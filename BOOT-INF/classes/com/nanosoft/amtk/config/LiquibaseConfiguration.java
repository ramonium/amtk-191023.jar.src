/*    */ package BOOT-INF.classes.com.nanosoft.amtk.config;
/*    */ 
/*    */ import java.util.concurrent.Executor;
/*    */ import javax.sql.DataSource;
/*    */ import liquibase.integration.spring.SpringLiquibase;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.beans.factory.ObjectProvider;
/*    */ import org.springframework.beans.factory.annotation.Qualifier;
/*    */ import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
/*    */ import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
/*    */ import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.core.env.Environment;
/*    */ import org.springframework.core.env.Profiles;
/*    */ import tech.jhipster.config.liquibase.AsyncSpringLiquibase;
/*    */ import tech.jhipster.config.liquibase.SpringLiquibaseUtil;
/*    */ 
/*    */ @Configuration
/*    */ public class LiquibaseConfiguration
/*    */ {
/* 23 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.config.LiquibaseConfiguration.class);
/*    */   
/*    */   private final Environment env;
/*    */   
/*    */   public LiquibaseConfiguration(Environment env) {
/* 28 */     this.env = env;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Bean
/*    */   public SpringLiquibase liquibase(@Qualifier("taskExecutor") Executor executor, @LiquibaseDataSource ObjectProvider<DataSource> liquibaseDataSource, LiquibaseProperties liquibaseProperties, ObjectProvider<DataSource> dataSource, DataSourceProperties dataSourceProperties) {
/* 41 */     AsyncSpringLiquibase asyncSpringLiquibase = SpringLiquibaseUtil.createAsyncSpringLiquibase(this.env, executor, (DataSource)liquibaseDataSource
/*    */ 
/*    */         
/* 44 */         .getIfAvailable(), liquibaseProperties, (DataSource)dataSource
/*    */         
/* 46 */         .getIfUnique(), dataSourceProperties);
/*    */ 
/*    */     
/* 49 */     asyncSpringLiquibase.setChangeLog("classpath:config/liquibase/master.xml");
/* 50 */     asyncSpringLiquibase.setContexts(liquibaseProperties.getContexts());
/* 51 */     asyncSpringLiquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
/* 52 */     asyncSpringLiquibase.setLiquibaseSchema(liquibaseProperties.getLiquibaseSchema());
/* 53 */     asyncSpringLiquibase.setLiquibaseTablespace(liquibaseProperties.getLiquibaseTablespace());
/* 54 */     asyncSpringLiquibase.setDatabaseChangeLogLockTable(liquibaseProperties.getDatabaseChangeLogLockTable());
/* 55 */     asyncSpringLiquibase.setDatabaseChangeLogTable(liquibaseProperties.getDatabaseChangeLogTable());
/* 56 */     asyncSpringLiquibase.setDropFirst(liquibaseProperties.isDropFirst());
/* 57 */     asyncSpringLiquibase.setLabels(liquibaseProperties.getLabels());
/* 58 */     asyncSpringLiquibase.setChangeLogParameters(liquibaseProperties.getParameters());
/* 59 */     asyncSpringLiquibase.setRollbackFile(liquibaseProperties.getRollbackFile());
/* 60 */     asyncSpringLiquibase.setTestRollbackOnUpdate(liquibaseProperties.isTestRollbackOnUpdate());
/* 61 */     if (this.env.acceptsProfiles(Profiles.of(new String[] { "no-liquibase" }))) {
/* 62 */       asyncSpringLiquibase.setShouldRun(false);
/*    */     } else {
/* 64 */       asyncSpringLiquibase.setShouldRun(liquibaseProperties.isEnabled());
/* 65 */       this.log.debug("Configuring Liquibase");
/*    */     } 
/* 67 */     return (SpringLiquibase)asyncSpringLiquibase;
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\config\LiquibaseConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */