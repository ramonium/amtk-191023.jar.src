/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*     */ 
/*     */ import com.nanosoft.amtk.service.dto.SkillsMatrixDTO;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import java.util.Objects;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import javax.validation.constraints.Pattern;
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
/*     */ public class ProjectDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   @NotNull
/*     */   private String name;
/*     */   private String customer;
/*     */   @NotNull
/*     */   private Boolean safety;
/*     */   @Pattern(regexp = "([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?")
/*     */   private String qualificationAfter;
/*     */   @Pattern(regexp = "([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?")
/*     */   private String decertifyAfter;
/*     */   private String description;
/*     */   @Size(max = 50)
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   private SkillsMatrixDTO skillsMatrix;
/*     */   
/*     */   public Long getId() {
/*  45 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  49 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  53 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  57 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getCustomer() {
/*  61 */     return this.customer;
/*     */   }
/*     */   
/*     */   public void setCustomer(String customer) {
/*  65 */     this.customer = customer;
/*     */   }
/*     */   
/*     */   public Boolean getSafety() {
/*  69 */     return this.safety;
/*     */   }
/*     */   
/*     */   public void setSafety(Boolean safety) {
/*  73 */     this.safety = safety;
/*     */   }
/*     */   
/*     */   public String getQualificationAfter() {
/*  77 */     return this.qualificationAfter;
/*     */   }
/*     */   
/*     */   public void setQualificationAfter(String qualificationAfter) {
/*  81 */     this.qualificationAfter = qualificationAfter;
/*     */   }
/*     */   
/*     */   public String getDecertifyAfter() {
/*  85 */     return this.decertifyAfter;
/*     */   }
/*     */   
/*     */   public void setDecertifyAfter(String decertifyAfter) {
/*  89 */     this.decertifyAfter = decertifyAfter;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  93 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  97 */     this.description = description;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/* 101 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/* 105 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/* 109 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/* 113 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/* 117 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/* 121 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/* 125 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/* 129 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public SkillsMatrixDTO getSkillsMatrix() {
/* 133 */     return this.skillsMatrix;
/*     */   }
/*     */   
/*     */   public void setSkillsMatrix(SkillsMatrixDTO skillsMatrix) {
/* 137 */     this.skillsMatrix = skillsMatrix;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 142 */     if (this == o) {
/* 143 */       return true;
/*     */     }
/* 145 */     if (!(o instanceof com.nanosoft.amtk.service.dto.ProjectDTO)) {
/* 146 */       return false;
/*     */     }
/*     */     
/* 149 */     com.nanosoft.amtk.service.dto.ProjectDTO projectDTO = (com.nanosoft.amtk.service.dto.ProjectDTO)o;
/* 150 */     if (this.id == null) {
/* 151 */       return false;
/*     */     }
/* 153 */     return Objects.equals(this.id, projectDTO.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 158 */     return Objects.hash(new Object[] { this.id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 165 */     return "ProjectDTO{id=" + getId() + ", name='" + 
/* 166 */       getName() + "', customer='" + 
/* 167 */       getCustomer() + "', safety='" + 
/* 168 */       getSafety() + "', qualificationAfter='" + 
/* 169 */       getQualificationAfter() + "', decertifyAfter='" + 
/* 170 */       getDecertifyAfter() + "', description='" + 
/* 171 */       getDescription() + "', createdBy='" + 
/* 172 */       getCreatedBy() + "', createdDate='" + 
/* 173 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 174 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 175 */       getLastModifiedDate() + "', skillsMatrix=" + 
/* 176 */       getSkillsMatrix() + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\ProjectDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */