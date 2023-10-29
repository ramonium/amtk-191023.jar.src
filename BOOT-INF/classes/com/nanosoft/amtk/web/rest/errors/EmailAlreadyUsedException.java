/*   */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest.errors;
/*   */ 
/*   */ import com.nanosoft.amtk.web.rest.errors.BadRequestAlertException;
/*   */ import com.nanosoft.amtk.web.rest.errors.ErrorConstants;
/*   */ 
/*   */ public class EmailAlreadyUsedException
/*   */   extends BadRequestAlertException {
/*   */   public EmailAlreadyUsedException() {
/* 9 */     super(ErrorConstants.EMAIL_ALREADY_USED_TYPE, "Email is already in use!", "userManagement", "emailexists");
/*   */   }
/*   */   
/*   */   private static final long serialVersionUID = 1L;
/*   */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\errors\EmailAlreadyUsedException.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */