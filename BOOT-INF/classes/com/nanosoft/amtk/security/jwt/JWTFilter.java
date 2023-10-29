/*    */ package BOOT-INF.classes.com.nanosoft.amtk.security.jwt;
/*    */ 
/*    */ import com.nanosoft.amtk.security.jwt.TokenProvider;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.context.SecurityContextHolder;
/*    */ import org.springframework.util.StringUtils;
/*    */ import org.springframework.web.filter.GenericFilterBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JWTFilter
/*    */   extends GenericFilterBean
/*    */ {
/*    */   public static final String AUTHORIZATION_HEADER = "Authorization";
/*    */   private final TokenProvider tokenProvider;
/*    */   
/*    */   public JWTFilter(TokenProvider tokenProvider) {
/* 25 */     this.tokenProvider = tokenProvider;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
/* 31 */     HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
/* 32 */     String jwt = resolveToken(httpServletRequest);
/* 33 */     if (StringUtils.hasText(jwt) && this.tokenProvider.validateToken(jwt)) {
/* 34 */       Authentication authentication = this.tokenProvider.getAuthentication(jwt);
/* 35 */       SecurityContextHolder.getContext().setAuthentication(authentication);
/*    */     } 
/* 37 */     filterChain.doFilter(servletRequest, servletResponse);
/*    */   }
/*    */   
/*    */   private String resolveToken(HttpServletRequest request) {
/* 41 */     String bearerToken = request.getHeader("Authorization");
/* 42 */     if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
/* 43 */       return bearerToken.substring(7);
/*    */     }
/* 45 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\security\jwt\JWTFilter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */