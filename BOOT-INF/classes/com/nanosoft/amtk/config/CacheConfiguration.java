/*     */ package BOOT-INF.classes.com.nanosoft.amtk.config;
/*     */ import com.nanosoft.amtk.domain.Area;
/*     */ import com.nanosoft.amtk.domain.Assignment;
/*     */ import com.nanosoft.amtk.domain.CertificationLevel;
/*     */ import com.nanosoft.amtk.domain.Checklist;
/*     */ import com.nanosoft.amtk.domain.ChecklistModel;
/*     */ import com.nanosoft.amtk.domain.Employee;
/*     */ import com.nanosoft.amtk.domain.EmployeeTitle;
/*     */ import com.nanosoft.amtk.domain.Process;
/*     */ import com.nanosoft.amtk.domain.Project;
/*     */ import com.nanosoft.amtk.domain.Team;
/*     */ import com.nanosoft.amtk.domain.User;
/*     */ import com.nanosoft.amtk.domain.Workstation;
/*     */ import java.util.Map;
/*     */ import javax.cache.CacheManager;
/*     */ import org.springframework.boot.info.BuildProperties;
/*     */ import org.springframework.boot.info.GitProperties;
/*     */ import org.springframework.context.annotation.Bean;
/*     */ import tech.jhipster.config.JHipsterProperties;
/*     */ 
/*     */ @Configuration
/*     */ @EnableCaching
/*     */ public class CacheConfiguration {
/*     */   private GitProperties gitProperties;
/*     */   
/*     */   public CacheConfiguration(JHipsterProperties jHipsterProperties) {
/*  27 */     JHipsterProperties.Cache.Ehcache ehcache = jHipsterProperties.getCache().getEhcache();
/*     */     
/*  29 */     this
/*  30 */       .jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
/*     */         
/*  32 */         CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class, (Builder)ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
/*  33 */         .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
/*  34 */         .build());
/*     */   }
/*     */   private BuildProperties buildProperties; private final Configuration<Object, Object> jcacheConfiguration;
/*     */   
/*     */   @Bean
/*     */   public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(CacheManager cacheManager) {
/*  40 */     return hibernateProperties -> hibernateProperties.put("hibernate.javax.cache.cache_manager", cacheManager);
/*     */   }
/*     */   
/*     */   @Bean
/*     */   public JCacheManagerCustomizer cacheManagerCustomizer() {
/*  45 */     return cm -> {
/*     */         createCache(cm, "usersByLogin");
/*     */         createCache(cm, "usersByEmail");
/*     */         createCache(cm, User.class.getName());
/*     */         createCache(cm, Authority.class.getName());
/*     */         createCache(cm, User.class.getName() + ".authorities");
/*     */         createCache(cm, Employee.class.getName());
/*     */         createCache(cm, Employee.class.getName() + ".attachments");
/*     */         createCache(cm, Employee.class.getName() + ".certificates");
/*     */         createCache(cm, Project.class.getName());
/*     */         createCache(cm, Project.class.getName() + ".areas");
/*     */         createCache(cm, Area.class.getName());
/*     */         createCache(cm, Area.class.getName() + ".workstations");
/*     */         createCache(cm, Workstation.class.getName());
/*     */         createCache(cm, Workstation.class.getName() + ".certificates");
/*     */         createCache(cm, Certificate.class.getName());
/*     */         createCache(cm, Checklist.class.getName());
/*     */         createCache(cm, Checklist.class.getName() + ".checklistItems");
/*     */         createCache(cm, ChecklistItem.class.getName());
/*     */         createCache(cm, ChecklistModel.class.getName());
/*     */         createCache(cm, ChecklistModel.class.getName() + ".certificationLevels");
/*     */         createCache(cm, ChecklistModel.class.getName() + ".checklists");
/*     */         createCache(cm, ChecklistModel.class.getName() + ".checklistModelItems");
/*     */         createCache(cm, ChecklistModelItem.class.getName());
/*     */         createCache(cm, Attachment.class.getName());
/*     */         createCache(cm, Content.class.getName());
/*     */         createCache(cm, Employee.class.getName() + ".assignments");
/*     */         createCache(cm, Workstation.class.getName() + ".assignments");
/*     */         createCache(cm, EmployeeTitle.class.getName());
/*     */         createCache(cm, EmployeeTitle.class.getName() + ".employees");
/*     */         createCache(cm, Team.class.getName());
/*     */         createCache(cm, Team.class.getName() + ".employees");
/*     */         createCache(cm, Process.class.getName());
/*     */         createCache(cm, Process.class.getName() + ".workstations");
/*     */         createCache(cm, Process.class.getName() + ".certificationLevels");
/*     */         createCache(cm, CertificationLevel.class.getName());
/*     */         createCache(cm, CertificationLevel.class.getName() + ".certificates");
/*     */         createCache(cm, Assignment.class.getName());
/*     */         createCache(cm, Assignment.class.getName() + ".certificates");
/*     */         createCache(cm, UserInfo.class.getName());
/*     */         createCache(cm, Employee.class.getName() + ".managedTeams");
/*     */         createCache(cm, Project.class.getName() + ".skillsMatrixHistories");
/*     */         createCache(cm, SkillsMatrix.class.getName());
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   private void createCache(CacheManager cm, String cacheName) {
/*  93 */     Cache<Object, Object> cache = cm.getCache(cacheName);
/*  94 */     if (cache != null) {
/*  95 */       cache.clear();
/*     */     } else {
/*  97 */       cm.createCache(cacheName, this.jcacheConfiguration);
/*     */     } 
/*     */   }
/*     */   
/*     */   @Autowired(required = false)
/*     */   public void setGitProperties(GitProperties gitProperties) {
/* 103 */     this.gitProperties = gitProperties;
/*     */   }
/*     */   
/*     */   @Autowired(required = false)
/*     */   public void setBuildProperties(BuildProperties buildProperties) {
/* 108 */     this.buildProperties = buildProperties;
/*     */   }
/*     */   
/*     */   @Bean
/*     */   public KeyGenerator keyGenerator() {
/* 113 */     return (KeyGenerator)new PrefixedKeyGenerator(this.gitProperties, this.buildProperties);
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\config\CacheConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */