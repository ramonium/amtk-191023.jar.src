/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.EmployeeTitle;
/*     */ import com.nanosoft.amtk.service.dto.EmployeeTitleDTO;
/*     */ import com.nanosoft.amtk.service.mapper.EmployeeTitleMapper;
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
/*     */ public class EmployeeTitleMapperImpl
/*     */   implements EmployeeTitleMapper
/*     */ {
/*     */   public EmployeeTitle toEntity(EmployeeTitleDTO dto) {
/*  20 */     if (dto == null) {
/*  21 */       return null;
/*     */     }
/*     */     
/*  24 */     EmployeeTitle employeeTitle = new EmployeeTitle();
/*     */     
/*  26 */     employeeTitle.createdBy(dto.getCreatedBy());
/*  27 */     employeeTitle.createdDate(dto.getCreatedDate());
/*  28 */     employeeTitle.lastModifiedBy(dto.getLastModifiedBy());
/*  29 */     employeeTitle.lastModifiedDate(dto.getLastModifiedDate());
/*  30 */     employeeTitle.setId(dto.getId());
/*  31 */     employeeTitle.setName(dto.getName());
/*  32 */     employeeTitle.setDescription(dto.getDescription());
/*  33 */     employeeTitle.setCanSupervise(dto.getCanSupervise());
/*     */     
/*  35 */     return employeeTitle;
/*     */   }
/*     */ 
/*     */   
/*     */   public EmployeeTitleDTO toDto(EmployeeTitle entity) {
/*  40 */     if (entity == null) {
/*  41 */       return null;
/*     */     }
/*     */     
/*  44 */     EmployeeTitleDTO employeeTitleDTO = new EmployeeTitleDTO();
/*     */     
/*  46 */     employeeTitleDTO.setId(entity.getId());
/*  47 */     employeeTitleDTO.setName(entity.getName());
/*  48 */     employeeTitleDTO.setDescription(entity.getDescription());
/*  49 */     employeeTitleDTO.setCanSupervise(entity.getCanSupervise());
/*  50 */     employeeTitleDTO.setCreatedBy(entity.getCreatedBy());
/*  51 */     employeeTitleDTO.setCreatedDate(entity.getCreatedDate());
/*  52 */     employeeTitleDTO.setLastModifiedBy(entity.getLastModifiedBy());
/*  53 */     employeeTitleDTO.setLastModifiedDate(entity.getLastModifiedDate());
/*     */     
/*  55 */     return employeeTitleDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<EmployeeTitle> toEntity(List<EmployeeTitleDTO> dtoList) {
/*  60 */     if (dtoList == null) {
/*  61 */       return null;
/*     */     }
/*     */     
/*  64 */     List<EmployeeTitle> list = new ArrayList<>(dtoList.size());
/*  65 */     for (EmployeeTitleDTO employeeTitleDTO : dtoList) {
/*  66 */       list.add(toEntity(employeeTitleDTO));
/*     */     }
/*     */     
/*  69 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<EmployeeTitleDTO> toDto(List<EmployeeTitle> entityList) {
/*  74 */     if (entityList == null) {
/*  75 */       return null;
/*     */     }
/*     */     
/*  78 */     List<EmployeeTitleDTO> list = new ArrayList<>(entityList.size());
/*  79 */     for (EmployeeTitle employeeTitle : entityList) {
/*  80 */       list.add(toDto(employeeTitle));
/*     */     }
/*     */     
/*  83 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(EmployeeTitle entity, EmployeeTitleDTO dto) {
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
/* 107 */     if (dto.getName() != null) {
/* 108 */       entity.setName(dto.getName());
/*     */     }
/* 110 */     if (dto.getDescription() != null) {
/* 111 */       entity.setDescription(dto.getDescription());
/*     */     }
/* 113 */     if (dto.getCanSupervise() != null)
/* 114 */       entity.setCanSupervise(dto.getCanSupervise()); 
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\EmployeeTitleMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */