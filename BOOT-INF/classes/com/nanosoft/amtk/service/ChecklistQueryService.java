/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ import com.nanosoft.amtk.domain.Certificate_;
/*     */ import com.nanosoft.amtk.domain.Checklist;
/*     */ import com.nanosoft.amtk.domain.ChecklistItem_;
/*     */ import com.nanosoft.amtk.domain.ChecklistModel_;
/*     */ import com.nanosoft.amtk.domain.Checklist_;
/*     */ import com.nanosoft.amtk.repository.ChecklistRepository;
/*     */ import com.nanosoft.amtk.service.criteria.ChecklistCriteria;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistDTO;
/*     */ import com.nanosoft.amtk.service.mapper.ChecklistMapper;
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
/*     */ import tech.jhipster.service.filter.Filter;
/*     */ import tech.jhipster.service.filter.RangeFilter;
/*     */ 
/*     */ @Service
/*     */ @Transactional(readOnly = true)
/*     */ public class ChecklistQueryService extends QueryService<Checklist> {
/*  30 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.ChecklistQueryService.class);
/*     */   
/*     */   private final ChecklistRepository checklistRepository;
/*     */   
/*     */   private final ChecklistMapper checklistMapper;
/*     */   
/*     */   public ChecklistQueryService(ChecklistRepository checklistRepository, ChecklistMapper checklistMapper) {
/*  37 */     this.checklistRepository = checklistRepository;
/*  38 */     this.checklistMapper = checklistMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<ChecklistDTO> findByCriteria(ChecklistCriteria criteria) {
/*  48 */     this.log.debug("find by criteria : {}", criteria);
/*  49 */     Specification<Checklist> specification = createSpecification(criteria);
/*  50 */     return this.checklistMapper.toDto(this.checklistRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<ChecklistDTO> findByCriteria(ChecklistCriteria criteria, Pageable page) {
/*  61 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*  62 */     Specification<Checklist> specification = createSpecification(criteria);
/*  63 */     Objects.requireNonNull(this.checklistMapper); return this.checklistRepository.findAll(specification, page).map(this.checklistMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(ChecklistCriteria criteria) {
/*  73 */     this.log.debug("count by criteria : {}", criteria);
/*  74 */     Specification<Checklist> specification = createSpecification(criteria);
/*  75 */     return this.checklistRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<Checklist> createSpecification(ChecklistCriteria criteria) {
/*  84 */     Specification<Checklist> specification = Specification.where(null);
/*  85 */     if (criteria != null) {
/*     */       
/*  87 */       if (criteria.getDistinct() != null) {
/*  88 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/*  90 */       if (criteria.getId() != null) {
/*  91 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), Checklist_.id));
/*     */       }
/*  93 */       if (criteria.getTitle() != null) {
/*  94 */         specification = specification.and(buildStringSpecification(criteria.getTitle(), Checklist_.title));
/*     */       }
/*  96 */       if (criteria.getDescription() != null) {
/*  97 */         specification = specification.and(buildStringSpecification(criteria.getDescription(), Checklist_.description));
/*     */       }
/*  99 */       if (criteria.getValidatorRole() != null) {
/* 100 */         specification = specification.and(buildStringSpecification(criteria.getValidatorRole(), Checklist_.validatorRole));
/*     */       }
/* 102 */       if (criteria.getValidator() != null) {
/* 103 */         specification = specification.and(buildStringSpecification(criteria.getValidator(), Checklist_.validator));
/*     */       }
/* 105 */       if (criteria.getValidatorCheck() != null) {
/* 106 */         specification = specification.and(buildSpecification((Filter)criteria.getValidatorCheck(), Checklist_.validatorCheck));
/*     */       }
/* 108 */       if (criteria.getValidatorRole2() != null) {
/* 109 */         specification = specification.and(buildStringSpecification(criteria.getValidatorRole2(), Checklist_.validatorRole2));
/*     */       }
/* 111 */       if (criteria.getValidator2() != null) {
/* 112 */         specification = specification.and(buildStringSpecification(criteria.getValidator2(), Checklist_.validator2));
/*     */       }
/* 114 */       if (criteria.getValidator2Check() != null) {
/* 115 */         specification = specification.and(buildSpecification((Filter)criteria.getValidator2Check(), Checklist_.validator2Check));
/*     */       }
/* 117 */       if (criteria.getValidatorRole3() != null) {
/* 118 */         specification = specification.and(buildStringSpecification(criteria.getValidatorRole3(), Checklist_.validatorRole3));
/*     */       }
/* 120 */       if (criteria.getValidator3() != null) {
/* 121 */         specification = specification.and(buildStringSpecification(criteria.getValidator3(), Checklist_.validator3));
/*     */       }
/* 123 */       if (criteria.getValidator3Check() != null) {
/* 124 */         specification = specification.and(buildSpecification((Filter)criteria.getValidator3Check(), Checklist_.validator3Check));
/*     */       }
/* 126 */       if (criteria.getValidatorRole4() != null) {
/* 127 */         specification = specification.and(buildStringSpecification(criteria.getValidatorRole4(), Checklist_.validatorRole4));
/*     */       }
/* 129 */       if (criteria.getValidator4() != null) {
/* 130 */         specification = specification.and(buildStringSpecification(criteria.getValidator4(), Checklist_.validator4));
/*     */       }
/* 132 */       if (criteria.getValidator4Check() != null) {
/* 133 */         specification = specification.and(buildSpecification((Filter)criteria.getValidator4Check(), Checklist_.validator4Check));
/*     */       }
/* 135 */       if (criteria.getStatus() != null) {
/* 136 */         specification = specification.and(buildSpecification((Filter)criteria.getStatus(), Checklist_.status));
/*     */       }
/* 138 */       if (criteria.getCreatedBy() != null) {
/* 139 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), Checklist_.createdBy));
/*     */       }
/* 141 */       if (criteria.getCreatedDate() != null) {
/* 142 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), Checklist_.createdDate));
/*     */       }
/* 144 */       if (criteria.getLastModifiedBy() != null) {
/* 145 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), Checklist_.lastModifiedBy));
/*     */       }
/* 147 */       if (criteria.getLastModifiedDate() != null) {
/* 148 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), Checklist_.lastModifiedDate));
/*     */       }
/* 150 */       if (criteria.getCertificateId() != null)
/*     */       {
/* 152 */         specification = specification.and(
/* 153 */             buildSpecification((RangeFilter)criteria
/* 154 */               .getCertificateId(), root -> root.join(Checklist_.certificate, JoinType.LEFT).get(Certificate_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 159 */       if (criteria.getChecklistModelId() != null)
/*     */       {
/* 161 */         specification = specification.and(
/* 162 */             buildSpecification((RangeFilter)criteria
/* 163 */               .getChecklistModelId(), root -> root.join(Checklist_.checklistModel, JoinType.LEFT).get(ChecklistModel_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 168 */       if (criteria.getChecklistItemId() != null)
/*     */       {
/* 170 */         specification = specification.and(
/* 171 */             buildSpecification((RangeFilter)criteria
/* 172 */               .getChecklistItemId(), root -> root.join(Checklist_.checklistItems, JoinType.LEFT).get(ChecklistItem_.id)));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 178 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\ChecklistQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */