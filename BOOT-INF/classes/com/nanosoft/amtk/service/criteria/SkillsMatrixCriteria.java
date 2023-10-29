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
/*     */ @ParameterObject
/*     */ public class SkillsMatrixCriteria
/*     */   implements Serializable, Criteria
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private LongFilter id;
/*     */   private StringFilter createdBy;
/*     */   private InstantFilter createdDate;
/*     */   private StringFilter lastModifiedBy;
/*     */   private InstantFilter lastModifiedDate;
/*     */   private LongFilter projectId;
/*     */   private LongFilter forProjectId;
/*     */   private Boolean distinct;
/*     */   
/*     */   public SkillsMatrixCriteria() {}
/*     */   
/*     */   public SkillsMatrixCriteria(com.nanosoft.amtk.service.criteria.SkillsMatrixCriteria other) {
/*  43 */     this.id = (other.id == null) ? null : other.id.copy();
/*  44 */     this.createdBy = (other.createdBy == null) ? null : other.createdBy.copy();
/*  45 */     this.createdDate = (other.createdDate == null) ? null : other.createdDate.copy();
/*  46 */     this.lastModifiedBy = (other.lastModifiedBy == null) ? null : other.lastModifiedBy.copy();
/*  47 */     this.lastModifiedDate = (other.lastModifiedDate == null) ? null : other.lastModifiedDate.copy();
/*  48 */     this.projectId = (other.projectId == null) ? null : other.projectId.copy();
/*  49 */     this.forProjectId = (other.forProjectId == null) ? null : other.forProjectId.copy();
/*  50 */     this.distinct = other.distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public com.nanosoft.amtk.service.criteria.SkillsMatrixCriteria copy() {
/*  55 */     return new com.nanosoft.amtk.service.criteria.SkillsMatrixCriteria(this);
/*     */   }
/*     */   
/*     */   public LongFilter getId() {
/*  59 */     return this.id;
/*     */   }
/*     */   
/*     */   public LongFilter id() {
/*  63 */     if (this.id == null) {
/*  64 */       this.id = new LongFilter();
/*     */     }
/*  66 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(LongFilter id) {
/*  70 */     this.id = id;
/*     */   }
/*     */   
/*     */   public StringFilter getCreatedBy() {
/*  74 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public StringFilter createdBy() {
/*  78 */     if (this.createdBy == null) {
/*  79 */       this.createdBy = new StringFilter();
/*     */     }
/*  81 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(StringFilter createdBy) {
/*  85 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getCreatedDate() {
/*  89 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public InstantFilter createdDate() {
/*  93 */     if (this.createdDate == null) {
/*  94 */       this.createdDate = new InstantFilter();
/*     */     }
/*  96 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(InstantFilter createdDate) {
/* 100 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public StringFilter getLastModifiedBy() {
/* 104 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public StringFilter lastModifiedBy() {
/* 108 */     if (this.lastModifiedBy == null) {
/* 109 */       this.lastModifiedBy = new StringFilter();
/*     */     }
/* 111 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(StringFilter lastModifiedBy) {
/* 115 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getLastModifiedDate() {
/* 119 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public InstantFilter lastModifiedDate() {
/* 123 */     if (this.lastModifiedDate == null) {
/* 124 */       this.lastModifiedDate = new InstantFilter();
/*     */     }
/* 126 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(InstantFilter lastModifiedDate) {
/* 130 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public LongFilter getProjectId() {
/* 134 */     return this.projectId;
/*     */   }
/*     */   
/*     */   public LongFilter projectId() {
/* 138 */     if (this.projectId == null) {
/* 139 */       this.projectId = new LongFilter();
/*     */     }
/* 141 */     return this.projectId;
/*     */   }
/*     */   
/*     */   public void setProjectId(LongFilter projectId) {
/* 145 */     this.projectId = projectId;
/*     */   }
/*     */   
/*     */   public LongFilter getForProjectId() {
/* 149 */     return this.forProjectId;
/*     */   }
/*     */   
/*     */   public LongFilter forProjectId() {
/* 153 */     if (this.forProjectId == null) {
/* 154 */       this.forProjectId = new LongFilter();
/*     */     }
/* 156 */     return this.forProjectId;
/*     */   }
/*     */   
/*     */   public void setForProjectId(LongFilter forProjectId) {
/* 160 */     this.forProjectId = forProjectId;
/*     */   }
/*     */   
/*     */   public Boolean getDistinct() {
/* 164 */     return this.distinct;
/*     */   }
/*     */   
/*     */   public void setDistinct(Boolean distinct) {
/* 168 */     this.distinct = distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 173 */     if (this == o) {
/* 174 */       return true;
/*     */     }
/* 176 */     if (o == null || getClass() != o.getClass()) {
/* 177 */       return false;
/*     */     }
/* 179 */     com.nanosoft.amtk.service.criteria.SkillsMatrixCriteria that = (com.nanosoft.amtk.service.criteria.SkillsMatrixCriteria)o;
/* 180 */     return (
/* 181 */       Objects.equals(this.id, that.id) && 
/* 182 */       Objects.equals(this.createdBy, that.createdBy) && 
/* 183 */       Objects.equals(this.createdDate, that.createdDate) && 
/* 184 */       Objects.equals(this.lastModifiedBy, that.lastModifiedBy) && 
/* 185 */       Objects.equals(this.lastModifiedDate, that.lastModifiedDate) && 
/* 186 */       Objects.equals(this.projectId, that.projectId) && 
/* 187 */       Objects.equals(this.forProjectId, that.forProjectId) && 
/* 188 */       Objects.equals(this.distinct, that.distinct));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 194 */     return Objects.hash(new Object[] { this.id, this.createdBy, this.createdDate, this.lastModifiedBy, this.lastModifiedDate, this.projectId, this.forProjectId, this.distinct });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 201 */     return "SkillsMatrixCriteria{" + ((this.id != null) ? ("id=" + this.id + ", ") : "") + (
/* 202 */       (this.createdBy != null) ? ("createdBy=" + this.createdBy + ", ") : "") + (
/* 203 */       (this.createdDate != null) ? ("createdDate=" + this.createdDate + ", ") : "") + (
/* 204 */       (this.lastModifiedBy != null) ? ("lastModifiedBy=" + this.lastModifiedBy + ", ") : "") + (
/* 205 */       (this.lastModifiedDate != null) ? ("lastModifiedDate=" + this.lastModifiedDate + ", ") : "") + (
/* 206 */       (this.projectId != null) ? ("projectId=" + this.projectId + ", ") : "") + (
/* 207 */       (this.forProjectId != null) ? ("forProjectId=" + this.forProjectId + ", ") : "") + (
/* 208 */       (this.distinct != null) ? ("distinct=" + this.distinct + ", ") : "") + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\criteria\SkillsMatrixCriteria.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */