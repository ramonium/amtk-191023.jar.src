/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Employee;
/*     */ import com.nanosoft.amtk.domain.EmployeeTitle;
/*     */ import com.nanosoft.amtk.domain.Team;
/*     */ import com.nanosoft.amtk.service.dto.EmployeeDTO;
/*     */ import com.nanosoft.amtk.service.dto.EmployeeTitleDTO;
/*     */ import com.nanosoft.amtk.service.dto.TeamDTO;
/*     */ import com.nanosoft.amtk.service.mapper.EmployeeMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Component
/*     */ public class EmployeeMapperImpl
/*     */   implements EmployeeMapper
/*     */ {
/*     */   public Employee toEntity(EmployeeDTO dto) {
/*  24 */     if (dto == null) {
/*  25 */       return null;
/*     */     }
/*     */     
/*  28 */     Employee employee = new Employee();
/*     */     
/*  30 */     employee.createdBy(dto.getCreatedBy());
/*  31 */     employee.createdDate(dto.getCreatedDate());
/*  32 */     employee.lastModifiedBy(dto.getLastModifiedBy());
/*  33 */     employee.lastModifiedDate(dto.getLastModifiedDate());
/*  34 */     employee.setId(dto.getId());
/*  35 */     employee.setFirstName(dto.getFirstName());
/*  36 */     employee.setLastName(dto.getLastName());
/*  37 */     employee.setThirdName(dto.getThirdName());
/*  38 */     employee.setGender(dto.getGender());
/*  39 */     employee.setIdNumber(dto.getIdNumber());
/*  40 */     employee.setBirthday(dto.getBirthday());
/*  41 */     employee.setJoiningDate(dto.getJoiningDate());
/*  42 */     employee.setRelievingDate(dto.getRelievingDate());
/*  43 */     employee.setEmployeeNumber(dto.getEmployeeNumber());
/*  44 */     employee.title(employeeTitleDTOToEmployeeTitle(dto.getTitle()));
/*  45 */     employee.team(teamDTOToTeam(dto.getTeam()));
/*     */     
/*  47 */     return employee;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Employee> toEntity(List<EmployeeDTO> dtoList) {
/*  52 */     if (dtoList == null) {
/*  53 */       return null;
/*     */     }
/*     */     
/*  56 */     List<Employee> list = new ArrayList<>(dtoList.size());
/*  57 */     for (EmployeeDTO employeeDTO : dtoList) {
/*  58 */       list.add(toEntity(employeeDTO));
/*     */     }
/*     */     
/*  61 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<EmployeeDTO> toDto(List<Employee> entityList) {
/*  66 */     if (entityList == null) {
/*  67 */       return null;
/*     */     }
/*     */     
/*  70 */     List<EmployeeDTO> list = new ArrayList<>(entityList.size());
/*  71 */     for (Employee employee : entityList) {
/*  72 */       list.add(toDto(employee));
/*     */     }
/*     */     
/*  75 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(Employee entity, EmployeeDTO dto) {
/*  80 */     if (dto == null) {
/*     */       return;
/*     */     }
/*     */     
/*  84 */     if (dto.getCreatedBy() != null) {
/*  85 */       entity.createdBy(dto.getCreatedBy());
/*     */     }
/*  87 */     if (dto.getCreatedDate() != null) {
/*  88 */       entity.createdDate(dto.getCreatedDate());
/*     */     }
/*  90 */     if (dto.getLastModifiedBy() != null) {
/*  91 */       entity.lastModifiedBy(dto.getLastModifiedBy());
/*     */     }
/*  93 */     if (dto.getLastModifiedDate() != null) {
/*  94 */       entity.lastModifiedDate(dto.getLastModifiedDate());
/*     */     }
/*  96 */     if (dto.getId() != null) {
/*  97 */       entity.setId(dto.getId());
/*     */     }
/*  99 */     if (dto.getFirstName() != null) {
/* 100 */       entity.setFirstName(dto.getFirstName());
/*     */     }
/* 102 */     if (dto.getLastName() != null) {
/* 103 */       entity.setLastName(dto.getLastName());
/*     */     }
/* 105 */     if (dto.getThirdName() != null) {
/* 106 */       entity.setThirdName(dto.getThirdName());
/*     */     }
/* 108 */     if (dto.getGender() != null) {
/* 109 */       entity.setGender(dto.getGender());
/*     */     }
/* 111 */     if (dto.getIdNumber() != null) {
/* 112 */       entity.setIdNumber(dto.getIdNumber());
/*     */     }
/* 114 */     if (dto.getBirthday() != null) {
/* 115 */       entity.setBirthday(dto.getBirthday());
/*     */     }
/* 117 */     if (dto.getJoiningDate() != null) {
/* 118 */       entity.setJoiningDate(dto.getJoiningDate());
/*     */     }
/* 120 */     if (dto.getRelievingDate() != null) {
/* 121 */       entity.setRelievingDate(dto.getRelievingDate());
/*     */     }
/* 123 */     if (dto.getEmployeeNumber() != null) {
/* 124 */       entity.setEmployeeNumber(dto.getEmployeeNumber());
/*     */     }
/* 126 */     if (dto.getTitle() != null) {
/* 127 */       if (entity.getTitle() == null) {
/* 128 */         entity.title(new EmployeeTitle());
/*     */       }
/* 130 */       employeeTitleDTOToEmployeeTitle1(dto.getTitle(), entity.getTitle());
/*     */     } 
/* 132 */     if (dto.getTeam() != null) {
/* 133 */       if (entity.getTeam() == null) {
/* 134 */         entity.team(new Team());
/*     */       }
/* 136 */       teamDTOToTeam1(dto.getTeam(), entity.getTeam());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public EmployeeDTO toDto(Employee s) {
/* 142 */     if (s == null) {
/* 143 */       return null;
/*     */     }
/*     */     
/* 146 */     EmployeeDTO employeeDTO = new EmployeeDTO();
/*     */     
/* 148 */     employeeDTO.setTitle(toDtoEmployeeTitleName(s.getTitle()));
/* 149 */     employeeDTO.setTeam(toDtoTeamName(s.getTeam()));
/* 150 */     employeeDTO.setId(s.getId());
/* 151 */     employeeDTO.setFirstName(s.getFirstName());
/* 152 */     employeeDTO.setLastName(s.getLastName());
/* 153 */     employeeDTO.setThirdName(s.getThirdName());
/* 154 */     employeeDTO.setGender(s.getGender());
/* 155 */     employeeDTO.setIdNumber(s.getIdNumber());
/* 156 */     employeeDTO.setBirthday(s.getBirthday());
/* 157 */     employeeDTO.setJoiningDate(s.getJoiningDate());
/* 158 */     employeeDTO.setRelievingDate(s.getRelievingDate());
/* 159 */     employeeDTO.setEmployeeNumber(s.getEmployeeNumber());
/* 160 */     employeeDTO.setCreatedBy(s.getCreatedBy());
/* 161 */     employeeDTO.setCreatedDate(s.getCreatedDate());
/* 162 */     employeeDTO.setLastModifiedBy(s.getLastModifiedBy());
/* 163 */     employeeDTO.setLastModifiedDate(s.getLastModifiedDate());
/*     */     
/* 165 */     return employeeDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public EmployeeTitleDTO toDtoEmployeeTitleName(EmployeeTitle employeeTitle) {
/* 170 */     if (employeeTitle == null) {
/* 171 */       return null;
/*     */     }
/*     */     
/* 174 */     EmployeeTitleDTO employeeTitleDTO = new EmployeeTitleDTO();
/*     */     
/* 176 */     employeeTitleDTO.setId(employeeTitle.getId());
/* 177 */     employeeTitleDTO.setName(employeeTitle.getName());
/*     */     
/* 179 */     return employeeTitleDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public TeamDTO toDtoTeamName(Team team) {
/* 184 */     if (team == null) {
/* 185 */       return null;
/*     */     }
/*     */     
/* 188 */     TeamDTO teamDTO = new TeamDTO();
/*     */     
/* 190 */     teamDTO.setId(team.getId());
/* 191 */     teamDTO.setName(team.getName());
/*     */     
/* 193 */     return teamDTO;
/*     */   }
/*     */   
/*     */   protected EmployeeTitle employeeTitleDTOToEmployeeTitle(EmployeeTitleDTO employeeTitleDTO) {
/* 197 */     if (employeeTitleDTO == null) {
/* 198 */       return null;
/*     */     }
/*     */     
/* 201 */     EmployeeTitle employeeTitle = new EmployeeTitle();
/*     */     
/* 203 */     employeeTitle.createdBy(employeeTitleDTO.getCreatedBy());
/* 204 */     employeeTitle.createdDate(employeeTitleDTO.getCreatedDate());
/* 205 */     employeeTitle.lastModifiedBy(employeeTitleDTO.getLastModifiedBy());
/* 206 */     employeeTitle.lastModifiedDate(employeeTitleDTO.getLastModifiedDate());
/* 207 */     employeeTitle.setId(employeeTitleDTO.getId());
/* 208 */     employeeTitle.setName(employeeTitleDTO.getName());
/* 209 */     employeeTitle.setDescription(employeeTitleDTO.getDescription());
/* 210 */     employeeTitle.setCanSupervise(employeeTitleDTO.getCanSupervise());
/*     */     
/* 212 */     return employeeTitle;
/*     */   }
/*     */   
/*     */   protected Team teamDTOToTeam(TeamDTO teamDTO) {
/* 216 */     if (teamDTO == null) {
/* 217 */       return null;
/*     */     }
/*     */     
/* 220 */     Team team = new Team();
/*     */     
/* 222 */     team.createdBy(teamDTO.getCreatedBy());
/* 223 */     team.createdDate(teamDTO.getCreatedDate());
/* 224 */     team.lastModifiedBy(teamDTO.getLastModifiedBy());
/* 225 */     team.lastModifiedDate(teamDTO.getLastModifiedDate());
/* 226 */     team.setId(teamDTO.getId());
/* 227 */     team.setName(teamDTO.getName());
/* 228 */     team.setDescription(teamDTO.getDescription());
/* 229 */     team.supervisor(toEntity(teamDTO.getSupervisor()));
/*     */     
/* 231 */     return team;
/*     */   }
/*     */   
/*     */   protected void employeeTitleDTOToEmployeeTitle1(EmployeeTitleDTO employeeTitleDTO, EmployeeTitle mappingTarget) {
/* 235 */     if (employeeTitleDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 239 */     if (employeeTitleDTO.getCreatedBy() != null) {
/* 240 */       mappingTarget.createdBy(employeeTitleDTO.getCreatedBy());
/*     */     }
/* 242 */     if (employeeTitleDTO.getCreatedDate() != null) {
/* 243 */       mappingTarget.createdDate(employeeTitleDTO.getCreatedDate());
/*     */     }
/* 245 */     if (employeeTitleDTO.getLastModifiedBy() != null) {
/* 246 */       mappingTarget.lastModifiedBy(employeeTitleDTO.getLastModifiedBy());
/*     */     }
/* 248 */     if (employeeTitleDTO.getLastModifiedDate() != null) {
/* 249 */       mappingTarget.lastModifiedDate(employeeTitleDTO.getLastModifiedDate());
/*     */     }
/* 251 */     if (employeeTitleDTO.getId() != null) {
/* 252 */       mappingTarget.setId(employeeTitleDTO.getId());
/*     */     }
/* 254 */     if (employeeTitleDTO.getName() != null) {
/* 255 */       mappingTarget.setName(employeeTitleDTO.getName());
/*     */     }
/* 257 */     if (employeeTitleDTO.getDescription() != null) {
/* 258 */       mappingTarget.setDescription(employeeTitleDTO.getDescription());
/*     */     }
/* 260 */     if (employeeTitleDTO.getCanSupervise() != null) {
/* 261 */       mappingTarget.setCanSupervise(employeeTitleDTO.getCanSupervise());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void teamDTOToTeam1(TeamDTO teamDTO, Team mappingTarget) {
/* 266 */     if (teamDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 270 */     if (teamDTO.getCreatedBy() != null) {
/* 271 */       mappingTarget.createdBy(teamDTO.getCreatedBy());
/*     */     }
/* 273 */     if (teamDTO.getCreatedDate() != null) {
/* 274 */       mappingTarget.createdDate(teamDTO.getCreatedDate());
/*     */     }
/* 276 */     if (teamDTO.getLastModifiedBy() != null) {
/* 277 */       mappingTarget.lastModifiedBy(teamDTO.getLastModifiedBy());
/*     */     }
/* 279 */     if (teamDTO.getLastModifiedDate() != null) {
/* 280 */       mappingTarget.lastModifiedDate(teamDTO.getLastModifiedDate());
/*     */     }
/* 282 */     if (teamDTO.getId() != null) {
/* 283 */       mappingTarget.setId(teamDTO.getId());
/*     */     }
/* 285 */     if (teamDTO.getName() != null) {
/* 286 */       mappingTarget.setName(teamDTO.getName());
/*     */     }
/* 288 */     if (teamDTO.getDescription() != null) {
/* 289 */       mappingTarget.setDescription(teamDTO.getDescription());
/*     */     }
/* 291 */     if (teamDTO.getSupervisor() != null)
/* 292 */       mappingTarget.supervisor(toEntity(teamDTO.getSupervisor())); 
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\EmployeeMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */