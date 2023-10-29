/*    */ package BOOT-INF.classes.com.nanosoft.amtk.config;
/*    */ 
/*    */ import ch.qos.logback.classic.LoggerContext;
/*    */ import com.fasterxml.jackson.core.JsonProcessingException;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.beans.factory.annotation.Value;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import tech.jhipster.config.JHipsterProperties;
/*    */ import tech.jhipster.config.logging.LoggingUtils;
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
/*    */ @Configuration
/*    */ public class LoggingConfiguration
/*    */ {
/*    */   public LoggingConfiguration(@Value("${spring.application.name}") String appName, @Value("${server.port}") String serverPort, JHipsterProperties jHipsterProperties, ObjectMapper mapper) throws JsonProcessingException {
/* 27 */     LoggerContext context = (LoggerContext)LoggerFactory.getILoggerFactory();
/*    */     
/* 29 */     Map<String, String> map = new HashMap<>();
/* 30 */     map.put("app_name", appName);
/* 31 */     map.put("app_port", serverPort);
/* 32 */     String customFields = mapper.writeValueAsString(map);
/*    */     
/* 34 */     JHipsterProperties.Logging loggingProperties = jHipsterProperties.getLogging();
/* 35 */     JHipsterProperties.Logging.Logstash logstashProperties = loggingProperties.getLogstash();
/*    */     
/* 37 */     if (loggingProperties.isUseJsonFormat()) {
/* 38 */       LoggingUtils.addJsonConsoleAppender(context, customFields);
/*    */     }
/* 40 */     if (logstashProperties.isEnabled()) {
/* 41 */       LoggingUtils.addLogstashTcpSocketAppender(context, customFields, logstashProperties);
/*    */     }
/* 43 */     if (loggingProperties.isUseJsonFormat() || logstashProperties.isEnabled())
/* 44 */       LoggingUtils.addContextListener(context, customFields, loggingProperties); 
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\config\LoggingConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */