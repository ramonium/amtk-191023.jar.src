/*    */ package BOOT-INF.classes.com.nanosoft.amtk.config;
/*    */ import com.nanosoft.amtk.aop.logging.LoggingAspect;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.context.annotation.EnableAspectJAutoProxy;
/*    */ import org.springframework.context.annotation.Profile;
/*    */ import org.springframework.core.env.Environment;
/*    */ 
/*    */ @Configuration
/*    */ @EnableAspectJAutoProxy
/*    */ public class LoggingAspectConfiguration {
/*    */   @Bean
/*    */   @Profile({"dev"})
/*    */   public LoggingAspect loggingAspect(Environment env) {
/* 15 */     return new LoggingAspect(env);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\config\LoggingAspectConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */