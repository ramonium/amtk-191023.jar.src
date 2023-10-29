/*    */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest.errors;
/*    */ 
/*    */ import com.nanosoft.amtk.web.rest.errors.ErrorConstants;
/*    */ import org.zalando.problem.AbstractThrowableProblem;
/*    */ import org.zalando.problem.Status;
/*    */ import org.zalando.problem.StatusType;
/*    */ 
/*    */ public class InvalidPasswordException extends AbstractThrowableProblem {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public InvalidPasswordException() {
/* 12 */     super(ErrorConstants.INVALID_PASSWORD_TYPE, "Incorrect password", (StatusType)Status.BAD_REQUEST);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\errors\InvalidPasswordException.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */