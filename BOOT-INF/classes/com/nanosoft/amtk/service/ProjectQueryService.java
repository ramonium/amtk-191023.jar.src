/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Area_;
/*     */ import com.nanosoft.amtk.domain.Project;
/*     */ import com.nanosoft.amtk.domain.Project_;
/*     */ import com.nanosoft.amtk.domain.SkillsMatrix_;
/*     */ import com.nanosoft.amtk.repository.ProjectRepository;
/*     */ import com.nanosoft.amtk.service.criteria.ProjectCriteria;
/*     */ import com.nanosoft.amtk.service.dto.ProjectDTO;
/*     */ import com.nanosoft.amtk.service.mapper.ProjectMapper;
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
/*     */ public class ProjectQueryService extends QueryService<Project> {
/*  30 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.ProjectQueryService.class);
/*     */   
/*     */   private final ProjectRepository projectRepository;
/*     */   
/*     */   private final ProjectMapper projectMapper;
/*     */   
/*     */   public ProjectQueryService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
/*  37 */     this.projectRepository = projectRepository;
/*  38 */     this.projectMapper = projectMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<ProjectDTO> findByCriteria(ProjectCriteria criteria) {
/*  48 */     this.log.debug("find by criteria : {}", criteria);
/*  49 */     Specification<Project> specification = createSpecification(criteria);
/*  50 */     return this.projectMapper.toDto(this.projectRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<ProjectDTO> findByCriteria(ProjectCriteria criteria, Pageable page) {
/*  61 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*  62 */     Specification<Project> specification = createSpecification(criteria);
/*  63 */     Objects.requireNonNull(this.projectMapper); return this.projectRepository.findAll(specification, page).map(this.projectMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(ProjectCriteria criteria) {
/*  73 */     this.log.debug("count by criteria : {}", criteria);
/*  74 */     Specification<Project> specification = createSpecification(criteria);
/*  75 */     return this.projectRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<Project> createSpecification(ProjectCriteria criteria) {
/*  84 */     Specification<Project> specification = Specification.where(null);
/*  85 */     if (criteria != null) {
/*     */       
/*  87 */       if (criteria.getDistinct() != null) {
/*  88 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/*  90 */       if (criteria.getId() != null) {
/*  91 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), Project_.id));
/*     */       }
/*  93 */       if (criteria.getName() != null) {
/*  94 */         specification = specification.and(buildStringSpecification(criteria.getName(), Project_.name));
/*     */       }
/*  96 */       if (criteria.getCustomer() != null) {
/*  97 */         specification = specification.and(buildStringSpecification(criteria.getCustomer(), Project_.customer));
/*     */       }
/*  99 */       if (criteria.getSafety() != null) {
/* 100 */         specification = specification.and(buildSpecification((Filter)criteria.getSafety(), Project_.safety));
/*     */       }
/* 102 */       if (criteria.getQualificationAfter() != null) {
/* 103 */         specification = specification.and(buildStringSpecification(criteria.getQualificationAfter(), Project_.qualificationAfter));
/*     */       }
/* 105 */       if (criteria.getDecertifyAfter() != null) {
/* 106 */         specification = specification.and(buildStringSpecification(criteria.getDecertifyAfter(), Project_.decertifyAfter));
/*     */       }
/* 108 */       if (criteria.getDescription() != null) {
/* 109 */         specification = specification.and(buildStringSpecification(criteria.getDescription(), Project_.description));
/*     */       }
/* 111 */       if (criteria.getCreatedBy() != null) {
/* 112 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), Project_.createdBy));
/*     */       }
/* 114 */       if (criteria.getCreatedDate() != null) {
/* 115 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), Project_.createdDate));
/*     */       }
/* 117 */       if (criteria.getLastModifiedBy() != null) {
/* 118 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), Project_.lastModifiedBy));
/*     */       }
/* 120 */       if (criteria.getLastModifiedDate() != null) {
/* 121 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), Project_.lastModifiedDate));
/*     */       }
/* 123 */       if (criteria.getAreaId() != null)
/*     */       {
/* 125 */         specification = specification.and(
/* 126 */             buildSpecification((RangeFilter)criteria.getAreaId(), root -> root.join(Project_.areas, JoinType.LEFT).get(Area_.id)));
/*     */       }
/*     */       
/* 129 */       if (criteria.getSkillsMatrixHistoryId() != null)
/*     */       {
/* 131 */         specification = specification.and(
/* 132 */             buildSpecification((RangeFilter)criteria
/* 133 */               .getSkillsMatrixHistoryId(), root -> root.join(Project_.skillsMatrixHistories, JoinType.LEFT).get(SkillsMatrix_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 138 */       if (criteria.getSkillsMatrixId() != null)
/*     */       {
/* 140 */         specification = specification.and(
/* 141 */             buildSpecification((RangeFilter)criteria
/* 142 */               .getSkillsMatrixId(), root -> root.join(Project_.skillsMatrix, JoinType.LEFT).get(SkillsMatrix_.id)));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 148 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\ProjectQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */