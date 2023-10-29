/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.criteria;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Objects;
/*     */ import org.springdoc.api.annotations.ParameterObject;
/*     */ import tech.jhipster.service.Criteria;
/*     */ import tech.jhipster.service.filter.InstantFilter;
/*     */ import tech.jhipster.service.filter.LongFilter;
/*     */ import tech.jhipster.service.filter.StringFilter;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ParameterObject
/*     */ public class AssignmentCriteria
/*     */   implements Serializable, Criteria
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private LongFilter id;
/*     */   private InstantFilter assignmentStart;
/*     */   private InstantFilter assignmentEnd;
/*     */   private StringFilter description;
/*     */   private StringFilter createdBy;
/*     */   private InstantFilter createdDate;
/*     */   private StringFilter lastModifiedBy;
/*     */   private InstantFilter lastModifiedDate;
/*     */   private LongFilter certificateId;
/*     */   private LongFilter workstationId;
/*     */   private LongFilter employeeId;
/*     */   private LongFilter currentCertificateId;
/*     */   private Boolean distinct;
/*     */   
/*     */   public AssignmentCriteria() {}
/*     */   
/*     */   public AssignmentCriteria(com.nanosoft.amtk.service.criteria.AssignmentCriteria other) {
/*  53 */     this.id = (other.id == null) ? null : other.id.copy();
/*  54 */     this.assignmentStart = (other.assignmentStart == null) ? null : other.assignmentStart.copy();
/*  55 */     this.assignmentEnd = (other.assignmentEnd == null) ? null : other.assignmentEnd.copy();
/*  56 */     this.description = (other.description == null) ? null : other.description.copy();
/*  57 */     this.createdBy = (other.createdBy == null) ? null : other.createdBy.copy();
/*  58 */     this.createdDate = (other.createdDate == null) ? null : other.createdDate.copy();
/*  59 */     this.lastModifiedBy = (other.lastModifiedBy == null) ? null : other.lastModifiedBy.copy();
/*  60 */     this.lastModifiedDate = (other.lastModifiedDate == null) ? null : other.lastModifiedDate.copy();
/*  61 */     this.certificateId = (other.certificateId == null) ? null : other.certificateId.copy();
/*  62 */     this.workstationId = (other.workstationId == null) ? null : other.workstationId.copy();
/*  63 */     this.employeeId = (other.employeeId == null) ? null : other.employeeId.copy();
/*  64 */     this.currentCertificateId = (other.currentCertificateId == null) ? null : other.currentCertificateId.copy();
/*  65 */     this.distinct = other.distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public com.nanosoft.amtk.service.criteria.AssignmentCriteria copy() {
/*  70 */     return new com.nanosoft.amtk.service.criteria.AssignmentCriteria(this);
/*     */   }
/*     */   
/*     */   public LongFilter getId() {
/*  74 */     return this.id;
/*     */   }
/*     */   
/*     */   public LongFilter id() {
/*  78 */     if (this.id == null) {
/*  79 */       this.id = new LongFilter();
/*     */     }
/*  81 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(LongFilter id) {
/*  85 */     this.id = id;
/*     */   }
/*     */   
/*     */   public InstantFilter getAssignmentStart() {
/*  89 */     return this.assignmentStart;
/*     */   }
/*     */   
/*     */   public InstantFilter assignmentStart() {
/*  93 */     if (this.assignmentStart == null) {
/*  94 */       this.assignmentStart = new InstantFilter();
/*     */     }
/*  96 */     return this.assignmentStart;
/*     */   }
/*     */   
/*     */   public void setAssignmentStart(InstantFilter assignmentStart) {
/* 100 */     this.assignmentStart = assignmentStart;
/*     */   }
/*     */   
/*     */   public InstantFilter getAssignmentEnd() {
/* 104 */     return this.assignmentEnd;
/*     */   }
/*     */   
/*     */   public InstantFilter assignmentEnd() {
/* 108 */     if (this.assignmentEnd == null) {
/* 109 */       this.assignmentEnd = new InstantFilter();
/*     */     }
/* 111 */     return this.assignmentEnd;
/*     */   }
/*     */   
/*     */   public void setAssignmentEnd(InstantFilter assignmentEnd) {
/* 115 */     this.assignmentEnd = assignmentEnd;
/*     */   }
/*     */   
/*     */   public StringFilter getDescription() {
/* 119 */     return this.description;
/*     */   }
/*     */   
/*     */   public StringFilter description() {
/* 123 */     if (this.description == null) {
/* 124 */       this.description = new StringFilter();
/*     */     }
/* 126 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(StringFilter description) {
/* 130 */     this.description = description;
/*     */   }
/*     */   
/*     */   public StringFilter getCreatedBy() {
/* 134 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public StringFilter createdBy() {
/* 138 */     if (this.createdBy == null) {
/* 139 */       this.createdBy = new StringFilter();
/*     */     }
/* 141 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(StringFilter createdBy) {
/* 145 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getCreatedDate() {
/* 149 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public InstantFilter createdDate() {
/* 153 */     if (this.createdDate == null) {
/* 154 */       this.createdDate = new InstantFilter();
/*     */     }
/* 156 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(InstantFilter createdDate) {
/* 160 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public StringFilter getLastModifiedBy() {
/* 164 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public StringFilter lastModifiedBy() {
/* 168 */     if (this.lastModifiedBy == null) {
/* 169 */       this.lastModifiedBy = new StringFilter();
/*     */     }
/* 171 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(StringFilter lastModifiedBy) {
/* 175 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getLastModifiedDate() {
/* 179 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public InstantFilter lastModifiedDate() {
/* 183 */     if (this.lastModifiedDate == null) {
/* 184 */       this.lastModifiedDate = new InstantFilter();
/*     */     }
/* 186 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(InstantFilter lastModifiedDate) {
/* 190 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public LongFilter getCertificateId() {
/* 194 */     return this.certificateId;
/*     */   }
/*     */   
/*     */   public LongFilter certificateId() {
/* 198 */     if (this.certificateId == null) {
/* 199 */       this.certificateId = new LongFilter();
/*     */     }
/* 201 */     return this.certificateId;
/*     */   }
/*     */   
/*     */   public void setCertificateId(LongFilter certificateId) {
/* 205 */     this.certificateId = certificateId;
/*     */   }
/*     */   
/*     */   public LongFilter getWorkstationId() {
/* 209 */     return this.workstationId;
/*     */   }
/*     */   
/*     */   public LongFilter workstationId() {
/* 213 */     if (this.workstationId == null) {
/* 214 */       this.workstationId = new LongFilter();
/*     */     }
/* 216 */     return this.workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(LongFilter workstationId) {
/* 220 */     this.workstationId = workstationId;
/*     */   }
/*     */   
/*     */   public LongFilter getEmployeeId() {
/* 224 */     return this.employeeId;
/*     */   }
/*     */   
/*     */   public LongFilter employeeId() {
/* 228 */     if (this.employeeId == null) {
/* 229 */       this.employeeId = new LongFilter();
/*     */     }
/* 231 */     return this.employeeId;
/*     */   }
/*     */   
/*     */   public void setEmployeeId(LongFilter employeeId) {
/* 235 */     this.employeeId = employeeId;
/*     */   }
/*     */   
/*     */   public LongFilter getCurrentCertificateId() {
/* 239 */     return this.currentCertificateId;
/*     */   }
/*     */   
/*     */   public LongFilter currentCertificateId() {
/* 243 */     if (this.currentCertificateId == null) {
/* 244 */       this.currentCertificateId = new LongFilter();
/*     */     }
/* 246 */     return this.currentCertificateId;
/*     */   }
/*     */   
/*     */   public void setCurrentCertificateId(LongFilter currentCertificateId) {
/* 250 */     this.currentCertificateId = currentCertificateId;
/*     */   }
/*     */   
/*     */   public Boolean getDistinct() {
/* 254 */     return this.distinct;
/*     */   }
/*     */   
/*     */   public void setDistinct(Boolean distinct) {
/* 258 */     this.distinct = distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 263 */     if (this == o) {
/* 264 */       return true;
/*     */     }
/* 266 */     if (o == null || getClass() != o.getClass()) {
/* 267 */       return false;
/*     */     }
/* 269 */     com.nanosoft.amtk.service.criteria.AssignmentCriteria that = (com.nanosoft.amtk.service.criteria.AssignmentCriteria)o;
/* 270 */     return (
/* 271 */       Objects.equals(this.id, that.id) && 
/* 272 */       Objects.equals(this.assignmentStart, that.assignmentStart) && 
/* 273 */       Objects.equals(this.assignmentEnd, that.assignmentEnd) && 
/* 274 */       Objects.equals(this.description, that.description) && 
/* 275 */       Objects.equals(this.createdBy, that.createdBy) && 
/* 276 */       Objects.equals(this.createdDate, that.createdDate) && 
/* 277 */       Objects.equals(this.lastModifiedBy, that.lastModifiedBy) && 
/* 278 */       Objects.equals(this.lastModifiedDate, that.lastModifiedDate) && 
/* 279 */       Objects.equals(this.certificateId, that.certificateId) && 
/* 280 */       Objects.equals(this.workstationId, that.workstationId) && 
/* 281 */       Objects.equals(this.employeeId, that.employeeId) && 
/* 282 */       Objects.equals(this.currentCertificateId, that.currentCertificateId) && 
/* 283 */       Objects.equals(this.distinct, that.distinct));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 289 */     return Objects.hash(new Object[] { this.id, this.assignmentStart, this.assignmentEnd, this.description, this.createdBy, this.createdDate, this.lastModifiedBy, this.lastModifiedDate, this.certificateId, this.workstationId, this.employeeId, this.currentCertificateId, this.distinct });
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 310 */     return "AssignmentCriteria{" + ((this.id != null) ? ("id=" + this.id + ", ") : "") + (
/* 311 */       (this.assignmentStart != null) ? ("assignmentStart=" + this.assignmentStart + ", ") : "") + (
/* 312 */       (this.assignmentEnd != null) ? ("assignmentEnd=" + this.assignmentEnd + ", ") : "") + (
/* 313 */       (this.description != null) ? ("description=" + this.description + ", ") : "") + (
/* 314 */       (this.createdBy != null) ? ("createdBy=" + this.createdBy + ", ") : "") + (
/* 315 */       (this.createdDate != null) ? ("createdDate=" + this.createdDate + ", ") : "") + (
/* 316 */       (this.lastModifiedBy != null) ? ("lastModifiedBy=" + this.lastModifiedBy + ", ") : "") + (
/* 317 */       (this.lastModifiedDate != null) ? ("lastModifiedDate=" + this.lastModifiedDate + ", ") : "") + (
/* 318 */       (this.certificateId != null) ? ("certificateId=" + this.certificateId + ", ") : "") + (
/* 319 */       (this.workstationId != null) ? ("workstationId=" + this.workstationId + ", ") : "") + (
/* 320 */       (this.employeeId != null) ? ("employeeId=" + this.employeeId + ", ") : "") + (
/* 321 */       (this.currentCertificateId != null) ? ("currentCertificateId=" + this.currentCertificateId + ", ") : "") + (
/* 322 */       (this.distinct != null) ? ("distinct=" + this.distinct + ", ") : "") + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\criteria\AssignmentCriteria.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */