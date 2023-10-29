/*    */ package BOOT-INF.classes.com.nanosoft.amtk.config;
/*    */ 
/*    */ import java.util.concurrent.Executor;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
/*    */ import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
/*    */ import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.context.annotation.Profile;
/*    */ import org.springframework.core.task.AsyncTaskExecutor;
/*    */ import org.springframework.scheduling.annotation.AsyncConfigurer;
/*    */ import org.springframework.scheduling.annotation.EnableAsync;
/*    */ import org.springframework.scheduling.annotation.EnableScheduling;
/*    */ import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
/*    */ import tech.jhipster.async.ExceptionHandlingAsyncTaskExecutor;
/*    */ 
/*    */ @Configuration
/*    */ @EnableAsync
/*    */ @EnableScheduling
/*    */ @Profile({"!testdev & !testprod"})
/*    */ public class AsyncConfiguration implements AsyncConfigurer {
/* 24 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.config.AsyncConfiguration.class);
/*    */   
/*    */   private final TaskExecutionProperties taskExecutionProperties;
/*    */   
/*    */   public AsyncConfiguration(TaskExecutionProperties taskExecutionProperties) {
/* 29 */     this.taskExecutionProperties = taskExecutionProperties;
/*    */   }
/*    */ 
/*    */   
/*    */   @Bean(name = {"taskExecutor"})
/*    */   public Executor getAsyncExecutor() {
/* 35 */     this.log.debug("Creating Async Task Executor");
/* 36 */     ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
/* 37 */     executor.setCorePoolSize(this.taskExecutionProperties.getPool().getCoreSize());
/* 38 */     executor.setMaxPoolSize(this.taskExecutionProperties.getPool().getMaxSize());
/* 39 */     executor.setQueueCapacity(this.taskExecutionProperties.getPool().getQueueCapacity());
/* 40 */     executor.setThreadNamePrefix(this.taskExecutionProperties.getThreadNamePrefix());
/* 41 */     return (Executor)new ExceptionHandlingAsyncTaskExecutor((AsyncTaskExecutor)executor);
/*    */   }
/*    */ 
/*    */   
/*    */   public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
/* 46 */     return (AsyncUncaughtExceptionHandler)new SimpleAsyncUncaughtExceptionHandler();
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\config\AsyncConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */