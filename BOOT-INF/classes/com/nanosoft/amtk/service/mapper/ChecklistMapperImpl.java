/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Checklist;
/*     */ import com.nanosoft.amtk.domain.ChecklistItem;
/*     */ import com.nanosoft.amtk.domain.ChecklistModel;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistDTO;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistItemDTO;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistModelDTO;
/*     */ import com.nanosoft.amtk.service.mapper.ChecklistMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Component
/*     */ public class ChecklistMapperImpl
/*     */   implements ChecklistMapper
/*     */ {
/*     */   public Checklist toEntity(ChecklistDTO dto) {
/*  26 */     if (dto == null) {
/*  27 */       return null;
/*     */     }
/*     */     
/*  30 */     Checklist checklist = new Checklist();
/*     */     
/*  32 */     checklist.createdBy(dto.getCreatedBy());
/*  33 */     checklist.createdDate(dto.getCreatedDate());
/*  34 */     checklist.lastModifiedBy(dto.getLastModifiedBy());
/*  35 */     checklist.lastModifiedDate(dto.getLastModifiedDate());
/*  36 */     checklist.setId(dto.getId());
/*  37 */     checklist.setTitle(dto.getTitle());
/*  38 */     checklist.setDescription(dto.getDescription());
/*  39 */     checklist.setValidatorRole(dto.getValidatorRole());
/*  40 */     checklist.setValidator(dto.getValidator());
/*  41 */     checklist.setValidatorCheck(dto.getValidatorCheck());
/*  42 */     checklist.setValidatorRole2(dto.getValidatorRole2());
/*  43 */     checklist.setValidator2(dto.getValidator2());
/*  44 */     checklist.setValidator2Check(dto.getValidator2Check());
/*  45 */     checklist.setValidatorRole3(dto.getValidatorRole3());
/*  46 */     checklist.setValidator3(dto.getValidator3());
/*  47 */     checklist.setValidator3Check(dto.getValidator3Check());
/*  48 */     checklist.setValidatorRole4(dto.getValidatorRole4());
/*  49 */     checklist.setValidator4(dto.getValidator4());
/*  50 */     checklist.setValidator4Check(dto.getValidator4Check());
/*  51 */     checklist.setStatus(dto.getStatus());
/*  52 */     checklist.checklistModel(checklistModelDTOToChecklistModel(dto.getChecklistModel()));
/*  53 */     checklist.checklistItems(checklistItemDTOListToChecklistItemSet(dto.getChecklistItems()));
/*     */     
/*  55 */     return checklist;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Checklist> toEntity(List<ChecklistDTO> dtoList) {
/*  60 */     if (dtoList == null) {
/*  61 */       return null;
/*     */     }
/*     */     
/*  64 */     List<Checklist> list = new ArrayList<>(dtoList.size());
/*  65 */     for (ChecklistDTO checklistDTO : dtoList) {
/*  66 */       list.add(toEntity(checklistDTO));
/*     */     }
/*     */     
/*  69 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ChecklistDTO> toDto(List<Checklist> entityList) {
/*  74 */     if (entityList == null) {
/*  75 */       return null;
/*     */     }
/*     */     
/*  78 */     List<ChecklistDTO> list = new ArrayList<>(entityList.size());
/*  79 */     for (Checklist checklist : entityList) {
/*  80 */       list.add(toDto(checklist));
/*     */     }
/*     */     
/*  83 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(Checklist entity, ChecklistDTO dto) {
/*  88 */     if (dto == null) {
/*     */       return;
/*     */     }
/*     */     
/*  92 */     if (dto.getCreatedBy() != null) {
/*  93 */       entity.createdBy(dto.getCreatedBy());
/*     */     }
/*  95 */     if (dto.getCreatedDate() != null) {
/*  96 */       entity.createdDate(dto.getCreatedDate());
/*     */     }
/*  98 */     if (dto.getLastModifiedBy() != null) {
/*  99 */       entity.lastModifiedBy(dto.getLastModifiedBy());
/*     */     }
/* 101 */     if (dto.getLastModifiedDate() != null) {
/* 102 */       entity.lastModifiedDate(dto.getLastModifiedDate());
/*     */     }
/* 104 */     if (dto.getId() != null) {
/* 105 */       entity.setId(dto.getId());
/*     */     }
/* 107 */     if (dto.getTitle() != null) {
/* 108 */       entity.setTitle(dto.getTitle());
/*     */     }
/* 110 */     if (dto.getDescription() != null) {
/* 111 */       entity.setDescription(dto.getDescription());
/*     */     }
/* 113 */     if (dto.getValidatorRole() != null) {
/* 114 */       entity.setValidatorRole(dto.getValidatorRole());
/*     */     }
/* 116 */     if (dto.getValidator() != null) {
/* 117 */       entity.setValidator(dto.getValidator());
/*     */     }
/* 119 */     if (dto.getValidatorCheck() != null) {
/* 120 */       entity.setValidatorCheck(dto.getValidatorCheck());
/*     */     }
/* 122 */     if (dto.getValidatorRole2() != null) {
/* 123 */       entity.setValidatorRole2(dto.getValidatorRole2());
/*     */     }
/* 125 */     if (dto.getValidator2() != null) {
/* 126 */       entity.setValidator2(dto.getValidator2());
/*     */     }
/* 128 */     if (dto.getValidator2Check() != null) {
/* 129 */       entity.setValidator2Check(dto.getValidator2Check());
/*     */     }
/* 131 */     if (dto.getValidatorRole3() != null) {
/* 132 */       entity.setValidatorRole3(dto.getValidatorRole3());
/*     */     }
/* 134 */     if (dto.getValidator3() != null) {
/* 135 */       entity.setValidator3(dto.getValidator3());
/*     */     }
/* 137 */     if (dto.getValidator3Check() != null) {
/* 138 */       entity.setValidator3Check(dto.getValidator3Check());
/*     */     }
/* 140 */     if (dto.getValidatorRole4() != null) {
/* 141 */       entity.setValidatorRole4(dto.getValidatorRole4());
/*     */     }
/* 143 */     if (dto.getValidator4() != null) {
/* 144 */       entity.setValidator4(dto.getValidator4());
/*     */     }
/* 146 */     if (dto.getValidator4Check() != null) {
/* 147 */       entity.setValidator4Check(dto.getValidator4Check());
/*     */     }
/* 149 */     if (dto.getStatus() != null) {
/* 150 */       entity.setStatus(dto.getStatus());
/*     */     }
/* 152 */     if (dto.getChecklistModel() != null) {
/* 153 */       if (entity.getChecklistModel() == null) {
/* 154 */         entity.checklistModel(new ChecklistModel());
/*     */       }
/* 156 */       checklistModelDTOToChecklistModel1(dto.getChecklistModel(), entity.getChecklistModel());
/*     */     } 
/* 158 */     if (entity.getChecklistItems() != null) {
/* 159 */       Set<ChecklistItem> set = checklistItemDTOListToChecklistItemSet(dto.getChecklistItems());
/* 160 */       if (set != null) {
/* 161 */         entity.getChecklistItems().clear();
/* 162 */         entity.getChecklistItems().addAll(set);
/*     */       } 
/*     */     } else {
/*     */       
/* 166 */       Set<ChecklistItem> set = checklistItemDTOListToChecklistItemSet(dto.getChecklistItems());
/* 167 */       if (set != null) {
/* 168 */         entity.checklistItems(set);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ChecklistDTO toDto(Checklist s) {
/* 175 */     if (s == null) {
/* 176 */       return null;
/*     */     }
/*     */     
/* 179 */     ChecklistDTO checklistDTO = new ChecklistDTO();
/*     */     
/* 181 */     checklistDTO.setChecklistModel(toDtoChecklistModelId(s.getChecklistModel()));
/* 182 */     checklistDTO.setId(s.getId());
/* 183 */     checklistDTO.setTitle(s.getTitle());
/* 184 */     checklistDTO.setDescription(s.getDescription());
/* 185 */     checklistDTO.setValidatorRole(s.getValidatorRole());
/* 186 */     checklistDTO.setValidator(s.getValidator());
/* 187 */     checklistDTO.setValidatorCheck(s.getValidatorCheck());
/* 188 */     checklistDTO.setValidatorRole2(s.getValidatorRole2());
/* 189 */     checklistDTO.setValidator2(s.getValidator2());
/* 190 */     checklistDTO.setValidator2Check(s.getValidator2Check());
/* 191 */     checklistDTO.setValidatorRole3(s.getValidatorRole3());
/* 192 */     checklistDTO.setValidator3(s.getValidator3());
/* 193 */     checklistDTO.setValidator3Check(s.getValidator3Check());
/* 194 */     checklistDTO.setValidatorRole4(s.getValidatorRole4());
/* 195 */     checklistDTO.setValidator4(s.getValidator4());
/* 196 */     checklistDTO.setValidator4Check(s.getValidator4Check());
/* 197 */     checklistDTO.setStatus(s.getStatus());
/* 198 */     checklistDTO.setCreatedBy(s.getCreatedBy());
/* 199 */     checklistDTO.setCreatedDate(s.getCreatedDate());
/* 200 */     checklistDTO.setLastModifiedBy(s.getLastModifiedBy());
/* 201 */     checklistDTO.setLastModifiedDate(s.getLastModifiedDate());
/* 202 */     checklistDTO.setChecklistItems(checklistItemSetToChecklistItemDTOList(s.getChecklistItems()));
/*     */     
/* 204 */     return checklistDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChecklistModelDTO toDtoChecklistModelId(ChecklistModel checklistModel) {
/* 209 */     if (checklistModel == null) {
/* 210 */       return null;
/*     */     }
/*     */     
/* 213 */     ChecklistModelDTO checklistModelDTO = new ChecklistModelDTO();
/*     */     
/* 215 */     checklistModelDTO.setId(checklistModel.getId());
/*     */     
/* 217 */     return checklistModelDTO;
/*     */   }
/*     */   
/*     */   protected ChecklistModel checklistModelDTOToChecklistModel(ChecklistModelDTO checklistModelDTO) {
/* 221 */     if (checklistModelDTO == null) {
/* 222 */       return null;
/*     */     }
/*     */     
/* 225 */     ChecklistModel checklistModel = new ChecklistModel();
/*     */     
/* 227 */     checklistModel.createdBy(checklistModelDTO.getCreatedBy());
/* 228 */     checklistModel.createdDate(checklistModelDTO.getCreatedDate());
/* 229 */     checklistModel.lastModifiedBy(checklistModelDTO.getLastModifiedBy());
/* 230 */     checklistModel.lastModifiedDate(checklistModelDTO.getLastModifiedDate());
/* 231 */     checklistModel.setId(checklistModelDTO.getId());
/* 232 */     checklistModel.setTitle(checklistModelDTO.getTitle());
/* 233 */     checklistModel.setDescription(checklistModelDTO.getDescription());
/* 234 */     checklistModel.setValidator(checklistModelDTO.getValidator());
/* 235 */     checklistModel.setValidator2(checklistModelDTO.getValidator2());
/* 236 */     checklistModel.setValidator3(checklistModelDTO.getValidator3());
/* 237 */     checklistModel.setValidator4(checklistModelDTO.getValidator4());
/*     */     
/* 239 */     return checklistModel;
/*     */   }
/*     */   
/*     */   protected ChecklistItem checklistItemDTOToChecklistItem(ChecklistItemDTO checklistItemDTO) {
/* 243 */     if (checklistItemDTO == null) {
/* 244 */       return null;
/*     */     }
/*     */     
/* 247 */     ChecklistItem checklistItem = new ChecklistItem();
/*     */     
/* 249 */     checklistItem.createdBy(checklistItemDTO.getCreatedBy());
/* 250 */     checklistItem.createdDate(checklistItemDTO.getCreatedDate());
/* 251 */     checklistItem.lastModifiedBy(checklistItemDTO.getLastModifiedBy());
/* 252 */     checklistItem.lastModifiedDate(checklistItemDTO.getLastModifiedDate());
/* 253 */     checklistItem.setId(checklistItemDTO.getId());
/* 254 */     checklistItem.setText(checklistItemDTO.getText());
/* 255 */     checklistItem.setItemGroup(checklistItemDTO.getItemGroup());
/* 256 */     checklistItem.setValidatorRole(checklistItemDTO.getValidatorRole());
/* 257 */     checklistItem.setValidator(checklistItemDTO.getValidator());
/* 258 */     checklistItem.setIsChecked(checklistItemDTO.getIsChecked());
/*     */     
/* 260 */     return checklistItem;
/*     */   }
/*     */   
/*     */   protected Set<ChecklistItem> checklistItemDTOListToChecklistItemSet(List<ChecklistItemDTO> list) {
/* 264 */     if (list == null) {
/* 265 */       return null;
/*     */     }
/*     */     
/* 268 */     Set<ChecklistItem> set = new LinkedHashSet<>(Math.max((int)(list.size() / 0.75F) + 1, 16));
/* 269 */     for (ChecklistItemDTO checklistItemDTO : list) {
/* 270 */       set.add(checklistItemDTOToChecklistItem(checklistItemDTO));
/*     */     }
/*     */     
/* 273 */     return set;
/*     */   }
/*     */   
/*     */   protected void checklistModelDTOToChecklistModel1(ChecklistModelDTO checklistModelDTO, ChecklistModel mappingTarget) {
/* 277 */     if (checklistModelDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 281 */     if (checklistModelDTO.getCreatedBy() != null) {
/* 282 */       mappingTarget.createdBy(checklistModelDTO.getCreatedBy());
/*     */     }
/* 284 */     if (checklistModelDTO.getCreatedDate() != null) {
/* 285 */       mappingTarget.createdDate(checklistModelDTO.getCreatedDate());
/*     */     }
/* 287 */     if (checklistModelDTO.getLastModifiedBy() != null) {
/* 288 */       mappingTarget.lastModifiedBy(checklistModelDTO.getLastModifiedBy());
/*     */     }
/* 290 */     if (checklistModelDTO.getLastModifiedDate() != null) {
/* 291 */       mappingTarget.lastModifiedDate(checklistModelDTO.getLastModifiedDate());
/*     */     }
/* 293 */     if (checklistModelDTO.getId() != null) {
/* 294 */       mappingTarget.setId(checklistModelDTO.getId());
/*     */     }
/* 296 */     if (checklistModelDTO.getTitle() != null) {
/* 297 */       mappingTarget.setTitle(checklistModelDTO.getTitle());
/*     */     }
/* 299 */     if (checklistModelDTO.getDescription() != null) {
/* 300 */       mappingTarget.setDescription(checklistModelDTO.getDescription());
/*     */     }
/* 302 */     if (checklistModelDTO.getValidator() != null) {
/* 303 */       mappingTarget.setValidator(checklistModelDTO.getValidator());
/*     */     }
/* 305 */     if (checklistModelDTO.getValidator2() != null) {
/* 306 */       mappingTarget.setValidator2(checklistModelDTO.getValidator2());
/*     */     }
/* 308 */     if (checklistModelDTO.getValidator3() != null) {
/* 309 */       mappingTarget.setValidator3(checklistModelDTO.getValidator3());
/*     */     }
/* 311 */     if (checklistModelDTO.getValidator4() != null) {
/* 312 */       mappingTarget.setValidator4(checklistModelDTO.getValidator4());
/*     */     }
/*     */   }
/*     */   
/*     */   protected ChecklistItemDTO checklistItemToChecklistItemDTO(ChecklistItem checklistItem) {
/* 317 */     if (checklistItem == null) {
/* 318 */       return null;
/*     */     }
/*     */     
/* 321 */     ChecklistItemDTO checklistItemDTO = new ChecklistItemDTO();
/*     */     
/* 323 */     checklistItemDTO.setId(checklistItem.getId());
/* 324 */     checklistItemDTO.setText(checklistItem.getText());
/* 325 */     checklistItemDTO.setItemGroup(checklistItem.getItemGroup());
/* 326 */     checklistItemDTO.setValidatorRole(checklistItem.getValidatorRole());
/* 327 */     checklistItemDTO.setValidator(checklistItem.getValidator());
/* 328 */     checklistItemDTO.setIsChecked(checklistItem.getIsChecked());
/* 329 */     checklistItemDTO.setCreatedBy(checklistItem.getCreatedBy());
/* 330 */     checklistItemDTO.setCreatedDate(checklistItem.getCreatedDate());
/* 331 */     checklistItemDTO.setLastModifiedBy(checklistItem.getLastModifiedBy());
/* 332 */     checklistItemDTO.setLastModifiedDate(checklistItem.getLastModifiedDate());
/*     */     
/* 334 */     return checklistItemDTO;
/*     */   }
/*     */   
/*     */   protected List<ChecklistItemDTO> checklistItemSetToChecklistItemDTOList(Set<ChecklistItem> set) {
/* 338 */     if (set == null) {
/* 339 */       return null;
/*     */     }
/*     */     
/* 342 */     List<ChecklistItemDTO> list = new ArrayList<>(set.size());
/* 343 */     for (ChecklistItem checklistItem : set) {
/* 344 */       list.add(checklistItemToChecklistItemDTO(checklistItem));
/*     */     }
/*     */     
/* 347 */     return list;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\ChecklistMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */