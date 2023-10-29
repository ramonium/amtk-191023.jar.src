/*    */ package BOOT-INF.classes.com.nanosoft.amtk.config;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.web.servlet.HandlerInterceptor;
/*    */ import org.springframework.web.servlet.LocaleResolver;
/*    */ import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
/*    */ import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*    */ import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
/*    */ import tech.jhipster.config.locale.AngularCookieLocaleResolver;
/*    */ 
/*    */ @Configuration
/*    */ public class LocaleConfiguration implements WebMvcConfigurer {
/*    */   @Bean
/*    */   public LocaleResolver localeResolver() {
/* 15 */     AngularCookieLocaleResolver cookieLocaleResolver = new AngularCookieLocaleResolver();
/* 16 */     cookieLocaleResolver.setCookieName("NG_TRANSLATE_LANG_KEY");
/* 17 */     return (LocaleResolver)cookieLocaleResolver;
/*    */   }
/*    */ 
/*    */   
/*    */   public void addInterceptors(InterceptorRegistry registry) {
/* 22 */     LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
/* 23 */     localeChangeInterceptor.setParamName("language");
/* 24 */     registry.addInterceptor((HandlerInterceptor)localeChangeInterceptor);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\config\LocaleConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */