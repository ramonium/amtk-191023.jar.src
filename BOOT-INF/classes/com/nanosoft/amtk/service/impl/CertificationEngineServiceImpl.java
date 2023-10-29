/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*     */ import com.fasterxml.jackson.databind.JsonNode;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import com.fasterxml.jackson.databind.node.ArrayNode;
/*     */ import com.fasterxml.jackson.databind.node.ObjectNode;
/*     */ import com.nanosoft.amtk.domain.Area;
/*     */ import com.nanosoft.amtk.domain.Assignment;
/*     */ import com.nanosoft.amtk.domain.Certificate;
/*     */ import com.nanosoft.amtk.domain.CertificationLevel;
/*     */ import com.nanosoft.amtk.domain.Checklist;
/*     */ import com.nanosoft.amtk.domain.ChecklistItem;
/*     */ import com.nanosoft.amtk.domain.ChecklistModel;
/*     */ import com.nanosoft.amtk.domain.ChecklistModelItem;
/*     */ import com.nanosoft.amtk.domain.Employee;
/*     */ import com.nanosoft.amtk.domain.Project;
/*     */ import com.nanosoft.amtk.domain.SkillsMatrix;
/*     */ import com.nanosoft.amtk.domain.Workstation;
/*     */ import com.nanosoft.amtk.domain.enumeration.CertificationStatus;
/*     */ import com.nanosoft.amtk.domain.enumeration.ChecklistStatus;
/*     */ import com.nanosoft.amtk.repository.AssignmentRepository;
/*     */ import com.nanosoft.amtk.repository.CertificateRepository;
/*     */ import com.nanosoft.amtk.repository.CertificationLevelRepository;
/*     */ import com.nanosoft.amtk.repository.ChecklistRepository;
/*     */ import com.nanosoft.amtk.repository.ProjectRepository;
/*     */ import com.nanosoft.amtk.repository.SkillsMatrixRepository;
/*     */ import java.time.Instant;
/*     */ import java.time.Period;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ 
/*     */ @Service
/*     */ @Transactional
/*     */ public class CertificationEngineServiceImpl implements CertificationEngineService {
/*  37 */   private final Logger log = LoggerFactory.getLogger(CertificationEngineService.class);
/*     */ 
/*     */   
/*     */   private final CertificateRepository certificateRepository;
/*     */ 
/*     */   
/*     */   private final ChecklistRepository checklistRepository;
/*     */   
/*     */   private final CertificationLevelRepository certificateLevelRepository;
/*     */   
/*     */   private final AssignmentRepository assignmentRepository;
/*     */   
/*     */   private final ProjectRepository projectRepository;
/*     */   
/*     */   private final SkillsMatrixRepository skillsMatrixRepository;
/*     */   
/*     */   private final ObjectMapper objectMapper;
/*     */ 
/*     */   
/*     */   public CertificationEngineServiceImpl(CertificateRepository certificateRepository, AssignmentRepository assignmentRepository, CertificationLevelRepository certificateLevelRepository, ChecklistRepository checklistRepository, ProjectRepository projectRepository, SkillsMatrixRepository skillsMatrixRepository, ObjectMapper objectMapper) {
/*  57 */     this.certificateRepository = certificateRepository;
/*  58 */     this.assignmentRepository = assignmentRepository;
/*  59 */     this.certificateLevelRepository = certificateLevelRepository;
/*  60 */     this.checklistRepository = checklistRepository;
/*  61 */     this.projectRepository = projectRepository;
/*  62 */     this.skillsMatrixRepository = skillsMatrixRepository;
/*  63 */     this.objectMapper = objectMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Scheduled(cron = "0 0 3 * * *")
/*     */   public void runEngineSequence() {
/*  70 */     runCertificationEngine();
/*  71 */     runSkillsMatrixEngine();
/*     */   }
/*     */ 
/*     */   
/*     */   public void runCertificationEngine() {
/*  76 */     List<Assignment> assignments = this.assignmentRepository.findAll();
/*     */     
/*  78 */     for (Assignment assignment : assignments) {
/*     */       try {
/*  80 */         runEngineForAssignment(assignment);
/*  81 */       } catch (Exception exception) {
/*  82 */         this.log.error(exception.getMessage());
/*  83 */         this.log.error(ExceptionUtils.getStackTrace(exception));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void runSkillsMatrixEngine() {
/*  90 */     List<Project> projects = this.projectRepository.findAll();
/*  91 */     for (Project project : projects) {
/*  92 */       runSkillsMatrixEngine(project);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void runSkillsMatrixEngine(Long projectId) {
/*  98 */     this.projectRepository.findById(projectId).ifPresent(this::runSkillsMatrixEngine);
/*     */   }
/*     */   
/*     */   public void runSkillsMatrixEngine(Project project) {
/* 102 */     ObjectNode projectNode = this.objectMapper.createObjectNode();
/* 103 */     ArrayNode workstationsNode = this.objectMapper.createArrayNode();
/* 104 */     Map<Employee, Map<Workstation, Certificate>> data = new HashMap<>();
/* 105 */     Map<Workstation, Certificate> initMap = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 110 */     List<Area> areas = (List<Area>)project.getAreas().stream().sorted(Comparator.comparingInt(Area::getOrderNumber)).collect(Collectors.toList());
/* 111 */     for (Area area : areas) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 116 */       List<Workstation> workstations = (List<Workstation>)area.getWorkstations().stream().sorted(Comparator.comparingInt(Workstation::getOrderNumber)).collect(Collectors.toList());
/* 117 */       for (Workstation workstation : workstations) {
/* 118 */         workstationsNode.add(this.objectMapper.valueToTree(workstation));
/* 119 */         for (Assignment assignment : workstation.getAssignments()) {
/* 120 */           if (!data.containsKey(assignment.getEmployee())) {
/* 121 */             data.put(assignment.getEmployee(), new HashMap<>(initMap));
/*     */           }
/*     */           
/* 124 */           ((Map<Workstation, Certificate>)data.get(assignment.getEmployee())).put(workstation, assignment.getCurrentCertificate());
/*     */         } 
/*     */         
/* 127 */         if (!initMap.containsKey(workstation)) {
/* 128 */           initMap.put(workstation, null);
/*     */         }
/*     */         
/* 131 */         for (Map.Entry<Employee, Map<Workstation, Certificate>> employeeEntry : data.entrySet()) {
/* 132 */           if (!((Map)employeeEntry.getValue()).containsKey(workstation)) {
/* 133 */             ((Map)employeeEntry.getValue()).put(workstation, null);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 139 */     projectNode.putIfAbsent("workstations", (JsonNode)workstationsNode);
/*     */     
/* 141 */     ArrayNode employeeArray = this.objectMapper.createArrayNode();
/* 142 */     for (Map.Entry<Employee, Map<Workstation, Certificate>> employeeEntry : data.entrySet()) {
/* 143 */       Employee employee = employeeEntry.getKey();
/* 144 */       ObjectNode employeeNode = this.objectMapper.createObjectNode();
/* 145 */       employeeNode.putIfAbsent("employee", this.objectMapper.valueToTree(employee));
/*     */       
/* 147 */       ArrayNode certificateArray = this.objectMapper.createArrayNode();
/* 148 */       for (Map.Entry<Workstation, Certificate> certificateEntry : (Iterable<Map.Entry<Workstation, Certificate>>)((Map)employeeEntry.getValue()).entrySet()) {
/* 149 */         Workstation workstation = certificateEntry.getKey();
/* 150 */         Certificate certificate = certificateEntry.getValue();
/*     */         
/* 152 */         ObjectNode certificateEntryNode = this.objectMapper.createObjectNode();
/* 153 */         certificateEntryNode.putIfAbsent("workstation", this.objectMapper.valueToTree((new Workstation()).id(workstation.getId())));
/* 154 */         certificateEntryNode.putIfAbsent("certificate", this.objectMapper.valueToTree(certificate));
/*     */         
/* 156 */         certificateArray.add((JsonNode)certificateEntryNode);
/*     */       } 
/*     */       
/* 159 */       employeeNode.putIfAbsent("certificates", (JsonNode)certificateArray);
/* 160 */       employeeArray.add((JsonNode)employeeNode);
/*     */     } 
/* 162 */     projectNode.putIfAbsent("certificates", (JsonNode)employeeArray);
/*     */     
/* 164 */     SkillsMatrix skillsMatrix = (new SkillsMatrix()).data(projectNode.toString().getBytes()).dataContentType("JSON").project(project);
/*     */     
/* 166 */     this.skillsMatrixRepository.save(skillsMatrix);
/*     */     
/* 168 */     project.setSkillsMatrix(skillsMatrix);
/* 169 */     this.projectRepository.save(project);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void runEngineForAssignment(Assignment assignment) {
/* 175 */     Comparator<CertificationLevel> compareByOrder = Comparator.comparing(CertificationLevel::getOrderNumber).thenComparing(CertificationLevel::getId);
/*     */     
/* 177 */     Workstation workstation = assignment.getWorkstation();
/* 178 */     Process process = workstation.getProcess();
/* 179 */     List<CertificationLevel> certificationLevels = this.certificateLevelRepository.findAllByProcess(process);
/*     */     
/* 181 */     if (assignment.getAssignmentEnd() == null || assignment.getAssignmentEnd().isAfter(Instant.now())) {
/*     */       
/* 183 */       if (assignment.getCertificates().isEmpty()) {
/*     */ 
/*     */         
/* 186 */         Optional<CertificationLevel> firstCertificationLevel = certificationLevels.stream().min(compareByOrder);
/*     */         
/* 188 */         createCertificate(assignment, firstCertificationLevel);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 194 */       Optional<Certificate> lastCertificateOpt = assignment.getCertificates().stream().max(Comparator.comparingLong(Certificate::getId));
/*     */       
/* 196 */       if (lastCertificateOpt.isPresent()) {
/* 197 */         Certificate lastCertificate = lastCertificateOpt.get();
/*     */         
/* 199 */         if (lastCertificate.getStatus() == CertificationStatus.InProgress && 
/* 200 */           Instant.now().isAfter(lastCertificate.getExpectedEndDate())) {
/* 201 */           if (lastCertificate.getLevel().getChecklistModel() != null) {
/* 202 */             lastCertificate.setStatus(CertificationStatus.PendingChecklist);
/* 203 */             ChecklistModel checklistModel = lastCertificate.getLevel().getChecklistModel();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 211 */             Checklist checklist = (new Checklist()).title(checklistModel.getTitle()).description(checklistModel.getDescription()).validatorRole(checklistModel.getValidator()).validatorRole2(checklistModel.getValidator2()).validatorRole3(checklistModel.getValidator3()).validatorRole4(checklistModel.getValidator4()).status(ChecklistStatus.PendingItemsValidation);
/* 212 */             for (ChecklistModelItem item : checklistModel.getChecklistModelItems()) {
/*     */ 
/*     */ 
/*     */               
/* 216 */               ChecklistItem checklistItem = (new ChecklistItem()).itemGroup(item.getItemGroup()).validatorRole(item.getValidator()).text(item.getText());
/* 217 */               checklist.addChecklistItem(checklistItem);
/*     */             } 
/* 219 */             checklist.checklistModel(checklistModel);
/* 220 */             this.checklistRepository.save(checklist);
/* 221 */             lastCertificate.setChecklist(checklist);
/*     */           } else {
/* 223 */             lastCertificate.setStatus(CertificationStatus.PendingValidation);
/*     */           } 
/* 225 */           this.certificateRepository.save(lastCertificate);
/*     */         } 
/*     */ 
/*     */         
/* 229 */         runEnginForCertificate(lastCertificate);
/*     */         
/* 231 */         if (lastCertificate.getStatus() == CertificationStatus.PendingValidation) {
/* 232 */           lastCertificate.setStatus(CertificationStatus.Completed);
/* 233 */           lastCertificate.setValidated(Boolean.valueOf(true));
/* 234 */           lastCertificate.setEndDate(Instant.now());
/* 235 */           this.certificateRepository.save(lastCertificate);
/* 236 */           assignment.currentCertificate(lastCertificate);
/* 237 */           this.assignmentRepository.save(assignment);
/*     */         } 
/*     */         
/* 240 */         if (lastCertificate.getStatus() == CertificationStatus.Completed) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 251 */           Optional<CertificationLevel> nextCertificationLevelOpt = certificationLevels.stream().sorted(compareByOrder).filter(cl -> (cl.getOrderNumber().intValue() > lastCertificate.getLevel().getOrderNumber().intValue() || (Objects.equals(cl.getOrderNumber(), lastCertificate.getLevel().getOrderNumber()) && cl.getId().longValue() > lastCertificate.getLevel().getId().longValue()))).findFirst();
/*     */           
/* 253 */           if (nextCertificationLevelOpt.isPresent()) {
/* 254 */             createCertificate(assignment, nextCertificationLevelOpt);
/*     */           } else {
/*     */             
/* 257 */             Period requalifiquationPeriod = assignment.getWorkstation().getArea().getProject().getQualificationAfterAsPeriod();
/* 258 */             if (requalifiquationPeriod != null && lastCertificate
/*     */               
/* 260 */               .getEndDate() != null && lastCertificate
/* 261 */               .getEndDate().isBefore(Instant.now().minus(requalifiquationPeriod))) {
/*     */               
/* 263 */               lastCertificate.setStatus(CertificationStatus.Recertify);
/* 264 */               this.certificateRepository.save(lastCertificate);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 269 */         if (lastCertificate.getStatus() == CertificationStatus.Failed) {
/* 270 */           createCertificate(assignment, lastCertificate.getLevel(), true);
/*     */         }
/*     */         
/* 273 */         if (lastCertificate.getStatus() == CertificationStatus.Recertify) {
/* 274 */           createCertificate(assignment, lastCertificate.getLevel(), true);
/*     */         }
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 280 */       Period uncertifyPeriod = assignment.getWorkstation().getArea().getProject().getDecertifyAfterAsPeriod();
/* 281 */       if (uncertifyPeriod != null && assignment.getAssignmentEnd().isBefore(Instant.now().minus(uncertifyPeriod))) {
/*     */         
/* 283 */         assignment
/* 284 */           .getCertificates()
/* 285 */           .forEach(certificate -> {
/*     */               certificate.setStatus(CertificationStatus.Expired);
/*     */               this.certificateRepository.save(certificate);
/*     */             });
/* 289 */         assignment.currentCertificate(null);
/* 290 */         this.assignmentRepository.save(assignment);
/*     */       } 
/*     */ 
/*     */       
/* 294 */       for (Certificate certificate : assignment.getCertificates()) {
/* 295 */         if (certificate.getStatus() != CertificationStatus.Canceled) {
/* 296 */           boolean shouldCancelCertification = (certificate.getStatus() == CertificationStatus.PendingValidation);
/* 297 */           int i = shouldCancelCertification | ((certificate.getStatus() == CertificationStatus.PendingChecklist) ? 1 : 0);
/* 298 */           i |= (certificate.getStatus() == CertificationStatus.InProgress) ? 1 : 0;
/*     */           
/* 300 */           if (i != 0) {
/* 301 */             certificate.setStatus(CertificationStatus.Canceled);
/* 302 */             this.certificateRepository.save(certificate);
/*     */           } 
/*     */           
/* 305 */           if (certificate.getChecklist() != null) {
/* 306 */             Checklist checklist = certificate.getChecklist();
/* 307 */             boolean shouldCancelChecklist = (checklist.getStatus() == ChecklistStatus.PendingItemsValidation);
/*     */             
/* 309 */             if (shouldCancelChecklist) {
/* 310 */               checklist.setStatus(ChecklistStatus.Canceled);
/* 311 */               this.checklistRepository.save(checklist);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void runEnginForCertificate(Certificate certificate) {
/* 320 */     if (certificate.getStatus() == CertificationStatus.PendingChecklist) {
/* 321 */       if (certificate.getChecklist().getStatus() == ChecklistStatus.PendingItemsValidation) {
/* 322 */         int i; boolean passed = true;
/* 323 */         boolean finished = true;
/* 324 */         for (ChecklistItem checklistItem : certificate.getChecklist().getChecklistItems()) {
/* 325 */           i = finished & ((checklistItem.getIsChecked() != null) ? 1 : 0);
/* 326 */           if (i != 0) {
/* 327 */             passed &= checklistItem.getIsChecked().booleanValue();
/*     */           }
/*     */         } 
/* 330 */         if (i != 0) {
/* 331 */           if (passed) {
/* 332 */             certificate.getChecklist().setStatus(ChecklistStatus.PendingValidation);
/* 333 */             this.certificateRepository.save(certificate);
/*     */           } else {
/* 335 */             certificate.getChecklist().setStatus(ChecklistStatus.Failed);
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 340 */       if (certificate.getChecklist().getStatus() == ChecklistStatus.PendingValidation) {
/* 341 */         boolean finished = certificate.getChecklist().getValidatorCheck().booleanValue();
/*     */ 
/*     */         
/* 344 */         int i = finished & ((certificate.getChecklist().getValidatorRole2() == null || (certificate.getChecklist().getValidatorRole2() != null && certificate.getChecklist().getValidator2Check().booleanValue())) ? 1 : 0);
/* 345 */         i &= (certificate
/* 346 */           .getChecklist().getValidatorRole3() == null || (certificate
/* 347 */           .getChecklist().getValidatorRole3() != null && certificate.getChecklist().getValidator3Check().booleanValue())) ? 1 : 0;
/* 348 */         i &= (certificate
/* 349 */           .getChecklist().getValidatorRole4() == null || (certificate
/* 350 */           .getChecklist().getValidatorRole4() != null && certificate.getChecklist().getValidator4Check().booleanValue())) ? 1 : 0;
/* 351 */         if (i != 0) {
/* 352 */           certificate.getChecklist().setStatus(ChecklistStatus.Completed);
/* 353 */           this.certificateRepository.save(certificate);
/*     */         } 
/*     */       } 
/*     */       
/* 357 */       if (certificate.getChecklist().getStatus() == ChecklistStatus.Completed) {
/* 358 */         certificate.setStatus(CertificationStatus.PendingValidation);
/* 359 */         this.certificateRepository.save(certificate);
/* 360 */       } else if (certificate.getChecklist().getStatus() == ChecklistStatus.Failed) {
/* 361 */         certificate.setStatus(CertificationStatus.Failed);
/* 362 */         this.certificateRepository.save(certificate);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void createCertificate(Assignment assignment, Optional<CertificationLevel> nextCertificationLevelOpt) {
/* 368 */     nextCertificationLevelOpt.ifPresent(certificationLevel -> createCertificate(assignment, certificationLevel, false));
/*     */   }
/*     */   
/*     */   private void createCertificate(Assignment assignment, Optional<CertificationLevel> nextCertificationLevelOpt, boolean isRecycling) {
/* 372 */     nextCertificationLevelOpt.ifPresent(certificationLevel -> createCertificate(assignment, certificationLevel, isRecycling));
/*     */   }
/*     */   
/*     */   private void createCertificate(Assignment assignment, CertificationLevel nextCertificationLevel) {
/* 376 */     createCertificate(assignment, nextCertificationLevel, false);
/*     */   }
/*     */   private void createCertificate(Assignment assignment, CertificationLevel nextCertificationLevel, boolean isRecycling) {
/*     */     Period trainingPeriod;
/* 380 */     Certificate certificate = new Certificate();
/* 381 */     certificate.setAssignment(assignment);
/* 382 */     certificate.setStatus(CertificationStatus.InProgress);
/* 383 */     certificate.setLevel(nextCertificationLevel);
/* 384 */     certificate.setStartDate(Instant.now());
/* 385 */     certificate.setValidated(Boolean.valueOf(false));
/* 386 */     certificate.setIsRecycling(Boolean.valueOf(isRecycling));
/*     */ 
/*     */     
/* 389 */     if (isRecycling) {
/* 390 */       trainingPeriod = nextCertificationLevel.getRecyclingAsPeriod();
/*     */     } else {
/* 392 */       trainingPeriod = nextCertificationLevel.getTrainingDurationAsPeriod();
/*     */     } 
/*     */     
/* 395 */     Instant expectedEndDate = certificate.getStartDate().plus(trainingPeriod);
/* 396 */     certificate.setExpectedEndDate(expectedEndDate);
/*     */     
/* 398 */     assignment.addCertificate(certificate);
/*     */     
/* 400 */     this.certificateRepository.save(certificate);
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\CertificationEngineServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */