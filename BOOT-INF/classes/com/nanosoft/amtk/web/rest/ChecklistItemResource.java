/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.ChecklistItemRepository;
/*     */ import com.nanosoft.amtk.service.ChecklistItemQueryService;
/*     */ import com.nanosoft.amtk.service.ChecklistItemService;
/*     */ import com.nanosoft.amtk.service.criteria.ChecklistItemCriteria;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistItemDTO;
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
/*     */ public class ChecklistItemResource {
/*  36 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.ChecklistItemResource.class);
/*     */ 
/*     */   
/*     */   private static final String ENTITY_NAME = "checklistItem";
/*     */ 
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */ 
/*     */   
/*     */   private final ChecklistItemService checklistItemService;
/*     */   
/*     */   private final ChecklistItemRepository checklistItemRepository;
/*     */   
/*     */   private final ChecklistItemQueryService checklistItemQueryService;
/*     */ 
/*     */   
/*     */   public ChecklistItemResource(ChecklistItemService checklistItemService, ChecklistItemRepository checklistItemRepository, ChecklistItemQueryService checklistItemQueryService) {
/*  54 */     this.checklistItemService = checklistItemService;
/*  55 */     this.checklistItemRepository = checklistItemRepository;
/*  56 */     this.checklistItemQueryService = checklistItemQueryService;
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
/*     */   @PostMapping({"/checklist-items"})
/*     */   public ResponseEntity<ChecklistItemDTO> createChecklistItem(@Valid @RequestBody ChecklistItemDTO checklistItemDTO) throws URISyntaxException {
/*  69 */     this.log.debug("REST request to save ChecklistItem : {}", checklistItemDTO);
/*  70 */     if (checklistItemDTO.getId() != null) {
/*  71 */       throw new BadRequestAlertException("A new checklistItem cannot already have an ID", "checklistItem", "idexists");
/*     */     }
/*  73 */     ChecklistItemDTO result = this.checklistItemService.save(checklistItemDTO);
/*  74 */     return (
/*  75 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/checklist-items/" + result.getId()))
/*  76 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "checklistItem", result.getId().toString())))
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
/*     */   @PutMapping({"/checklist-items/{id}"})
/*     */   public ResponseEntity<ChecklistItemDTO> updateChecklistItem(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody ChecklistItemDTO checklistItemDTO) throws URISyntaxException {
/*  95 */     this.log.debug("REST request to update ChecklistItem : {}, {}", id, checklistItemDTO);
/*  96 */     if (checklistItemDTO.getId() == null) {
/*  97 */       throw new BadRequestAlertException("Invalid id", "checklistItem", "idnull");
/*     */     }
/*  99 */     if (!Objects.equals(id, checklistItemDTO.getId())) {
/* 100 */       throw new BadRequestAlertException("Invalid ID", "checklistItem", "idinvalid");
/*     */     }
/*     */     
/* 103 */     if (!this.checklistItemRepository.existsById(id)) {
/* 104 */       throw new BadRequestAlertException("Entity not found", "checklistItem", "idnotfound");
/*     */     }
/*     */     
/* 107 */     ChecklistItemDTO result = this.checklistItemService.update(checklistItemDTO);
/* 108 */     return (
/* 109 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 110 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "checklistItem", checklistItemDTO.getId().toString())))
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
/*     */   @PatchMapping(value = {"/checklist-items/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<ChecklistItemDTO> partialUpdateChecklistItem(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody ChecklistItemDTO checklistItemDTO) throws URISyntaxException {
/* 130 */     this.log.debug("REST request to partial update ChecklistItem partially : {}, {}", id, checklistItemDTO);
/* 131 */     if (checklistItemDTO.getId() == null) {
/* 132 */       throw new BadRequestAlertException("Invalid id", "checklistItem", "idnull");
/*     */     }
/* 134 */     if (!Objects.equals(id, checklistItemDTO.getId())) {
/* 135 */       throw new BadRequestAlertException("Invalid ID", "checklistItem", "idinvalid");
/*     */     }
/*     */     
/* 138 */     if (!this.checklistItemRepository.existsById(id)) {
/* 139 */       throw new BadRequestAlertException("Entity not found", "checklistItem", "idnotfound");
/*     */     }
/*     */     
/* 142 */     Optional<ChecklistItemDTO> result = this.checklistItemService.partialUpdate(checklistItemDTO);
/*     */     
/* 144 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 146 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "checklistItem", checklistItemDTO.getId().toString()));
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
/*     */   @GetMapping({"/checklist-items"})
/*     */   public ResponseEntity<List<ChecklistItemDTO>> getAllChecklistItems(ChecklistItemCriteria criteria, @ParameterObject Pageable pageable) {
/* 162 */     this.log.debug("REST request to get ChecklistItems by criteria: {}", criteria);
/* 163 */     Page<ChecklistItemDTO> page = this.checklistItemQueryService.findByCriteria(criteria, pageable);
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
/*     */   @GetMapping({"/checklist-items/count"})
/*     */   public ResponseEntity<Long> countChecklistItems(ChecklistItemCriteria criteria) {
/* 176 */     this.log.debug("REST request to count ChecklistItems by criteria: {}", criteria);
/* 177 */     return ResponseEntity.ok().body(Long.valueOf(this.checklistItemQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/checklist-items/{id}"})
/*     */   public ResponseEntity<ChecklistItemDTO> getChecklistItem(@PathVariable Long id) {
/* 188 */     this.log.debug("REST request to get ChecklistItem : {}", id);
/* 189 */     Optional<ChecklistItemDTO> checklistItemDTO = this.checklistItemService.findOne(id);
/* 190 */     return ResponseUtil.wrapOrNotFound(checklistItemDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/checklist-items/{id}"})
/*     */   public ResponseEntity<Void> deleteChecklistItem(@PathVariable Long id) {
/* 201 */     this.log.debug("REST request to delete ChecklistItem : {}", id);
/* 202 */     this.checklistItemService.delete(id);
/* 203 */     return 
/* 204 */       ResponseEntity.noContent()
/* 205 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "checklistItem", id.toString()))
/* 206 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\ChecklistItemResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */