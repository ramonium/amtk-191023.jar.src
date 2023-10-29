/*    */ package BOOT-INF.classes.com.nanosoft.amtk.security;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.Authority;
/*    */ import com.nanosoft.amtk.domain.User;
/*    */ import com.nanosoft.amtk.repository.UserRepository;
/*    */ import com.nanosoft.amtk.security.UserNotActivatedException;
/*    */ import java.util.List;
/*    */ import java.util.Locale;
/*    */ import java.util.function.Function;
/*    */ import java.util.stream.Collectors;
/*    */ import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.security.core.GrantedAuthority;
/*    */ import org.springframework.security.core.userdetails.User;
/*    */ import org.springframework.security.core.userdetails.UserDetails;
/*    */ import org.springframework.security.core.userdetails.UserDetailsService;
/*    */ import org.springframework.security.core.userdetails.UsernameNotFoundException;
/*    */ import org.springframework.stereotype.Component;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Component("userDetailsService")
/*    */ public class DomainUserDetailsService
/*    */   implements UserDetailsService {
/* 25 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.security.DomainUserDetailsService.class);
/*    */   
/*    */   private final UserRepository userRepository;
/*    */   
/*    */   public DomainUserDetailsService(UserRepository userRepository) {
/* 30 */     this.userRepository = userRepository;
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public UserDetails loadUserByUsername(String login) {
/* 36 */     this.log.debug("Authenticating {}", login);
/*    */     
/* 38 */     if (this.userRepository.count() > 250L) {
/* 39 */       throw new UsernameNotFoundException("Registered user is higher than 250");
/*    */     }
/*    */     
/* 42 */     if ((new EmailValidator()).isValid(login, null)) {
/* 43 */       return (UserDetails)this.userRepository
/* 44 */         .findOneWithAuthoritiesByEmailIgnoreCase(login)
/* 45 */         .map(user -> createSpringSecurityUser(login, user))
/* 46 */         .orElseThrow(() -> new UsernameNotFoundException("User with email " + login + " was not found in the database"));
/*    */     }
/*    */     
/* 49 */     String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
/* 50 */     return (UserDetails)this.userRepository
/* 51 */       .findOneWithAuthoritiesByLogin(lowercaseLogin)
/* 52 */       .map(user -> createSpringSecurityUser(lowercaseLogin, user))
/* 53 */       .orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));
/*    */   }
/*    */   
/*    */   private User createSpringSecurityUser(String lowercaseLogin, User user) {
/* 57 */     if (!user.isActivated()) {
/* 58 */       throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 65 */     List<GrantedAuthority> grantedAuthorities = (List<GrantedAuthority>)user.getAuthorities().stream().map(Authority::getName).map(org.springframework.security.core.authority.SimpleGrantedAuthority::new).collect(Collectors.toList());
/* 66 */     return new User(user.getLogin(), user.getPassword(), grantedAuthorities);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\security\DomainUserDetailsService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */