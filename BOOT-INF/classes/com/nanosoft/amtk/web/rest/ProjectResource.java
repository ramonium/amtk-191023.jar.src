/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.ProjectRepository;
/*     */ import com.nanosoft.amtk.service.ProjectQueryService;
/*     */ import com.nanosoft.amtk.service.ProjectService;
/*     */ import com.nanosoft.amtk.service.criteria.ProjectCriteria;
/*     */ import com.nanosoft.amtk.service.dto.ProjectDTO;
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
/*     */ public class ProjectResource {
/*  36 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.ProjectResource.class);
/*     */   
/*     */   private static final String ENTITY_NAME = "project";
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */   
/*     */   private final ProjectService projectService;
/*     */   
/*     */   private final ProjectRepository projectRepository;
/*     */   
/*     */   private final ProjectQueryService projectQueryService;
/*     */   
/*     */   public ProjectResource(ProjectService projectService, ProjectRepository projectRepository, ProjectQueryService projectQueryService) {
/*  50 */     this.projectService = projectService;
/*  51 */     this.projectRepository = projectRepository;
/*  52 */     this.projectQueryService = projectQueryService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/projects"})
/*     */   public ResponseEntity<ProjectDTO> createProject(@Valid @RequestBody ProjectDTO projectDTO) throws URISyntaxException {
/*  64 */     this.log.debug("REST request to save Project : {}", projectDTO);
/*  65 */     if (projectDTO.getId() != null) {
/*  66 */       throw new BadRequestAlertException("A new project cannot already have an ID", "project", "idexists");
/*     */     }
/*  68 */     ProjectDTO result = this.projectService.save(projectDTO);
/*  69 */     return (
/*  70 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/projects/" + result.getId()))
/*  71 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "project", result.getId().toString())))
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
/*     */   @PutMapping({"/projects/{id}"})
/*     */   public ResponseEntity<ProjectDTO> updateProject(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody ProjectDTO projectDTO) throws URISyntaxException {
/*  90 */     this.log.debug("REST request to update Project : {}, {}", id, projectDTO);
/*  91 */     if (projectDTO.getId() == null) {
/*  92 */       throw new BadRequestAlertException("Invalid id", "project", "idnull");
/*     */     }
/*  94 */     if (!Objects.equals(id, projectDTO.getId())) {
/*  95 */       throw new BadRequestAlertException("Invalid ID", "project", "idinvalid");
/*     */     }
/*     */     
/*  98 */     if (!this.projectRepository.existsById(id)) {
/*  99 */       throw new BadRequestAlertException("Entity not found", "project", "idnotfound");
/*     */     }
/*     */     
/* 102 */     ProjectDTO result = this.projectService.update(projectDTO);
/* 103 */     return (
/* 104 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 105 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "project", projectDTO.getId().toString())))
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
/*     */   @PatchMapping(value = {"/projects/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<ProjectDTO> partialUpdateProject(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody ProjectDTO projectDTO) throws URISyntaxException {
/* 125 */     this.log.debug("REST request to partial update Project partially : {}, {}", id, projectDTO);
/* 126 */     if (projectDTO.getId() == null) {
/* 127 */       throw new BadRequestAlertException("Invalid id", "project", "idnull");
/*     */     }
/* 129 */     if (!Objects.equals(id, projectDTO.getId())) {
/* 130 */       throw new BadRequestAlertException("Invalid ID", "project", "idinvalid");
/*     */     }
/*     */     
/* 133 */     if (!this.projectRepository.existsById(id)) {
/* 134 */       throw new BadRequestAlertException("Entity not found", "project", "idnotfound");
/*     */     }
/*     */     
/* 137 */     Optional<ProjectDTO> result = this.projectService.partialUpdate(projectDTO);
/*     */     
/* 139 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 141 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "project", projectDTO.getId().toString()));
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
/*     */   @GetMapping({"/projects"})
/*     */   public ResponseEntity<List<ProjectDTO>> getAllProjects(ProjectCriteria criteria, @ParameterObject Pageable pageable) {
/* 157 */     this.log.debug("REST request to get Projects by criteria: {}", criteria);
/* 158 */     Page<ProjectDTO> page = this.projectQueryService.findByCriteria(criteria, pageable);
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
/*     */   @GetMapping({"/projects/count"})
/*     */   public ResponseEntity<Long> countProjects(ProjectCriteria criteria) {
/* 171 */     this.log.debug("REST request to count Projects by criteria: {}", criteria);
/* 172 */     return ResponseEntity.ok().body(Long.valueOf(this.projectQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/projects/{id}"})
/*     */   public ResponseEntity<ProjectDTO> getProject(@PathVariable Long id) {
/* 183 */     this.log.debug("REST request to get Project : {}", id);
/* 184 */     Optional<ProjectDTO> projectDTO = this.projectService.findOne(id);
/* 185 */     return ResponseUtil.wrapOrNotFound(projectDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/projects/{id}"})
/*     */   public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
/* 196 */     this.log.debug("REST request to delete Project : {}", id);
/* 197 */     this.projectService.delete(id);
/* 198 */     return 
/* 199 */       ResponseEntity.noContent()
/* 200 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "project", id.toString()))
/* 201 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\ProjectResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */