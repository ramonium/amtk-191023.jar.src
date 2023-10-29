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
/*     */ @ParameterObject
/*     */ public class AreaCriteria
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
/*     */   private LongFilter workstationId;
/*     */   private LongFilter projectId;
/*     */   private Boolean distinct;
/*     */   
/*     */   public AreaCriteria() {}
/*     */   
/*     */   public AreaCriteria(com.nanosoft.amtk.service.criteria.AreaCriteria other) {
/*  49 */     this.id = (other.id == null) ? null : other.id.copy();
/*  50 */     this.name = (other.name == null) ? null : other.name.copy();
/*  51 */     this.description = (other.description == null) ? null : other.description.copy();
/*  52 */     this.orderNumber = (other.orderNumber == null) ? null : other.orderNumber.copy();
/*  53 */     this.createdBy = (other.createdBy == null) ? null : other.createdBy.copy();
/*  54 */     this.createdDate = (other.createdDate == null) ? null : other.createdDate.copy();
/*  55 */     this.lastModifiedBy = (other.lastModifiedBy == null) ? null : other.lastModifiedBy.copy();
/*  56 */     this.lastModifiedDate = (other.lastModifiedDate == null) ? null : other.lastModifiedDate.copy();
/*  57 */     this.workstationId = (other.workstationId == null) ? null : other.workstationId.copy();
/*  58 */     this.projectId = (other.projectId == null) ? null : other.projectId.copy();
/*  59 */     this.distinct = other.distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public com.nanosoft.amtk.service.criteria.AreaCriteria copy() {
/*  64 */     return new com.nanosoft.amtk.service.criteria.AreaCriteria(this);
/*     */   }
/*     */   
/*     */   public LongFilter getId() {
/*  68 */     return this.id;
/*     */   }
/*     */   
/*     */   public LongFilter id() {
/*  72 */     if (this.id == null) {
/*  73 */       this.id = new LongFilter();
/*     */     }
/*  75 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(LongFilter id) {
/*  79 */     this.id = id;
/*     */   }
/*     */   
/*     */   public StringFilter getName() {
/*  83 */     return this.name;
/*     */   }
/*     */   
/*     */   public StringFilter name() {
/*  87 */     if (this.name == null) {
/*  88 */       this.name = new StringFilter();
/*     */     }
/*  90 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(StringFilter name) {
/*  94 */     this.name = name;
/*     */   }
/*     */   
/*     */   public StringFilter getDescription() {
/*  98 */     return this.description;
/*     */   }
/*     */   
/*     */   public StringFilter description() {
/* 102 */     if (this.description == null) {
/* 103 */       this.description = new StringFilter();
/*     */     }
/* 105 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(StringFilter description) {
/* 109 */     this.description = description;
/*     */   }
/*     */   
/*     */   public IntegerFilter getOrderNumber() {
/* 113 */     return this.orderNumber;
/*     */   }
/*     */   
/*     */   public IntegerFilter orderNumber() {
/* 117 */     if (this.orderNumber == null) {
/* 118 */       this.orderNumber = new IntegerFilter();
/*     */     }
/* 120 */     return this.orderNumber;
/*     */   }
/*     */   
/*     */   public void setOrderNumber(IntegerFilter orderNumber) {
/* 124 */     this.orderNumber = orderNumber;
/*     */   }
/*     */   
/*     */   public StringFilter getCreatedBy() {
/* 128 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public StringFilter createdBy() {
/* 132 */     if (this.createdBy == null) {
/* 133 */       this.createdBy = new StringFilter();
/*     */     }
/* 135 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(StringFilter createdBy) {
/* 139 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getCreatedDate() {
/* 143 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public InstantFilter createdDate() {
/* 147 */     if (this.createdDate == null) {
/* 148 */       this.createdDate = new InstantFilter();
/*     */     }
/* 150 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(InstantFilter createdDate) {
/* 154 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public StringFilter getLastModifiedBy() {
/* 158 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public StringFilter lastModifiedBy() {
/* 162 */     if (this.lastModifiedBy == null) {
/* 163 */       this.lastModifiedBy = new StringFilter();
/*     */     }
/* 165 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(StringFilter lastModifiedBy) {
/* 169 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getLastModifiedDate() {
/* 173 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public InstantFilter lastModifiedDate() {
/* 177 */     if (this.lastModifiedDate == null) {
/* 178 */       this.lastModifiedDate = new InstantFilter();
/*     */     }
/* 180 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(InstantFilter lastModifiedDate) {
/* 184 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public LongFilter getWorkstationId() {
/* 188 */     return this.workstationId;
/*     */   }
/*     */   
/*     */   public LongFilter workstationId() {
/* 192 */     if (this.workstationId == null) {
/* 193 */       this.workstationId = new LongFilter();
/*     */     }
/* 195 */     return this.workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(LongFilter workstationId) {
/* 199 */     this.workstationId = workstationId;
/*     */   }
/*     */   
/*     */   public LongFilter getProjectId() {
/* 203 */     return this.projectId;
/*     */   }
/*     */   
/*     */   public LongFilter projectId() {
/* 207 */     if (this.projectId == null) {
/* 208 */       this.projectId = new LongFilter();
/*     */     }
/* 210 */     return this.projectId;
/*     */   }
/*     */   
/*     */   public void setProjectId(LongFilter projectId) {
/* 214 */     this.projectId = projectId;
/*     */   }
/*     */   
/*     */   public Boolean getDistinct() {
/* 218 */     return this.distinct;
/*     */   }
/*     */   
/*     */   public void setDistinct(Boolean distinct) {
/* 222 */     this.distinct = distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 227 */     if (this == o) {
/* 228 */       return true;
/*     */     }
/* 230 */     if (o == null || getClass() != o.getClass()) {
/* 231 */       return false;
/*     */     }
/* 233 */     com.nanosoft.amtk.service.criteria.AreaCriteria that = (com.nanosoft.amtk.service.criteria.AreaCriteria)o;
/* 234 */     return (
/* 235 */       Objects.equals(this.id, that.id) && 
/* 236 */       Objects.equals(this.name, that.name) && 
/* 237 */       Objects.equals(this.description, that.description) && 
/* 238 */       Objects.equals(this.orderNumber, that.orderNumber) && 
/* 239 */       Objects.equals(this.createdBy, that.createdBy) && 
/* 240 */       Objects.equals(this.createdDate, that.createdDate) && 
/* 241 */       Objects.equals(this.lastModifiedBy, that.lastModifiedBy) && 
/* 242 */       Objects.equals(this.lastModifiedDate, that.lastModifiedDate) && 
/* 243 */       Objects.equals(this.workstationId, that.workstationId) && 
/* 244 */       Objects.equals(this.projectId, that.projectId) && 
/* 245 */       Objects.equals(this.distinct, that.distinct));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 251 */     return Objects.hash(new Object[] { this.id, this.name, this.description, this.orderNumber, this.createdBy, this.createdDate, this.lastModifiedBy, this.lastModifiedDate, this.workstationId, this.projectId, this.distinct });
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
/*     */   public String toString() {
/* 270 */     return "AreaCriteria{" + ((this.id != null) ? ("id=" + this.id + ", ") : "") + (
/* 271 */       (this.name != null) ? ("name=" + this.name + ", ") : "") + (
/* 272 */       (this.description != null) ? ("description=" + this.description + ", ") : "") + (
/* 273 */       (this.orderNumber != null) ? ("orderNumber=" + this.orderNumber + ", ") : "") + (
/* 274 */       (this.createdBy != null) ? ("createdBy=" + this.createdBy + ", ") : "") + (
/* 275 */       (this.createdDate != null) ? ("createdDate=" + this.createdDate + ", ") : "") + (
/* 276 */       (this.lastModifiedBy != null) ? ("lastModifiedBy=" + this.lastModifiedBy + ", ") : "") + (
/* 277 */       (this.lastModifiedDate != null) ? ("lastModifiedDate=" + this.lastModifiedDate + ", ") : "") + (
/* 278 */       (this.workstationId != null) ? ("workstationId=" + this.workstationId + ", ") : "") + (
/* 279 */       (this.projectId != null) ? ("projectId=" + this.projectId + ", ") : "") + (
/* 280 */       (this.distinct != null) ? ("distinct=" + this.distinct + ", ") : "") + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\criteria\AreaCriteria.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */