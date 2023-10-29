/*   */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*   */ 
/*   */ public class EmailAlreadyUsedException
/*   */   extends RuntimeException {
/*   */   private static final long serialVersionUID = 1L;
/*   */   
/*   */   public EmailAlreadyUsedException() {
/* 8 */     super("Email is already in use!");
/*   */   }
/*   */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\EmailAlreadyUsedException.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */