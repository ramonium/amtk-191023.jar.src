/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Employee;
/*     */ import com.nanosoft.amtk.domain.EmployeeTitle;
/*     */ import com.nanosoft.amtk.domain.Team;
/*     */ import com.nanosoft.amtk.service.dto.EmployeeDTO;
/*     */ import com.nanosoft.amtk.service.dto.EmployeeTitleDTO;
/*     */ import com.nanosoft.amtk.service.dto.TeamDTO;
/*     */ import com.nanosoft.amtk.service.mapper.TeamMapper;
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
/*     */ public class TeamMapperImpl
/*     */   implements TeamMapper
/*     */ {
/*     */   public Team toEntity(TeamDTO dto) {
/*  24 */     if (dto == null) {
/*  25 */       return null;
/*     */     }
/*     */     
/*  28 */     Team team = new Team();
/*     */     
/*  30 */     team.createdBy(dto.getCreatedBy());
/*  31 */     team.createdDate(dto.getCreatedDate());
/*  32 */     team.lastModifiedBy(dto.getLastModifiedBy());
/*  33 */     team.lastModifiedDate(dto.getLastModifiedDate());
/*  34 */     team.setId(dto.getId());
/*  35 */     team.setName(dto.getName());
/*  36 */     team.setDescription(dto.getDescription());
/*  37 */     team.supervisor(employeeDTOToEmployee(dto.getSupervisor()));
/*     */     
/*  39 */     return team;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Team> toEntity(List<TeamDTO> dtoList) {
/*  44 */     if (dtoList == null) {
/*  45 */       return null;
/*     */     }
/*     */     
/*  48 */     List<Team> list = new ArrayList<>(dtoList.size());
/*  49 */     for (TeamDTO teamDTO : dtoList) {
/*  50 */       list.add(toEntity(teamDTO));
/*     */     }
/*     */     
/*  53 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<TeamDTO> toDto(List<Team> entityList) {
/*  58 */     if (entityList == null) {
/*  59 */       return null;
/*     */     }
/*     */     
/*  62 */     List<TeamDTO> list = new ArrayList<>(entityList.size());
/*  63 */     for (Team team : entityList) {
/*  64 */       list.add(toDto(team));
/*     */     }
/*     */     
/*  67 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(Team entity, TeamDTO dto) {
/*  72 */     if (dto == null) {
/*     */       return;
/*     */     }
/*     */     
/*  76 */     if (dto.getCreatedBy() != null) {
/*  77 */       entity.createdBy(dto.getCreatedBy());
/*     */     }
/*  79 */     if (dto.getCreatedDate() != null) {
/*  80 */       entity.createdDate(dto.getCreatedDate());
/*     */     }
/*  82 */     if (dto.getLastModifiedBy() != null) {
/*  83 */       entity.lastModifiedBy(dto.getLastModifiedBy());
/*     */     }
/*  85 */     if (dto.getLastModifiedDate() != null) {
/*  86 */       entity.lastModifiedDate(dto.getLastModifiedDate());
/*     */     }
/*  88 */     if (dto.getId() != null) {
/*  89 */       entity.setId(dto.getId());
/*     */     }
/*  91 */     if (dto.getName() != null) {
/*  92 */       entity.setName(dto.getName());
/*     */     }
/*  94 */     if (dto.getDescription() != null) {
/*  95 */       entity.setDescription(dto.getDescription());
/*     */     }
/*  97 */     if (dto.getSupervisor() != null) {
/*  98 */       if (entity.getSupervisor() == null) {
/*  99 */         entity.supervisor(new Employee());
/*     */       }
/* 101 */       employeeDTOToEmployee1(dto.getSupervisor(), entity.getSupervisor());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public TeamDTO toDto(Team s) {
/* 107 */     if (s == null) {
/* 108 */       return null;
/*     */     }
/*     */     
/* 111 */     TeamDTO teamDTO = new TeamDTO();
/*     */     
/* 113 */     teamDTO.setSupervisor(toDtoEmployeeId(s.getSupervisor()));
/* 114 */     teamDTO.setId(s.getId());
/* 115 */     teamDTO.setName(s.getName());
/* 116 */     teamDTO.setDescription(s.getDescription());
/* 117 */     teamDTO.setCreatedBy(s.getCreatedBy());
/* 118 */     teamDTO.setCreatedDate(s.getCreatedDate());
/* 119 */     teamDTO.setLastModifiedBy(s.getLastModifiedBy());
/* 120 */     teamDTO.setLastModifiedDate(s.getLastModifiedDate());
/*     */     
/* 122 */     return teamDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public EmployeeDTO toDtoEmployeeId(Employee employee) {
/* 127 */     if (employee == null) {
/* 128 */       return null;
/*     */     }
/*     */     
/* 131 */     EmployeeDTO employeeDTO = new EmployeeDTO();
/*     */     
/* 133 */     employeeDTO.setId(employee.getId());
/* 134 */     employeeDTO.setFirstName(employee.getFirstName());
/* 135 */     employeeDTO.setLastName(employee.getLastName());
/* 136 */     employeeDTO.setEmployeeNumber(employee.getEmployeeNumber());
/* 137 */     employeeDTO.setTitle(employeeTitleToEmployeeTitleDTO(employee.getTitle()));
/*     */     
/* 139 */     return employeeDTO;
/*     */   }
/*     */   
/*     */   protected EmployeeTitle employeeTitleDTOToEmployeeTitle(EmployeeTitleDTO employeeTitleDTO) {
/* 143 */     if (employeeTitleDTO == null) {
/* 144 */       return null;
/*     */     }
/*     */     
/* 147 */     EmployeeTitle employeeTitle = new EmployeeTitle();
/*     */     
/* 149 */     employeeTitle.createdBy(employeeTitleDTO.getCreatedBy());
/* 150 */     employeeTitle.createdDate(employeeTitleDTO.getCreatedDate());
/* 151 */     employeeTitle.lastModifiedBy(employeeTitleDTO.getLastModifiedBy());
/* 152 */     employeeTitle.lastModifiedDate(employeeTitleDTO.getLastModifiedDate());
/* 153 */     employeeTitle.setId(employeeTitleDTO.getId());
/* 154 */     employeeTitle.setName(employeeTitleDTO.getName());
/* 155 */     employeeTitle.setDescription(employeeTitleDTO.getDescription());
/* 156 */     employeeTitle.setCanSupervise(employeeTitleDTO.getCanSupervise());
/*     */     
/* 158 */     return employeeTitle;
/*     */   }
/*     */   
/*     */   protected Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
/* 162 */     if (employeeDTO == null) {
/* 163 */       return null;
/*     */     }
/*     */     
/* 166 */     Employee employee = new Employee();
/*     */     
/* 168 */     employee.createdBy(employeeDTO.getCreatedBy());
/* 169 */     employee.createdDate(employeeDTO.getCreatedDate());
/* 170 */     employee.lastModifiedBy(employeeDTO.getLastModifiedBy());
/* 171 */     employee.lastModifiedDate(employeeDTO.getLastModifiedDate());
/* 172 */     employee.setId(employeeDTO.getId());
/* 173 */     employee.setFirstName(employeeDTO.getFirstName());
/* 174 */     employee.setLastName(employeeDTO.getLastName());
/* 175 */     employee.setThirdName(employeeDTO.getThirdName());
/* 176 */     employee.setGender(employeeDTO.getGender());
/* 177 */     employee.setIdNumber(employeeDTO.getIdNumber());
/* 178 */     employee.setBirthday(employeeDTO.getBirthday());
/* 179 */     employee.setJoiningDate(employeeDTO.getJoiningDate());
/* 180 */     employee.setRelievingDate(employeeDTO.getRelievingDate());
/* 181 */     employee.setEmployeeNumber(employeeDTO.getEmployeeNumber());
/* 182 */     employee.title(employeeTitleDTOToEmployeeTitle(employeeDTO.getTitle()));
/* 183 */     employee.team(toEntity(employeeDTO.getTeam()));
/*     */     
/* 185 */     return employee;
/*     */   }
/*     */   
/*     */   protected void employeeTitleDTOToEmployeeTitle1(EmployeeTitleDTO employeeTitleDTO, EmployeeTitle mappingTarget) {
/* 189 */     if (employeeTitleDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 193 */     if (employeeTitleDTO.getCreatedBy() != null) {
/* 194 */       mappingTarget.createdBy(employeeTitleDTO.getCreatedBy());
/*     */     }
/* 196 */     if (employeeTitleDTO.getCreatedDate() != null) {
/* 197 */       mappingTarget.createdDate(employeeTitleDTO.getCreatedDate());
/*     */     }
/* 199 */     if (employeeTitleDTO.getLastModifiedBy() != null) {
/* 200 */       mappingTarget.lastModifiedBy(employeeTitleDTO.getLastModifiedBy());
/*     */     }
/* 202 */     if (employeeTitleDTO.getLastModifiedDate() != null) {
/* 203 */       mappingTarget.lastModifiedDate(employeeTitleDTO.getLastModifiedDate());
/*     */     }
/* 205 */     if (employeeTitleDTO.getId() != null) {
/* 206 */       mappingTarget.setId(employeeTitleDTO.getId());
/*     */     }
/* 208 */     if (employeeTitleDTO.getName() != null) {
/* 209 */       mappingTarget.setName(employeeTitleDTO.getName());
/*     */     }
/* 211 */     if (employeeTitleDTO.getDescription() != null) {
/* 212 */       mappingTarget.setDescription(employeeTitleDTO.getDescription());
/*     */     }
/* 214 */     if (employeeTitleDTO.getCanSupervise() != null) {
/* 215 */       mappingTarget.setCanSupervise(employeeTitleDTO.getCanSupervise());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void employeeDTOToEmployee1(EmployeeDTO employeeDTO, Employee mappingTarget) {
/* 220 */     if (employeeDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 224 */     if (employeeDTO.getCreatedBy() != null) {
/* 225 */       mappingTarget.createdBy(employeeDTO.getCreatedBy());
/*     */     }
/* 227 */     if (employeeDTO.getCreatedDate() != null) {
/* 228 */       mappingTarget.createdDate(employeeDTO.getCreatedDate());
/*     */     }
/* 230 */     if (employeeDTO.getLastModifiedBy() != null) {
/* 231 */       mappingTarget.lastModifiedBy(employeeDTO.getLastModifiedBy());
/*     */     }
/* 233 */     if (employeeDTO.getLastModifiedDate() != null) {
/* 234 */       mappingTarget.lastModifiedDate(employeeDTO.getLastModifiedDate());
/*     */     }
/* 236 */     if (employeeDTO.getId() != null) {
/* 237 */       mappingTarget.setId(employeeDTO.getId());
/*     */     }
/* 239 */     if (employeeDTO.getFirstName() != null) {
/* 240 */       mappingTarget.setFirstName(employeeDTO.getFirstName());
/*     */     }
/* 242 */     if (employeeDTO.getLastName() != null) {
/* 243 */       mappingTarget.setLastName(employeeDTO.getLastName());
/*     */     }
/* 245 */     if (employeeDTO.getThirdName() != null) {
/* 246 */       mappingTarget.setThirdName(employeeDTO.getThirdName());
/*     */     }
/* 248 */     if (employeeDTO.getGender() != null) {
/* 249 */       mappingTarget.setGender(employeeDTO.getGender());
/*     */     }
/* 251 */     if (employeeDTO.getIdNumber() != null) {
/* 252 */       mappingTarget.setIdNumber(employeeDTO.getIdNumber());
/*     */     }
/* 254 */     if (employeeDTO.getBirthday() != null) {
/* 255 */       mappingTarget.setBirthday(employeeDTO.getBirthday());
/*     */     }
/* 257 */     if (employeeDTO.getJoiningDate() != null) {
/* 258 */       mappingTarget.setJoiningDate(employeeDTO.getJoiningDate());
/*     */     }
/* 260 */     if (employeeDTO.getRelievingDate() != null) {
/* 261 */       mappingTarget.setRelievingDate(employeeDTO.getRelievingDate());
/*     */     }
/* 263 */     if (employeeDTO.getEmployeeNumber() != null) {
/* 264 */       mappingTarget.setEmployeeNumber(employeeDTO.getEmployeeNumber());
/*     */     }
/* 266 */     if (employeeDTO.getTitle() != null) {
/* 267 */       if (mappingTarget.getTitle() == null) {
/* 268 */         mappingTarget.title(new EmployeeTitle());
/*     */       }
/* 270 */       employeeTitleDTOToEmployeeTitle1(employeeDTO.getTitle(), mappingTarget.getTitle());
/*     */     } 
/* 272 */     if (employeeDTO.getTeam() != null) {
/* 273 */       mappingTarget.team(toEntity(employeeDTO.getTeam()));
/*     */     }
/*     */   }
/*     */   
/*     */   protected EmployeeTitleDTO employeeTitleToEmployeeTitleDTO(EmployeeTitle employeeTitle) {
/* 278 */     if (employeeTitle == null) {
/* 279 */       return null;
/*     */     }
/*     */     
/* 282 */     EmployeeTitleDTO employeeTitleDTO = new EmployeeTitleDTO();
/*     */     
/* 284 */     employeeTitleDTO.setId(employeeTitle.getId());
/* 285 */     employeeTitleDTO.setName(employeeTitle.getName());
/* 286 */     employeeTitleDTO.setDescription(employeeTitle.getDescription());
/* 287 */     employeeTitleDTO.setCanSupervise(employeeTitle.getCanSupervise());
/* 288 */     employeeTitleDTO.setCreatedBy(employeeTitle.getCreatedBy());
/* 289 */     employeeTitleDTO.setCreatedDate(employeeTitle.getCreatedDate());
/* 290 */     employeeTitleDTO.setLastModifiedBy(employeeTitle.getLastModifiedBy());
/* 291 */     employeeTitleDTO.setLastModifiedDate(employeeTitle.getLastModifiedDate());
/*     */     
/* 293 */     return employeeTitleDTO;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\TeamMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */