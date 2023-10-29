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
/*     */ @ParameterObject
/*     */ public class AttachmentCriteria
/*     */   implements Serializable, Criteria
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private LongFilter id;
/*     */   private StringFilter title;
/*     */   private StringFilter fileName;
/*     */   private LongFilter fileSize;
/*     */   private StringFilter fileType;
/*     */   private StringFilter description;
/*     */   private StringFilter createdBy;
/*     */   private InstantFilter createdDate;
/*     */   private StringFilter lastModifiedBy;
/*     */   private InstantFilter lastModifiedDate;
/*     */   private LongFilter contentId;
/*     */   private LongFilter employeeId;
/*     */   private Boolean distinct;
/*     */   
/*     */   public AttachmentCriteria() {}
/*     */   
/*     */   public AttachmentCriteria(com.nanosoft.amtk.service.criteria.AttachmentCriteria other) {
/*  53 */     this.id = (other.id == null) ? null : other.id.copy();
/*  54 */     this.title = (other.title == null) ? null : other.title.copy();
/*  55 */     this.fileName = (other.fileName == null) ? null : other.fileName.copy();
/*  56 */     this.fileSize = (other.fileSize == null) ? null : other.fileSize.copy();
/*  57 */     this.fileType = (other.fileType == null) ? null : other.fileType.copy();
/*  58 */     this.description = (other.description == null) ? null : other.description.copy();
/*  59 */     this.createdBy = (other.createdBy == null) ? null : other.createdBy.copy();
/*  60 */     this.createdDate = (other.createdDate == null) ? null : other.createdDate.copy();
/*  61 */     this.lastModifiedBy = (other.lastModifiedBy == null) ? null : other.lastModifiedBy.copy();
/*  62 */     this.lastModifiedDate = (other.lastModifiedDate == null) ? null : other.lastModifiedDate.copy();
/*  63 */     this.contentId = (other.contentId == null) ? null : other.contentId.copy();
/*  64 */     this.employeeId = (other.employeeId == null) ? null : other.employeeId.copy();
/*  65 */     this.distinct = other.distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public com.nanosoft.amtk.service.criteria.AttachmentCriteria copy() {
/*  70 */     return new com.nanosoft.amtk.service.criteria.AttachmentCriteria(this);
/*     */   }
/*     */   
/*     */   public LongFilter getId() {
/*  74 */     return this.id;
/*     */   }
/*     */   
/*     */   public LongFilter id() {
/*  78 */     if (this.id == null) {
/*  79 */       this.id = new LongFilter();
/*     */     }
/*  81 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(LongFilter id) {
/*  85 */     this.id = id;
/*     */   }
/*     */   
/*     */   public StringFilter getTitle() {
/*  89 */     return this.title;
/*     */   }
/*     */   
/*     */   public StringFilter title() {
/*  93 */     if (this.title == null) {
/*  94 */       this.title = new StringFilter();
/*     */     }
/*  96 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(StringFilter title) {
/* 100 */     this.title = title;
/*     */   }
/*     */   
/*     */   public StringFilter getFileName() {
/* 104 */     return this.fileName;
/*     */   }
/*     */   
/*     */   public StringFilter fileName() {
/* 108 */     if (this.fileName == null) {
/* 109 */       this.fileName = new StringFilter();
/*     */     }
/* 111 */     return this.fileName;
/*     */   }
/*     */   
/*     */   public void setFileName(StringFilter fileName) {
/* 115 */     this.fileName = fileName;
/*     */   }
/*     */   
/*     */   public LongFilter getFileSize() {
/* 119 */     return this.fileSize;
/*     */   }
/*     */   
/*     */   public LongFilter fileSize() {
/* 123 */     if (this.fileSize == null) {
/* 124 */       this.fileSize = new LongFilter();
/*     */     }
/* 126 */     return this.fileSize;
/*     */   }
/*     */   
/*     */   public void setFileSize(LongFilter fileSize) {
/* 130 */     this.fileSize = fileSize;
/*     */   }
/*     */   
/*     */   public StringFilter getFileType() {
/* 134 */     return this.fileType;
/*     */   }
/*     */   
/*     */   public StringFilter fileType() {
/* 138 */     if (this.fileType == null) {
/* 139 */       this.fileType = new StringFilter();
/*     */     }
/* 141 */     return this.fileType;
/*     */   }
/*     */   
/*     */   public void setFileType(StringFilter fileType) {
/* 145 */     this.fileType = fileType;
/*     */   }
/*     */   
/*     */   public StringFilter getDescription() {
/* 149 */     return this.description;
/*     */   }
/*     */   
/*     */   public StringFilter description() {
/* 153 */     if (this.description == null) {
/* 154 */       this.description = new StringFilter();
/*     */     }
/* 156 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(StringFilter description) {
/* 160 */     this.description = description;
/*     */   }
/*     */   
/*     */   public StringFilter getCreatedBy() {
/* 164 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public StringFilter createdBy() {
/* 168 */     if (this.createdBy == null) {
/* 169 */       this.createdBy = new StringFilter();
/*     */     }
/* 171 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(StringFilter createdBy) {
/* 175 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getCreatedDate() {
/* 179 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public InstantFilter createdDate() {
/* 183 */     if (this.createdDate == null) {
/* 184 */       this.createdDate = new InstantFilter();
/*     */     }
/* 186 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(InstantFilter createdDate) {
/* 190 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public StringFilter getLastModifiedBy() {
/* 194 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public StringFilter lastModifiedBy() {
/* 198 */     if (this.lastModifiedBy == null) {
/* 199 */       this.lastModifiedBy = new StringFilter();
/*     */     }
/* 201 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(StringFilter lastModifiedBy) {
/* 205 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getLastModifiedDate() {
/* 209 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public InstantFilter lastModifiedDate() {
/* 213 */     if (this.lastModifiedDate == null) {
/* 214 */       this.lastModifiedDate = new InstantFilter();
/*     */     }
/* 216 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(InstantFilter lastModifiedDate) {
/* 220 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public LongFilter getContentId() {
/* 224 */     return this.contentId;
/*     */   }
/*     */   
/*     */   public LongFilter contentId() {
/* 228 */     if (this.contentId == null) {
/* 229 */       this.contentId = new LongFilter();
/*     */     }
/* 231 */     return this.contentId;
/*     */   }
/*     */   
/*     */   public void setContentId(LongFilter contentId) {
/* 235 */     this.contentId = contentId;
/*     */   }
/*     */   
/*     */   public LongFilter getEmployeeId() {
/* 239 */     return this.employeeId;
/*     */   }
/*     */   
/*     */   public LongFilter employeeId() {
/* 243 */     if (this.employeeId == null) {
/* 244 */       this.employeeId = new LongFilter();
/*     */     }
/* 246 */     return this.employeeId;
/*     */   }
/*     */   
/*     */   public void setEmployeeId(LongFilter employeeId) {
/* 250 */     this.employeeId = employeeId;
/*     */   }
/*     */   
/*     */   public Boolean getDistinct() {
/* 254 */     return this.distinct;
/*     */   }
/*     */   
/*     */   public void setDistinct(Boolean distinct) {
/* 258 */     this.distinct = distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 263 */     if (this == o) {
/* 264 */       return true;
/*     */     }
/* 266 */     if (o == null || getClass() != o.getClass()) {
/* 267 */       return false;
/*     */     }
/* 269 */     com.nanosoft.amtk.service.criteria.AttachmentCriteria that = (com.nanosoft.amtk.service.criteria.AttachmentCriteria)o;
/* 270 */     return (
/* 271 */       Objects.equals(this.id, that.id) && 
/* 272 */       Objects.equals(this.title, that.title) && 
/* 273 */       Objects.equals(this.fileName, that.fileName) && 
/* 274 */       Objects.equals(this.fileSize, that.fileSize) && 
/* 275 */       Objects.equals(this.fileType, that.fileType) && 
/* 276 */       Objects.equals(this.description, that.description) && 
/* 277 */       Objects.equals(this.createdBy, that.createdBy) && 
/* 278 */       Objects.equals(this.createdDate, that.createdDate) && 
/* 279 */       Objects.equals(this.lastModifiedBy, that.lastModifiedBy) && 
/* 280 */       Objects.equals(this.lastModifiedDate, that.lastModifiedDate) && 
/* 281 */       Objects.equals(this.contentId, that.contentId) && 
/* 282 */       Objects.equals(this.employeeId, that.employeeId) && 
/* 283 */       Objects.equals(this.distinct, that.distinct));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 289 */     return Objects.hash(new Object[] { this.id, this.title, this.fileName, this.fileSize, this.fileType, this.description, this.createdBy, this.createdDate, this.lastModifiedBy, this.lastModifiedDate, this.contentId, this.employeeId, this.distinct });
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
/*     */   public String toString() {
/* 310 */     return "AttachmentCriteria{" + ((this.id != null) ? ("id=" + this.id + ", ") : "") + (
/* 311 */       (this.title != null) ? ("title=" + this.title + ", ") : "") + (
/* 312 */       (this.fileName != null) ? ("fileName=" + this.fileName + ", ") : "") + (
/* 313 */       (this.fileSize != null) ? ("fileSize=" + this.fileSize + ", ") : "") + (
/* 314 */       (this.fileType != null) ? ("fileType=" + this.fileType + ", ") : "") + (
/* 315 */       (this.description != null) ? ("description=" + this.description + ", ") : "") + (
/* 316 */       (this.createdBy != null) ? ("createdBy=" + this.createdBy + ", ") : "") + (
/* 317 */       (this.createdDate != null) ? ("createdDate=" + this.createdDate + ", ") : "") + (
/* 318 */       (this.lastModifiedBy != null) ? ("lastModifiedBy=" + this.lastModifiedBy + ", ") : "") + (
/* 319 */       (this.lastModifiedDate != null) ? ("lastModifiedDate=" + this.lastModifiedDate + ", ") : "") + (
/* 320 */       (this.contentId != null) ? ("contentId=" + this.contentId + ", ") : "") + (
/* 321 */       (this.employeeId != null) ? ("employeeId=" + this.employeeId + ", ") : "") + (
/* 322 */       (this.distinct != null) ? ("distinct=" + this.distinct + ", ") : "") + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\criteria\AttachmentCriteria.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */