/*    */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*    */ import com.nanosoft.amtk.service.UserService;
/*    */ import com.nanosoft.amtk.service.dto.UserDTO;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springdoc.api.annotations.ParameterObject;
/*    */ import org.springframework.data.domain.Page;
/*    */ import org.springframework.data.domain.Pageable;
/*    */ import org.springframework.http.HttpHeaders;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.util.MultiValueMap;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
/*    */ import tech.jhipster.web.util.PaginationUtil;
/*    */ 
/*    */ @RestController
/*    */ @RequestMapping({"/api"})
/*    */ public class PublicUserResource {
/* 23 */   private static final List<String> ALLOWED_ORDERED_PROPERTIES = Collections.unmodifiableList(
/* 24 */       Arrays.asList(new String[] { "id", "login", "firstName", "lastName", "email", "activated", "langKey" }));
/*    */ 
/*    */   
/* 27 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.PublicUserResource.class);
/*    */   
/*    */   private final UserService userService;
/*    */   
/*    */   public PublicUserResource(UserService userService) {
/* 32 */     this.userService = userService;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"/users"})
/*    */   public ResponseEntity<List<UserDTO>> getAllPublicUsers(@ParameterObject Pageable pageable) {
/* 43 */     this.log.debug("REST request to get all public User names");
/* 44 */     if (!onlyContainsAllowedProperties(pageable)) {
/* 45 */       return ResponseEntity.badRequest().build();
/*    */     }
/*    */     
/* 48 */     Page<UserDTO> page = this.userService.getAllPublicUsers(pageable);
/* 49 */     HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders((UriComponentsBuilder)ServletUriComponentsBuilder.fromCurrentRequest(), page);
/* 50 */     return new ResponseEntity(page.getContent(), (MultiValueMap)headers, HttpStatus.OK);
/*    */   }
/*    */   
/*    */   private boolean onlyContainsAllowedProperties(Pageable pageable) {
/* 54 */     Objects.requireNonNull(ALLOWED_ORDERED_PROPERTIES); return pageable.getSort().stream().map(Sort.Order::getProperty).allMatch(ALLOWED_ORDERED_PROPERTIES::contains);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"/authorities"})
/*    */   public List<String> getAuthorities() {
/* 63 */     return this.userService.getAuthorities();
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\PublicUserResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */