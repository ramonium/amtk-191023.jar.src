/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.CertificationLevel;
/*     */ import com.nanosoft.amtk.domain.ChecklistModel;
/*     */ import com.nanosoft.amtk.domain.Process;
/*     */ import com.nanosoft.amtk.service.dto.CertificationLevelDTO;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistModelDTO;
/*     */ import com.nanosoft.amtk.service.dto.ProcessDTO;
/*     */ import com.nanosoft.amtk.service.mapper.CertificationLevelMapper;
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
/*     */ public class CertificationLevelMapperImpl
/*     */   implements CertificationLevelMapper
/*     */ {
/*     */   public CertificationLevel toEntity(CertificationLevelDTO dto) {
/*  24 */     if (dto == null) {
/*  25 */       return null;
/*     */     }
/*     */     
/*  28 */     CertificationLevel certificationLevel = new CertificationLevel();
/*     */     
/*  30 */     certificationLevel.createdBy(dto.getCreatedBy());
/*  31 */     certificationLevel.createdDate(dto.getCreatedDate());
/*  32 */     certificationLevel.lastModifiedBy(dto.getLastModifiedBy());
/*  33 */     certificationLevel.lastModifiedDate(dto.getLastModifiedDate());
/*  34 */     certificationLevel.setId(dto.getId());
/*  35 */     certificationLevel.setLevel(dto.getLevel());
/*  36 */     certificationLevel.setOrderNumber(dto.getOrderNumber());
/*  37 */     certificationLevel.setTrainingDuration(dto.getTrainingDuration());
/*  38 */     certificationLevel.setRecyclingPeriod(dto.getRecyclingPeriod());
/*  39 */     certificationLevel.setDescription(dto.getDescription());
/*  40 */     certificationLevel.process(processDTOToProcess(dto.getProcess()));
/*  41 */     certificationLevel.checklistModel(checklistModelDTOToChecklistModel(dto.getChecklistModel()));
/*     */     
/*  43 */     return certificationLevel;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<CertificationLevel> toEntity(List<CertificationLevelDTO> dtoList) {
/*  48 */     if (dtoList == null) {
/*  49 */       return null;
/*     */     }
/*     */     
/*  52 */     List<CertificationLevel> list = new ArrayList<>(dtoList.size());
/*  53 */     for (CertificationLevelDTO certificationLevelDTO : dtoList) {
/*  54 */       list.add(toEntity(certificationLevelDTO));
/*     */     }
/*     */     
/*  57 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<CertificationLevelDTO> toDto(List<CertificationLevel> entityList) {
/*  62 */     if (entityList == null) {
/*  63 */       return null;
/*     */     }
/*     */     
/*  66 */     List<CertificationLevelDTO> list = new ArrayList<>(entityList.size());
/*  67 */     for (CertificationLevel certificationLevel : entityList) {
/*  68 */       list.add(toDto(certificationLevel));
/*     */     }
/*     */     
/*  71 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(CertificationLevel entity, CertificationLevelDTO dto) {
/*  76 */     if (dto == null) {
/*     */       return;
/*     */     }
/*     */     
/*  80 */     if (dto.getCreatedBy() != null) {
/*  81 */       entity.createdBy(dto.getCreatedBy());
/*     */     }
/*  83 */     if (dto.getCreatedDate() != null) {
/*  84 */       entity.createdDate(dto.getCreatedDate());
/*     */     }
/*  86 */     if (dto.getLastModifiedBy() != null) {
/*  87 */       entity.lastModifiedBy(dto.getLastModifiedBy());
/*     */     }
/*  89 */     if (dto.getLastModifiedDate() != null) {
/*  90 */       entity.lastModifiedDate(dto.getLastModifiedDate());
/*     */     }
/*  92 */     if (dto.getId() != null) {
/*  93 */       entity.setId(dto.getId());
/*     */     }
/*  95 */     if (dto.getLevel() != null) {
/*  96 */       entity.setLevel(dto.getLevel());
/*     */     }
/*  98 */     if (dto.getOrderNumber() != null) {
/*  99 */       entity.setOrderNumber(dto.getOrderNumber());
/*     */     }
/* 101 */     if (dto.getTrainingDuration() != null) {
/* 102 */       entity.setTrainingDuration(dto.getTrainingDuration());
/*     */     }
/* 104 */     if (dto.getRecyclingPeriod() != null) {
/* 105 */       entity.setRecyclingPeriod(dto.getRecyclingPeriod());
/*     */     }
/* 107 */     if (dto.getDescription() != null) {
/* 108 */       entity.setDescription(dto.getDescription());
/*     */     }
/* 110 */     if (dto.getProcess() != null) {
/* 111 */       if (entity.getProcess() == null) {
/* 112 */         entity.process(new Process());
/*     */       }
/* 114 */       processDTOToProcess1(dto.getProcess(), entity.getProcess());
/*     */     } 
/* 116 */     if (dto.getChecklistModel() != null) {
/* 117 */       if (entity.getChecklistModel() == null) {
/* 118 */         entity.checklistModel(new ChecklistModel());
/*     */       }
/* 120 */       checklistModelDTOToChecklistModel1(dto.getChecklistModel(), entity.getChecklistModel());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CertificationLevelDTO toDto(CertificationLevel s) {
/* 126 */     if (s == null) {
/* 127 */       return null;
/*     */     }
/*     */     
/* 130 */     CertificationLevelDTO certificationLevelDTO = new CertificationLevelDTO();
/*     */     
/* 132 */     certificationLevelDTO.setProcess(processToProcessDTO(s.getProcess()));
/* 133 */     certificationLevelDTO.setChecklistModel(checklistModelToChecklistModelDTO(s.getChecklistModel()));
/* 134 */     certificationLevelDTO.setId(s.getId());
/* 135 */     certificationLevelDTO.setLevel(s.getLevel());
/* 136 */     certificationLevelDTO.setOrderNumber(s.getOrderNumber());
/* 137 */     certificationLevelDTO.setTrainingDuration(s.getTrainingDuration());
/* 138 */     certificationLevelDTO.setRecyclingPeriod(s.getRecyclingPeriod());
/* 139 */     certificationLevelDTO.setDescription(s.getDescription());
/* 140 */     certificationLevelDTO.setCreatedBy(s.getCreatedBy());
/* 141 */     certificationLevelDTO.setCreatedDate(s.getCreatedDate());
/* 142 */     certificationLevelDTO.setLastModifiedBy(s.getLastModifiedBy());
/* 143 */     certificationLevelDTO.setLastModifiedDate(s.getLastModifiedDate());
/*     */     
/* 145 */     return certificationLevelDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public ProcessDTO toDtoProcessId(Process process) {
/* 150 */     if (process == null) {
/* 151 */       return null;
/*     */     }
/*     */     
/* 154 */     ProcessDTO processDTO = new ProcessDTO();
/*     */     
/* 156 */     processDTO.setId(process.getId());
/*     */     
/* 158 */     return processDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChecklistModelDTO toDtoChecklistModelId(ChecklistModel checklistModel) {
/* 163 */     if (checklistModel == null) {
/* 164 */       return null;
/*     */     }
/*     */     
/* 167 */     ChecklistModelDTO checklistModelDTO = new ChecklistModelDTO();
/*     */     
/* 169 */     checklistModelDTO.setId(checklistModel.getId());
/*     */     
/* 171 */     return checklistModelDTO;
/*     */   }
/*     */   
/*     */   protected Process processDTOToProcess(ProcessDTO processDTO) {
/* 175 */     if (processDTO == null) {
/* 176 */       return null;
/*     */     }
/*     */     
/* 179 */     Process process = new Process();
/*     */     
/* 181 */     process.createdBy(processDTO.getCreatedBy());
/* 182 */     process.createdDate(processDTO.getCreatedDate());
/* 183 */     process.lastModifiedBy(processDTO.getLastModifiedBy());
/* 184 */     process.lastModifiedDate(processDTO.getLastModifiedDate());
/* 185 */     process.setId(processDTO.getId());
/* 186 */     process.setName(processDTO.getName());
/* 187 */     process.setDescription(processDTO.getDescription());
/*     */     
/* 189 */     return process;
/*     */   }
/*     */   
/*     */   protected ChecklistModel checklistModelDTOToChecklistModel(ChecklistModelDTO checklistModelDTO) {
/* 193 */     if (checklistModelDTO == null) {
/* 194 */       return null;
/*     */     }
/*     */     
/* 197 */     ChecklistModel checklistModel = new ChecklistModel();
/*     */     
/* 199 */     checklistModel.createdBy(checklistModelDTO.getCreatedBy());
/* 200 */     checklistModel.createdDate(checklistModelDTO.getCreatedDate());
/* 201 */     checklistModel.lastModifiedBy(checklistModelDTO.getLastModifiedBy());
/* 202 */     checklistModel.lastModifiedDate(checklistModelDTO.getLastModifiedDate());
/* 203 */     checklistModel.setId(checklistModelDTO.getId());
/* 204 */     checklistModel.setTitle(checklistModelDTO.getTitle());
/* 205 */     checklistModel.setDescription(checklistModelDTO.getDescription());
/* 206 */     checklistModel.setValidator(checklistModelDTO.getValidator());
/* 207 */     checklistModel.setValidator2(checklistModelDTO.getValidator2());
/* 208 */     checklistModel.setValidator3(checklistModelDTO.getValidator3());
/* 209 */     checklistModel.setValidator4(checklistModelDTO.getValidator4());
/*     */     
/* 211 */     return checklistModel;
/*     */   }
/*     */   
/*     */   protected void processDTOToProcess1(ProcessDTO processDTO, Process mappingTarget) {
/* 215 */     if (processDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 219 */     if (processDTO.getCreatedBy() != null) {
/* 220 */       mappingTarget.createdBy(processDTO.getCreatedBy());
/*     */     }
/* 222 */     if (processDTO.getCreatedDate() != null) {
/* 223 */       mappingTarget.createdDate(processDTO.getCreatedDate());
/*     */     }
/* 225 */     if (processDTO.getLastModifiedBy() != null) {
/* 226 */       mappingTarget.lastModifiedBy(processDTO.getLastModifiedBy());
/*     */     }
/* 228 */     if (processDTO.getLastModifiedDate() != null) {
/* 229 */       mappingTarget.lastModifiedDate(processDTO.getLastModifiedDate());
/*     */     }
/* 231 */     if (processDTO.getId() != null) {
/* 232 */       mappingTarget.setId(processDTO.getId());
/*     */     }
/* 234 */     if (processDTO.getName() != null) {
/* 235 */       mappingTarget.setName(processDTO.getName());
/*     */     }
/* 237 */     if (processDTO.getDescription() != null) {
/* 238 */       mappingTarget.setDescription(processDTO.getDescription());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void checklistModelDTOToChecklistModel1(ChecklistModelDTO checklistModelDTO, ChecklistModel mappingTarget) {
/* 243 */     if (checklistModelDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 247 */     if (checklistModelDTO.getCreatedBy() != null) {
/* 248 */       mappingTarget.createdBy(checklistModelDTO.getCreatedBy());
/*     */     }
/* 250 */     if (checklistModelDTO.getCreatedDate() != null) {
/* 251 */       mappingTarget.createdDate(checklistModelDTO.getCreatedDate());
/*     */     }
/* 253 */     if (checklistModelDTO.getLastModifiedBy() != null) {
/* 254 */       mappingTarget.lastModifiedBy(checklistModelDTO.getLastModifiedBy());
/*     */     }
/* 256 */     if (checklistModelDTO.getLastModifiedDate() != null) {
/* 257 */       mappingTarget.lastModifiedDate(checklistModelDTO.getLastModifiedDate());
/*     */     }
/* 259 */     if (checklistModelDTO.getId() != null) {
/* 260 */       mappingTarget.setId(checklistModelDTO.getId());
/*     */     }
/* 262 */     if (checklistModelDTO.getTitle() != null) {
/* 263 */       mappingTarget.setTitle(checklistModelDTO.getTitle());
/*     */     }
/* 265 */     if (checklistModelDTO.getDescription() != null) {
/* 266 */       mappingTarget.setDescription(checklistModelDTO.getDescription());
/*     */     }
/* 268 */     if (checklistModelDTO.getValidator() != null) {
/* 269 */       mappingTarget.setValidator(checklistModelDTO.getValidator());
/*     */     }
/* 271 */     if (checklistModelDTO.getValidator2() != null) {
/* 272 */       mappingTarget.setValidator2(checklistModelDTO.getValidator2());
/*     */     }
/* 274 */     if (checklistModelDTO.getValidator3() != null) {
/* 275 */       mappingTarget.setValidator3(checklistModelDTO.getValidator3());
/*     */     }
/* 277 */     if (checklistModelDTO.getValidator4() != null) {
/* 278 */       mappingTarget.setValidator4(checklistModelDTO.getValidator4());
/*     */     }
/*     */   }
/*     */   
/*     */   protected ProcessDTO processToProcessDTO(Process process) {
/* 283 */     if (process == null) {
/* 284 */       return null;
/*     */     }
/*     */     
/* 287 */     ProcessDTO processDTO = new ProcessDTO();
/*     */     
/* 289 */     processDTO.setId(process.getId());
/* 290 */     processDTO.setName(process.getName());
/* 291 */     processDTO.setDescription(process.getDescription());
/* 292 */     processDTO.setCreatedBy(process.getCreatedBy());
/* 293 */     processDTO.setCreatedDate(process.getCreatedDate());
/* 294 */     processDTO.setLastModifiedBy(process.getLastModifiedBy());
/* 295 */     processDTO.setLastModifiedDate(process.getLastModifiedDate());
/*     */     
/* 297 */     return processDTO;
/*     */   }
/*     */   
/*     */   protected ChecklistModelDTO checklistModelToChecklistModelDTO(ChecklistModel checklistModel) {
/* 301 */     if (checklistModel == null) {
/* 302 */       return null;
/*     */     }
/*     */     
/* 305 */     ChecklistModelDTO checklistModelDTO = new ChecklistModelDTO();
/*     */     
/* 307 */     checklistModelDTO.setId(checklistModel.getId());
/* 308 */     checklistModelDTO.setTitle(checklistModel.getTitle());
/* 309 */     checklistModelDTO.setDescription(checklistModel.getDescription());
/* 310 */     checklistModelDTO.setValidator(checklistModel.getValidator());
/* 311 */     checklistModelDTO.setValidator2(checklistModel.getValidator2());
/* 312 */     checklistModelDTO.setValidator3(checklistModel.getValidator3());
/* 313 */     checklistModelDTO.setValidator4(checklistModel.getValidator4());
/* 314 */     checklistModelDTO.setCreatedBy(checklistModel.getCreatedBy());
/* 315 */     checklistModelDTO.setCreatedDate(checklistModel.getCreatedDate());
/* 316 */     checklistModelDTO.setLastModifiedBy(checklistModel.getLastModifiedBy());
/* 317 */     checklistModelDTO.setLastModifiedDate(checklistModel.getLastModifiedDate());
/*     */     
/* 319 */     return checklistModelDTO;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\CertificationLevelMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */