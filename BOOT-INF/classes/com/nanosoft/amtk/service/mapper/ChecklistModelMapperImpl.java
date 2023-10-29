/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.ChecklistModel;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistModelDTO;
/*     */ import com.nanosoft.amtk.service.mapper.ChecklistModelMapper;
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
/*     */ public class ChecklistModelMapperImpl
/*     */   implements ChecklistModelMapper
/*     */ {
/*     */   public ChecklistModel toEntity(ChecklistModelDTO dto) {
/*  20 */     if (dto == null) {
/*  21 */       return null;
/*     */     }
/*     */     
/*  24 */     ChecklistModel checklistModel = new ChecklistModel();
/*     */     
/*  26 */     checklistModel.createdBy(dto.getCreatedBy());
/*  27 */     checklistModel.createdDate(dto.getCreatedDate());
/*  28 */     checklistModel.lastModifiedBy(dto.getLastModifiedBy());
/*  29 */     checklistModel.lastModifiedDate(dto.getLastModifiedDate());
/*  30 */     checklistModel.setId(dto.getId());
/*  31 */     checklistModel.setTitle(dto.getTitle());
/*  32 */     checklistModel.setDescription(dto.getDescription());
/*  33 */     checklistModel.setValidator(dto.getValidator());
/*  34 */     checklistModel.setValidator2(dto.getValidator2());
/*  35 */     checklistModel.setValidator3(dto.getValidator3());
/*  36 */     checklistModel.setValidator4(dto.getValidator4());
/*     */     
/*  38 */     return checklistModel;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChecklistModelDTO toDto(ChecklistModel entity) {
/*  43 */     if (entity == null) {
/*  44 */       return null;
/*     */     }
/*     */     
/*  47 */     ChecklistModelDTO checklistModelDTO = new ChecklistModelDTO();
/*     */     
/*  49 */     checklistModelDTO.setId(entity.getId());
/*  50 */     checklistModelDTO.setTitle(entity.getTitle());
/*  51 */     checklistModelDTO.setDescription(entity.getDescription());
/*  52 */     checklistModelDTO.setValidator(entity.getValidator());
/*  53 */     checklistModelDTO.setValidator2(entity.getValidator2());
/*  54 */     checklistModelDTO.setValidator3(entity.getValidator3());
/*  55 */     checklistModelDTO.setValidator4(entity.getValidator4());
/*  56 */     checklistModelDTO.setCreatedBy(entity.getCreatedBy());
/*  57 */     checklistModelDTO.setCreatedDate(entity.getCreatedDate());
/*  58 */     checklistModelDTO.setLastModifiedBy(entity.getLastModifiedBy());
/*  59 */     checklistModelDTO.setLastModifiedDate(entity.getLastModifiedDate());
/*     */     
/*  61 */     return checklistModelDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ChecklistModel> toEntity(List<ChecklistModelDTO> dtoList) {
/*  66 */     if (dtoList == null) {
/*  67 */       return null;
/*     */     }
/*     */     
/*  70 */     List<ChecklistModel> list = new ArrayList<>(dtoList.size());
/*  71 */     for (ChecklistModelDTO checklistModelDTO : dtoList) {
/*  72 */       list.add(toEntity(checklistModelDTO));
/*     */     }
/*     */     
/*  75 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ChecklistModelDTO> toDto(List<ChecklistModel> entityList) {
/*  80 */     if (entityList == null) {
/*  81 */       return null;
/*     */     }
/*     */     
/*  84 */     List<ChecklistModelDTO> list = new ArrayList<>(entityList.size());
/*  85 */     for (ChecklistModel checklistModel : entityList) {
/*  86 */       list.add(toDto(checklistModel));
/*     */     }
/*     */     
/*  89 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(ChecklistModel entity, ChecklistModelDTO dto) {
/*  94 */     if (dto == null) {
/*     */       return;
/*     */     }
/*     */     
/*  98 */     if (dto.getCreatedBy() != null) {
/*  99 */       entity.createdBy(dto.getCreatedBy());
/*     */     }
/* 101 */     if (dto.getCreatedDate() != null) {
/* 102 */       entity.createdDate(dto.getCreatedDate());
/*     */     }
/* 104 */     if (dto.getLastModifiedBy() != null) {
/* 105 */       entity.lastModifiedBy(dto.getLastModifiedBy());
/*     */     }
/* 107 */     if (dto.getLastModifiedDate() != null) {
/* 108 */       entity.lastModifiedDate(dto.getLastModifiedDate());
/*     */     }
/* 110 */     if (dto.getId() != null) {
/* 111 */       entity.setId(dto.getId());
/*     */     }
/* 113 */     if (dto.getTitle() != null) {
/* 114 */       entity.setTitle(dto.getTitle());
/*     */     }
/* 116 */     if (dto.getDescription() != null) {
/* 117 */       entity.setDescription(dto.getDescription());
/*     */     }
/* 119 */     if (dto.getValidator() != null) {
/* 120 */       entity.setValidator(dto.getValidator());
/*     */     }
/* 122 */     if (dto.getValidator2() != null) {
/* 123 */       entity.setValidator2(dto.getValidator2());
/*     */     }
/* 125 */     if (dto.getValidator3() != null) {
/* 126 */       entity.setValidator3(dto.getValidator3());
/*     */     }
/* 128 */     if (dto.getValidator4() != null)
/* 129 */       entity.setValidator4(dto.getValidator4()); 
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\ChecklistModelMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */