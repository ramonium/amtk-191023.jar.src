/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.WorkstationRepository;
/*     */ import com.nanosoft.amtk.service.WorkstationQueryService;
/*     */ import com.nanosoft.amtk.service.WorkstationService;
/*     */ import com.nanosoft.amtk.service.criteria.WorkstationCriteria;
/*     */ import com.nanosoft.amtk.service.dto.WorkstationDTO;
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
/*     */ public class WorkstationResource {
/*  36 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.WorkstationResource.class);
/*     */ 
/*     */   
/*     */   private static final String ENTITY_NAME = "workstation";
/*     */ 
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */ 
/*     */   
/*     */   private final WorkstationService workstationService;
/*     */   
/*     */   private final WorkstationRepository workstationRepository;
/*     */   
/*     */   private final WorkstationQueryService workstationQueryService;
/*     */ 
/*     */   
/*     */   public WorkstationResource(WorkstationService workstationService, WorkstationRepository workstationRepository, WorkstationQueryService workstationQueryService) {
/*  54 */     this.workstationService = workstationService;
/*  55 */     this.workstationRepository = workstationRepository;
/*  56 */     this.workstationQueryService = workstationQueryService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/workstations"})
/*     */   public ResponseEntity<WorkstationDTO> createWorkstation(@Valid @RequestBody WorkstationDTO workstationDTO) throws URISyntaxException {
/*  68 */     this.log.debug("REST request to save Workstation : {}", workstationDTO);
/*  69 */     if (workstationDTO.getId() != null) {
/*  70 */       throw new BadRequestAlertException("A new workstation cannot already have an ID", "workstation", "idexists");
/*     */     }
/*  72 */     WorkstationDTO result = this.workstationService.save(workstationDTO);
/*  73 */     return (
/*  74 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/workstations/" + result.getId()))
/*  75 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "workstation", result.getId().toString())))
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
/*     */   @PutMapping({"/workstations/{id}"})
/*     */   public ResponseEntity<WorkstationDTO> updateWorkstation(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody WorkstationDTO workstationDTO) throws URISyntaxException {
/*  94 */     this.log.debug("REST request to update Workstation : {}, {}", id, workstationDTO);
/*  95 */     if (workstationDTO.getId() == null) {
/*  96 */       throw new BadRequestAlertException("Invalid id", "workstation", "idnull");
/*     */     }
/*  98 */     if (!Objects.equals(id, workstationDTO.getId())) {
/*  99 */       throw new BadRequestAlertException("Invalid ID", "workstation", "idinvalid");
/*     */     }
/*     */     
/* 102 */     if (!this.workstationRepository.existsById(id)) {
/* 103 */       throw new BadRequestAlertException("Entity not found", "workstation", "idnotfound");
/*     */     }
/*     */     
/* 106 */     WorkstationDTO result = this.workstationService.update(workstationDTO);
/* 107 */     return (
/* 108 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 109 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "workstation", workstationDTO.getId().toString())))
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
/*     */   @PatchMapping(value = {"/workstations/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<WorkstationDTO> partialUpdateWorkstation(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody WorkstationDTO workstationDTO) throws URISyntaxException {
/* 129 */     this.log.debug("REST request to partial update Workstation partially : {}, {}", id, workstationDTO);
/* 130 */     if (workstationDTO.getId() == null) {
/* 131 */       throw new BadRequestAlertException("Invalid id", "workstation", "idnull");
/*     */     }
/* 133 */     if (!Objects.equals(id, workstationDTO.getId())) {
/* 134 */       throw new BadRequestAlertException("Invalid ID", "workstation", "idinvalid");
/*     */     }
/*     */     
/* 137 */     if (!this.workstationRepository.existsById(id)) {
/* 138 */       throw new BadRequestAlertException("Entity not found", "workstation", "idnotfound");
/*     */     }
/*     */     
/* 141 */     Optional<WorkstationDTO> result = this.workstationService.partialUpdate(workstationDTO);
/*     */     
/* 143 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 145 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "workstation", workstationDTO.getId().toString()));
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
/*     */   @GetMapping({"/workstations"})
/*     */   public ResponseEntity<List<WorkstationDTO>> getAllWorkstations(WorkstationCriteria criteria, @ParameterObject Pageable pageable) {
/* 161 */     this.log.debug("REST request to get Workstations by criteria: {}", criteria);
/* 162 */     Page<WorkstationDTO> page = this.workstationQueryService.findByCriteria(criteria, pageable);
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
/*     */   @GetMapping({"/workstations/count"})
/*     */   public ResponseEntity<Long> countWorkstations(WorkstationCriteria criteria) {
/* 175 */     this.log.debug("REST request to count Workstations by criteria: {}", criteria);
/* 176 */     return ResponseEntity.ok().body(Long.valueOf(this.workstationQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/workstations/{id}"})
/*     */   public ResponseEntity<WorkstationDTO> getWorkstation(@PathVariable Long id) {
/* 187 */     this.log.debug("REST request to get Workstation : {}", id);
/* 188 */     Optional<WorkstationDTO> workstationDTO = this.workstationService.findOne(id);
/* 189 */     return ResponseUtil.wrapOrNotFound(workstationDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/workstations/{id}"})
/*     */   public ResponseEntity<Void> deleteWorkstation(@PathVariable Long id) {
/* 200 */     this.log.debug("REST request to delete Workstation : {}", id);
/* 201 */     this.workstationService.delete(id);
/* 202 */     return 
/* 203 */       ResponseEntity.noContent()
/* 204 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "workstation", id.toString()))
/* 205 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\WorkstationResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */