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
/*     */ @ParameterObject
/*     */ public class EmployeeTitleCriteria
/*     */   implements Serializable, Criteria
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private LongFilter id;
/*     */   private StringFilter name;
/*     */   private StringFilter description;
/*     */   private BooleanFilter canSupervise;
/*     */   private StringFilter createdBy;
/*     */   private InstantFilter createdDate;
/*     */   private StringFilter lastModifiedBy;
/*     */   private InstantFilter lastModifiedDate;
/*     */   private LongFilter employeeId;
/*     */   private Boolean distinct;
/*     */   
/*     */   public EmployeeTitleCriteria() {}
/*     */   
/*     */   public EmployeeTitleCriteria(com.nanosoft.amtk.service.criteria.EmployeeTitleCriteria other) {
/*  47 */     this.id = (other.id == null) ? null : other.id.copy();
/*  48 */     this.name = (other.name == null) ? null : other.name.copy();
/*  49 */     this.description = (other.description == null) ? null : other.description.copy();
/*  50 */     this.canSupervise = (other.canSupervise == null) ? null : other.canSupervise.copy();
/*  51 */     this.createdBy = (other.createdBy == null) ? null : other.createdBy.copy();
/*  52 */     this.createdDate = (other.createdDate == null) ? null : other.createdDate.copy();
/*  53 */     this.lastModifiedBy = (other.lastModifiedBy == null) ? null : other.lastModifiedBy.copy();
/*  54 */     this.lastModifiedDate = (other.lastModifiedDate == null) ? null : other.lastModifiedDate.copy();
/*  55 */     this.employeeId = (other.employeeId == null) ? null : other.employeeId.copy();
/*  56 */     this.distinct = other.distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public com.nanosoft.amtk.service.criteria.EmployeeTitleCriteria copy() {
/*  61 */     return new com.nanosoft.amtk.service.criteria.EmployeeTitleCriteria(this);
/*     */   }
/*     */   
/*     */   public LongFilter getId() {
/*  65 */     return this.id;
/*     */   }
/*     */   
/*     */   public LongFilter id() {
/*  69 */     if (this.id == null) {
/*  70 */       this.id = new LongFilter();
/*     */     }
/*  72 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(LongFilter id) {
/*  76 */     this.id = id;
/*     */   }
/*     */   
/*     */   public StringFilter getName() {
/*  80 */     return this.name;
/*     */   }
/*     */   
/*     */   public StringFilter name() {
/*  84 */     if (this.name == null) {
/*  85 */       this.name = new StringFilter();
/*     */     }
/*  87 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(StringFilter name) {
/*  91 */     this.name = name;
/*     */   }
/*     */   
/*     */   public StringFilter getDescription() {
/*  95 */     return this.description;
/*     */   }
/*     */   
/*     */   public StringFilter description() {
/*  99 */     if (this.description == null) {
/* 100 */       this.description = new StringFilter();
/*     */     }
/* 102 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(StringFilter description) {
/* 106 */     this.description = description;
/*     */   }
/*     */   
/*     */   public BooleanFilter getCanSupervise() {
/* 110 */     return this.canSupervise;
/*     */   }
/*     */   
/*     */   public BooleanFilter canSupervise() {
/* 114 */     if (this.canSupervise == null) {
/* 115 */       this.canSupervise = new BooleanFilter();
/*     */     }
/* 117 */     return this.canSupervise;
/*     */   }
/*     */   
/*     */   public void setCanSupervise(BooleanFilter canSupervise) {
/* 121 */     this.canSupervise = canSupervise;
/*     */   }
/*     */   
/*     */   public StringFilter getCreatedBy() {
/* 125 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public StringFilter createdBy() {
/* 129 */     if (this.createdBy == null) {
/* 130 */       this.createdBy = new StringFilter();
/*     */     }
/* 132 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(StringFilter createdBy) {
/* 136 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getCreatedDate() {
/* 140 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public InstantFilter createdDate() {
/* 144 */     if (this.createdDate == null) {
/* 145 */       this.createdDate = new InstantFilter();
/*     */     }
/* 147 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(InstantFilter createdDate) {
/* 151 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public StringFilter getLastModifiedBy() {
/* 155 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public StringFilter lastModifiedBy() {
/* 159 */     if (this.lastModifiedBy == null) {
/* 160 */       this.lastModifiedBy = new StringFilter();
/*     */     }
/* 162 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(StringFilter lastModifiedBy) {
/* 166 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getLastModifiedDate() {
/* 170 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public InstantFilter lastModifiedDate() {
/* 174 */     if (this.lastModifiedDate == null) {
/* 175 */       this.lastModifiedDate = new InstantFilter();
/*     */     }
/* 177 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(InstantFilter lastModifiedDate) {
/* 181 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public LongFilter getEmployeeId() {
/* 185 */     return this.employeeId;
/*     */   }
/*     */   
/*     */   public LongFilter employeeId() {
/* 189 */     if (this.employeeId == null) {
/* 190 */       this.employeeId = new LongFilter();
/*     */     }
/* 192 */     return this.employeeId;
/*     */   }
/*     */   
/*     */   public void setEmployeeId(LongFilter employeeId) {
/* 196 */     this.employeeId = employeeId;
/*     */   }
/*     */   
/*     */   public Boolean getDistinct() {
/* 200 */     return this.distinct;
/*     */   }
/*     */   
/*     */   public void setDistinct(Boolean distinct) {
/* 204 */     this.distinct = distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 209 */     if (this == o) {
/* 210 */       return true;
/*     */     }
/* 212 */     if (o == null || getClass() != o.getClass()) {
/* 213 */       return false;
/*     */     }
/* 215 */     com.nanosoft.amtk.service.criteria.EmployeeTitleCriteria that = (com.nanosoft.amtk.service.criteria.EmployeeTitleCriteria)o;
/* 216 */     return (
/* 217 */       Objects.equals(this.id, that.id) && 
/* 218 */       Objects.equals(this.name, that.name) && 
/* 219 */       Objects.equals(this.description, that.description) && 
/* 220 */       Objects.equals(this.canSupervise, that.canSupervise) && 
/* 221 */       Objects.equals(this.createdBy, that.createdBy) && 
/* 222 */       Objects.equals(this.createdDate, that.createdDate) && 
/* 223 */       Objects.equals(this.lastModifiedBy, that.lastModifiedBy) && 
/* 224 */       Objects.equals(this.lastModifiedDate, that.lastModifiedDate) && 
/* 225 */       Objects.equals(this.employeeId, that.employeeId) && 
/* 226 */       Objects.equals(this.distinct, that.distinct));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 232 */     return Objects.hash(new Object[] { this.id, this.name, this.description, this.canSupervise, this.createdBy, this.createdDate, this.lastModifiedBy, this.lastModifiedDate, this.employeeId, this.distinct });
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
/*     */   public String toString() {
/* 250 */     return "EmployeeTitleCriteria{" + ((this.id != null) ? ("id=" + this.id + ", ") : "") + (
/* 251 */       (this.name != null) ? ("name=" + this.name + ", ") : "") + (
/* 252 */       (this.description != null) ? ("description=" + this.description + ", ") : "") + (
/* 253 */       (this.canSupervise != null) ? ("canSupervise=" + this.canSupervise + ", ") : "") + (
/* 254 */       (this.createdBy != null) ? ("createdBy=" + this.createdBy + ", ") : "") + (
/* 255 */       (this.createdDate != null) ? ("createdDate=" + this.createdDate + ", ") : "") + (
/* 256 */       (this.lastModifiedBy != null) ? ("lastModifiedBy=" + this.lastModifiedBy + ", ") : "") + (
/* 257 */       (this.lastModifiedDate != null) ? ("lastModifiedDate=" + this.lastModifiedDate + ", ") : "") + (
/* 258 */       (this.employeeId != null) ? ("employeeId=" + this.employeeId + ", ") : "") + (
/* 259 */       (this.distinct != null) ? ("distinct=" + this.distinct + ", ") : "") + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\criteria\EmployeeTitleCriteria.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */