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
/*     */ @ParameterObject
/*     */ public class ProjectCriteria
/*     */   implements Serializable, Criteria
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private LongFilter id;
/*     */   private StringFilter name;
/*     */   private StringFilter customer;
/*     */   private BooleanFilter safety;
/*     */   private StringFilter qualificationAfter;
/*     */   private StringFilter decertifyAfter;
/*     */   private StringFilter description;
/*     */   private StringFilter createdBy;
/*     */   private InstantFilter createdDate;
/*     */   private StringFilter lastModifiedBy;
/*     */   private InstantFilter lastModifiedDate;
/*     */   private LongFilter areaId;
/*     */   private LongFilter skillsMatrixHistoryId;
/*     */   private LongFilter skillsMatrixId;
/*     */   private Boolean distinct;
/*     */   
/*     */   public ProjectCriteria() {}
/*     */   
/*     */   public ProjectCriteria(com.nanosoft.amtk.service.criteria.ProjectCriteria other) {
/*  57 */     this.id = (other.id == null) ? null : other.id.copy();
/*  58 */     this.name = (other.name == null) ? null : other.name.copy();
/*  59 */     this.customer = (other.customer == null) ? null : other.customer.copy();
/*  60 */     this.safety = (other.safety == null) ? null : other.safety.copy();
/*  61 */     this.qualificationAfter = (other.qualificationAfter == null) ? null : other.qualificationAfter.copy();
/*  62 */     this.decertifyAfter = (other.decertifyAfter == null) ? null : other.decertifyAfter.copy();
/*  63 */     this.description = (other.description == null) ? null : other.description.copy();
/*  64 */     this.createdBy = (other.createdBy == null) ? null : other.createdBy.copy();
/*  65 */     this.createdDate = (other.createdDate == null) ? null : other.createdDate.copy();
/*  66 */     this.lastModifiedBy = (other.lastModifiedBy == null) ? null : other.lastModifiedBy.copy();
/*  67 */     this.lastModifiedDate = (other.lastModifiedDate == null) ? null : other.lastModifiedDate.copy();
/*  68 */     this.areaId = (other.areaId == null) ? null : other.areaId.copy();
/*  69 */     this.skillsMatrixHistoryId = (other.skillsMatrixHistoryId == null) ? null : other.skillsMatrixHistoryId.copy();
/*  70 */     this.skillsMatrixId = (other.skillsMatrixId == null) ? null : other.skillsMatrixId.copy();
/*  71 */     this.distinct = other.distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public com.nanosoft.amtk.service.criteria.ProjectCriteria copy() {
/*  76 */     return new com.nanosoft.amtk.service.criteria.ProjectCriteria(this);
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
/*     */   public StringFilter getName() {
/*  95 */     return this.name;
/*     */   }
/*     */   
/*     */   public StringFilter name() {
/*  99 */     if (this.name == null) {
/* 100 */       this.name = new StringFilter();
/*     */     }
/* 102 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(StringFilter name) {
/* 106 */     this.name = name;
/*     */   }
/*     */   
/*     */   public StringFilter getCustomer() {
/* 110 */     return this.customer;
/*     */   }
/*     */   
/*     */   public StringFilter customer() {
/* 114 */     if (this.customer == null) {
/* 115 */       this.customer = new StringFilter();
/*     */     }
/* 117 */     return this.customer;
/*     */   }
/*     */   
/*     */   public void setCustomer(StringFilter customer) {
/* 121 */     this.customer = customer;
/*     */   }
/*     */   
/*     */   public BooleanFilter getSafety() {
/* 125 */     return this.safety;
/*     */   }
/*     */   
/*     */   public BooleanFilter safety() {
/* 129 */     if (this.safety == null) {
/* 130 */       this.safety = new BooleanFilter();
/*     */     }
/* 132 */     return this.safety;
/*     */   }
/*     */   
/*     */   public void setSafety(BooleanFilter safety) {
/* 136 */     this.safety = safety;
/*     */   }
/*     */   
/*     */   public StringFilter getQualificationAfter() {
/* 140 */     return this.qualificationAfter;
/*     */   }
/*     */   
/*     */   public StringFilter qualificationAfter() {
/* 144 */     if (this.qualificationAfter == null) {
/* 145 */       this.qualificationAfter = new StringFilter();
/*     */     }
/* 147 */     return this.qualificationAfter;
/*     */   }
/*     */   
/*     */   public void setQualificationAfter(StringFilter qualificationAfter) {
/* 151 */     this.qualificationAfter = qualificationAfter;
/*     */   }
/*     */   
/*     */   public StringFilter getDecertifyAfter() {
/* 155 */     return this.decertifyAfter;
/*     */   }
/*     */   
/*     */   public StringFilter decertifyAfter() {
/* 159 */     if (this.decertifyAfter == null) {
/* 160 */       this.decertifyAfter = new StringFilter();
/*     */     }
/* 162 */     return this.decertifyAfter;
/*     */   }
/*     */   
/*     */   public void setDecertifyAfter(StringFilter decertifyAfter) {
/* 166 */     this.decertifyAfter = decertifyAfter;
/*     */   }
/*     */   
/*     */   public StringFilter getDescription() {
/* 170 */     return this.description;
/*     */   }
/*     */   
/*     */   public StringFilter description() {
/* 174 */     if (this.description == null) {
/* 175 */       this.description = new StringFilter();
/*     */     }
/* 177 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(StringFilter description) {
/* 181 */     this.description = description;
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
/*     */   public LongFilter getAreaId() {
/* 245 */     return this.areaId;
/*     */   }
/*     */   
/*     */   public LongFilter areaId() {
/* 249 */     if (this.areaId == null) {
/* 250 */       this.areaId = new LongFilter();
/*     */     }
/* 252 */     return this.areaId;
/*     */   }
/*     */   
/*     */   public void setAreaId(LongFilter areaId) {
/* 256 */     this.areaId = areaId;
/*     */   }
/*     */   
/*     */   public LongFilter getSkillsMatrixHistoryId() {
/* 260 */     return this.skillsMatrixHistoryId;
/*     */   }
/*     */   
/*     */   public LongFilter skillsMatrixHistoryId() {
/* 264 */     if (this.skillsMatrixHistoryId == null) {
/* 265 */       this.skillsMatrixHistoryId = new LongFilter();
/*     */     }
/* 267 */     return this.skillsMatrixHistoryId;
/*     */   }
/*     */   
/*     */   public void setSkillsMatrixHistoryId(LongFilter skillsMatrixHistoryId) {
/* 271 */     this.skillsMatrixHistoryId = skillsMatrixHistoryId;
/*     */   }
/*     */   
/*     */   public LongFilter getSkillsMatrixId() {
/* 275 */     return this.skillsMatrixId;
/*     */   }
/*     */   
/*     */   public LongFilter skillsMatrixId() {
/* 279 */     if (this.skillsMatrixId == null) {
/* 280 */       this.skillsMatrixId = new LongFilter();
/*     */     }
/* 282 */     return this.skillsMatrixId;
/*     */   }
/*     */   
/*     */   public void setSkillsMatrixId(LongFilter skillsMatrixId) {
/* 286 */     this.skillsMatrixId = skillsMatrixId;
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
/* 305 */     com.nanosoft.amtk.service.criteria.ProjectCriteria that = (com.nanosoft.amtk.service.criteria.ProjectCriteria)o;
/* 306 */     return (
/* 307 */       Objects.equals(this.id, that.id) && 
/* 308 */       Objects.equals(this.name, that.name) && 
/* 309 */       Objects.equals(this.customer, that.customer) && 
/* 310 */       Objects.equals(this.safety, that.safety) && 
/* 311 */       Objects.equals(this.qualificationAfter, that.qualificationAfter) && 
/* 312 */       Objects.equals(this.decertifyAfter, that.decertifyAfter) && 
/* 313 */       Objects.equals(this.description, that.description) && 
/* 314 */       Objects.equals(this.createdBy, that.createdBy) && 
/* 315 */       Objects.equals(this.createdDate, that.createdDate) && 
/* 316 */       Objects.equals(this.lastModifiedBy, that.lastModifiedBy) && 
/* 317 */       Objects.equals(this.lastModifiedDate, that.lastModifiedDate) && 
/* 318 */       Objects.equals(this.areaId, that.areaId) && 
/* 319 */       Objects.equals(this.skillsMatrixHistoryId, that.skillsMatrixHistoryId) && 
/* 320 */       Objects.equals(this.skillsMatrixId, that.skillsMatrixId) && 
/* 321 */       Objects.equals(this.distinct, that.distinct));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 327 */     return Objects.hash(new Object[] { this.id, this.name, this.customer, this.safety, this.qualificationAfter, this.decertifyAfter, this.description, this.createdBy, this.createdDate, this.lastModifiedBy, this.lastModifiedDate, this.areaId, this.skillsMatrixHistoryId, this.skillsMatrixId, this.distinct });
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
/* 350 */     return "ProjectCriteria{" + ((this.id != null) ? ("id=" + this.id + ", ") : "") + (
/* 351 */       (this.name != null) ? ("name=" + this.name + ", ") : "") + (
/* 352 */       (this.customer != null) ? ("customer=" + this.customer + ", ") : "") + (
/* 353 */       (this.safety != null) ? ("safety=" + this.safety + ", ") : "") + (
/* 354 */       (this.qualificationAfter != null) ? ("qualificationAfter=" + this.qualificationAfter + ", ") : "") + (
/* 355 */       (this.decertifyAfter != null) ? ("decertifyAfter=" + this.decertifyAfter + ", ") : "") + (
/* 356 */       (this.description != null) ? ("description=" + this.description + ", ") : "") + (
/* 357 */       (this.createdBy != null) ? ("createdBy=" + this.createdBy + ", ") : "") + (
/* 358 */       (this.createdDate != null) ? ("createdDate=" + this.createdDate + ", ") : "") + (
/* 359 */       (this.lastModifiedBy != null) ? ("lastModifiedBy=" + this.lastModifiedBy + ", ") : "") + (
/* 360 */       (this.lastModifiedDate != null) ? ("lastModifiedDate=" + this.lastModifiedDate + ", ") : "") + (
/* 361 */       (this.areaId != null) ? ("areaId=" + this.areaId + ", ") : "") + (
/* 362 */       (this.skillsMatrixHistoryId != null) ? ("skillsMatrixHistoryId=" + this.skillsMatrixHistoryId + ", ") : "") + (
/* 363 */       (this.skillsMatrixId != null) ? ("skillsMatrixId=" + this.skillsMatrixId + ", ") : "") + (
/* 364 */       (this.distinct != null) ? ("distinct=" + this.distinct + ", ") : "") + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\criteria\ProjectCriteria.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */