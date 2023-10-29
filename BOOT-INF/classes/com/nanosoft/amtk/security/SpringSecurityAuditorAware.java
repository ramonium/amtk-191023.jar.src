/*    */ package BOOT-INF.classes.com.nanosoft.amtk.security;
/*    */ 
/*    */ import com.nanosoft.amtk.security.SecurityUtils;
/*    */ import java.util.Optional;
/*    */ import org.springframework.data.domain.AuditorAware;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Component
/*    */ public class SpringSecurityAuditorAware
/*    */   implements AuditorAware<String>
/*    */ {
/*    */   public Optional<String> getCurrentAuditor() {
/* 16 */     return Optional.of(SecurityUtils.getCurrentUserLogin().orElse("system"));
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\security\SpringSecurityAuditorAware.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */