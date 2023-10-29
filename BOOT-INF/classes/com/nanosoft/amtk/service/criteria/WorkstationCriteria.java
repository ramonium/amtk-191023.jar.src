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
/*     */ @ParameterObject
/*     */ public class WorkstationCriteria
/*     */   implements Serializable, Criteria
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private LongFilter id;
/*     */   private StringFilter name;
/*     */   private StringFilter description;
/*     */   private IntegerFilter orderNumber;
/*     */   private StringFilter createdBy;
/*     */   private InstantFilter createdDate;
/*     */   private StringFilter lastModifiedBy;
/*     */   private InstantFilter lastModifiedDate;
/*     */   private LongFilter assignmentId;
/*     */   private LongFilter areaId;
/*     */   private LongFilter processId;
/*     */   private Boolean distinct;
/*     */   
/*     */   public WorkstationCriteria() {}
/*     */   
/*     */   public WorkstationCriteria(com.nanosoft.amtk.service.criteria.WorkstationCriteria other) {
/*  51 */     this.id = (other.id == null) ? null : other.id.copy();
/*  52 */     this.name = (other.name == null) ? null : other.name.copy();
/*  53 */     this.description = (other.description == null) ? null : other.description.copy();
/*  54 */     this.orderNumber = (other.orderNumber == null) ? null : other.orderNumber.copy();
/*  55 */     this.createdBy = (other.createdBy == null) ? null : other.createdBy.copy();
/*  56 */     this.createdDate = (other.createdDate == null) ? null : other.createdDate.copy();
/*  57 */     this.lastModifiedBy = (other.lastModifiedBy == null) ? null : other.lastModifiedBy.copy();
/*  58 */     this.lastModifiedDate = (other.lastModifiedDate == null) ? null : other.lastModifiedDate.copy();
/*  59 */     this.assignmentId = (other.assignmentId == null) ? null : other.assignmentId.copy();
/*  60 */     this.areaId = (other.areaId == null) ? null : other.areaId.copy();
/*  61 */     this.processId = (other.processId == null) ? null : other.processId.copy();
/*  62 */     this.distinct = other.distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public com.nanosoft.amtk.service.criteria.WorkstationCriteria copy() {
/*  67 */     return new com.nanosoft.amtk.service.criteria.WorkstationCriteria(this);
/*     */   }
/*     */   
/*     */   public LongFilter getId() {
/*  71 */     return this.id;
/*     */   }
/*     */   
/*     */   public LongFilter id() {
/*  75 */     if (this.id == null) {
/*  76 */       this.id = new LongFilter();
/*     */     }
/*  78 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(LongFilter id) {
/*  82 */     this.id = id;
/*     */   }
/*     */   
/*     */   public StringFilter getName() {
/*  86 */     return this.name;
/*     */   }
/*     */   
/*     */   public StringFilter name() {
/*  90 */     if (this.name == null) {
/*  91 */       this.name = new StringFilter();
/*     */     }
/*  93 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(StringFilter name) {
/*  97 */     this.name = name;
/*     */   }
/*     */   
/*     */   public StringFilter getDescription() {
/* 101 */     return this.description;
/*     */   }
/*     */   
/*     */   public StringFilter description() {
/* 105 */     if (this.description == null) {
/* 106 */       this.description = new StringFilter();
/*     */     }
/* 108 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(StringFilter description) {
/* 112 */     this.description = description;
/*     */   }
/*     */   
/*     */   public IntegerFilter getOrderNumber() {
/* 116 */     return this.orderNumber;
/*     */   }
/*     */   
/*     */   public IntegerFilter orderNumber() {
/* 120 */     if (this.orderNumber == null) {
/* 121 */       this.orderNumber = new IntegerFilter();
/*     */     }
/* 123 */     return this.orderNumber;
/*     */   }
/*     */   
/*     */   public void setOrderNumber(IntegerFilter orderNumber) {
/* 127 */     this.orderNumber = orderNumber;
/*     */   }
/*     */   
/*     */   public StringFilter getCreatedBy() {
/* 131 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public StringFilter createdBy() {
/* 135 */     if (this.createdBy == null) {
/* 136 */       this.createdBy = new StringFilter();
/*     */     }
/* 138 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(StringFilter createdBy) {
/* 142 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getCreatedDate() {
/* 146 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public InstantFilter createdDate() {
/* 150 */     if (this.createdDate == null) {
/* 151 */       this.createdDate = new InstantFilter();
/*     */     }
/* 153 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(InstantFilter createdDate) {
/* 157 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public StringFilter getLastModifiedBy() {
/* 161 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public StringFilter lastModifiedBy() {
/* 165 */     if (this.lastModifiedBy == null) {
/* 166 */       this.lastModifiedBy = new StringFilter();
/*     */     }
/* 168 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(StringFilter lastModifiedBy) {
/* 172 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getLastModifiedDate() {
/* 176 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public InstantFilter lastModifiedDate() {
/* 180 */     if (this.lastModifiedDate == null) {
/* 181 */       this.lastModifiedDate = new InstantFilter();
/*     */     }
/* 183 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(InstantFilter lastModifiedDate) {
/* 187 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public LongFilter getAssignmentId() {
/* 191 */     return this.assignmentId;
/*     */   }
/*     */   
/*     */   public LongFilter assignmentId() {
/* 195 */     if (this.assignmentId == null) {
/* 196 */       this.assignmentId = new LongFilter();
/*     */     }
/* 198 */     return this.assignmentId;
/*     */   }
/*     */   
/*     */   public void setAssignmentId(LongFilter assignmentId) {
/* 202 */     this.assignmentId = assignmentId;
/*     */   }
/*     */   
/*     */   public LongFilter getAreaId() {
/* 206 */     return this.areaId;
/*     */   }
/*     */   
/*     */   public LongFilter areaId() {
/* 210 */     if (this.areaId == null) {
/* 211 */       this.areaId = new LongFilter();
/*     */     }
/* 213 */     return this.areaId;
/*     */   }
/*     */   
/*     */   public void setAreaId(LongFilter areaId) {
/* 217 */     this.areaId = areaId;
/*     */   }
/*     */   
/*     */   public LongFilter getProcessId() {
/* 221 */     return this.processId;
/*     */   }
/*     */   
/*     */   public LongFilter processId() {
/* 225 */     if (this.processId == null) {
/* 226 */       this.processId = new LongFilter();
/*     */     }
/* 228 */     return this.processId;
/*     */   }
/*     */   
/*     */   public void setProcessId(LongFilter processId) {
/* 232 */     this.processId = processId;
/*     */   }
/*     */   
/*     */   public Boolean getDistinct() {
/* 236 */     return this.distinct;
/*     */   }
/*     */   
/*     */   public void setDistinct(Boolean distinct) {
/* 240 */     this.distinct = distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 245 */     if (this == o) {
/* 246 */       return true;
/*     */     }
/* 248 */     if (o == null || getClass() != o.getClass()) {
/* 249 */       return false;
/*     */     }
/* 251 */     com.nanosoft.amtk.service.criteria.WorkstationCriteria that = (com.nanosoft.amtk.service.criteria.WorkstationCriteria)o;
/* 252 */     return (
/* 253 */       Objects.equals(this.id, that.id) && 
/* 254 */       Objects.equals(this.name, that.name) && 
/* 255 */       Objects.equals(this.description, that.description) && 
/* 256 */       Objects.equals(this.orderNumber, that.orderNumber) && 
/* 257 */       Objects.equals(this.createdBy, that.createdBy) && 
/* 258 */       Objects.equals(this.createdDate, that.createdDate) && 
/* 259 */       Objects.equals(this.lastModifiedBy, that.lastModifiedBy) && 
/* 260 */       Objects.equals(this.lastModifiedDate, that.lastModifiedDate) && 
/* 261 */       Objects.equals(this.assignmentId, that.assignmentId) && 
/* 262 */       Objects.equals(this.areaId, that.areaId) && 
/* 263 */       Objects.equals(this.processId, that.processId) && 
/* 264 */       Objects.equals(this.distinct, that.distinct));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 270 */     return Objects.hash(new Object[] { this.id, this.name, this.description, this.orderNumber, this.createdBy, this.createdDate, this.lastModifiedBy, this.lastModifiedDate, this.assignmentId, this.areaId, this.processId, this.distinct });
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
/*     */   public String toString() {
/* 290 */     return "WorkstationCriteria{" + ((this.id != null) ? ("id=" + this.id + ", ") : "") + (
/* 291 */       (this.name != null) ? ("name=" + this.name + ", ") : "") + (
/* 292 */       (this.description != null) ? ("description=" + this.description + ", ") : "") + (
/* 293 */       (this.orderNumber != null) ? ("orderNumber=" + this.orderNumber + ", ") : "") + (
/* 294 */       (this.createdBy != null) ? ("createdBy=" + this.createdBy + ", ") : "") + (
/* 295 */       (this.createdDate != null) ? ("createdDate=" + this.createdDate + ", ") : "") + (
/* 296 */       (this.lastModifiedBy != null) ? ("lastModifiedBy=" + this.lastModifiedBy + ", ") : "") + (
/* 297 */       (this.lastModifiedDate != null) ? ("lastModifiedDate=" + this.lastModifiedDate + ", ") : "") + (
/* 298 */       (this.assignmentId != null) ? ("assignmentId=" + this.assignmentId + ", ") : "") + (
/* 299 */       (this.areaId != null) ? ("areaId=" + this.areaId + ", ") : "") + (
/* 300 */       (this.processId != null) ? ("processId=" + this.processId + ", ") : "") + (
/* 301 */       (this.distinct != null) ? ("distinct=" + this.distinct + ", ") : "") + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\criteria\WorkstationCriteria.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */