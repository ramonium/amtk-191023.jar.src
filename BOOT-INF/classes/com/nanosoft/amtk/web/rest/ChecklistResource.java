/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.ChecklistRepository;
/*     */ import com.nanosoft.amtk.service.ChecklistQueryService;
/*     */ import com.nanosoft.amtk.service.ChecklistService;
/*     */ import com.nanosoft.amtk.service.criteria.ChecklistCriteria;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistDTO;
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
/*     */ public class ChecklistResource {
/*  37 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.ChecklistResource.class);
/*     */ 
/*     */   
/*     */   private static final String ENTITY_NAME = "checklist";
/*     */ 
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */ 
/*     */   
/*     */   private final ChecklistService checklistService;
/*     */   
/*     */   private final ChecklistRepository checklistRepository;
/*     */   
/*     */   private final ChecklistQueryService checklistQueryService;
/*     */ 
/*     */   
/*     */   public ChecklistResource(ChecklistService checklistService, ChecklistRepository checklistRepository, ChecklistQueryService checklistQueryService) {
/*  55 */     this.checklistService = checklistService;
/*  56 */     this.checklistRepository = checklistRepository;
/*  57 */     this.checklistQueryService = checklistQueryService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/checklists"})
/*     */   public ResponseEntity<ChecklistDTO> createChecklist(@Valid @RequestBody ChecklistDTO checklistDTO) throws URISyntaxException {
/*  69 */     this.log.debug("REST request to save Checklist : {}", checklistDTO);
/*  70 */     if (checklistDTO.getId() != null) {
/*  71 */       throw new BadRequestAlertException("A new checklist cannot already have an ID", "checklist", "idexists");
/*     */     }
/*  73 */     ChecklistDTO result = this.checklistService.save(checklistDTO);
/*  74 */     return (
/*  75 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/checklists/" + result.getId()))
/*  76 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "checklist", result.getId().toString())))
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
/*     */   @PutMapping({"/checklists/{id}"})
/*     */   public ResponseEntity<ChecklistDTO> updateChecklist(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody ChecklistDTO checklistDTO) throws URISyntaxException {
/*  95 */     this.log.debug("REST request to update Checklist : {}, {}", id, checklistDTO);
/*  96 */     if (checklistDTO.getId() == null) {
/*  97 */       throw new BadRequestAlertException("Invalid id", "checklist", "idnull");
/*     */     }
/*  99 */     if (!Objects.equals(id, checklistDTO.getId())) {
/* 100 */       throw new BadRequestAlertException("Invalid ID", "checklist", "idinvalid");
/*     */     }
/*     */     
/* 103 */     if (!this.checklistRepository.existsById(id)) {
/* 104 */       throw new BadRequestAlertException("Entity not found", "checklist", "idnotfound");
/*     */     }
/*     */     
/* 107 */     ChecklistDTO result = this.checklistService.update(checklistDTO);
/* 108 */     return (
/* 109 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 110 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "checklist", checklistDTO.getId().toString())))
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
/*     */   @PatchMapping(value = {"/checklists/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<ChecklistDTO> partialUpdateChecklist(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody ChecklistDTO checklistDTO) throws URISyntaxException {
/* 130 */     this.log.debug("REST request to partial update Checklist partially : {}, {}", id, checklistDTO);
/* 131 */     if (checklistDTO.getId() == null) {
/* 132 */       throw new BadRequestAlertException("Invalid id", "checklist", "idnull");
/*     */     }
/* 134 */     if (!Objects.equals(id, checklistDTO.getId())) {
/* 135 */       throw new BadRequestAlertException("Invalid ID", "checklist", "idinvalid");
/*     */     }
/*     */     
/* 138 */     if (!this.checklistRepository.existsById(id)) {
/* 139 */       throw new BadRequestAlertException("Entity not found", "checklist", "idnotfound");
/*     */     }
/*     */     
/* 142 */     Optional<ChecklistDTO> result = this.checklistService.partialUpdate(checklistDTO);
/*     */     
/* 144 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 146 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "checklist", checklistDTO.getId().toString()));
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
/*     */   @GetMapping({"/checklists"})
/*     */   public ResponseEntity<List<ChecklistDTO>> getAllChecklists(ChecklistCriteria criteria, @ParameterObject Pageable pageable) {
/* 162 */     this.log.debug("REST request to get Checklists by criteria: {}", criteria);
/* 163 */     Page<ChecklistDTO> page = this.checklistQueryService.findByCriteria(criteria, pageable);
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
/*     */   @GetMapping({"/checklists/count"})
/*     */   public ResponseEntity<Long> countChecklists(ChecklistCriteria criteria) {
/* 176 */     this.log.debug("REST request to count Checklists by criteria: {}", criteria);
/* 177 */     return ResponseEntity.ok().body(Long.valueOf(this.checklistQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/checklists/{id}"})
/*     */   public ResponseEntity<ChecklistDTO> getChecklist(@PathVariable Long id) {
/* 188 */     this.log.debug("REST request to get Checklist : {}", id);
/* 189 */     Optional<ChecklistDTO> checklistDTO = this.checklistService.findOne(id);
/* 190 */     return ResponseUtil.wrapOrNotFound(checklistDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/checklists/{id}"})
/*     */   public ResponseEntity<Void> deleteChecklist(@PathVariable Long id) {
/* 201 */     this.log.debug("REST request to delete Checklist : {}", id);
/* 202 */     this.checklistService.delete(id);
/* 203 */     return 
/* 204 */       ResponseEntity.noContent()
/* 205 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "checklist", id.toString()))
/* 206 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\ChecklistResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */