/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.EmployeeTitle;
/*     */ import com.nanosoft.amtk.domain.EmployeeTitle_;
/*     */ import com.nanosoft.amtk.domain.Employee_;
/*     */ import com.nanosoft.amtk.repository.EmployeeTitleRepository;
/*     */ import com.nanosoft.amtk.service.criteria.EmployeeTitleCriteria;
/*     */ import com.nanosoft.amtk.service.dto.EmployeeTitleDTO;
/*     */ import com.nanosoft.amtk.service.mapper.EmployeeTitleMapper;
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
/*     */ public class EmployeeTitleQueryService
/*     */   extends QueryService<EmployeeTitle> {
/*  30 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.EmployeeTitleQueryService.class);
/*     */   
/*     */   private final EmployeeTitleRepository employeeTitleRepository;
/*     */   
/*     */   private final EmployeeTitleMapper employeeTitleMapper;
/*     */   
/*     */   public EmployeeTitleQueryService(EmployeeTitleRepository employeeTitleRepository, EmployeeTitleMapper employeeTitleMapper) {
/*  37 */     this.employeeTitleRepository = employeeTitleRepository;
/*  38 */     this.employeeTitleMapper = employeeTitleMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<EmployeeTitleDTO> findByCriteria(EmployeeTitleCriteria criteria) {
/*  48 */     this.log.debug("find by criteria : {}", criteria);
/*  49 */     Specification<EmployeeTitle> specification = createSpecification(criteria);
/*  50 */     return this.employeeTitleMapper.toDto(this.employeeTitleRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<EmployeeTitleDTO> findByCriteria(EmployeeTitleCriteria criteria, Pageable page) {
/*  61 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*  62 */     Specification<EmployeeTitle> specification = createSpecification(criteria);
/*  63 */     Objects.requireNonNull(this.employeeTitleMapper); return this.employeeTitleRepository.findAll(specification, page).map(this.employeeTitleMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(EmployeeTitleCriteria criteria) {
/*  73 */     this.log.debug("count by criteria : {}", criteria);
/*  74 */     Specification<EmployeeTitle> specification = createSpecification(criteria);
/*  75 */     return this.employeeTitleRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<EmployeeTitle> createSpecification(EmployeeTitleCriteria criteria) {
/*  84 */     Specification<EmployeeTitle> specification = Specification.where(null);
/*  85 */     if (criteria != null) {
/*     */       
/*  87 */       if (criteria.getDistinct() != null) {
/*  88 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/*  90 */       if (criteria.getId() != null) {
/*  91 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), EmployeeTitle_.id));
/*     */       }
/*  93 */       if (criteria.getName() != null) {
/*  94 */         specification = specification.and(buildStringSpecification(criteria.getName(), EmployeeTitle_.name));
/*     */       }
/*  96 */       if (criteria.getDescription() != null) {
/*  97 */         specification = specification.and(buildStringSpecification(criteria.getDescription(), EmployeeTitle_.description));
/*     */       }
/*  99 */       if (criteria.getCanSupervise() != null) {
/* 100 */         specification = specification.and(buildSpecification((Filter)criteria.getCanSupervise(), EmployeeTitle_.canSupervise));
/*     */       }
/* 102 */       if (criteria.getCreatedBy() != null) {
/* 103 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), EmployeeTitle_.createdBy));
/*     */       }
/* 105 */       if (criteria.getCreatedDate() != null) {
/* 106 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), EmployeeTitle_.createdDate));
/*     */       }
/* 108 */       if (criteria.getLastModifiedBy() != null) {
/* 109 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), EmployeeTitle_.lastModifiedBy));
/*     */       }
/* 111 */       if (criteria.getLastModifiedDate() != null) {
/* 112 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), EmployeeTitle_.lastModifiedDate));
/*     */       }
/* 114 */       if (criteria.getEmployeeId() != null)
/*     */       {
/* 116 */         specification = specification.and(
/* 117 */             buildSpecification((RangeFilter)criteria
/* 118 */               .getEmployeeId(), root -> root.join(EmployeeTitle_.employees, JoinType.LEFT).get(Employee_.id)));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 124 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\EmployeeTitleQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */