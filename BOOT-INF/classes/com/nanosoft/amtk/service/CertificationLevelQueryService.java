/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Certificate_;
/*     */ import com.nanosoft.amtk.domain.CertificationLevel;
/*     */ import com.nanosoft.amtk.domain.CertificationLevel_;
/*     */ import com.nanosoft.amtk.domain.ChecklistModel_;
/*     */ import com.nanosoft.amtk.domain.Process_;
/*     */ import com.nanosoft.amtk.repository.CertificationLevelRepository;
/*     */ import com.nanosoft.amtk.service.criteria.CertificationLevelCriteria;
/*     */ import com.nanosoft.amtk.service.dto.CertificationLevelDTO;
/*     */ import com.nanosoft.amtk.service.mapper.CertificationLevelMapper;
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
/*     */ public class CertificationLevelQueryService extends QueryService<CertificationLevel> {
/*  30 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.CertificationLevelQueryService.class);
/*     */ 
/*     */   
/*     */   private final CertificationLevelRepository certificationLevelRepository;
/*     */ 
/*     */   
/*     */   private final CertificationLevelMapper certificationLevelMapper;
/*     */ 
/*     */   
/*     */   public CertificationLevelQueryService(CertificationLevelRepository certificationLevelRepository, CertificationLevelMapper certificationLevelMapper) {
/*  40 */     this.certificationLevelRepository = certificationLevelRepository;
/*  41 */     this.certificationLevelMapper = certificationLevelMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<CertificationLevelDTO> findByCriteria(CertificationLevelCriteria criteria) {
/*  51 */     this.log.debug("find by criteria : {}", criteria);
/*  52 */     Specification<CertificationLevel> specification = createSpecification(criteria);
/*  53 */     return this.certificationLevelMapper.toDto(this.certificationLevelRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<CertificationLevelDTO> findByCriteria(CertificationLevelCriteria criteria, Pageable page) {
/*  64 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*  65 */     Specification<CertificationLevel> specification = createSpecification(criteria);
/*  66 */     Objects.requireNonNull(this.certificationLevelMapper); return this.certificationLevelRepository.findAll(specification, page).map(this.certificationLevelMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(CertificationLevelCriteria criteria) {
/*  76 */     this.log.debug("count by criteria : {}", criteria);
/*  77 */     Specification<CertificationLevel> specification = createSpecification(criteria);
/*  78 */     return this.certificationLevelRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<CertificationLevel> createSpecification(CertificationLevelCriteria criteria) {
/*  87 */     Specification<CertificationLevel> specification = Specification.where(null);
/*  88 */     if (criteria != null) {
/*     */       
/*  90 */       if (criteria.getDistinct() != null) {
/*  91 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/*  93 */       if (criteria.getId() != null) {
/*  94 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), CertificationLevel_.id));
/*     */       }
/*  96 */       if (criteria.getLevel() != null) {
/*  97 */         specification = specification.and(buildStringSpecification(criteria.getLevel(), CertificationLevel_.level));
/*     */       }
/*  99 */       if (criteria.getOrderNumber() != null) {
/* 100 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getOrderNumber(), CertificationLevel_.orderNumber));
/*     */       }
/* 102 */       if (criteria.getTrainingDuration() != null)
/*     */       {
/* 104 */         specification = specification.and(buildStringSpecification(criteria.getTrainingDuration(), CertificationLevel_.trainingDuration));
/*     */       }
/* 106 */       if (criteria.getRecyclingPeriod() != null)
/*     */       {
/* 108 */         specification = specification.and(buildStringSpecification(criteria.getRecyclingPeriod(), CertificationLevel_.recyclingPeriod));
/*     */       }
/* 110 */       if (criteria.getDescription() != null) {
/* 111 */         specification = specification.and(buildStringSpecification(criteria.getDescription(), CertificationLevel_.description));
/*     */       }
/* 113 */       if (criteria.getCreatedBy() != null) {
/* 114 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), CertificationLevel_.createdBy));
/*     */       }
/* 116 */       if (criteria.getCreatedDate() != null) {
/* 117 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), CertificationLevel_.createdDate));
/*     */       }
/* 119 */       if (criteria.getLastModifiedBy() != null)
/*     */       {
/* 121 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), CertificationLevel_.lastModifiedBy));
/*     */       }
/* 123 */       if (criteria.getLastModifiedDate() != null)
/*     */       {
/* 125 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), CertificationLevel_.lastModifiedDate));
/*     */       }
/* 127 */       if (criteria.getCertificateId() != null)
/*     */       {
/* 129 */         specification = specification.and(
/* 130 */             buildSpecification((RangeFilter)criteria
/* 131 */               .getCertificateId(), root -> root.join(CertificationLevel_.certificates, JoinType.LEFT).get(Certificate_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 136 */       if (criteria.getProcessId() != null)
/*     */       {
/* 138 */         specification = specification.and(
/* 139 */             buildSpecification((RangeFilter)criteria
/* 140 */               .getProcessId(), root -> root.join(CertificationLevel_.process, JoinType.LEFT).get(Process_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 145 */       if (criteria.getChecklistModelId() != null)
/*     */       {
/* 147 */         specification = specification.and(
/* 148 */             buildSpecification((RangeFilter)criteria
/* 149 */               .getChecklistModelId(), root -> root.join(CertificationLevel_.checklistModel, JoinType.LEFT).get(ChecklistModel_.id)));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 155 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\CertificationLevelQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */