/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.ChecklistModelRepository;
/*     */ import com.nanosoft.amtk.service.ChecklistModelQueryService;
/*     */ import com.nanosoft.amtk.service.ChecklistModelService;
/*     */ import com.nanosoft.amtk.service.criteria.ChecklistModelCriteria;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistModelDTO;
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
/*     */ public class ChecklistModelResource {
/*  36 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.ChecklistModelResource.class);
/*     */ 
/*     */   
/*     */   private static final String ENTITY_NAME = "checklistModel";
/*     */ 
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */ 
/*     */   
/*     */   private final ChecklistModelService checklistModelService;
/*     */   
/*     */   private final ChecklistModelRepository checklistModelRepository;
/*     */   
/*     */   private final ChecklistModelQueryService checklistModelQueryService;
/*     */ 
/*     */   
/*     */   public ChecklistModelResource(ChecklistModelService checklistModelService, ChecklistModelRepository checklistModelRepository, ChecklistModelQueryService checklistModelQueryService) {
/*  54 */     this.checklistModelService = checklistModelService;
/*  55 */     this.checklistModelRepository = checklistModelRepository;
/*  56 */     this.checklistModelQueryService = checklistModelQueryService;
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
/*     */   @PostMapping({"/checklist-models"})
/*     */   public ResponseEntity<ChecklistModelDTO> createChecklistModel(@Valid @RequestBody ChecklistModelDTO checklistModelDTO) throws URISyntaxException {
/*  69 */     this.log.debug("REST request to save ChecklistModel : {}", checklistModelDTO);
/*  70 */     if (checklistModelDTO.getId() != null) {
/*  71 */       throw new BadRequestAlertException("A new checklistModel cannot already have an ID", "checklistModel", "idexists");
/*     */     }
/*  73 */     ChecklistModelDTO result = this.checklistModelService.save(checklistModelDTO);
/*  74 */     return (
/*  75 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/checklist-models/" + result.getId()))
/*  76 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "checklistModel", result.getId().toString())))
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
/*     */   @PutMapping({"/checklist-models/{id}"})
/*     */   public ResponseEntity<ChecklistModelDTO> updateChecklistModel(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody ChecklistModelDTO checklistModelDTO) throws URISyntaxException {
/*  95 */     this.log.debug("REST request to update ChecklistModel : {}, {}", id, checklistModelDTO);
/*  96 */     if (checklistModelDTO.getId() == null) {
/*  97 */       throw new BadRequestAlertException("Invalid id", "checklistModel", "idnull");
/*     */     }
/*  99 */     if (!Objects.equals(id, checklistModelDTO.getId())) {
/* 100 */       throw new BadRequestAlertException("Invalid ID", "checklistModel", "idinvalid");
/*     */     }
/*     */     
/* 103 */     if (!this.checklistModelRepository.existsById(id)) {
/* 104 */       throw new BadRequestAlertException("Entity not found", "checklistModel", "idnotfound");
/*     */     }
/*     */     
/* 107 */     ChecklistModelDTO result = this.checklistModelService.update(checklistModelDTO);
/* 108 */     return (
/* 109 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 110 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "checklistModel", checklistModelDTO.getId().toString())))
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
/*     */   @PatchMapping(value = {"/checklist-models/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<ChecklistModelDTO> partialUpdateChecklistModel(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody ChecklistModelDTO checklistModelDTO) throws URISyntaxException {
/* 130 */     this.log.debug("REST request to partial update ChecklistModel partially : {}, {}", id, checklistModelDTO);
/* 131 */     if (checklistModelDTO.getId() == null) {
/* 132 */       throw new BadRequestAlertException("Invalid id", "checklistModel", "idnull");
/*     */     }
/* 134 */     if (!Objects.equals(id, checklistModelDTO.getId())) {
/* 135 */       throw new BadRequestAlertException("Invalid ID", "checklistModel", "idinvalid");
/*     */     }
/*     */     
/* 138 */     if (!this.checklistModelRepository.existsById(id)) {
/* 139 */       throw new BadRequestAlertException("Entity not found", "checklistModel", "idnotfound");
/*     */     }
/*     */     
/* 142 */     Optional<ChecklistModelDTO> result = this.checklistModelService.partialUpdate(checklistModelDTO);
/*     */     
/* 144 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 146 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "checklistModel", checklistModelDTO.getId().toString()));
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
/*     */   @GetMapping({"/checklist-models"})
/*     */   public ResponseEntity<List<ChecklistModelDTO>> getAllChecklistModels(ChecklistModelCriteria criteria, @ParameterObject Pageable pageable) {
/* 162 */     this.log.debug("REST request to get ChecklistModels by criteria: {}", criteria);
/* 163 */     Page<ChecklistModelDTO> page = this.checklistModelQueryService.findByCriteria(criteria, pageable);
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
/*     */   @GetMapping({"/checklist-models/count"})
/*     */   public ResponseEntity<Long> countChecklistModels(ChecklistModelCriteria criteria) {
/* 176 */     this.log.debug("REST request to count ChecklistModels by criteria: {}", criteria);
/* 177 */     return ResponseEntity.ok().body(Long.valueOf(this.checklistModelQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/checklist-models/{id}"})
/*     */   public ResponseEntity<ChecklistModelDTO> getChecklistModel(@PathVariable Long id) {
/* 188 */     this.log.debug("REST request to get ChecklistModel : {}", id);
/* 189 */     Optional<ChecklistModelDTO> checklistModelDTO = this.checklistModelService.findOne(id);
/* 190 */     return ResponseUtil.wrapOrNotFound(checklistModelDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/checklist-models/{id}"})
/*     */   public ResponseEntity<Void> deleteChecklistModel(@PathVariable Long id) {
/* 201 */     this.log.debug("REST request to delete ChecklistModel : {}", id);
/* 202 */     this.checklistModelService.delete(id);
/* 203 */     return 
/* 204 */       ResponseEntity.noContent()
/* 205 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "checklistModel", id.toString()))
/* 206 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\ChecklistModelResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */