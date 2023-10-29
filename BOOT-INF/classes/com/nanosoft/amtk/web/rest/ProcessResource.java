/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.ProcessRepository;
/*     */ import com.nanosoft.amtk.service.ProcessQueryService;
/*     */ import com.nanosoft.amtk.service.ProcessService;
/*     */ import com.nanosoft.amtk.service.criteria.ProcessCriteria;
/*     */ import com.nanosoft.amtk.service.dto.ProcessDTO;
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
/*     */ public class ProcessResource {
/*  36 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.ProcessResource.class);
/*     */   
/*     */   private static final String ENTITY_NAME = "process";
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */   
/*     */   private final ProcessService processService;
/*     */   
/*     */   private final ProcessRepository processRepository;
/*     */   
/*     */   private final ProcessQueryService processQueryService;
/*     */   
/*     */   public ProcessResource(ProcessService processService, ProcessRepository processRepository, ProcessQueryService processQueryService) {
/*  50 */     this.processService = processService;
/*  51 */     this.processRepository = processRepository;
/*  52 */     this.processQueryService = processQueryService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/processes"})
/*     */   public ResponseEntity<ProcessDTO> createProcess(@Valid @RequestBody ProcessDTO processDTO) throws URISyntaxException {
/*  64 */     this.log.debug("REST request to save Process : {}", processDTO);
/*  65 */     if (processDTO.getId() != null) {
/*  66 */       throw new BadRequestAlertException("A new process cannot already have an ID", "process", "idexists");
/*     */     }
/*  68 */     ProcessDTO result = this.processService.save(processDTO);
/*  69 */     return (
/*  70 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/processes/" + result.getId()))
/*  71 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "process", result.getId().toString())))
/*  72 */       .body(result);
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
/*     */   @PutMapping({"/processes/{id}"})
/*     */   public ResponseEntity<ProcessDTO> updateProcess(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody ProcessDTO processDTO) throws URISyntaxException {
/*  90 */     this.log.debug("REST request to update Process : {}, {}", id, processDTO);
/*  91 */     if (processDTO.getId() == null) {
/*  92 */       throw new BadRequestAlertException("Invalid id", "process", "idnull");
/*     */     }
/*  94 */     if (!Objects.equals(id, processDTO.getId())) {
/*  95 */       throw new BadRequestAlertException("Invalid ID", "process", "idinvalid");
/*     */     }
/*     */     
/*  98 */     if (!this.processRepository.existsById(id)) {
/*  99 */       throw new BadRequestAlertException("Entity not found", "process", "idnotfound");
/*     */     }
/*     */     
/* 102 */     ProcessDTO result = this.processService.update(processDTO);
/* 103 */     return (
/* 104 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 105 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "process", processDTO.getId().toString())))
/* 106 */       .body(result);
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
/*     */   @PatchMapping(value = {"/processes/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<ProcessDTO> partialUpdateProcess(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody ProcessDTO processDTO) throws URISyntaxException {
/* 125 */     this.log.debug("REST request to partial update Process partially : {}, {}", id, processDTO);
/* 126 */     if (processDTO.getId() == null) {
/* 127 */       throw new BadRequestAlertException("Invalid id", "process", "idnull");
/*     */     }
/* 129 */     if (!Objects.equals(id, processDTO.getId())) {
/* 130 */       throw new BadRequestAlertException("Invalid ID", "process", "idinvalid");
/*     */     }
/*     */     
/* 133 */     if (!this.processRepository.existsById(id)) {
/* 134 */       throw new BadRequestAlertException("Entity not found", "process", "idnotfound");
/*     */     }
/*     */     
/* 137 */     Optional<ProcessDTO> result = this.processService.partialUpdate(processDTO);
/*     */     
/* 139 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 141 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "process", processDTO.getId().toString()));
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
/*     */   @GetMapping({"/processes"})
/*     */   public ResponseEntity<List<ProcessDTO>> getAllProcesses(ProcessCriteria criteria, @ParameterObject Pageable pageable) {
/* 157 */     this.log.debug("REST request to get Processes by criteria: {}", criteria);
/* 158 */     Page<ProcessDTO> page = this.processQueryService.findByCriteria(criteria, pageable);
/* 159 */     HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders((UriComponentsBuilder)ServletUriComponentsBuilder.fromCurrentRequest(), page);
/* 160 */     return ((ResponseEntity.BodyBuilder)ResponseEntity.ok().headers(headers)).body(page.getContent());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/processes/count"})
/*     */   public ResponseEntity<Long> countProcesses(ProcessCriteria criteria) {
/* 171 */     this.log.debug("REST request to count Processes by criteria: {}", criteria);
/* 172 */     return ResponseEntity.ok().body(Long.valueOf(this.processQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/processes/{id}"})
/*     */   public ResponseEntity<ProcessDTO> getProcess(@PathVariable Long id) {
/* 183 */     this.log.debug("REST request to get Process : {}", id);
/* 184 */     Optional<ProcessDTO> processDTO = this.processService.findOne(id);
/* 185 */     return ResponseUtil.wrapOrNotFound(processDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/processes/{id}"})
/*     */   public ResponseEntity<Void> deleteProcess(@PathVariable Long id) {
/* 196 */     this.log.debug("REST request to delete Process : {}", id);
/* 197 */     this.processService.delete(id);
/* 198 */     return 
/* 199 */       ResponseEntity.noContent()
/* 200 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "process", id.toString()))
/* 201 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\ProcessResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */