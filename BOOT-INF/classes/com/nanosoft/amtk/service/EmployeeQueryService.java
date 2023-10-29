/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ import com.nanosoft.amtk.domain.Assignment_;
/*     */ import com.nanosoft.amtk.domain.Attachment_;
/*     */ import com.nanosoft.amtk.domain.Employee;
/*     */ import com.nanosoft.amtk.domain.EmployeeTitle_;
/*     */ import com.nanosoft.amtk.domain.Employee_;
/*     */ import com.nanosoft.amtk.domain.Team_;
/*     */ import com.nanosoft.amtk.repository.EmployeeRepository;
/*     */ import com.nanosoft.amtk.security.SecurityUtils;
/*     */ import com.nanosoft.amtk.service.TeamQueryService;
/*     */ import com.nanosoft.amtk.service.UserInfoQueryService;
/*     */ import com.nanosoft.amtk.service.criteria.EmployeeCriteria;
/*     */ import com.nanosoft.amtk.service.criteria.TeamCriteria;
/*     */ import com.nanosoft.amtk.service.criteria.UserInfoCriteria;
/*     */ import com.nanosoft.amtk.service.dto.EmployeeDTO;
/*     */ import com.nanosoft.amtk.service.dto.TeamDTO;
/*     */ import com.nanosoft.amtk.service.dto.UserInfoDTO;
/*     */ import com.nanosoft.amtk.service.mapper.EmployeeMapper;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collectors;
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
/*     */ import tech.jhipster.service.filter.LongFilter;
/*     */ import tech.jhipster.service.filter.RangeFilter;
/*     */ import tech.jhipster.service.filter.StringFilter;
/*     */ 
/*     */ @Service
/*     */ @Transactional(readOnly = true)
/*     */ public class EmployeeQueryService extends QueryService<Employee> {
/*  39 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.EmployeeQueryService.class);
/*     */ 
/*     */   
/*     */   private final EmployeeRepository employeeRepository;
/*     */ 
/*     */   
/*     */   private final EmployeeMapper employeeMapper;
/*     */ 
/*     */   
/*     */   private final UserInfoQueryService userInfoQueryService;
/*     */ 
/*     */   
/*     */   private final TeamQueryService teamQueryService;
/*     */ 
/*     */   
/*     */   public EmployeeQueryService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper, UserInfoQueryService userInfoQueryService, TeamQueryService teamQueryService) {
/*  55 */     this.employeeRepository = employeeRepository;
/*  56 */     this.employeeMapper = employeeMapper;
/*  57 */     this.userInfoQueryService = userInfoQueryService;
/*  58 */     this.teamQueryService = teamQueryService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<EmployeeDTO> findByCriteria(EmployeeCriteria criteria) {
/*  68 */     this.log.debug("find by criteria : {}", criteria);
/*  69 */     Specification<Employee> specification = createSpecification(criteria);
/*  70 */     return this.employeeMapper.toDto(this.employeeRepository.findAll(specification));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<EmployeeDTO> findByCriteria(EmployeeCriteria criteria, Pageable page) {
/*  81 */     this.log.debug("find by criteria : {}, page: {}", criteria, page);
/*     */     
/*  83 */     StringFilter stringFilter = new StringFilter();
/*  84 */     stringFilter.setEquals(SecurityUtils.getCurrentUserLogin().get());
/*  85 */     UserInfoCriteria userInfoCriteria = new UserInfoCriteria();
/*  86 */     userInfoCriteria.setUserLogin(stringFilter);
/*  87 */     List<UserInfoDTO> userInfos = this.userInfoQueryService.findByCriteria(userInfoCriteria);
/*     */     
/*  89 */     if (userInfos.size() > 0) {
/*  90 */       UserInfoDTO userInfo = userInfos.get(0);
/*     */       
/*  92 */       if (userInfo.getRelatedEmployee().getTitle().getCanSupervise().booleanValue()) {
/*  93 */         LongFilter supervisorId = new LongFilter();
/*  94 */         supervisorId.setEquals(userInfo.getRelatedEmployee().getId());
/*  95 */         TeamCriteria teamCriteria = new TeamCriteria();
/*  96 */         teamCriteria.setSupervisorId(supervisorId);
/*  97 */         List<TeamDTO> managedTeams = this.teamQueryService.findByCriteria(teamCriteria);
/*     */         
/*  99 */         LongFilter teamsIdFilter = new LongFilter();
/* 100 */         teamsIdFilter.setIn((List)managedTeams.stream().map(TeamDTO::getId).collect(Collectors.toList()));
/* 101 */         criteria.setTeamId(teamsIdFilter);
/*     */       } 
/*     */     } 
/*     */     
/* 105 */     Specification<Employee> specification = createSpecification(criteria);
/* 106 */     Objects.requireNonNull(this.employeeMapper); return this.employeeRepository.findAll(specification, page).map(this.employeeMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public long countByCriteria(EmployeeCriteria criteria) {
/* 116 */     this.log.debug("count by criteria : {}", criteria);
/* 117 */     Specification<Employee> specification = createSpecification(criteria);
/* 118 */     return this.employeeRepository.count(specification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Specification<Employee> createSpecification(EmployeeCriteria criteria) {
/* 127 */     Specification<Employee> specification = Specification.where(null);
/* 128 */     if (criteria != null) {
/*     */       
/* 130 */       if (criteria.getDistinct() != null) {
/* 131 */         specification = specification.and(distinct(criteria.getDistinct().booleanValue()));
/*     */       }
/* 133 */       if (criteria.getFilter() != null) {
/* 134 */         Specification<Employee> filterSpecification = buildStringSpecification(criteria.getFilter(), Employee_.firstName);
/* 135 */         filterSpecification = filterSpecification.or(buildStringSpecification(criteria.getFilter(), Employee_.lastName));
/* 136 */         filterSpecification = filterSpecification.or(buildStringSpecification(criteria.getFilter(), Employee_.thirdName));
/* 137 */         filterSpecification = filterSpecification.or(buildStringSpecification(criteria.getFilter(), Employee_.employeeNumber));
/* 138 */         filterSpecification = filterSpecification.or(buildStringSpecification(criteria.getFilter(), Employee_.idNumber));
/* 139 */         specification = specification.and(filterSpecification);
/*     */       } 
/* 141 */       if (criteria.getId() != null) {
/* 142 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getId(), Employee_.id));
/*     */       }
/* 144 */       if (criteria.getFirstName() != null) {
/* 145 */         specification = specification.and(buildStringSpecification(criteria.getFirstName(), Employee_.firstName));
/*     */       }
/* 147 */       if (criteria.getLastName() != null) {
/* 148 */         specification = specification.and(buildStringSpecification(criteria.getLastName(), Employee_.lastName));
/*     */       }
/* 150 */       if (criteria.getThirdName() != null) {
/* 151 */         specification = specification.and(buildStringSpecification(criteria.getThirdName(), Employee_.thirdName));
/*     */       }
/* 153 */       if (criteria.getGender() != null) {
/* 154 */         specification = specification.and(buildStringSpecification(criteria.getGender(), Employee_.gender));
/*     */       }
/* 156 */       if (criteria.getIdNumber() != null) {
/* 157 */         specification = specification.and(buildStringSpecification(criteria.getIdNumber(), Employee_.idNumber));
/*     */       }
/* 159 */       if (criteria.getBirthday() != null) {
/* 160 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getBirthday(), Employee_.birthday));
/*     */       }
/* 162 */       if (criteria.getJoiningDate() != null) {
/* 163 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getJoiningDate(), Employee_.joiningDate));
/*     */       }
/* 165 */       if (criteria.getRelievingDate() != null) {
/* 166 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getRelievingDate(), Employee_.relievingDate));
/*     */       }
/* 168 */       if (criteria.getEmployeeNumber() != null) {
/* 169 */         specification = specification.and(buildStringSpecification(criteria.getEmployeeNumber(), Employee_.employeeNumber));
/*     */       }
/* 171 */       if (criteria.getCreatedBy() != null) {
/* 172 */         specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), Employee_.createdBy));
/*     */       }
/* 174 */       if (criteria.getCreatedDate() != null) {
/* 175 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getCreatedDate(), Employee_.createdDate));
/*     */       }
/* 177 */       if (criteria.getLastModifiedBy() != null) {
/* 178 */         specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), Employee_.lastModifiedBy));
/*     */       }
/* 180 */       if (criteria.getLastModifiedDate() != null) {
/* 181 */         specification = specification.and(buildRangeSpecification((RangeFilter)criteria.getLastModifiedDate(), Employee_.lastModifiedDate));
/*     */       }
/* 183 */       if (criteria.getAttachmentId() != null)
/*     */       {
/* 185 */         specification = specification.and(
/* 186 */             buildSpecification((RangeFilter)criteria
/* 187 */               .getAttachmentId(), root -> root.join(Employee_.attachments, JoinType.LEFT).get(Attachment_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 192 */       if (criteria.getAssignmentId() != null)
/*     */       {
/* 194 */         specification = specification.and(
/* 195 */             buildSpecification((RangeFilter)criteria
/* 196 */               .getAssignmentId(), root -> root.join(Employee_.assignments, JoinType.LEFT).get(Assignment_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 201 */       if (criteria.getTitleId() != null)
/*     */       {
/* 203 */         specification = specification.and(
/* 204 */             buildSpecification((RangeFilter)criteria.getTitleId(), root -> root.join(Employee_.title, JoinType.LEFT).get(EmployeeTitle_.id)));
/*     */       }
/*     */       
/* 207 */       if (criteria.getTeamId() != null)
/*     */       {
/* 209 */         specification = specification.and(
/* 210 */             buildSpecification((RangeFilter)criteria.getTeamId(), root -> root.join(Employee_.team, JoinType.LEFT).get(Team_.id)));
/*     */       }
/*     */       
/* 213 */       if (criteria.getManagedTeamId() != null)
/*     */       {
/* 215 */         specification = specification.and(
/* 216 */             buildSpecification((RangeFilter)criteria
/* 217 */               .getManagedTeamId(), root -> root.join(Employee_.managedTeams, JoinType.LEFT).get(Team_.id)));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 222 */       if (criteria.getCanSupervise() != null)
/*     */       {
/* 224 */         specification = specification.and(
/* 225 */             buildSpecification((Filter)criteria
/* 226 */               .getCanSupervise(), root -> root.join(Employee_.title, JoinType.LEFT).get(EmployeeTitle_.canSupervise)));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 232 */     return specification;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\EmployeeQueryService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */