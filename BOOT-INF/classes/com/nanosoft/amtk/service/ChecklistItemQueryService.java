/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.ChecklistItem;
/*     */ import com.nanosoft.amtk.domain.ChecklistItem_;
/*     */ import com.nanosoft.amtk.domain.Checklist_;
/*     */ import com.nanosoft.amtk.repository.ChecklistItemRepository;
/*     */ import com.nanosoft.amtk.service.criteria.ChecklistItemCriteria;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistItemDTO;
/*     */ import com.nanosoft.amtk.service.mapper.ChecklistItemMapper;
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
/*     */ public class ChecklistItemQueryService
/*     */   extends QueryService<ChecklistItem> {
/*  30 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.ChecklistItemQueryService.class);
/*     */   
/*     */   private final ChecklistItemRepository checklistItemRepository;
/*     */   
/*     */   private final ChecklistItemMapper checklistItemMapper;
/*     */   
/*     */   public ChecklistItemQueryService(ChecklistItemRepository checklistItemRepository, ChecklistItemMapper checklistItemMapper) {
/*  37 */     this.checklistItemRepository = checklistItemRepository;
/*  38 */     this.checklistItemMapper = checklistItemMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<ChecklistItemDTO> findByCriteria(ChecklistItemCriteria criteria) {
/*  48 */     this.log.debug("find by criteria : {}", criteria);
/*  49 */     Specification<ChecklistItem> specification = createSpecification(criteria);
/*  50 */     return this.checklistItemMapper.toDto(this.checklistItemRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<ChecklistItemDTO> findByCriteria(ChecklistItemCriteria criteria, Pageable page) {
/*  61 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*  62 */     Specification<ChecklistItem> specification = createSpecification(criteria);
/*  63 */     Objects.requireNonNull(this.checklistItemMapper); return this.checklistItemRepository.findAll(specification, page).map(this.checklistItemMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(ChecklistItemCriteria criteria) {
/*  73 */     this.log.debug("count by criteria : {}", criteria);
/*  74 */     Specification<ChecklistItem> specification = createSpecification(criteria);
/*  75 */     return this.checklistItemRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<ChecklistItem> createSpecification(ChecklistItemCriteria criteria) {
/*  84 */     Specification<ChecklistItem> specification = Specification.where(null);
/*  85 */     if (criteria != null) {
/*     */       
/*  87 */       if (criteria.getDistinct() != null) {
/*  88 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/*  90 */       if (criteria.getId() != null) {
/*  91 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), ChecklistItem_.id));
/*     */       }
/*  93 */       if (criteria.getText() != null) {
/*  94 */         specification = specification.and(buildStringSpecification(criteria.getText(), ChecklistItem_.text));
/*     */       }
/*  96 */       if (criteria.getItemGroup() != null) {
/*  97 */         specification = specification.and(buildStringSpecification(criteria.getItemGroup(), ChecklistItem_.itemGroup));
/*     */       }
/*  99 */       if (criteria.getValidatorRole() != null) {
/* 100 */         specification = specification.and(buildStringSpecification(criteria.getValidatorRole(), ChecklistItem_.validatorRole));
/*     */       }
/* 102 */       if (criteria.getValidator() != null) {
/* 103 */         specification = specification.and(buildStringSpecification(criteria.getValidator(), ChecklistItem_.validator));
/*     */       }
/* 105 */       if (criteria.getIsChecked() != null) {
/* 106 */         specification = specification.and(buildSpecification((Filter)criteria.getIsChecked(), ChecklistItem_.isChecked));
/*     */       }
/* 108 */       if (criteria.getCreatedBy() != null) {
/* 109 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), ChecklistItem_.createdBy));
/*     */       }
/* 111 */       if (criteria.getCreatedDate() != null) {
/* 112 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), ChecklistItem_.createdDate));
/*     */       }
/* 114 */       if (criteria.getLastModifiedBy() != null) {
/* 115 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), ChecklistItem_.lastModifiedBy));
/*     */       }
/* 117 */       if (criteria.getLastModifiedDate() != null) {
/* 118 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), ChecklistItem_.lastModifiedDate));
/*     */       }
/* 120 */       if (criteria.getChecklistId() != null)
/*     */       {
/* 122 */         specification = specification.and(
/* 123 */             buildSpecification((RangeFilter)criteria
/* 124 */               .getChecklistId(), root -> root.join(ChecklistItem_.checklist, JoinType.LEFT).get(Checklist_.id)));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 130 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\ChecklistItemQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */