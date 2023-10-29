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
/*     */ @ParameterObject
/*     */ public class TeamCriteria
/*     */   implements Serializable, Criteria
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private LongFilter id;
/*     */   private StringFilter name;
/*     */   private StringFilter description;
/*     */   private StringFilter createdBy;
/*     */   private InstantFilter createdDate;
/*     */   private StringFilter lastModifiedBy;
/*     */   private InstantFilter lastModifiedDate;
/*     */   private LongFilter employeeId;
/*     */   private LongFilter supervisorId;
/*     */   private Boolean distinct;
/*     */   
/*     */   public TeamCriteria() {}
/*     */   
/*     */   public TeamCriteria(com.nanosoft.amtk.service.criteria.TeamCriteria other) {
/*  47 */     this.id = (other.id == null) ? null : other.id.copy();
/*  48 */     this.name = (other.name == null) ? null : other.name.copy();
/*  49 */     this.description = (other.description == null) ? null : other.description.copy();
/*  50 */     this.createdBy = (other.createdBy == null) ? null : other.createdBy.copy();
/*  51 */     this.createdDate = (other.createdDate == null) ? null : other.createdDate.copy();
/*  52 */     this.lastModifiedBy = (other.lastModifiedBy == null) ? null : other.lastModifiedBy.copy();
/*  53 */     this.lastModifiedDate = (other.lastModifiedDate == null) ? null : other.lastModifiedDate.copy();
/*  54 */     this.employeeId = (other.employeeId == null) ? null : other.employeeId.copy();
/*  55 */     this.supervisorId = (other.supervisorId == null) ? null : other.supervisorId.copy();
/*  56 */     this.distinct = other.distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public com.nanosoft.amtk.service.criteria.TeamCriteria copy() {
/*  61 */     return new com.nanosoft.amtk.service.criteria.TeamCriteria(this);
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
/*     */   public StringFilter getCreatedBy() {
/* 110 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public StringFilter createdBy() {
/* 114 */     if (this.createdBy == null) {
/* 115 */       this.createdBy = new StringFilter();
/*     */     }
/* 117 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(StringFilter createdBy) {
/* 121 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getCreatedDate() {
/* 125 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public InstantFilter createdDate() {
/* 129 */     if (this.createdDate == null) {
/* 130 */       this.createdDate = new InstantFilter();
/*     */     }
/* 132 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(InstantFilter createdDate) {
/* 136 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public StringFilter getLastModifiedBy() {
/* 140 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public StringFilter lastModifiedBy() {
/* 144 */     if (this.lastModifiedBy == null) {
/* 145 */       this.lastModifiedBy = new StringFilter();
/*     */     }
/* 147 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(StringFilter lastModifiedBy) {
/* 151 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getLastModifiedDate() {
/* 155 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public InstantFilter lastModifiedDate() {
/* 159 */     if (this.lastModifiedDate == null) {
/* 160 */       this.lastModifiedDate = new InstantFilter();
/*     */     }
/* 162 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(InstantFilter lastModifiedDate) {
/* 166 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public LongFilter getEmployeeId() {
/* 170 */     return this.employeeId;
/*     */   }
/*     */   
/*     */   public LongFilter employeeId() {
/* 174 */     if (this.employeeId == null) {
/* 175 */       this.employeeId = new LongFilter();
/*     */     }
/* 177 */     return this.employeeId;
/*     */   }
/*     */   
/*     */   public void setEmployeeId(LongFilter employeeId) {
/* 181 */     this.employeeId = employeeId;
/*     */   }
/*     */   
/*     */   public LongFilter getSupervisorId() {
/* 185 */     return this.supervisorId;
/*     */   }
/*     */   
/*     */   public LongFilter supervisorId() {
/* 189 */     if (this.supervisorId == null) {
/* 190 */       this.supervisorId = new LongFilter();
/*     */     }
/* 192 */     return this.supervisorId;
/*     */   }
/*     */   
/*     */   public void setSupervisorId(LongFilter supervisorId) {
/* 196 */     this.supervisorId = supervisorId;
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
/* 215 */     com.nanosoft.amtk.service.criteria.TeamCriteria that = (com.nanosoft.amtk.service.criteria.TeamCriteria)o;
/* 216 */     return (
/* 217 */       Objects.equals(this.id, that.id) && 
/* 218 */       Objects.equals(this.name, that.name) && 
/* 219 */       Objects.equals(this.description, that.description) && 
/* 220 */       Objects.equals(this.createdBy, that.createdBy) && 
/* 221 */       Objects.equals(this.createdDate, that.createdDate) && 
/* 222 */       Objects.equals(this.lastModifiedBy, that.lastModifiedBy) && 
/* 223 */       Objects.equals(this.lastModifiedDate, that.lastModifiedDate) && 
/* 224 */       Objects.equals(this.employeeId, that.employeeId) && 
/* 225 */       Objects.equals(this.supervisorId, that.supervisorId) && 
/* 226 */       Objects.equals(this.distinct, that.distinct));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 232 */     return Objects.hash(new Object[] { this.id, this.name, this.description, this.createdBy, this.createdDate, this.lastModifiedBy, this.lastModifiedDate, this.employeeId, this.supervisorId, this.distinct });
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
/* 250 */     return "TeamCriteria{" + ((this.id != null) ? ("id=" + this.id + ", ") : "") + (
/* 251 */       (this.name != null) ? ("name=" + this.name + ", ") : "") + (
/* 252 */       (this.description != null) ? ("description=" + this.description + ", ") : "") + (
/* 253 */       (this.createdBy != null) ? ("createdBy=" + this.createdBy + ", ") : "") + (
/* 254 */       (this.createdDate != null) ? ("createdDate=" + this.createdDate + ", ") : "") + (
/* 255 */       (this.lastModifiedBy != null) ? ("lastModifiedBy=" + this.lastModifiedBy + ", ") : "") + (
/* 256 */       (this.lastModifiedDate != null) ? ("lastModifiedDate=" + this.lastModifiedDate + ", ") : "") + (
/* 257 */       (this.employeeId != null) ? ("employeeId=" + this.employeeId + ", ") : "") + (
/* 258 */       (this.supervisorId != null) ? ("supervisorId=" + this.supervisorId + ", ") : "") + (
/* 259 */       (this.distinct != null) ? ("distinct=" + this.distinct + ", ") : "") + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\criteria\TeamCriteria.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */