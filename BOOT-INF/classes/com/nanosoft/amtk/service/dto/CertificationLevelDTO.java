/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*     */ 
/*     */ import com.nanosoft.amtk.service.dto.ChecklistModelDTO;
/*     */ import com.nanosoft.amtk.service.dto.ProcessDTO;
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
/*     */ public class CertificationLevelDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   @NotNull
/*     */   private String level;
/*     */   private Integer orderNumber;
/*     */   @NotNull
/*     */   @Pattern(regexp = "([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?")
/*     */   private String trainingDuration;
/*     */   @NotNull
/*     */   @Pattern(regexp = "([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?")
/*     */   private String recyclingPeriod;
/*     */   private String description;
/*     */   @Size(max = 50)
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   private ProcessDTO process;
/*     */   private ChecklistModelDTO checklistModel;
/*     */   
/*     */   public Long getId() {
/*  46 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  50 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getLevel() {
/*  54 */     return this.level;
/*     */   }
/*     */   
/*     */   public void setLevel(String level) {
/*  58 */     this.level = level;
/*     */   }
/*     */   
/*     */   public Integer getOrderNumber() {
/*  62 */     return this.orderNumber;
/*     */   }
/*     */   
/*     */   public void setOrderNumber(Integer orderNumber) {
/*  66 */     this.orderNumber = orderNumber;
/*     */   }
/*     */   
/*     */   public String getTrainingDuration() {
/*  70 */     return this.trainingDuration;
/*     */   }
/*     */   
/*     */   public void setTrainingDuration(String trainingDuration) {
/*  74 */     this.trainingDuration = trainingDuration;
/*     */   }
/*     */   
/*     */   public String getRecyclingPeriod() {
/*  78 */     return this.recyclingPeriod;
/*     */   }
/*     */   
/*     */   public void setRecyclingPeriod(String recyclingPeriod) {
/*  82 */     this.recyclingPeriod = recyclingPeriod;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  86 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  90 */     this.description = description;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/*  94 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/*  98 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/* 102 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/* 106 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/* 110 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/* 114 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/* 118 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/* 122 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public ProcessDTO getProcess() {
/* 126 */     return this.process;
/*     */   }
/*     */   
/*     */   public void setProcess(ProcessDTO process) {
/* 130 */     this.process = process;
/*     */   }
/*     */   
/*     */   public ChecklistModelDTO getChecklistModel() {
/* 134 */     return this.checklistModel;
/*     */   }
/*     */   
/*     */   public void setChecklistModel(ChecklistModelDTO checklistModel) {
/* 138 */     this.checklistModel = checklistModel;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 143 */     if (this == o) {
/* 144 */       return true;
/*     */     }
/* 146 */     if (!(o instanceof com.nanosoft.amtk.service.dto.CertificationLevelDTO)) {
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     com.nanosoft.amtk.service.dto.CertificationLevelDTO certificationLevelDTO = (com.nanosoft.amtk.service.dto.CertificationLevelDTO)o;
/* 151 */     if (this.id == null) {
/* 152 */       return false;
/*     */     }
/* 154 */     return Objects.equals(this.id, certificationLevelDTO.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 159 */     return Objects.hash(new Object[] { this.id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 166 */     return "CertificationLevelDTO{id=" + getId() + ", level='" + 
/* 167 */       getLevel() + "', orderNumber=" + 
/* 168 */       getOrderNumber() + ", trainingDuration='" + 
/* 169 */       getTrainingDuration() + "', recyclingPeriod='" + 
/* 170 */       getRecyclingPeriod() + "', description='" + 
/* 171 */       getDescription() + "', createdBy='" + 
/* 172 */       getCreatedBy() + "', createdDate='" + 
/* 173 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 174 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 175 */       getLastModifiedDate() + "', process=" + 
/* 176 */       getProcess() + ", checklistModel=" + 
/* 177 */       getChecklistModel() + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\CertificationLevelDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */