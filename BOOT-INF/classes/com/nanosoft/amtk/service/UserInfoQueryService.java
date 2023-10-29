/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Employee_;
/*     */ import com.nanosoft.amtk.domain.UserInfo;
/*     */ import com.nanosoft.amtk.domain.UserInfo_;
/*     */ import com.nanosoft.amtk.domain.User_;
/*     */ import com.nanosoft.amtk.repository.UserInfoRepository;
/*     */ import com.nanosoft.amtk.service.criteria.UserInfoCriteria;
/*     */ import com.nanosoft.amtk.service.dto.UserInfoDTO;
/*     */ import com.nanosoft.amtk.service.mapper.UserInfoMapper;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
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
/*     */ import tech.jhipster.service.filter.RangeFilter;
/*     */ 
/*     */ @Service
/*     */ @Transactional(readOnly = true)
/*     */ public class UserInfoQueryService
/*     */   extends QueryService<UserInfo> {
/*  30 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.UserInfoQueryService.class);
/*     */   
/*     */   private final UserInfoRepository userInfoRepository;
/*     */   
/*     */   private final UserInfoMapper userInfoMapper;
/*     */   
/*     */   public UserInfoQueryService(UserInfoRepository userInfoRepository, UserInfoMapper userInfoMapper) {
/*  37 */     this.userInfoRepository = userInfoRepository;
/*  38 */     this.userInfoMapper = userInfoMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<UserInfoDTO> findByCriteria(UserInfoCriteria criteria) {
/*  48 */     this.log.debug("find by criteria : {}", criteria);
/*  49 */     Specification<UserInfo> specification = createSpecification(criteria);
/*  50 */     return this.userInfoMapper.toDto(this.userInfoRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<UserInfoDTO> findByCriteria(UserInfoCriteria criteria, Pageable page) {
/*  61 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*  62 */     Specification<UserInfo> specification = createSpecification(criteria);
/*  63 */     Objects.requireNonNull(this.userInfoMapper); return this.userInfoRepository.findAll(specification, page).map(this.userInfoMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(UserInfoCriteria criteria) {
/*  73 */     this.log.debug("count by criteria : {}", criteria);
/*  74 */     Specification<UserInfo> specification = createSpecification(criteria);
/*  75 */     return this.userInfoRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<UserInfo> createSpecification(UserInfoCriteria criteria) {
/*  84 */     Specification<UserInfo> specification = Specification.where(null);
/*  85 */     if (criteria != null) {
/*     */       
/*  87 */       if (criteria.getDistinct() != null) {
/*  88 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/*  90 */       if (criteria.getId() != null) {
/*  91 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), UserInfo_.id));
/*     */       }
/*  93 */       if (criteria.getDescription() != null) {
/*  94 */         specification = specification.and(buildStringSpecification(criteria.getDescription(), UserInfo_.description));
/*     */       }
/*  96 */       if (criteria.getCreatedBy() != null) {
/*  97 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), UserInfo_.createdBy));
/*     */       }
/*  99 */       if (criteria.getCreatedDate() != null) {
/* 100 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), UserInfo_.createdDate));
/*     */       }
/* 102 */       if (criteria.getLastModifiedBy() != null) {
/* 103 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), UserInfo_.lastModifiedBy));
/*     */       }
/* 105 */       if (criteria.getLastModifiedDate() != null) {
/* 106 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), UserInfo_.lastModifiedDate));
/*     */       }
/* 108 */       if (criteria.getUserId() != null)
/*     */       {
/* 110 */         specification = specification.and(
/* 111 */             buildSpecification((RangeFilter)criteria.getUserId(), root -> root.join(UserInfo_.user, JoinType.LEFT).get(User_.id)));
/*     */       }
/*     */       
/* 114 */       if (criteria.getUserLogin() != null)
/*     */       {
/* 116 */         specification = specification.and(
/* 117 */             buildSpecification(criteria.getUserLogin(), root -> root.join(UserInfo_.user, JoinType.LEFT).get(User_.login)));
/*     */       }
/*     */       
/* 120 */       if (criteria.getRelatedEmployeeId() != null)
/*     */       {
/* 122 */         specification = specification.and(
/* 123 */             buildSpecification((RangeFilter)criteria
/* 124 */               .getRelatedEmployeeId(), root -> root.join(UserInfo_.relatedEmployee, JoinType.LEFT).get(Employee_.id)));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 130 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\UserInfoQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */