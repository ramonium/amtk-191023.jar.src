/*    */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PasswordChangeDTO
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String currentPassword;
/*    */   private String newPassword;
/*    */   
/*    */   public PasswordChangeDTO() {}
/*    */   
/*    */   public PasswordChangeDTO(String currentPassword, String newPassword) {
/* 20 */     this.currentPassword = currentPassword;
/* 21 */     this.newPassword = newPassword;
/*    */   }
/*    */   
/*    */   public String getCurrentPassword() {
/* 25 */     return this.currentPassword;
/*    */   }
/*    */   
/*    */   public void setCurrentPassword(String currentPassword) {
/* 29 */     this.currentPassword = currentPassword;
/*    */   }
/*    */   
/*    */   public String getNewPassword() {
/* 33 */     return this.newPassword;
/*    */   }
/*    */   
/*    */   public void setNewPassword(String newPassword) {
/* 37 */     this.newPassword = newPassword;
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\PasswordChangeDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */