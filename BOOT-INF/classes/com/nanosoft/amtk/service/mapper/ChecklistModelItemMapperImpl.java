/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.ChecklistModel;
/*     */ import com.nanosoft.amtk.domain.ChecklistModelItem;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistModelDTO;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistModelItemDTO;
/*     */ import com.nanosoft.amtk.service.mapper.ChecklistModelItemMapper;
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
/*     */ public class ChecklistModelItemMapperImpl
/*     */   implements ChecklistModelItemMapper
/*     */ {
/*     */   public ChecklistModelItem toEntity(ChecklistModelItemDTO dto) {
/*  22 */     if (dto == null) {
/*  23 */       return null;
/*     */     }
/*     */     
/*  26 */     ChecklistModelItem checklistModelItem = new ChecklistModelItem();
/*     */     
/*  28 */     checklistModelItem.createdBy(dto.getCreatedBy());
/*  29 */     checklistModelItem.createdDate(dto.getCreatedDate());
/*  30 */     checklistModelItem.lastModifiedBy(dto.getLastModifiedBy());
/*  31 */     checklistModelItem.lastModifiedDate(dto.getLastModifiedDate());
/*  32 */     checklistModelItem.setId(dto.getId());
/*  33 */     checklistModelItem.setText(dto.getText());
/*  34 */     checklistModelItem.setItemGroup(dto.getItemGroup());
/*  35 */     checklistModelItem.setValidator(dto.getValidator());
/*  36 */     checklistModelItem.checklistModel(checklistModelDTOToChecklistModel(dto.getChecklistModel()));
/*     */     
/*  38 */     return checklistModelItem;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ChecklistModelItem> toEntity(List<ChecklistModelItemDTO> dtoList) {
/*  43 */     if (dtoList == null) {
/*  44 */       return null;
/*     */     }
/*     */     
/*  47 */     List<ChecklistModelItem> list = new ArrayList<>(dtoList.size());
/*  48 */     for (ChecklistModelItemDTO checklistModelItemDTO : dtoList) {
/*  49 */       list.add(toEntity(checklistModelItemDTO));
/*     */     }
/*     */     
/*  52 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ChecklistModelItemDTO> toDto(List<ChecklistModelItem> entityList) {
/*  57 */     if (entityList == null) {
/*  58 */       return null;
/*     */     }
/*     */     
/*  61 */     List<ChecklistModelItemDTO> list = new ArrayList<>(entityList.size());
/*  62 */     for (ChecklistModelItem checklistModelItem : entityList) {
/*  63 */       list.add(toDto(checklistModelItem));
/*     */     }
/*     */     
/*  66 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(ChecklistModelItem entity, ChecklistModelItemDTO dto) {
/*  71 */     if (dto == null) {
/*     */       return;
/*     */     }
/*     */     
/*  75 */     if (dto.getCreatedBy() != null) {
/*  76 */       entity.createdBy(dto.getCreatedBy());
/*     */     }
/*  78 */     if (dto.getCreatedDate() != null) {
/*  79 */       entity.createdDate(dto.getCreatedDate());
/*     */     }
/*  81 */     if (dto.getLastModifiedBy() != null) {
/*  82 */       entity.lastModifiedBy(dto.getLastModifiedBy());
/*     */     }
/*  84 */     if (dto.getLastModifiedDate() != null) {
/*  85 */       entity.lastModifiedDate(dto.getLastModifiedDate());
/*     */     }
/*  87 */     if (dto.getId() != null) {
/*  88 */       entity.setId(dto.getId());
/*     */     }
/*  90 */     if (dto.getText() != null) {
/*  91 */       entity.setText(dto.getText());
/*     */     }
/*  93 */     if (dto.getItemGroup() != null) {
/*  94 */       entity.setItemGroup(dto.getItemGroup());
/*     */     }
/*  96 */     if (dto.getValidator() != null) {
/*  97 */       entity.setValidator(dto.getValidator());
/*     */     }
/*  99 */     if (dto.getChecklistModel() != null) {
/* 100 */       if (entity.getChecklistModel() == null) {
/* 101 */         entity.checklistModel(new ChecklistModel());
/*     */       }
/* 103 */       checklistModelDTOToChecklistModel1(dto.getChecklistModel(), entity.getChecklistModel());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ChecklistModelItemDTO toDto(ChecklistModelItem s) {
/* 109 */     if (s == null) {
/* 110 */       return null;
/*     */     }
/*     */     
/* 113 */     ChecklistModelItemDTO checklistModelItemDTO = new ChecklistModelItemDTO();
/*     */     
/* 115 */     checklistModelItemDTO.setChecklistModel(checklistModelToChecklistModelDTO(s.getChecklistModel()));
/* 116 */     checklistModelItemDTO.setId(s.getId());
/* 117 */     checklistModelItemDTO.setText(s.getText());
/* 118 */     checklistModelItemDTO.setItemGroup(s.getItemGroup());
/* 119 */     checklistModelItemDTO.setValidator(s.getValidator());
/* 120 */     checklistModelItemDTO.setCreatedBy(s.getCreatedBy());
/* 121 */     checklistModelItemDTO.setCreatedDate(s.getCreatedDate());
/* 122 */     checklistModelItemDTO.setLastModifiedBy(s.getLastModifiedBy());
/* 123 */     checklistModelItemDTO.setLastModifiedDate(s.getLastModifiedDate());
/*     */     
/* 125 */     return checklistModelItemDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChecklistModelDTO toDtoChecklistModelId(ChecklistModel checklistModel) {
/* 130 */     if (checklistModel == null) {
/* 131 */       return null;
/*     */     }
/*     */     
/* 134 */     ChecklistModelDTO checklistModelDTO = new ChecklistModelDTO();
/*     */     
/* 136 */     checklistModelDTO.setId(checklistModel.getId());
/*     */     
/* 138 */     return checklistModelDTO;
/*     */   }
/*     */   
/*     */   protected ChecklistModel checklistModelDTOToChecklistModel(ChecklistModelDTO checklistModelDTO) {
/* 142 */     if (checklistModelDTO == null) {
/* 143 */       return null;
/*     */     }
/*     */     
/* 146 */     ChecklistModel checklistModel = new ChecklistModel();
/*     */     
/* 148 */     checklistModel.createdBy(checklistModelDTO.getCreatedBy());
/* 149 */     checklistModel.createdDate(checklistModelDTO.getCreatedDate());
/* 150 */     checklistModel.lastModifiedBy(checklistModelDTO.getLastModifiedBy());
/* 151 */     checklistModel.lastModifiedDate(checklistModelDTO.getLastModifiedDate());
/* 152 */     checklistModel.setId(checklistModelDTO.getId());
/* 153 */     checklistModel.setTitle(checklistModelDTO.getTitle());
/* 154 */     checklistModel.setDescription(checklistModelDTO.getDescription());
/* 155 */     checklistModel.setValidator(checklistModelDTO.getValidator());
/* 156 */     checklistModel.setValidator2(checklistModelDTO.getValidator2());
/* 157 */     checklistModel.setValidator3(checklistModelDTO.getValidator3());
/* 158 */     checklistModel.setValidator4(checklistModelDTO.getValidator4());
/*     */     
/* 160 */     return checklistModel;
/*     */   }
/*     */   
/*     */   protected void checklistModelDTOToChecklistModel1(ChecklistModelDTO checklistModelDTO, ChecklistModel mappingTarget) {
/* 164 */     if (checklistModelDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 168 */     if (checklistModelDTO.getCreatedBy() != null) {
/* 169 */       mappingTarget.createdBy(checklistModelDTO.getCreatedBy());
/*     */     }
/* 171 */     if (checklistModelDTO.getCreatedDate() != null) {
/* 172 */       mappingTarget.createdDate(checklistModelDTO.getCreatedDate());
/*     */     }
/* 174 */     if (checklistModelDTO.getLastModifiedBy() != null) {
/* 175 */       mappingTarget.lastModifiedBy(checklistModelDTO.getLastModifiedBy());
/*     */     }
/* 177 */     if (checklistModelDTO.getLastModifiedDate() != null) {
/* 178 */       mappingTarget.lastModifiedDate(checklistModelDTO.getLastModifiedDate());
/*     */     }
/* 180 */     if (checklistModelDTO.getId() != null) {
/* 181 */       mappingTarget.setId(checklistModelDTO.getId());
/*     */     }
/* 183 */     if (checklistModelDTO.getTitle() != null) {
/* 184 */       mappingTarget.setTitle(checklistModelDTO.getTitle());
/*     */     }
/* 186 */     if (checklistModelDTO.getDescription() != null) {
/* 187 */       mappingTarget.setDescription(checklistModelDTO.getDescription());
/*     */     }
/* 189 */     if (checklistModelDTO.getValidator() != null) {
/* 190 */       mappingTarget.setValidator(checklistModelDTO.getValidator());
/*     */     }
/* 192 */     if (checklistModelDTO.getValidator2() != null) {
/* 193 */       mappingTarget.setValidator2(checklistModelDTO.getValidator2());
/*     */     }
/* 195 */     if (checklistModelDTO.getValidator3() != null) {
/* 196 */       mappingTarget.setValidator3(checklistModelDTO.getValidator3());
/*     */     }
/* 198 */     if (checklistModelDTO.getValidator4() != null) {
/* 199 */       mappingTarget.setValidator4(checklistModelDTO.getValidator4());
/*     */     }
/*     */   }
/*     */   
/*     */   protected ChecklistModelDTO checklistModelToChecklistModelDTO(ChecklistModel checklistModel) {
/* 204 */     if (checklistModel == null) {
/* 205 */       return null;
/*     */     }
/*     */     
/* 208 */     ChecklistModelDTO checklistModelDTO = new ChecklistModelDTO();
/*     */     
/* 210 */     checklistModelDTO.setId(checklistModel.getId());
/* 211 */     checklistModelDTO.setTitle(checklistModel.getTitle());
/* 212 */     checklistModelDTO.setDescription(checklistModel.getDescription());
/* 213 */     checklistModelDTO.setValidator(checklistModel.getValidator());
/* 214 */     checklistModelDTO.setValidator2(checklistModel.getValidator2());
/* 215 */     checklistModelDTO.setValidator3(checklistModel.getValidator3());
/* 216 */     checklistModelDTO.setValidator4(checklistModel.getValidator4());
/* 217 */     checklistModelDTO.setCreatedBy(checklistModel.getCreatedBy());
/* 218 */     checklistModelDTO.setCreatedDate(checklistModel.getCreatedDate());
/* 219 */     checklistModelDTO.setLastModifiedBy(checklistModel.getLastModifiedBy());
/* 220 */     checklistModelDTO.setLastModifiedDate(checklistModel.getLastModifiedDate());
/*     */     
/* 222 */     return checklistModelDTO;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\ChecklistModelItemMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */