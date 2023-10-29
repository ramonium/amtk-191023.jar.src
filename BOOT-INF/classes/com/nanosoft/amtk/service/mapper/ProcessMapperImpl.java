/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Process;
/*     */ import com.nanosoft.amtk.service.dto.ProcessDTO;
/*     */ import com.nanosoft.amtk.service.mapper.ProcessMapper;
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
/*     */ public class ProcessMapperImpl
/*     */   implements ProcessMapper
/*     */ {
/*     */   public Process toEntity(ProcessDTO dto) {
/*  20 */     if (dto == null) {
/*  21 */       return null;
/*     */     }
/*     */     
/*  24 */     Process process = new Process();
/*     */     
/*  26 */     process.createdBy(dto.getCreatedBy());
/*  27 */     process.createdDate(dto.getCreatedDate());
/*  28 */     process.lastModifiedBy(dto.getLastModifiedBy());
/*  29 */     process.lastModifiedDate(dto.getLastModifiedDate());
/*  30 */     process.setId(dto.getId());
/*  31 */     process.setName(dto.getName());
/*  32 */     process.setDescription(dto.getDescription());
/*     */     
/*  34 */     return process;
/*     */   }
/*     */ 
/*     */   
/*     */   public ProcessDTO toDto(Process entity) {
/*  39 */     if (entity == null) {
/*  40 */       return null;
/*     */     }
/*     */     
/*  43 */     ProcessDTO processDTO = new ProcessDTO();
/*     */     
/*  45 */     processDTO.setId(entity.getId());
/*  46 */     processDTO.setName(entity.getName());
/*  47 */     processDTO.setDescription(entity.getDescription());
/*  48 */     processDTO.setCreatedBy(entity.getCreatedBy());
/*  49 */     processDTO.setCreatedDate(entity.getCreatedDate());
/*  50 */     processDTO.setLastModifiedBy(entity.getLastModifiedBy());
/*  51 */     processDTO.setLastModifiedDate(entity.getLastModifiedDate());
/*     */     
/*  53 */     return processDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Process> toEntity(List<ProcessDTO> dtoList) {
/*  58 */     if (dtoList == null) {
/*  59 */       return null;
/*     */     }
/*     */     
/*  62 */     List<Process> list = new ArrayList<>(dtoList.size());
/*  63 */     for (ProcessDTO processDTO : dtoList) {
/*  64 */       list.add(toEntity(processDTO));
/*     */     }
/*     */     
/*  67 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ProcessDTO> toDto(List<Process> entityList) {
/*  72 */     if (entityList == null) {
/*  73 */       return null;
/*     */     }
/*     */     
/*  76 */     List<ProcessDTO> list = new ArrayList<>(entityList.size());
/*  77 */     for (Process process : entityList) {
/*  78 */       list.add(toDto(process));
/*     */     }
/*     */     
/*  81 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(Process entity, ProcessDTO dto) {
/*  86 */     if (dto == null) {
/*     */       return;
/*     */     }
/*     */     
/*  90 */     if (dto.getCreatedBy() != null) {
/*  91 */       entity.createdBy(dto.getCreatedBy());
/*     */     }
/*  93 */     if (dto.getCreatedDate() != null) {
/*  94 */       entity.createdDate(dto.getCreatedDate());
/*     */     }
/*  96 */     if (dto.getLastModifiedBy() != null) {
/*  97 */       entity.lastModifiedBy(dto.getLastModifiedBy());
/*     */     }
/*  99 */     if (dto.getLastModifiedDate() != null) {
/* 100 */       entity.lastModifiedDate(dto.getLastModifiedDate());
/*     */     }
/* 102 */     if (dto.getId() != null) {
/* 103 */       entity.setId(dto.getId());
/*     */     }
/* 105 */     if (dto.getName() != null) {
/* 106 */       entity.setName(dto.getName());
/*     */     }
/* 108 */     if (dto.getDescription() != null)
/* 109 */       entity.setDescription(dto.getDescription()); 
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\ProcessMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */