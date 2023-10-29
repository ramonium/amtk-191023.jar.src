/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Attachment_;
/*     */ import com.nanosoft.amtk.domain.Content;
/*     */ import com.nanosoft.amtk.domain.Content_;
/*     */ import com.nanosoft.amtk.repository.ContentRepository;
/*     */ import com.nanosoft.amtk.service.criteria.ContentCriteria;
/*     */ import com.nanosoft.amtk.service.dto.ContentDTO;
/*     */ import com.nanosoft.amtk.service.mapper.ContentMapper;
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
/*     */ public class ContentQueryService
/*     */   extends QueryService<Content>
/*     */ {
/*  30 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.ContentQueryService.class);
/*     */   
/*     */   private final ContentRepository contentRepository;
/*     */   
/*     */   private final ContentMapper contentMapper;
/*     */   
/*     */   public ContentQueryService(ContentRepository contentRepository, ContentMapper contentMapper) {
/*  37 */     this.contentRepository = contentRepository;
/*  38 */     this.contentMapper = contentMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<ContentDTO> findByCriteria(ContentCriteria criteria) {
/*  48 */     this.log.debug("find by criteria : {}", criteria);
/*  49 */     Specification<Content> specification = createSpecification(criteria);
/*  50 */     return this.contentMapper.toDto(this.contentRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<ContentDTO> findByCriteria(ContentCriteria criteria, Pageable page) {
/*  61 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*  62 */     Specification<Content> specification = createSpecification(criteria);
/*  63 */     Objects.requireNonNull(this.contentMapper); return this.contentRepository.findAll(specification, page).map(this.contentMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(ContentCriteria criteria) {
/*  73 */     this.log.debug("count by criteria : {}", criteria);
/*  74 */     Specification<Content> specification = createSpecification(criteria);
/*  75 */     return this.contentRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<Content> createSpecification(ContentCriteria criteria) {
/*  84 */     Specification<Content> specification = Specification.where(null);
/*  85 */     if (criteria != null) {
/*     */       
/*  87 */       if (criteria.getDistinct() != null) {
/*  88 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/*  90 */       if (criteria.getId() != null) {
/*  91 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), Content_.id));
/*     */       }
/*  93 */       if (criteria.getCreatedBy() != null) {
/*  94 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), Content_.createdBy));
/*     */       }
/*  96 */       if (criteria.getCreatedDate() != null) {
/*  97 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), Content_.createdDate));
/*     */       }
/*  99 */       if (criteria.getLastModifiedBy() != null) {
/* 100 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), Content_.lastModifiedBy));
/*     */       }
/* 102 */       if (criteria.getLastModifiedDate() != null) {
/* 103 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), Content_.lastModifiedDate));
/*     */       }
/* 105 */       if (criteria.getAttachmentId() != null)
/*     */       {
/* 107 */         specification = specification.and(
/* 108 */             buildSpecification((RangeFilter)criteria
/* 109 */               .getAttachmentId(), root -> root.join(Content_.attachment, JoinType.LEFT).get(Attachment_.id)));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 115 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\ContentQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */