/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*     */ 
/*     */ import com.nanosoft.amtk.service.dto.ProjectDTO;
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
/*     */ public class AreaDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   @NotNull
/*     */   private String name;
/*     */   private String description;
/*     */   private Integer orderNumber;
/*     */   @Size(max = 50)
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   private ProjectDTO project;
/*     */   
/*     */   public Long getId() {
/*  36 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  40 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  44 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  48 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  52 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  56 */     this.description = description;
/*     */   }
/*     */   
/*     */   public Integer getOrderNumber() {
/*  60 */     return this.orderNumber;
/*     */   }
/*     */   
/*     */   public void setOrderNumber(Integer orderNumber) {
/*  64 */     this.orderNumber = orderNumber;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/*  68 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/*  72 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/*  76 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/*  80 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/*  84 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/*  88 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/*  92 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/*  96 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public ProjectDTO getProject() {
/* 100 */     return this.project;
/*     */   }
/*     */   
/*     */   public void setProject(ProjectDTO project) {
/* 104 */     this.project = project;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 109 */     if (this == o) {
/* 110 */       return true;
/*     */     }
/* 112 */     if (!(o instanceof com.nanosoft.amtk.service.dto.AreaDTO)) {
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     com.nanosoft.amtk.service.dto.AreaDTO areaDTO = (com.nanosoft.amtk.service.dto.AreaDTO)o;
/* 117 */     if (this.id == null) {
/* 118 */       return false;
/*     */     }
/* 120 */     return Objects.equals(this.id, areaDTO.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 125 */     return Objects.hash(new Object[] { this.id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 132 */     return "AreaDTO{id=" + getId() + ", name='" + 
/* 133 */       getName() + "', description='" + 
/* 134 */       getDescription() + "', orderNumber=" + 
/* 135 */       getOrderNumber() + ", createdBy='" + 
/* 136 */       getCreatedBy() + "', createdDate='" + 
/* 137 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 138 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 139 */       getLastModifiedDate() + "', project=" + 
/* 140 */       getProject() + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\AreaDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */