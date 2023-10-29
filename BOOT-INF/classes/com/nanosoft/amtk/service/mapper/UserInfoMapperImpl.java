/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Employee;
/*     */ import com.nanosoft.amtk.domain.EmployeeTitle;
/*     */ import com.nanosoft.amtk.domain.Team;
/*     */ import com.nanosoft.amtk.domain.User;
/*     */ import com.nanosoft.amtk.domain.UserInfo;
/*     */ import com.nanosoft.amtk.service.dto.EmployeeDTO;
/*     */ import com.nanosoft.amtk.service.dto.EmployeeTitleDTO;
/*     */ import com.nanosoft.amtk.service.dto.TeamDTO;
/*     */ import com.nanosoft.amtk.service.dto.UserDTO;
/*     */ import com.nanosoft.amtk.service.dto.UserInfoDTO;
/*     */ import com.nanosoft.amtk.service.mapper.UserInfoMapper;
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
/*     */ public class UserInfoMapperImpl
/*     */   implements UserInfoMapper
/*     */ {
/*     */   public UserInfo toEntity(UserInfoDTO dto) {
/*  28 */     if (dto == null) {
/*  29 */       return null;
/*     */     }
/*     */     
/*  32 */     UserInfo userInfo = new UserInfo();
/*     */     
/*  34 */     userInfo.setId(dto.getId());
/*  35 */     userInfo.setDescription(dto.getDescription());
/*  36 */     userInfo.setCreatedBy(dto.getCreatedBy());
/*  37 */     userInfo.setCreatedDate(dto.getCreatedDate());
/*  38 */     userInfo.setLastModifiedBy(dto.getLastModifiedBy());
/*  39 */     userInfo.setLastModifiedDate(dto.getLastModifiedDate());
/*  40 */     userInfo.user(userDTOToUser(dto.getUser()));
/*  41 */     userInfo.relatedEmployee(employeeDTOToEmployee(dto.getRelatedEmployee()));
/*     */     
/*  43 */     return userInfo;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<UserInfo> toEntity(List<UserInfoDTO> dtoList) {
/*  48 */     if (dtoList == null) {
/*  49 */       return null;
/*     */     }
/*     */     
/*  52 */     List<UserInfo> list = new ArrayList<>(dtoList.size());
/*  53 */     for (UserInfoDTO userInfoDTO : dtoList) {
/*  54 */       list.add(toEntity(userInfoDTO));
/*     */     }
/*     */     
/*  57 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<UserInfoDTO> toDto(List<UserInfo> entityList) {
/*  62 */     if (entityList == null) {
/*  63 */       return null;
/*     */     }
/*     */     
/*  66 */     List<UserInfoDTO> list = new ArrayList<>(entityList.size());
/*  67 */     for (UserInfo userInfo : entityList) {
/*  68 */       list.add(toDto(userInfo));
/*     */     }
/*     */     
/*  71 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(UserInfo entity, UserInfoDTO dto) {
/*  76 */     if (dto == null) {
/*     */       return;
/*     */     }
/*     */     
/*  80 */     if (dto.getId() != null) {
/*  81 */       entity.setId(dto.getId());
/*     */     }
/*  83 */     if (dto.getDescription() != null) {
/*  84 */       entity.setDescription(dto.getDescription());
/*     */     }
/*  86 */     if (dto.getCreatedBy() != null) {
/*  87 */       entity.setCreatedBy(dto.getCreatedBy());
/*     */     }
/*  89 */     if (dto.getCreatedDate() != null) {
/*  90 */       entity.setCreatedDate(dto.getCreatedDate());
/*     */     }
/*  92 */     if (dto.getLastModifiedBy() != null) {
/*  93 */       entity.setLastModifiedBy(dto.getLastModifiedBy());
/*     */     }
/*  95 */     if (dto.getLastModifiedDate() != null) {
/*  96 */       entity.setLastModifiedDate(dto.getLastModifiedDate());
/*     */     }
/*  98 */     if (dto.getUser() != null) {
/*  99 */       if (entity.getUser() == null) {
/* 100 */         entity.user(new User());
/*     */       }
/* 102 */       userDTOToUser1(dto.getUser(), entity.getUser());
/*     */     } 
/* 104 */     if (dto.getRelatedEmployee() != null) {
/* 105 */       if (entity.getRelatedEmployee() == null) {
/* 106 */         entity.relatedEmployee(new Employee());
/*     */       }
/* 108 */       employeeDTOToEmployee1(dto.getRelatedEmployee(), entity.getRelatedEmployee());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public UserInfoDTO toDto(UserInfo s) {
/* 114 */     if (s == null) {
/* 115 */       return null;
/*     */     }
/*     */     
/* 118 */     UserInfoDTO userInfoDTO = new UserInfoDTO();
/*     */     
/* 120 */     userInfoDTO.setUser(userToUserDTO(s.getUser()));
/* 121 */     userInfoDTO.setRelatedEmployee(toDtoEmployeeId(s.getRelatedEmployee()));
/* 122 */     userInfoDTO.setId(s.getId());
/* 123 */     userInfoDTO.setDescription(s.getDescription());
/* 124 */     userInfoDTO.setCreatedBy(s.getCreatedBy());
/* 125 */     userInfoDTO.setCreatedDate(s.getCreatedDate());
/* 126 */     userInfoDTO.setLastModifiedBy(s.getLastModifiedBy());
/* 127 */     userInfoDTO.setLastModifiedDate(s.getLastModifiedDate());
/*     */     
/* 129 */     return userInfoDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public UserDTO toDtoUserId(User user) {
/* 134 */     if (user == null) {
/* 135 */       return null;
/*     */     }
/*     */     
/* 138 */     UserDTO userDTO = new UserDTO();
/*     */     
/* 140 */     userDTO.setId(user.getId());
/*     */     
/* 142 */     return userDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public EmployeeDTO toDtoEmployeeId(Employee employee) {
/* 147 */     if (employee == null) {
/* 148 */       return null;
/*     */     }
/*     */     
/* 151 */     EmployeeDTO employeeDTO = new EmployeeDTO();
/*     */     
/* 153 */     employeeDTO.setId(employee.getId());
/* 154 */     employeeDTO.setFirstName(employee.getFirstName());
/* 155 */     employeeDTO.setLastName(employee.getLastName());
/* 156 */     employeeDTO.setEmployeeNumber(employee.getEmployeeNumber());
/* 157 */     employeeDTO.setTitle(employeeTitleToEmployeeTitleDTO(employee.getTitle()));
/*     */     
/* 159 */     return employeeDTO;
/*     */   }
/*     */   
/*     */   protected User userDTOToUser(UserDTO userDTO) {
/* 163 */     if (userDTO == null) {
/* 164 */       return null;
/*     */     }
/*     */     
/* 167 */     User user = new User();
/*     */     
/* 169 */     user.setId(userDTO.getId());
/* 170 */     user.setLogin(userDTO.getLogin());
/* 171 */     user.setFirstName(userDTO.getFirstName());
/* 172 */     user.setLastName(userDTO.getLastName());
/* 173 */     user.setEmail(userDTO.getEmail());
/*     */     
/* 175 */     return user;
/*     */   }
/*     */   
/*     */   protected EmployeeTitle employeeTitleDTOToEmployeeTitle(EmployeeTitleDTO employeeTitleDTO) {
/* 179 */     if (employeeTitleDTO == null) {
/* 180 */       return null;
/*     */     }
/*     */     
/* 183 */     EmployeeTitle employeeTitle = new EmployeeTitle();
/*     */     
/* 185 */     employeeTitle.createdBy(employeeTitleDTO.getCreatedBy());
/* 186 */     employeeTitle.createdDate(employeeTitleDTO.getCreatedDate());
/* 187 */     employeeTitle.lastModifiedBy(employeeTitleDTO.getLastModifiedBy());
/* 188 */     employeeTitle.lastModifiedDate(employeeTitleDTO.getLastModifiedDate());
/* 189 */     employeeTitle.setId(employeeTitleDTO.getId());
/* 190 */     employeeTitle.setName(employeeTitleDTO.getName());
/* 191 */     employeeTitle.setDescription(employeeTitleDTO.getDescription());
/* 192 */     employeeTitle.setCanSupervise(employeeTitleDTO.getCanSupervise());
/*     */     
/* 194 */     return employeeTitle;
/*     */   }
/*     */   
/*     */   protected Team teamDTOToTeam(TeamDTO teamDTO) {
/* 198 */     if (teamDTO == null) {
/* 199 */       return null;
/*     */     }
/*     */     
/* 202 */     Team team = new Team();
/*     */     
/* 204 */     team.createdBy(teamDTO.getCreatedBy());
/* 205 */     team.createdDate(teamDTO.getCreatedDate());
/* 206 */     team.lastModifiedBy(teamDTO.getLastModifiedBy());
/* 207 */     team.lastModifiedDate(teamDTO.getLastModifiedDate());
/* 208 */     team.setId(teamDTO.getId());
/* 209 */     team.setName(teamDTO.getName());
/* 210 */     team.setDescription(teamDTO.getDescription());
/* 211 */     team.supervisor(employeeDTOToEmployee(teamDTO.getSupervisor()));
/*     */     
/* 213 */     return team;
/*     */   }
/*     */   
/*     */   protected Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
/* 217 */     if (employeeDTO == null) {
/* 218 */       return null;
/*     */     }
/*     */     
/* 221 */     Employee employee = new Employee();
/*     */     
/* 223 */     employee.createdBy(employeeDTO.getCreatedBy());
/* 224 */     employee.createdDate(employeeDTO.getCreatedDate());
/* 225 */     employee.lastModifiedBy(employeeDTO.getLastModifiedBy());
/* 226 */     employee.lastModifiedDate(employeeDTO.getLastModifiedDate());
/* 227 */     employee.setId(employeeDTO.getId());
/* 228 */     employee.setFirstName(employeeDTO.getFirstName());
/* 229 */     employee.setLastName(employeeDTO.getLastName());
/* 230 */     employee.setThirdName(employeeDTO.getThirdName());
/* 231 */     employee.setGender(employeeDTO.getGender());
/* 232 */     employee.setIdNumber(employeeDTO.getIdNumber());
/* 233 */     employee.setBirthday(employeeDTO.getBirthday());
/* 234 */     employee.setJoiningDate(employeeDTO.getJoiningDate());
/* 235 */     employee.setRelievingDate(employeeDTO.getRelievingDate());
/* 236 */     employee.setEmployeeNumber(employeeDTO.getEmployeeNumber());
/* 237 */     employee.title(employeeTitleDTOToEmployeeTitle(employeeDTO.getTitle()));
/* 238 */     employee.team(teamDTOToTeam(employeeDTO.getTeam()));
/*     */     
/* 240 */     return employee;
/*     */   }
/*     */   
/*     */   protected void userDTOToUser1(UserDTO userDTO, User mappingTarget) {
/* 244 */     if (userDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 248 */     if (userDTO.getId() != null) {
/* 249 */       mappingTarget.setId(userDTO.getId());
/*     */     }
/* 251 */     if (userDTO.getLogin() != null) {
/* 252 */       mappingTarget.setLogin(userDTO.getLogin());
/*     */     }
/* 254 */     if (userDTO.getFirstName() != null) {
/* 255 */       mappingTarget.setFirstName(userDTO.getFirstName());
/*     */     }
/* 257 */     if (userDTO.getLastName() != null) {
/* 258 */       mappingTarget.setLastName(userDTO.getLastName());
/*     */     }
/* 260 */     if (userDTO.getEmail() != null) {
/* 261 */       mappingTarget.setEmail(userDTO.getEmail());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void employeeTitleDTOToEmployeeTitle1(EmployeeTitleDTO employeeTitleDTO, EmployeeTitle mappingTarget) {
/* 266 */     if (employeeTitleDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 270 */     if (employeeTitleDTO.getCreatedBy() != null) {
/* 271 */       mappingTarget.createdBy(employeeTitleDTO.getCreatedBy());
/*     */     }
/* 273 */     if (employeeTitleDTO.getCreatedDate() != null) {
/* 274 */       mappingTarget.createdDate(employeeTitleDTO.getCreatedDate());
/*     */     }
/* 276 */     if (employeeTitleDTO.getLastModifiedBy() != null) {
/* 277 */       mappingTarget.lastModifiedBy(employeeTitleDTO.getLastModifiedBy());
/*     */     }
/* 279 */     if (employeeTitleDTO.getLastModifiedDate() != null) {
/* 280 */       mappingTarget.lastModifiedDate(employeeTitleDTO.getLastModifiedDate());
/*     */     }
/* 282 */     if (employeeTitleDTO.getId() != null) {
/* 283 */       mappingTarget.setId(employeeTitleDTO.getId());
/*     */     }
/* 285 */     if (employeeTitleDTO.getName() != null) {
/* 286 */       mappingTarget.setName(employeeTitleDTO.getName());
/*     */     }
/* 288 */     if (employeeTitleDTO.getDescription() != null) {
/* 289 */       mappingTarget.setDescription(employeeTitleDTO.getDescription());
/*     */     }
/* 291 */     if (employeeTitleDTO.getCanSupervise() != null) {
/* 292 */       mappingTarget.setCanSupervise(employeeTitleDTO.getCanSupervise());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void teamDTOToTeam1(TeamDTO teamDTO, Team mappingTarget) {
/* 297 */     if (teamDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 301 */     if (teamDTO.getCreatedBy() != null) {
/* 302 */       mappingTarget.createdBy(teamDTO.getCreatedBy());
/*     */     }
/* 304 */     if (teamDTO.getCreatedDate() != null) {
/* 305 */       mappingTarget.createdDate(teamDTO.getCreatedDate());
/*     */     }
/* 307 */     if (teamDTO.getLastModifiedBy() != null) {
/* 308 */       mappingTarget.lastModifiedBy(teamDTO.getLastModifiedBy());
/*     */     }
/* 310 */     if (teamDTO.getLastModifiedDate() != null) {
/* 311 */       mappingTarget.lastModifiedDate(teamDTO.getLastModifiedDate());
/*     */     }
/* 313 */     if (teamDTO.getId() != null) {
/* 314 */       mappingTarget.setId(teamDTO.getId());
/*     */     }
/* 316 */     if (teamDTO.getName() != null) {
/* 317 */       mappingTarget.setName(teamDTO.getName());
/*     */     }
/* 319 */     if (teamDTO.getDescription() != null) {
/* 320 */       mappingTarget.setDescription(teamDTO.getDescription());
/*     */     }
/* 322 */     if (teamDTO.getSupervisor() != null) {
/* 323 */       if (mappingTarget.getSupervisor() == null) {
/* 324 */         mappingTarget.supervisor(new Employee());
/*     */       }
/* 326 */       employeeDTOToEmployee1(teamDTO.getSupervisor(), mappingTarget.getSupervisor());
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void employeeDTOToEmployee1(EmployeeDTO employeeDTO, Employee mappingTarget) {
/* 331 */     if (employeeDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 335 */     if (employeeDTO.getCreatedBy() != null) {
/* 336 */       mappingTarget.createdBy(employeeDTO.getCreatedBy());
/*     */     }
/* 338 */     if (employeeDTO.getCreatedDate() != null) {
/* 339 */       mappingTarget.createdDate(employeeDTO.getCreatedDate());
/*     */     }
/* 341 */     if (employeeDTO.getLastModifiedBy() != null) {
/* 342 */       mappingTarget.lastModifiedBy(employeeDTO.getLastModifiedBy());
/*     */     }
/* 344 */     if (employeeDTO.getLastModifiedDate() != null) {
/* 345 */       mappingTarget.lastModifiedDate(employeeDTO.getLastModifiedDate());
/*     */     }
/* 347 */     if (employeeDTO.getId() != null) {
/* 348 */       mappingTarget.setId(employeeDTO.getId());
/*     */     }
/* 350 */     if (employeeDTO.getFirstName() != null) {
/* 351 */       mappingTarget.setFirstName(employeeDTO.getFirstName());
/*     */     }
/* 353 */     if (employeeDTO.getLastName() != null) {
/* 354 */       mappingTarget.setLastName(employeeDTO.getLastName());
/*     */     }
/* 356 */     if (employeeDTO.getThirdName() != null) {
/* 357 */       mappingTarget.setThirdName(employeeDTO.getThirdName());
/*     */     }
/* 359 */     if (employeeDTO.getGender() != null) {
/* 360 */       mappingTarget.setGender(employeeDTO.getGender());
/*     */     }
/* 362 */     if (employeeDTO.getIdNumber() != null) {
/* 363 */       mappingTarget.setIdNumber(employeeDTO.getIdNumber());
/*     */     }
/* 365 */     if (employeeDTO.getBirthday() != null) {
/* 366 */       mappingTarget.setBirthday(employeeDTO.getBirthday());
/*     */     }
/* 368 */     if (employeeDTO.getJoiningDate() != null) {
/* 369 */       mappingTarget.setJoiningDate(employeeDTO.getJoiningDate());
/*     */     }
/* 371 */     if (employeeDTO.getRelievingDate() != null) {
/* 372 */       mappingTarget.setRelievingDate(employeeDTO.getRelievingDate());
/*     */     }
/* 374 */     if (employeeDTO.getEmployeeNumber() != null) {
/* 375 */       mappingTarget.setEmployeeNumber(employeeDTO.getEmployeeNumber());
/*     */     }
/* 377 */     if (employeeDTO.getTitle() != null) {
/* 378 */       if (mappingTarget.getTitle() == null) {
/* 379 */         mappingTarget.title(new EmployeeTitle());
/*     */       }
/* 381 */       employeeTitleDTOToEmployeeTitle1(employeeDTO.getTitle(), mappingTarget.getTitle());
/*     */     } 
/* 383 */     if (employeeDTO.getTeam() != null) {
/* 384 */       if (mappingTarget.getTeam() == null) {
/* 385 */         mappingTarget.team(new Team());
/*     */       }
/* 387 */       teamDTOToTeam1(employeeDTO.getTeam(), mappingTarget.getTeam());
/*     */     } 
/*     */   }
/*     */   
/*     */   protected UserDTO userToUserDTO(User user) {
/* 392 */     if (user == null) {
/* 393 */       return null;
/*     */     }
/*     */     
/* 396 */     UserDTO userDTO = new UserDTO();
/*     */     
/* 398 */     userDTO.setId(user.getId());
/* 399 */     userDTO.setLogin(user.getLogin());
/* 400 */     userDTO.setFirstName(user.getFirstName());
/* 401 */     userDTO.setLastName(user.getLastName());
/* 402 */     userDTO.setEmail(user.getEmail());
/*     */     
/* 404 */     return userDTO;
/*     */   }
/*     */   
/*     */   protected EmployeeTitleDTO employeeTitleToEmployeeTitleDTO(EmployeeTitle employeeTitle) {
/* 408 */     if (employeeTitle == null) {
/* 409 */       return null;
/*     */     }
/*     */     
/* 412 */     EmployeeTitleDTO employeeTitleDTO = new EmployeeTitleDTO();
/*     */     
/* 414 */     employeeTitleDTO.setId(employeeTitle.getId());
/* 415 */     employeeTitleDTO.setName(employeeTitle.getName());
/* 416 */     employeeTitleDTO.setDescription(employeeTitle.getDescription());
/* 417 */     employeeTitleDTO.setCanSupervise(employeeTitle.getCanSupervise());
/* 418 */     employeeTitleDTO.setCreatedBy(employeeTitle.getCreatedBy());
/* 419 */     employeeTitleDTO.setCreatedDate(employeeTitle.getCreatedDate());
/* 420 */     employeeTitleDTO.setLastModifiedBy(employeeTitle.getLastModifiedBy());
/* 421 */     employeeTitleDTO.setLastModifiedDate(employeeTitle.getLastModifiedDate());
/*     */     
/* 423 */     return employeeTitleDTO;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\UserInfoMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */