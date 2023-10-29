/*   */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest.errors;
/*   */ 
/*   */ import com.nanosoft.amtk.web.rest.errors.BadRequestAlertException;
/*   */ import com.nanosoft.amtk.web.rest.errors.ErrorConstants;
/*   */ 
/*   */ public class LoginAlreadyUsedException
/*   */   extends BadRequestAlertException {
/*   */   public LoginAlreadyUsedException() {
/* 9 */     super(ErrorConstants.LOGIN_ALREADY_USED_TYPE, "Login name already used!", "userManagement", "userexists");
/*   */   }
/*   */   
/*   */   private static final long serialVersionUID = 1L;
/*   */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\errors\LoginAlreadyUsedException.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */