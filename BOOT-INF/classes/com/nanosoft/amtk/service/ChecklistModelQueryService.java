/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.CertificationLevel_;
/*     */ import com.nanosoft.amtk.domain.ChecklistModel;
/*     */ import com.nanosoft.amtk.domain.ChecklistModelItem_;
/*     */ import com.nanosoft.amtk.domain.ChecklistModel_;
/*     */ import com.nanosoft.amtk.domain.Checklist_;
/*     */ import com.nanosoft.amtk.repository.ChecklistModelRepository;
/*     */ import com.nanosoft.amtk.service.criteria.ChecklistModelCriteria;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistModelDTO;
/*     */ import com.nanosoft.amtk.service.mapper.ChecklistModelMapper;
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
/*     */ public class ChecklistModelQueryService extends QueryService<ChecklistModel> {
/*  30 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.ChecklistModelQueryService.class);
/*     */   
/*     */   private final ChecklistModelRepository checklistModelRepository;
/*     */   
/*     */   private final ChecklistModelMapper checklistModelMapper;
/*     */   
/*     */   public ChecklistModelQueryService(ChecklistModelRepository checklistModelRepository, ChecklistModelMapper checklistModelMapper) {
/*  37 */     this.checklistModelRepository = checklistModelRepository;
/*  38 */     this.checklistModelMapper = checklistModelMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<ChecklistModelDTO> findByCriteria(ChecklistModelCriteria criteria) {
/*  48 */     this.log.debug("find by criteria : {}", criteria);
/*  49 */     Specification<ChecklistModel> specification = createSpecification(criteria);
/*  50 */     return this.checklistModelMapper.toDto(this.checklistModelRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<ChecklistModelDTO> findByCriteria(ChecklistModelCriteria criteria, Pageable page) {
/*  61 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*  62 */     Specification<ChecklistModel> specification = createSpecification(criteria);
/*  63 */     Objects.requireNonNull(this.checklistModelMapper); return this.checklistModelRepository.findAll(specification, page).map(this.checklistModelMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(ChecklistModelCriteria criteria) {
/*  73 */     this.log.debug("count by criteria : {}", criteria);
/*  74 */     Specification<ChecklistModel> specification = createSpecification(criteria);
/*  75 */     return this.checklistModelRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<ChecklistModel> createSpecification(ChecklistModelCriteria criteria) {
/*  84 */     Specification<ChecklistModel> specification = Specification.where(null);
/*  85 */     if (criteria != null) {
/*     */       
/*  87 */       if (criteria.getDistinct() != null) {
/*  88 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/*  90 */       if (criteria.getId() != null) {
/*  91 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), ChecklistModel_.id));
/*     */       }
/*  93 */       if (criteria.getTitle() != null) {
/*  94 */         specification = specification.and(buildStringSpecification(criteria.getTitle(), ChecklistModel_.title));
/*     */       }
/*  96 */       if (criteria.getDescription() != null) {
/*  97 */         specification = specification.and(buildStringSpecification(criteria.getDescription(), ChecklistModel_.description));
/*     */       }
/*  99 */       if (criteria.getValidator() != null) {
/* 100 */         specification = specification.and(buildStringSpecification(criteria.getValidator(), ChecklistModel_.validator));
/*     */       }
/* 102 */       if (criteria.getValidator2() != null) {
/* 103 */         specification = specification.and(buildStringSpecification(criteria.getValidator2(), ChecklistModel_.validator2));
/*     */       }
/* 105 */       if (criteria.getValidator3() != null) {
/* 106 */         specification = specification.and(buildStringSpecification(criteria.getValidator3(), ChecklistModel_.validator3));
/*     */       }
/* 108 */       if (criteria.getValidator4() != null) {
/* 109 */         specification = specification.and(buildStringSpecification(criteria.getValidator4(), ChecklistModel_.validator4));
/*     */       }
/* 111 */       if (criteria.getCreatedBy() != null) {
/* 112 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), ChecklistModel_.createdBy));
/*     */       }
/* 114 */       if (criteria.getCreatedDate() != null) {
/* 115 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), ChecklistModel_.createdDate));
/*     */       }
/* 117 */       if (criteria.getLastModifiedBy() != null) {
/* 118 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), ChecklistModel_.lastModifiedBy));
/*     */       }
/* 120 */       if (criteria.getLastModifiedDate() != null)
/*     */       {
/* 122 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), ChecklistModel_.lastModifiedDate));
/*     */       }
/* 124 */       if (criteria.getCertificationLevelId() != null)
/*     */       {
/* 126 */         specification = specification.and(
/* 127 */             buildSpecification((RangeFilter)criteria
/* 128 */               .getCertificationLevelId(), root -> root.join(ChecklistModel_.certificationLevels, JoinType.LEFT).get(CertificationLevel_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 133 */       if (criteria.getChecklistId() != null)
/*     */       {
/* 135 */         specification = specification.and(
/* 136 */             buildSpecification((RangeFilter)criteria
/* 137 */               .getChecklistId(), root -> root.join(ChecklistModel_.checklists, JoinType.LEFT).get(Checklist_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 142 */       if (criteria.getChecklistModelItemId() != null)
/*     */       {
/* 144 */         specification = specification.and(
/* 145 */             buildSpecification((RangeFilter)criteria
/* 146 */               .getChecklistModelItemId(), root -> root.join(ChecklistModel_.checklistModelItems, JoinType.LEFT).get(ChecklistModelItem_.id)));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 152 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\ChecklistModelQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */