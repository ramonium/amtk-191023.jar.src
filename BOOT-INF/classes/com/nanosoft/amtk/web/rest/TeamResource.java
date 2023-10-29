/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.TeamRepository;
/*     */ import com.nanosoft.amtk.service.TeamQueryService;
/*     */ import com.nanosoft.amtk.service.TeamService;
/*     */ import com.nanosoft.amtk.service.criteria.TeamCriteria;
/*     */ import com.nanosoft.amtk.service.dto.TeamDTO;
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
/*     */ public class TeamResource {
/*  36 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.TeamResource.class);
/*     */   
/*     */   private static final String ENTITY_NAME = "team";
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */   
/*     */   private final TeamService teamService;
/*     */   
/*     */   private final TeamRepository teamRepository;
/*     */   
/*     */   private final TeamQueryService teamQueryService;
/*     */   
/*     */   public TeamResource(TeamService teamService, TeamRepository teamRepository, TeamQueryService teamQueryService) {
/*  50 */     this.teamService = teamService;
/*  51 */     this.teamRepository = teamRepository;
/*  52 */     this.teamQueryService = teamQueryService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/teams"})
/*     */   public ResponseEntity<TeamDTO> createTeam(@Valid @RequestBody TeamDTO teamDTO) throws URISyntaxException {
/*  64 */     this.log.debug("REST request to save Team : {}", teamDTO);
/*  65 */     if (teamDTO.getId() != null) {
/*  66 */       throw new BadRequestAlertException("A new team cannot already have an ID", "team", "idexists");
/*     */     }
/*  68 */     TeamDTO result = this.teamService.save(teamDTO);
/*  69 */     return (
/*  70 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/teams/" + result.getId()))
/*  71 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "team", result.getId().toString())))
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
/*     */   @PutMapping({"/teams/{id}"})
/*     */   public ResponseEntity<TeamDTO> updateTeam(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody TeamDTO teamDTO) throws URISyntaxException {
/*  90 */     this.log.debug("REST request to update Team : {}, {}", id, teamDTO);
/*  91 */     if (teamDTO.getId() == null) {
/*  92 */       throw new BadRequestAlertException("Invalid id", "team", "idnull");
/*     */     }
/*  94 */     if (!Objects.equals(id, teamDTO.getId())) {
/*  95 */       throw new BadRequestAlertException("Invalid ID", "team", "idinvalid");
/*     */     }
/*     */     
/*  98 */     if (!this.teamRepository.existsById(id)) {
/*  99 */       throw new BadRequestAlertException("Entity not found", "team", "idnotfound");
/*     */     }
/*     */     
/* 102 */     TeamDTO result = this.teamService.update(teamDTO);
/* 103 */     return (
/* 104 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 105 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "team", teamDTO.getId().toString())))
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
/*     */   @PatchMapping(value = {"/teams/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<TeamDTO> partialUpdateTeam(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody TeamDTO teamDTO) throws URISyntaxException {
/* 125 */     this.log.debug("REST request to partial update Team partially : {}, {}", id, teamDTO);
/* 126 */     if (teamDTO.getId() == null) {
/* 127 */       throw new BadRequestAlertException("Invalid id", "team", "idnull");
/*     */     }
/* 129 */     if (!Objects.equals(id, teamDTO.getId())) {
/* 130 */       throw new BadRequestAlertException("Invalid ID", "team", "idinvalid");
/*     */     }
/*     */     
/* 133 */     if (!this.teamRepository.existsById(id)) {
/* 134 */       throw new BadRequestAlertException("Entity not found", "team", "idnotfound");
/*     */     }
/*     */     
/* 137 */     Optional<TeamDTO> result = this.teamService.partialUpdate(teamDTO);
/*     */     
/* 139 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 141 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "team", teamDTO.getId().toString()));
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
/*     */   @GetMapping({"/teams"})
/*     */   public ResponseEntity<List<TeamDTO>> getAllTeams(TeamCriteria criteria, @ParameterObject Pageable pageable) {
/* 157 */     this.log.debug("REST request to get Teams by criteria: {}", criteria);
/* 158 */     Page<TeamDTO> page = this.teamQueryService.findByCriteria(criteria, pageable);
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
/*     */   @GetMapping({"/teams/count"})
/*     */   public ResponseEntity<Long> countTeams(TeamCriteria criteria) {
/* 171 */     this.log.debug("REST request to count Teams by criteria: {}", criteria);
/* 172 */     return ResponseEntity.ok().body(Long.valueOf(this.teamQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/teams/{id}"})
/*     */   public ResponseEntity<TeamDTO> getTeam(@PathVariable Long id) {
/* 183 */     this.log.debug("REST request to get Team : {}", id);
/* 184 */     Optional<TeamDTO> teamDTO = this.teamService.findOne(id);
/* 185 */     return ResponseUtil.wrapOrNotFound(teamDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/teams/{id}"})
/*     */   public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
/* 196 */     this.log.debug("REST request to delete Team : {}", id);
/* 197 */     this.teamService.delete(id);
/* 198 */     return 
/* 199 */       ResponseEntity.noContent()
/* 200 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "team", id.toString()))
/* 201 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\TeamResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */