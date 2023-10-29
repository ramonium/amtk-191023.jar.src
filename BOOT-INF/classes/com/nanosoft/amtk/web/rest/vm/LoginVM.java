/*    */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest.vm;
/*    */ 
/*    */ import javax.validation.constraints.NotNull;
/*    */ import javax.validation.constraints.Size;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoginVM
/*    */ {
/*    */   @NotNull
/*    */   @Size(min = 1, max = 50)
/*    */   private String username;
/*    */   @NotNull
/*    */   @Size(min = 4, max = 100)
/*    */   private String password;
/*    */   private boolean rememberMe;
/*    */   
/*    */   public String getUsername() {
/* 22 */     return this.username;
/*    */   }
/*    */   
/*    */   public void setUsername(String username) {
/* 26 */     this.username = username;
/*    */   }
/*    */   
/*    */   public String getPassword() {
/* 30 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 34 */     this.password = password;
/*    */   }
/*    */   
/*    */   public boolean isRememberMe() {
/* 38 */     return this.rememberMe;
/*    */   }
/*    */   
/*    */   public void setRememberMe(boolean rememberMe) {
/* 42 */     this.rememberMe = rememberMe;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 48 */     return "LoginVM{username='" + this.username + "', rememberMe=" + this.rememberMe + "}";
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\vm\LoginVM.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */