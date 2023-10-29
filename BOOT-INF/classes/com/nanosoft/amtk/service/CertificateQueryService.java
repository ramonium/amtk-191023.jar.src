/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ import com.nanosoft.amtk.domain.Assignment_;
/*     */ import com.nanosoft.amtk.domain.Certificate;
/*     */ import com.nanosoft.amtk.domain.Certificate_;
/*     */ import com.nanosoft.amtk.domain.CertificationLevel_;
/*     */ import com.nanosoft.amtk.domain.Checklist_;
/*     */ import com.nanosoft.amtk.domain.Employee_;
/*     */ import com.nanosoft.amtk.domain.Team_;
/*     */ import com.nanosoft.amtk.repository.CertificateRepository;
/*     */ import com.nanosoft.amtk.security.SecurityUtils;
/*     */ import com.nanosoft.amtk.service.TeamQueryService;
/*     */ import com.nanosoft.amtk.service.UserInfoQueryService;
/*     */ import com.nanosoft.amtk.service.criteria.CertificateCriteria;
/*     */ import com.nanosoft.amtk.service.criteria.UserInfoCriteria;
/*     */ import com.nanosoft.amtk.service.dto.CertificateDTO;
/*     */ import com.nanosoft.amtk.service.dto.UserInfoDTO;
/*     */ import com.nanosoft.amtk.service.mapper.CertificateMapper;
/*     */ import java.util.List;
/*     */ import javax.persistence.criteria.Expression;
/*     */ import javax.persistence.criteria.JoinType;
/*     */ import javax.persistence.criteria.Root;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.Pageable;
/*     */ import org.springframework.data.jpa.domain.Specification;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import tech.jhipster.service.QueryService;
/*     */ import tech.jhipster.service.filter.Filter;
/*     */ import tech.jhipster.service.filter.LongFilter;
/*     */ import tech.jhipster.service.filter.RangeFilter;
/*     */ import tech.jhipster.service.filter.StringFilter;
/*     */ 
/*     */ @Service
/*     */ @Transactional(readOnly = true)
/*     */ public class CertificateQueryService extends QueryService<Certificate> {
/*  38 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.CertificateQueryService.class);
/*     */ 
/*     */   
/*     */   private final CertificateRepository certificateRepository;
/*     */ 
/*     */   
/*     */   private final CertificateMapper certificateMapper;
/*     */ 
/*     */   
/*     */   private final UserInfoQueryService userInfoQueryService;
/*     */ 
/*     */   
/*     */   private final TeamQueryService teamQueryService;
/*     */ 
/*     */   
/*     */   public CertificateQueryService(CertificateRepository certificateRepository, CertificateMapper certificateMapper, UserInfoQueryService userInfoQueryService, TeamQueryService teamQueryService) {
/*  54 */     this.certificateRepository = certificateRepository;
/*  55 */     this.certificateMapper = certificateMapper;
/*  56 */     this.userInfoQueryService = userInfoQueryService;
/*  57 */     this.teamQueryService = teamQueryService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<CertificateDTO> findByCriteria(CertificateCriteria criteria) {
/*  67 */     this.log.debug("find by criteria : {}", criteria);
/*  68 */     Specification<Certificate> specification = createSpecification(criteria);
/*  69 */     return this.certificateMapper.toDto(this.certificateRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<CertificateDTO> findByCriteria(CertificateCriteria criteria, Pageable page) {
/*  80 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*     */     
/*  82 */     StringFilter stringFilter = new StringFilter();
/*  83 */     stringFilter.setEquals(SecurityUtils.getCurrentUserLogin().get());
/*  84 */     UserInfoCriteria userInfoCriteria = new UserInfoCriteria();
/*  85 */     userInfoCriteria.setUserLogin(stringFilter);
/*  86 */     List<UserInfoDTO> userInfos = this.userInfoQueryService.findByCriteria(userInfoCriteria);
/*     */     
/*  88 */     if (userInfos.size() > 0) {
/*  89 */       UserInfoDTO userInfo = userInfos.get(0);
/*     */       
/*  91 */       if (userInfo.getRelatedEmployee().getTitle().getCanSupervise().booleanValue()) {
/*  92 */         LongFilter supervisorId = new LongFilter();
/*  93 */         supervisorId.setEquals(userInfo.getRelatedEmployee().getId());
/*  94 */         criteria.setSupervisorId(supervisorId);
/*     */       } 
/*     */     } 
/*     */     
/*  98 */     Specification<Certificate> specification = createSpecification(criteria);
/*  99 */     Objects.requireNonNull(this.certificateMapper); return this.certificateRepository.findAll(specification, page).map(this.certificateMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(CertificateCriteria criteria) {
/* 109 */     this.log.debug("count by criteria : {}", criteria);
/* 110 */     Specification<Certificate> specification = createSpecification(criteria);
/* 111 */     return this.certificateRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<Certificate> createSpecification(CertificateCriteria criteria) {
/* 120 */     Specification<Certificate> specification = Specification.where(null);
/* 121 */     if (criteria != null) {
/*     */       
/* 123 */       if (criteria.getDistinct() != null) {
/* 124 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/* 126 */       if (criteria.getId() != null) {
/* 127 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), Certificate_.id));
/*     */       }
/* 129 */       if (criteria.getStatus() != null) {
/* 130 */         specification = specification.and(buildSpecification((Filter)criteria.getStatus(), Certificate_.status));
/*     */       }
/* 132 */       if (criteria.getStartDate() != null) {
/* 133 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getStartDate(), Certificate_.startDate));
/*     */       }
/* 135 */       if (criteria.getExpectedEndDate() != null) {
/* 136 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getExpectedEndDate(), Certificate_.expectedEndDate));
/*     */       }
/* 138 */       if (criteria.getEndDate() != null) {
/* 139 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getEndDate(), Certificate_.endDate));
/*     */       }
/* 141 */       if (criteria.getValidated() != null) {
/* 142 */         specification = specification.and(buildSpecification((Filter)criteria.getValidated(), Certificate_.validated));
/*     */       }
/* 144 */       if (criteria.getIsRecycling() != null) {
/* 145 */         specification = specification.and(buildSpecification((Filter)criteria.getIsRecycling(), Certificate_.isRecycling));
/*     */       }
/* 147 */       if (criteria.getCreatedBy() != null) {
/* 148 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), Certificate_.createdBy));
/*     */       }
/* 150 */       if (criteria.getCreatedDate() != null) {
/* 151 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), Certificate_.createdDate));
/*     */       }
/* 153 */       if (criteria.getLastModifiedBy() != null) {
/* 154 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), Certificate_.lastModifiedBy));
/*     */       }
/* 156 */       if (criteria.getLastModifiedDate() != null) {
/* 157 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), Certificate_.lastModifiedDate));
/*     */       }
/* 159 */       if (criteria.getAssignmentId() != null)
/*     */       {
/* 161 */         specification = specification.and(
/* 162 */             buildSpecification((RangeFilter)criteria
/* 163 */               .getAssignmentId(), root -> root.join(Certificate_.assignment, JoinType.LEFT).get(Assignment_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 168 */       if (criteria.getForAssigmentId() != null)
/*     */       {
/* 170 */         specification = specification.and(
/* 171 */             buildSpecification((RangeFilter)criteria
/* 172 */               .getForAssigmentId(), root -> root.join(Certificate_.forAssigment, JoinType.LEFT).get(Assignment_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 177 */       if (criteria.getSupervisorId() != null)
/*     */       {
/* 179 */         specification = specification.and(
/* 180 */             buildSpecification((RangeFilter)criteria
/* 181 */               .getSupervisorId(), root -> root.join(Certificate_.assignment, JoinType.LEFT).join(Assignment_.employee, JoinType.LEFT).join(Employee_.team, JoinType.LEFT).join(Team_.supervisor, JoinType.LEFT).get(Employee_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 192 */       if (criteria.getLevelId() != null)
/*     */       {
/* 194 */         specification = specification.and(
/* 195 */             buildSpecification((RangeFilter)criteria
/* 196 */               .getLevelId(), root -> root.join(Certificate_.level, JoinType.LEFT).get(CertificationLevel_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 201 */       if (criteria.getChecklistId() != null)
/*     */       {
/* 203 */         specification = specification.and(
/* 204 */             buildSpecification((RangeFilter)criteria
/* 205 */               .getChecklistId(), root -> root.join(Certificate_.checklist, JoinType.LEFT).get(Checklist_.id)));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 211 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\CertificateQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */