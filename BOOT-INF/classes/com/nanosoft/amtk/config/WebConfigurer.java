/*    */ package BOOT-INF.classes.com.nanosoft.amtk.config;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.net.URLDecoder;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.nio.file.Paths;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.ServletException;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.boot.web.server.WebServerFactory;
/*    */ import org.springframework.boot.web.server.WebServerFactoryCustomizer;
/*    */ import org.springframework.boot.web.servlet.ServletContextInitializer;
/*    */ import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.core.env.Environment;
/*    */ import org.springframework.util.CollectionUtils;
/*    */ import org.springframework.web.cors.CorsConfiguration;
/*    */ import org.springframework.web.cors.CorsConfigurationSource;
/*    */ import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
/*    */ import org.springframework.web.filter.CorsFilter;
/*    */ import tech.jhipster.config.JHipsterProperties;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ public class WebConfigurer
/*    */   implements ServletContextInitializer, WebServerFactoryCustomizer<WebServerFactory>
/*    */ {
/* 31 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.config.WebConfigurer.class);
/*    */   
/*    */   private final Environment env;
/*    */   
/*    */   private final JHipsterProperties jHipsterProperties;
/*    */   
/*    */   public WebConfigurer(Environment env, JHipsterProperties jHipsterProperties) {
/* 38 */     this.env = env;
/* 39 */     this.jHipsterProperties = jHipsterProperties;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onStartup(ServletContext servletContext) throws ServletException {
/* 44 */     if ((this.env.getActiveProfiles()).length != 0) {
/* 45 */       this.log.info("Web application configuration, using profiles: {}", (Object[])this.env.getActiveProfiles());
/*    */     }
/*    */     
/* 48 */     this.log.info("Web application fully configured");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void customize(WebServerFactory server) {
/* 57 */     setLocationForStaticAssets(server);
/*    */   }
/*    */   
/*    */   private void setLocationForStaticAssets(WebServerFactory server) {
/* 61 */     if (server instanceof ConfigurableServletWebServerFactory) {
/* 62 */       ConfigurableServletWebServerFactory servletWebServer = (ConfigurableServletWebServerFactory)server;
/*    */       
/* 64 */       String prefixPath = resolvePathPrefix();
/* 65 */       File root = new File(prefixPath + "target/classes/static/");
/* 66 */       if (root.exists() && root.isDirectory()) {
/* 67 */         servletWebServer.setDocumentRoot(root);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private String resolvePathPrefix() {
/* 76 */     String fullExecutablePath = URLDecoder.decode(getClass().getResource("").getPath(), StandardCharsets.UTF_8);
/* 77 */     String rootPath = Paths.get(".", new String[0]).toUri().normalize().getPath();
/* 78 */     String extractedPath = fullExecutablePath.replace(rootPath, "");
/* 79 */     int extractionEndIndex = extractedPath.indexOf("target/");
/* 80 */     if (extractionEndIndex <= 0) {
/* 81 */       return "";
/*    */     }
/* 83 */     return extractedPath.substring(0, extractionEndIndex);
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public CorsFilter corsFilter() {
/* 88 */     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
/* 89 */     CorsConfiguration config = this.jHipsterProperties.getCors();
/* 90 */     if (!CollectionUtils.isEmpty(config.getAllowedOrigins()) || !CollectionUtils.isEmpty(config.getAllowedOriginPatterns())) {
/* 91 */       this.log.debug("Registering CORS filter");
/* 92 */       source.registerCorsConfiguration("/api/**", config);
/* 93 */       source.registerCorsConfiguration("/management/**", config);
/* 94 */       source.registerCorsConfiguration("/v3/api-docs", config);
/* 95 */       source.registerCorsConfiguration("/swagger-ui/**", config);
/*    */     } 
/* 97 */     return new CorsFilter((CorsConfigurationSource)source);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\config\WebConfigurer.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */