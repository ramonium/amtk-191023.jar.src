/*    */ package BOOT-INF.classes.com.nanosoft.amtk.security;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Optional;
/*    */ import java.util.stream.Stream;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.GrantedAuthority;
/*    */ import org.springframework.security.core.context.SecurityContext;
/*    */ import org.springframework.security.core.context.SecurityContextHolder;
/*    */ import org.springframework.security.core.userdetails.UserDetails;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SecurityUtils
/*    */ {
/*    */   public static Optional<String> getCurrentUserLogin() {
/* 25 */     SecurityContext securityContext = SecurityContextHolder.getContext();
/* 26 */     return Optional.ofNullable(extractPrincipal(securityContext.getAuthentication()));
/*    */   }
/*    */   
/*    */   private static String extractPrincipal(Authentication authentication) {
/* 30 */     if (authentication == null)
/* 31 */       return null; 
/* 32 */     if (authentication.getPrincipal() instanceof UserDetails) {
/* 33 */       UserDetails springSecurityUser = (UserDetails)authentication.getPrincipal();
/* 34 */       return springSecurityUser.getUsername();
/* 35 */     }  if (authentication.getPrincipal() instanceof String) {
/* 36 */       return (String)authentication.getPrincipal();
/*    */     }
/* 38 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Optional<String> getCurrentUserJWT() {
/* 47 */     SecurityContext securityContext = SecurityContextHolder.getContext();
/* 48 */     return 
/* 49 */       Optional.<Authentication>ofNullable(securityContext.getAuthentication())
/* 50 */       .filter(authentication -> authentication.getCredentials() instanceof String)
/* 51 */       .map(authentication -> (String)authentication.getCredentials());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isAuthenticated() {
/* 60 */     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
/* 61 */     return (authentication != null && getAuthorities(authentication).noneMatch("ROLE_ANONYMOUS"::equals));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean hasCurrentUserAnyOfAuthorities(String... authorities) {
/* 71 */     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
/* 72 */     return (authentication != null && 
/* 73 */       getAuthorities(authentication).anyMatch(authority -> Arrays.<String>asList(authorities).contains(authority)));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean hasCurrentUserNoneOfAuthorities(String... authorities) {
/* 84 */     return !hasCurrentUserAnyOfAuthorities(authorities);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean hasCurrentUserThisAuthority(String authority) {
/* 94 */     return hasCurrentUserAnyOfAuthorities(new String[] { authority });
/*    */   }
/*    */   
/*    */   private static Stream<String> getAuthorities(Authentication authentication) {
/* 98 */     return authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\security\SecurityUtils.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */