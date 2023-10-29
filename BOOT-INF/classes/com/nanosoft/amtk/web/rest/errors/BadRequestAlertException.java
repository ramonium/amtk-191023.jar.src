/*    */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest.errors;
/*    */ 
/*    */ import com.nanosoft.amtk.web.rest.errors.ErrorConstants;
/*    */ import java.net.URI;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.zalando.problem.AbstractThrowableProblem;
/*    */ import org.zalando.problem.Status;
/*    */ import org.zalando.problem.StatusType;
/*    */ 
/*    */ public class BadRequestAlertException
/*    */   extends AbstractThrowableProblem
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final String entityName;
/*    */   private final String errorKey;
/*    */   
/*    */   public BadRequestAlertException(String defaultMessage, String entityName, String errorKey) {
/* 19 */     this(ErrorConstants.DEFAULT_TYPE, defaultMessage, entityName, errorKey);
/*    */   }
/*    */   
/*    */   public BadRequestAlertException(URI type, String defaultMessage, String entityName, String errorKey) {
/* 23 */     super(type, defaultMessage, (StatusType)Status.BAD_REQUEST, null, null, null, getAlertParameters(entityName, errorKey));
/* 24 */     this.entityName = entityName;
/* 25 */     this.errorKey = errorKey;
/*    */   }
/*    */   
/*    */   public String getEntityName() {
/* 29 */     return this.entityName;
/*    */   }
/*    */   
/*    */   public String getErrorKey() {
/* 33 */     return this.errorKey;
/*    */   }
/*    */   
/*    */   private static Map<String, Object> getAlertParameters(String entityName, String errorKey) {
/* 37 */     Map<String, Object> parameters = new HashMap<>();
/* 38 */     parameters.put("message", "error." + errorKey);
/* 39 */     parameters.put("params", entityName);
/* 40 */     return parameters;
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\errors\BadRequestAlertException.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */