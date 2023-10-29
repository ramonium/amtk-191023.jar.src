/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.User;
/*     */ import com.nanosoft.amtk.repository.UserRepository;
/*     */ import com.nanosoft.amtk.security.SecurityUtils;
/*     */ import com.nanosoft.amtk.service.MailService;
/*     */ import com.nanosoft.amtk.service.UserService;
/*     */ import com.nanosoft.amtk.service.dto.AdminUserDTO;
/*     */ import com.nanosoft.amtk.service.dto.PasswordChangeDTO;
/*     */ import com.nanosoft.amtk.web.rest.errors.EmailAlreadyUsedException;
/*     */ import com.nanosoft.amtk.web.rest.errors.InvalidPasswordException;
/*     */ import com.nanosoft.amtk.web.rest.vm.KeyAndPasswordVM;
/*     */ import com.nanosoft.amtk.web.rest.vm.ManagedUserVM;
/*     */ import java.util.Optional;
/*     */ import java.util.function.Function;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.validation.Valid;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.http.HttpStatus;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseStatus;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ @RequestMapping({"/api"})
/*     */ public class AccountResource
/*     */ {
/*  36 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.AccountResource.class);
/*     */   
/*     */   private final UserRepository userRepository;
/*     */   
/*     */   private final UserService userService;
/*     */   
/*     */   private final MailService mailService;
/*     */   
/*     */   public AccountResource(UserRepository userRepository, UserService userService, MailService mailService) {
/*  45 */     this.userRepository = userRepository;
/*  46 */     this.userService = userService;
/*  47 */     this.mailService = mailService;
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
/*     */   @PostMapping({"/register"})
/*     */   @ResponseStatus(HttpStatus.CREATED)
/*     */   public void registerAccount(@Valid @RequestBody ManagedUserVM managedUserVM) {
/*  61 */     if (isPasswordLengthInvalid(managedUserVM.getPassword())) {
/*  62 */       throw new InvalidPasswordException();
/*     */     }
/*  64 */     User user = this.userService.registerUser((AdminUserDTO)managedUserVM, managedUserVM.getPassword());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/activate"})
/*     */   public void activateAccount(@RequestParam("key") String key) {
/*  76 */     Optional<User> user = this.userService.activateRegistration(key);
/*  77 */     if (!user.isPresent()) {
/*  78 */       throw new AccountResourceException("No user was found for this activation key");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/authenticate"})
/*     */   public String isAuthenticated(HttpServletRequest request) {
/*  90 */     this.log.debug("REST request to check if the current user is authenticated");
/*  91 */     return request.getRemoteUser();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/account"})
/*     */   public AdminUserDTO getAccount() {
/* 102 */     return (AdminUserDTO)this.userService
/* 103 */       .getUserWithAuthorities()
/* 104 */       .map(AdminUserDTO::new)
/* 105 */       .orElseThrow(() -> new AccountResourceException("User could not be found"));
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
/*     */   @PostMapping({"/account"})
/*     */   public void saveAccount(@Valid @RequestBody AdminUserDTO userDTO) {
/* 119 */     String userLogin = (String)SecurityUtils.getCurrentUserLogin().orElseThrow(() -> new AccountResourceException("Current user login not found"));
/* 120 */     Optional<User> existingUser = this.userRepository.findOneByEmailIgnoreCase(userDTO.getEmail());
/* 121 */     if (existingUser.isPresent() && !((User)existingUser.get()).getLogin().equalsIgnoreCase(userLogin)) {
/* 122 */       throw new EmailAlreadyUsedException();
/*     */     }
/* 124 */     Optional<User> user = this.userRepository.findOneByLogin(userLogin);
/* 125 */     if (!user.isPresent()) {
/* 126 */       throw new AccountResourceException("User could not be found");
/*     */     }
/* 128 */     this.userService.updateUser(userDTO
/* 129 */         .getFirstName(), userDTO
/* 130 */         .getLastName(), userDTO
/* 131 */         .getEmail(), userDTO
/* 132 */         .getLangKey(), userDTO
/* 133 */         .getImageUrl());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping(path = {"/account/change-password"})
/*     */   public void changePassword(@RequestBody PasswordChangeDTO passwordChangeDto) {
/* 145 */     if (isPasswordLengthInvalid(passwordChangeDto.getNewPassword())) {
/* 146 */       throw new InvalidPasswordException();
/*     */     }
/* 148 */     this.userService.changePassword(passwordChangeDto.getCurrentPassword(), passwordChangeDto.getNewPassword());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping(path = {"/account/reset-password/init"})
/*     */   public void requestPasswordReset(@RequestBody String mail) {
/* 158 */     Optional<User> user = this.userService.requestPasswordReset(mail);
/* 159 */     if (user.isPresent()) {
/* 160 */       this.mailService.sendPasswordResetMail(user.get());
/*     */     }
/*     */     else {
/*     */       
/* 164 */       this.log.warn("Password reset requested for non existing mail");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping(path = {"/account/reset-password/finish"})
/*     */   public void finishPasswordReset(@RequestBody KeyAndPasswordVM keyAndPassword) {
/* 177 */     if (isPasswordLengthInvalid(keyAndPassword.getNewPassword())) {
/* 178 */       throw new InvalidPasswordException();
/*     */     }
/* 180 */     Optional<User> user = this.userService.completePasswordReset(keyAndPassword.getNewPassword(), keyAndPassword.getKey());
/*     */     
/* 182 */     if (!user.isPresent()) {
/* 183 */       throw new AccountResourceException("No user was found for this reset key");
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean isPasswordLengthInvalid(String password) {
/* 188 */     return (
/* 189 */       StringUtils.isEmpty(password) || password
/* 190 */       .length() < 4 || password
/* 191 */       .length() > 100);
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\AccountResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */