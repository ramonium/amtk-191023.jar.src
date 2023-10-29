/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.AssignmentRepository;
/*     */ import com.nanosoft.amtk.service.AssignmentQueryService;
/*     */ import com.nanosoft.amtk.service.AssignmentService;
/*     */ import com.nanosoft.amtk.service.criteria.AssignmentCriteria;
/*     */ import com.nanosoft.amtk.service.dto.AssignmentDTO;
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
/*     */ public class AssignmentResource {
/*  36 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.AssignmentResource.class);
/*     */ 
/*     */   
/*     */   private static final String ENTITY_NAME = "assignment";
/*     */ 
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */ 
/*     */   
/*     */   private final AssignmentService assignmentService;
/*     */   
/*     */   private final AssignmentRepository assignmentRepository;
/*     */   
/*     */   private final AssignmentQueryService assignmentQueryService;
/*     */ 
/*     */   
/*     */   public AssignmentResource(AssignmentService assignmentService, AssignmentRepository assignmentRepository, AssignmentQueryService assignmentQueryService) {
/*  54 */     this.assignmentService = assignmentService;
/*  55 */     this.assignmentRepository = assignmentRepository;
/*  56 */     this.assignmentQueryService = assignmentQueryService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/assignments"})
/*     */   public ResponseEntity<AssignmentDTO> createAssignment(@Valid @RequestBody AssignmentDTO assignmentDTO) throws URISyntaxException {
/*  68 */     this.log.debug("REST request to save Assignment : {}", assignmentDTO);
/*  69 */     if (assignmentDTO.getId() != null) {
/*  70 */       throw new BadRequestAlertException("A new assignment cannot already have an ID", "assignment", "idexists");
/*     */     }
/*  72 */     AssignmentDTO result = this.assignmentService.save(assignmentDTO);
/*  73 */     return (
/*  74 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/assignments/" + result.getId()))
/*  75 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "assignment", result.getId().toString())))
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
/*     */   @PutMapping({"/assignments/{id}"})
/*     */   public ResponseEntity<AssignmentDTO> updateAssignment(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody AssignmentDTO assignmentDTO) throws URISyntaxException {
/*  94 */     this.log.debug("REST request to update Assignment : {}, {}", id, assignmentDTO);
/*  95 */     if (assignmentDTO.getId() == null) {
/*  96 */       throw new BadRequestAlertException("Invalid id", "assignment", "idnull");
/*     */     }
/*  98 */     if (!Objects.equals(id, assignmentDTO.getId())) {
/*  99 */       throw new BadRequestAlertException("Invalid ID", "assignment", "idinvalid");
/*     */     }
/*     */     
/* 102 */     if (!this.assignmentRepository.existsById(id)) {
/* 103 */       throw new BadRequestAlertException("Entity not found", "assignment", "idnotfound");
/*     */     }
/*     */     
/* 106 */     AssignmentDTO result = this.assignmentService.update(assignmentDTO);
/* 107 */     return (
/* 108 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 109 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "assignment", assignmentDTO.getId().toString())))
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
/*     */   @PatchMapping(value = {"/assignments/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<AssignmentDTO> partialUpdateAssignment(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody AssignmentDTO assignmentDTO) throws URISyntaxException {
/* 129 */     this.log.debug("REST request to partial update Assignment partially : {}, {}", id, assignmentDTO);
/* 130 */     if (assignmentDTO.getId() == null) {
/* 131 */       throw new BadRequestAlertException("Invalid id", "assignment", "idnull");
/*     */     }
/* 133 */     if (!Objects.equals(id, assignmentDTO.getId())) {
/* 134 */       throw new BadRequestAlertException("Invalid ID", "assignment", "idinvalid");
/*     */     }
/*     */     
/* 137 */     if (!this.assignmentRepository.existsById(id)) {
/* 138 */       throw new BadRequestAlertException("Entity not found", "assignment", "idnotfound");
/*     */     }
/*     */     
/* 141 */     Optional<AssignmentDTO> result = this.assignmentService.partialUpdate(assignmentDTO);
/*     */     
/* 143 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 145 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "assignment", assignmentDTO.getId().toString()));
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
/*     */   @GetMapping({"/assignments"})
/*     */   public ResponseEntity<List<AssignmentDTO>> getAllAssignments(AssignmentCriteria criteria, @ParameterObject Pageable pageable) {
/* 161 */     this.log.debug("REST request to get Assignments by criteria: {}", criteria);
/* 162 */     Page<AssignmentDTO> page = this.assignmentQueryService.findByCriteria(criteria, pageable);
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
/*     */   @GetMapping({"/assignments/count"})
/*     */   public ResponseEntity<Long> countAssignments(AssignmentCriteria criteria) {
/* 175 */     this.log.debug("REST request to count Assignments by criteria: {}", criteria);
/* 176 */     return ResponseEntity.ok().body(Long.valueOf(this.assignmentQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/assignments/{id}"})
/*     */   public ResponseEntity<AssignmentDTO> getAssignment(@PathVariable Long id) {
/* 187 */     this.log.debug("REST request to get Assignment : {}", id);
/* 188 */     Optional<AssignmentDTO> assignmentDTO = this.assignmentService.findOne(id);
/* 189 */     return ResponseUtil.wrapOrNotFound(assignmentDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/assignments/{id}"})
/*     */   public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
/* 200 */     this.log.debug("REST request to delete Assignment : {}", id);
/* 201 */     this.assignmentService.delete(id);
/* 202 */     return 
/* 203 */       ResponseEntity.noContent()
/* 204 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "assignment", id.toString()))
/* 205 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\AssignmentResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */