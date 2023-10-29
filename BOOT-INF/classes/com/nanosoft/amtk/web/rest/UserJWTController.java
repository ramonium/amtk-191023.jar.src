/*    */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*    */ 
/*    */ import com.nanosoft.amtk.security.jwt.TokenProvider;
/*    */ import com.nanosoft.amtk.web.rest.vm.LoginVM;
/*    */ import javax.validation.Valid;
/*    */ import org.springframework.http.HttpHeaders;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.security.authentication.AuthenticationManager;
/*    */ import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
/*    */ import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.context.SecurityContextHolder;
/*    */ import org.springframework.util.MultiValueMap;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ @RequestMapping({"/api"})
/*    */ public class UserJWTController
/*    */ {
/*    */   private final TokenProvider tokenProvider;
/*    */   private final AuthenticationManagerBuilder authenticationManagerBuilder;
/*    */   
/*    */   public UserJWTController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
/* 29 */     this.tokenProvider = tokenProvider;
/* 30 */     this.authenticationManagerBuilder = authenticationManagerBuilder;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"/authenticate"})
/*    */   public ResponseEntity<JWTToken> authorize(@Valid @RequestBody LoginVM loginVM) {
/* 37 */     UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginVM.getUsername(), loginVM.getPassword());
/*    */ 
/*    */     
/* 40 */     Authentication authentication = ((AuthenticationManager)this.authenticationManagerBuilder.getObject()).authenticate((Authentication)authenticationToken);
/* 41 */     SecurityContextHolder.getContext().setAuthentication(authentication);
/* 42 */     String jwt = this.tokenProvider.createToken(authentication, loginVM.isRememberMe());
/* 43 */     HttpHeaders httpHeaders = new HttpHeaders();
/* 44 */     httpHeaders.add("Authorization", "Bearer " + jwt);
/* 45 */     return new ResponseEntity(new JWTToken(jwt), (MultiValueMap)httpHeaders, HttpStatus.OK);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\UserJWTController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */