/*    */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest.vm;
/*    */ 
/*    */ import com.nanosoft.amtk.service.dto.AdminUserDTO;
/*    */ import javax.validation.constraints.Size;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ManagedUserVM
/*    */   extends AdminUserDTO
/*    */ {
/*    */   public static final int PASSWORD_MIN_LENGTH = 4;
/*    */   public static final int PASSWORD_MAX_LENGTH = 100;
/*    */   @Size(min = 4, max = 100)
/*    */   private String password;
/*    */   
/*    */   public String getPassword() {
/* 23 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 27 */     this.password = password;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 33 */     return "ManagedUserVM{" + super.toString() + "} ";
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\vm\ManagedUserVM.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */