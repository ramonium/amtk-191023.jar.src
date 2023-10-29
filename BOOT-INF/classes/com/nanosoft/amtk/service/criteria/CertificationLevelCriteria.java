/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.criteria;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Objects;
/*     */ import org.springdoc.api.annotations.ParameterObject;
/*     */ import tech.jhipster.service.Criteria;
/*     */ import tech.jhipster.service.filter.InstantFilter;
/*     */ import tech.jhipster.service.filter.IntegerFilter;
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
/*     */ public class CertificationLevelCriteria
/*     */   implements Serializable, Criteria
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private LongFilter id;
/*     */   private StringFilter level;
/*     */   private IntegerFilter orderNumber;
/*     */   private StringFilter trainingDuration;
/*     */   private StringFilter recyclingPeriod;
/*     */   private StringFilter description;
/*     */   private StringFilter createdBy;
/*     */   private InstantFilter createdDate;
/*     */   private StringFilter lastModifiedBy;
/*     */   private InstantFilter lastModifiedDate;
/*     */   private LongFilter certificateId;
/*     */   private LongFilter processId;
/*     */   private LongFilter checklistModelId;
/*     */   private Boolean distinct;
/*     */   
/*     */   public CertificationLevelCriteria() {}
/*     */   
/*     */   public CertificationLevelCriteria(com.nanosoft.amtk.service.criteria.CertificationLevelCriteria other) {
/*  55 */     this.id = (other.id == null) ? null : other.id.copy();
/*  56 */     this.level = (other.level == null) ? null : other.level.copy();
/*  57 */     this.orderNumber = (other.orderNumber == null) ? null : other.orderNumber.copy();
/*  58 */     this.trainingDuration = (other.trainingDuration == null) ? null : other.trainingDuration.copy();
/*  59 */     this.recyclingPeriod = (other.recyclingPeriod == null) ? null : other.recyclingPeriod.copy();
/*  60 */     this.description = (other.description == null) ? null : other.description.copy();
/*  61 */     this.createdBy = (other.createdBy == null) ? null : other.createdBy.copy();
/*  62 */     this.createdDate = (other.createdDate == null) ? null : other.createdDate.copy();
/*  63 */     this.lastModifiedBy = (other.lastModifiedBy == null) ? null : other.lastModifiedBy.copy();
/*  64 */     this.lastModifiedDate = (other.lastModifiedDate == null) ? null : other.lastModifiedDate.copy();
/*  65 */     this.certificateId = (other.certificateId == null) ? null : other.certificateId.copy();
/*  66 */     this.processId = (other.processId == null) ? null : other.processId.copy();
/*  67 */     this.checklistModelId = (other.checklistModelId == null) ? null : other.checklistModelId.copy();
/*  68 */     this.distinct = other.distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public com.nanosoft.amtk.service.criteria.CertificationLevelCriteria copy() {
/*  73 */     return new com.nanosoft.amtk.service.criteria.CertificationLevelCriteria(this);
/*     */   }
/*     */   
/*     */   public LongFilter getId() {
/*  77 */     return this.id;
/*     */   }
/*     */   
/*     */   public LongFilter id() {
/*  81 */     if (this.id == null) {
/*  82 */       this.id = new LongFilter();
/*     */     }
/*  84 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(LongFilter id) {
/*  88 */     this.id = id;
/*     */   }
/*     */   
/*     */   public StringFilter getLevel() {
/*  92 */     return this.level;
/*     */   }
/*     */   
/*     */   public StringFilter level() {
/*  96 */     if (this.level == null) {
/*  97 */       this.level = new StringFilter();
/*     */     }
/*  99 */     return this.level;
/*     */   }
/*     */   
/*     */   public void setLevel(StringFilter level) {
/* 103 */     this.level = level;
/*     */   }
/*     */   
/*     */   public IntegerFilter getOrderNumber() {
/* 107 */     return this.orderNumber;
/*     */   }
/*     */   
/*     */   public IntegerFilter orderNumber() {
/* 111 */     if (this.orderNumber == null) {
/* 112 */       this.orderNumber = new IntegerFilter();
/*     */     }
/* 114 */     return this.orderNumber;
/*     */   }
/*     */   
/*     */   public void setOrderNumber(IntegerFilter orderNumber) {
/* 118 */     this.orderNumber = orderNumber;
/*     */   }
/*     */   
/*     */   public StringFilter getTrainingDuration() {
/* 122 */     return this.trainingDuration;
/*     */   }
/*     */   
/*     */   public StringFilter trainingDuration() {
/* 126 */     if (this.trainingDuration == null) {
/* 127 */       this.trainingDuration = new StringFilter();
/*     */     }
/* 129 */     return this.trainingDuration;
/*     */   }
/*     */   
/*     */   public void setTrainingDuration(StringFilter trainingDuration) {
/* 133 */     this.trainingDuration = trainingDuration;
/*     */   }
/*     */   
/*     */   public StringFilter getRecyclingPeriod() {
/* 137 */     return this.recyclingPeriod;
/*     */   }
/*     */   
/*     */   public StringFilter recyclingPeriod() {
/* 141 */     if (this.recyclingPeriod == null) {
/* 142 */       this.recyclingPeriod = new StringFilter();
/*     */     }
/* 144 */     return this.recyclingPeriod;
/*     */   }
/*     */   
/*     */   public void setRecyclingPeriod(StringFilter recyclingPeriod) {
/* 148 */     this.recyclingPeriod = recyclingPeriod;
/*     */   }
/*     */   
/*     */   public StringFilter getDescription() {
/* 152 */     return this.description;
/*     */   }
/*     */   
/*     */   public StringFilter description() {
/* 156 */     if (this.description == null) {
/* 157 */       this.description = new StringFilter();
/*     */     }
/* 159 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(StringFilter description) {
/* 163 */     this.description = description;
/*     */   }
/*     */   
/*     */   public StringFilter getCreatedBy() {
/* 167 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public StringFilter createdBy() {
/* 171 */     if (this.createdBy == null) {
/* 172 */       this.createdBy = new StringFilter();
/*     */     }
/* 174 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(StringFilter createdBy) {
/* 178 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getCreatedDate() {
/* 182 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public InstantFilter createdDate() {
/* 186 */     if (this.createdDate == null) {
/* 187 */       this.createdDate = new InstantFilter();
/*     */     }
/* 189 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(InstantFilter createdDate) {
/* 193 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public StringFilter getLastModifiedBy() {
/* 197 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public StringFilter lastModifiedBy() {
/* 201 */     if (this.lastModifiedBy == null) {
/* 202 */       this.lastModifiedBy = new StringFilter();
/*     */     }
/* 204 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(StringFilter lastModifiedBy) {
/* 208 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getLastModifiedDate() {
/* 212 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public InstantFilter lastModifiedDate() {
/* 216 */     if (this.lastModifiedDate == null) {
/* 217 */       this.lastModifiedDate = new InstantFilter();
/*     */     }
/* 219 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(InstantFilter lastModifiedDate) {
/* 223 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public LongFilter getCertificateId() {
/* 227 */     return this.certificateId;
/*     */   }
/*     */   
/*     */   public LongFilter certificateId() {
/* 231 */     if (this.certificateId == null) {
/* 232 */       this.certificateId = new LongFilter();
/*     */     }
/* 234 */     return this.certificateId;
/*     */   }
/*     */   
/*     */   public void setCertificateId(LongFilter certificateId) {
/* 238 */     this.certificateId = certificateId;
/*     */   }
/*     */   
/*     */   public LongFilter getProcessId() {
/* 242 */     return this.processId;
/*     */   }
/*     */   
/*     */   public LongFilter processId() {
/* 246 */     if (this.processId == null) {
/* 247 */       this.processId = new LongFilter();
/*     */     }
/* 249 */     return this.processId;
/*     */   }
/*     */   
/*     */   public void setProcessId(LongFilter processId) {
/* 253 */     this.processId = processId;
/*     */   }
/*     */   
/*     */   public LongFilter getChecklistModelId() {
/* 257 */     return this.checklistModelId;
/*     */   }
/*     */   
/*     */   public LongFilter checklistModelId() {
/* 261 */     if (this.checklistModelId == null) {
/* 262 */       this.checklistModelId = new LongFilter();
/*     */     }
/* 264 */     return this.checklistModelId;
/*     */   }
/*     */   
/*     */   public void setChecklistModelId(LongFilter checklistModelId) {
/* 268 */     this.checklistModelId = checklistModelId;
/*     */   }
/*     */   
/*     */   public Boolean getDistinct() {
/* 272 */     return this.distinct;
/*     */   }
/*     */   
/*     */   public void setDistinct(Boolean distinct) {
/* 276 */     this.distinct = distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 281 */     if (this == o) {
/* 282 */       return true;
/*     */     }
/* 284 */     if (o == null || getClass() != o.getClass()) {
/* 285 */       return false;
/*     */     }
/* 287 */     com.nanosoft.amtk.service.criteria.CertificationLevelCriteria that = (com.nanosoft.amtk.service.criteria.CertificationLevelCriteria)o;
/* 288 */     return (
/* 289 */       Objects.equals(this.id, that.id) && 
/* 290 */       Objects.equals(this.level, that.level) && 
/* 291 */       Objects.equals(this.orderNumber, that.orderNumber) && 
/* 292 */       Objects.equals(this.trainingDuration, that.trainingDuration) && 
/* 293 */       Objects.equals(this.recyclingPeriod, that.recyclingPeriod) && 
/* 294 */       Objects.equals(this.description, that.description) && 
/* 295 */       Objects.equals(this.createdBy, that.createdBy) && 
/* 296 */       Objects.equals(this.createdDate, that.createdDate) && 
/* 297 */       Objects.equals(this.lastModifiedBy, that.lastModifiedBy) && 
/* 298 */       Objects.equals(this.lastModifiedDate, that.lastModifiedDate) && 
/* 299 */       Objects.equals(this.certificateId, that.certificateId) && 
/* 300 */       Objects.equals(this.processId, that.processId) && 
/* 301 */       Objects.equals(this.checklistModelId, that.checklistModelId) && 
/* 302 */       Objects.equals(this.distinct, that.distinct));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 308 */     return Objects.hash(new Object[] { this.id, this.level, this.orderNumber, this.trainingDuration, this.recyclingPeriod, this.description, this.createdBy, this.createdDate, this.lastModifiedBy, this.lastModifiedDate, this.certificateId, this.processId, this.checklistModelId, this.distinct });
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
/*     */   public String toString() {
/* 330 */     return "CertificationLevelCriteria{" + ((this.id != null) ? ("id=" + this.id + ", ") : "") + (
/* 331 */       (this.level != null) ? ("level=" + this.level + ", ") : "") + (
/* 332 */       (this.orderNumber != null) ? ("orderNumber=" + this.orderNumber + ", ") : "") + (
/* 333 */       (this.trainingDuration != null) ? ("trainingDuration=" + this.trainingDuration + ", ") : "") + (
/* 334 */       (this.recyclingPeriod != null) ? ("recyclingPeriod=" + this.recyclingPeriod + ", ") : "") + (
/* 335 */       (this.description != null) ? ("description=" + this.description + ", ") : "") + (
/* 336 */       (this.createdBy != null) ? ("createdBy=" + this.createdBy + ", ") : "") + (
/* 337 */       (this.createdDate != null) ? ("createdDate=" + this.createdDate + ", ") : "") + (
/* 338 */       (this.lastModifiedBy != null) ? ("lastModifiedBy=" + this.lastModifiedBy + ", ") : "") + (
/* 339 */       (this.lastModifiedDate != null) ? ("lastModifiedDate=" + this.lastModifiedDate + ", ") : "") + (
/* 340 */       (this.certificateId != null) ? ("certificateId=" + this.certificateId + ", ") : "") + (
/* 341 */       (this.processId != null) ? ("processId=" + this.processId + ", ") : "") + (
/* 342 */       (this.checklistModelId != null) ? ("checklistModelId=" + this.checklistModelId + ", ") : "") + (
/* 343 */       (this.distinct != null) ? ("distinct=" + this.distinct + ", ") : "") + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\criteria\CertificationLevelCriteria.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */