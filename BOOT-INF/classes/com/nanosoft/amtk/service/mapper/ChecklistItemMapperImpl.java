/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Checklist;
/*     */ import com.nanosoft.amtk.domain.ChecklistItem;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistDTO;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistItemDTO;
/*     */ import com.nanosoft.amtk.service.mapper.ChecklistItemMapper;
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
/*     */ public class ChecklistItemMapperImpl
/*     */   implements ChecklistItemMapper
/*     */ {
/*     */   public ChecklistItem toEntity(ChecklistItemDTO dto) {
/*  22 */     if (dto == null) {
/*  23 */       return null;
/*     */     }
/*     */     
/*  26 */     ChecklistItem checklistItem = new ChecklistItem();
/*     */     
/*  28 */     checklistItem.createdBy(dto.getCreatedBy());
/*  29 */     checklistItem.createdDate(dto.getCreatedDate());
/*  30 */     checklistItem.lastModifiedBy(dto.getLastModifiedBy());
/*  31 */     checklistItem.lastModifiedDate(dto.getLastModifiedDate());
/*  32 */     checklistItem.setId(dto.getId());
/*  33 */     checklistItem.setText(dto.getText());
/*  34 */     checklistItem.setItemGroup(dto.getItemGroup());
/*  35 */     checklistItem.setValidatorRole(dto.getValidatorRole());
/*  36 */     checklistItem.setValidator(dto.getValidator());
/*  37 */     checklistItem.setIsChecked(dto.getIsChecked());
/*     */     
/*  39 */     return checklistItem;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ChecklistItem> toEntity(List<ChecklistItemDTO> dtoList) {
/*  44 */     if (dtoList == null) {
/*  45 */       return null;
/*     */     }
/*     */     
/*  48 */     List<ChecklistItem> list = new ArrayList<>(dtoList.size());
/*  49 */     for (ChecklistItemDTO checklistItemDTO : dtoList) {
/*  50 */       list.add(toEntity(checklistItemDTO));
/*     */     }
/*     */     
/*  53 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ChecklistItemDTO> toDto(List<ChecklistItem> entityList) {
/*  58 */     if (entityList == null) {
/*  59 */       return null;
/*     */     }
/*     */     
/*  62 */     List<ChecklistItemDTO> list = new ArrayList<>(entityList.size());
/*  63 */     for (ChecklistItem checklistItem : entityList) {
/*  64 */       list.add(toDto(checklistItem));
/*     */     }
/*     */     
/*  67 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(ChecklistItem entity, ChecklistItemDTO dto) {
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
/*  91 */     if (dto.getText() != null) {
/*  92 */       entity.setText(dto.getText());
/*     */     }
/*  94 */     if (dto.getItemGroup() != null) {
/*  95 */       entity.setItemGroup(dto.getItemGroup());
/*     */     }
/*  97 */     if (dto.getValidatorRole() != null) {
/*  98 */       entity.setValidatorRole(dto.getValidatorRole());
/*     */     }
/* 100 */     if (dto.getValidator() != null) {
/* 101 */       entity.setValidator(dto.getValidator());
/*     */     }
/* 103 */     if (dto.getIsChecked() != null) {
/* 104 */       entity.setIsChecked(dto.getIsChecked());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ChecklistItemDTO toDto(ChecklistItem s) {
/* 110 */     if (s == null) {
/* 111 */       return null;
/*     */     }
/*     */     
/* 114 */     ChecklistItemDTO checklistItemDTO = new ChecklistItemDTO();
/*     */     
/* 116 */     checklistItemDTO.setId(s.getId());
/* 117 */     checklistItemDTO.setText(s.getText());
/* 118 */     checklistItemDTO.setItemGroup(s.getItemGroup());
/* 119 */     checklistItemDTO.setValidatorRole(s.getValidatorRole());
/* 120 */     checklistItemDTO.setValidator(s.getValidator());
/* 121 */     checklistItemDTO.setIsChecked(s.getIsChecked());
/* 122 */     checklistItemDTO.setCreatedBy(s.getCreatedBy());
/* 123 */     checklistItemDTO.setCreatedDate(s.getCreatedDate());
/* 124 */     checklistItemDTO.setLastModifiedBy(s.getLastModifiedBy());
/* 125 */     checklistItemDTO.setLastModifiedDate(s.getLastModifiedDate());
/*     */     
/* 127 */     return checklistItemDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChecklistDTO toDtoChecklistId(Checklist checklist) {
/* 132 */     if (checklist == null) {
/* 133 */       return null;
/*     */     }
/*     */     
/* 136 */     ChecklistDTO checklistDTO = new ChecklistDTO();
/*     */     
/* 138 */     checklistDTO.setId(checklist.getId());
/*     */     
/* 140 */     return checklistDTO;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\ChecklistItemMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */