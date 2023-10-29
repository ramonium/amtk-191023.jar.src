/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.AreaRepository;
/*     */ import com.nanosoft.amtk.service.AreaQueryService;
/*     */ import com.nanosoft.amtk.service.AreaService;
/*     */ import com.nanosoft.amtk.service.criteria.AreaCriteria;
/*     */ import com.nanosoft.amtk.service.dto.AreaDTO;
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
/*     */ public class AreaResource {
/*  36 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.AreaResource.class);
/*     */   
/*     */   private static final String ENTITY_NAME = "area";
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */   
/*     */   private final AreaService areaService;
/*     */   
/*     */   private final AreaRepository areaRepository;
/*     */   
/*     */   private final AreaQueryService areaQueryService;
/*     */   
/*     */   public AreaResource(AreaService areaService, AreaRepository areaRepository, AreaQueryService areaQueryService) {
/*  50 */     this.areaService = areaService;
/*  51 */     this.areaRepository = areaRepository;
/*  52 */     this.areaQueryService = areaQueryService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/areas"})
/*     */   public ResponseEntity<AreaDTO> createArea(@Valid @RequestBody AreaDTO areaDTO) throws URISyntaxException {
/*  64 */     this.log.debug("REST request to save Area : {}", areaDTO);
/*  65 */     if (areaDTO.getId() != null) {
/*  66 */       throw new BadRequestAlertException("A new area cannot already have an ID", "area", "idexists");
/*     */     }
/*  68 */     AreaDTO result = this.areaService.save(areaDTO);
/*  69 */     return (
/*  70 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/areas/" + result.getId()))
/*  71 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "area", result.getId().toString())))
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
/*     */   @PutMapping({"/areas/{id}"})
/*     */   public ResponseEntity<AreaDTO> updateArea(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody AreaDTO areaDTO) throws URISyntaxException {
/*  90 */     this.log.debug("REST request to update Area : {}, {}", id, areaDTO);
/*  91 */     if (areaDTO.getId() == null) {
/*  92 */       throw new BadRequestAlertException("Invalid id", "area", "idnull");
/*     */     }
/*  94 */     if (!Objects.equals(id, areaDTO.getId())) {
/*  95 */       throw new BadRequestAlertException("Invalid ID", "area", "idinvalid");
/*     */     }
/*     */     
/*  98 */     if (!this.areaRepository.existsById(id)) {
/*  99 */       throw new BadRequestAlertException("Entity not found", "area", "idnotfound");
/*     */     }
/*     */     
/* 102 */     AreaDTO result = this.areaService.update(areaDTO);
/* 103 */     return (
/* 104 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 105 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "area", areaDTO.getId().toString())))
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
/*     */   @PatchMapping(value = {"/areas/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<AreaDTO> partialUpdateArea(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody AreaDTO areaDTO) throws URISyntaxException {
/* 125 */     this.log.debug("REST request to partial update Area partially : {}, {}", id, areaDTO);
/* 126 */     if (areaDTO.getId() == null) {
/* 127 */       throw new BadRequestAlertException("Invalid id", "area", "idnull");
/*     */     }
/* 129 */     if (!Objects.equals(id, areaDTO.getId())) {
/* 130 */       throw new BadRequestAlertException("Invalid ID", "area", "idinvalid");
/*     */     }
/*     */     
/* 133 */     if (!this.areaRepository.existsById(id)) {
/* 134 */       throw new BadRequestAlertException("Entity not found", "area", "idnotfound");
/*     */     }
/*     */     
/* 137 */     Optional<AreaDTO> result = this.areaService.partialUpdate(areaDTO);
/*     */     
/* 139 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 141 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "area", areaDTO.getId().toString()));
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
/*     */   @GetMapping({"/areas"})
/*     */   public ResponseEntity<List<AreaDTO>> getAllAreas(AreaCriteria criteria, @ParameterObject Pageable pageable) {
/* 157 */     this.log.debug("REST request to get Areas by criteria: {}", criteria);
/* 158 */     Page<AreaDTO> page = this.areaQueryService.findByCriteria(criteria, pageable);
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
/*     */   @GetMapping({"/areas/count"})
/*     */   public ResponseEntity<Long> countAreas(AreaCriteria criteria) {
/* 171 */     this.log.debug("REST request to count Areas by criteria: {}", criteria);
/* 172 */     return ResponseEntity.ok().body(Long.valueOf(this.areaQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/areas/{id}"})
/*     */   public ResponseEntity<AreaDTO> getArea(@PathVariable Long id) {
/* 183 */     this.log.debug("REST request to get Area : {}", id);
/* 184 */     Optional<AreaDTO> areaDTO = this.areaService.findOne(id);
/* 185 */     return ResponseUtil.wrapOrNotFound(areaDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/areas/{id}"})
/*     */   public ResponseEntity<Void> deleteArea(@PathVariable Long id) {
/* 196 */     this.log.debug("REST request to delete Area : {}", id);
/* 197 */     this.areaService.delete(id);
/* 198 */     return 
/* 199 */       ResponseEntity.noContent()
/* 200 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "area", id.toString()))
/* 201 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\AreaResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */