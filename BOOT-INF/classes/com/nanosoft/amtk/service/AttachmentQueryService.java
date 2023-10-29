/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Attachment;
/*     */ import com.nanosoft.amtk.domain.Attachment_;
/*     */ import com.nanosoft.amtk.domain.Content_;
/*     */ import com.nanosoft.amtk.domain.Employee_;
/*     */ import com.nanosoft.amtk.repository.AttachmentRepository;
/*     */ import com.nanosoft.amtk.service.criteria.AttachmentCriteria;
/*     */ import com.nanosoft.amtk.service.dto.AttachmentDTO;
/*     */ import com.nanosoft.amtk.service.mapper.AttachmentMapper;
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
/*     */ public class AttachmentQueryService
/*     */   extends QueryService<Attachment> {
/*  30 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.AttachmentQueryService.class);
/*     */   
/*     */   private final AttachmentRepository attachmentRepository;
/*     */   
/*     */   private final AttachmentMapper attachmentMapper;
/*     */   
/*     */   public AttachmentQueryService(AttachmentRepository attachmentRepository, AttachmentMapper attachmentMapper) {
/*  37 */     this.attachmentRepository = attachmentRepository;
/*  38 */     this.attachmentMapper = attachmentMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<AttachmentDTO> findByCriteria(AttachmentCriteria criteria) {
/*  48 */     this.log.debug("find by criteria : {}", criteria);
/*  49 */     Specification<Attachment> specification = createSpecification(criteria);
/*  50 */     return this.attachmentMapper.toDto(this.attachmentRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<AttachmentDTO> findByCriteria(AttachmentCriteria criteria, Pageable page) {
/*  61 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*  62 */     Specification<Attachment> specification = createSpecification(criteria);
/*  63 */     Objects.requireNonNull(this.attachmentMapper); return this.attachmentRepository.findAll(specification, page).map(this.attachmentMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(AttachmentCriteria criteria) {
/*  73 */     this.log.debug("count by criteria : {}", criteria);
/*  74 */     Specification<Attachment> specification = createSpecification(criteria);
/*  75 */     return this.attachmentRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<Attachment> createSpecification(AttachmentCriteria criteria) {
/*  84 */     Specification<Attachment> specification = Specification.where(null);
/*  85 */     if (criteria != null) {
/*     */       
/*  87 */       if (criteria.getDistinct() != null) {
/*  88 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/*  90 */       if (criteria.getId() != null) {
/*  91 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), Attachment_.id));
/*     */       }
/*  93 */       if (criteria.getTitle() != null) {
/*  94 */         specification = specification.and(buildStringSpecification(criteria.getTitle(), Attachment_.title));
/*     */       }
/*  96 */       if (criteria.getFileName() != null) {
/*  97 */         specification = specification.and(buildStringSpecification(criteria.getFileName(), Attachment_.fileName));
/*     */       }
/*  99 */       if (criteria.getFileSize() != null) {
/* 100 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getFileSize(), Attachment_.fileSize));
/*     */       }
/* 102 */       if (criteria.getFileType() != null) {
/* 103 */         specification = specification.and(buildStringSpecification(criteria.getFileType(), Attachment_.fileType));
/*     */       }
/* 105 */       if (criteria.getDescription() != null) {
/* 106 */         specification = specification.and(buildStringSpecification(criteria.getDescription(), Attachment_.description));
/*     */       }
/* 108 */       if (criteria.getCreatedBy() != null) {
/* 109 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), Attachment_.createdBy));
/*     */       }
/* 111 */       if (criteria.getCreatedDate() != null) {
/* 112 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), Attachment_.createdDate));
/*     */       }
/* 114 */       if (criteria.getLastModifiedBy() != null) {
/* 115 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), Attachment_.lastModifiedBy));
/*     */       }
/* 117 */       if (criteria.getLastModifiedDate() != null) {
/* 118 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), Attachment_.lastModifiedDate));
/*     */       }
/* 120 */       if (criteria.getContentId() != null)
/*     */       {
/* 122 */         specification = specification.and(
/* 123 */             buildSpecification((RangeFilter)criteria.getContentId(), root -> root.join(Attachment_.content, JoinType.LEFT).get(Content_.id)));
/*     */       }
/*     */       
/* 126 */       if (criteria.getEmployeeId() != null)
/*     */       {
/* 128 */         specification = specification.and(
/* 129 */             buildSpecification((RangeFilter)criteria
/* 130 */               .getEmployeeId(), root -> root.join(Attachment_.employee, JoinType.LEFT).get(Employee_.id)));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 136 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\AttachmentQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */