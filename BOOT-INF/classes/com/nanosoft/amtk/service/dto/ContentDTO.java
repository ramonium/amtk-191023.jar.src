/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Lob;
/*     */ import javax.validation.constraints.Size;
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
/*     */ public class ContentDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   @Lob
/*     */   private byte[] data;
/*     */   private String dataContentType;
/*     */   @Size(max = 50)
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   
/*     */   public Long getId() {
/*  33 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  37 */     this.id = id;
/*     */   }
/*     */   
/*     */   public byte[] getData() {
/*  41 */     return this.data;
/*     */   }
/*     */   
/*     */   public void setData(byte[] data) {
/*  45 */     this.data = data;
/*     */   }
/*     */   
/*     */   public String getDataContentType() {
/*  49 */     return this.dataContentType;
/*     */   }
/*     */   
/*     */   public void setDataContentType(String dataContentType) {
/*  53 */     this.dataContentType = dataContentType;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/*  57 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/*  61 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/*  65 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/*  69 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/*  73 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/*  77 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/*  81 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/*  85 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  90 */     if (this == o) {
/*  91 */       return true;
/*     */     }
/*  93 */     if (!(o instanceof com.nanosoft.amtk.service.dto.ContentDTO)) {
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     com.nanosoft.amtk.service.dto.ContentDTO contentDTO = (com.nanosoft.amtk.service.dto.ContentDTO)o;
/*  98 */     if (this.id == null) {
/*  99 */       return false;
/*     */     }
/* 101 */     return Objects.equals(this.id, contentDTO.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 106 */     return Objects.hash(new Object[] { this.id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 113 */     return "ContentDTO{id=" + getId() + ", data='" + 
/* 114 */       getData() + "', createdBy='" + 
/* 115 */       getCreatedBy() + "', createdDate='" + 
/* 116 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 117 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 118 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\ContentDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */