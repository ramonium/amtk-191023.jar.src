/*    */ package BOOT-INF.classes.com.nanosoft.amtk.config;
/*    */ 
/*    */ import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
/*    */ import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
/*    */ import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.zalando.problem.jackson.ProblemModule;
/*    */ import org.zalando.problem.violations.ConstraintViolationProblemModule;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ public class JacksonConfiguration
/*    */ {
/*    */   @Bean
/*    */   public JavaTimeModule javaTimeModule() {
/* 20 */     return new JavaTimeModule();
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public Jdk8Module jdk8TimeModule() {
/* 25 */     return new Jdk8Module();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Bean
/*    */   public Hibernate5Module hibernate5Module() {
/* 33 */     return new Hibernate5Module();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Bean
/*    */   public ProblemModule problemModule() {
/* 41 */     return new ProblemModule();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Bean
/*    */   public ConstraintViolationProblemModule constraintViolationProblemModule() {
/* 49 */     return new ConstraintViolationProblemModule();
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\config\JacksonConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */