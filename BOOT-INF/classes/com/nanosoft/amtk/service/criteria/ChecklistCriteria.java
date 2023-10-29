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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ParameterObject
/*     */ public class ChecklistCriteria
/*     */   implements Serializable, Criteria
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private LongFilter id;
/*     */   private StringFilter title;
/*     */   private StringFilter description;
/*     */   private StringFilter validatorRole;
/*     */   private StringFilter validator;
/*     */   private BooleanFilter validatorCheck;
/*     */   private StringFilter validatorRole2;
/*     */   private StringFilter validator2;
/*     */   private BooleanFilter validator2Check;
/*     */   private StringFilter validatorRole3;
/*     */   private StringFilter validator3;
/*     */   private BooleanFilter validator3Check;
/*     */   private StringFilter validatorRole4;
/*     */   private StringFilter validator4;
/*     */   private BooleanFilter validator4Check;
/*     */   private ChecklistStatusFilter status;
/*     */   private StringFilter createdBy;
/*     */   private InstantFilter createdDate;
/*     */   private StringFilter lastModifiedBy;
/*     */   private InstantFilter lastModifiedDate;
/*     */   private LongFilter certificateId;
/*     */   private LongFilter checklistModelId;
/*     */   private LongFilter checklistItemId;
/*     */   private Boolean distinct;
/*     */   
/*     */   public ChecklistCriteria() {}
/*     */   
/*     */   public ChecklistCriteria(com.nanosoft.amtk.service.criteria.ChecklistCriteria other) {
/*  93 */     this.id = (other.id == null) ? null : other.id.copy();
/*  94 */     this.title = (other.title == null) ? null : other.title.copy();
/*  95 */     this.description = (other.description == null) ? null : other.description.copy();
/*  96 */     this.validatorRole = (other.validatorRole == null) ? null : other.validatorRole.copy();
/*  97 */     this.validator = (other.validator == null) ? null : other.validator.copy();
/*  98 */     this.validatorCheck = (other.validatorCheck == null) ? null : other.validatorCheck.copy();
/*  99 */     this.validatorRole2 = (other.validatorRole2 == null) ? null : other.validatorRole2.copy();
/* 100 */     this.validator2 = (other.validator2 == null) ? null : other.validator2.copy();
/* 101 */     this.validator2Check = (other.validator2Check == null) ? null : other.validator2Check.copy();
/* 102 */     this.validatorRole3 = (other.validatorRole3 == null) ? null : other.validatorRole3.copy();
/* 103 */     this.validator3 = (other.validator3 == null) ? null : other.validator3.copy();
/* 104 */     this.validator3Check = (other.validator3Check == null) ? null : other.validator3Check.copy();
/* 105 */     this.validatorRole4 = (other.validatorRole4 == null) ? null : other.validatorRole4.copy();
/* 106 */     this.validator4 = (other.validator4 == null) ? null : other.validator4.copy();
/* 107 */     this.validator4Check = (other.validator4Check == null) ? null : other.validator4Check.copy();
/* 108 */     this.status = (other.status == null) ? null : other.status.copy();
/* 109 */     this.createdBy = (other.createdBy == null) ? null : other.createdBy.copy();
/* 110 */     this.createdDate = (other.createdDate == null) ? null : other.createdDate.copy();
/* 111 */     this.lastModifiedBy = (other.lastModifiedBy == null) ? null : other.lastModifiedBy.copy();
/* 112 */     this.lastModifiedDate = (other.lastModifiedDate == null) ? null : other.lastModifiedDate.copy();
/* 113 */     this.certificateId = (other.certificateId == null) ? null : other.certificateId.copy();
/* 114 */     this.checklistModelId = (other.checklistModelId == null) ? null : other.checklistModelId.copy();
/* 115 */     this.checklistItemId = (other.checklistItemId == null) ? null : other.checklistItemId.copy();
/* 116 */     this.distinct = other.distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public com.nanosoft.amtk.service.criteria.ChecklistCriteria copy() {
/* 121 */     return new com.nanosoft.amtk.service.criteria.ChecklistCriteria(this);
/*     */   }
/*     */   
/*     */   public LongFilter getId() {
/* 125 */     return this.id;
/*     */   }
/*     */   
/*     */   public LongFilter id() {
/* 129 */     if (this.id == null) {
/* 130 */       this.id = new LongFilter();
/*     */     }
/* 132 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(LongFilter id) {
/* 136 */     this.id = id;
/*     */   }
/*     */   
/*     */   public StringFilter getTitle() {
/* 140 */     return this.title;
/*     */   }
/*     */   
/*     */   public StringFilter title() {
/* 144 */     if (this.title == null) {
/* 145 */       this.title = new StringFilter();
/*     */     }
/* 147 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(StringFilter title) {
/* 151 */     this.title = title;
/*     */   }
/*     */   
/*     */   public StringFilter getDescription() {
/* 155 */     return this.description;
/*     */   }
/*     */   
/*     */   public StringFilter description() {
/* 159 */     if (this.description == null) {
/* 160 */       this.description = new StringFilter();
/*     */     }
/* 162 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(StringFilter description) {
/* 166 */     this.description = description;
/*     */   }
/*     */   
/*     */   public StringFilter getValidatorRole() {
/* 170 */     return this.validatorRole;
/*     */   }
/*     */   
/*     */   public StringFilter validatorRole() {
/* 174 */     if (this.validatorRole == null) {
/* 175 */       this.validatorRole = new StringFilter();
/*     */     }
/* 177 */     return this.validatorRole;
/*     */   }
/*     */   
/*     */   public void setValidatorRole(StringFilter validatorRole) {
/* 181 */     this.validatorRole = validatorRole;
/*     */   }
/*     */   
/*     */   public StringFilter getValidator() {
/* 185 */     return this.validator;
/*     */   }
/*     */   
/*     */   public StringFilter validator() {
/* 189 */     if (this.validator == null) {
/* 190 */       this.validator = new StringFilter();
/*     */     }
/* 192 */     return this.validator;
/*     */   }
/*     */   
/*     */   public void setValidator(StringFilter validator) {
/* 196 */     this.validator = validator;
/*     */   }
/*     */   
/*     */   public BooleanFilter getValidatorCheck() {
/* 200 */     return this.validatorCheck;
/*     */   }
/*     */   
/*     */   public BooleanFilter validatorCheck() {
/* 204 */     if (this.validatorCheck == null) {
/* 205 */       this.validatorCheck = new BooleanFilter();
/*     */     }
/* 207 */     return this.validatorCheck;
/*     */   }
/*     */   
/*     */   public void setValidatorCheck(BooleanFilter validatorCheck) {
/* 211 */     this.validatorCheck = validatorCheck;
/*     */   }
/*     */   
/*     */   public StringFilter getValidatorRole2() {
/* 215 */     return this.validatorRole2;
/*     */   }
/*     */   
/*     */   public StringFilter validatorRole2() {
/* 219 */     if (this.validatorRole2 == null) {
/* 220 */       this.validatorRole2 = new StringFilter();
/*     */     }
/* 222 */     return this.validatorRole2;
/*     */   }
/*     */   
/*     */   public void setValidatorRole2(StringFilter validatorRole2) {
/* 226 */     this.validatorRole2 = validatorRole2;
/*     */   }
/*     */   
/*     */   public StringFilter getValidator2() {
/* 230 */     return this.validator2;
/*     */   }
/*     */   
/*     */   public StringFilter validator2() {
/* 234 */     if (this.validator2 == null) {
/* 235 */       this.validator2 = new StringFilter();
/*     */     }
/* 237 */     return this.validator2;
/*     */   }
/*     */   
/*     */   public void setValidator2(StringFilter validator2) {
/* 241 */     this.validator2 = validator2;
/*     */   }
/*     */   
/*     */   public BooleanFilter getValidator2Check() {
/* 245 */     return this.validator2Check;
/*     */   }
/*     */   
/*     */   public BooleanFilter validator2Check() {
/* 249 */     if (this.validator2Check == null) {
/* 250 */       this.validator2Check = new BooleanFilter();
/*     */     }
/* 252 */     return this.validator2Check;
/*     */   }
/*     */   
/*     */   public void setValidator2Check(BooleanFilter validator2Check) {
/* 256 */     this.validator2Check = validator2Check;
/*     */   }
/*     */   
/*     */   public StringFilter getValidatorRole3() {
/* 260 */     return this.validatorRole3;
/*     */   }
/*     */   
/*     */   public StringFilter validatorRole3() {
/* 264 */     if (this.validatorRole3 == null) {
/* 265 */       this.validatorRole3 = new StringFilter();
/*     */     }
/* 267 */     return this.validatorRole3;
/*     */   }
/*     */   
/*     */   public void setValidatorRole3(StringFilter validatorRole3) {
/* 271 */     this.validatorRole3 = validatorRole3;
/*     */   }
/*     */   
/*     */   public StringFilter getValidator3() {
/* 275 */     return this.validator3;
/*     */   }
/*     */   
/*     */   public StringFilter validator3() {
/* 279 */     if (this.validator3 == null) {
/* 280 */       this.validator3 = new StringFilter();
/*     */     }
/* 282 */     return this.validator3;
/*     */   }
/*     */   
/*     */   public void setValidator3(StringFilter validator3) {
/* 286 */     this.validator3 = validator3;
/*     */   }
/*     */   
/*     */   public BooleanFilter getValidator3Check() {
/* 290 */     return this.validator3Check;
/*     */   }
/*     */   
/*     */   public BooleanFilter validator3Check() {
/* 294 */     if (this.validator3Check == null) {
/* 295 */       this.validator3Check = new BooleanFilter();
/*     */     }
/* 297 */     return this.validator3Check;
/*     */   }
/*     */   
/*     */   public void setValidator3Check(BooleanFilter validator3Check) {
/* 301 */     this.validator3Check = validator3Check;
/*     */   }
/*     */   
/*     */   public StringFilter getValidatorRole4() {
/* 305 */     return this.validatorRole4;
/*     */   }
/*     */   
/*     */   public StringFilter validatorRole4() {
/* 309 */     if (this.validatorRole4 == null) {
/* 310 */       this.validatorRole4 = new StringFilter();
/*     */     }
/* 312 */     return this.validatorRole4;
/*     */   }
/*     */   
/*     */   public void setValidatorRole4(StringFilter validatorRole4) {
/* 316 */     this.validatorRole4 = validatorRole4;
/*     */   }
/*     */   
/*     */   public StringFilter getValidator4() {
/* 320 */     return this.validator4;
/*     */   }
/*     */   
/*     */   public StringFilter validator4() {
/* 324 */     if (this.validator4 == null) {
/* 325 */       this.validator4 = new StringFilter();
/*     */     }
/* 327 */     return this.validator4;
/*     */   }
/*     */   
/*     */   public void setValidator4(StringFilter validator4) {
/* 331 */     this.validator4 = validator4;
/*     */   }
/*     */   
/*     */   public BooleanFilter getValidator4Check() {
/* 335 */     return this.validator4Check;
/*     */   }
/*     */   
/*     */   public BooleanFilter validator4Check() {
/* 339 */     if (this.validator4Check == null) {
/* 340 */       this.validator4Check = new BooleanFilter();
/*     */     }
/* 342 */     return this.validator4Check;
/*     */   }
/*     */   
/*     */   public void setValidator4Check(BooleanFilter validator4Check) {
/* 346 */     this.validator4Check = validator4Check;
/*     */   }
/*     */   
/*     */   public ChecklistStatusFilter getStatus() {
/* 350 */     return this.status;
/*     */   }
/*     */   
/*     */   public ChecklistStatusFilter status() {
/* 354 */     if (this.status == null) {
/* 355 */       this.status = new ChecklistStatusFilter();
/*     */     }
/* 357 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(ChecklistStatusFilter status) {
/* 361 */     this.status = status;
/*     */   }
/*     */   
/*     */   public StringFilter getCreatedBy() {
/* 365 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public StringFilter createdBy() {
/* 369 */     if (this.createdBy == null) {
/* 370 */       this.createdBy = new StringFilter();
/*     */     }
/* 372 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(StringFilter createdBy) {
/* 376 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getCreatedDate() {
/* 380 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public InstantFilter createdDate() {
/* 384 */     if (this.createdDate == null) {
/* 385 */       this.createdDate = new InstantFilter();
/*     */     }
/* 387 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(InstantFilter createdDate) {
/* 391 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public StringFilter getLastModifiedBy() {
/* 395 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public StringFilter lastModifiedBy() {
/* 399 */     if (this.lastModifiedBy == null) {
/* 400 */       this.lastModifiedBy = new StringFilter();
/*     */     }
/* 402 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(StringFilter lastModifiedBy) {
/* 406 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getLastModifiedDate() {
/* 410 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public InstantFilter lastModifiedDate() {
/* 414 */     if (this.lastModifiedDate == null) {
/* 415 */       this.lastModifiedDate = new InstantFilter();
/*     */     }
/* 417 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(InstantFilter lastModifiedDate) {
/* 421 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public LongFilter getCertificateId() {
/* 425 */     return this.certificateId;
/*     */   }
/*     */   
/*     */   public LongFilter certificateId() {
/* 429 */     if (this.certificateId == null) {
/* 430 */       this.certificateId = new LongFilter();
/*     */     }
/* 432 */     return this.certificateId;
/*     */   }
/*     */   
/*     */   public void setCertificateId(LongFilter certificateId) {
/* 436 */     this.certificateId = certificateId;
/*     */   }
/*     */   
/*     */   public LongFilter getChecklistModelId() {
/* 440 */     return this.checklistModelId;
/*     */   }
/*     */   
/*     */   public LongFilter checklistModelId() {
/* 444 */     if (this.checklistModelId == null) {
/* 445 */       this.checklistModelId = new LongFilter();
/*     */     }
/* 447 */     return this.checklistModelId;
/*     */   }
/*     */   
/*     */   public void setChecklistModelId(LongFilter checklistModelId) {
/* 451 */     this.checklistModelId = checklistModelId;
/*     */   }
/*     */   
/*     */   public LongFilter getChecklistItemId() {
/* 455 */     return this.checklistItemId;
/*     */   }
/*     */   
/*     */   public LongFilter checklistItemId() {
/* 459 */     if (this.checklistItemId == null) {
/* 460 */       this.checklistItemId = new LongFilter();
/*     */     }
/* 462 */     return this.checklistItemId;
/*     */   }
/*     */   
/*     */   public void setChecklistItemId(LongFilter checklistItemId) {
/* 466 */     this.checklistItemId = checklistItemId;
/*     */   }
/*     */   
/*     */   public Boolean getDistinct() {
/* 470 */     return this.distinct;
/*     */   }
/*     */   
/*     */   public void setDistinct(Boolean distinct) {
/* 474 */     this.distinct = distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 479 */     if (this == o) {
/* 480 */       return true;
/*     */     }
/* 482 */     if (o == null || getClass() != o.getClass()) {
/* 483 */       return false;
/*     */     }
/* 485 */     com.nanosoft.amtk.service.criteria.ChecklistCriteria that = (com.nanosoft.amtk.service.criteria.ChecklistCriteria)o;
/* 486 */     return (
/* 487 */       Objects.equals(this.id, that.id) && 
/* 488 */       Objects.equals(this.title, that.title) && 
/* 489 */       Objects.equals(this.description, that.description) && 
/* 490 */       Objects.equals(this.validatorRole, that.validatorRole) && 
/* 491 */       Objects.equals(this.validator, that.validator) && 
/* 492 */       Objects.equals(this.validatorCheck, that.validatorCheck) && 
/* 493 */       Objects.equals(this.validatorRole2, that.validatorRole2) && 
/* 494 */       Objects.equals(this.validator2, that.validator2) && 
/* 495 */       Objects.equals(this.validator2Check, that.validator2Check) && 
/* 496 */       Objects.equals(this.validatorRole3, that.validatorRole3) && 
/* 497 */       Objects.equals(this.validator3, that.validator3) && 
/* 498 */       Objects.equals(this.validator3Check, that.validator3Check) && 
/* 499 */       Objects.equals(this.validatorRole4, that.validatorRole4) && 
/* 500 */       Objects.equals(this.validator4, that.validator4) && 
/* 501 */       Objects.equals(this.validator4Check, that.validator4Check) && 
/* 502 */       Objects.equals(this.status, that.status) && 
/* 503 */       Objects.equals(this.createdBy, that.createdBy) && 
/* 504 */       Objects.equals(this.createdDate, that.createdDate) && 
/* 505 */       Objects.equals(this.lastModifiedBy, that.lastModifiedBy) && 
/* 506 */       Objects.equals(this.lastModifiedDate, that.lastModifiedDate) && 
/* 507 */       Objects.equals(this.certificateId, that.certificateId) && 
/* 508 */       Objects.equals(this.checklistModelId, that.checklistModelId) && 
/* 509 */       Objects.equals(this.checklistItemId, that.checklistItemId) && 
/* 510 */       Objects.equals(this.distinct, that.distinct));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 516 */     return Objects.hash(new Object[] { this.id, this.title, this.description, this.validatorRole, this.validator, this.validatorCheck, this.validatorRole2, this.validator2, this.validator2Check, this.validatorRole3, this.validator3, this.validator3Check, this.validatorRole4, this.validator4, this.validator4Check, this.status, this.createdBy, this.createdDate, this.lastModifiedBy, this.lastModifiedDate, this.certificateId, this.checklistModelId, this.checklistItemId, this.distinct });
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
/*     */ 
/*     */   
/*     */   public String toString() {
/* 548 */     return "ChecklistCriteria{" + ((this.id != null) ? ("id=" + this.id + ", ") : "") + (
/* 549 */       (this.title != null) ? ("title=" + this.title + ", ") : "") + (
/* 550 */       (this.description != null) ? ("description=" + this.description + ", ") : "") + (
/* 551 */       (this.validatorRole != null) ? ("validatorRole=" + this.validatorRole + ", ") : "") + (
/* 552 */       (this.validator != null) ? ("validator=" + this.validator + ", ") : "") + (
/* 553 */       (this.validatorCheck != null) ? ("validatorCheck=" + this.validatorCheck + ", ") : "") + (
/* 554 */       (this.validatorRole2 != null) ? ("validatorRole2=" + this.validatorRole2 + ", ") : "") + (
/* 555 */       (this.validator2 != null) ? ("validator2=" + this.validator2 + ", ") : "") + (
/* 556 */       (this.validator2Check != null) ? ("validator2Check=" + this.validator2Check + ", ") : "") + (
/* 557 */       (this.validatorRole3 != null) ? ("validatorRole3=" + this.validatorRole3 + ", ") : "") + (
/* 558 */       (this.validator3 != null) ? ("validator3=" + this.validator3 + ", ") : "") + (
/* 559 */       (this.validator3Check != null) ? ("validator3Check=" + this.validator3Check + ", ") : "") + (
/* 560 */       (this.validatorRole4 != null) ? ("validatorRole4=" + this.validatorRole4 + ", ") : "") + (
/* 561 */       (this.validator4 != null) ? ("validator4=" + this.validator4 + ", ") : "") + (
/* 562 */       (this.validator4Check != null) ? ("validator4Check=" + this.validator4Check + ", ") : "") + (
/* 563 */       (this.status != null) ? ("status=" + this.status + ", ") : "") + (
/* 564 */       (this.createdBy != null) ? ("createdBy=" + this.createdBy + ", ") : "") + (
/* 565 */       (this.createdDate != null) ? ("createdDate=" + this.createdDate + ", ") : "") + (
/* 566 */       (this.lastModifiedBy != null) ? ("lastModifiedBy=" + this.lastModifiedBy + ", ") : "") + (
/* 567 */       (this.lastModifiedDate != null) ? ("lastModifiedDate=" + this.lastModifiedDate + ", ") : "") + (
/* 568 */       (this.certificateId != null) ? ("certificateId=" + this.certificateId + ", ") : "") + (
/* 569 */       (this.checklistModelId != null) ? ("checklistModelId=" + this.checklistModelId + ", ") : "") + (
/* 570 */       (this.checklistItemId != null) ? ("checklistItemId=" + this.checklistItemId + ", ") : "") + (
/* 571 */       (this.distinct != null) ? ("distinct=" + this.distinct + ", ") : "") + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\criteria\ChecklistCriteria.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */