/*    */ package BOOT-INF.classes.com.nanosoft.amtk.security.jwt;
/*    */ import com.nanosoft.amtk.security.jwt.JWTFilter;
/*    */ import com.nanosoft.amtk.security.jwt.TokenProvider;
/*    */ import javax.servlet.Filter;
/*    */ import org.springframework.security.config.annotation.SecurityBuilder;
/*    */ import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
/*    */ import org.springframework.security.config.annotation.web.builders.HttpSecurity;
/*    */ import org.springframework.security.web.DefaultSecurityFilterChain;
/*    */ import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
/*    */ 
/*    */ public class JWTConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
/*    */   public JWTConfigurer(TokenProvider tokenProvider) {
/* 13 */     this.tokenProvider = tokenProvider;
/*    */   }
/*    */   private final TokenProvider tokenProvider;
/*    */   
/*    */   public void configure(HttpSecurity http) {
/* 18 */     JWTFilter customFilter = new JWTFilter(this.tokenProvider);
/* 19 */     http.addFilterBefore((Filter)customFilter, UsernamePasswordAuthenticationFilter.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\security\jwt\JWTConfigurer.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */