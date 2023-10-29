/*    */ package BOOT-INF.classes.com.nanosoft.amtk.config;
/*    */ 
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.format.FormatterRegistry;
/*    */ import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
/*    */ import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ public class DateTimeFormatConfiguration
/*    */   implements WebMvcConfigurer
/*    */ {
/*    */   public void addFormatters(FormatterRegistry registry) {
/* 16 */     DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
/* 17 */     registrar.setUseIsoFormat(true);
/* 18 */     registrar.registerFormatters(registry);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\config\DateTimeFormatConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */