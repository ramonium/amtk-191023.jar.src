/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Project_;
/*     */ import com.nanosoft.amtk.domain.SkillsMatrix;
/*     */ import com.nanosoft.amtk.domain.SkillsMatrix_;
/*     */ import com.nanosoft.amtk.repository.SkillsMatrixRepository;
/*     */ import com.nanosoft.amtk.service.criteria.SkillsMatrixCriteria;
/*     */ import com.nanosoft.amtk.service.dto.SkillsMatrixDTO;
/*     */ import com.nanosoft.amtk.service.mapper.SkillsMatrixMapper;
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
/*     */ public class SkillsMatrixQueryService
/*     */   extends QueryService<SkillsMatrix>
/*     */ {
/*  30 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.SkillsMatrixQueryService.class);
/*     */   
/*     */   private final SkillsMatrixRepository skillsMatrixRepository;
/*     */   
/*     */   private final SkillsMatrixMapper skillsMatrixMapper;
/*     */   
/*     */   public SkillsMatrixQueryService(SkillsMatrixRepository skillsMatrixRepository, SkillsMatrixMapper skillsMatrixMapper) {
/*  37 */     this.skillsMatrixRepository = skillsMatrixRepository;
/*  38 */     this.skillsMatrixMapper = skillsMatrixMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<SkillsMatrixDTO> findByCriteria(SkillsMatrixCriteria criteria) {
/*  48 */     this.log.debug("find by criteria : {}", criteria);
/*  49 */     Specification<SkillsMatrix> specification = createSpecification(criteria);
/*  50 */     return this.skillsMatrixMapper.toDto(this.skillsMatrixRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<SkillsMatrixDTO> findByCriteria(SkillsMatrixCriteria criteria, Pageable page) {
/*  61 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*  62 */     Specification<SkillsMatrix> specification = createSpecification(criteria);
/*  63 */     Objects.requireNonNull(this.skillsMatrixMapper); return this.skillsMatrixRepository.findAll(specification, page).map(this.skillsMatrixMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(SkillsMatrixCriteria criteria) {
/*  73 */     this.log.debug("count by criteria : {}", criteria);
/*  74 */     Specification<SkillsMatrix> specification = createSpecification(criteria);
/*  75 */     return this.skillsMatrixRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<SkillsMatrix> createSpecification(SkillsMatrixCriteria criteria) {
/*  84 */     Specification<SkillsMatrix> specification = Specification.where(null);
/*  85 */     if (criteria != null) {
/*     */       
/*  87 */       if (criteria.getDistinct() != null) {
/*  88 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/*  90 */       if (criteria.getId() != null) {
/*  91 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), SkillsMatrix_.id));
/*     */       }
/*  93 */       if (criteria.getCreatedBy() != null) {
/*  94 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), SkillsMatrix_.createdBy));
/*     */       }
/*  96 */       if (criteria.getCreatedDate() != null) {
/*  97 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), SkillsMatrix_.createdDate));
/*     */       }
/*  99 */       if (criteria.getLastModifiedBy() != null) {
/* 100 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), SkillsMatrix_.lastModifiedBy));
/*     */       }
/* 102 */       if (criteria.getLastModifiedDate() != null) {
/* 103 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), SkillsMatrix_.lastModifiedDate));
/*     */       }
/* 105 */       if (criteria.getProjectId() != null)
/*     */       {
/* 107 */         specification = specification.and(
/* 108 */             buildSpecification((RangeFilter)criteria
/* 109 */               .getProjectId(), root -> root.join(SkillsMatrix_.project, JoinType.LEFT).get(Project_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 114 */       if (criteria.getForProjectId() != null)
/*     */       {
/* 116 */         specification = specification.and(
/* 117 */             buildSpecification((RangeFilter)criteria
/* 118 */               .getForProjectId(), root -> root.join(SkillsMatrix_.forProject, JoinType.LEFT).get(Project_.id)));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 124 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\SkillsMatrixQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */