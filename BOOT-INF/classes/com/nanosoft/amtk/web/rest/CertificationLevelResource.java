/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.CertificationLevelRepository;
/*     */ import com.nanosoft.amtk.service.CertificationLevelQueryService;
/*     */ import com.nanosoft.amtk.service.CertificationLevelService;
/*     */ import com.nanosoft.amtk.service.criteria.CertificationLevelCriteria;
/*     */ import com.nanosoft.amtk.service.dto.CertificationLevelDTO;
/*     */ import com.nanosoft.amtk.web.rest.errors.BadRequestAlertException;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springdoc.api.annotations.ParameterObject;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.Pageable;
/*     */ import org.springframework.http.HttpHeaders;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.web.bind.annotation.DeleteMapping;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PatchMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
/*     */ import tech.jhipster.web.util.HeaderUtil;
/*     */ import tech.jhipster.web.util.PaginationUtil;
/*     */ import tech.jhipster.web.util.ResponseUtil;
/*     */ 
/*     */ @RestController
/*     */ @RequestMapping({"/api"})
/*     */ public class CertificationLevelResource {
/*  36 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.CertificationLevelResource.class);
/*     */ 
/*     */   
/*     */   private static final String ENTITY_NAME = "certificationLevel";
/*     */ 
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */ 
/*     */   
/*     */   private final CertificationLevelService certificationLevelService;
/*     */   
/*     */   private final CertificationLevelRepository certificationLevelRepository;
/*     */   
/*     */   private final CertificationLevelQueryService certificationLevelQueryService;
/*     */ 
/*     */   
/*     */   public CertificationLevelResource(CertificationLevelService certificationLevelService, CertificationLevelRepository certificationLevelRepository, CertificationLevelQueryService certificationLevelQueryService) {
/*  54 */     this.certificationLevelService = certificationLevelService;
/*  55 */     this.certificationLevelRepository = certificationLevelRepository;
/*  56 */     this.certificationLevelQueryService = certificationLevelQueryService;
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
/*     */   @PostMapping({"/certification-levels"})
/*     */   public ResponseEntity<CertificationLevelDTO> createCertificationLevel(@Valid @RequestBody CertificationLevelDTO certificationLevelDTO) throws URISyntaxException {
/*  69 */     this.log.debug("REST request to save CertificationLevel : {}", certificationLevelDTO);
/*  70 */     if (certificationLevelDTO.getId() != null) {
/*  71 */       throw new BadRequestAlertException("A new certificationLevel cannot already have an ID", "certificationLevel", "idexists");
/*     */     }
/*  73 */     CertificationLevelDTO result = this.certificationLevelService.save(certificationLevelDTO);
/*  74 */     return (
/*  75 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/certification-levels/" + result.getId()))
/*  76 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "certificationLevel", result.getId().toString())))
/*  77 */       .body(result);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PutMapping({"/certification-levels/{id}"})
/*     */   public ResponseEntity<CertificationLevelDTO> updateCertificationLevel(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody CertificationLevelDTO certificationLevelDTO) throws URISyntaxException {
/*  95 */     this.log.debug("REST request to update CertificationLevel : {}, {}", id, certificationLevelDTO);
/*  96 */     if (certificationLevelDTO.getId() == null) {
/*  97 */       throw new BadRequestAlertException("Invalid id", "certificationLevel", "idnull");
/*     */     }
/*  99 */     if (!Objects.equals(id, certificationLevelDTO.getId())) {
/* 100 */       throw new BadRequestAlertException("Invalid ID", "certificationLevel", "idinvalid");
/*     */     }
/*     */     
/* 103 */     if (!this.certificationLevelRepository.existsById(id)) {
/* 104 */       throw new BadRequestAlertException("Entity not found", "certificationLevel", "idnotfound");
/*     */     }
/*     */     
/* 107 */     CertificationLevelDTO result = this.certificationLevelService.update(certificationLevelDTO);
/* 108 */     return (
/* 109 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 110 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "certificationLevel", certificationLevelDTO.getId().toString())))
/* 111 */       .body(result);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PatchMapping(value = {"/certification-levels/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<CertificationLevelDTO> partialUpdateCertificationLevel(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody CertificationLevelDTO certificationLevelDTO) throws URISyntaxException {
/* 130 */     this.log.debug("REST request to partial update CertificationLevel partially : {}, {}", id, certificationLevelDTO);
/* 131 */     if (certificationLevelDTO.getId() == null) {
/* 132 */       throw new BadRequestAlertException("Invalid id", "certificationLevel", "idnull");
/*     */     }
/* 134 */     if (!Objects.equals(id, certificationLevelDTO.getId())) {
/* 135 */       throw new BadRequestAlertException("Invalid ID", "certificationLevel", "idinvalid");
/*     */     }
/*     */     
/* 138 */     if (!this.certificationLevelRepository.existsById(id)) {
/* 139 */       throw new BadRequestAlertException("Entity not found", "certificationLevel", "idnotfound");
/*     */     }
/*     */     
/* 142 */     Optional<CertificationLevelDTO> result = this.certificationLevelService.partialUpdate(certificationLevelDTO);
/*     */     
/* 144 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 146 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "certificationLevel", certificationLevelDTO.getId().toString()));
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
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/certification-levels"})
/*     */   public ResponseEntity<List<CertificationLevelDTO>> getAllCertificationLevels(CertificationLevelCriteria criteria, @ParameterObject Pageable pageable) {
/* 162 */     this.log.debug("REST request to get CertificationLevels by criteria: {}", criteria);
/* 163 */     Page<CertificationLevelDTO> page = this.certificationLevelQueryService.findByCriteria(criteria, pageable);
/* 164 */     HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders((UriComponentsBuilder)ServletUriComponentsBuilder.fromCurrentRequest(), page);
/* 165 */     return ((ResponseEntity.BodyBuilder)ResponseEntity.ok().headers(headers)).body(page.getContent());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/certification-levels/count"})
/*     */   public ResponseEntity<Long> countCertificationLevels(CertificationLevelCriteria criteria) {
/* 176 */     this.log.debug("REST request to count CertificationLevels by criteria: {}", criteria);
/* 177 */     return ResponseEntity.ok().body(Long.valueOf(this.certificationLevelQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/certification-levels/{id}"})
/*     */   public ResponseEntity<CertificationLevelDTO> getCertificationLevel(@PathVariable Long id) {
/* 188 */     this.log.debug("REST request to get CertificationLevel : {}", id);
/* 189 */     Optional<CertificationLevelDTO> certificationLevelDTO = this.certificationLevelService.findOne(id);
/* 190 */     return ResponseUtil.wrapOrNotFound(certificationLevelDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/certification-levels/{id}"})
/*     */   public ResponseEntity<Void> deleteCertificationLevel(@PathVariable Long id) {
/* 201 */     this.log.debug("REST request to delete CertificationLevel : {}", id);
/* 202 */     this.certificationLevelService.delete(id);
/* 203 */     return 
/* 204 */       ResponseEntity.noContent()
/* 205 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "certificationLevel", id.toString()))
/* 206 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\CertificationLevelResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */