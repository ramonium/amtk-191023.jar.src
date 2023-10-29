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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChecklistModelDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   @NotNull
/*     */   private String title;
/*     */   private String description;
/*     */   @NotNull
/*     */   private String validator;
/*     */   private String validator2;
/*     */   private String validator3;
/*     */   private String validator4;
/*     */   @Size(max = 50)
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   
/*     */   public Long getId() {
/*  41 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  45 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getTitle() {
/*  49 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/*  53 */     this.title = title;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  57 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  61 */     this.description = description;
/*     */   }
/*     */   
/*     */   public String getValidator() {
/*  65 */     return this.validator;
/*     */   }
/*     */   
/*     */   public void setValidator(String validator) {
/*  69 */     this.validator = validator;
/*     */   }
/*     */   
/*     */   public String getValidator2() {
/*  73 */     return this.validator2;
/*     */   }
/*     */   
/*     */   public void setValidator2(String validator2) {
/*  77 */     this.validator2 = validator2;
/*     */   }
/*     */   
/*     */   public String getValidator3() {
/*  81 */     return this.validator3;
/*     */   }
/*     */   
/*     */   public void setValidator3(String validator3) {
/*  85 */     this.validator3 = validator3;
/*     */   }
/*     */   
/*     */   public String getValidator4() {
/*  89 */     return this.validator4;
/*     */   }
/*     */   
/*     */   public void setValidator4(String validator4) {
/*  93 */     this.validator4 = validator4;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/*  97 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/* 101 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/* 105 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/* 109 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/* 113 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/* 117 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/* 121 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/* 125 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 130 */     if (this == o) {
/* 131 */       return true;
/*     */     }
/* 133 */     if (!(o instanceof com.nanosoft.amtk.service.dto.ChecklistModelDTO)) {
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     com.nanosoft.amtk.service.dto.ChecklistModelDTO checklistModelDTO = (com.nanosoft.amtk.service.dto.ChecklistModelDTO)o;
/* 138 */     if (this.id == null) {
/* 139 */       return false;
/*     */     }
/* 141 */     return Objects.equals(this.id, checklistModelDTO.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 146 */     return Objects.hash(new Object[] { this.id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 153 */     return "ChecklistModelDTO{id=" + getId() + ", title='" + 
/* 154 */       getTitle() + "', description='" + 
/* 155 */       getDescription() + "', validator='" + 
/* 156 */       getValidator() + "', validator2='" + 
/* 157 */       getValidator2() + "', validator3='" + 
/* 158 */       getValidator3() + "', validator4='" + 
/* 159 */       getValidator4() + "', createdBy='" + 
/* 160 */       getCreatedBy() + "', createdDate='" + 
/* 161 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 162 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 163 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\ChecklistModelDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */