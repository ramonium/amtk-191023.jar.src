/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest;
/*     */ import com.nanosoft.amtk.repository.UserInfoRepository;
/*     */ import com.nanosoft.amtk.service.UserInfoQueryService;
/*     */ import com.nanosoft.amtk.service.UserInfoService;
/*     */ import com.nanosoft.amtk.service.criteria.UserInfoCriteria;
/*     */ import com.nanosoft.amtk.service.dto.UserInfoDTO;
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
/*     */ public class UserInfoResource {
/*  36 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.web.rest.UserInfoResource.class);
/*     */ 
/*     */   
/*     */   private static final String ENTITY_NAME = "userInfo";
/*     */ 
/*     */   
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName;
/*     */ 
/*     */   
/*     */   private final UserInfoService userInfoService;
/*     */   
/*     */   private final UserInfoRepository userInfoRepository;
/*     */   
/*     */   private final UserInfoQueryService userInfoQueryService;
/*     */ 
/*     */   
/*     */   public UserInfoResource(UserInfoService userInfoService, UserInfoRepository userInfoRepository, UserInfoQueryService userInfoQueryService) {
/*  54 */     this.userInfoService = userInfoService;
/*  55 */     this.userInfoRepository = userInfoRepository;
/*  56 */     this.userInfoQueryService = userInfoQueryService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/user-infos"})
/*     */   public ResponseEntity<UserInfoDTO> createUserInfo(@Valid @RequestBody UserInfoDTO userInfoDTO) throws URISyntaxException {
/*  68 */     this.log.debug("REST request to save UserInfo : {}", userInfoDTO);
/*  69 */     if (userInfoDTO.getId() != null) {
/*  70 */       throw new BadRequestAlertException("A new userInfo cannot already have an ID", "userInfo", "idexists");
/*     */     }
/*  72 */     UserInfoDTO result = this.userInfoService.save(userInfoDTO);
/*  73 */     return (
/*  74 */       (ResponseEntity.BodyBuilder)ResponseEntity.created(new URI("/api/user-infos/" + result.getId()))
/*  75 */       .headers(HeaderUtil.createEntityCreationAlert(this.applicationName, true, "userInfo", result.getId().toString())))
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
/*     */   @PutMapping({"/user-infos/{id}"})
/*     */   public ResponseEntity<UserInfoDTO> updateUserInfo(@PathVariable(value = "id", required = false) Long id, @Valid @RequestBody UserInfoDTO userInfoDTO) throws URISyntaxException {
/*  94 */     this.log.debug("REST request to update UserInfo : {}, {}", id, userInfoDTO);
/*  95 */     if (userInfoDTO.getId() == null) {
/*  96 */       throw new BadRequestAlertException("Invalid id", "userInfo", "idnull");
/*     */     }
/*  98 */     if (!Objects.equals(id, userInfoDTO.getId())) {
/*  99 */       throw new BadRequestAlertException("Invalid ID", "userInfo", "idinvalid");
/*     */     }
/*     */     
/* 102 */     if (!this.userInfoRepository.existsById(id)) {
/* 103 */       throw new BadRequestAlertException("Entity not found", "userInfo", "idnotfound");
/*     */     }
/*     */     
/* 106 */     UserInfoDTO result = this.userInfoService.update(userInfoDTO);
/* 107 */     return (
/* 108 */       (ResponseEntity.BodyBuilder)ResponseEntity.ok()
/* 109 */       .headers(HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "userInfo", userInfoDTO.getId().toString())))
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
/*     */   @PatchMapping(value = {"/user-infos/{id}"}, consumes = {"application/json", "application/merge-patch+json"})
/*     */   public ResponseEntity<UserInfoDTO> partialUpdateUserInfo(@PathVariable(value = "id", required = false) Long id, @NotNull @RequestBody UserInfoDTO userInfoDTO) throws URISyntaxException {
/* 129 */     this.log.debug("REST request to partial update UserInfo partially : {}, {}", id, userInfoDTO);
/* 130 */     if (userInfoDTO.getId() == null) {
/* 131 */       throw new BadRequestAlertException("Invalid id", "userInfo", "idnull");
/*     */     }
/* 133 */     if (!Objects.equals(id, userInfoDTO.getId())) {
/* 134 */       throw new BadRequestAlertException("Invalid ID", "userInfo", "idinvalid");
/*     */     }
/*     */     
/* 137 */     if (!this.userInfoRepository.existsById(id)) {
/* 138 */       throw new BadRequestAlertException("Entity not found", "userInfo", "idnotfound");
/*     */     }
/*     */     
/* 141 */     Optional<UserInfoDTO> result = this.userInfoService.partialUpdate(userInfoDTO);
/*     */     
/* 143 */     return ResponseUtil.wrapOrNotFound(result, 
/*     */         
/* 145 */         HeaderUtil.createEntityUpdateAlert(this.applicationName, true, "userInfo", userInfoDTO.getId().toString()));
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
/*     */   @GetMapping({"/user-infos"})
/*     */   public ResponseEntity<List<UserInfoDTO>> getAllUserInfos(UserInfoCriteria criteria, @ParameterObject Pageable pageable) {
/* 161 */     this.log.debug("REST request to get UserInfos by criteria: {}", criteria);
/* 162 */     Page<UserInfoDTO> page = this.userInfoQueryService.findByCriteria(criteria, pageable);
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
/*     */   @GetMapping({"/user-infos/count"})
/*     */   public ResponseEntity<Long> countUserInfos(UserInfoCriteria criteria) {
/* 175 */     this.log.debug("REST request to count UserInfos by criteria: {}", criteria);
/* 176 */     return ResponseEntity.ok().body(Long.valueOf(this.userInfoQueryService.countByCriteria(criteria)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/user-infos/{id}"})
/*     */   public ResponseEntity<UserInfoDTO> getUserInfo(@PathVariable Long id) {
/* 187 */     this.log.debug("REST request to get UserInfo : {}", id);
/* 188 */     Optional<UserInfoDTO> userInfoDTO = this.userInfoService.findOne(id);
/* 189 */     return ResponseUtil.wrapOrNotFound(userInfoDTO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/user-infos/{id}"})
/*     */   public ResponseEntity<Void> deleteUserInfo(@PathVariable Long id) {
/* 200 */     this.log.debug("REST request to delete UserInfo : {}", id);
/* 201 */     this.userInfoService.delete(id);
/* 202 */     return 
/* 203 */       ResponseEntity.noContent()
/* 204 */       .headers(HeaderUtil.createEntityDeletionAlert(this.applicationName, true, "userInfo", id.toString()))
/* 205 */       .build();
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\UserInfoResource.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */