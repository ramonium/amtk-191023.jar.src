/*    */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest.errors;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FieldErrorVM
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final String objectName;
/*    */   private final String field;
/*    */   private final String message;
/*    */   
/*    */   public FieldErrorVM(String dto, String field, String message) {
/* 16 */     this.objectName = dto;
/* 17 */     this.field = field;
/* 18 */     this.message = message;
/*    */   }
/*    */   
/*    */   public String getObjectName() {
/* 22 */     return this.objectName;
/*    */   }
/*    */   
/*    */   public String getField() {
/* 26 */     return this.field;
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 30 */     return this.message;
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\errors\FieldErrorVM.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */