/*    */ package BOOT-INF.classes.com.nanosoft.amtk;
/*    */ 
/*    */ import com.nanosoft.amtk.AmtkApp;
/*    */ import org.springframework.boot.builder.SpringApplicationBuilder;
/*    */ import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/*    */ import tech.jhipster.config.DefaultProfileUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ApplicationWebXml
/*    */   extends SpringBootServletInitializer
/*    */ {
/*    */   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
/* 16 */     DefaultProfileUtil.addDefaultProfile(application.application());
/* 17 */     return application.sources(new Class[] { AmtkApp.class });
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\ApplicationWebXml.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */