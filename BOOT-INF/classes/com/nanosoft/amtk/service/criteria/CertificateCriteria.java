/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.criteria;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Objects;
/*     */ import org.springdoc.api.annotations.ParameterObject;
/*     */ import tech.jhipster.service.Criteria;
/*     */ import tech.jhipster.service.filter.BooleanFilter;
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
/*     */ public class CertificateCriteria
/*     */   implements Serializable, Criteria
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private LongFilter id;
/*     */   private CertificationStatusFilter status;
/*     */   private InstantFilter startDate;
/*     */   private InstantFilter expectedEndDate;
/*     */   private InstantFilter endDate;
/*     */   private BooleanFilter validated;
/*     */   private BooleanFilter isRecycling;
/*     */   private StringFilter createdBy;
/*     */   private InstantFilter createdDate;
/*     */   private StringFilter lastModifiedBy;
/*     */   private InstantFilter lastModifiedDate;
/*     */   private LongFilter assignmentId;
/*     */   private LongFilter supervisorId;
/*     */   private LongFilter forAssigmentId;
/*     */   private LongFilter levelId;
/*     */   private LongFilter checklistId;
/*     */   private Boolean distinct;
/*     */   
/*     */   public CertificateCriteria() {}
/*     */   
/*     */   public CertificateCriteria(com.nanosoft.amtk.service.criteria.CertificateCriteria other) {
/*  79 */     this.id = (other.id == null) ? null : other.id.copy();
/*  80 */     this.status = (other.status == null) ? null : other.status.copy();
/*  81 */     this.startDate = (other.startDate == null) ? null : other.startDate.copy();
/*  82 */     this.expectedEndDate = (other.expectedEndDate == null) ? null : other.expectedEndDate.copy();
/*  83 */     this.endDate = (other.endDate == null) ? null : other.endDate.copy();
/*  84 */     this.validated = (other.validated == null) ? null : other.validated.copy();
/*  85 */     this.isRecycling = (other.isRecycling == null) ? null : other.isRecycling.copy();
/*  86 */     this.createdBy = (other.createdBy == null) ? null : other.createdBy.copy();
/*  87 */     this.createdDate = (other.createdDate == null) ? null : other.createdDate.copy();
/*  88 */     this.lastModifiedBy = (other.lastModifiedBy == null) ? null : other.lastModifiedBy.copy();
/*  89 */     this.lastModifiedDate = (other.lastModifiedDate == null) ? null : other.lastModifiedDate.copy();
/*  90 */     this.assignmentId = (other.assignmentId == null) ? null : other.assignmentId.copy();
/*  91 */     this.supervisorId = (other.supervisorId == null) ? null : other.supervisorId.copy();
/*  92 */     this.forAssigmentId = (other.forAssigmentId == null) ? null : other.forAssigmentId.copy();
/*  93 */     this.levelId = (other.levelId == null) ? null : other.levelId.copy();
/*  94 */     this.checklistId = (other.checklistId == null) ? null : other.checklistId.copy();
/*  95 */     this.distinct = other.distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public com.nanosoft.amtk.service.criteria.CertificateCriteria copy() {
/* 100 */     return new com.nanosoft.amtk.service.criteria.CertificateCriteria(this);
/*     */   }
/*     */   
/*     */   public LongFilter getId() {
/* 104 */     return this.id;
/*     */   }
/*     */   
/*     */   public LongFilter id() {
/* 108 */     if (this.id == null) {
/* 109 */       this.id = new LongFilter();
/*     */     }
/* 111 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(LongFilter id) {
/* 115 */     this.id = id;
/*     */   }
/*     */   
/*     */   public CertificationStatusFilter getStatus() {
/* 119 */     return this.status;
/*     */   }
/*     */   
/*     */   public CertificationStatusFilter status() {
/* 123 */     if (this.status == null) {
/* 124 */       this.status = new CertificationStatusFilter();
/*     */     }
/* 126 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(CertificationStatusFilter status) {
/* 130 */     this.status = status;
/*     */   }
/*     */   
/*     */   public InstantFilter getStartDate() {
/* 134 */     return this.startDate;
/*     */   }
/*     */   
/*     */   public InstantFilter startDate() {
/* 138 */     if (this.startDate == null) {
/* 139 */       this.startDate = new InstantFilter();
/*     */     }
/* 141 */     return this.startDate;
/*     */   }
/*     */   
/*     */   public void setStartDate(InstantFilter startDate) {
/* 145 */     this.startDate = startDate;
/*     */   }
/*     */   
/*     */   public InstantFilter getExpectedEndDate() {
/* 149 */     return this.expectedEndDate;
/*     */   }
/*     */   
/*     */   public InstantFilter expectedEndDate() {
/* 153 */     if (this.expectedEndDate == null) {
/* 154 */       this.expectedEndDate = new InstantFilter();
/*     */     }
/* 156 */     return this.expectedEndDate;
/*     */   }
/*     */   
/*     */   public void setExpectedEndDate(InstantFilter expectedEndDate) {
/* 160 */     this.expectedEndDate = expectedEndDate;
/*     */   }
/*     */   
/*     */   public InstantFilter getEndDate() {
/* 164 */     return this.endDate;
/*     */   }
/*     */   
/*     */   public InstantFilter endDate() {
/* 168 */     if (this.endDate == null) {
/* 169 */       this.endDate = new InstantFilter();
/*     */     }
/* 171 */     return this.endDate;
/*     */   }
/*     */   
/*     */   public void setEndDate(InstantFilter endDate) {
/* 175 */     this.endDate = endDate;
/*     */   }
/*     */   
/*     */   public BooleanFilter getValidated() {
/* 179 */     return this.validated;
/*     */   }
/*     */   
/*     */   public BooleanFilter validated() {
/* 183 */     if (this.validated == null) {
/* 184 */       this.validated = new BooleanFilter();
/*     */     }
/* 186 */     return this.validated;
/*     */   }
/*     */   
/*     */   public void setValidated(BooleanFilter validated) {
/* 190 */     this.validated = validated;
/*     */   }
/*     */   
/*     */   public BooleanFilter getIsRecycling() {
/* 194 */     return this.isRecycling;
/*     */   }
/*     */   
/*     */   public BooleanFilter isRecycling() {
/* 198 */     if (this.isRecycling == null) {
/* 199 */       this.isRecycling = new BooleanFilter();
/*     */     }
/* 201 */     return this.isRecycling;
/*     */   }
/*     */   
/*     */   public void setIsRecycling(BooleanFilter isRecycling) {
/* 205 */     this.isRecycling = isRecycling;
/*     */   }
/*     */   
/*     */   public StringFilter getCreatedBy() {
/* 209 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public StringFilter createdBy() {
/* 213 */     if (this.createdBy == null) {
/* 214 */       this.createdBy = new StringFilter();
/*     */     }
/* 216 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(StringFilter createdBy) {
/* 220 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getCreatedDate() {
/* 224 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public InstantFilter createdDate() {
/* 228 */     if (this.createdDate == null) {
/* 229 */       this.createdDate = new InstantFilter();
/*     */     }
/* 231 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(InstantFilter createdDate) {
/* 235 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public StringFilter getLastModifiedBy() {
/* 239 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public StringFilter lastModifiedBy() {
/* 243 */     if (this.lastModifiedBy == null) {
/* 244 */       this.lastModifiedBy = new StringFilter();
/*     */     }
/* 246 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(StringFilter lastModifiedBy) {
/* 250 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getLastModifiedDate() {
/* 254 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public InstantFilter lastModifiedDate() {
/* 258 */     if (this.lastModifiedDate == null) {
/* 259 */       this.lastModifiedDate = new InstantFilter();
/*     */     }
/* 261 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(InstantFilter lastModifiedDate) {
/* 265 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public LongFilter getAssignmentId() {
/* 269 */     return this.assignmentId;
/*     */   }
/*     */   
/*     */   public LongFilter assignmentId() {
/* 273 */     if (this.assignmentId == null) {
/* 274 */       this.assignmentId = new LongFilter();
/*     */     }
/* 276 */     return this.assignmentId;
/*     */   }
/*     */   
/*     */   public void setAssignmentId(LongFilter assignmentId) {
/* 280 */     this.assignmentId = assignmentId;
/*     */   }
/*     */   
/*     */   public LongFilter getSupervisorId() {
/* 284 */     return this.supervisorId;
/*     */   }
/*     */   
/*     */   public LongFilter employeeId() {
/* 288 */     if (this.supervisorId == null) {
/* 289 */       this.supervisorId = new LongFilter();
/*     */     }
/* 291 */     return this.supervisorId;
/*     */   }
/*     */   
/*     */   public void setSupervisorId(LongFilter supervisorId) {
/* 295 */     this.supervisorId = supervisorId;
/*     */   }
/*     */   
/*     */   public LongFilter getForAssigmentId() {
/* 299 */     return this.forAssigmentId;
/*     */   }
/*     */   
/*     */   public LongFilter forAssigmentId() {
/* 303 */     if (this.forAssigmentId == null) {
/* 304 */       this.forAssigmentId = new LongFilter();
/*     */     }
/* 306 */     return this.forAssigmentId;
/*     */   }
/*     */   
/*     */   public void setForAssigmentId(LongFilter forAssigmentId) {
/* 310 */     this.forAssigmentId = forAssigmentId;
/*     */   }
/*     */   
/*     */   public LongFilter getLevelId() {
/* 314 */     return this.levelId;
/*     */   }
/*     */   
/*     */   public LongFilter levelId() {
/* 318 */     if (this.levelId == null) {
/* 319 */       this.levelId = new LongFilter();
/*     */     }
/* 321 */     return this.levelId;
/*     */   }
/*     */   
/*     */   public void setLevelId(LongFilter levelId) {
/* 325 */     this.levelId = levelId;
/*     */   }
/*     */   
/*     */   public LongFilter getChecklistId() {
/* 329 */     return this.checklistId;
/*     */   }
/*     */   
/*     */   public LongFilter checklistId() {
/* 333 */     if (this.checklistId == null) {
/* 334 */       this.checklistId = new LongFilter();
/*     */     }
/* 336 */     return this.checklistId;
/*     */   }
/*     */   
/*     */   public void setChecklistId(LongFilter checklistId) {
/* 340 */     this.checklistId = checklistId;
/*     */   }
/*     */   
/*     */   public Boolean getDistinct() {
/* 344 */     return this.distinct;
/*     */   }
/*     */   
/*     */   public void setDistinct(Boolean distinct) {
/* 348 */     this.distinct = distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 353 */     if (this == o) {
/* 354 */       return true;
/*     */     }
/* 356 */     if (o == null || getClass() != o.getClass()) {
/* 357 */       return false;
/*     */     }
/* 359 */     com.nanosoft.amtk.service.criteria.CertificateCriteria that = (com.nanosoft.amtk.service.criteria.CertificateCriteria)o;
/* 360 */     return (
/* 361 */       Objects.equals(this.id, that.id) && 
/* 362 */       Objects.equals(this.status, that.status) && 
/* 363 */       Objects.equals(this.startDate, that.startDate) && 
/* 364 */       Objects.equals(this.expectedEndDate, that.expectedEndDate) && 
/* 365 */       Objects.equals(this.endDate, that.endDate) && 
/* 366 */       Objects.equals(this.validated, that.validated) && 
/* 367 */       Objects.equals(this.isRecycling, that.isRecycling) && 
/* 368 */       Objects.equals(this.createdBy, that.createdBy) && 
/* 369 */       Objects.equals(this.createdDate, that.createdDate) && 
/* 370 */       Objects.equals(this.lastModifiedBy, that.lastModifiedBy) && 
/* 371 */       Objects.equals(this.lastModifiedDate, that.lastModifiedDate) && 
/* 372 */       Objects.equals(this.assignmentId, that.assignmentId) && 
/* 373 */       Objects.equals(this.supervisorId, that.supervisorId) && 
/* 374 */       Objects.equals(this.forAssigmentId, that.forAssigmentId) && 
/* 375 */       Objects.equals(this.levelId, that.levelId) && 
/* 376 */       Objects.equals(this.checklistId, that.checklistId) && 
/* 377 */       Objects.equals(this.distinct, that.distinct));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 383 */     return Objects.hash(new Object[] { this.id, this.status, this.startDate, this.expectedEndDate, this.endDate, this.validated, this.isRecycling, this.createdBy, this.createdDate, this.lastModifiedBy, this.lastModifiedDate, this.assignmentId, this.supervisorId, this.forAssigmentId, this.levelId, this.checklistId, this.distinct });
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 408 */     return "CertificateCriteria{" + ((this.id != null) ? ("id=" + this.id + ", ") : "") + (
/* 409 */       (this.status != null) ? ("status=" + this.status + ", ") : "") + (
/* 410 */       (this.startDate != null) ? ("startDate=" + this.startDate + ", ") : "") + (
/* 411 */       (this.expectedEndDate != null) ? ("expectedEndDate=" + this.expectedEndDate + ", ") : "") + (
/* 412 */       (this.endDate != null) ? ("endDate=" + this.endDate + ", ") : "") + (
/* 413 */       (this.validated != null) ? ("validated=" + this.validated + ", ") : "") + (
/* 414 */       (this.isRecycling != null) ? ("isRecycling=" + this.isRecycling + ", ") : "") + (
/* 415 */       (this.createdBy != null) ? ("createdBy=" + this.createdBy + ", ") : "") + (
/* 416 */       (this.createdDate != null) ? ("createdDate=" + this.createdDate + ", ") : "") + (
/* 417 */       (this.lastModifiedBy != null) ? ("lastModifiedBy=" + this.lastModifiedBy + ", ") : "") + (
/* 418 */       (this.lastModifiedDate != null) ? ("lastModifiedDate=" + this.lastModifiedDate + ", ") : "") + (
/* 419 */       (this.assignmentId != null) ? ("assignmentId=" + this.assignmentId + ", ") : "") + (
/* 420 */       (this.supervisorId != null) ? ("assignmentId=" + this.supervisorId + ", ") : "") + (
/* 421 */       (this.forAssigmentId != null) ? ("forAssigmentId=" + this.forAssigmentId + ", ") : "") + (
/* 422 */       (this.levelId != null) ? ("levelId=" + this.levelId + ", ") : "") + (
/* 423 */       (this.checklistId != null) ? ("checklistId=" + this.checklistId + ", ") : "") + (
/* 424 */       (this.distinct != null) ? ("distinct=" + this.distinct + ", ") : "") + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\criteria\CertificateCriteria.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */