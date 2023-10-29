/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Assignment;
/*     */ import com.nanosoft.amtk.domain.Certificate;
/*     */ import com.nanosoft.amtk.domain.CertificationLevel;
/*     */ import com.nanosoft.amtk.domain.Checklist;
/*     */ import com.nanosoft.amtk.domain.ChecklistItem;
/*     */ import com.nanosoft.amtk.domain.ChecklistModel;
/*     */ import com.nanosoft.amtk.domain.Employee;
/*     */ import com.nanosoft.amtk.domain.EmployeeTitle;
/*     */ import com.nanosoft.amtk.domain.Process;
/*     */ import com.nanosoft.amtk.domain.Team;
/*     */ import com.nanosoft.amtk.domain.Workstation;
/*     */ import com.nanosoft.amtk.service.dto.AssignmentDTO;
/*     */ import com.nanosoft.amtk.service.dto.CertificateDTO;
/*     */ import com.nanosoft.amtk.service.dto.CertificationLevelDTO;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistDTO;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistItemDTO;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistModelDTO;
/*     */ import com.nanosoft.amtk.service.dto.EmployeeDTO;
/*     */ import com.nanosoft.amtk.service.dto.EmployeeTitleDTO;
/*     */ import com.nanosoft.amtk.service.dto.ProcessDTO;
/*     */ import com.nanosoft.amtk.service.dto.TeamDTO;
/*     */ import com.nanosoft.amtk.service.mapper.CertificateMapper;
/*     */ import com.nanosoft.amtk.service.mapper.WorkstationMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Component
/*     */ public class CertificateMapperImpl
/*     */   implements CertificateMapper
/*     */ {
/*     */   @Autowired
/*     */   private WorkstationMapper workstationMapper;
/*     */   
/*     */   public Certificate toEntity(CertificateDTO dto) {
/*  44 */     if (dto == null) {
/*  45 */       return null;
/*     */     }
/*     */     
/*  48 */     Certificate certificate = new Certificate();
/*     */     
/*  50 */     certificate.createdBy(dto.getCreatedBy());
/*  51 */     certificate.createdDate(dto.getCreatedDate());
/*  52 */     certificate.lastModifiedBy(dto.getLastModifiedBy());
/*  53 */     certificate.lastModifiedDate(dto.getLastModifiedDate());
/*  54 */     certificate.setId(dto.getId());
/*  55 */     certificate.setStatus(dto.getStatus());
/*  56 */     certificate.setStartDate(dto.getStartDate());
/*  57 */     certificate.setExpectedEndDate(dto.getExpectedEndDate());
/*  58 */     certificate.setEndDate(dto.getEndDate());
/*  59 */     certificate.setValidated(dto.getValidated());
/*  60 */     certificate.setIsRecycling(dto.getIsRecycling());
/*  61 */     certificate.assignment(assignmentDTOToAssignment(dto.getAssignment()));
/*  62 */     certificate.level(certificationLevelDTOToCertificationLevel(dto.getLevel()));
/*  63 */     certificate.checklist(checklistDTOToChecklist(dto.getChecklist()));
/*     */     
/*  65 */     return certificate;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Certificate> toEntity(List<CertificateDTO> dtoList) {
/*  70 */     if (dtoList == null) {
/*  71 */       return null;
/*     */     }
/*     */     
/*  74 */     List<Certificate> list = new ArrayList<>(dtoList.size());
/*  75 */     for (CertificateDTO certificateDTO : dtoList) {
/*  76 */       list.add(toEntity(certificateDTO));
/*     */     }
/*     */     
/*  79 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<CertificateDTO> toDto(List<Certificate> entityList) {
/*  84 */     if (entityList == null) {
/*  85 */       return null;
/*     */     }
/*     */     
/*  88 */     List<CertificateDTO> list = new ArrayList<>(entityList.size());
/*  89 */     for (Certificate certificate : entityList) {
/*  90 */       list.add(toDto(certificate));
/*     */     }
/*     */     
/*  93 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(Certificate entity, CertificateDTO dto) {
/*  98 */     if (dto == null) {
/*     */       return;
/*     */     }
/*     */     
/* 102 */     if (dto.getCreatedBy() != null) {
/* 103 */       entity.createdBy(dto.getCreatedBy());
/*     */     }
/* 105 */     if (dto.getCreatedDate() != null) {
/* 106 */       entity.createdDate(dto.getCreatedDate());
/*     */     }
/* 108 */     if (dto.getLastModifiedBy() != null) {
/* 109 */       entity.lastModifiedBy(dto.getLastModifiedBy());
/*     */     }
/* 111 */     if (dto.getLastModifiedDate() != null) {
/* 112 */       entity.lastModifiedDate(dto.getLastModifiedDate());
/*     */     }
/* 114 */     if (dto.getId() != null) {
/* 115 */       entity.setId(dto.getId());
/*     */     }
/* 117 */     if (dto.getStatus() != null) {
/* 118 */       entity.setStatus(dto.getStatus());
/*     */     }
/* 120 */     if (dto.getStartDate() != null) {
/* 121 */       entity.setStartDate(dto.getStartDate());
/*     */     }
/* 123 */     if (dto.getExpectedEndDate() != null) {
/* 124 */       entity.setExpectedEndDate(dto.getExpectedEndDate());
/*     */     }
/* 126 */     if (dto.getEndDate() != null) {
/* 127 */       entity.setEndDate(dto.getEndDate());
/*     */     }
/* 129 */     if (dto.getValidated() != null) {
/* 130 */       entity.setValidated(dto.getValidated());
/*     */     }
/* 132 */     if (dto.getIsRecycling() != null) {
/* 133 */       entity.setIsRecycling(dto.getIsRecycling());
/*     */     }
/* 135 */     if (dto.getAssignment() != null) {
/* 136 */       if (entity.getAssignment() == null) {
/* 137 */         entity.assignment(new Assignment());
/*     */       }
/* 139 */       assignmentDTOToAssignment1(dto.getAssignment(), entity.getAssignment());
/*     */     } 
/* 141 */     if (dto.getLevel() != null) {
/* 142 */       if (entity.getLevel() == null) {
/* 143 */         entity.level(new CertificationLevel());
/*     */       }
/* 145 */       certificationLevelDTOToCertificationLevel1(dto.getLevel(), entity.getLevel());
/*     */     } 
/* 147 */     if (dto.getChecklist() != null) {
/* 148 */       if (entity.getChecklist() == null) {
/* 149 */         entity.checklist(new Checklist());
/*     */       }
/* 151 */       checklistDTOToChecklist1(dto.getChecklist(), entity.getChecklist());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CertificateDTO toDto(Certificate s) {
/* 157 */     if (s == null) {
/* 158 */       return null;
/*     */     }
/*     */     
/* 161 */     CertificateDTO certificateDTO = new CertificateDTO();
/*     */     
/* 163 */     certificateDTO.setAssignment(toDtoAssignmentId(s.getAssignment()));
/* 164 */     certificateDTO.setLevel(certificationLevelToCertificationLevelDTO(s.getLevel()));
/* 165 */     certificateDTO.setChecklist(checklistToChecklistDTO(s.getChecklist()));
/* 166 */     certificateDTO.setId(s.getId());
/* 167 */     certificateDTO.setStatus(s.getStatus());
/* 168 */     certificateDTO.setStartDate(s.getStartDate());
/* 169 */     certificateDTO.setExpectedEndDate(s.getExpectedEndDate());
/* 170 */     certificateDTO.setEndDate(s.getEndDate());
/* 171 */     certificateDTO.setValidated(s.getValidated());
/* 172 */     certificateDTO.setIsRecycling(s.getIsRecycling());
/* 173 */     certificateDTO.setCreatedBy(s.getCreatedBy());
/* 174 */     certificateDTO.setCreatedDate(s.getCreatedDate());
/* 175 */     certificateDTO.setLastModifiedBy(s.getLastModifiedBy());
/* 176 */     certificateDTO.setLastModifiedDate(s.getLastModifiedDate());
/*     */     
/* 178 */     return certificateDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public AssignmentDTO toDtoAssignmentId(Assignment assignment) {
/* 183 */     if (assignment == null) {
/* 184 */       return null;
/*     */     }
/*     */     
/* 187 */     AssignmentDTO assignmentDTO = new AssignmentDTO();
/*     */     
/* 189 */     assignmentDTO.setId(assignment.getId());
/* 190 */     assignmentDTO.setAssignmentStart(assignment.getAssignmentStart());
/* 191 */     assignmentDTO.setWorkstation(this.workstationMapper.toDto(assignment.getWorkstation()));
/* 192 */     assignmentDTO.setEmployee(toDtoEmployeeId(assignment.getEmployee()));
/*     */     
/* 194 */     return assignmentDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public EmployeeDTO toDtoEmployeeId(Employee employee) {
/* 199 */     if (employee == null) {
/* 200 */       return null;
/*     */     }
/*     */     
/* 203 */     EmployeeDTO employeeDTO = new EmployeeDTO();
/*     */     
/* 205 */     employeeDTO.setId(employee.getId());
/* 206 */     employeeDTO.setFirstName(employee.getFirstName());
/* 207 */     employeeDTO.setLastName(employee.getLastName());
/* 208 */     employeeDTO.setEmployeeNumber(employee.getEmployeeNumber());
/* 209 */     employeeDTO.setTitle(employeeTitleToEmployeeTitleDTO(employee.getTitle()));
/*     */     
/* 211 */     return employeeDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public CertificationLevelDTO toDtoCertificationLevelId(CertificationLevel certificationLevel) {
/* 216 */     if (certificationLevel == null) {
/* 217 */       return null;
/*     */     }
/*     */     
/* 220 */     CertificationLevelDTO certificationLevelDTO = new CertificationLevelDTO();
/*     */     
/* 222 */     certificationLevelDTO.setId(certificationLevel.getId());
/*     */     
/* 224 */     return certificationLevelDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChecklistDTO toDtoChecklistId(Checklist checklist) {
/* 229 */     if (checklist == null) {
/* 230 */       return null;
/*     */     }
/*     */     
/* 233 */     ChecklistDTO checklistDTO = new ChecklistDTO();
/*     */     
/* 235 */     checklistDTO.setId(checklist.getId());
/*     */     
/* 237 */     return checklistDTO;
/*     */   }
/*     */   
/*     */   protected EmployeeTitle employeeTitleDTOToEmployeeTitle(EmployeeTitleDTO employeeTitleDTO) {
/* 241 */     if (employeeTitleDTO == null) {
/* 242 */       return null;
/*     */     }
/*     */     
/* 245 */     EmployeeTitle employeeTitle = new EmployeeTitle();
/*     */     
/* 247 */     employeeTitle.createdBy(employeeTitleDTO.getCreatedBy());
/* 248 */     employeeTitle.createdDate(employeeTitleDTO.getCreatedDate());
/* 249 */     employeeTitle.lastModifiedBy(employeeTitleDTO.getLastModifiedBy());
/* 250 */     employeeTitle.lastModifiedDate(employeeTitleDTO.getLastModifiedDate());
/* 251 */     employeeTitle.setId(employeeTitleDTO.getId());
/* 252 */     employeeTitle.setName(employeeTitleDTO.getName());
/* 253 */     employeeTitle.setDescription(employeeTitleDTO.getDescription());
/* 254 */     employeeTitle.setCanSupervise(employeeTitleDTO.getCanSupervise());
/*     */     
/* 256 */     return employeeTitle;
/*     */   }
/*     */   
/*     */   protected Team teamDTOToTeam(TeamDTO teamDTO) {
/* 260 */     if (teamDTO == null) {
/* 261 */       return null;
/*     */     }
/*     */     
/* 264 */     Team team = new Team();
/*     */     
/* 266 */     team.createdBy(teamDTO.getCreatedBy());
/* 267 */     team.createdDate(teamDTO.getCreatedDate());
/* 268 */     team.lastModifiedBy(teamDTO.getLastModifiedBy());
/* 269 */     team.lastModifiedDate(teamDTO.getLastModifiedDate());
/* 270 */     team.setId(teamDTO.getId());
/* 271 */     team.setName(teamDTO.getName());
/* 272 */     team.setDescription(teamDTO.getDescription());
/* 273 */     team.supervisor(employeeDTOToEmployee(teamDTO.getSupervisor()));
/*     */     
/* 275 */     return team;
/*     */   }
/*     */   
/*     */   protected Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
/* 279 */     if (employeeDTO == null) {
/* 280 */       return null;
/*     */     }
/*     */     
/* 283 */     Employee employee = new Employee();
/*     */     
/* 285 */     employee.createdBy(employeeDTO.getCreatedBy());
/* 286 */     employee.createdDate(employeeDTO.getCreatedDate());
/* 287 */     employee.lastModifiedBy(employeeDTO.getLastModifiedBy());
/* 288 */     employee.lastModifiedDate(employeeDTO.getLastModifiedDate());
/* 289 */     employee.setId(employeeDTO.getId());
/* 290 */     employee.setFirstName(employeeDTO.getFirstName());
/* 291 */     employee.setLastName(employeeDTO.getLastName());
/* 292 */     employee.setThirdName(employeeDTO.getThirdName());
/* 293 */     employee.setGender(employeeDTO.getGender());
/* 294 */     employee.setIdNumber(employeeDTO.getIdNumber());
/* 295 */     employee.setBirthday(employeeDTO.getBirthday());
/* 296 */     employee.setJoiningDate(employeeDTO.getJoiningDate());
/* 297 */     employee.setRelievingDate(employeeDTO.getRelievingDate());
/* 298 */     employee.setEmployeeNumber(employeeDTO.getEmployeeNumber());
/* 299 */     employee.title(employeeTitleDTOToEmployeeTitle(employeeDTO.getTitle()));
/* 300 */     employee.team(teamDTOToTeam(employeeDTO.getTeam()));
/*     */     
/* 302 */     return employee;
/*     */   }
/*     */   
/*     */   protected Assignment assignmentDTOToAssignment(AssignmentDTO assignmentDTO) {
/* 306 */     if (assignmentDTO == null) {
/* 307 */       return null;
/*     */     }
/*     */     
/* 310 */     Assignment assignment = new Assignment();
/*     */     
/* 312 */     assignment.createdBy(assignmentDTO.getCreatedBy());
/* 313 */     assignment.createdDate(assignmentDTO.getCreatedDate());
/* 314 */     assignment.lastModifiedBy(assignmentDTO.getLastModifiedBy());
/* 315 */     assignment.lastModifiedDate(assignmentDTO.getLastModifiedDate());
/* 316 */     assignment.setId(assignmentDTO.getId());
/* 317 */     assignment.setAssignmentStart(assignmentDTO.getAssignmentStart());
/* 318 */     assignment.setAssignmentEnd(assignmentDTO.getAssignmentEnd());
/* 319 */     assignment.setDescription(assignmentDTO.getDescription());
/* 320 */     assignment.workstation((Workstation)this.workstationMapper.toEntity(assignmentDTO.getWorkstation()));
/* 321 */     assignment.employee(employeeDTOToEmployee(assignmentDTO.getEmployee()));
/* 322 */     assignment.currentCertificate(toEntity(assignmentDTO.getCurrentCertificate()));
/*     */     
/* 324 */     return assignment;
/*     */   }
/*     */   
/*     */   protected Process processDTOToProcess(ProcessDTO processDTO) {
/* 328 */     if (processDTO == null) {
/* 329 */       return null;
/*     */     }
/*     */     
/* 332 */     Process process = new Process();
/*     */     
/* 334 */     process.createdBy(processDTO.getCreatedBy());
/* 335 */     process.createdDate(processDTO.getCreatedDate());
/* 336 */     process.lastModifiedBy(processDTO.getLastModifiedBy());
/* 337 */     process.lastModifiedDate(processDTO.getLastModifiedDate());
/* 338 */     process.setId(processDTO.getId());
/* 339 */     process.setName(processDTO.getName());
/* 340 */     process.setDescription(processDTO.getDescription());
/*     */     
/* 342 */     return process;
/*     */   }
/*     */   
/*     */   protected ChecklistModel checklistModelDTOToChecklistModel(ChecklistModelDTO checklistModelDTO) {
/* 346 */     if (checklistModelDTO == null) {
/* 347 */       return null;
/*     */     }
/*     */     
/* 350 */     ChecklistModel checklistModel = new ChecklistModel();
/*     */     
/* 352 */     checklistModel.createdBy(checklistModelDTO.getCreatedBy());
/* 353 */     checklistModel.createdDate(checklistModelDTO.getCreatedDate());
/* 354 */     checklistModel.lastModifiedBy(checklistModelDTO.getLastModifiedBy());
/* 355 */     checklistModel.lastModifiedDate(checklistModelDTO.getLastModifiedDate());
/* 356 */     checklistModel.setId(checklistModelDTO.getId());
/* 357 */     checklistModel.setTitle(checklistModelDTO.getTitle());
/* 358 */     checklistModel.setDescription(checklistModelDTO.getDescription());
/* 359 */     checklistModel.setValidator(checklistModelDTO.getValidator());
/* 360 */     checklistModel.setValidator2(checklistModelDTO.getValidator2());
/* 361 */     checklistModel.setValidator3(checklistModelDTO.getValidator3());
/* 362 */     checklistModel.setValidator4(checklistModelDTO.getValidator4());
/*     */     
/* 364 */     return checklistModel;
/*     */   }
/*     */   
/*     */   protected CertificationLevel certificationLevelDTOToCertificationLevel(CertificationLevelDTO certificationLevelDTO) {
/* 368 */     if (certificationLevelDTO == null) {
/* 369 */       return null;
/*     */     }
/*     */     
/* 372 */     CertificationLevel certificationLevel = new CertificationLevel();
/*     */     
/* 374 */     certificationLevel.createdBy(certificationLevelDTO.getCreatedBy());
/* 375 */     certificationLevel.createdDate(certificationLevelDTO.getCreatedDate());
/* 376 */     certificationLevel.lastModifiedBy(certificationLevelDTO.getLastModifiedBy());
/* 377 */     certificationLevel.lastModifiedDate(certificationLevelDTO.getLastModifiedDate());
/* 378 */     certificationLevel.setId(certificationLevelDTO.getId());
/* 379 */     certificationLevel.setLevel(certificationLevelDTO.getLevel());
/* 380 */     certificationLevel.setOrderNumber(certificationLevelDTO.getOrderNumber());
/* 381 */     certificationLevel.setTrainingDuration(certificationLevelDTO.getTrainingDuration());
/* 382 */     certificationLevel.setRecyclingPeriod(certificationLevelDTO.getRecyclingPeriod());
/* 383 */     certificationLevel.setDescription(certificationLevelDTO.getDescription());
/* 384 */     certificationLevel.process(processDTOToProcess(certificationLevelDTO.getProcess()));
/* 385 */     certificationLevel.checklistModel(checklistModelDTOToChecklistModel(certificationLevelDTO.getChecklistModel()));
/*     */     
/* 387 */     return certificationLevel;
/*     */   }
/*     */   
/*     */   protected ChecklistItem checklistItemDTOToChecklistItem(ChecklistItemDTO checklistItemDTO) {
/* 391 */     if (checklistItemDTO == null) {
/* 392 */       return null;
/*     */     }
/*     */     
/* 395 */     ChecklistItem checklistItem = new ChecklistItem();
/*     */     
/* 397 */     checklistItem.createdBy(checklistItemDTO.getCreatedBy());
/* 398 */     checklistItem.createdDate(checklistItemDTO.getCreatedDate());
/* 399 */     checklistItem.lastModifiedBy(checklistItemDTO.getLastModifiedBy());
/* 400 */     checklistItem.lastModifiedDate(checklistItemDTO.getLastModifiedDate());
/* 401 */     checklistItem.setId(checklistItemDTO.getId());
/* 402 */     checklistItem.setText(checklistItemDTO.getText());
/* 403 */     checklistItem.setItemGroup(checklistItemDTO.getItemGroup());
/* 404 */     checklistItem.setValidatorRole(checklistItemDTO.getValidatorRole());
/* 405 */     checklistItem.setValidator(checklistItemDTO.getValidator());
/* 406 */     checklistItem.setIsChecked(checklistItemDTO.getIsChecked());
/*     */     
/* 408 */     return checklistItem;
/*     */   }
/*     */   
/*     */   protected Set<ChecklistItem> checklistItemDTOListToChecklistItemSet(List<ChecklistItemDTO> list) {
/* 412 */     if (list == null) {
/* 413 */       return null;
/*     */     }
/*     */     
/* 416 */     Set<ChecklistItem> set = new LinkedHashSet<>(Math.max((int)(list.size() / 0.75F) + 1, 16));
/* 417 */     for (ChecklistItemDTO checklistItemDTO : list) {
/* 418 */       set.add(checklistItemDTOToChecklistItem(checklistItemDTO));
/*     */     }
/*     */     
/* 421 */     return set;
/*     */   }
/*     */   
/*     */   protected Checklist checklistDTOToChecklist(ChecklistDTO checklistDTO) {
/* 425 */     if (checklistDTO == null) {
/* 426 */       return null;
/*     */     }
/*     */     
/* 429 */     Checklist checklist = new Checklist();
/*     */     
/* 431 */     checklist.createdBy(checklistDTO.getCreatedBy());
/* 432 */     checklist.createdDate(checklistDTO.getCreatedDate());
/* 433 */     checklist.lastModifiedBy(checklistDTO.getLastModifiedBy());
/* 434 */     checklist.lastModifiedDate(checklistDTO.getLastModifiedDate());
/* 435 */     checklist.setId(checklistDTO.getId());
/* 436 */     checklist.setTitle(checklistDTO.getTitle());
/* 437 */     checklist.setDescription(checklistDTO.getDescription());
/* 438 */     checklist.setValidatorRole(checklistDTO.getValidatorRole());
/* 439 */     checklist.setValidator(checklistDTO.getValidator());
/* 440 */     checklist.setValidatorCheck(checklistDTO.getValidatorCheck());
/* 441 */     checklist.setValidatorRole2(checklistDTO.getValidatorRole2());
/* 442 */     checklist.setValidator2(checklistDTO.getValidator2());
/* 443 */     checklist.setValidator2Check(checklistDTO.getValidator2Check());
/* 444 */     checklist.setValidatorRole3(checklistDTO.getValidatorRole3());
/* 445 */     checklist.setValidator3(checklistDTO.getValidator3());
/* 446 */     checklist.setValidator3Check(checklistDTO.getValidator3Check());
/* 447 */     checklist.setValidatorRole4(checklistDTO.getValidatorRole4());
/* 448 */     checklist.setValidator4(checklistDTO.getValidator4());
/* 449 */     checklist.setValidator4Check(checklistDTO.getValidator4Check());
/* 450 */     checklist.setStatus(checklistDTO.getStatus());
/* 451 */     checklist.checklistModel(checklistModelDTOToChecklistModel(checklistDTO.getChecklistModel()));
/* 452 */     checklist.checklistItems(checklistItemDTOListToChecklistItemSet(checklistDTO.getChecklistItems()));
/*     */     
/* 454 */     return checklist;
/*     */   }
/*     */   
/*     */   protected void employeeTitleDTOToEmployeeTitle1(EmployeeTitleDTO employeeTitleDTO, EmployeeTitle mappingTarget) {
/* 458 */     if (employeeTitleDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 462 */     if (employeeTitleDTO.getCreatedBy() != null) {
/* 463 */       mappingTarget.createdBy(employeeTitleDTO.getCreatedBy());
/*     */     }
/* 465 */     if (employeeTitleDTO.getCreatedDate() != null) {
/* 466 */       mappingTarget.createdDate(employeeTitleDTO.getCreatedDate());
/*     */     }
/* 468 */     if (employeeTitleDTO.getLastModifiedBy() != null) {
/* 469 */       mappingTarget.lastModifiedBy(employeeTitleDTO.getLastModifiedBy());
/*     */     }
/* 471 */     if (employeeTitleDTO.getLastModifiedDate() != null) {
/* 472 */       mappingTarget.lastModifiedDate(employeeTitleDTO.getLastModifiedDate());
/*     */     }
/* 474 */     if (employeeTitleDTO.getId() != null) {
/* 475 */       mappingTarget.setId(employeeTitleDTO.getId());
/*     */     }
/* 477 */     if (employeeTitleDTO.getName() != null) {
/* 478 */       mappingTarget.setName(employeeTitleDTO.getName());
/*     */     }
/* 480 */     if (employeeTitleDTO.getDescription() != null) {
/* 481 */       mappingTarget.setDescription(employeeTitleDTO.getDescription());
/*     */     }
/* 483 */     if (employeeTitleDTO.getCanSupervise() != null) {
/* 484 */       mappingTarget.setCanSupervise(employeeTitleDTO.getCanSupervise());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void teamDTOToTeam1(TeamDTO teamDTO, Team mappingTarget) {
/* 489 */     if (teamDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 493 */     if (teamDTO.getCreatedBy() != null) {
/* 494 */       mappingTarget.createdBy(teamDTO.getCreatedBy());
/*     */     }
/* 496 */     if (teamDTO.getCreatedDate() != null) {
/* 497 */       mappingTarget.createdDate(teamDTO.getCreatedDate());
/*     */     }
/* 499 */     if (teamDTO.getLastModifiedBy() != null) {
/* 500 */       mappingTarget.lastModifiedBy(teamDTO.getLastModifiedBy());
/*     */     }
/* 502 */     if (teamDTO.getLastModifiedDate() != null) {
/* 503 */       mappingTarget.lastModifiedDate(teamDTO.getLastModifiedDate());
/*     */     }
/* 505 */     if (teamDTO.getId() != null) {
/* 506 */       mappingTarget.setId(teamDTO.getId());
/*     */     }
/* 508 */     if (teamDTO.getName() != null) {
/* 509 */       mappingTarget.setName(teamDTO.getName());
/*     */     }
/* 511 */     if (teamDTO.getDescription() != null) {
/* 512 */       mappingTarget.setDescription(teamDTO.getDescription());
/*     */     }
/* 514 */     if (teamDTO.getSupervisor() != null) {
/* 515 */       if (mappingTarget.getSupervisor() == null) {
/* 516 */         mappingTarget.supervisor(new Employee());
/*     */       }
/* 518 */       employeeDTOToEmployee1(teamDTO.getSupervisor(), mappingTarget.getSupervisor());
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void employeeDTOToEmployee1(EmployeeDTO employeeDTO, Employee mappingTarget) {
/* 523 */     if (employeeDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 527 */     if (employeeDTO.getCreatedBy() != null) {
/* 528 */       mappingTarget.createdBy(employeeDTO.getCreatedBy());
/*     */     }
/* 530 */     if (employeeDTO.getCreatedDate() != null) {
/* 531 */       mappingTarget.createdDate(employeeDTO.getCreatedDate());
/*     */     }
/* 533 */     if (employeeDTO.getLastModifiedBy() != null) {
/* 534 */       mappingTarget.lastModifiedBy(employeeDTO.getLastModifiedBy());
/*     */     }
/* 536 */     if (employeeDTO.getLastModifiedDate() != null) {
/* 537 */       mappingTarget.lastModifiedDate(employeeDTO.getLastModifiedDate());
/*     */     }
/* 539 */     if (employeeDTO.getId() != null) {
/* 540 */       mappingTarget.setId(employeeDTO.getId());
/*     */     }
/* 542 */     if (employeeDTO.getFirstName() != null) {
/* 543 */       mappingTarget.setFirstName(employeeDTO.getFirstName());
/*     */     }
/* 545 */     if (employeeDTO.getLastName() != null) {
/* 546 */       mappingTarget.setLastName(employeeDTO.getLastName());
/*     */     }
/* 548 */     if (employeeDTO.getThirdName() != null) {
/* 549 */       mappingTarget.setThirdName(employeeDTO.getThirdName());
/*     */     }
/* 551 */     if (employeeDTO.getGender() != null) {
/* 552 */       mappingTarget.setGender(employeeDTO.getGender());
/*     */     }
/* 554 */     if (employeeDTO.getIdNumber() != null) {
/* 555 */       mappingTarget.setIdNumber(employeeDTO.getIdNumber());
/*     */     }
/* 557 */     if (employeeDTO.getBirthday() != null) {
/* 558 */       mappingTarget.setBirthday(employeeDTO.getBirthday());
/*     */     }
/* 560 */     if (employeeDTO.getJoiningDate() != null) {
/* 561 */       mappingTarget.setJoiningDate(employeeDTO.getJoiningDate());
/*     */     }
/* 563 */     if (employeeDTO.getRelievingDate() != null) {
/* 564 */       mappingTarget.setRelievingDate(employeeDTO.getRelievingDate());
/*     */     }
/* 566 */     if (employeeDTO.getEmployeeNumber() != null) {
/* 567 */       mappingTarget.setEmployeeNumber(employeeDTO.getEmployeeNumber());
/*     */     }
/* 569 */     if (employeeDTO.getTitle() != null) {
/* 570 */       if (mappingTarget.getTitle() == null) {
/* 571 */         mappingTarget.title(new EmployeeTitle());
/*     */       }
/* 573 */       employeeTitleDTOToEmployeeTitle1(employeeDTO.getTitle(), mappingTarget.getTitle());
/*     */     } 
/* 575 */     if (employeeDTO.getTeam() != null) {
/* 576 */       if (mappingTarget.getTeam() == null) {
/* 577 */         mappingTarget.team(new Team());
/*     */       }
/* 579 */       teamDTOToTeam1(employeeDTO.getTeam(), mappingTarget.getTeam());
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void assignmentDTOToAssignment1(AssignmentDTO assignmentDTO, Assignment mappingTarget) {
/* 584 */     if (assignmentDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 588 */     if (assignmentDTO.getCreatedBy() != null) {
/* 589 */       mappingTarget.createdBy(assignmentDTO.getCreatedBy());
/*     */     }
/* 591 */     if (assignmentDTO.getCreatedDate() != null) {
/* 592 */       mappingTarget.createdDate(assignmentDTO.getCreatedDate());
/*     */     }
/* 594 */     if (assignmentDTO.getLastModifiedBy() != null) {
/* 595 */       mappingTarget.lastModifiedBy(assignmentDTO.getLastModifiedBy());
/*     */     }
/* 597 */     if (assignmentDTO.getLastModifiedDate() != null) {
/* 598 */       mappingTarget.lastModifiedDate(assignmentDTO.getLastModifiedDate());
/*     */     }
/* 600 */     if (assignmentDTO.getId() != null) {
/* 601 */       mappingTarget.setId(assignmentDTO.getId());
/*     */     }
/* 603 */     if (assignmentDTO.getAssignmentStart() != null) {
/* 604 */       mappingTarget.setAssignmentStart(assignmentDTO.getAssignmentStart());
/*     */     }
/* 606 */     if (assignmentDTO.getAssignmentEnd() != null) {
/* 607 */       mappingTarget.setAssignmentEnd(assignmentDTO.getAssignmentEnd());
/*     */     }
/* 609 */     if (assignmentDTO.getDescription() != null) {
/* 610 */       mappingTarget.setDescription(assignmentDTO.getDescription());
/*     */     }
/* 612 */     if (assignmentDTO.getWorkstation() != null) {
/* 613 */       mappingTarget.workstation((Workstation)this.workstationMapper.toEntity(assignmentDTO.getWorkstation()));
/*     */     }
/* 615 */     if (assignmentDTO.getEmployee() != null) {
/* 616 */       if (mappingTarget.getEmployee() == null) {
/* 617 */         mappingTarget.employee(new Employee());
/*     */       }
/* 619 */       employeeDTOToEmployee1(assignmentDTO.getEmployee(), mappingTarget.getEmployee());
/*     */     } 
/* 621 */     if (assignmentDTO.getCurrentCertificate() != null) {
/* 622 */       mappingTarget.currentCertificate(toEntity(assignmentDTO.getCurrentCertificate()));
/*     */     }
/*     */   }
/*     */   
/*     */   protected void processDTOToProcess1(ProcessDTO processDTO, Process mappingTarget) {
/* 627 */     if (processDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 631 */     if (processDTO.getCreatedBy() != null) {
/* 632 */       mappingTarget.createdBy(processDTO.getCreatedBy());
/*     */     }
/* 634 */     if (processDTO.getCreatedDate() != null) {
/* 635 */       mappingTarget.createdDate(processDTO.getCreatedDate());
/*     */     }
/* 637 */     if (processDTO.getLastModifiedBy() != null) {
/* 638 */       mappingTarget.lastModifiedBy(processDTO.getLastModifiedBy());
/*     */     }
/* 640 */     if (processDTO.getLastModifiedDate() != null) {
/* 641 */       mappingTarget.lastModifiedDate(processDTO.getLastModifiedDate());
/*     */     }
/* 643 */     if (processDTO.getId() != null) {
/* 644 */       mappingTarget.setId(processDTO.getId());
/*     */     }
/* 646 */     if (processDTO.getName() != null) {
/* 647 */       mappingTarget.setName(processDTO.getName());
/*     */     }
/* 649 */     if (processDTO.getDescription() != null) {
/* 650 */       mappingTarget.setDescription(processDTO.getDescription());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void checklistModelDTOToChecklistModel1(ChecklistModelDTO checklistModelDTO, ChecklistModel mappingTarget) {
/* 655 */     if (checklistModelDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 659 */     if (checklistModelDTO.getCreatedBy() != null) {
/* 660 */       mappingTarget.createdBy(checklistModelDTO.getCreatedBy());
/*     */     }
/* 662 */     if (checklistModelDTO.getCreatedDate() != null) {
/* 663 */       mappingTarget.createdDate(checklistModelDTO.getCreatedDate());
/*     */     }
/* 665 */     if (checklistModelDTO.getLastModifiedBy() != null) {
/* 666 */       mappingTarget.lastModifiedBy(checklistModelDTO.getLastModifiedBy());
/*     */     }
/* 668 */     if (checklistModelDTO.getLastModifiedDate() != null) {
/* 669 */       mappingTarget.lastModifiedDate(checklistModelDTO.getLastModifiedDate());
/*     */     }
/* 671 */     if (checklistModelDTO.getId() != null) {
/* 672 */       mappingTarget.setId(checklistModelDTO.getId());
/*     */     }
/* 674 */     if (checklistModelDTO.getTitle() != null) {
/* 675 */       mappingTarget.setTitle(checklistModelDTO.getTitle());
/*     */     }
/* 677 */     if (checklistModelDTO.getDescription() != null) {
/* 678 */       mappingTarget.setDescription(checklistModelDTO.getDescription());
/*     */     }
/* 680 */     if (checklistModelDTO.getValidator() != null) {
/* 681 */       mappingTarget.setValidator(checklistModelDTO.getValidator());
/*     */     }
/* 683 */     if (checklistModelDTO.getValidator2() != null) {
/* 684 */       mappingTarget.setValidator2(checklistModelDTO.getValidator2());
/*     */     }
/* 686 */     if (checklistModelDTO.getValidator3() != null) {
/* 687 */       mappingTarget.setValidator3(checklistModelDTO.getValidator3());
/*     */     }
/* 689 */     if (checklistModelDTO.getValidator4() != null) {
/* 690 */       mappingTarget.setValidator4(checklistModelDTO.getValidator4());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void certificationLevelDTOToCertificationLevel1(CertificationLevelDTO certificationLevelDTO, CertificationLevel mappingTarget) {
/* 695 */     if (certificationLevelDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 699 */     if (certificationLevelDTO.getCreatedBy() != null) {
/* 700 */       mappingTarget.createdBy(certificationLevelDTO.getCreatedBy());
/*     */     }
/* 702 */     if (certificationLevelDTO.getCreatedDate() != null) {
/* 703 */       mappingTarget.createdDate(certificationLevelDTO.getCreatedDate());
/*     */     }
/* 705 */     if (certificationLevelDTO.getLastModifiedBy() != null) {
/* 706 */       mappingTarget.lastModifiedBy(certificationLevelDTO.getLastModifiedBy());
/*     */     }
/* 708 */     if (certificationLevelDTO.getLastModifiedDate() != null) {
/* 709 */       mappingTarget.lastModifiedDate(certificationLevelDTO.getLastModifiedDate());
/*     */     }
/* 711 */     if (certificationLevelDTO.getId() != null) {
/* 712 */       mappingTarget.setId(certificationLevelDTO.getId());
/*     */     }
/* 714 */     if (certificationLevelDTO.getLevel() != null) {
/* 715 */       mappingTarget.setLevel(certificationLevelDTO.getLevel());
/*     */     }
/* 717 */     if (certificationLevelDTO.getOrderNumber() != null) {
/* 718 */       mappingTarget.setOrderNumber(certificationLevelDTO.getOrderNumber());
/*     */     }
/* 720 */     if (certificationLevelDTO.getTrainingDuration() != null) {
/* 721 */       mappingTarget.setTrainingDuration(certificationLevelDTO.getTrainingDuration());
/*     */     }
/* 723 */     if (certificationLevelDTO.getRecyclingPeriod() != null) {
/* 724 */       mappingTarget.setRecyclingPeriod(certificationLevelDTO.getRecyclingPeriod());
/*     */     }
/* 726 */     if (certificationLevelDTO.getDescription() != null) {
/* 727 */       mappingTarget.setDescription(certificationLevelDTO.getDescription());
/*     */     }
/* 729 */     if (certificationLevelDTO.getProcess() != null) {
/* 730 */       if (mappingTarget.getProcess() == null) {
/* 731 */         mappingTarget.process(new Process());
/*     */       }
/* 733 */       processDTOToProcess1(certificationLevelDTO.getProcess(), mappingTarget.getProcess());
/*     */     } 
/* 735 */     if (certificationLevelDTO.getChecklistModel() != null) {
/* 736 */       if (mappingTarget.getChecklistModel() == null) {
/* 737 */         mappingTarget.checklistModel(new ChecklistModel());
/*     */       }
/* 739 */       checklistModelDTOToChecklistModel1(certificationLevelDTO.getChecklistModel(), mappingTarget.getChecklistModel());
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void checklistDTOToChecklist1(ChecklistDTO checklistDTO, Checklist mappingTarget) {
/* 744 */     if (checklistDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 748 */     if (checklistDTO.getCreatedBy() != null) {
/* 749 */       mappingTarget.createdBy(checklistDTO.getCreatedBy());
/*     */     }
/* 751 */     if (checklistDTO.getCreatedDate() != null) {
/* 752 */       mappingTarget.createdDate(checklistDTO.getCreatedDate());
/*     */     }
/* 754 */     if (checklistDTO.getLastModifiedBy() != null) {
/* 755 */       mappingTarget.lastModifiedBy(checklistDTO.getLastModifiedBy());
/*     */     }
/* 757 */     if (checklistDTO.getLastModifiedDate() != null) {
/* 758 */       mappingTarget.lastModifiedDate(checklistDTO.getLastModifiedDate());
/*     */     }
/* 760 */     if (checklistDTO.getId() != null) {
/* 761 */       mappingTarget.setId(checklistDTO.getId());
/*     */     }
/* 763 */     if (checklistDTO.getTitle() != null) {
/* 764 */       mappingTarget.setTitle(checklistDTO.getTitle());
/*     */     }
/* 766 */     if (checklistDTO.getDescription() != null) {
/* 767 */       mappingTarget.setDescription(checklistDTO.getDescription());
/*     */     }
/* 769 */     if (checklistDTO.getValidatorRole() != null) {
/* 770 */       mappingTarget.setValidatorRole(checklistDTO.getValidatorRole());
/*     */     }
/* 772 */     if (checklistDTO.getValidator() != null) {
/* 773 */       mappingTarget.setValidator(checklistDTO.getValidator());
/*     */     }
/* 775 */     if (checklistDTO.getValidatorCheck() != null) {
/* 776 */       mappingTarget.setValidatorCheck(checklistDTO.getValidatorCheck());
/*     */     }
/* 778 */     if (checklistDTO.getValidatorRole2() != null) {
/* 779 */       mappingTarget.setValidatorRole2(checklistDTO.getValidatorRole2());
/*     */     }
/* 781 */     if (checklistDTO.getValidator2() != null) {
/* 782 */       mappingTarget.setValidator2(checklistDTO.getValidator2());
/*     */     }
/* 784 */     if (checklistDTO.getValidator2Check() != null) {
/* 785 */       mappingTarget.setValidator2Check(checklistDTO.getValidator2Check());
/*     */     }
/* 787 */     if (checklistDTO.getValidatorRole3() != null) {
/* 788 */       mappingTarget.setValidatorRole3(checklistDTO.getValidatorRole3());
/*     */     }
/* 790 */     if (checklistDTO.getValidator3() != null) {
/* 791 */       mappingTarget.setValidator3(checklistDTO.getValidator3());
/*     */     }
/* 793 */     if (checklistDTO.getValidator3Check() != null) {
/* 794 */       mappingTarget.setValidator3Check(checklistDTO.getValidator3Check());
/*     */     }
/* 796 */     if (checklistDTO.getValidatorRole4() != null) {
/* 797 */       mappingTarget.setValidatorRole4(checklistDTO.getValidatorRole4());
/*     */     }
/* 799 */     if (checklistDTO.getValidator4() != null) {
/* 800 */       mappingTarget.setValidator4(checklistDTO.getValidator4());
/*     */     }
/* 802 */     if (checklistDTO.getValidator4Check() != null) {
/* 803 */       mappingTarget.setValidator4Check(checklistDTO.getValidator4Check());
/*     */     }
/* 805 */     if (checklistDTO.getStatus() != null) {
/* 806 */       mappingTarget.setStatus(checklistDTO.getStatus());
/*     */     }
/* 808 */     if (checklistDTO.getChecklistModel() != null) {
/* 809 */       if (mappingTarget.getChecklistModel() == null) {
/* 810 */         mappingTarget.checklistModel(new ChecklistModel());
/*     */       }
/* 812 */       checklistModelDTOToChecklistModel1(checklistDTO.getChecklistModel(), mappingTarget.getChecklistModel());
/*     */     } 
/* 814 */     if (mappingTarget.getChecklistItems() != null) {
/* 815 */       Set<ChecklistItem> set = checklistItemDTOListToChecklistItemSet(checklistDTO.getChecklistItems());
/* 816 */       if (set != null) {
/* 817 */         mappingTarget.getChecklistItems().clear();
/* 818 */         mappingTarget.getChecklistItems().addAll(set);
/*     */       } 
/*     */     } else {
/*     */       
/* 822 */       Set<ChecklistItem> set = checklistItemDTOListToChecklistItemSet(checklistDTO.getChecklistItems());
/* 823 */       if (set != null) {
/* 824 */         mappingTarget.checklistItems(set);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected ProcessDTO processToProcessDTO(Process process) {
/* 830 */     if (process == null) {
/* 831 */       return null;
/*     */     }
/*     */     
/* 834 */     ProcessDTO processDTO = new ProcessDTO();
/*     */     
/* 836 */     processDTO.setId(process.getId());
/* 837 */     processDTO.setName(process.getName());
/* 838 */     processDTO.setDescription(process.getDescription());
/* 839 */     processDTO.setCreatedBy(process.getCreatedBy());
/* 840 */     processDTO.setCreatedDate(process.getCreatedDate());
/* 841 */     processDTO.setLastModifiedBy(process.getLastModifiedBy());
/* 842 */     processDTO.setLastModifiedDate(process.getLastModifiedDate());
/*     */     
/* 844 */     return processDTO;
/*     */   }
/*     */   
/*     */   protected ChecklistModelDTO checklistModelToChecklistModelDTO(ChecklistModel checklistModel) {
/* 848 */     if (checklistModel == null) {
/* 849 */       return null;
/*     */     }
/*     */     
/* 852 */     ChecklistModelDTO checklistModelDTO = new ChecklistModelDTO();
/*     */     
/* 854 */     checklistModelDTO.setId(checklistModel.getId());
/* 855 */     checklistModelDTO.setTitle(checklistModel.getTitle());
/* 856 */     checklistModelDTO.setDescription(checklistModel.getDescription());
/* 857 */     checklistModelDTO.setValidator(checklistModel.getValidator());
/* 858 */     checklistModelDTO.setValidator2(checklistModel.getValidator2());
/* 859 */     checklistModelDTO.setValidator3(checklistModel.getValidator3());
/* 860 */     checklistModelDTO.setValidator4(checklistModel.getValidator4());
/* 861 */     checklistModelDTO.setCreatedBy(checklistModel.getCreatedBy());
/* 862 */     checklistModelDTO.setCreatedDate(checklistModel.getCreatedDate());
/* 863 */     checklistModelDTO.setLastModifiedBy(checklistModel.getLastModifiedBy());
/* 864 */     checklistModelDTO.setLastModifiedDate(checklistModel.getLastModifiedDate());
/*     */     
/* 866 */     return checklistModelDTO;
/*     */   }
/*     */   
/*     */   protected CertificationLevelDTO certificationLevelToCertificationLevelDTO(CertificationLevel certificationLevel) {
/* 870 */     if (certificationLevel == null) {
/* 871 */       return null;
/*     */     }
/*     */     
/* 874 */     CertificationLevelDTO certificationLevelDTO = new CertificationLevelDTO();
/*     */     
/* 876 */     certificationLevelDTO.setId(certificationLevel.getId());
/* 877 */     certificationLevelDTO.setLevel(certificationLevel.getLevel());
/* 878 */     certificationLevelDTO.setOrderNumber(certificationLevel.getOrderNumber());
/* 879 */     certificationLevelDTO.setTrainingDuration(certificationLevel.getTrainingDuration());
/* 880 */     certificationLevelDTO.setRecyclingPeriod(certificationLevel.getRecyclingPeriod());
/* 881 */     certificationLevelDTO.setDescription(certificationLevel.getDescription());
/* 882 */     certificationLevelDTO.setCreatedBy(certificationLevel.getCreatedBy());
/* 883 */     certificationLevelDTO.setCreatedDate(certificationLevel.getCreatedDate());
/* 884 */     certificationLevelDTO.setLastModifiedBy(certificationLevel.getLastModifiedBy());
/* 885 */     certificationLevelDTO.setLastModifiedDate(certificationLevel.getLastModifiedDate());
/* 886 */     certificationLevelDTO.setProcess(processToProcessDTO(certificationLevel.getProcess()));
/* 887 */     certificationLevelDTO.setChecklistModel(checklistModelToChecklistModelDTO(certificationLevel.getChecklistModel()));
/*     */     
/* 889 */     return certificationLevelDTO;
/*     */   }
/*     */   
/*     */   protected ChecklistItemDTO checklistItemToChecklistItemDTO(ChecklistItem checklistItem) {
/* 893 */     if (checklistItem == null) {
/* 894 */       return null;
/*     */     }
/*     */     
/* 897 */     ChecklistItemDTO checklistItemDTO = new ChecklistItemDTO();
/*     */     
/* 899 */     checklistItemDTO.setId(checklistItem.getId());
/* 900 */     checklistItemDTO.setText(checklistItem.getText());
/* 901 */     checklistItemDTO.setItemGroup(checklistItem.getItemGroup());
/* 902 */     checklistItemDTO.setValidatorRole(checklistItem.getValidatorRole());
/* 903 */     checklistItemDTO.setValidator(checklistItem.getValidator());
/* 904 */     checklistItemDTO.setIsChecked(checklistItem.getIsChecked());
/* 905 */     checklistItemDTO.setCreatedBy(checklistItem.getCreatedBy());
/* 906 */     checklistItemDTO.setCreatedDate(checklistItem.getCreatedDate());
/* 907 */     checklistItemDTO.setLastModifiedBy(checklistItem.getLastModifiedBy());
/* 908 */     checklistItemDTO.setLastModifiedDate(checklistItem.getLastModifiedDate());
/*     */     
/* 910 */     return checklistItemDTO;
/*     */   }
/*     */   
/*     */   protected List<ChecklistItemDTO> checklistItemSetToChecklistItemDTOList(Set<ChecklistItem> set) {
/* 914 */     if (set == null) {
/* 915 */       return null;
/*     */     }
/*     */     
/* 918 */     List<ChecklistItemDTO> list = new ArrayList<>(set.size());
/* 919 */     for (ChecklistItem checklistItem : set) {
/* 920 */       list.add(checklistItemToChecklistItemDTO(checklistItem));
/*     */     }
/*     */     
/* 923 */     return list;
/*     */   }
/*     */   
/*     */   protected ChecklistDTO checklistToChecklistDTO(Checklist checklist) {
/* 927 */     if (checklist == null) {
/* 928 */       return null;
/*     */     }
/*     */     
/* 931 */     ChecklistDTO checklistDTO = new ChecklistDTO();
/*     */     
/* 933 */     checklistDTO.setId(checklist.getId());
/* 934 */     checklistDTO.setTitle(checklist.getTitle());
/* 935 */     checklistDTO.setDescription(checklist.getDescription());
/* 936 */     checklistDTO.setValidatorRole(checklist.getValidatorRole());
/* 937 */     checklistDTO.setValidator(checklist.getValidator());
/* 938 */     checklistDTO.setValidatorCheck(checklist.getValidatorCheck());
/* 939 */     checklistDTO.setValidatorRole2(checklist.getValidatorRole2());
/* 940 */     checklistDTO.setValidator2(checklist.getValidator2());
/* 941 */     checklistDTO.setValidator2Check(checklist.getValidator2Check());
/* 942 */     checklistDTO.setValidatorRole3(checklist.getValidatorRole3());
/* 943 */     checklistDTO.setValidator3(checklist.getValidator3());
/* 944 */     checklistDTO.setValidator3Check(checklist.getValidator3Check());
/* 945 */     checklistDTO.setValidatorRole4(checklist.getValidatorRole4());
/* 946 */     checklistDTO.setValidator4(checklist.getValidator4());
/* 947 */     checklistDTO.setValidator4Check(checklist.getValidator4Check());
/* 948 */     checklistDTO.setStatus(checklist.getStatus());
/* 949 */     checklistDTO.setCreatedBy(checklist.getCreatedBy());
/* 950 */     checklistDTO.setCreatedDate(checklist.getCreatedDate());
/* 951 */     checklistDTO.setLastModifiedBy(checklist.getLastModifiedBy());
/* 952 */     checklistDTO.setLastModifiedDate(checklist.getLastModifiedDate());
/* 953 */     checklistDTO.setChecklistModel(checklistModelToChecklistModelDTO(checklist.getChecklistModel()));
/* 954 */     checklistDTO.setChecklistItems(checklistItemSetToChecklistItemDTOList(checklist.getChecklistItems()));
/*     */     
/* 956 */     return checklistDTO;
/*     */   }
/*     */   
/*     */   protected EmployeeTitleDTO employeeTitleToEmployeeTitleDTO(EmployeeTitle employeeTitle) {
/* 960 */     if (employeeTitle == null) {
/* 961 */       return null;
/*     */     }
/*     */     
/* 964 */     EmployeeTitleDTO employeeTitleDTO = new EmployeeTitleDTO();
/*     */     
/* 966 */     employeeTitleDTO.setId(employeeTitle.getId());
/* 967 */     employeeTitleDTO.setName(employeeTitle.getName());
/* 968 */     employeeTitleDTO.setDescription(employeeTitle.getDescription());
/* 969 */     employeeTitleDTO.setCanSupervise(employeeTitle.getCanSupervise());
/* 970 */     employeeTitleDTO.setCreatedBy(employeeTitle.getCreatedBy());
/* 971 */     employeeTitleDTO.setCreatedDate(employeeTitle.getCreatedDate());
/* 972 */     employeeTitleDTO.setLastModifiedBy(employeeTitle.getLastModifiedBy());
/* 973 */     employeeTitleDTO.setLastModifiedDate(employeeTitle.getLastModifiedDate());
/*     */     
/* 975 */     return employeeTitleDTO;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\CertificateMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */