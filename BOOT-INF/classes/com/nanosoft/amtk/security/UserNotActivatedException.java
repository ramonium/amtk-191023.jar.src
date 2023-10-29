/*    */ package BOOT-INF.classes.com.nanosoft.amtk.security;
/*    */ 
/*    */ import org.springframework.security.core.AuthenticationException;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserNotActivatedException
/*    */   extends AuthenticationException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public UserNotActivatedException(String message) {
/* 13 */     super(message);
/*    */   }
/*    */   
/*    */   public UserNotActivatedException(String message, Throwable t) {
/* 17 */     super(message, t);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\security\UserNotActivatedException.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */