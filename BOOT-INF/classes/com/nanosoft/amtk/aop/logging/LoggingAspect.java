/*     */ package BOOT-INF.classes.com.nanosoft.amtk.aop.logging;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import org.aspectj.lang.JoinPoint;
/*     */ import org.aspectj.lang.ProceedingJoinPoint;
/*     */ import org.aspectj.lang.annotation.AfterThrowing;
/*     */ import org.aspectj.lang.annotation.Around;
/*     */ import org.aspectj.lang.annotation.Aspect;
/*     */ import org.aspectj.lang.annotation.Pointcut;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.core.env.Environment;
/*     */ import org.springframework.core.env.Profiles;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Aspect
/*     */ public class LoggingAspect
/*     */ {
/*     */   private final Environment env;
/*     */   
/*     */   public LoggingAspect(Environment env) {
/*  27 */     this.env = env;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Pointcut("within(@org.springframework.stereotype.Repository *) || within(@org.springframework.stereotype.Service *) || within(@org.springframework.web.bind.annotation.RestController *)")
/*     */   public void springBeanPointcut() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Pointcut("within(com.nanosoft.amtk.repository..*) || within(com.nanosoft.amtk.service..*) || within(com.nanosoft.amtk.web.rest..*)")
/*     */   public void applicationPackagePointcut() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Logger logger(JoinPoint joinPoint) {
/*  59 */     return LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringTypeName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
/*     */   public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
/*  70 */     if (this.env.acceptsProfiles(Profiles.of(new String[] { "dev" }))) {
/*  71 */       logger(joinPoint)
/*  72 */         .error("Exception in {}() with cause = '{}' and exception = '{}'", new Object[] {
/*     */             
/*  74 */             joinPoint.getSignature().getName(), 
/*  75 */             (e.getCause() != null) ? e.getCause() : "NULL", e
/*  76 */             .getMessage(), e
/*     */           });
/*     */     } else {
/*     */       
/*  80 */       logger(joinPoint)
/*  81 */         .error("Exception in {}() with cause = {}", joinPoint
/*     */           
/*  83 */           .getSignature().getName(), 
/*  84 */           (e.getCause() != null) ? e.getCause() : "NULL");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Around("applicationPackagePointcut() && springBeanPointcut()")
/*     */   public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
/*  98 */     Logger log = logger((JoinPoint)joinPoint);
/*  99 */     if (log.isDebugEnabled()) {
/* 100 */       log.debug("Enter: {}() with argument[s] = {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
/*     */     }
/*     */     try {
/* 103 */       Object result = joinPoint.proceed();
/* 104 */       if (log.isDebugEnabled()) {
/* 105 */         log.debug("Exit: {}() with result = {}", joinPoint.getSignature().getName(), result);
/*     */       }
/* 107 */       return result;
/* 108 */     } catch (IllegalArgumentException e) {
/* 109 */       log.error("Illegal argument: {} in {}()", Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature().getName());
/* 110 */       throw e;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\aop\logging\LoggingAspect.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */