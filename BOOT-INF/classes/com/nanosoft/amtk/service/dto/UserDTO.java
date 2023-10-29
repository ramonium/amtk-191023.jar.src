/*    */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.User;
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserDTO
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private Long id;
/*    */   private String login;
/*    */   private String firstName;
/*    */   private String lastName;
/*    */   private String email;
/*    */   
/*    */   public UserDTO() {}
/*    */   
/*    */   public UserDTO(User user) {
/* 28 */     this.id = user.getId();
/*    */     
/* 30 */     this.login = user.getLogin();
/* 31 */     this.firstName = user.getFirstName();
/* 32 */     this.lastName = user.getLastName();
/* 33 */     this.email = user.getEmail();
/*    */   }
/*    */   
/*    */   public Long getId() {
/* 37 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 41 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getLogin() {
/* 45 */     return this.login;
/*    */   }
/*    */   
/*    */   public void setLogin(String login) {
/* 49 */     this.login = login;
/*    */   }
/*    */   
/*    */   public String getFirstName() {
/* 53 */     return this.firstName;
/*    */   }
/*    */   
/*    */   public void setFirstName(String firstName) {
/* 57 */     this.firstName = firstName;
/*    */   }
/*    */   
/*    */   public String getLastName() {
/* 61 */     return this.lastName;
/*    */   }
/*    */   
/*    */   public void setLastName(String lastName) {
/* 65 */     this.lastName = lastName;
/*    */   }
/*    */   
/*    */   public String getEmail() {
/* 69 */     return this.email;
/*    */   }
/*    */   
/*    */   public void setEmail(String email) {
/* 73 */     this.email = email;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 79 */     return "UserDTO{id='" + this.id + "', login='" + this.login + "', firstName='" + this.firstName + "', lastName='" + this.lastName + "', email='" + this.email + "'}";
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\UserDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */