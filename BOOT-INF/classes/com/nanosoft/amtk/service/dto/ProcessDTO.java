/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import java.util.Objects;
/*     */ import javax.validation.constraints.NotNull;
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
/*     */ public class ProcessDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   @NotNull
/*     */   private String name;
/*     */   private String description;
/*     */   @Size(max = 50)
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   
/*     */   public Long getId() {
/*  32 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  36 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  40 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  44 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  48 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  52 */     this.description = description;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/*  56 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/*  60 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/*  64 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/*  68 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/*  72 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/*  76 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/*  80 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/*  84 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  89 */     if (this == o) {
/*  90 */       return true;
/*     */     }
/*  92 */     if (!(o instanceof com.nanosoft.amtk.service.dto.ProcessDTO)) {
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     com.nanosoft.amtk.service.dto.ProcessDTO processDTO = (com.nanosoft.amtk.service.dto.ProcessDTO)o;
/*  97 */     if (this.id == null) {
/*  98 */       return false;
/*     */     }
/* 100 */     return Objects.equals(this.id, processDTO.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 105 */     return Objects.hash(new Object[] { this.id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 112 */     return "ProcessDTO{id=" + getId() + ", name='" + 
/* 113 */       getName() + "', description='" + 
/* 114 */       getDescription() + "', createdBy='" + 
/* 115 */       getCreatedBy() + "', createdDate='" + 
/* 116 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 117 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 118 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\ProcessDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */