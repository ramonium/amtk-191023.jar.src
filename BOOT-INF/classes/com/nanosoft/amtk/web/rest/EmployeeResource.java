/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.EmployeeRepository;
/*     */ import com.nanosoft.amtk.service.EmployeeQueryService;
/*     */ import com.nanosoft.amtk.service.EmployeeService;
/*     */ import com.nanosoft.amtk.service.criteria.EmployeeCriteria;
/*     */ import com.nanosoft.amtk.service.dto.EmployeeDTO;
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
/*     */ public class EmployeeResource {
/*  36 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.EmployeeResource.class);
/*     */ 
/*     */   
/*     */   private static final String ENTITY_NAME = "employee";
/*     */ 
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */ 
/*     */   
/*     */   private final EmployeeService employeeService;
/*     */   
/*     */   private final EmployeeRepository employeeRepository;
/*     */   
/*     */   private final EmployeeQueryService employeeQueryService;
/*     */ 
/*     */   
/*     */   public EmployeeResource(EmployeeService employeeService, EmployeeRepository employeeRepository, EmployeeQueryService employeeQueryService) {
/*  54 */     this.employeeService = employeeService;
/*  55 */     this.employeeRepository = employeeRepository;
/*  56 */     this.employeeQueryService = employeeQueryService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/employees"})
/*     */   public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws URISyntaxException {
/*  68 */     this.log.debug("REST request to save Employee : {}", employeeDTO);
/*  69 */     if (employeeDTO.getId() != null) {
/*  70 */       throw new BadRequestAlertException("A new employee cannot already have an ID", "employee", "idexists");
/*     */     }
/*  72 */     EmployeeDTO result = this.employeeService.save(employeeDTO);
/*  73 */     return (
/*  74 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/employees/" + result.getId()))
/*  75 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "employee", result.getId().toString())))
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
/*     */   @PutMapping({"/employees/{id}"})
/*     */   public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody EmployeeDTO employeeDTO) throws URISyntaxException {
/*  94 */     this.log.debug("REST request to update Employee : {}, {}", id, employeeDTO);
/*  95 */     if (employeeDTO.getId() == null) {
/*  96 */       throw new BadRequestAlertException("Invalid id", "employee", "idnull");
/*     */     }
/*  98 */     if (!Objects.equals(id, employeeDTO.getId())) {
/*  99 */       throw new BadRequestAlertException("Invalid ID", "employee", "idinvalid");
/*     */     }
/*     */     
/* 102 */     if (!this.employeeRepository.existsById(id)) {
/* 103 */       throw new BadRequestAlertException("Entity not found", "employee", "idnotfound");
/*     */     }
/*     */     
/* 106 */     EmployeeDTO result = this.employeeService.update(employeeDTO);
/* 107 */     return (
/* 108 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 109 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "employee", employeeDTO.getId().toString())))
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
/*     */   @PatchMapping(value = {"/employees/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<EmployeeDTO> partialUpdateEmployee(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody EmployeeDTO employeeDTO) throws URISyntaxException {
/* 129 */     this.log.debug("REST request to partial update Employee partially : {}, {}", id, employeeDTO);
/* 130 */     if (employeeDTO.getId() == null) {
/* 131 */       throw new BadRequestAlertException("Invalid id", "employee", "idnull");
/*     */     }
/* 133 */     if (!Objects.equals(id, employeeDTO.getId())) {
/* 134 */       throw new BadRequestAlertException("Invalid ID", "employee", "idinvalid");
/*     */     }
/*     */     
/* 137 */     if (!this.employeeRepository.existsById(id)) {
/* 138 */       throw new BadRequestAlertException("Entity not found", "employee", "idnotfound");
/*     */     }
/*     */     
/* 141 */     Optional<EmployeeDTO> result = this.employeeService.partialUpdate(employeeDTO);
/*     */     
/* 143 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 145 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "employee", employeeDTO.getId().toString()));
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
/*     */   @GetMapping({"/employees"})
/*     */   public ResponseEntity<List<EmployeeDTO>> getAllEmployees(EmployeeCriteria criteria, @ParameterObject Pageable pageable) {
/* 161 */     this.log.debug("REST request to get Employees by criteria: {}", criteria);
/* 162 */     Page<EmployeeDTO> page = this.employeeQueryService.findByCriteria(criteria, pageable);
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
/*     */   @GetMapping({"/employees/count"})
/*     */   public ResponseEntity<Long> countEmployees(EmployeeCriteria criteria) {
/* 175 */     this.log.debug("REST request to count Employees by criteria: {}", criteria);
/* 176 */     return ResponseEntity.ok().body(Long.valueOf(this.employeeQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/employees/{id}"})
/*     */   public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long id) {
/* 187 */     this.log.debug("REST request to get Employee : {}", id);
/* 188 */     Optional<EmployeeDTO> employeeDTO = this.employeeService.findOne(id);
/* 189 */     return ResponseUtil.wrapOrNotFound(employeeDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/employees/{id}"})
/*     */   public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
/* 200 */     this.log.debug("REST request to delete Employee : {}", id);
/* 201 */     this.employeeService.delete(id);
/* 202 */     return 
/* 203 */       ResponseEntity.noContent()
/* 204 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "employee", id.toString()))
/* 205 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\EmployeeResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */