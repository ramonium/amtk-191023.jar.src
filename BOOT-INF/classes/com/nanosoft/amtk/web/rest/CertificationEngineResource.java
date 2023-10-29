/*    */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*    */ 
/*    */ import com.nanosoft.amtk.service.CertificationEngineService;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.beans.factory.annotation.Value;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ @RestController
/*    */ @RequestMapping({"/api"})
/*    */ public class CertificationEngineResource
/*    */ {
/* 17 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.CertificationEngineResource.class);
/*    */   
/*    */   @Value("${jhipster.clientApp.name}")
/*    */   private String applicationName;
/*    */   
/*    */   private final CertificationEngineService certificationEngineService;
/*    */   
/*    */   public CertificationEngineResource(CertificationEngineService certificationEngineService) {
/* 25 */     this.certificationEngineService = certificationEngineService;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"/certification-engine/certification"})
/*    */   public ResponseEntity<Void> runCertificationEngine() {
/* 35 */     this.log.debug("REST request to run certification engine.");
/* 36 */     this.certificationEngineService.runCertificationEngine();
/* 37 */     return ResponseEntity.noContent().build();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"/certification-engine/skills-matrix"})
/*    */   public ResponseEntity<Void> runSkillsMatrixEngine() {
/* 47 */     this.log.debug("REST request to run certification engine.");
/* 48 */     this.certificationEngineService.runSkillsMatrixEngine();
/* 49 */     return ResponseEntity.noContent().build();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"/certification-engine/skills-matrix/{projectId}"})
/*    */   public ResponseEntity<Void> runSkillsMatrixEngine(@PathVariable(value = "projectId", required = false) Long projectId) {
/* 59 */     this.log.debug("REST request to run certification engine.");
/* 60 */     this.certificationEngineService.runSkillsMatrixEngine(projectId);
/* 61 */     return ResponseEntity.noContent().build();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"/certification-engine/engine-sequence"})
/*    */   public ResponseEntity<Void> runEngineSequence() {
/* 71 */     this.log.debug("REST request to run engine sequence.");
/* 72 */     this.certificationEngineService.runEngineSequence();
/* 73 */     return ResponseEntity.noContent().build();
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\CertificationEngineResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */