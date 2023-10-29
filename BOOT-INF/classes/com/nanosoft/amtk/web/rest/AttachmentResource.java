/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.AttachmentRepository;
/*     */ import com.nanosoft.amtk.service.AttachmentQueryService;
/*     */ import com.nanosoft.amtk.service.AttachmentService;
/*     */ import com.nanosoft.amtk.service.criteria.AttachmentCriteria;
/*     */ import com.nanosoft.amtk.service.dto.AttachmentDTO;
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
/*     */ public class AttachmentResource {
/*  36 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.AttachmentResource.class);
/*     */ 
/*     */   
/*     */   private static final String ENTITY_NAME = "attachment";
/*     */ 
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */ 
/*     */   
/*     */   private final AttachmentService attachmentService;
/*     */   
/*     */   private final AttachmentRepository attachmentRepository;
/*     */   
/*     */   private final AttachmentQueryService attachmentQueryService;
/*     */ 
/*     */   
/*     */   public AttachmentResource(AttachmentService attachmentService, AttachmentRepository attachmentRepository, AttachmentQueryService attachmentQueryService) {
/*  54 */     this.attachmentService = attachmentService;
/*  55 */     this.attachmentRepository = attachmentRepository;
/*  56 */     this.attachmentQueryService = attachmentQueryService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/attachments"})
/*     */   public ResponseEntity<AttachmentDTO> createAttachment(@Valid @RequestBody AttachmentDTO attachmentDTO) throws URISyntaxException {
/*  68 */     this.log.debug("REST request to save Attachment : {}", attachmentDTO);
/*  69 */     if (attachmentDTO.getId() != null) {
/*  70 */       throw new BadRequestAlertException("A new attachment cannot already have an ID", "attachment", "idexists");
/*     */     }
/*  72 */     AttachmentDTO result = this.attachmentService.save(attachmentDTO);
/*  73 */     return (
/*  74 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/attachments/" + result.getId()))
/*  75 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "attachment", result.getId().toString())))
/*  76 */       .body(result);
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
/*     */   @PutMapping({"/attachments/{id}"})
/*     */   public ResponseEntity<AttachmentDTO> updateAttachment(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody AttachmentDTO attachmentDTO) throws URISyntaxException {
/*  94 */     this.log.debug("REST request to update Attachment : {}, {}", id, attachmentDTO);
/*  95 */     if (attachmentDTO.getId() == null) {
/*  96 */       throw new BadRequestAlertException("Invalid id", "attachment", "idnull");
/*     */     }
/*  98 */     if (!Objects.equals(id, attachmentDTO.getId())) {
/*  99 */       throw new BadRequestAlertException("Invalid ID", "attachment", "idinvalid");
/*     */     }
/*     */     
/* 102 */     if (!this.attachmentRepository.existsById(id)) {
/* 103 */       throw new BadRequestAlertException("Entity not found", "attachment", "idnotfound");
/*     */     }
/*     */     
/* 106 */     AttachmentDTO result = this.attachmentService.update(attachmentDTO);
/* 107 */     return (
/* 108 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 109 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "attachment", attachmentDTO.getId().toString())))
/* 110 */       .body(result);
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
/*     */   @PatchMapping(value = {"/attachments/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<AttachmentDTO> partialUpdateAttachment(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody AttachmentDTO attachmentDTO) throws URISyntaxException {
/* 129 */     this.log.debug("REST request to partial update Attachment partially : {}, {}", id, attachmentDTO);
/* 130 */     if (attachmentDTO.getId() == null) {
/* 131 */       throw new BadRequestAlertException("Invalid id", "attachment", "idnull");
/*     */     }
/* 133 */     if (!Objects.equals(id, attachmentDTO.getId())) {
/* 134 */       throw new BadRequestAlertException("Invalid ID", "attachment", "idinvalid");
/*     */     }
/*     */     
/* 137 */     if (!this.attachmentRepository.existsById(id)) {
/* 138 */       throw new BadRequestAlertException("Entity not found", "attachment", "idnotfound");
/*     */     }
/*     */     
/* 141 */     Optional<AttachmentDTO> result = this.attachmentService.partialUpdate(attachmentDTO);
/*     */     
/* 143 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 145 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "attachment", attachmentDTO.getId().toString()));
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
/*     */   @GetMapping({"/attachments"})
/*     */   public ResponseEntity<List<AttachmentDTO>> getAllAttachments(AttachmentCriteria criteria, @ParameterObject Pageable pageable) {
/* 161 */     this.log.debug("REST request to get Attachments by criteria: {}", criteria);
/* 162 */     Page<AttachmentDTO> page = this.attachmentQueryService.findByCriteria(criteria, pageable);
/* 163 */     HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders((UriComponentsBuilder)ServletUriComponentsBuilder.fromCurrentRequest(), page);
/* 164 */     return ((ResponseEntity.BodyBuilder)ResponseEntity.ok().headers(headers)).body(page.getContent());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/attachments/count"})
/*     */   public ResponseEntity<Long> countAttachments(AttachmentCriteria criteria) {
/* 175 */     this.log.debug("REST request to count Attachments by criteria: {}", criteria);
/* 176 */     return ResponseEntity.ok().body(Long.valueOf(this.attachmentQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/attachments/{id}"})
/*     */   public ResponseEntity<AttachmentDTO> getAttachment(@PathVariable Long id) {
/* 187 */     this.log.debug("REST request to get Attachment : {}", id);
/* 188 */     Optional<AttachmentDTO> attachmentDTO = this.attachmentService.findOne(id);
/* 189 */     return ResponseUtil.wrapOrNotFound(attachmentDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/attachments/{id}"})
/*     */   public ResponseEntity<Void> deleteAttachment(@PathVariable Long id) {
/* 200 */     this.log.debug("REST request to delete Attachment : {}", id);
/* 201 */     this.attachmentService.delete(id);
/* 202 */     return 
/* 203 */       ResponseEntity.noContent()
/* 204 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "attachment", id.toString()))
/* 205 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\AttachmentResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */