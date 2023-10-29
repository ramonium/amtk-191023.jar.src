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
/*     */ 
/*     */ 
/*     */ @ParameterObject
/*     */ public class ChecklistModelCriteria
/*     */   implements Serializable, Criteria
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private LongFilter id;
/*     */   private StringFilter title;
/*     */   private StringFilter description;
/*     */   private StringFilter validator;
/*     */   private StringFilter validator2;
/*     */   private StringFilter validator3;
/*     */   private StringFilter validator4;
/*     */   private StringFilter createdBy;
/*     */   private InstantFilter createdDate;
/*     */   private StringFilter lastModifiedBy;
/*     */   private InstantFilter lastModifiedDate;
/*     */   private LongFilter certificationLevelId;
/*     */   private LongFilter checklistId;
/*     */   private LongFilter checklistModelItemId;
/*     */   private Boolean distinct;
/*     */   
/*     */   public ChecklistModelCriteria() {}
/*     */   
/*     */   public ChecklistModelCriteria(com.nanosoft.amtk.service.criteria.ChecklistModelCriteria other) {
/*  57 */     this.id = (other.id == null) ? null : other.id.copy();
/*  58 */     this.title = (other.title == null) ? null : other.title.copy();
/*  59 */     this.description = (other.description == null) ? null : other.description.copy();
/*  60 */     this.validator = (other.validator == null) ? null : other.validator.copy();
/*  61 */     this.validator2 = (other.validator2 == null) ? null : other.validator2.copy();
/*  62 */     this.validator3 = (other.validator3 == null) ? null : other.validator3.copy();
/*  63 */     this.validator4 = (other.validator4 == null) ? null : other.validator4.copy();
/*  64 */     this.createdBy = (other.createdBy == null) ? null : other.createdBy.copy();
/*  65 */     this.createdDate = (other.createdDate == null) ? null : other.createdDate.copy();
/*  66 */     this.lastModifiedBy = (other.lastModifiedBy == null) ? null : other.lastModifiedBy.copy();
/*  67 */     this.lastModifiedDate = (other.lastModifiedDate == null) ? null : other.lastModifiedDate.copy();
/*  68 */     this.certificationLevelId = (other.certificationLevelId == null) ? null : other.certificationLevelId.copy();
/*  69 */     this.checklistId = (other.checklistId == null) ? null : other.checklistId.copy();
/*  70 */     this.checklistModelItemId = (other.checklistModelItemId == null) ? null : other.checklistModelItemId.copy();
/*  71 */     this.distinct = other.distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public com.nanosoft.amtk.service.criteria.ChecklistModelCriteria copy() {
/*  76 */     return new com.nanosoft.amtk.service.criteria.ChecklistModelCriteria(this);
/*     */   }
/*     */   
/*     */   public LongFilter getId() {
/*  80 */     return this.id;
/*     */   }
/*     */   
/*     */   public LongFilter id() {
/*  84 */     if (this.id == null) {
/*  85 */       this.id = new LongFilter();
/*     */     }
/*  87 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(LongFilter id) {
/*  91 */     this.id = id;
/*     */   }
/*     */   
/*     */   public StringFilter getTitle() {
/*  95 */     return this.title;
/*     */   }
/*     */   
/*     */   public StringFilter title() {
/*  99 */     if (this.title == null) {
/* 100 */       this.title = new StringFilter();
/*     */     }
/* 102 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(StringFilter title) {
/* 106 */     this.title = title;
/*     */   }
/*     */   
/*     */   public StringFilter getDescription() {
/* 110 */     return this.description;
/*     */   }
/*     */   
/*     */   public StringFilter description() {
/* 114 */     if (this.description == null) {
/* 115 */       this.description = new StringFilter();
/*     */     }
/* 117 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(StringFilter description) {
/* 121 */     this.description = description;
/*     */   }
/*     */   
/*     */   public StringFilter getValidator() {
/* 125 */     return this.validator;
/*     */   }
/*     */   
/*     */   public StringFilter validator() {
/* 129 */     if (this.validator == null) {
/* 130 */       this.validator = new StringFilter();
/*     */     }
/* 132 */     return this.validator;
/*     */   }
/*     */   
/*     */   public void setValidator(StringFilter validator) {
/* 136 */     this.validator = validator;
/*     */   }
/*     */   
/*     */   public StringFilter getValidator2() {
/* 140 */     return this.validator2;
/*     */   }
/*     */   
/*     */   public StringFilter validator2() {
/* 144 */     if (this.validator2 == null) {
/* 145 */       this.validator2 = new StringFilter();
/*     */     }
/* 147 */     return this.validator2;
/*     */   }
/*     */   
/*     */   public void setValidator2(StringFilter validator2) {
/* 151 */     this.validator2 = validator2;
/*     */   }
/*     */   
/*     */   public StringFilter getValidator3() {
/* 155 */     return this.validator3;
/*     */   }
/*     */   
/*     */   public StringFilter validator3() {
/* 159 */     if (this.validator3 == null) {
/* 160 */       this.validator3 = new StringFilter();
/*     */     }
/* 162 */     return this.validator3;
/*     */   }
/*     */   
/*     */   public void setValidator3(StringFilter validator3) {
/* 166 */     this.validator3 = validator3;
/*     */   }
/*     */   
/*     */   public StringFilter getValidator4() {
/* 170 */     return this.validator4;
/*     */   }
/*     */   
/*     */   public StringFilter validator4() {
/* 174 */     if (this.validator4 == null) {
/* 175 */       this.validator4 = new StringFilter();
/*     */     }
/* 177 */     return this.validator4;
/*     */   }
/*     */   
/*     */   public void setValidator4(StringFilter validator4) {
/* 181 */     this.validator4 = validator4;
/*     */   }
/*     */   
/*     */   public StringFilter getCreatedBy() {
/* 185 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public StringFilter createdBy() {
/* 189 */     if (this.createdBy == null) {
/* 190 */       this.createdBy = new StringFilter();
/*     */     }
/* 192 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(StringFilter createdBy) {
/* 196 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getCreatedDate() {
/* 200 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public InstantFilter createdDate() {
/* 204 */     if (this.createdDate == null) {
/* 205 */       this.createdDate = new InstantFilter();
/*     */     }
/* 207 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(InstantFilter createdDate) {
/* 211 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public StringFilter getLastModifiedBy() {
/* 215 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public StringFilter lastModifiedBy() {
/* 219 */     if (this.lastModifiedBy == null) {
/* 220 */       this.lastModifiedBy = new StringFilter();
/*     */     }
/* 222 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(StringFilter lastModifiedBy) {
/* 226 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getLastModifiedDate() {
/* 230 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public InstantFilter lastModifiedDate() {
/* 234 */     if (this.lastModifiedDate == null) {
/* 235 */       this.lastModifiedDate = new InstantFilter();
/*     */     }
/* 237 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(InstantFilter lastModifiedDate) {
/* 241 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public LongFilter getCertificationLevelId() {
/* 245 */     return this.certificationLevelId;
/*     */   }
/*     */   
/*     */   public LongFilter certificationLevelId() {
/* 249 */     if (this.certificationLevelId == null) {
/* 250 */       this.certificationLevelId = new LongFilter();
/*     */     }
/* 252 */     return this.certificationLevelId;
/*     */   }
/*     */   
/*     */   public void setCertificationLevelId(LongFilter certificationLevelId) {
/* 256 */     this.certificationLevelId = certificationLevelId;
/*     */   }
/*     */   
/*     */   public LongFilter getChecklistId() {
/* 260 */     return this.checklistId;
/*     */   }
/*     */   
/*     */   public LongFilter checklistId() {
/* 264 */     if (this.checklistId == null) {
/* 265 */       this.checklistId = new LongFilter();
/*     */     }
/* 267 */     return this.checklistId;
/*     */   }
/*     */   
/*     */   public void setChecklistId(LongFilter checklistId) {
/* 271 */     this.checklistId = checklistId;
/*     */   }
/*     */   
/*     */   public LongFilter getChecklistModelItemId() {
/* 275 */     return this.checklistModelItemId;
/*     */   }
/*     */   
/*     */   public LongFilter checklistModelItemId() {
/* 279 */     if (this.checklistModelItemId == null) {
/* 280 */       this.checklistModelItemId = new LongFilter();
/*     */     }
/* 282 */     return this.checklistModelItemId;
/*     */   }
/*     */   
/*     */   public void setChecklistModelItemId(LongFilter checklistModelItemId) {
/* 286 */     this.checklistModelItemId = checklistModelItemId;
/*     */   }
/*     */   
/*     */   public Boolean getDistinct() {
/* 290 */     return this.distinct;
/*     */   }
/*     */   
/*     */   public void setDistinct(Boolean distinct) {
/* 294 */     this.distinct = distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 299 */     if (this == o) {
/* 300 */       return true;
/*     */     }
/* 302 */     if (o == null || getClass() != o.getClass()) {
/* 303 */       return false;
/*     */     }
/* 305 */     com.nanosoft.amtk.service.criteria.ChecklistModelCriteria that = (com.nanosoft.amtk.service.criteria.ChecklistModelCriteria)o;
/* 306 */     return (
/* 307 */       Objects.equals(this.id, that.id) && 
/* 308 */       Objects.equals(this.title, that.title) && 
/* 309 */       Objects.equals(this.description, that.description) && 
/* 310 */       Objects.equals(this.validator, that.validator) && 
/* 311 */       Objects.equals(this.validator2, that.validator2) && 
/* 312 */       Objects.equals(this.validator3, that.validator3) && 
/* 313 */       Objects.equals(this.validator4, that.validator4) && 
/* 314 */       Objects.equals(this.createdBy, that.createdBy) && 
/* 315 */       Objects.equals(this.createdDate, that.createdDate) && 
/* 316 */       Objects.equals(this.lastModifiedBy, that.lastModifiedBy) && 
/* 317 */       Objects.equals(this.lastModifiedDate, that.lastModifiedDate) && 
/* 318 */       Objects.equals(this.certificationLevelId, that.certificationLevelId) && 
/* 319 */       Objects.equals(this.checklistId, that.checklistId) && 
/* 320 */       Objects.equals(this.checklistModelItemId, that.checklistModelItemId) && 
/* 321 */       Objects.equals(this.distinct, that.distinct));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 327 */     return Objects.hash(new Object[] { this.id, this.title, this.description, this.validator, this.validator2, this.validator3, this.validator4, this.createdBy, this.createdDate, this.lastModifiedBy, this.lastModifiedDate, this.certificationLevelId, this.checklistId, this.checklistModelItemId, this.distinct });
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
/*     */   public String toString() {
/* 350 */     return "ChecklistModelCriteria{" + ((this.id != null) ? ("id=" + this.id + ", ") : "") + (
/* 351 */       (this.title != null) ? ("title=" + this.title + ", ") : "") + (
/* 352 */       (this.description != null) ? ("description=" + this.description + ", ") : "") + (
/* 353 */       (this.validator != null) ? ("validator=" + this.validator + ", ") : "") + (
/* 354 */       (this.validator2 != null) ? ("validator2=" + this.validator2 + ", ") : "") + (
/* 355 */       (this.validator3 != null) ? ("validator3=" + this.validator3 + ", ") : "") + (
/* 356 */       (this.validator4 != null) ? ("validator4=" + this.validator4 + ", ") : "") + (
/* 357 */       (this.createdBy != null) ? ("createdBy=" + this.createdBy + ", ") : "") + (
/* 358 */       (this.createdDate != null) ? ("createdDate=" + this.createdDate + ", ") : "") + (
/* 359 */       (this.lastModifiedBy != null) ? ("lastModifiedBy=" + this.lastModifiedBy + ", ") : "") + (
/* 360 */       (this.lastModifiedDate != null) ? ("lastModifiedDate=" + this.lastModifiedDate + ", ") : "") + (
/* 361 */       (this.certificationLevelId != null) ? ("certificationLevelId=" + this.certificationLevelId + ", ") : "") + (
/* 362 */       (this.checklistId != null) ? ("checklistId=" + this.checklistId + ", ") : "") + (
/* 363 */       (this.checklistModelItemId != null) ? ("checklistModelItemId=" + this.checklistModelItemId + ", ") : "") + (
/* 364 */       (this.distinct != null) ? ("distinct=" + this.distinct + ", ") : "") + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\criteria\ChecklistModelCriteria.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */