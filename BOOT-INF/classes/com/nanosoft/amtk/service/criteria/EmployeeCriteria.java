/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.criteria;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Objects;
/*     */ import org.springdoc.api.annotations.ParameterObject;
/*     */ import tech.jhipster.service.Criteria;
/*     */ import tech.jhipster.service.filter.BooleanFilter;
/*     */ import tech.jhipster.service.filter.InstantFilter;
/*     */ import tech.jhipster.service.filter.LocalDateFilter;
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
/*     */ @ParameterObject
/*     */ public class EmployeeCriteria
/*     */   implements Serializable, Criteria
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private LongFilter id;
/*     */   private StringFilter firstName;
/*     */   private StringFilter lastName;
/*     */   private StringFilter thirdName;
/*     */   private StringFilter gender;
/*     */   private StringFilter idNumber;
/*     */   private LocalDateFilter birthday;
/*     */   private LocalDateFilter joiningDate;
/*     */   private LocalDateFilter relievingDate;
/*     */   private StringFilter employeeNumber;
/*     */   private StringFilter createdBy;
/*     */   private InstantFilter createdDate;
/*     */   private StringFilter lastModifiedBy;
/*     */   private InstantFilter lastModifiedDate;
/*     */   private LongFilter attachmentId;
/*     */   private LongFilter assignmentId;
/*     */   private LongFilter titleId;
/*     */   private LongFilter teamId;
/*     */   private LongFilter managedTeamId;
/*     */   private BooleanFilter canSupervise;
/*     */   private Boolean distinct;
/*     */   private StringFilter filter;
/*     */   
/*     */   public EmployeeCriteria() {}
/*     */   
/*     */   public EmployeeCriteria(com.nanosoft.amtk.service.criteria.EmployeeCriteria other) {
/*  71 */     this.id = (other.id == null) ? null : other.id.copy();
/*  72 */     this.firstName = (other.firstName == null) ? null : other.firstName.copy();
/*  73 */     this.lastName = (other.lastName == null) ? null : other.lastName.copy();
/*  74 */     this.thirdName = (other.thirdName == null) ? null : other.thirdName.copy();
/*  75 */     this.gender = (other.gender == null) ? null : other.gender.copy();
/*  76 */     this.idNumber = (other.idNumber == null) ? null : other.idNumber.copy();
/*  77 */     this.birthday = (other.birthday == null) ? null : other.birthday.copy();
/*  78 */     this.joiningDate = (other.joiningDate == null) ? null : other.joiningDate.copy();
/*  79 */     this.relievingDate = (other.relievingDate == null) ? null : other.relievingDate.copy();
/*  80 */     this.employeeNumber = (other.employeeNumber == null) ? null : other.employeeNumber.copy();
/*  81 */     this.createdBy = (other.createdBy == null) ? null : other.createdBy.copy();
/*  82 */     this.createdDate = (other.createdDate == null) ? null : other.createdDate.copy();
/*  83 */     this.lastModifiedBy = (other.lastModifiedBy == null) ? null : other.lastModifiedBy.copy();
/*  84 */     this.lastModifiedDate = (other.lastModifiedDate == null) ? null : other.lastModifiedDate.copy();
/*  85 */     this.attachmentId = (other.attachmentId == null) ? null : other.attachmentId.copy();
/*  86 */     this.assignmentId = (other.assignmentId == null) ? null : other.assignmentId.copy();
/*  87 */     this.titleId = (other.titleId == null) ? null : other.titleId.copy();
/*  88 */     this.teamId = (other.teamId == null) ? null : other.teamId.copy();
/*  89 */     this.managedTeamId = (other.managedTeamId == null) ? null : other.managedTeamId.copy();
/*  90 */     this.canSupervise = (other.canSupervise == null) ? null : other.canSupervise.copy();
/*  91 */     this.distinct = other.distinct;
/*  92 */     this.filter = (other.filter == null) ? null : other.filter.copy();
/*     */   }
/*     */ 
/*     */   
/*     */   public com.nanosoft.amtk.service.criteria.EmployeeCriteria copy() {
/*  97 */     return new com.nanosoft.amtk.service.criteria.EmployeeCriteria(this);
/*     */   }
/*     */   
/*     */   public LongFilter getId() {
/* 101 */     return this.id;
/*     */   }
/*     */   
/*     */   public LongFilter id() {
/* 105 */     if (this.id == null) {
/* 106 */       this.id = new LongFilter();
/*     */     }
/* 108 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(LongFilter id) {
/* 112 */     this.id = id;
/*     */   }
/*     */   
/*     */   public StringFilter getFirstName() {
/* 116 */     return this.firstName;
/*     */   }
/*     */   
/*     */   public StringFilter firstName() {
/* 120 */     if (this.firstName == null) {
/* 121 */       this.firstName = new StringFilter();
/*     */     }
/* 123 */     return this.firstName;
/*     */   }
/*     */   
/*     */   public void setFirstName(StringFilter firstName) {
/* 127 */     this.firstName = firstName;
/*     */   }
/*     */   
/*     */   public StringFilter getLastName() {
/* 131 */     return this.lastName;
/*     */   }
/*     */   
/*     */   public StringFilter lastName() {
/* 135 */     if (this.lastName == null) {
/* 136 */       this.lastName = new StringFilter();
/*     */     }
/* 138 */     return this.lastName;
/*     */   }
/*     */   
/*     */   public void setLastName(StringFilter lastName) {
/* 142 */     this.lastName = lastName;
/*     */   }
/*     */   
/*     */   public StringFilter getThirdName() {
/* 146 */     return this.thirdName;
/*     */   }
/*     */   
/*     */   public StringFilter thirdName() {
/* 150 */     if (this.thirdName == null) {
/* 151 */       this.thirdName = new StringFilter();
/*     */     }
/* 153 */     return this.thirdName;
/*     */   }
/*     */   
/*     */   public void setThirdName(StringFilter thirdName) {
/* 157 */     this.thirdName = thirdName;
/*     */   }
/*     */   
/*     */   public StringFilter getGender() {
/* 161 */     return this.gender;
/*     */   }
/*     */   
/*     */   public StringFilter gender() {
/* 165 */     if (this.gender == null) {
/* 166 */       this.gender = new StringFilter();
/*     */     }
/* 168 */     return this.gender;
/*     */   }
/*     */   
/*     */   public void setGender(StringFilter gender) {
/* 172 */     this.gender = gender;
/*     */   }
/*     */   
/*     */   public StringFilter getIdNumber() {
/* 176 */     return this.idNumber;
/*     */   }
/*     */   
/*     */   public StringFilter idNumber() {
/* 180 */     if (this.idNumber == null) {
/* 181 */       this.idNumber = new StringFilter();
/*     */     }
/* 183 */     return this.idNumber;
/*     */   }
/*     */   
/*     */   public void setIdNumber(StringFilter idNumber) {
/* 187 */     this.idNumber = idNumber;
/*     */   }
/*     */   
/*     */   public LocalDateFilter getBirthday() {
/* 191 */     return this.birthday;
/*     */   }
/*     */   
/*     */   public LocalDateFilter birthday() {
/* 195 */     if (this.birthday == null) {
/* 196 */       this.birthday = new LocalDateFilter();
/*     */     }
/* 198 */     return this.birthday;
/*     */   }
/*     */   
/*     */   public void setBirthday(LocalDateFilter birthday) {
/* 202 */     this.birthday = birthday;
/*     */   }
/*     */   
/*     */   public LocalDateFilter getJoiningDate() {
/* 206 */     return this.joiningDate;
/*     */   }
/*     */   
/*     */   public LocalDateFilter joiningDate() {
/* 210 */     if (this.joiningDate == null) {
/* 211 */       this.joiningDate = new LocalDateFilter();
/*     */     }
/* 213 */     return this.joiningDate;
/*     */   }
/*     */   
/*     */   public void setJoiningDate(LocalDateFilter joiningDate) {
/* 217 */     this.joiningDate = joiningDate;
/*     */   }
/*     */   
/*     */   public LocalDateFilter getRelievingDate() {
/* 221 */     return this.relievingDate;
/*     */   }
/*     */   
/*     */   public LocalDateFilter relievingDate() {
/* 225 */     if (this.relievingDate == null) {
/* 226 */       this.relievingDate = new LocalDateFilter();
/*     */     }
/* 228 */     return this.relievingDate;
/*     */   }
/*     */   
/*     */   public void setRelievingDate(LocalDateFilter relievingDate) {
/* 232 */     this.relievingDate = relievingDate;
/*     */   }
/*     */   
/*     */   public StringFilter getEmployeeNumber() {
/* 236 */     return this.employeeNumber;
/*     */   }
/*     */   
/*     */   public StringFilter employeeNumber() {
/* 240 */     if (this.employeeNumber == null) {
/* 241 */       this.employeeNumber = new StringFilter();
/*     */     }
/* 243 */     return this.employeeNumber;
/*     */   }
/*     */   
/*     */   public void setEmployeeNumber(StringFilter employeeNumber) {
/* 247 */     this.employeeNumber = employeeNumber;
/*     */   }
/*     */   
/*     */   public StringFilter getCreatedBy() {
/* 251 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public StringFilter createdBy() {
/* 255 */     if (this.createdBy == null) {
/* 256 */       this.createdBy = new StringFilter();
/*     */     }
/* 258 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(StringFilter createdBy) {
/* 262 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getCreatedDate() {
/* 266 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public InstantFilter createdDate() {
/* 270 */     if (this.createdDate == null) {
/* 271 */       this.createdDate = new InstantFilter();
/*     */     }
/* 273 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(InstantFilter createdDate) {
/* 277 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public StringFilter getLastModifiedBy() {
/* 281 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public StringFilter lastModifiedBy() {
/* 285 */     if (this.lastModifiedBy == null) {
/* 286 */       this.lastModifiedBy = new StringFilter();
/*     */     }
/* 288 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(StringFilter lastModifiedBy) {
/* 292 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getLastModifiedDate() {
/* 296 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public InstantFilter lastModifiedDate() {
/* 300 */     if (this.lastModifiedDate == null) {
/* 301 */       this.lastModifiedDate = new InstantFilter();
/*     */     }
/* 303 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(InstantFilter lastModifiedDate) {
/* 307 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public LongFilter getAttachmentId() {
/* 311 */     return this.attachmentId;
/*     */   }
/*     */   
/*     */   public LongFilter attachmentId() {
/* 315 */     if (this.attachmentId == null) {
/* 316 */       this.attachmentId = new LongFilter();
/*     */     }
/* 318 */     return this.attachmentId;
/*     */   }
/*     */   
/*     */   public void setAttachmentId(LongFilter attachmentId) {
/* 322 */     this.attachmentId = attachmentId;
/*     */   }
/*     */   
/*     */   public LongFilter getAssignmentId() {
/* 326 */     return this.assignmentId;
/*     */   }
/*     */   
/*     */   public LongFilter assignmentId() {
/* 330 */     if (this.assignmentId == null) {
/* 331 */       this.assignmentId = new LongFilter();
/*     */     }
/* 333 */     return this.assignmentId;
/*     */   }
/*     */   
/*     */   public void setAssignmentId(LongFilter assignmentId) {
/* 337 */     this.assignmentId = assignmentId;
/*     */   }
/*     */   
/*     */   public LongFilter getTitleId() {
/* 341 */     return this.titleId;
/*     */   }
/*     */   
/*     */   public LongFilter titleId() {
/* 345 */     if (this.titleId == null) {
/* 346 */       this.titleId = new LongFilter();
/*     */     }
/* 348 */     return this.titleId;
/*     */   }
/*     */   
/*     */   public void setTitleId(LongFilter titleId) {
/* 352 */     this.titleId = titleId;
/*     */   }
/*     */   
/*     */   public LongFilter getTeamId() {
/* 356 */     return this.teamId;
/*     */   }
/*     */   
/*     */   public LongFilter teamId() {
/* 360 */     if (this.teamId == null) {
/* 361 */       this.teamId = new LongFilter();
/*     */     }
/* 363 */     return this.teamId;
/*     */   }
/*     */   
/*     */   public void setTeamId(LongFilter teamId) {
/* 367 */     this.teamId = teamId;
/*     */   }
/*     */   
/*     */   public LongFilter getManagedTeamId() {
/* 371 */     return this.managedTeamId;
/*     */   }
/*     */   
/*     */   public LongFilter managedTeamId() {
/* 375 */     if (this.managedTeamId == null) {
/* 376 */       this.managedTeamId = new LongFilter();
/*     */     }
/* 378 */     return this.managedTeamId;
/*     */   }
/*     */   
/*     */   public void setManagedTeamId(LongFilter managedTeamId) {
/* 382 */     this.managedTeamId = managedTeamId;
/*     */   }
/*     */   
/*     */   public BooleanFilter getCanSupervise() {
/* 386 */     return this.canSupervise;
/*     */   }
/*     */   
/*     */   public BooleanFilter canSupervise() {
/* 390 */     if (this.canSupervise == null) {
/* 391 */       this.canSupervise = new BooleanFilter();
/*     */     }
/* 393 */     return this.canSupervise;
/*     */   }
/*     */   
/*     */   public void setCanSupervise(BooleanFilter canSupervise) {
/* 397 */     this.canSupervise = canSupervise;
/*     */   }
/*     */   
/*     */   public Boolean getDistinct() {
/* 401 */     return this.distinct;
/*     */   }
/*     */   
/*     */   public void setDistinct(Boolean distinct) {
/* 405 */     this.distinct = distinct;
/*     */   }
/*     */   
/*     */   public StringFilter getFilter() {
/* 409 */     return this.filter;
/*     */   }
/*     */   
/*     */   public StringFilter filter() {
/* 413 */     if (this.filter == null) {
/* 414 */       this.filter = new StringFilter();
/*     */     }
/* 416 */     return this.filter;
/*     */   }
/*     */   
/*     */   public void setFilter(StringFilter filter) {
/* 420 */     this.filter = filter;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 425 */     if (this == o) {
/* 426 */       return true;
/*     */     }
/* 428 */     if (o == null || getClass() != o.getClass()) {
/* 429 */       return false;
/*     */     }
/* 431 */     com.nanosoft.amtk.service.criteria.EmployeeCriteria that = (com.nanosoft.amtk.service.criteria.EmployeeCriteria)o;
/* 432 */     return (
/* 433 */       Objects.equals(this.id, that.id) && 
/* 434 */       Objects.equals(this.firstName, that.firstName) && 
/* 435 */       Objects.equals(this.lastName, that.lastName) && 
/* 436 */       Objects.equals(this.thirdName, that.thirdName) && 
/* 437 */       Objects.equals(this.gender, that.gender) && 
/* 438 */       Objects.equals(this.idNumber, that.idNumber) && 
/* 439 */       Objects.equals(this.birthday, that.birthday) && 
/* 440 */       Objects.equals(this.joiningDate, that.joiningDate) && 
/* 441 */       Objects.equals(this.relievingDate, that.relievingDate) && 
/* 442 */       Objects.equals(this.employeeNumber, that.employeeNumber) && 
/* 443 */       Objects.equals(this.createdBy, that.createdBy) && 
/* 444 */       Objects.equals(this.createdDate, that.createdDate) && 
/* 445 */       Objects.equals(this.lastModifiedBy, that.lastModifiedBy) && 
/* 446 */       Objects.equals(this.lastModifiedDate, that.lastModifiedDate) && 
/* 447 */       Objects.equals(this.attachmentId, that.attachmentId) && 
/* 448 */       Objects.equals(this.assignmentId, that.assignmentId) && 
/* 449 */       Objects.equals(this.titleId, that.titleId) && 
/* 450 */       Objects.equals(this.teamId, that.teamId) && 
/* 451 */       Objects.equals(this.managedTeamId, that.managedTeamId) && 
/* 452 */       Objects.equals(this.canSupervise, that.canSupervise) && 
/* 453 */       Objects.equals(this.filter, that.filter) && 
/* 454 */       Objects.equals(this.distinct, that.distinct));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 460 */     return Objects.hash(new Object[] { this.id, this.firstName, this.lastName, this.thirdName, this.gender, this.idNumber, this.birthday, this.joiningDate, this.relievingDate, this.employeeNumber, this.createdBy, this.createdDate, this.lastModifiedBy, this.lastModifiedDate, this.attachmentId, this.assignmentId, this.titleId, this.teamId, this.managedTeamId, this.canSupervise, this.filter, this.distinct });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 490 */     return "EmployeeCriteria{" + ((this.id != null) ? ("id=" + this.id + ", ") : "") + (
/* 491 */       (this.firstName != null) ? ("firstName=" + this.firstName + ", ") : "") + (
/* 492 */       (this.lastName != null) ? ("lastName=" + this.lastName + ", ") : "") + (
/* 493 */       (this.thirdName != null) ? ("thirdName=" + this.thirdName + ", ") : "") + (
/* 494 */       (this.gender != null) ? ("gender=" + this.gender + ", ") : "") + (
/* 495 */       (this.idNumber != null) ? ("idNumber=" + this.idNumber + ", ") : "") + (
/* 496 */       (this.birthday != null) ? ("birthday=" + this.birthday + ", ") : "") + (
/* 497 */       (this.joiningDate != null) ? ("joiningDate=" + this.joiningDate + ", ") : "") + (
/* 498 */       (this.relievingDate != null) ? ("relievingDate=" + this.relievingDate + ", ") : "") + (
/* 499 */       (this.employeeNumber != null) ? ("employeeNumber=" + this.employeeNumber + ", ") : "") + (
/* 500 */       (this.createdBy != null) ? ("createdBy=" + this.createdBy + ", ") : "") + (
/* 501 */       (this.createdDate != null) ? ("createdDate=" + this.createdDate + ", ") : "") + (
/* 502 */       (this.lastModifiedBy != null) ? ("lastModifiedBy=" + this.lastModifiedBy + ", ") : "") + (
/* 503 */       (this.lastModifiedDate != null) ? ("lastModifiedDate=" + this.lastModifiedDate + ", ") : "") + (
/* 504 */       (this.attachmentId != null) ? ("attachmentId=" + this.attachmentId + ", ") : "") + (
/* 505 */       (this.assignmentId != null) ? ("assignmentId=" + this.assignmentId + ", ") : "") + (
/* 506 */       (this.titleId != null) ? ("titleId=" + this.titleId + ", ") : "") + (
/* 507 */       (this.teamId != null) ? ("teamId=" + this.teamId + ", ") : "") + (
/* 508 */       (this.managedTeamId != null) ? ("managedTeamId=" + this.managedTeamId + ", ") : "") + (
/* 509 */       (this.canSupervise != null) ? ("canSupervise=" + this.canSupervise + ", ") : "") + (
/* 510 */       (this.distinct != null) ? ("distinct=" + this.distinct + ", ") : "") + (
/* 511 */       (this.filter != null) ? ("filter=" + this.filter + ", ") : "") + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\criteria\EmployeeCriteria.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */