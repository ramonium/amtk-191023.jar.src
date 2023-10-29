/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.CertificateRepository;
/*     */ import com.nanosoft.amtk.service.CertificateQueryService;
/*     */ import com.nanosoft.amtk.service.CertificateService;
/*     */ import com.nanosoft.amtk.service.criteria.CertificateCriteria;
/*     */ import com.nanosoft.amtk.service.dto.CertificateDTO;
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
/*     */ import org.springframework.web.bind.annotation.PostMapping;
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
/*     */ public class CertificateResource {
/*  37 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.CertificateResource.class);
/*     */ 
/*     */   
/*     */   private static final String ENTITY_NAME = "certificate";
/*     */ 
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */ 
/*     */   
/*     */   private final CertificateService certificateService;
/*     */   
/*     */   private final CertificateRepository certificateRepository;
/*     */   
/*     */   private final CertificateQueryService certificateQueryService;
/*     */ 
/*     */   
/*     */   public CertificateResource(CertificateService certificateService, CertificateRepository certificateRepository, CertificateQueryService certificateQueryService) {
/*  55 */     this.certificateService = certificateService;
/*  56 */     this.certificateRepository = certificateRepository;
/*  57 */     this.certificateQueryService = certificateQueryService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/certificates"})
/*     */   public ResponseEntity<CertificateDTO> createCertificate(@Valid @RequestBody CertificateDTO certificateDTO) throws URISyntaxException {
/*  69 */     this.log.debug("REST request to save Certificate : {}", certificateDTO);
/*  70 */     if (certificateDTO.getId() != null) {
/*  71 */       throw new BadRequestAlertException("A new certificate cannot already have an ID", "certificate", "idexists");
/*     */     }
/*  73 */     CertificateDTO result = this.certificateService.save(certificateDTO);
/*  74 */     return (
/*  75 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/certificates/" + result.getId()))
/*  76 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "certificate", result.getId().toString())))
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
/*     */   @PutMapping({"/certificates/{id}"})
/*     */   public ResponseEntity<CertificateDTO> updateCertificate(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody CertificateDTO certificateDTO) throws URISyntaxException {
/*  95 */     this.log.debug("REST request to update Certificate : {}, {}", id, certificateDTO);
/*  96 */     if (certificateDTO.getId() == null) {
/*  97 */       throw new BadRequestAlertException("Invalid id", "certificate", "idnull");
/*     */     }
/*  99 */     if (!Objects.equals(id, certificateDTO.getId())) {
/* 100 */       throw new BadRequestAlertException("Invalid ID", "certificate", "idinvalid");
/*     */     }
/*     */     
/* 103 */     if (!this.certificateRepository.existsById(id)) {
/* 104 */       throw new BadRequestAlertException("Entity not found", "certificate", "idnotfound");
/*     */     }
/*     */     
/* 107 */     CertificateDTO result = this.certificateService.update(certificateDTO);
/* 108 */     return (
/* 109 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 110 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "certificate", certificateDTO.getId().toString())))
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
/*     */   @PatchMapping(value = {"/certificates/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<CertificateDTO> partialUpdateCertificate(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody CertificateDTO certificateDTO) throws URISyntaxException {
/* 130 */     this.log.debug("REST request to partial update Certificate partially : {}, {}", id, certificateDTO);
/* 131 */     if (certificateDTO.getId() == null) {
/* 132 */       throw new BadRequestAlertException("Invalid id", "certificate", "idnull");
/*     */     }
/* 134 */     if (!Objects.equals(id, certificateDTO.getId())) {
/* 135 */       throw new BadRequestAlertException("Invalid ID", "certificate", "idinvalid");
/*     */     }
/*     */     
/* 138 */     if (!this.certificateRepository.existsById(id)) {
/* 139 */       throw new BadRequestAlertException("Entity not found", "certificate", "idnotfound");
/*     */     }
/*     */     
/* 142 */     Optional<CertificateDTO> result = this.certificateService.partialUpdate(certificateDTO);
/*     */     
/* 144 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 146 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "certificate", certificateDTO.getId().toString()));
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
/*     */   @GetMapping({"/certificates"})
/*     */   public ResponseEntity<List<CertificateDTO>> getAllCertificates(CertificateCriteria criteria, @ParameterObject Pageable pageable) {
/* 162 */     this.log.debug("REST request to get Certificates by criteria: {}", criteria);
/* 163 */     Page<CertificateDTO> page = this.certificateQueryService.findByCriteria(criteria, pageable);
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
/*     */   @GetMapping({"/certificates/count"})
/*     */   public ResponseEntity<Long> countCertificates(CertificateCriteria criteria) {
/* 176 */     this.log.debug("REST request to count Certificates by criteria: {}", criteria);
/* 177 */     return ResponseEntity.ok().body(Long.valueOf(this.certificateQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/certificates/{id}"})
/*     */   public ResponseEntity<CertificateDTO> getCertificate(@PathVariable Long id) {
/* 188 */     this.log.debug("REST request to get Certificate : {}", id);
/* 189 */     Optional<CertificateDTO> certificateDTO = this.certificateService.findOne(id);
/* 190 */     return ResponseUtil.wrapOrNotFound(certificateDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/certificates/{id}"})
/*     */   public ResponseEntity<Void> deleteCertificate(@PathVariable Long id) {
/* 201 */     this.log.debug("REST request to delete Certificate : {}", id);
/* 202 */     this.certificateService.delete(id);
/* 203 */     return 
/* 204 */       ResponseEntity.noContent()
/* 205 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "certificate", id.toString()))
/* 206 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\CertificateResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */