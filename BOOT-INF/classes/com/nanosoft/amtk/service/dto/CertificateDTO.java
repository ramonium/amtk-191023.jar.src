/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.enumeration.CertificationStatus;
/*     */ import com.nanosoft.amtk.service.dto.AssignmentDTO;
/*     */ import com.nanosoft.amtk.service.dto.CertificationLevelDTO;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistDTO;
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
/*     */ public class CertificateDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   private CertificationStatus status;
/*     */   @NotNull
/*     */   private Instant startDate;
/*     */   @NotNull
/*     */   private Instant expectedEndDate;
/*     */   private Instant endDate;
/*     */   private Boolean validated;
/*     */   private Boolean isRecycling;
/*     */   @Size(max = 50)
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   private AssignmentDTO assignment;
/*     */   private CertificationLevelDTO level;
/*     */   private ChecklistDTO checklist;
/*     */   
/*     */   public Long getId() {
/*  48 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  52 */     this.id = id;
/*     */   }
/*     */   
/*     */   public CertificationStatus getStatus() {
/*  56 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(CertificationStatus status) {
/*  60 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Instant getStartDate() {
/*  64 */     return this.startDate;
/*     */   }
/*     */   
/*     */   public void setStartDate(Instant startDate) {
/*  68 */     this.startDate = startDate;
/*     */   }
/*     */   
/*     */   public Instant getExpectedEndDate() {
/*  72 */     return this.expectedEndDate;
/*     */   }
/*     */   
/*     */   public void setExpectedEndDate(Instant expectedEndDate) {
/*  76 */     this.expectedEndDate = expectedEndDate;
/*     */   }
/*     */   
/*     */   public Instant getEndDate() {
/*  80 */     return this.endDate;
/*     */   }
/*     */   
/*     */   public void setEndDate(Instant endDate) {
/*  84 */     this.endDate = endDate;
/*     */   }
/*     */   
/*     */   public Boolean getValidated() {
/*  88 */     return this.validated;
/*     */   }
/*     */   
/*     */   public void setValidated(Boolean validated) {
/*  92 */     this.validated = validated;
/*     */   }
/*     */   
/*     */   public Boolean getIsRecycling() {
/*  96 */     return this.isRecycling;
/*     */   }
/*     */   
/*     */   public void setIsRecycling(Boolean isRecycling) {
/* 100 */     this.isRecycling = isRecycling;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/* 104 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/* 108 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/* 112 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/* 116 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/* 120 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/* 124 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/* 128 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/* 132 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public AssignmentDTO getAssignment() {
/* 136 */     return this.assignment;
/*     */   }
/*     */   
/*     */   public void setAssignment(AssignmentDTO assignment) {
/* 140 */     this.assignment = assignment;
/*     */   }
/*     */   
/*     */   public CertificationLevelDTO getLevel() {
/* 144 */     return this.level;
/*     */   }
/*     */   
/*     */   public void setLevel(CertificationLevelDTO level) {
/* 148 */     this.level = level;
/*     */   }
/*     */   
/*     */   public ChecklistDTO getChecklist() {
/* 152 */     return this.checklist;
/*     */   }
/*     */   
/*     */   public void setChecklist(ChecklistDTO checklist) {
/* 156 */     this.checklist = checklist;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 161 */     if (this == o) {
/* 162 */       return true;
/*     */     }
/* 164 */     if (!(o instanceof com.nanosoft.amtk.service.dto.CertificateDTO)) {
/* 165 */       return false;
/*     */     }
/*     */     
/* 168 */     com.nanosoft.amtk.service.dto.CertificateDTO certificateDTO = (com.nanosoft.amtk.service.dto.CertificateDTO)o;
/* 169 */     if (this.id == null) {
/* 170 */       return false;
/*     */     }
/* 172 */     return Objects.equals(this.id, certificateDTO.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 177 */     return Objects.hash(new Object[] { this.id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 184 */     return "CertificateDTO{id=" + getId() + ", status='" + 
/* 185 */       getStatus() + "', startDate='" + 
/* 186 */       getStartDate() + "', expectedEndDate='" + 
/* 187 */       getExpectedEndDate() + "', endDate='" + 
/* 188 */       getEndDate() + "', validated='" + 
/* 189 */       getValidated() + "', isRecycling='" + 
/* 190 */       getIsRecycling() + "', createdBy='" + 
/* 191 */       getCreatedBy() + "', createdDate='" + 
/* 192 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 193 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 194 */       getLastModifiedDate() + "', assignment=" + 
/* 195 */       getAssignment() + ", level=" + 
/* 196 */       getLevel() + ", checklist=" + 
/* 197 */       getChecklist() + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\CertificateDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */