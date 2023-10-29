/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.User;
/*     */ import com.nanosoft.amtk.repository.UserRepository;
/*     */ import com.nanosoft.amtk.service.MailService;
/*     */ import com.nanosoft.amtk.service.UserService;
/*     */ import com.nanosoft.amtk.service.dto.AdminUserDTO;
/*     */ import com.nanosoft.amtk.web.rest.errors.BadRequestAlertException;
/*     */ import com.nanosoft.amtk.web.rest.errors.EmailAlreadyUsedException;
/*     */ import com.nanosoft.amtk.web.rest.errors.LoginAlreadyUsedException;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.function.Function;
/*     */ import javax.validation.Valid;
/*     */ import javax.validation.constraints.Pattern;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springdoc.api.annotations.ParameterObject;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.Pageable;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.http.HttpHeaders;
/*     */ import org.springframework.http.HttpStatus;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.security.access.prepost.PreAuthorize;
/*     */ import org.springframework.util.MultiValueMap;
/*     */ import org.springframework.web.bind.annotation.DeleteMapping;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
/*     */ import org.springframework.web.util.UriComponentsBuilder;
/*     */ import tech.jhipster.web.util.HeaderUtil;
/*     */ import tech.jhipster.web.util.PaginationUtil;
/*     */ import tech.jhipster.web.util.ResponseUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ @RequestMapping({"/api/admin"})
/*     */ public class UserResource
/*     */ {
/*  63 */   private static final List<String> ALLOWED_ORDERED_PROPERTIES = Collections.unmodifiableList(
/*  64 */       Arrays.asList(new String[] { 
/*     */           "id", "login", "firstName", "lastName", "email", "activated", "langKey", "createdBy", "createdDate", "lastModifiedBy", 
/*     */           "lastModifiedDate" }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  79 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.UserResource.class);
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */   
/*     */   private final UserService userService;
/*     */   
/*     */   private final UserRepository userRepository;
/*     */   
/*     */   private final MailService mailService;
/*     */   
/*     */   public UserResource(UserService userService, UserRepository userRepository, MailService mailService) {
/*  91 */     this.userService = userService;
/*  92 */     this.userRepository = userRepository;
/*  93 */     this.mailService = mailService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/users"})
/*     */   @PreAuthorize("hasAuthority(\"ROLE_ADMIN\")")
/*     */   public ResponseEntity<User> createUser(@Valid @RequestBody AdminUserDTO userDTO) throws URISyntaxException {
/* 111 */     this.log.debug("REST request to save User : {}", userDTO);
/*     */     
/* 113 */     if (userDTO.getId() != null) {
/* 114 */       throw new BadRequestAlertException("A new user cannot already have an ID", "userManagement", "idexists");
/*     */     }
/* 116 */     if (this.userRepository.findOneByLogin(userDTO.getLogin().toLowerCase()).isPresent())
/* 117 */       throw new LoginAlreadyUsedException(); 
/* 118 */     if (this.userRepository.findOneByEmailIgnoreCase(userDTO.getEmail()).isPresent()) {
/* 119 */       throw new EmailAlreadyUsedException();
/*     */     }
/* 121 */     User newUser = this.userService.createUser(userDTO);
/* 122 */     this.mailService.sendCreationEmail(newUser);
/* 123 */     return (
/* 124 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/admin/users/" + newUser.getLogin()))
/* 125 */       .headers(HeaderUtil.createAlert(this.applicationName, "userManagement.created", newUser.getLogin())))
/* 126 */       .body(newUser);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PutMapping({"/users"})
/*     */   @PreAuthorize("hasAuthority(\"ROLE_ADMIN\")")
/*     */   public ResponseEntity<AdminUserDTO> updateUser(@Valid @RequestBody AdminUserDTO userDTO) {
/* 141 */     this.log.debug("REST request to update User : {}", userDTO);
/* 142 */     Optional<User> existingUser = this.userRepository.findOneByEmailIgnoreCase(userDTO.getEmail());
/* 143 */     if (existingUser.isPresent() && !((User)existingUser.get()).getId().equals(userDTO.getId())) {
/* 144 */       throw new EmailAlreadyUsedException();
/*     */     }
/* 146 */     existingUser = this.userRepository.findOneByLogin(userDTO.getLogin().toLowerCase());
/* 147 */     if (existingUser.isPresent() && !((User)existingUser.get()).getId().equals(userDTO.getId())) {
/* 148 */       throw new LoginAlreadyUsedException();
/*     */     }
/* 150 */     Optional<AdminUserDTO> updatedUser = this.userService.updateUser(userDTO);
/*     */     
/* 152 */     return ResponseUtil.wrapOrNotFound(updatedUser, 
/*     */         
/* 154 */         HeaderUtil.createAlert(this.applicationName, "userManagement.updated", userDTO.getLogin()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/users"})
/*     */   @PreAuthorize("hasAuthority(\"ROLE_ADMIN\")")
/*     */   public ResponseEntity<List<AdminUserDTO>> getAllUsers(@ParameterObject Pageable pageable) {
/* 167 */     this.log.debug("REST request to get all User for an admin");
/* 168 */     if (!onlyContainsAllowedProperties(pageable)) {
/* 169 */       return ResponseEntity.badRequest().build();
/*     */     }
/*     */     
/* 172 */     Page<AdminUserDTO> page = this.userService.getAllManagedUsers(pageable);
/* 173 */     HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders((UriComponentsBuilder)ServletUriComponentsBuilder.fromCurrentRequest(), page);
/* 174 */     return new ResponseEntity(page.getContent(), (MultiValueMap)headers, HttpStatus.OK);
/*     */   }
/*     */   
/*     */   private boolean onlyContainsAllowedProperties(Pageable pageable) {
/* 178 */     Objects.requireNonNull(ALLOWED_ORDERED_PROPERTIES); return pageable.getSort().stream().map(Sort.Order::getProperty).allMatch(ALLOWED_ORDERED_PROPERTIES::contains);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/users/{login}"})
/*     */   @PreAuthorize("hasAuthority(\"ROLE_ADMIN\")")
/*     */   public ResponseEntity<AdminUserDTO> getUser(@PathVariable @Pattern(regexp = "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$") String login) {
/* 190 */     this.log.debug("REST request to get User : {}", login);
/* 191 */     return ResponseUtil.wrapOrNotFound(this.userService.getUserWithAuthoritiesByLogin(login).map(AdminUserDTO::new));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/users/{login}"})
/*     */   @PreAuthorize("hasAuthority(\"ROLE_ADMIN\")")
/*     */   public ResponseEntity<Void> deleteUser(@PathVariable @Pattern(regexp = "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$") String login) {
/* 203 */     this.log.debug("REST request to delete User: {}", login);
/* 204 */     this.userService.deleteUser(login);
/* 205 */     return ResponseEntity.noContent().headers(HeaderUtil.createAlert(this.applicationName, "userManagement.deleted", login)).build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\UserResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */