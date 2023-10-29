/*    */ package BOOT-INF.classes.com.nanosoft.amtk.config;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.context.annotation.Profile;
/*    */ import org.springframework.http.CacheControl;
/*    */ import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
/*    */ import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
/*    */ import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*    */ import tech.jhipster.config.JHipsterProperties;
/*    */ 
/*    */ @Configuration
/*    */ @Profile({"prod"})
/*    */ public class StaticResourcesWebConfiguration
/*    */   implements WebMvcConfigurer
/*    */ {
/* 17 */   protected static final String[] RESOURCE_LOCATIONS = new String[] { "classpath:/static/", "classpath:/static/content/", "classpath:/static/assets/", "classpath:/static/assets/assets/", "classpath:/static/assets/assets/fonts/", "classpath:/static/assets/assets/packages/", "classpath:/static/assets/assets/images/", "classpath:/static/assets/assets/env/", "classpath:/static/assets/assets/fonts/", "classpath:/static/assets/assets/icons/", "classpath:/static/i18n/" };
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
/*    */ 
/*    */   
/* 30 */   protected static final String[] RESOURCE_PATHS = new String[] { "/*.js", "/*.css", "/*.svg", "/*.png", "*.ico", "/content/**", "/i18n/*" };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final JHipsterProperties jhipsterProperties;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public StaticResourcesWebConfiguration(JHipsterProperties jHipsterProperties) {
/* 43 */     this.jhipsterProperties = jHipsterProperties;
/*    */   }
/*    */ 
/*    */   
/*    */   public void addResourceHandlers(ResourceHandlerRegistry registry) {
/* 48 */     ResourceHandlerRegistration resourceHandlerRegistration = appendResourceHandler(registry);
/* 49 */     initializeResourceHandler(resourceHandlerRegistration);
/*    */   }
/*    */   
/*    */   protected ResourceHandlerRegistration appendResourceHandler(ResourceHandlerRegistry registry) {
/* 53 */     return registry.addResourceHandler(RESOURCE_PATHS);
/*    */   }
/*    */   
/*    */   protected void initializeResourceHandler(ResourceHandlerRegistration resourceHandlerRegistration) {
/* 57 */     resourceHandlerRegistration.addResourceLocations(RESOURCE_LOCATIONS).setCacheControl(getCacheControl());
/*    */   }
/*    */   
/*    */   protected CacheControl getCacheControl() {
/* 61 */     return CacheControl.maxAge(getJHipsterHttpCacheProperty(), TimeUnit.DAYS).cachePublic();
/*    */   }
/*    */   
/*    */   private int getJHipsterHttpCacheProperty() {
/* 65 */     return this.jhipsterProperties.getHttp().getCache().getTimeToLiveInDays();
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\config\StaticResourcesWebConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */