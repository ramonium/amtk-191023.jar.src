/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.SkillsMatrix;
/*     */ import com.nanosoft.amtk.service.dto.SkillsMatrixDTO;
/*     */ import com.nanosoft.amtk.service.mapper.SkillsMatrixMapper;
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
/*     */ public class SkillsMatrixMapperImpl
/*     */   implements SkillsMatrixMapper
/*     */ {
/*     */   public SkillsMatrix toEntity(SkillsMatrixDTO dto) {
/*  21 */     if (dto == null) {
/*  22 */       return null;
/*     */     }
/*     */     
/*  25 */     SkillsMatrix skillsMatrix = new SkillsMatrix();
/*     */     
/*  27 */     skillsMatrix.createdBy(dto.getCreatedBy());
/*  28 */     skillsMatrix.createdDate(dto.getCreatedDate());
/*  29 */     skillsMatrix.lastModifiedBy(dto.getLastModifiedBy());
/*  30 */     skillsMatrix.lastModifiedDate(dto.getLastModifiedDate());
/*  31 */     skillsMatrix.setId(dto.getId());
/*  32 */     byte[] data = dto.getData();
/*  33 */     if (data != null) {
/*  34 */       skillsMatrix.setData(Arrays.copyOf(data, data.length));
/*     */     }
/*  36 */     skillsMatrix.setDataContentType(dto.getDataContentType());
/*     */     
/*  38 */     return skillsMatrix;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<SkillsMatrix> toEntity(List<SkillsMatrixDTO> dtoList) {
/*  43 */     if (dtoList == null) {
/*  44 */       return null;
/*     */     }
/*     */     
/*  47 */     List<SkillsMatrix> list = new ArrayList<>(dtoList.size());
/*  48 */     for (SkillsMatrixDTO skillsMatrixDTO : dtoList) {
/*  49 */       list.add(toEntity(skillsMatrixDTO));
/*     */     }
/*     */     
/*  52 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<SkillsMatrixDTO> toDto(List<SkillsMatrix> entityList) {
/*  57 */     if (entityList == null) {
/*  58 */       return null;
/*     */     }
/*     */     
/*  61 */     List<SkillsMatrixDTO> list = new ArrayList<>(entityList.size());
/*  62 */     for (SkillsMatrix skillsMatrix : entityList) {
/*  63 */       list.add(toDto(skillsMatrix));
/*     */     }
/*     */     
/*  66 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(SkillsMatrix entity, SkillsMatrixDTO dto) {
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
/*  90 */     byte[] data = dto.getData();
/*  91 */     if (data != null) {
/*  92 */       entity.setData(Arrays.copyOf(data, data.length));
/*     */     }
/*  94 */     if (dto.getDataContentType() != null) {
/*  95 */       entity.setDataContentType(dto.getDataContentType());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public SkillsMatrixDTO toDto(SkillsMatrix s) {
/* 101 */     if (s == null) {
/* 102 */       return null;
/*     */     }
/*     */     
/* 105 */     SkillsMatrixDTO skillsMatrixDTO = new SkillsMatrixDTO();
/*     */     
/* 107 */     skillsMatrixDTO.setId(s.getId());
/* 108 */     byte[] data = s.getData();
/* 109 */     if (data != null) {
/* 110 */       skillsMatrixDTO.setData(Arrays.copyOf(data, data.length));
/*     */     }
/* 112 */     skillsMatrixDTO.setDataContentType(s.getDataContentType());
/* 113 */     skillsMatrixDTO.setCreatedBy(s.getCreatedBy());
/* 114 */     skillsMatrixDTO.setCreatedDate(s.getCreatedDate());
/* 115 */     skillsMatrixDTO.setLastModifiedBy(s.getLastModifiedBy());
/* 116 */     skillsMatrixDTO.setLastModifiedDate(s.getLastModifiedDate());
/*     */     
/* 118 */     return skillsMatrixDTO;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\SkillsMatrixMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */