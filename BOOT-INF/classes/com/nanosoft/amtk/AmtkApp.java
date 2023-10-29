/*     */ package BOOT-INF.classes.com.nanosoft.amtk;
/*     */ 
/*     */ import com.nanosoft.amtk.config.ApplicationProperties;
/*     */ import com.nanosoft.amtk.config.CRLFLogConverter;
/*     */ import java.net.InetAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Optional;
/*     */ import javax.annotation.PostConstruct;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.boot.SpringApplication;
/*     */ import org.springframework.boot.autoconfigure.SpringBootApplication;
/*     */ import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
/*     */ import org.springframework.boot.context.properties.EnableConfigurationProperties;
/*     */ import org.springframework.core.env.ConfigurableEnvironment;
/*     */ import org.springframework.core.env.Environment;
/*     */ import tech.jhipster.config.DefaultProfileUtil;
/*     */ 
/*     */ @SpringBootApplication
/*     */ @EnableConfigurationProperties({LiquibaseProperties.class, ApplicationProperties.class})
/*     */ public class AmtkApp
/*     */ {
/*  26 */   private static final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.AmtkApp.class);
/*     */   
/*     */   private final Environment env;
/*     */   
/*     */   public AmtkApp(Environment env) {
/*  31 */     this.env = env;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostConstruct
/*     */   public void initApplication() {
/*  43 */     Collection<String> activeProfiles = Arrays.asList(this.env.getActiveProfiles());
/*  44 */     if (activeProfiles
/*  45 */       .contains("dev") && activeProfiles
/*  46 */       .contains("prod"))
/*     */     {
/*  48 */       log.error("You have misconfigured your application! It should not run with both the 'dev' and 'prod' profiles at the same time.");
/*     */     }
/*     */ 
/*     */     
/*  52 */     if (activeProfiles
/*  53 */       .contains("dev") && activeProfiles
/*  54 */       .contains("cloud"))
/*     */     {
/*  56 */       log.error("You have misconfigured your application! It should not run with both the 'dev' and 'cloud' profiles at the same time.");
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
/*     */   public static void main(String[] args) {
/*  68 */     SpringApplication app = new SpringApplication(new Class[] { com.nanosoft.amtk.AmtkApp.class });
/*  69 */     DefaultProfileUtil.addDefaultProfile(app);
/*  70 */     ConfigurableEnvironment configurableEnvironment = app.run(args).getEnvironment();
/*  71 */     logApplicationStartup((Environment)configurableEnvironment);
/*     */   }
/*     */   
/*     */   private static void logApplicationStartup(Environment env) {
/*  75 */     String protocol = Optional.<String>ofNullable(env.getProperty("server.ssl.key-store")).map(key -> "https").orElse("http");
/*  76 */     String serverPort = env.getProperty("server.port");
/*     */ 
/*     */ 
/*     */     
/*  80 */     String contextPath = Optional.<String>ofNullable(env.getProperty("server.servlet.context-path")).filter(StringUtils::isNotBlank).orElse("/");
/*  81 */     String hostAddress = "localhost";
/*     */     try {
/*  83 */       hostAddress = InetAddress.getLocalHost().getHostAddress();
/*  84 */     } catch (UnknownHostException e) {
/*  85 */       log.warn("The host name could not be determined, using `localhost` as fallback");
/*     */     } 
/*  87 */     log.info(CRLFLogConverter.CRLF_SAFE_MARKER, "\n----------------------------------------------------------\n\tApplication '{}' is running! Access URLs:\n\tLocal: \t\t{}://localhost:{}{}\n\tExternal: \t{}://{}:{}{}\n\tProfile(s): \t{}\n----------------------------------------------------------", new Object[] { env
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  94 */           .getProperty("spring.application.name"), protocol, serverPort, contextPath, protocol, hostAddress, serverPort, contextPath, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 102 */           ((env.getActiveProfiles()).length == 0) ? env.getDefaultProfiles() : env.getActiveProfiles() });
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\AmtkApp.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */