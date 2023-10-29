/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Area;
/*     */ import com.nanosoft.amtk.domain.Area_;
/*     */ import com.nanosoft.amtk.domain.Project_;
/*     */ import com.nanosoft.amtk.domain.Workstation_;
/*     */ import com.nanosoft.amtk.repository.AreaRepository;
/*     */ import com.nanosoft.amtk.service.criteria.AreaCriteria;
/*     */ import com.nanosoft.amtk.service.dto.AreaDTO;
/*     */ import com.nanosoft.amtk.service.mapper.AreaMapper;
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
/*     */ public class AreaQueryService
/*     */   extends QueryService<Area> {
/*  30 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.AreaQueryService.class);
/*     */   
/*     */   private final AreaRepository areaRepository;
/*     */   
/*     */   private final AreaMapper areaMapper;
/*     */   
/*     */   public AreaQueryService(AreaRepository areaRepository, AreaMapper areaMapper) {
/*  37 */     this.areaRepository = areaRepository;
/*  38 */     this.areaMapper = areaMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<AreaDTO> findByCriteria(AreaCriteria criteria) {
/*  48 */     this.log.debug("find by criteria : {}", criteria);
/*  49 */     Specification<Area> specification = createSpecification(criteria);
/*  50 */     return this.areaMapper.toDto(this.areaRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<AreaDTO> findByCriteria(AreaCriteria criteria, Pageable page) {
/*  61 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*  62 */     Specification<Area> specification = createSpecification(criteria);
/*  63 */     Objects.requireNonNull(this.areaMapper); return this.areaRepository.findAll(specification, page).map(this.areaMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(AreaCriteria criteria) {
/*  73 */     this.log.debug("count by criteria : {}", criteria);
/*  74 */     Specification<Area> specification = createSpecification(criteria);
/*  75 */     return this.areaRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<Area> createSpecification(AreaCriteria criteria) {
/*  84 */     Specification<Area> specification = Specification.where(null);
/*  85 */     if (criteria != null) {
/*     */       
/*  87 */       if (criteria.getDistinct() != null) {
/*  88 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/*  90 */       if (criteria.getId() != null) {
/*  91 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), Area_.id));
/*     */       }
/*  93 */       if (criteria.getName() != null) {
/*  94 */         specification = specification.and(buildStringSpecification(criteria.getName(), Area_.name));
/*     */       }
/*  96 */       if (criteria.getDescription() != null) {
/*  97 */         specification = specification.and(buildStringSpecification(criteria.getDescription(), Area_.description));
/*     */       }
/*  99 */       if (criteria.getOrderNumber() != null) {
/* 100 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getOrderNumber(), Area_.orderNumber));
/*     */       }
/* 102 */       if (criteria.getCreatedBy() != null) {
/* 103 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), Area_.createdBy));
/*     */       }
/* 105 */       if (criteria.getCreatedDate() != null) {
/* 106 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), Area_.createdDate));
/*     */       }
/* 108 */       if (criteria.getLastModifiedBy() != null) {
/* 109 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), Area_.lastModifiedBy));
/*     */       }
/* 111 */       if (criteria.getLastModifiedDate() != null) {
/* 112 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), Area_.lastModifiedDate));
/*     */       }
/* 114 */       if (criteria.getWorkstationId() != null)
/*     */       {
/* 116 */         specification = specification.and(
/* 117 */             buildSpecification((RangeFilter)criteria
/* 118 */               .getWorkstationId(), root -> root.join(Area_.workstations, JoinType.LEFT).get(Workstation_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 123 */       if (criteria.getProjectId() != null)
/*     */       {
/* 125 */         specification = specification.and(
/* 126 */             buildSpecification((RangeFilter)criteria.getProjectId(), root -> root.join(Area_.project, JoinType.LEFT).get(Project_.id)));
/*     */       }
/*     */     } 
/*     */     
/* 130 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\AreaQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */