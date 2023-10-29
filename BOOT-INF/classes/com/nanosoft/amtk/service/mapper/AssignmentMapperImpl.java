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
/*     */ import com.nanosoft.amtk.service.dto.WorkstationDTO;
/*     */ import com.nanosoft.amtk.service.mapper.AssignmentMapper;
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
/*     */ 
/*     */ @Component
/*     */ public class AssignmentMapperImpl
/*     */   implements AssignmentMapper
/*     */ {
/*     */   @Autowired
/*     */   private WorkstationMapper workstationMapper;
/*     */   
/*     */   public Assignment toEntity(AssignmentDTO dto) {
/*  46 */     if (dto == null) {
/*  47 */       return null;
/*     */     }
/*     */     
/*  50 */     Assignment assignment = new Assignment();
/*     */     
/*  52 */     assignment.createdBy(dto.getCreatedBy());
/*  53 */     assignment.createdDate(dto.getCreatedDate());
/*  54 */     assignment.lastModifiedBy(dto.getLastModifiedBy());
/*  55 */     assignment.lastModifiedDate(dto.getLastModifiedDate());
/*  56 */     assignment.setId(dto.getId());
/*  57 */     assignment.setAssignmentStart(dto.getAssignmentStart());
/*  58 */     assignment.setAssignmentEnd(dto.getAssignmentEnd());
/*  59 */     assignment.setDescription(dto.getDescription());
/*  60 */     assignment.workstation((Workstation)this.workstationMapper.toEntity(dto.getWorkstation()));
/*  61 */     assignment.employee(employeeDTOToEmployee(dto.getEmployee()));
/*  62 */     assignment.currentCertificate(certificateDTOToCertificate(dto.getCurrentCertificate()));
/*     */     
/*  64 */     return assignment;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Assignment> toEntity(List<AssignmentDTO> dtoList) {
/*  69 */     if (dtoList == null) {
/*  70 */       return null;
/*     */     }
/*     */     
/*  73 */     List<Assignment> list = new ArrayList<>(dtoList.size());
/*  74 */     for (AssignmentDTO assignmentDTO : dtoList) {
/*  75 */       list.add(toEntity(assignmentDTO));
/*     */     }
/*     */     
/*  78 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<AssignmentDTO> toDto(List<Assignment> entityList) {
/*  83 */     if (entityList == null) {
/*  84 */       return null;
/*     */     }
/*     */     
/*  87 */     List<AssignmentDTO> list = new ArrayList<>(entityList.size());
/*  88 */     for (Assignment assignment : entityList) {
/*  89 */       list.add(toDto(assignment));
/*     */     }
/*     */     
/*  92 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(Assignment entity, AssignmentDTO dto) {
/*  97 */     if (dto == null) {
/*     */       return;
/*     */     }
/*     */     
/* 101 */     if (dto.getCreatedBy() != null) {
/* 102 */       entity.createdBy(dto.getCreatedBy());
/*     */     }
/* 104 */     if (dto.getCreatedDate() != null) {
/* 105 */       entity.createdDate(dto.getCreatedDate());
/*     */     }
/* 107 */     if (dto.getLastModifiedBy() != null) {
/* 108 */       entity.lastModifiedBy(dto.getLastModifiedBy());
/*     */     }
/* 110 */     if (dto.getLastModifiedDate() != null) {
/* 111 */       entity.lastModifiedDate(dto.getLastModifiedDate());
/*     */     }
/* 113 */     if (dto.getId() != null) {
/* 114 */       entity.setId(dto.getId());
/*     */     }
/* 116 */     if (dto.getAssignmentStart() != null) {
/* 117 */       entity.setAssignmentStart(dto.getAssignmentStart());
/*     */     }
/* 119 */     if (dto.getAssignmentEnd() != null) {
/* 120 */       entity.setAssignmentEnd(dto.getAssignmentEnd());
/*     */     }
/* 122 */     if (dto.getDescription() != null) {
/* 123 */       entity.setDescription(dto.getDescription());
/*     */     }
/* 125 */     if (dto.getWorkstation() != null) {
/* 126 */       entity.workstation((Workstation)this.workstationMapper.toEntity(dto.getWorkstation()));
/*     */     }
/* 128 */     if (dto.getEmployee() != null) {
/* 129 */       if (entity.getEmployee() == null) {
/* 130 */         entity.employee(new Employee());
/*     */       }
/* 132 */       employeeDTOToEmployee1(dto.getEmployee(), entity.getEmployee());
/*     */     } 
/* 134 */     if (dto.getCurrentCertificate() != null) {
/* 135 */       if (entity.getCurrentCertificate() == null) {
/* 136 */         entity.currentCertificate(new Certificate());
/*     */       }
/* 138 */       certificateDTOToCertificate1(dto.getCurrentCertificate(), entity.getCurrentCertificate());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public AssignmentDTO toDto(Assignment s) {
/* 144 */     if (s == null) {
/* 145 */       return null;
/*     */     }
/*     */     
/* 148 */     AssignmentDTO assignmentDTO = new AssignmentDTO();
/*     */     
/* 150 */     assignmentDTO.setWorkstation(this.workstationMapper.toDto(s.getWorkstation()));
/* 151 */     assignmentDTO.setEmployee(toDtoEmployeeId(s.getEmployee()));
/* 152 */     assignmentDTO.setCurrentCertificate(toDtoCertificateId(s.getCurrentCertificate()));
/* 153 */     assignmentDTO.setId(s.getId());
/* 154 */     assignmentDTO.setAssignmentStart(s.getAssignmentStart());
/* 155 */     assignmentDTO.setAssignmentEnd(s.getAssignmentEnd());
/* 156 */     assignmentDTO.setDescription(s.getDescription());
/* 157 */     assignmentDTO.setCreatedBy(s.getCreatedBy());
/* 158 */     assignmentDTO.setCreatedDate(s.getCreatedDate());
/* 159 */     assignmentDTO.setLastModifiedBy(s.getLastModifiedBy());
/* 160 */     assignmentDTO.setLastModifiedDate(s.getLastModifiedDate());
/*     */     
/* 162 */     return assignmentDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public CertificateDTO toDtoCertificateId(Certificate certificate) {
/* 167 */     if (certificate == null) {
/* 168 */       return null;
/*     */     }
/*     */     
/* 171 */     CertificateDTO certificateDTO = new CertificateDTO();
/*     */     
/* 173 */     certificateDTO.setId(certificate.getId());
/*     */     
/* 175 */     return certificateDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public WorkstationDTO toDtoWorkstationId(Workstation workstation) {
/* 180 */     if (workstation == null) {
/* 181 */       return null;
/*     */     }
/*     */     
/* 184 */     WorkstationDTO workstationDTO = new WorkstationDTO();
/*     */     
/* 186 */     workstationDTO.setId(workstation.getId());
/*     */     
/* 188 */     return workstationDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public EmployeeDTO toDtoEmployeeId(Employee employee) {
/* 193 */     if (employee == null) {
/* 194 */       return null;
/*     */     }
/*     */     
/* 197 */     EmployeeDTO employeeDTO = new EmployeeDTO();
/*     */     
/* 199 */     employeeDTO.setId(employee.getId());
/* 200 */     employeeDTO.setFirstName(employee.getFirstName());
/* 201 */     employeeDTO.setLastName(employee.getLastName());
/* 202 */     employeeDTO.setEmployeeNumber(employee.getEmployeeNumber());
/* 203 */     employeeDTO.setTitle(employeeTitleToEmployeeTitleDTO(employee.getTitle()));
/*     */     
/* 205 */     return employeeDTO;
/*     */   }
/*     */   
/*     */   protected EmployeeTitle employeeTitleDTOToEmployeeTitle(EmployeeTitleDTO employeeTitleDTO) {
/* 209 */     if (employeeTitleDTO == null) {
/* 210 */       return null;
/*     */     }
/*     */     
/* 213 */     EmployeeTitle employeeTitle = new EmployeeTitle();
/*     */     
/* 215 */     employeeTitle.createdBy(employeeTitleDTO.getCreatedBy());
/* 216 */     employeeTitle.createdDate(employeeTitleDTO.getCreatedDate());
/* 217 */     employeeTitle.lastModifiedBy(employeeTitleDTO.getLastModifiedBy());
/* 218 */     employeeTitle.lastModifiedDate(employeeTitleDTO.getLastModifiedDate());
/* 219 */     employeeTitle.setId(employeeTitleDTO.getId());
/* 220 */     employeeTitle.setName(employeeTitleDTO.getName());
/* 221 */     employeeTitle.setDescription(employeeTitleDTO.getDescription());
/* 222 */     employeeTitle.setCanSupervise(employeeTitleDTO.getCanSupervise());
/*     */     
/* 224 */     return employeeTitle;
/*     */   }
/*     */   
/*     */   protected Team teamDTOToTeam(TeamDTO teamDTO) {
/* 228 */     if (teamDTO == null) {
/* 229 */       return null;
/*     */     }
/*     */     
/* 232 */     Team team = new Team();
/*     */     
/* 234 */     team.createdBy(teamDTO.getCreatedBy());
/* 235 */     team.createdDate(teamDTO.getCreatedDate());
/* 236 */     team.lastModifiedBy(teamDTO.getLastModifiedBy());
/* 237 */     team.lastModifiedDate(teamDTO.getLastModifiedDate());
/* 238 */     team.setId(teamDTO.getId());
/* 239 */     team.setName(teamDTO.getName());
/* 240 */     team.setDescription(teamDTO.getDescription());
/* 241 */     team.supervisor(employeeDTOToEmployee(teamDTO.getSupervisor()));
/*     */     
/* 243 */     return team;
/*     */   }
/*     */   
/*     */   protected Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
/* 247 */     if (employeeDTO == null) {
/* 248 */       return null;
/*     */     }
/*     */     
/* 251 */     Employee employee = new Employee();
/*     */     
/* 253 */     employee.createdBy(employeeDTO.getCreatedBy());
/* 254 */     employee.createdDate(employeeDTO.getCreatedDate());
/* 255 */     employee.lastModifiedBy(employeeDTO.getLastModifiedBy());
/* 256 */     employee.lastModifiedDate(employeeDTO.getLastModifiedDate());
/* 257 */     employee.setId(employeeDTO.getId());
/* 258 */     employee.setFirstName(employeeDTO.getFirstName());
/* 259 */     employee.setLastName(employeeDTO.getLastName());
/* 260 */     employee.setThirdName(employeeDTO.getThirdName());
/* 261 */     employee.setGender(employeeDTO.getGender());
/* 262 */     employee.setIdNumber(employeeDTO.getIdNumber());
/* 263 */     employee.setBirthday(employeeDTO.getBirthday());
/* 264 */     employee.setJoiningDate(employeeDTO.getJoiningDate());
/* 265 */     employee.setRelievingDate(employeeDTO.getRelievingDate());
/* 266 */     employee.setEmployeeNumber(employeeDTO.getEmployeeNumber());
/* 267 */     employee.title(employeeTitleDTOToEmployeeTitle(employeeDTO.getTitle()));
/* 268 */     employee.team(teamDTOToTeam(employeeDTO.getTeam()));
/*     */     
/* 270 */     return employee;
/*     */   }
/*     */   
/*     */   protected Process processDTOToProcess(ProcessDTO processDTO) {
/* 274 */     if (processDTO == null) {
/* 275 */       return null;
/*     */     }
/*     */     
/* 278 */     Process process = new Process();
/*     */     
/* 280 */     process.createdBy(processDTO.getCreatedBy());
/* 281 */     process.createdDate(processDTO.getCreatedDate());
/* 282 */     process.lastModifiedBy(processDTO.getLastModifiedBy());
/* 283 */     process.lastModifiedDate(processDTO.getLastModifiedDate());
/* 284 */     process.setId(processDTO.getId());
/* 285 */     process.setName(processDTO.getName());
/* 286 */     process.setDescription(processDTO.getDescription());
/*     */     
/* 288 */     return process;
/*     */   }
/*     */   
/*     */   protected ChecklistModel checklistModelDTOToChecklistModel(ChecklistModelDTO checklistModelDTO) {
/* 292 */     if (checklistModelDTO == null) {
/* 293 */       return null;
/*     */     }
/*     */     
/* 296 */     ChecklistModel checklistModel = new ChecklistModel();
/*     */     
/* 298 */     checklistModel.createdBy(checklistModelDTO.getCreatedBy());
/* 299 */     checklistModel.createdDate(checklistModelDTO.getCreatedDate());
/* 300 */     checklistModel.lastModifiedBy(checklistModelDTO.getLastModifiedBy());
/* 301 */     checklistModel.lastModifiedDate(checklistModelDTO.getLastModifiedDate());
/* 302 */     checklistModel.setId(checklistModelDTO.getId());
/* 303 */     checklistModel.setTitle(checklistModelDTO.getTitle());
/* 304 */     checklistModel.setDescription(checklistModelDTO.getDescription());
/* 305 */     checklistModel.setValidator(checklistModelDTO.getValidator());
/* 306 */     checklistModel.setValidator2(checklistModelDTO.getValidator2());
/* 307 */     checklistModel.setValidator3(checklistModelDTO.getValidator3());
/* 308 */     checklistModel.setValidator4(checklistModelDTO.getValidator4());
/*     */     
/* 310 */     return checklistModel;
/*     */   }
/*     */   
/*     */   protected CertificationLevel certificationLevelDTOToCertificationLevel(CertificationLevelDTO certificationLevelDTO) {
/* 314 */     if (certificationLevelDTO == null) {
/* 315 */       return null;
/*     */     }
/*     */     
/* 318 */     CertificationLevel certificationLevel = new CertificationLevel();
/*     */     
/* 320 */     certificationLevel.createdBy(certificationLevelDTO.getCreatedBy());
/* 321 */     certificationLevel.createdDate(certificationLevelDTO.getCreatedDate());
/* 322 */     certificationLevel.lastModifiedBy(certificationLevelDTO.getLastModifiedBy());
/* 323 */     certificationLevel.lastModifiedDate(certificationLevelDTO.getLastModifiedDate());
/* 324 */     certificationLevel.setId(certificationLevelDTO.getId());
/* 325 */     certificationLevel.setLevel(certificationLevelDTO.getLevel());
/* 326 */     certificationLevel.setOrderNumber(certificationLevelDTO.getOrderNumber());
/* 327 */     certificationLevel.setTrainingDuration(certificationLevelDTO.getTrainingDuration());
/* 328 */     certificationLevel.setRecyclingPeriod(certificationLevelDTO.getRecyclingPeriod());
/* 329 */     certificationLevel.setDescription(certificationLevelDTO.getDescription());
/* 330 */     certificationLevel.process(processDTOToProcess(certificationLevelDTO.getProcess()));
/* 331 */     certificationLevel.checklistModel(checklistModelDTOToChecklistModel(certificationLevelDTO.getChecklistModel()));
/*     */     
/* 333 */     return certificationLevel;
/*     */   }
/*     */   
/*     */   protected ChecklistItem checklistItemDTOToChecklistItem(ChecklistItemDTO checklistItemDTO) {
/* 337 */     if (checklistItemDTO == null) {
/* 338 */       return null;
/*     */     }
/*     */     
/* 341 */     ChecklistItem checklistItem = new ChecklistItem();
/*     */     
/* 343 */     checklistItem.createdBy(checklistItemDTO.getCreatedBy());
/* 344 */     checklistItem.createdDate(checklistItemDTO.getCreatedDate());
/* 345 */     checklistItem.lastModifiedBy(checklistItemDTO.getLastModifiedBy());
/* 346 */     checklistItem.lastModifiedDate(checklistItemDTO.getLastModifiedDate());
/* 347 */     checklistItem.setId(checklistItemDTO.getId());
/* 348 */     checklistItem.setText(checklistItemDTO.getText());
/* 349 */     checklistItem.setItemGroup(checklistItemDTO.getItemGroup());
/* 350 */     checklistItem.setValidatorRole(checklistItemDTO.getValidatorRole());
/* 351 */     checklistItem.setValidator(checklistItemDTO.getValidator());
/* 352 */     checklistItem.setIsChecked(checklistItemDTO.getIsChecked());
/*     */     
/* 354 */     return checklistItem;
/*     */   }
/*     */   
/*     */   protected Set<ChecklistItem> checklistItemDTOListToChecklistItemSet(List<ChecklistItemDTO> list) {
/* 358 */     if (list == null) {
/* 359 */       return null;
/*     */     }
/*     */     
/* 362 */     Set<ChecklistItem> set = new LinkedHashSet<>(Math.max((int)(list.size() / 0.75F) + 1, 16));
/* 363 */     for (ChecklistItemDTO checklistItemDTO : list) {
/* 364 */       set.add(checklistItemDTOToChecklistItem(checklistItemDTO));
/*     */     }
/*     */     
/* 367 */     return set;
/*     */   }
/*     */   
/*     */   protected Checklist checklistDTOToChecklist(ChecklistDTO checklistDTO) {
/* 371 */     if (checklistDTO == null) {
/* 372 */       return null;
/*     */     }
/*     */     
/* 375 */     Checklist checklist = new Checklist();
/*     */     
/* 377 */     checklist.createdBy(checklistDTO.getCreatedBy());
/* 378 */     checklist.createdDate(checklistDTO.getCreatedDate());
/* 379 */     checklist.lastModifiedBy(checklistDTO.getLastModifiedBy());
/* 380 */     checklist.lastModifiedDate(checklistDTO.getLastModifiedDate());
/* 381 */     checklist.setId(checklistDTO.getId());
/* 382 */     checklist.setTitle(checklistDTO.getTitle());
/* 383 */     checklist.setDescription(checklistDTO.getDescription());
/* 384 */     checklist.setValidatorRole(checklistDTO.getValidatorRole());
/* 385 */     checklist.setValidator(checklistDTO.getValidator());
/* 386 */     checklist.setValidatorCheck(checklistDTO.getValidatorCheck());
/* 387 */     checklist.setValidatorRole2(checklistDTO.getValidatorRole2());
/* 388 */     checklist.setValidator2(checklistDTO.getValidator2());
/* 389 */     checklist.setValidator2Check(checklistDTO.getValidator2Check());
/* 390 */     checklist.setValidatorRole3(checklistDTO.getValidatorRole3());
/* 391 */     checklist.setValidator3(checklistDTO.getValidator3());
/* 392 */     checklist.setValidator3Check(checklistDTO.getValidator3Check());
/* 393 */     checklist.setValidatorRole4(checklistDTO.getValidatorRole4());
/* 394 */     checklist.setValidator4(checklistDTO.getValidator4());
/* 395 */     checklist.setValidator4Check(checklistDTO.getValidator4Check());
/* 396 */     checklist.setStatus(checklistDTO.getStatus());
/* 397 */     checklist.checklistModel(checklistModelDTOToChecklistModel(checklistDTO.getChecklistModel()));
/* 398 */     checklist.checklistItems(checklistItemDTOListToChecklistItemSet(checklistDTO.getChecklistItems()));
/*     */     
/* 400 */     return checklist;
/*     */   }
/*     */   
/*     */   protected Certificate certificateDTOToCertificate(CertificateDTO certificateDTO) {
/* 404 */     if (certificateDTO == null) {
/* 405 */       return null;
/*     */     }
/*     */     
/* 408 */     Certificate certificate = new Certificate();
/*     */     
/* 410 */     certificate.createdBy(certificateDTO.getCreatedBy());
/* 411 */     certificate.createdDate(certificateDTO.getCreatedDate());
/* 412 */     certificate.lastModifiedBy(certificateDTO.getLastModifiedBy());
/* 413 */     certificate.lastModifiedDate(certificateDTO.getLastModifiedDate());
/* 414 */     certificate.setId(certificateDTO.getId());
/* 415 */     certificate.setStatus(certificateDTO.getStatus());
/* 416 */     certificate.setStartDate(certificateDTO.getStartDate());
/* 417 */     certificate.setExpectedEndDate(certificateDTO.getExpectedEndDate());
/* 418 */     certificate.setEndDate(certificateDTO.getEndDate());
/* 419 */     certificate.setValidated(certificateDTO.getValidated());
/* 420 */     certificate.setIsRecycling(certificateDTO.getIsRecycling());
/* 421 */     certificate.assignment(toEntity(certificateDTO.getAssignment()));
/* 422 */     certificate.level(certificationLevelDTOToCertificationLevel(certificateDTO.getLevel()));
/* 423 */     certificate.checklist(checklistDTOToChecklist(certificateDTO.getChecklist()));
/*     */     
/* 425 */     return certificate;
/*     */   }
/*     */   
/*     */   protected void employeeTitleDTOToEmployeeTitle1(EmployeeTitleDTO employeeTitleDTO, EmployeeTitle mappingTarget) {
/* 429 */     if (employeeTitleDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 433 */     if (employeeTitleDTO.getCreatedBy() != null) {
/* 434 */       mappingTarget.createdBy(employeeTitleDTO.getCreatedBy());
/*     */     }
/* 436 */     if (employeeTitleDTO.getCreatedDate() != null) {
/* 437 */       mappingTarget.createdDate(employeeTitleDTO.getCreatedDate());
/*     */     }
/* 439 */     if (employeeTitleDTO.getLastModifiedBy() != null) {
/* 440 */       mappingTarget.lastModifiedBy(employeeTitleDTO.getLastModifiedBy());
/*     */     }
/* 442 */     if (employeeTitleDTO.getLastModifiedDate() != null) {
/* 443 */       mappingTarget.lastModifiedDate(employeeTitleDTO.getLastModifiedDate());
/*     */     }
/* 445 */     if (employeeTitleDTO.getId() != null) {
/* 446 */       mappingTarget.setId(employeeTitleDTO.getId());
/*     */     }
/* 448 */     if (employeeTitleDTO.getName() != null) {
/* 449 */       mappingTarget.setName(employeeTitleDTO.getName());
/*     */     }
/* 451 */     if (employeeTitleDTO.getDescription() != null) {
/* 452 */       mappingTarget.setDescription(employeeTitleDTO.getDescription());
/*     */     }
/* 454 */     if (employeeTitleDTO.getCanSupervise() != null) {
/* 455 */       mappingTarget.setCanSupervise(employeeTitleDTO.getCanSupervise());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void teamDTOToTeam1(TeamDTO teamDTO, Team mappingTarget) {
/* 460 */     if (teamDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 464 */     if (teamDTO.getCreatedBy() != null) {
/* 465 */       mappingTarget.createdBy(teamDTO.getCreatedBy());
/*     */     }
/* 467 */     if (teamDTO.getCreatedDate() != null) {
/* 468 */       mappingTarget.createdDate(teamDTO.getCreatedDate());
/*     */     }
/* 470 */     if (teamDTO.getLastModifiedBy() != null) {
/* 471 */       mappingTarget.lastModifiedBy(teamDTO.getLastModifiedBy());
/*     */     }
/* 473 */     if (teamDTO.getLastModifiedDate() != null) {
/* 474 */       mappingTarget.lastModifiedDate(teamDTO.getLastModifiedDate());
/*     */     }
/* 476 */     if (teamDTO.getId() != null) {
/* 477 */       mappingTarget.setId(teamDTO.getId());
/*     */     }
/* 479 */     if (teamDTO.getName() != null) {
/* 480 */       mappingTarget.setName(teamDTO.getName());
/*     */     }
/* 482 */     if (teamDTO.getDescription() != null) {
/* 483 */       mappingTarget.setDescription(teamDTO.getDescription());
/*     */     }
/* 485 */     if (teamDTO.getSupervisor() != null) {
/* 486 */       if (mappingTarget.getSupervisor() == null) {
/* 487 */         mappingTarget.supervisor(new Employee());
/*     */       }
/* 489 */       employeeDTOToEmployee1(teamDTO.getSupervisor(), mappingTarget.getSupervisor());
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void employeeDTOToEmployee1(EmployeeDTO employeeDTO, Employee mappingTarget) {
/* 494 */     if (employeeDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 498 */     if (employeeDTO.getCreatedBy() != null) {
/* 499 */       mappingTarget.createdBy(employeeDTO.getCreatedBy());
/*     */     }
/* 501 */     if (employeeDTO.getCreatedDate() != null) {
/* 502 */       mappingTarget.createdDate(employeeDTO.getCreatedDate());
/*     */     }
/* 504 */     if (employeeDTO.getLastModifiedBy() != null) {
/* 505 */       mappingTarget.lastModifiedBy(employeeDTO.getLastModifiedBy());
/*     */     }
/* 507 */     if (employeeDTO.getLastModifiedDate() != null) {
/* 508 */       mappingTarget.lastModifiedDate(employeeDTO.getLastModifiedDate());
/*     */     }
/* 510 */     if (employeeDTO.getId() != null) {
/* 511 */       mappingTarget.setId(employeeDTO.getId());
/*     */     }
/* 513 */     if (employeeDTO.getFirstName() != null) {
/* 514 */       mappingTarget.setFirstName(employeeDTO.getFirstName());
/*     */     }
/* 516 */     if (employeeDTO.getLastName() != null) {
/* 517 */       mappingTarget.setLastName(employeeDTO.getLastName());
/*     */     }
/* 519 */     if (employeeDTO.getThirdName() != null) {
/* 520 */       mappingTarget.setThirdName(employeeDTO.getThirdName());
/*     */     }
/* 522 */     if (employeeDTO.getGender() != null) {
/* 523 */       mappingTarget.setGender(employeeDTO.getGender());
/*     */     }
/* 525 */     if (employeeDTO.getIdNumber() != null) {
/* 526 */       mappingTarget.setIdNumber(employeeDTO.getIdNumber());
/*     */     }
/* 528 */     if (employeeDTO.getBirthday() != null) {
/* 529 */       mappingTarget.setBirthday(employeeDTO.getBirthday());
/*     */     }
/* 531 */     if (employeeDTO.getJoiningDate() != null) {
/* 532 */       mappingTarget.setJoiningDate(employeeDTO.getJoiningDate());
/*     */     }
/* 534 */     if (employeeDTO.getRelievingDate() != null) {
/* 535 */       mappingTarget.setRelievingDate(employeeDTO.getRelievingDate());
/*     */     }
/* 537 */     if (employeeDTO.getEmployeeNumber() != null) {
/* 538 */       mappingTarget.setEmployeeNumber(employeeDTO.getEmployeeNumber());
/*     */     }
/* 540 */     if (employeeDTO.getTitle() != null) {
/* 541 */       if (mappingTarget.getTitle() == null) {
/* 542 */         mappingTarget.title(new EmployeeTitle());
/*     */       }
/* 544 */       employeeTitleDTOToEmployeeTitle1(employeeDTO.getTitle(), mappingTarget.getTitle());
/*     */     } 
/* 546 */     if (employeeDTO.getTeam() != null) {
/* 547 */       if (mappingTarget.getTeam() == null) {
/* 548 */         mappingTarget.team(new Team());
/*     */       }
/* 550 */       teamDTOToTeam1(employeeDTO.getTeam(), mappingTarget.getTeam());
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void processDTOToProcess1(ProcessDTO processDTO, Process mappingTarget) {
/* 555 */     if (processDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 559 */     if (processDTO.getCreatedBy() != null) {
/* 560 */       mappingTarget.createdBy(processDTO.getCreatedBy());
/*     */     }
/* 562 */     if (processDTO.getCreatedDate() != null) {
/* 563 */       mappingTarget.createdDate(processDTO.getCreatedDate());
/*     */     }
/* 565 */     if (processDTO.getLastModifiedBy() != null) {
/* 566 */       mappingTarget.lastModifiedBy(processDTO.getLastModifiedBy());
/*     */     }
/* 568 */     if (processDTO.getLastModifiedDate() != null) {
/* 569 */       mappingTarget.lastModifiedDate(processDTO.getLastModifiedDate());
/*     */     }
/* 571 */     if (processDTO.getId() != null) {
/* 572 */       mappingTarget.setId(processDTO.getId());
/*     */     }
/* 574 */     if (processDTO.getName() != null) {
/* 575 */       mappingTarget.setName(processDTO.getName());
/*     */     }
/* 577 */     if (processDTO.getDescription() != null) {
/* 578 */       mappingTarget.setDescription(processDTO.getDescription());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void checklistModelDTOToChecklistModel1(ChecklistModelDTO checklistModelDTO, ChecklistModel mappingTarget) {
/* 583 */     if (checklistModelDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 587 */     if (checklistModelDTO.getCreatedBy() != null) {
/* 588 */       mappingTarget.createdBy(checklistModelDTO.getCreatedBy());
/*     */     }
/* 590 */     if (checklistModelDTO.getCreatedDate() != null) {
/* 591 */       mappingTarget.createdDate(checklistModelDTO.getCreatedDate());
/*     */     }
/* 593 */     if (checklistModelDTO.getLastModifiedBy() != null) {
/* 594 */       mappingTarget.lastModifiedBy(checklistModelDTO.getLastModifiedBy());
/*     */     }
/* 596 */     if (checklistModelDTO.getLastModifiedDate() != null) {
/* 597 */       mappingTarget.lastModifiedDate(checklistModelDTO.getLastModifiedDate());
/*     */     }
/* 599 */     if (checklistModelDTO.getId() != null) {
/* 600 */       mappingTarget.setId(checklistModelDTO.getId());
/*     */     }
/* 602 */     if (checklistModelDTO.getTitle() != null) {
/* 603 */       mappingTarget.setTitle(checklistModelDTO.getTitle());
/*     */     }
/* 605 */     if (checklistModelDTO.getDescription() != null) {
/* 606 */       mappingTarget.setDescription(checklistModelDTO.getDescription());
/*     */     }
/* 608 */     if (checklistModelDTO.getValidator() != null) {
/* 609 */       mappingTarget.setValidator(checklistModelDTO.getValidator());
/*     */     }
/* 611 */     if (checklistModelDTO.getValidator2() != null) {
/* 612 */       mappingTarget.setValidator2(checklistModelDTO.getValidator2());
/*     */     }
/* 614 */     if (checklistModelDTO.getValidator3() != null) {
/* 615 */       mappingTarget.setValidator3(checklistModelDTO.getValidator3());
/*     */     }
/* 617 */     if (checklistModelDTO.getValidator4() != null) {
/* 618 */       mappingTarget.setValidator4(checklistModelDTO.getValidator4());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void certificationLevelDTOToCertificationLevel1(CertificationLevelDTO certificationLevelDTO, CertificationLevel mappingTarget) {
/* 623 */     if (certificationLevelDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 627 */     if (certificationLevelDTO.getCreatedBy() != null) {
/* 628 */       mappingTarget.createdBy(certificationLevelDTO.getCreatedBy());
/*     */     }
/* 630 */     if (certificationLevelDTO.getCreatedDate() != null) {
/* 631 */       mappingTarget.createdDate(certificationLevelDTO.getCreatedDate());
/*     */     }
/* 633 */     if (certificationLevelDTO.getLastModifiedBy() != null) {
/* 634 */       mappingTarget.lastModifiedBy(certificationLevelDTO.getLastModifiedBy());
/*     */     }
/* 636 */     if (certificationLevelDTO.getLastModifiedDate() != null) {
/* 637 */       mappingTarget.lastModifiedDate(certificationLevelDTO.getLastModifiedDate());
/*     */     }
/* 639 */     if (certificationLevelDTO.getId() != null) {
/* 640 */       mappingTarget.setId(certificationLevelDTO.getId());
/*     */     }
/* 642 */     if (certificationLevelDTO.getLevel() != null) {
/* 643 */       mappingTarget.setLevel(certificationLevelDTO.getLevel());
/*     */     }
/* 645 */     if (certificationLevelDTO.getOrderNumber() != null) {
/* 646 */       mappingTarget.setOrderNumber(certificationLevelDTO.getOrderNumber());
/*     */     }
/* 648 */     if (certificationLevelDTO.getTrainingDuration() != null) {
/* 649 */       mappingTarget.setTrainingDuration(certificationLevelDTO.getTrainingDuration());
/*     */     }
/* 651 */     if (certificationLevelDTO.getRecyclingPeriod() != null) {
/* 652 */       mappingTarget.setRecyclingPeriod(certificationLevelDTO.getRecyclingPeriod());
/*     */     }
/* 654 */     if (certificationLevelDTO.getDescription() != null) {
/* 655 */       mappingTarget.setDescription(certificationLevelDTO.getDescription());
/*     */     }
/* 657 */     if (certificationLevelDTO.getProcess() != null) {
/* 658 */       if (mappingTarget.getProcess() == null) {
/* 659 */         mappingTarget.process(new Process());
/*     */       }
/* 661 */       processDTOToProcess1(certificationLevelDTO.getProcess(), mappingTarget.getProcess());
/*     */     } 
/* 663 */     if (certificationLevelDTO.getChecklistModel() != null) {
/* 664 */       if (mappingTarget.getChecklistModel() == null) {
/* 665 */         mappingTarget.checklistModel(new ChecklistModel());
/*     */       }
/* 667 */       checklistModelDTOToChecklistModel1(certificationLevelDTO.getChecklistModel(), mappingTarget.getChecklistModel());
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void checklistDTOToChecklist1(ChecklistDTO checklistDTO, Checklist mappingTarget) {
/* 672 */     if (checklistDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 676 */     if (checklistDTO.getCreatedBy() != null) {
/* 677 */       mappingTarget.createdBy(checklistDTO.getCreatedBy());
/*     */     }
/* 679 */     if (checklistDTO.getCreatedDate() != null) {
/* 680 */       mappingTarget.createdDate(checklistDTO.getCreatedDate());
/*     */     }
/* 682 */     if (checklistDTO.getLastModifiedBy() != null) {
/* 683 */       mappingTarget.lastModifiedBy(checklistDTO.getLastModifiedBy());
/*     */     }
/* 685 */     if (checklistDTO.getLastModifiedDate() != null) {
/* 686 */       mappingTarget.lastModifiedDate(checklistDTO.getLastModifiedDate());
/*     */     }
/* 688 */     if (checklistDTO.getId() != null) {
/* 689 */       mappingTarget.setId(checklistDTO.getId());
/*     */     }
/* 691 */     if (checklistDTO.getTitle() != null) {
/* 692 */       mappingTarget.setTitle(checklistDTO.getTitle());
/*     */     }
/* 694 */     if (checklistDTO.getDescription() != null) {
/* 695 */       mappingTarget.setDescription(checklistDTO.getDescription());
/*     */     }
/* 697 */     if (checklistDTO.getValidatorRole() != null) {
/* 698 */       mappingTarget.setValidatorRole(checklistDTO.getValidatorRole());
/*     */     }
/* 700 */     if (checklistDTO.getValidator() != null) {
/* 701 */       mappingTarget.setValidator(checklistDTO.getValidator());
/*     */     }
/* 703 */     if (checklistDTO.getValidatorCheck() != null) {
/* 704 */       mappingTarget.setValidatorCheck(checklistDTO.getValidatorCheck());
/*     */     }
/* 706 */     if (checklistDTO.getValidatorRole2() != null) {
/* 707 */       mappingTarget.setValidatorRole2(checklistDTO.getValidatorRole2());
/*     */     }
/* 709 */     if (checklistDTO.getValidator2() != null) {
/* 710 */       mappingTarget.setValidator2(checklistDTO.getValidator2());
/*     */     }
/* 712 */     if (checklistDTO.getValidator2Check() != null) {
/* 713 */       mappingTarget.setValidator2Check(checklistDTO.getValidator2Check());
/*     */     }
/* 715 */     if (checklistDTO.getValidatorRole3() != null) {
/* 716 */       mappingTarget.setValidatorRole3(checklistDTO.getValidatorRole3());
/*     */     }
/* 718 */     if (checklistDTO.getValidator3() != null) {
/* 719 */       mappingTarget.setValidator3(checklistDTO.getValidator3());
/*     */     }
/* 721 */     if (checklistDTO.getValidator3Check() != null) {
/* 722 */       mappingTarget.setValidator3Check(checklistDTO.getValidator3Check());
/*     */     }
/* 724 */     if (checklistDTO.getValidatorRole4() != null) {
/* 725 */       mappingTarget.setValidatorRole4(checklistDTO.getValidatorRole4());
/*     */     }
/* 727 */     if (checklistDTO.getValidator4() != null) {
/* 728 */       mappingTarget.setValidator4(checklistDTO.getValidator4());
/*     */     }
/* 730 */     if (checklistDTO.getValidator4Check() != null) {
/* 731 */       mappingTarget.setValidator4Check(checklistDTO.getValidator4Check());
/*     */     }
/* 733 */     if (checklistDTO.getStatus() != null) {
/* 734 */       mappingTarget.setStatus(checklistDTO.getStatus());
/*     */     }
/* 736 */     if (checklistDTO.getChecklistModel() != null) {
/* 737 */       if (mappingTarget.getChecklistModel() == null) {
/* 738 */         mappingTarget.checklistModel(new ChecklistModel());
/*     */       }
/* 740 */       checklistModelDTOToChecklistModel1(checklistDTO.getChecklistModel(), mappingTarget.getChecklistModel());
/*     */     } 
/* 742 */     if (mappingTarget.getChecklistItems() != null) {
/* 743 */       Set<ChecklistItem> set = checklistItemDTOListToChecklistItemSet(checklistDTO.getChecklistItems());
/* 744 */       if (set != null) {
/* 745 */         mappingTarget.getChecklistItems().clear();
/* 746 */         mappingTarget.getChecklistItems().addAll(set);
/*     */       } 
/*     */     } else {
/*     */       
/* 750 */       Set<ChecklistItem> set = checklistItemDTOListToChecklistItemSet(checklistDTO.getChecklistItems());
/* 751 */       if (set != null) {
/* 752 */         mappingTarget.checklistItems(set);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void certificateDTOToCertificate1(CertificateDTO certificateDTO, Certificate mappingTarget) {
/* 758 */     if (certificateDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 762 */     if (certificateDTO.getCreatedBy() != null) {
/* 763 */       mappingTarget.createdBy(certificateDTO.getCreatedBy());
/*     */     }
/* 765 */     if (certificateDTO.getCreatedDate() != null) {
/* 766 */       mappingTarget.createdDate(certificateDTO.getCreatedDate());
/*     */     }
/* 768 */     if (certificateDTO.getLastModifiedBy() != null) {
/* 769 */       mappingTarget.lastModifiedBy(certificateDTO.getLastModifiedBy());
/*     */     }
/* 771 */     if (certificateDTO.getLastModifiedDate() != null) {
/* 772 */       mappingTarget.lastModifiedDate(certificateDTO.getLastModifiedDate());
/*     */     }
/* 774 */     if (certificateDTO.getId() != null) {
/* 775 */       mappingTarget.setId(certificateDTO.getId());
/*     */     }
/* 777 */     if (certificateDTO.getStatus() != null) {
/* 778 */       mappingTarget.setStatus(certificateDTO.getStatus());
/*     */     }
/* 780 */     if (certificateDTO.getStartDate() != null) {
/* 781 */       mappingTarget.setStartDate(certificateDTO.getStartDate());
/*     */     }
/* 783 */     if (certificateDTO.getExpectedEndDate() != null) {
/* 784 */       mappingTarget.setExpectedEndDate(certificateDTO.getExpectedEndDate());
/*     */     }
/* 786 */     if (certificateDTO.getEndDate() != null) {
/* 787 */       mappingTarget.setEndDate(certificateDTO.getEndDate());
/*     */     }
/* 789 */     if (certificateDTO.getValidated() != null) {
/* 790 */       mappingTarget.setValidated(certificateDTO.getValidated());
/*     */     }
/* 792 */     if (certificateDTO.getIsRecycling() != null) {
/* 793 */       mappingTarget.setIsRecycling(certificateDTO.getIsRecycling());
/*     */     }
/* 795 */     if (certificateDTO.getAssignment() != null) {
/* 796 */       mappingTarget.assignment(toEntity(certificateDTO.getAssignment()));
/*     */     }
/* 798 */     if (certificateDTO.getLevel() != null) {
/* 799 */       if (mappingTarget.getLevel() == null) {
/* 800 */         mappingTarget.level(new CertificationLevel());
/*     */       }
/* 802 */       certificationLevelDTOToCertificationLevel1(certificateDTO.getLevel(), mappingTarget.getLevel());
/*     */     } 
/* 804 */     if (certificateDTO.getChecklist() != null) {
/* 805 */       if (mappingTarget.getChecklist() == null) {
/* 806 */         mappingTarget.checklist(new Checklist());
/*     */       }
/* 808 */       checklistDTOToChecklist1(certificateDTO.getChecklist(), mappingTarget.getChecklist());
/*     */     } 
/*     */   }
/*     */   
/*     */   protected EmployeeTitleDTO employeeTitleToEmployeeTitleDTO(EmployeeTitle employeeTitle) {
/* 813 */     if (employeeTitle == null) {
/* 814 */       return null;
/*     */     }
/*     */     
/* 817 */     EmployeeTitleDTO employeeTitleDTO = new EmployeeTitleDTO();
/*     */     
/* 819 */     employeeTitleDTO.setId(employeeTitle.getId());
/* 820 */     employeeTitleDTO.setName(employeeTitle.getName());
/* 821 */     employeeTitleDTO.setDescription(employeeTitle.getDescription());
/* 822 */     employeeTitleDTO.setCanSupervise(employeeTitle.getCanSupervise());
/* 823 */     employeeTitleDTO.setCreatedBy(employeeTitle.getCreatedBy());
/* 824 */     employeeTitleDTO.setCreatedDate(employeeTitle.getCreatedDate());
/* 825 */     employeeTitleDTO.setLastModifiedBy(employeeTitle.getLastModifiedBy());
/* 826 */     employeeTitleDTO.setLastModifiedDate(employeeTitle.getLastModifiedDate());
/*     */     
/* 828 */     return employeeTitleDTO;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\AssignmentMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */