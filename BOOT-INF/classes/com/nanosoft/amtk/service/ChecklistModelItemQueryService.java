/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.ChecklistModelItem;
/*     */ import com.nanosoft.amtk.domain.ChecklistModelItem_;
/*     */ import com.nanosoft.amtk.domain.ChecklistModel_;
/*     */ import com.nanosoft.amtk.repository.ChecklistModelItemRepository;
/*     */ import com.nanosoft.amtk.service.criteria.ChecklistModelItemCriteria;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistModelItemDTO;
/*     */ import com.nanosoft.amtk.service.mapper.ChecklistModelItemMapper;
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
/*     */ public class ChecklistModelItemQueryService
/*     */   extends QueryService<ChecklistModelItem>
/*     */ {
/*  30 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.ChecklistModelItemQueryService.class);
/*     */ 
/*     */   
/*     */   private final ChecklistModelItemRepository checklistModelItemRepository;
/*     */ 
/*     */   
/*     */   private final ChecklistModelItemMapper checklistModelItemMapper;
/*     */ 
/*     */   
/*     */   public ChecklistModelItemQueryService(ChecklistModelItemRepository checklistModelItemRepository, ChecklistModelItemMapper checklistModelItemMapper) {
/*  40 */     this.checklistModelItemRepository = checklistModelItemRepository;
/*  41 */     this.checklistModelItemMapper = checklistModelItemMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<ChecklistModelItemDTO> findByCriteria(ChecklistModelItemCriteria criteria) {
/*  51 */     this.log.debug("find by criteria : {}", criteria);
/*  52 */     Specification<ChecklistModelItem> specification = createSpecification(criteria);
/*  53 */     return this.checklistModelItemMapper.toDto(this.checklistModelItemRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<ChecklistModelItemDTO> findByCriteria(ChecklistModelItemCriteria criteria, Pageable page) {
/*  64 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*  65 */     Specification<ChecklistModelItem> specification = createSpecification(criteria);
/*  66 */     Objects.requireNonNull(this.checklistModelItemMapper); return this.checklistModelItemRepository.findAll(specification, page).map(this.checklistModelItemMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(ChecklistModelItemCriteria criteria) {
/*  76 */     this.log.debug("count by criteria : {}", criteria);
/*  77 */     Specification<ChecklistModelItem> specification = createSpecification(criteria);
/*  78 */     return this.checklistModelItemRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<ChecklistModelItem> createSpecification(ChecklistModelItemCriteria criteria) {
/*  87 */     Specification<ChecklistModelItem> specification = Specification.where(null);
/*  88 */     if (criteria != null) {
/*     */       
/*  90 */       if (criteria.getDistinct() != null) {
/*  91 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/*  93 */       if (criteria.getId() != null) {
/*  94 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), ChecklistModelItem_.id));
/*     */       }
/*  96 */       if (criteria.getText() != null) {
/*  97 */         specification = specification.and(buildStringSpecification(criteria.getText(), ChecklistModelItem_.text));
/*     */       }
/*  99 */       if (criteria.getItemGroup() != null) {
/* 100 */         specification = specification.and(buildStringSpecification(criteria.getItemGroup(), ChecklistModelItem_.itemGroup));
/*     */       }
/* 102 */       if (criteria.getValidator() != null) {
/* 103 */         specification = specification.and(buildStringSpecification(criteria.getValidator(), ChecklistModelItem_.validator));
/*     */       }
/* 105 */       if (criteria.getCreatedBy() != null) {
/* 106 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), ChecklistModelItem_.createdBy));
/*     */       }
/* 108 */       if (criteria.getCreatedDate() != null) {
/* 109 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), ChecklistModelItem_.createdDate));
/*     */       }
/* 111 */       if (criteria.getLastModifiedBy() != null)
/*     */       {
/* 113 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), ChecklistModelItem_.lastModifiedBy));
/*     */       }
/* 115 */       if (criteria.getLastModifiedDate() != null)
/*     */       {
/* 117 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), ChecklistModelItem_.lastModifiedDate));
/*     */       }
/* 119 */       if (criteria.getChecklistModelId() != null)
/*     */       {
/* 121 */         specification = specification.and(
/* 122 */             buildSpecification((RangeFilter)criteria
/* 123 */               .getChecklistModelId(), root -> root.join(ChecklistModelItem_.checklistModel, JoinType.LEFT).get(ChecklistModel_.id)));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 129 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\ChecklistModelItemQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */