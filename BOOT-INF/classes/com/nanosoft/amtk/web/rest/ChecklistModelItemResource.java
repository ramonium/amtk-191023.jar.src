/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.ChecklistModelItemRepository;
/*     */ import com.nanosoft.amtk.service.ChecklistModelItemQueryService;
/*     */ import com.nanosoft.amtk.service.ChecklistModelItemService;
/*     */ import com.nanosoft.amtk.service.criteria.ChecklistModelItemCriteria;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistModelItemDTO;
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
/*     */ public class ChecklistModelItemResource {
/*  36 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.ChecklistModelItemResource.class);
/*     */ 
/*     */   
/*     */   private static final String ENTITY_NAME = "checklistModelItem";
/*     */ 
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */ 
/*     */   
/*     */   private final ChecklistModelItemService checklistModelItemService;
/*     */   
/*     */   private final ChecklistModelItemRepository checklistModelItemRepository;
/*     */   
/*     */   private final ChecklistModelItemQueryService checklistModelItemQueryService;
/*     */ 
/*     */   
/*     */   public ChecklistModelItemResource(ChecklistModelItemService checklistModelItemService, ChecklistModelItemRepository checklistModelItemRepository, ChecklistModelItemQueryService checklistModelItemQueryService) {
/*  54 */     this.checklistModelItemService = checklistModelItemService;
/*  55 */     this.checklistModelItemRepository = checklistModelItemRepository;
/*  56 */     this.checklistModelItemQueryService = checklistModelItemQueryService;
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
/*     */   @PostMapping({"/checklist-model-items"})
/*     */   public ResponseEntity<ChecklistModelItemDTO> createChecklistModelItem(@Valid @RequestBody ChecklistModelItemDTO checklistModelItemDTO) throws URISyntaxException {
/*  69 */     this.log.debug("REST request to save ChecklistModelItem : {}", checklistModelItemDTO);
/*  70 */     if (checklistModelItemDTO.getId() != null) {
/*  71 */       throw new BadRequestAlertException("A new checklistModelItem cannot already have an ID", "checklistModelItem", "idexists");
/*     */     }
/*  73 */     ChecklistModelItemDTO result = this.checklistModelItemService.save(checklistModelItemDTO);
/*  74 */     return (
/*  75 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/checklist-model-items/" + result.getId()))
/*  76 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "checklistModelItem", result.getId().toString())))
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
/*     */   @PutMapping({"/checklist-model-items/{id}"})
/*     */   public ResponseEntity<ChecklistModelItemDTO> updateChecklistModelItem(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody ChecklistModelItemDTO checklistModelItemDTO) throws URISyntaxException {
/*  95 */     this.log.debug("REST request to update ChecklistModelItem : {}, {}", id, checklistModelItemDTO);
/*  96 */     if (checklistModelItemDTO.getId() == null) {
/*  97 */       throw new BadRequestAlertException("Invalid id", "checklistModelItem", "idnull");
/*     */     }
/*  99 */     if (!Objects.equals(id, checklistModelItemDTO.getId())) {
/* 100 */       throw new BadRequestAlertException("Invalid ID", "checklistModelItem", "idinvalid");
/*     */     }
/*     */     
/* 103 */     if (!this.checklistModelItemRepository.existsById(id)) {
/* 104 */       throw new BadRequestAlertException("Entity not found", "checklistModelItem", "idnotfound");
/*     */     }
/*     */     
/* 107 */     ChecklistModelItemDTO result = this.checklistModelItemService.update(checklistModelItemDTO);
/* 108 */     return (
/* 109 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 110 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "checklistModelItem", checklistModelItemDTO.getId().toString())))
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
/*     */   @PatchMapping(value = {"/checklist-model-items/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<ChecklistModelItemDTO> partialUpdateChecklistModelItem(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody ChecklistModelItemDTO checklistModelItemDTO) throws URISyntaxException {
/* 130 */     this.log.debug("REST request to partial update ChecklistModelItem partially : {}, {}", id, checklistModelItemDTO);
/* 131 */     if (checklistModelItemDTO.getId() == null) {
/* 132 */       throw new BadRequestAlertException("Invalid id", "checklistModelItem", "idnull");
/*     */     }
/* 134 */     if (!Objects.equals(id, checklistModelItemDTO.getId())) {
/* 135 */       throw new BadRequestAlertException("Invalid ID", "checklistModelItem", "idinvalid");
/*     */     }
/*     */     
/* 138 */     if (!this.checklistModelItemRepository.existsById(id)) {
/* 139 */       throw new BadRequestAlertException("Entity not found", "checklistModelItem", "idnotfound");
/*     */     }
/*     */     
/* 142 */     Optional<ChecklistModelItemDTO> result = this.checklistModelItemService.partialUpdate(checklistModelItemDTO);
/*     */     
/* 144 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 146 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "checklistModelItem", checklistModelItemDTO.getId().toString()));
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
/*     */   @GetMapping({"/checklist-model-items"})
/*     */   public ResponseEntity<List<ChecklistModelItemDTO>> getAllChecklistModelItems(ChecklistModelItemCriteria criteria, @ParameterObject Pageable pageable) {
/* 162 */     this.log.debug("REST request to get ChecklistModelItems by criteria: {}", criteria);
/* 163 */     Page<ChecklistModelItemDTO> page = this.checklistModelItemQueryService.findByCriteria(criteria, pageable);
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
/*     */   @GetMapping({"/checklist-model-items/count"})
/*     */   public ResponseEntity<Long> countChecklistModelItems(ChecklistModelItemCriteria criteria) {
/* 176 */     this.log.debug("REST request to count ChecklistModelItems by criteria: {}", criteria);
/* 177 */     return ResponseEntity.ok().body(Long.valueOf(this.checklistModelItemQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/checklist-model-items/{id}"})
/*     */   public ResponseEntity<ChecklistModelItemDTO> getChecklistModelItem(@PathVariable Long id) {
/* 188 */     this.log.debug("REST request to get ChecklistModelItem : {}", id);
/* 189 */     Optional<ChecklistModelItemDTO> checklistModelItemDTO = this.checklistModelItemService.findOne(id);
/* 190 */     return ResponseUtil.wrapOrNotFound(checklistModelItemDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/checklist-model-items/{id}"})
/*     */   public ResponseEntity<Void> deleteChecklistModelItem(@PathVariable Long id) {
/* 201 */     this.log.debug("REST request to delete ChecklistModelItem : {}", id);
/* 202 */     this.checklistModelItemService.delete(id);
/* 203 */     return 
/* 204 */       ResponseEntity.noContent()
/* 205 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "checklistModelItem", id.toString()))
/* 206 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\ChecklistModelItemResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */