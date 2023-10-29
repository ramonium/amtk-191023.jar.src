/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Employee_;
/*     */ import com.nanosoft.amtk.domain.Team;
/*     */ import com.nanosoft.amtk.domain.Team_;
/*     */ import com.nanosoft.amtk.repository.TeamRepository;
/*     */ import com.nanosoft.amtk.service.criteria.TeamCriteria;
/*     */ import com.nanosoft.amtk.service.dto.TeamDTO;
/*     */ import com.nanosoft.amtk.service.mapper.TeamMapper;
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
/*     */ public class TeamQueryService
/*     */   extends QueryService<Team>
/*     */ {
/*  30 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.TeamQueryService.class);
/*     */   
/*     */   private final TeamRepository teamRepository;
/*     */   
/*     */   private final TeamMapper teamMapper;
/*     */   
/*     */   public TeamQueryService(TeamRepository teamRepository, TeamMapper teamMapper) {
/*  37 */     this.teamRepository = teamRepository;
/*  38 */     this.teamMapper = teamMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<TeamDTO> findByCriteria(TeamCriteria criteria) {
/*  48 */     this.log.debug("find by criteria : {}", criteria);
/*  49 */     Specification<Team> specification = createSpecification(criteria);
/*  50 */     return this.teamMapper.toDto(this.teamRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<TeamDTO> findByCriteria(TeamCriteria criteria, Pageable page) {
/*  61 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*  62 */     Specification<Team> specification = createSpecification(criteria);
/*  63 */     Objects.requireNonNull(this.teamMapper); return this.teamRepository.findAll(specification, page).map(this.teamMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(TeamCriteria criteria) {
/*  73 */     this.log.debug("count by criteria : {}", criteria);
/*  74 */     Specification<Team> specification = createSpecification(criteria);
/*  75 */     return this.teamRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<Team> createSpecification(TeamCriteria criteria) {
/*  84 */     Specification<Team> specification = Specification.where(null);
/*  85 */     if (criteria != null) {
/*     */       
/*  87 */       if (criteria.getDistinct() != null) {
/*  88 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/*  90 */       if (criteria.getId() != null) {
/*  91 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), Team_.id));
/*     */       }
/*  93 */       if (criteria.getName() != null) {
/*  94 */         specification = specification.and(buildStringSpecification(criteria.getName(), Team_.name));
/*     */       }
/*  96 */       if (criteria.getDescription() != null) {
/*  97 */         specification = specification.and(buildStringSpecification(criteria.getDescription(), Team_.description));
/*     */       }
/*  99 */       if (criteria.getCreatedBy() != null) {
/* 100 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), Team_.createdBy));
/*     */       }
/* 102 */       if (criteria.getCreatedDate() != null) {
/* 103 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), Team_.createdDate));
/*     */       }
/* 105 */       if (criteria.getLastModifiedBy() != null) {
/* 106 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), Team_.lastModifiedBy));
/*     */       }
/* 108 */       if (criteria.getLastModifiedDate() != null) {
/* 109 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), Team_.lastModifiedDate));
/*     */       }
/* 111 */       if (criteria.getEmployeeId() != null)
/*     */       {
/* 113 */         specification = specification.and(
/* 114 */             buildSpecification((RangeFilter)criteria.getEmployeeId(), root -> root.join(Team_.employees, JoinType.LEFT).get(Employee_.id)));
/*     */       }
/*     */       
/* 117 */       if (criteria.getSupervisorId() != null)
/*     */       {
/* 119 */         specification = specification.and(
/* 120 */             buildSpecification((RangeFilter)criteria.getSupervisorId(), root -> root.join(Team_.supervisor, JoinType.LEFT).get(Employee_.id)));
/*     */       }
/*     */     } 
/*     */     
/* 124 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\TeamQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */