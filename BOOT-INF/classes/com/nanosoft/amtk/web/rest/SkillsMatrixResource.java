/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.SkillsMatrixRepository;
/*     */ import com.nanosoft.amtk.service.SkillsMatrixQueryService;
/*     */ import com.nanosoft.amtk.service.SkillsMatrixService;
/*     */ import com.nanosoft.amtk.service.criteria.SkillsMatrixCriteria;
/*     */ import com.nanosoft.amtk.service.dto.SkillsMatrixDTO;
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
/*     */ public class SkillsMatrixResource {
/*  37 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.SkillsMatrixResource.class);
/*     */ 
/*     */   
/*     */   private static final String ENTITY_NAME = "skillsMatrix";
/*     */ 
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */ 
/*     */   
/*     */   private final SkillsMatrixService skillsMatrixService;
/*     */   
/*     */   private final SkillsMatrixRepository skillsMatrixRepository;
/*     */   
/*     */   private final SkillsMatrixQueryService skillsMatrixQueryService;
/*     */ 
/*     */   
/*     */   public SkillsMatrixResource(SkillsMatrixService skillsMatrixService, SkillsMatrixRepository skillsMatrixRepository, SkillsMatrixQueryService skillsMatrixQueryService) {
/*  55 */     this.skillsMatrixService = skillsMatrixService;
/*  56 */     this.skillsMatrixRepository = skillsMatrixRepository;
/*  57 */     this.skillsMatrixQueryService = skillsMatrixQueryService;
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
/*     */   @PostMapping({"/skills-matrices"})
/*     */   public ResponseEntity<SkillsMatrixDTO> createSkillsMatrix(@Valid @RequestBody SkillsMatrixDTO skillsMatrixDTO) throws URISyntaxException {
/*  70 */     this.log.debug("REST request to save SkillsMatrix : {}", skillsMatrixDTO);
/*  71 */     if (skillsMatrixDTO.getId() != null) {
/*  72 */       throw new BadRequestAlertException("A new skillsMatrix cannot already have an ID", "skillsMatrix", "idexists");
/*     */     }
/*  74 */     SkillsMatrixDTO result = this.skillsMatrixService.save(skillsMatrixDTO);
/*  75 */     return (
/*  76 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/skills-matrices/" + result.getId()))
/*  77 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "skillsMatrix", result.getId().toString())))
/*  78 */       .body(result);
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
/*     */   @PutMapping({"/skills-matrices/{id}"})
/*     */   public ResponseEntity<SkillsMatrixDTO> updateSkillsMatrix(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody SkillsMatrixDTO skillsMatrixDTO) throws URISyntaxException {
/*  96 */     this.log.debug("REST request to update SkillsMatrix : {}, {}", id, skillsMatrixDTO);
/*  97 */     if (skillsMatrixDTO.getId() == null) {
/*  98 */       throw new BadRequestAlertException("Invalid id", "skillsMatrix", "idnull");
/*     */     }
/* 100 */     if (!Objects.equals(id, skillsMatrixDTO.getId())) {
/* 101 */       throw new BadRequestAlertException("Invalid ID", "skillsMatrix", "idinvalid");
/*     */     }
/*     */     
/* 104 */     if (!this.skillsMatrixRepository.existsById(id)) {
/* 105 */       throw new BadRequestAlertException("Entity not found", "skillsMatrix", "idnotfound");
/*     */     }
/*     */     
/* 108 */     SkillsMatrixDTO result = this.skillsMatrixService.update(skillsMatrixDTO);
/* 109 */     return (
/* 110 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 111 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "skillsMatrix", skillsMatrixDTO.getId().toString())))
/* 112 */       .body(result);
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
/*     */   @PatchMapping(value = {"/skills-matrices/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<SkillsMatrixDTO> partialUpdateSkillsMatrix(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody SkillsMatrixDTO skillsMatrixDTO) throws URISyntaxException {
/* 131 */     this.log.debug("REST request to partial update SkillsMatrix partially : {}, {}", id, skillsMatrixDTO);
/* 132 */     if (skillsMatrixDTO.getId() == null) {
/* 133 */       throw new BadRequestAlertException("Invalid id", "skillsMatrix", "idnull");
/*     */     }
/* 135 */     if (!Objects.equals(id, skillsMatrixDTO.getId())) {
/* 136 */       throw new BadRequestAlertException("Invalid ID", "skillsMatrix", "idinvalid");
/*     */     }
/*     */     
/* 139 */     if (!this.skillsMatrixRepository.existsById(id)) {
/* 140 */       throw new BadRequestAlertException("Entity not found", "skillsMatrix", "idnotfound");
/*     */     }
/*     */     
/* 143 */     Optional<SkillsMatrixDTO> result = this.skillsMatrixService.partialUpdate(skillsMatrixDTO);
/*     */     
/* 145 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 147 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "skillsMatrix", skillsMatrixDTO.getId().toString()));
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
/*     */   @GetMapping({"/skills-matrices"})
/*     */   public ResponseEntity<List<SkillsMatrixDTO>> getAllSkillsMatrices(SkillsMatrixCriteria criteria, @ParameterObject Pageable pageable) {
/* 163 */     this.log.debug("REST request to get SkillsMatrices by criteria: {}", criteria);
/* 164 */     Page<SkillsMatrixDTO> page = this.skillsMatrixQueryService.findByCriteria(criteria, pageable);
/* 165 */     HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders((UriComponentsBuilder)ServletUriComponentsBuilder.fromCurrentRequest(), page);
/* 166 */     return ((ResponseEntity.BodyBuilder)ResponseEntity.ok().headers(headers)).body(page.getContent());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/skills-matrices/count"})
/*     */   public ResponseEntity<Long> countSkillsMatrices(SkillsMatrixCriteria criteria) {
/* 177 */     this.log.debug("REST request to count SkillsMatrices by criteria: {}", criteria);
/* 178 */     return ResponseEntity.ok().body(Long.valueOf(this.skillsMatrixQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/skills-matrices/{id}"})
/*     */   public ResponseEntity<SkillsMatrixDTO> getSkillsMatrix(@PathVariable Long id) {
/* 189 */     this.log.debug("REST request to get SkillsMatrix : {}", id);
/* 190 */     Optional<SkillsMatrixDTO> skillsMatrixDTO = this.skillsMatrixService.findOne(id);
/* 191 */     return ResponseUtil.wrapOrNotFound(skillsMatrixDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/skills-matrices/{id}"})
/*     */   public ResponseEntity<Void> deleteSkillsMatrix(@PathVariable Long id) {
/* 202 */     this.log.debug("REST request to delete SkillsMatrix : {}", id);
/* 203 */     this.skillsMatrixService.delete(id);
/* 204 */     return 
/* 205 */       ResponseEntity.noContent()
/* 206 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "skillsMatrix", id.toString()))
/* 207 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\SkillsMatrixResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */