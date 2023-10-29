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
/*     */ public class EmployeeTitleDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   @NotNull
/*     */   private String name;
/*     */   private String description;
/*     */   private Boolean canSupervise;
/*     */   @Size(max = 50)
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   
/*     */   public Long getId() {
/*  34 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  38 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  42 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  46 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  50 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  54 */     this.description = description;
/*     */   }
/*     */   
/*     */   public Boolean getCanSupervise() {
/*  58 */     return this.canSupervise;
/*     */   }
/*     */   
/*     */   public void setCanSupervise(Boolean canSupervise) {
/*  62 */     this.canSupervise = canSupervise;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/*  66 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/*  70 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/*  74 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/*  78 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/*  82 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/*  86 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/*  90 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/*  94 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  99 */     if (this == o) {
/* 100 */       return true;
/*     */     }
/* 102 */     if (!(o instanceof com.nanosoft.amtk.service.dto.EmployeeTitleDTO)) {
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     com.nanosoft.amtk.service.dto.EmployeeTitleDTO employeeTitleDTO = (com.nanosoft.amtk.service.dto.EmployeeTitleDTO)o;
/* 107 */     if (this.id == null) {
/* 108 */       return false;
/*     */     }
/* 110 */     return Objects.equals(this.id, employeeTitleDTO.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 115 */     return Objects.hash(new Object[] { this.id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 122 */     return "EmployeeTitleDTO{id=" + getId() + ", name='" + 
/* 123 */       getName() + "', description='" + 
/* 124 */       getDescription() + "', canSupervise='" + 
/* 125 */       getCanSupervise() + "', createdBy='" + 
/* 126 */       getCreatedBy() + "', createdDate='" + 
/* 127 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 128 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 129 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\EmployeeTitleDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */