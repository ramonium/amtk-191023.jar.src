/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Area_;
/*     */ import com.nanosoft.amtk.domain.Assignment_;
/*     */ import com.nanosoft.amtk.domain.Process_;
/*     */ import com.nanosoft.amtk.domain.Workstation;
/*     */ import com.nanosoft.amtk.domain.Workstation_;
/*     */ import com.nanosoft.amtk.repository.WorkstationRepository;
/*     */ import com.nanosoft.amtk.service.criteria.WorkstationCriteria;
/*     */ import com.nanosoft.amtk.service.dto.WorkstationDTO;
/*     */ import com.nanosoft.amtk.service.mapper.WorkstationMapper;
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
/*     */ public class WorkstationQueryService extends QueryService<Workstation> {
/*  30 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.WorkstationQueryService.class);
/*     */   
/*     */   private final WorkstationRepository workstationRepository;
/*     */   
/*     */   private final WorkstationMapper workstationMapper;
/*     */   
/*     */   public WorkstationQueryService(WorkstationRepository workstationRepository, WorkstationMapper workstationMapper) {
/*  37 */     this.workstationRepository = workstationRepository;
/*  38 */     this.workstationMapper = workstationMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<WorkstationDTO> findByCriteria(WorkstationCriteria criteria) {
/*  48 */     this.log.debug("find by criteria : {}", criteria);
/*  49 */     Specification<Workstation> specification = createSpecification(criteria);
/*  50 */     return this.workstationMapper.toDto(this.workstationRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<WorkstationDTO> findByCriteria(WorkstationCriteria criteria, Pageable page) {
/*  61 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*  62 */     Specification<Workstation> specification = createSpecification(criteria);
/*  63 */     Objects.requireNonNull(this.workstationMapper); return this.workstationRepository.findAll(specification, page).map(this.workstationMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(WorkstationCriteria criteria) {
/*  73 */     this.log.debug("count by criteria : {}", criteria);
/*  74 */     Specification<Workstation> specification = createSpecification(criteria);
/*  75 */     return this.workstationRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<Workstation> createSpecification(WorkstationCriteria criteria) {
/*  84 */     Specification<Workstation> specification = Specification.where(null);
/*  85 */     if (criteria != null) {
/*     */       
/*  87 */       if (criteria.getDistinct() != null) {
/*  88 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/*  90 */       if (criteria.getId() != null) {
/*  91 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), Workstation_.id));
/*     */       }
/*  93 */       if (criteria.getName() != null) {
/*  94 */         specification = specification.and(buildStringSpecification(criteria.getName(), Workstation_.name));
/*     */       }
/*  96 */       if (criteria.getDescription() != null) {
/*  97 */         specification = specification.and(buildStringSpecification(criteria.getDescription(), Workstation_.description));
/*     */       }
/*  99 */       if (criteria.getOrderNumber() != null) {
/* 100 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getOrderNumber(), Workstation_.orderNumber));
/*     */       }
/* 102 */       if (criteria.getCreatedBy() != null) {
/* 103 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), Workstation_.createdBy));
/*     */       }
/* 105 */       if (criteria.getCreatedDate() != null) {
/* 106 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), Workstation_.createdDate));
/*     */       }
/* 108 */       if (criteria.getLastModifiedBy() != null) {
/* 109 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), Workstation_.lastModifiedBy));
/*     */       }
/* 111 */       if (criteria.getLastModifiedDate() != null) {
/* 112 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), Workstation_.lastModifiedDate));
/*     */       }
/* 114 */       if (criteria.getAssignmentId() != null)
/*     */       {
/* 116 */         specification = specification.and(
/* 117 */             buildSpecification((RangeFilter)criteria
/* 118 */               .getAssignmentId(), root -> root.join(Workstation_.assignments, JoinType.LEFT).get(Assignment_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 123 */       if (criteria.getAreaId() != null)
/*     */       {
/* 125 */         specification = specification.and(
/* 126 */             buildSpecification((RangeFilter)criteria.getAreaId(), root -> root.join(Workstation_.area, JoinType.LEFT).get(Area_.id)));
/*     */       }
/*     */       
/* 129 */       if (criteria.getProcessId() != null)
/*     */       {
/* 131 */         specification = specification.and(
/* 132 */             buildSpecification((RangeFilter)criteria.getProcessId(), root -> root.join(Workstation_.process, JoinType.LEFT).get(Process_.id)));
/*     */       }
/*     */     } 
/*     */     
/* 136 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\WorkstationQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */