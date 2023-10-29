/*    */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*    */ 
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ public class ClientForwardController
/*    */ {
/*    */   @GetMapping({"/**/{path:[^\\.]*}"})
/*    */   public String forward() {
/* 15 */     return "forward:/";
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\ClientForwardController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */