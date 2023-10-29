/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.ContentRepository;
/*     */ import com.nanosoft.amtk.service.ContentQueryService;
/*     */ import com.nanosoft.amtk.service.ContentService;
/*     */ import com.nanosoft.amtk.service.criteria.ContentCriteria;
/*     */ import com.nanosoft.amtk.service.dto.ContentDTO;
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
/*     */ public class ContentResource {
/*  37 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.ContentResource.class);
/*     */   
/*     */   private static final String ENTITY_NAME = "content";
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */   
/*     */   private final ContentService contentService;
/*     */   
/*     */   private final ContentRepository contentRepository;
/*     */   
/*     */   private final ContentQueryService contentQueryService;
/*     */   
/*     */   public ContentResource(ContentService contentService, ContentRepository contentRepository, ContentQueryService contentQueryService) {
/*  51 */     this.contentService = contentService;
/*  52 */     this.contentRepository = contentRepository;
/*  53 */     this.contentQueryService = contentQueryService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/contents"})
/*     */   public ResponseEntity<ContentDTO> createContent(@Valid @RequestBody ContentDTO contentDTO) throws URISyntaxException {
/*  65 */     this.log.debug("REST request to save Content : {}", contentDTO);
/*  66 */     if (contentDTO.getId() != null) {
/*  67 */       throw new BadRequestAlertException("A new content cannot already have an ID", "content", "idexists");
/*     */     }
/*  69 */     ContentDTO result = this.contentService.save(contentDTO);
/*  70 */     return (
/*  71 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/contents/" + result.getId()))
/*  72 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "content", result.getId().toString())))
/*  73 */       .body(result);
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
/*     */   @PutMapping({"/contents/{id}"})
/*     */   public ResponseEntity<ContentDTO> updateContent(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody ContentDTO contentDTO) throws URISyntaxException {
/*  91 */     this.log.debug("REST request to update Content : {}, {}", id, contentDTO);
/*  92 */     if (contentDTO.getId() == null) {
/*  93 */       throw new BadRequestAlertException("Invalid id", "content", "idnull");
/*     */     }
/*  95 */     if (!Objects.equals(id, contentDTO.getId())) {
/*  96 */       throw new BadRequestAlertException("Invalid ID", "content", "idinvalid");
/*     */     }
/*     */     
/*  99 */     if (!this.contentRepository.existsById(id)) {
/* 100 */       throw new BadRequestAlertException("Entity not found", "content", "idnotfound");
/*     */     }
/*     */     
/* 103 */     ContentDTO result = this.contentService.update(contentDTO);
/* 104 */     return (
/* 105 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 106 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "content", contentDTO.getId().toString())))
/* 107 */       .body(result);
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
/*     */   @PatchMapping(value = {"/contents/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<ContentDTO> partialUpdateContent(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody ContentDTO contentDTO) throws URISyntaxException {
/* 126 */     this.log.debug("REST request to partial update Content partially : {}, {}", id, contentDTO);
/* 127 */     if (contentDTO.getId() == null) {
/* 128 */       throw new BadRequestAlertException("Invalid id", "content", "idnull");
/*     */     }
/* 130 */     if (!Objects.equals(id, contentDTO.getId())) {
/* 131 */       throw new BadRequestAlertException("Invalid ID", "content", "idinvalid");
/*     */     }
/*     */     
/* 134 */     if (!this.contentRepository.existsById(id)) {
/* 135 */       throw new BadRequestAlertException("Entity not found", "content", "idnotfound");
/*     */     }
/*     */     
/* 138 */     Optional<ContentDTO> result = this.contentService.partialUpdate(contentDTO);
/*     */     
/* 140 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 142 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "content", contentDTO.getId().toString()));
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
/*     */   @GetMapping({"/contents"})
/*     */   public ResponseEntity<List<ContentDTO>> getAllContents(ContentCriteria criteria, @ParameterObject Pageable pageable) {
/* 158 */     this.log.debug("REST request to get Contents by criteria: {}", criteria);
/* 159 */     Page<ContentDTO> page = this.contentQueryService.findByCriteria(criteria, pageable);
/* 160 */     HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders((UriComponentsBuilder)ServletUriComponentsBuilder.fromCurrentRequest(), page);
/* 161 */     return ((ResponseEntity.BodyBuilder)ResponseEntity.ok().headers(headers)).body(page.getContent());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/contents/count"})
/*     */   public ResponseEntity<Long> countContents(ContentCriteria criteria) {
/* 172 */     this.log.debug("REST request to count Contents by criteria: {}", criteria);
/* 173 */     return ResponseEntity.ok().body(Long.valueOf(this.contentQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/contents/{id}"})
/*     */   public ResponseEntity<ContentDTO> getContent(@PathVariable Long id) {
/* 184 */     this.log.debug("REST request to get Content : {}", id);
/* 185 */     Optional<ContentDTO> contentDTO = this.contentService.findOne(id);
/* 186 */     return ResponseUtil.wrapOrNotFound(contentDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/contents/{id}"})
/*     */   public ResponseEntity<Void> deleteContent(@PathVariable Long id) {
/* 197 */     this.log.debug("REST request to delete Content : {}", id);
/* 198 */     this.contentService.delete(id);
/* 199 */     return 
/* 200 */       ResponseEntity.noContent()
/* 201 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "content", id.toString()))
/* 202 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\ContentResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */