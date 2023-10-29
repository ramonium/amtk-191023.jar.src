/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*     */ 
/*     */ import com.nanosoft.amtk.service.dto.CertificateDTO;
/*     */ import com.nanosoft.amtk.service.dto.EmployeeDTO;
/*     */ import com.nanosoft.amtk.service.dto.WorkstationDTO;
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
/*     */ public class AssignmentDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   @NotNull
/*     */   private Instant assignmentStart;
/*     */   private Instant assignmentEnd;
/*     */   private String description;
/*     */   @Size(max = 50)
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   private WorkstationDTO workstation;
/*     */   private EmployeeDTO employee;
/*     */   private CertificateDTO currentCertificate;
/*     */   
/*     */   public Long getId() {
/*  40 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  44 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Instant getAssignmentStart() {
/*  48 */     return this.assignmentStart;
/*     */   }
/*     */   
/*     */   public void setAssignmentStart(Instant assignmentStart) {
/*  52 */     this.assignmentStart = assignmentStart;
/*     */   }
/*     */   
/*     */   public Instant getAssignmentEnd() {
/*  56 */     return this.assignmentEnd;
/*     */   }
/*     */   
/*     */   public void setAssignmentEnd(Instant assignmentEnd) {
/*  60 */     this.assignmentEnd = assignmentEnd;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  64 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  68 */     this.description = description;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/*  72 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/*  76 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/*  80 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/*  84 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/*  88 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/*  92 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/*  96 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/* 100 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public WorkstationDTO getWorkstation() {
/* 104 */     return this.workstation;
/*     */   }
/*     */   
/*     */   public void setWorkstation(WorkstationDTO workstation) {
/* 108 */     this.workstation = workstation;
/*     */   }
/*     */   
/*     */   public EmployeeDTO getEmployee() {
/* 112 */     return this.employee;
/*     */   }
/*     */   
/*     */   public void setEmployee(EmployeeDTO employee) {
/* 116 */     this.employee = employee;
/*     */   }
/*     */   
/*     */   public CertificateDTO getCurrentCertificate() {
/* 120 */     return this.currentCertificate;
/*     */   }
/*     */   
/*     */   public void setCurrentCertificate(CertificateDTO currentCertificate) {
/* 124 */     this.currentCertificate = currentCertificate;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 129 */     if (this == o) {
/* 130 */       return true;
/*     */     }
/* 132 */     if (!(o instanceof com.nanosoft.amtk.service.dto.AssignmentDTO)) {
/* 133 */       return false;
/*     */     }
/*     */     
/* 136 */     com.nanosoft.amtk.service.dto.AssignmentDTO assignmentDTO = (com.nanosoft.amtk.service.dto.AssignmentDTO)o;
/* 137 */     if (this.id == null) {
/* 138 */       return false;
/*     */     }
/* 140 */     return Objects.equals(this.id, assignmentDTO.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 145 */     return Objects.hash(new Object[] { this.id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 152 */     return "AssignmentDTO{id=" + getId() + ", assignmentStart='" + 
/* 153 */       getAssignmentStart() + "', assignmentEnd='" + 
/* 154 */       getAssignmentEnd() + "', description='" + 
/* 155 */       getDescription() + "', createdBy='" + 
/* 156 */       getCreatedBy() + "', createdDate='" + 
/* 157 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 158 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 159 */       getLastModifiedDate() + "', workstation=" + 
/* 160 */       getWorkstation() + ", employee=" + 
/* 161 */       getEmployee() + ", currentCertificate=" + 
/* 162 */       getCurrentCertificate() + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\AssignmentDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */