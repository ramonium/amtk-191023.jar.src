/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Content;
/*     */ import com.nanosoft.amtk.service.dto.ContentDTO;
/*     */ import com.nanosoft.amtk.service.mapper.ContentMapper;
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
/*     */ public class ContentMapperImpl
/*     */   implements ContentMapper
/*     */ {
/*     */   public Content toEntity(ContentDTO dto) {
/*  21 */     if (dto == null) {
/*  22 */       return null;
/*     */     }
/*     */     
/*  25 */     Content content = new Content();
/*     */     
/*  27 */     content.createdBy(dto.getCreatedBy());
/*  28 */     content.createdDate(dto.getCreatedDate());
/*  29 */     content.lastModifiedBy(dto.getLastModifiedBy());
/*  30 */     content.lastModifiedDate(dto.getLastModifiedDate());
/*  31 */     content.setId(dto.getId());
/*  32 */     byte[] data = dto.getData();
/*  33 */     if (data != null) {
/*  34 */       content.setData(Arrays.copyOf(data, data.length));
/*     */     }
/*  36 */     content.setDataContentType(dto.getDataContentType());
/*     */     
/*  38 */     return content;
/*     */   }
/*     */ 
/*     */   
/*     */   public ContentDTO toDto(Content entity) {
/*  43 */     if (entity == null) {
/*  44 */       return null;
/*     */     }
/*     */     
/*  47 */     ContentDTO contentDTO = new ContentDTO();
/*     */     
/*  49 */     contentDTO.setId(entity.getId());
/*  50 */     byte[] data = entity.getData();
/*  51 */     if (data != null) {
/*  52 */       contentDTO.setData(Arrays.copyOf(data, data.length));
/*     */     }
/*  54 */     contentDTO.setDataContentType(entity.getDataContentType());
/*  55 */     contentDTO.setCreatedBy(entity.getCreatedBy());
/*  56 */     contentDTO.setCreatedDate(entity.getCreatedDate());
/*  57 */     contentDTO.setLastModifiedBy(entity.getLastModifiedBy());
/*  58 */     contentDTO.setLastModifiedDate(entity.getLastModifiedDate());
/*     */     
/*  60 */     return contentDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Content> toEntity(List<ContentDTO> dtoList) {
/*  65 */     if (dtoList == null) {
/*  66 */       return null;
/*     */     }
/*     */     
/*  69 */     List<Content> list = new ArrayList<>(dtoList.size());
/*  70 */     for (ContentDTO contentDTO : dtoList) {
/*  71 */       list.add(toEntity(contentDTO));
/*     */     }
/*     */     
/*  74 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ContentDTO> toDto(List<Content> entityList) {
/*  79 */     if (entityList == null) {
/*  80 */       return null;
/*     */     }
/*     */     
/*  83 */     List<ContentDTO> list = new ArrayList<>(entityList.size());
/*  84 */     for (Content content : entityList) {
/*  85 */       list.add(toDto(content));
/*     */     }
/*     */     
/*  88 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(Content entity, ContentDTO dto) {
/*  93 */     if (dto == null) {
/*     */       return;
/*     */     }
/*     */     
/*  97 */     if (dto.getCreatedBy() != null) {
/*  98 */       entity.createdBy(dto.getCreatedBy());
/*     */     }
/* 100 */     if (dto.getCreatedDate() != null) {
/* 101 */       entity.createdDate(dto.getCreatedDate());
/*     */     }
/* 103 */     if (dto.getLastModifiedBy() != null) {
/* 104 */       entity.lastModifiedBy(dto.getLastModifiedBy());
/*     */     }
/* 106 */     if (dto.getLastModifiedDate() != null) {
/* 107 */       entity.lastModifiedDate(dto.getLastModifiedDate());
/*     */     }
/* 109 */     if (dto.getId() != null) {
/* 110 */       entity.setId(dto.getId());
/*     */     }
/* 112 */     byte[] data = dto.getData();
/* 113 */     if (data != null) {
/* 114 */       entity.setData(Arrays.copyOf(data, data.length));
/*     */     }
/* 116 */     if (dto.getDataContentType() != null)
/* 117 */       entity.setDataContentType(dto.getDataContentType()); 
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\ContentMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */