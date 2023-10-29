/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.CertificationLevel_;
/*     */ import com.nanosoft.amtk.domain.Process;
/*     */ import com.nanosoft.amtk.domain.Process_;
/*     */ import com.nanosoft.amtk.domain.Workstation_;
/*     */ import com.nanosoft.amtk.repository.ProcessRepository;
/*     */ import com.nanosoft.amtk.service.criteria.ProcessCriteria;
/*     */ import com.nanosoft.amtk.service.dto.ProcessDTO;
/*     */ import com.nanosoft.amtk.service.mapper.ProcessMapper;
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
/*     */ public class ProcessQueryService
/*     */   extends QueryService<Process> {
/*  30 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.ProcessQueryService.class);
/*     */   
/*     */   private final ProcessRepository processRepository;
/*     */   
/*     */   private final ProcessMapper processMapper;
/*     */   
/*     */   public ProcessQueryService(ProcessRepository processRepository, ProcessMapper processMapper) {
/*  37 */     this.processRepository = processRepository;
/*  38 */     this.processMapper = processMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<ProcessDTO> findByCriteria(ProcessCriteria criteria) {
/*  48 */     this.log.debug("find by criteria : {}", criteria);
/*  49 */     Specification<Process> specification = createSpecification(criteria);
/*  50 */     return this.processMapper.toDto(this.processRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<ProcessDTO> findByCriteria(ProcessCriteria criteria, Pageable page) {
/*  61 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*  62 */     Specification<Process> specification = createSpecification(criteria);
/*  63 */     Objects.requireNonNull(this.processMapper); return this.processRepository.findAll(specification, page).map(this.processMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(ProcessCriteria criteria) {
/*  73 */     this.log.debug("count by criteria : {}", criteria);
/*  74 */     Specification<Process> specification = createSpecification(criteria);
/*  75 */     return this.processRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<Process> createSpecification(ProcessCriteria criteria) {
/*  84 */     Specification<Process> specification = Specification.where(null);
/*  85 */     if (criteria != null) {
/*     */       
/*  87 */       if (criteria.getDistinct() != null) {
/*  88 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/*  90 */       if (criteria.getId() != null) {
/*  91 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), Process_.id));
/*     */       }
/*  93 */       if (criteria.getName() != null) {
/*  94 */         specification = specification.and(buildStringSpecification(criteria.getName(), Process_.name));
/*     */       }
/*  96 */       if (criteria.getDescription() != null) {
/*  97 */         specification = specification.and(buildStringSpecification(criteria.getDescription(), Process_.description));
/*     */       }
/*  99 */       if (criteria.getCreatedBy() != null) {
/* 100 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), Process_.createdBy));
/*     */       }
/* 102 */       if (criteria.getCreatedDate() != null) {
/* 103 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), Process_.createdDate));
/*     */       }
/* 105 */       if (criteria.getLastModifiedBy() != null) {
/* 106 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), Process_.lastModifiedBy));
/*     */       }
/* 108 */       if (criteria.getLastModifiedDate() != null) {
/* 109 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), Process_.lastModifiedDate));
/*     */       }
/* 111 */       if (criteria.getWorkstationId() != null)
/*     */       {
/* 113 */         specification = specification.and(
/* 114 */             buildSpecification((RangeFilter)criteria
/* 115 */               .getWorkstationId(), root -> root.join(Process_.workstations, JoinType.LEFT).get(Workstation_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 120 */       if (criteria.getCertificationLevelId() != null)
/*     */       {
/* 122 */         specification = specification.and(
/* 123 */             buildSpecification((RangeFilter)criteria
/* 124 */               .getCertificationLevelId(), root -> root.join(Process_.certificationLevels, JoinType.LEFT).get(CertificationLevel_.id)));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 130 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\ProcessQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */