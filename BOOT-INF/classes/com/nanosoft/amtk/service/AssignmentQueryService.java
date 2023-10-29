/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Assignment;
/*     */ import com.nanosoft.amtk.domain.Assignment_;
/*     */ import com.nanosoft.amtk.domain.Certificate_;
/*     */ import com.nanosoft.amtk.domain.Employee_;
/*     */ import com.nanosoft.amtk.domain.Workstation_;
/*     */ import com.nanosoft.amtk.repository.AssignmentRepository;
/*     */ import com.nanosoft.amtk.service.criteria.AssignmentCriteria;
/*     */ import com.nanosoft.amtk.service.dto.AssignmentDTO;
/*     */ import com.nanosoft.amtk.service.mapper.AssignmentMapper;
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
/*     */ public class AssignmentQueryService extends QueryService<Assignment> {
/*  30 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.AssignmentQueryService.class);
/*     */   
/*     */   private final AssignmentRepository assignmentRepository;
/*     */   
/*     */   private final AssignmentMapper assignmentMapper;
/*     */   
/*     */   public AssignmentQueryService(AssignmentRepository assignmentRepository, AssignmentMapper assignmentMapper) {
/*  37 */     this.assignmentRepository = assignmentRepository;
/*  38 */     this.assignmentMapper = assignmentMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<AssignmentDTO> findByCriteria(AssignmentCriteria criteria) {
/*  48 */     this.log.debug("find by criteria : {}", criteria);
/*  49 */     Specification<Assignment> specification = createSpecification(criteria);
/*  50 */     return this.assignmentMapper.toDto(this.assignmentRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<AssignmentDTO> findByCriteria(AssignmentCriteria criteria, Pageable page) {
/*  61 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*  62 */     Specification<Assignment> specification = createSpecification(criteria);
/*  63 */     Objects.requireNonNull(this.assignmentMapper); return this.assignmentRepository.findAll(specification, page).map(this.assignmentMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(AssignmentCriteria criteria) {
/*  73 */     this.log.debug("count by criteria : {}", criteria);
/*  74 */     Specification<Assignment> specification = createSpecification(criteria);
/*  75 */     return this.assignmentRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<Assignment> createSpecification(AssignmentCriteria criteria) {
/*  84 */     Specification<Assignment> specification = Specification.where(null);
/*  85 */     if (criteria != null) {
/*     */       
/*  87 */       if (criteria.getDistinct() != null) {
/*  88 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/*  90 */       if (criteria.getId() != null) {
/*  91 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), Assignment_.id));
/*     */       }
/*  93 */       if (criteria.getAssignmentStart() != null) {
/*  94 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getAssignmentStart(), Assignment_.assignmentStart));
/*     */       }
/*  96 */       if (criteria.getAssignmentEnd() != null) {
/*  97 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getAssignmentEnd(), Assignment_.assignmentEnd));
/*     */       }
/*  99 */       if (criteria.getDescription() != null) {
/* 100 */         specification = specification.and(buildStringSpecification(criteria.getDescription(), Assignment_.description));
/*     */       }
/* 102 */       if (criteria.getCreatedBy() != null) {
/* 103 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), Assignment_.createdBy));
/*     */       }
/* 105 */       if (criteria.getCreatedDate() != null) {
/* 106 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), Assignment_.createdDate));
/*     */       }
/* 108 */       if (criteria.getLastModifiedBy() != null) {
/* 109 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), Assignment_.lastModifiedBy));
/*     */       }
/* 111 */       if (criteria.getLastModifiedDate() != null) {
/* 112 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), Assignment_.lastModifiedDate));
/*     */       }
/* 114 */       if (criteria.getCertificateId() != null)
/*     */       {
/* 116 */         specification = specification.and(
/* 117 */             buildSpecification((RangeFilter)criteria
/* 118 */               .getCertificateId(), root -> root.join(Assignment_.certificates, JoinType.LEFT).get(Certificate_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 123 */       if (criteria.getWorkstationId() != null)
/*     */       {
/* 125 */         specification = specification.and(
/* 126 */             buildSpecification((RangeFilter)criteria
/* 127 */               .getWorkstationId(), root -> root.join(Assignment_.workstation, JoinType.LEFT).get(Workstation_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 132 */       if (criteria.getEmployeeId() != null)
/*     */       {
/* 134 */         specification = specification.and(
/* 135 */             buildSpecification((RangeFilter)criteria
/* 136 */               .getEmployeeId(), root -> root.join(Assignment_.employee, JoinType.LEFT).get(Employee_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 141 */       if (criteria.getCurrentCertificateId() != null)
/*     */       {
/* 143 */         specification = specification.and(
/* 144 */             buildSpecification((RangeFilter)criteria
/* 145 */               .getCurrentCertificateId(), root -> root.join(Assignment_.currentCertificate, JoinType.LEFT).get(Certificate_.id)));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 151 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\AssignmentQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */