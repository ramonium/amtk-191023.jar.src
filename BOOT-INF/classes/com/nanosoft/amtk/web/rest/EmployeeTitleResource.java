/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.EmployeeTitleRepository;
/*     */ import com.nanosoft.amtk.service.EmployeeTitleQueryService;
/*     */ import com.nanosoft.amtk.service.EmployeeTitleService;
/*     */ import com.nanosoft.amtk.service.criteria.EmployeeTitleCriteria;
/*     */ import com.nanosoft.amtk.service.dto.EmployeeTitleDTO;
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
/*     */ public class EmployeeTitleResource {
/*  36 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.EmployeeTitleResource.class);
/*     */ 
/*     */   
/*     */   private static final String ENTITY_NAME = "employeeTitle";
/*     */ 
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */ 
/*     */   
/*     */   private final EmployeeTitleService employeeTitleService;
/*     */   
/*     */   private final EmployeeTitleRepository employeeTitleRepository;
/*     */   
/*     */   private final EmployeeTitleQueryService employeeTitleQueryService;
/*     */ 
/*     */   
/*     */   public EmployeeTitleResource(EmployeeTitleService employeeTitleService, EmployeeTitleRepository employeeTitleRepository, EmployeeTitleQueryService employeeTitleQueryService) {
/*  54 */     this.employeeTitleService = employeeTitleService;
/*  55 */     this.employeeTitleRepository = employeeTitleRepository;
/*  56 */     this.employeeTitleQueryService = employeeTitleQueryService;
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
/*     */   @PostMapping({"/employee-titles"})
/*     */   public ResponseEntity<EmployeeTitleDTO> createEmployeeTitle(@Valid @RequestBody EmployeeTitleDTO employeeTitleDTO) throws URISyntaxException {
/*  69 */     this.log.debug("REST request to save EmployeeTitle : {}", employeeTitleDTO);
/*  70 */     if (employeeTitleDTO.getId() != null) {
/*  71 */       throw new BadRequestAlertException("A new employeeTitle cannot already have an ID", "employeeTitle", "idexists");
/*     */     }
/*  73 */     EmployeeTitleDTO result = this.employeeTitleService.save(employeeTitleDTO);
/*  74 */     return (
/*  75 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/employee-titles/" + result.getId()))
/*  76 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "employeeTitle", result.getId().toString())))
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
/*     */   @PutMapping({"/employee-titles/{id}"})
/*     */   public ResponseEntity<EmployeeTitleDTO> updateEmployeeTitle(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody EmployeeTitleDTO employeeTitleDTO) throws URISyntaxException {
/*  95 */     this.log.debug("REST request to update EmployeeTitle : {}, {}", id, employeeTitleDTO);
/*  96 */     if (employeeTitleDTO.getId() == null) {
/*  97 */       throw new BadRequestAlertException("Invalid id", "employeeTitle", "idnull");
/*     */     }
/*  99 */     if (!Objects.equals(id, employeeTitleDTO.getId())) {
/* 100 */       throw new BadRequestAlertException("Invalid ID", "employeeTitle", "idinvalid");
/*     */     }
/*     */     
/* 103 */     if (!this.employeeTitleRepository.existsById(id)) {
/* 104 */       throw new BadRequestAlertException("Entity not found", "employeeTitle", "idnotfound");
/*     */     }
/*     */     
/* 107 */     EmployeeTitleDTO result = this.employeeTitleService.update(employeeTitleDTO);
/* 108 */     return (
/* 109 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 110 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "employeeTitle", employeeTitleDTO.getId().toString())))
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
/*     */   @PatchMapping(value = {"/employee-titles/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<EmployeeTitleDTO> partialUpdateEmployeeTitle(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody EmployeeTitleDTO employeeTitleDTO) throws URISyntaxException {
/* 130 */     this.log.debug("REST request to partial update EmployeeTitle partially : {}, {}", id, employeeTitleDTO);
/* 131 */     if (employeeTitleDTO.getId() == null) {
/* 132 */       throw new BadRequestAlertException("Invalid id", "employeeTitle", "idnull");
/*     */     }
/* 134 */     if (!Objects.equals(id, employeeTitleDTO.getId())) {
/* 135 */       throw new BadRequestAlertException("Invalid ID", "employeeTitle", "idinvalid");
/*     */     }
/*     */     
/* 138 */     if (!this.employeeTitleRepository.existsById(id)) {
/* 139 */       throw new BadRequestAlertException("Entity not found", "employeeTitle", "idnotfound");
/*     */     }
/*     */     
/* 142 */     Optional<EmployeeTitleDTO> result = this.employeeTitleService.partialUpdate(employeeTitleDTO);
/*     */     
/* 144 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 146 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "employeeTitle", employeeTitleDTO.getId().toString()));
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
/*     */   @GetMapping({"/employee-titles"})
/*     */   public ResponseEntity<List<EmployeeTitleDTO>> getAllEmployeeTitles(EmployeeTitleCriteria criteria, @ParameterObject Pageable pageable) {
/* 162 */     this.log.debug("REST request to get EmployeeTitles by criteria: {}", criteria);
/* 163 */     Page<EmployeeTitleDTO> page = this.employeeTitleQueryService.findByCriteria(criteria, pageable);
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
/*     */   @GetMapping({"/employee-titles/count"})
/*     */   public ResponseEntity<Long> countEmployeeTitles(EmployeeTitleCriteria criteria) {
/* 176 */     this.log.debug("REST request to count EmployeeTitles by criteria: {}", criteria);
/* 177 */     return ResponseEntity.ok().body(Long.valueOf(this.employeeTitleQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/employee-titles/{id}"})
/*     */   public ResponseEntity<EmployeeTitleDTO> getEmployeeTitle(@PathVariable Long id) {
/* 188 */     this.log.debug("REST request to get EmployeeTitle : {}", id);
/* 189 */     Optional<EmployeeTitleDTO> employeeTitleDTO = this.employeeTitleService.findOne(id);
/* 190 */     return ResponseUtil.wrapOrNotFound(employeeTitleDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/employee-titles/{id}"})
/*     */   public ResponseEntity<Void> deleteEmployeeTitle(@PathVariable Long id) {
/* 201 */     this.log.debug("REST request to delete EmployeeTitle : {}", id);
/* 202 */     this.employeeTitleService.delete(id);
/* 203 */     return 
/* 204 */       ResponseEntity.noContent()
/* 205 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "employeeTitle", id.toString()))
/* 206 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\EmployeeTitleResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */