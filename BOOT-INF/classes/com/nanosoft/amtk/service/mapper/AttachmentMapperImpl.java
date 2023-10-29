/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Attachment;
/*     */ import com.nanosoft.amtk.domain.Content;
/*     */ import com.nanosoft.amtk.domain.Employee;
/*     */ import com.nanosoft.amtk.domain.EmployeeTitle;
/*     */ import com.nanosoft.amtk.domain.Team;
/*     */ import com.nanosoft.amtk.service.dto.AttachmentDTO;
/*     */ import com.nanosoft.amtk.service.dto.ContentDTO;
/*     */ import com.nanosoft.amtk.service.dto.EmployeeDTO;
/*     */ import com.nanosoft.amtk.service.dto.EmployeeTitleDTO;
/*     */ import com.nanosoft.amtk.service.dto.TeamDTO;
/*     */ import com.nanosoft.amtk.service.mapper.AttachmentMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Component
/*     */ public class AttachmentMapperImpl
/*     */   implements AttachmentMapper
/*     */ {
/*     */   public Attachment toEntity(AttachmentDTO dto) {
/*  29 */     if (dto == null) {
/*  30 */       return null;
/*     */     }
/*     */     
/*  33 */     Attachment attachment = new Attachment();
/*     */     
/*  35 */     attachment.createdBy(dto.getCreatedBy());
/*  36 */     attachment.createdDate(dto.getCreatedDate());
/*  37 */     attachment.lastModifiedBy(dto.getLastModifiedBy());
/*  38 */     attachment.lastModifiedDate(dto.getLastModifiedDate());
/*  39 */     attachment.setId(dto.getId());
/*  40 */     attachment.setTitle(dto.getTitle());
/*  41 */     attachment.setFileName(dto.getFileName());
/*  42 */     attachment.setFileSize(dto.getFileSize());
/*  43 */     attachment.setFileType(dto.getFileType());
/*  44 */     attachment.setDescription(dto.getDescription());
/*  45 */     attachment.content(contentDTOToContent(dto.getContent()));
/*  46 */     attachment.employee(employeeDTOToEmployee(dto.getEmployee()));
/*     */     
/*  48 */     return attachment;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Attachment> toEntity(List<AttachmentDTO> dtoList) {
/*  53 */     if (dtoList == null) {
/*  54 */       return null;
/*     */     }
/*     */     
/*  57 */     List<Attachment> list = new ArrayList<>(dtoList.size());
/*  58 */     for (AttachmentDTO attachmentDTO : dtoList) {
/*  59 */       list.add(toEntity(attachmentDTO));
/*     */     }
/*     */     
/*  62 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<AttachmentDTO> toDto(List<Attachment> entityList) {
/*  67 */     if (entityList == null) {
/*  68 */       return null;
/*     */     }
/*     */     
/*  71 */     List<AttachmentDTO> list = new ArrayList<>(entityList.size());
/*  72 */     for (Attachment attachment : entityList) {
/*  73 */       list.add(toDto(attachment));
/*     */     }
/*     */     
/*  76 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(Attachment entity, AttachmentDTO dto) {
/*  81 */     if (dto == null) {
/*     */       return;
/*     */     }
/*     */     
/*  85 */     if (dto.getCreatedBy() != null) {
/*  86 */       entity.createdBy(dto.getCreatedBy());
/*     */     }
/*  88 */     if (dto.getCreatedDate() != null) {
/*  89 */       entity.createdDate(dto.getCreatedDate());
/*     */     }
/*  91 */     if (dto.getLastModifiedBy() != null) {
/*  92 */       entity.lastModifiedBy(dto.getLastModifiedBy());
/*     */     }
/*  94 */     if (dto.getLastModifiedDate() != null) {
/*  95 */       entity.lastModifiedDate(dto.getLastModifiedDate());
/*     */     }
/*  97 */     if (dto.getId() != null) {
/*  98 */       entity.setId(dto.getId());
/*     */     }
/* 100 */     if (dto.getTitle() != null) {
/* 101 */       entity.setTitle(dto.getTitle());
/*     */     }
/* 103 */     if (dto.getFileName() != null) {
/* 104 */       entity.setFileName(dto.getFileName());
/*     */     }
/* 106 */     if (dto.getFileSize() != null) {
/* 107 */       entity.setFileSize(dto.getFileSize());
/*     */     }
/* 109 */     if (dto.getFileType() != null) {
/* 110 */       entity.setFileType(dto.getFileType());
/*     */     }
/* 112 */     if (dto.getDescription() != null) {
/* 113 */       entity.setDescription(dto.getDescription());
/*     */     }
/* 115 */     if (dto.getContent() != null) {
/* 116 */       if (entity.getContent() == null) {
/* 117 */         entity.content(new Content());
/*     */       }
/* 119 */       contentDTOToContent1(dto.getContent(), entity.getContent());
/*     */     } 
/* 121 */     if (dto.getEmployee() != null) {
/* 122 */       if (entity.getEmployee() == null) {
/* 123 */         entity.employee(new Employee());
/*     */       }
/* 125 */       employeeDTOToEmployee1(dto.getEmployee(), entity.getEmployee());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public AttachmentDTO toDto(Attachment s) {
/* 131 */     if (s == null) {
/* 132 */       return null;
/*     */     }
/*     */     
/* 135 */     AttachmentDTO attachmentDTO = new AttachmentDTO();
/*     */     
/* 137 */     attachmentDTO.setContentId(sContentId(s));
/* 138 */     attachmentDTO.setEmployee(employeeToEmployeeDTO(s.getEmployee()));
/* 139 */     attachmentDTO.setId(s.getId());
/* 140 */     attachmentDTO.setTitle(s.getTitle());
/* 141 */     attachmentDTO.setFileName(s.getFileName());
/* 142 */     attachmentDTO.setFileSize(s.getFileSize());
/* 143 */     attachmentDTO.setFileType(s.getFileType());
/* 144 */     attachmentDTO.setDescription(s.getDescription());
/* 145 */     attachmentDTO.setCreatedBy(s.getCreatedBy());
/* 146 */     attachmentDTO.setCreatedDate(s.getCreatedDate());
/* 147 */     attachmentDTO.setLastModifiedBy(s.getLastModifiedBy());
/* 148 */     attachmentDTO.setLastModifiedDate(s.getLastModifiedDate());
/*     */     
/* 150 */     return attachmentDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public ContentDTO toDtoContentId(Content content) {
/* 155 */     if (content == null) {
/* 156 */       return null;
/*     */     }
/*     */     
/* 159 */     ContentDTO contentDTO = new ContentDTO();
/*     */     
/* 161 */     contentDTO.setId(content.getId());
/*     */     
/* 163 */     return contentDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public EmployeeDTO toDtoEmployeeId(Employee employee) {
/* 168 */     if (employee == null) {
/* 169 */       return null;
/*     */     }
/*     */     
/* 172 */     EmployeeDTO employeeDTO = new EmployeeDTO();
/*     */     
/* 174 */     employeeDTO.setId(employee.getId());
/*     */     
/* 176 */     return employeeDTO;
/*     */   }
/*     */   
/*     */   protected Content contentDTOToContent(ContentDTO contentDTO) {
/* 180 */     if (contentDTO == null) {
/* 181 */       return null;
/*     */     }
/*     */     
/* 184 */     Content content = new Content();
/*     */     
/* 186 */     content.createdBy(contentDTO.getCreatedBy());
/* 187 */     content.createdDate(contentDTO.getCreatedDate());
/* 188 */     content.lastModifiedBy(contentDTO.getLastModifiedBy());
/* 189 */     content.lastModifiedDate(contentDTO.getLastModifiedDate());
/* 190 */     content.setId(contentDTO.getId());
/* 191 */     byte[] data = contentDTO.getData();
/* 192 */     if (data != null) {
/* 193 */       content.setData(Arrays.copyOf(data, data.length));
/*     */     }
/* 195 */     content.setDataContentType(contentDTO.getDataContentType());
/*     */     
/* 197 */     return content;
/*     */   }
/*     */   
/*     */   protected EmployeeTitle employeeTitleDTOToEmployeeTitle(EmployeeTitleDTO employeeTitleDTO) {
/* 201 */     if (employeeTitleDTO == null) {
/* 202 */       return null;
/*     */     }
/*     */     
/* 205 */     EmployeeTitle employeeTitle = new EmployeeTitle();
/*     */     
/* 207 */     employeeTitle.createdBy(employeeTitleDTO.getCreatedBy());
/* 208 */     employeeTitle.createdDate(employeeTitleDTO.getCreatedDate());
/* 209 */     employeeTitle.lastModifiedBy(employeeTitleDTO.getLastModifiedBy());
/* 210 */     employeeTitle.lastModifiedDate(employeeTitleDTO.getLastModifiedDate());
/* 211 */     employeeTitle.setId(employeeTitleDTO.getId());
/* 212 */     employeeTitle.setName(employeeTitleDTO.getName());
/* 213 */     employeeTitle.setDescription(employeeTitleDTO.getDescription());
/* 214 */     employeeTitle.setCanSupervise(employeeTitleDTO.getCanSupervise());
/*     */     
/* 216 */     return employeeTitle;
/*     */   }
/*     */   
/*     */   protected Team teamDTOToTeam(TeamDTO teamDTO) {
/* 220 */     if (teamDTO == null) {
/* 221 */       return null;
/*     */     }
/*     */     
/* 224 */     Team team = new Team();
/*     */     
/* 226 */     team.createdBy(teamDTO.getCreatedBy());
/* 227 */     team.createdDate(teamDTO.getCreatedDate());
/* 228 */     team.lastModifiedBy(teamDTO.getLastModifiedBy());
/* 229 */     team.lastModifiedDate(teamDTO.getLastModifiedDate());
/* 230 */     team.setId(teamDTO.getId());
/* 231 */     team.setName(teamDTO.getName());
/* 232 */     team.setDescription(teamDTO.getDescription());
/* 233 */     team.supervisor(employeeDTOToEmployee(teamDTO.getSupervisor()));
/*     */     
/* 235 */     return team;
/*     */   }
/*     */   
/*     */   protected Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
/* 239 */     if (employeeDTO == null) {
/* 240 */       return null;
/*     */     }
/*     */     
/* 243 */     Employee employee = new Employee();
/*     */     
/* 245 */     employee.createdBy(employeeDTO.getCreatedBy());
/* 246 */     employee.createdDate(employeeDTO.getCreatedDate());
/* 247 */     employee.lastModifiedBy(employeeDTO.getLastModifiedBy());
/* 248 */     employee.lastModifiedDate(employeeDTO.getLastModifiedDate());
/* 249 */     employee.setId(employeeDTO.getId());
/* 250 */     employee.setFirstName(employeeDTO.getFirstName());
/* 251 */     employee.setLastName(employeeDTO.getLastName());
/* 252 */     employee.setThirdName(employeeDTO.getThirdName());
/* 253 */     employee.setGender(employeeDTO.getGender());
/* 254 */     employee.setIdNumber(employeeDTO.getIdNumber());
/* 255 */     employee.setBirthday(employeeDTO.getBirthday());
/* 256 */     employee.setJoiningDate(employeeDTO.getJoiningDate());
/* 257 */     employee.setRelievingDate(employeeDTO.getRelievingDate());
/* 258 */     employee.setEmployeeNumber(employeeDTO.getEmployeeNumber());
/* 259 */     employee.title(employeeTitleDTOToEmployeeTitle(employeeDTO.getTitle()));
/* 260 */     employee.team(teamDTOToTeam(employeeDTO.getTeam()));
/*     */     
/* 262 */     return employee;
/*     */   }
/*     */   
/*     */   protected void contentDTOToContent1(ContentDTO contentDTO, Content mappingTarget) {
/* 266 */     if (contentDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 270 */     if (contentDTO.getCreatedBy() != null) {
/* 271 */       mappingTarget.createdBy(contentDTO.getCreatedBy());
/*     */     }
/* 273 */     if (contentDTO.getCreatedDate() != null) {
/* 274 */       mappingTarget.createdDate(contentDTO.getCreatedDate());
/*     */     }
/* 276 */     if (contentDTO.getLastModifiedBy() != null) {
/* 277 */       mappingTarget.lastModifiedBy(contentDTO.getLastModifiedBy());
/*     */     }
/* 279 */     if (contentDTO.getLastModifiedDate() != null) {
/* 280 */       mappingTarget.lastModifiedDate(contentDTO.getLastModifiedDate());
/*     */     }
/* 282 */     if (contentDTO.getId() != null) {
/* 283 */       mappingTarget.setId(contentDTO.getId());
/*     */     }
/* 285 */     byte[] data = contentDTO.getData();
/* 286 */     if (data != null) {
/* 287 */       mappingTarget.setData(Arrays.copyOf(data, data.length));
/*     */     }
/* 289 */     if (contentDTO.getDataContentType() != null) {
/* 290 */       mappingTarget.setDataContentType(contentDTO.getDataContentType());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void employeeTitleDTOToEmployeeTitle1(EmployeeTitleDTO employeeTitleDTO, EmployeeTitle mappingTarget) {
/* 295 */     if (employeeTitleDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 299 */     if (employeeTitleDTO.getCreatedBy() != null) {
/* 300 */       mappingTarget.createdBy(employeeTitleDTO.getCreatedBy());
/*     */     }
/* 302 */     if (employeeTitleDTO.getCreatedDate() != null) {
/* 303 */       mappingTarget.createdDate(employeeTitleDTO.getCreatedDate());
/*     */     }
/* 305 */     if (employeeTitleDTO.getLastModifiedBy() != null) {
/* 306 */       mappingTarget.lastModifiedBy(employeeTitleDTO.getLastModifiedBy());
/*     */     }
/* 308 */     if (employeeTitleDTO.getLastModifiedDate() != null) {
/* 309 */       mappingTarget.lastModifiedDate(employeeTitleDTO.getLastModifiedDate());
/*     */     }
/* 311 */     if (employeeTitleDTO.getId() != null) {
/* 312 */       mappingTarget.setId(employeeTitleDTO.getId());
/*     */     }
/* 314 */     if (employeeTitleDTO.getName() != null) {
/* 315 */       mappingTarget.setName(employeeTitleDTO.getName());
/*     */     }
/* 317 */     if (employeeTitleDTO.getDescription() != null) {
/* 318 */       mappingTarget.setDescription(employeeTitleDTO.getDescription());
/*     */     }
/* 320 */     if (employeeTitleDTO.getCanSupervise() != null) {
/* 321 */       mappingTarget.setCanSupervise(employeeTitleDTO.getCanSupervise());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void teamDTOToTeam1(TeamDTO teamDTO, Team mappingTarget) {
/* 326 */     if (teamDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 330 */     if (teamDTO.getCreatedBy() != null) {
/* 331 */       mappingTarget.createdBy(teamDTO.getCreatedBy());
/*     */     }
/* 333 */     if (teamDTO.getCreatedDate() != null) {
/* 334 */       mappingTarget.createdDate(teamDTO.getCreatedDate());
/*     */     }
/* 336 */     if (teamDTO.getLastModifiedBy() != null) {
/* 337 */       mappingTarget.lastModifiedBy(teamDTO.getLastModifiedBy());
/*     */     }
/* 339 */     if (teamDTO.getLastModifiedDate() != null) {
/* 340 */       mappingTarget.lastModifiedDate(teamDTO.getLastModifiedDate());
/*     */     }
/* 342 */     if (teamDTO.getId() != null) {
/* 343 */       mappingTarget.setId(teamDTO.getId());
/*     */     }
/* 345 */     if (teamDTO.getName() != null) {
/* 346 */       mappingTarget.setName(teamDTO.getName());
/*     */     }
/* 348 */     if (teamDTO.getDescription() != null) {
/* 349 */       mappingTarget.setDescription(teamDTO.getDescription());
/*     */     }
/* 351 */     if (teamDTO.getSupervisor() != null) {
/* 352 */       if (mappingTarget.getSupervisor() == null) {
/* 353 */         mappingTarget.supervisor(new Employee());
/*     */       }
/* 355 */       employeeDTOToEmployee1(teamDTO.getSupervisor(), mappingTarget.getSupervisor());
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void employeeDTOToEmployee1(EmployeeDTO employeeDTO, Employee mappingTarget) {
/* 360 */     if (employeeDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 364 */     if (employeeDTO.getCreatedBy() != null) {
/* 365 */       mappingTarget.createdBy(employeeDTO.getCreatedBy());
/*     */     }
/* 367 */     if (employeeDTO.getCreatedDate() != null) {
/* 368 */       mappingTarget.createdDate(employeeDTO.getCreatedDate());
/*     */     }
/* 370 */     if (employeeDTO.getLastModifiedBy() != null) {
/* 371 */       mappingTarget.lastModifiedBy(employeeDTO.getLastModifiedBy());
/*     */     }
/* 373 */     if (employeeDTO.getLastModifiedDate() != null) {
/* 374 */       mappingTarget.lastModifiedDate(employeeDTO.getLastModifiedDate());
/*     */     }
/* 376 */     if (employeeDTO.getId() != null) {
/* 377 */       mappingTarget.setId(employeeDTO.getId());
/*     */     }
/* 379 */     if (employeeDTO.getFirstName() != null) {
/* 380 */       mappingTarget.setFirstName(employeeDTO.getFirstName());
/*     */     }
/* 382 */     if (employeeDTO.getLastName() != null) {
/* 383 */       mappingTarget.setLastName(employeeDTO.getLastName());
/*     */     }
/* 385 */     if (employeeDTO.getThirdName() != null) {
/* 386 */       mappingTarget.setThirdName(employeeDTO.getThirdName());
/*     */     }
/* 388 */     if (employeeDTO.getGender() != null) {
/* 389 */       mappingTarget.setGender(employeeDTO.getGender());
/*     */     }
/* 391 */     if (employeeDTO.getIdNumber() != null) {
/* 392 */       mappingTarget.setIdNumber(employeeDTO.getIdNumber());
/*     */     }
/* 394 */     if (employeeDTO.getBirthday() != null) {
/* 395 */       mappingTarget.setBirthday(employeeDTO.getBirthday());
/*     */     }
/* 397 */     if (employeeDTO.getJoiningDate() != null) {
/* 398 */       mappingTarget.setJoiningDate(employeeDTO.getJoiningDate());
/*     */     }
/* 400 */     if (employeeDTO.getRelievingDate() != null) {
/* 401 */       mappingTarget.setRelievingDate(employeeDTO.getRelievingDate());
/*     */     }
/* 403 */     if (employeeDTO.getEmployeeNumber() != null) {
/* 404 */       mappingTarget.setEmployeeNumber(employeeDTO.getEmployeeNumber());
/*     */     }
/* 406 */     if (employeeDTO.getTitle() != null) {
/* 407 */       if (mappingTarget.getTitle() == null) {
/* 408 */         mappingTarget.title(new EmployeeTitle());
/*     */       }
/* 410 */       employeeTitleDTOToEmployeeTitle1(employeeDTO.getTitle(), mappingTarget.getTitle());
/*     */     } 
/* 412 */     if (employeeDTO.getTeam() != null) {
/* 413 */       if (mappingTarget.getTeam() == null) {
/* 414 */         mappingTarget.team(new Team());
/*     */       }
/* 416 */       teamDTOToTeam1(employeeDTO.getTeam(), mappingTarget.getTeam());
/*     */     } 
/*     */   }
/*     */   
/*     */   private Long sContentId(Attachment attachment) {
/* 421 */     if (attachment == null) {
/* 422 */       return null;
/*     */     }
/* 424 */     Content content = attachment.getContent();
/* 425 */     if (content == null) {
/* 426 */       return null;
/*     */     }
/* 428 */     Long id = content.getId();
/* 429 */     if (id == null) {
/* 430 */       return null;
/*     */     }
/* 432 */     return id;
/*     */   }
/*     */   
/*     */   protected EmployeeTitleDTO employeeTitleToEmployeeTitleDTO(EmployeeTitle employeeTitle) {
/* 436 */     if (employeeTitle == null) {
/* 437 */       return null;
/*     */     }
/*     */     
/* 440 */     EmployeeTitleDTO employeeTitleDTO = new EmployeeTitleDTO();
/*     */     
/* 442 */     employeeTitleDTO.setId(employeeTitle.getId());
/* 443 */     employeeTitleDTO.setName(employeeTitle.getName());
/* 444 */     employeeTitleDTO.setDescription(employeeTitle.getDescription());
/* 445 */     employeeTitleDTO.setCanSupervise(employeeTitle.getCanSupervise());
/* 446 */     employeeTitleDTO.setCreatedBy(employeeTitle.getCreatedBy());
/* 447 */     employeeTitleDTO.setCreatedDate(employeeTitle.getCreatedDate());
/* 448 */     employeeTitleDTO.setLastModifiedBy(employeeTitle.getLastModifiedBy());
/* 449 */     employeeTitleDTO.setLastModifiedDate(employeeTitle.getLastModifiedDate());
/*     */     
/* 451 */     return employeeTitleDTO;
/*     */   }
/*     */   
/*     */   protected TeamDTO teamToTeamDTO(Team team) {
/* 455 */     if (team == null) {
/* 456 */       return null;
/*     */     }
/*     */     
/* 459 */     TeamDTO teamDTO = new TeamDTO();
/*     */     
/* 461 */     teamDTO.setId(team.getId());
/* 462 */     teamDTO.setName(team.getName());
/* 463 */     teamDTO.setDescription(team.getDescription());
/* 464 */     teamDTO.setCreatedBy(team.getCreatedBy());
/* 465 */     teamDTO.setCreatedDate(team.getCreatedDate());
/* 466 */     teamDTO.setLastModifiedBy(team.getLastModifiedBy());
/* 467 */     teamDTO.setLastModifiedDate(team.getLastModifiedDate());
/* 468 */     teamDTO.setSupervisor(employeeToEmployeeDTO(team.getSupervisor()));
/*     */     
/* 470 */     return teamDTO;
/*     */   }
/*     */   
/*     */   protected EmployeeDTO employeeToEmployeeDTO(Employee employee) {
/* 474 */     if (employee == null) {
/* 475 */       return null;
/*     */     }
/*     */     
/* 478 */     EmployeeDTO employeeDTO = new EmployeeDTO();
/*     */     
/* 480 */     employeeDTO.setId(employee.getId());
/* 481 */     employeeDTO.setFirstName(employee.getFirstName());
/* 482 */     employeeDTO.setLastName(employee.getLastName());
/* 483 */     employeeDTO.setThirdName(employee.getThirdName());
/* 484 */     employeeDTO.setGender(employee.getGender());
/* 485 */     employeeDTO.setIdNumber(employee.getIdNumber());
/* 486 */     employeeDTO.setBirthday(employee.getBirthday());
/* 487 */     employeeDTO.setJoiningDate(employee.getJoiningDate());
/* 488 */     employeeDTO.setRelievingDate(employee.getRelievingDate());
/* 489 */     employeeDTO.setEmployeeNumber(employee.getEmployeeNumber());
/* 490 */     employeeDTO.setCreatedBy(employee.getCreatedBy());
/* 491 */     employeeDTO.setCreatedDate(employee.getCreatedDate());
/* 492 */     employeeDTO.setLastModifiedBy(employee.getLastModifiedBy());
/* 493 */     employeeDTO.setLastModifiedDate(employee.getLastModifiedDate());
/* 494 */     employeeDTO.setTitle(employeeTitleToEmployeeTitleDTO(employee.getTitle()));
/* 495 */     employeeDTO.setTeam(teamToTeamDTO(employee.getTeam()));
/*     */     
/* 497 */     return employeeDTO;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\AttachmentMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */