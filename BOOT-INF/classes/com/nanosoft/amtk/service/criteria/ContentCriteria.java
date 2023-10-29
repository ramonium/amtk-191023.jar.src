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
/*     */ @ParameterObject
/*     */ public class ContentCriteria
/*     */   implements Serializable, Criteria
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private LongFilter id;
/*     */   private StringFilter createdBy;
/*     */   private InstantFilter createdDate;
/*     */   private StringFilter lastModifiedBy;
/*     */   private InstantFilter lastModifiedDate;
/*     */   private LongFilter attachmentId;
/*     */   private Boolean distinct;
/*     */   
/*     */   public ContentCriteria() {}
/*     */   
/*     */   public ContentCriteria(com.nanosoft.amtk.service.criteria.ContentCriteria other) {
/*  41 */     this.id = (other.id == null) ? null : other.id.copy();
/*  42 */     this.createdBy = (other.createdBy == null) ? null : other.createdBy.copy();
/*  43 */     this.createdDate = (other.createdDate == null) ? null : other.createdDate.copy();
/*  44 */     this.lastModifiedBy = (other.lastModifiedBy == null) ? null : other.lastModifiedBy.copy();
/*  45 */     this.lastModifiedDate = (other.lastModifiedDate == null) ? null : other.lastModifiedDate.copy();
/*  46 */     this.attachmentId = (other.attachmentId == null) ? null : other.attachmentId.copy();
/*  47 */     this.distinct = other.distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public com.nanosoft.amtk.service.criteria.ContentCriteria copy() {
/*  52 */     return new com.nanosoft.amtk.service.criteria.ContentCriteria(this);
/*     */   }
/*     */   
/*     */   public LongFilter getId() {
/*  56 */     return this.id;
/*     */   }
/*     */   
/*     */   public LongFilter id() {
/*  60 */     if (this.id == null) {
/*  61 */       this.id = new LongFilter();
/*     */     }
/*  63 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(LongFilter id) {
/*  67 */     this.id = id;
/*     */   }
/*     */   
/*     */   public StringFilter getCreatedBy() {
/*  71 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public StringFilter createdBy() {
/*  75 */     if (this.createdBy == null) {
/*  76 */       this.createdBy = new StringFilter();
/*     */     }
/*  78 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(StringFilter createdBy) {
/*  82 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getCreatedDate() {
/*  86 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public InstantFilter createdDate() {
/*  90 */     if (this.createdDate == null) {
/*  91 */       this.createdDate = new InstantFilter();
/*     */     }
/*  93 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(InstantFilter createdDate) {
/*  97 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public StringFilter getLastModifiedBy() {
/* 101 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public StringFilter lastModifiedBy() {
/* 105 */     if (this.lastModifiedBy == null) {
/* 106 */       this.lastModifiedBy = new StringFilter();
/*     */     }
/* 108 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(StringFilter lastModifiedBy) {
/* 112 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getLastModifiedDate() {
/* 116 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public InstantFilter lastModifiedDate() {
/* 120 */     if (this.lastModifiedDate == null) {
/* 121 */       this.lastModifiedDate = new InstantFilter();
/*     */     }
/* 123 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(InstantFilter lastModifiedDate) {
/* 127 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public LongFilter getAttachmentId() {
/* 131 */     return this.attachmentId;
/*     */   }
/*     */   
/*     */   public LongFilter attachmentId() {
/* 135 */     if (this.attachmentId == null) {
/* 136 */       this.attachmentId = new LongFilter();
/*     */     }
/* 138 */     return this.attachmentId;
/*     */   }
/*     */   
/*     */   public void setAttachmentId(LongFilter attachmentId) {
/* 142 */     this.attachmentId = attachmentId;
/*     */   }
/*     */   
/*     */   public Boolean getDistinct() {
/* 146 */     return this.distinct;
/*     */   }
/*     */   
/*     */   public void setDistinct(Boolean distinct) {
/* 150 */     this.distinct = distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 155 */     if (this == o) {
/* 156 */       return true;
/*     */     }
/* 158 */     if (o == null || getClass() != o.getClass()) {
/* 159 */       return false;
/*     */     }
/* 161 */     com.nanosoft.amtk.service.criteria.ContentCriteria that = (com.nanosoft.amtk.service.criteria.ContentCriteria)o;
/* 162 */     return (
/* 163 */       Objects.equals(this.id, that.id) && 
/* 164 */       Objects.equals(this.createdBy, that.createdBy) && 
/* 165 */       Objects.equals(this.createdDate, that.createdDate) && 
/* 166 */       Objects.equals(this.lastModifiedBy, that.lastModifiedBy) && 
/* 167 */       Objects.equals(this.lastModifiedDate, that.lastModifiedDate) && 
/* 168 */       Objects.equals(this.attachmentId, that.attachmentId) && 
/* 169 */       Objects.equals(this.distinct, that.distinct));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 175 */     return Objects.hash(new Object[] { this.id, this.createdBy, this.createdDate, this.lastModifiedBy, this.lastModifiedDate, this.attachmentId, this.distinct });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 182 */     return "ContentCriteria{" + ((this.id != null) ? ("id=" + this.id + ", ") : "") + (
/* 183 */       (this.createdBy != null) ? ("createdBy=" + this.createdBy + ", ") : "") + (
/* 184 */       (this.createdDate != null) ? ("createdDate=" + this.createdDate + ", ") : "") + (
/* 185 */       (this.lastModifiedBy != null) ? ("lastModifiedBy=" + this.lastModifiedBy + ", ") : "") + (
/* 186 */       (this.lastModifiedDate != null) ? ("lastModifiedDate=" + this.lastModifiedDate + ", ") : "") + (
/* 187 */       (this.attachmentId != null) ? ("attachmentId=" + this.attachmentId + ", ") : "") + (
/* 188 */       (this.distinct != null) ? ("distinct=" + this.distinct + ", ") : "") + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\criteria\ContentCriteria.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */