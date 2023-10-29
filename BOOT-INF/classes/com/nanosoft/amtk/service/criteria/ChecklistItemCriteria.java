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
/*     */ @ParameterObject
/*     */ public class ChecklistItemCriteria
/*     */   implements Serializable, Criteria
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private LongFilter id;
/*     */   private StringFilter text;
/*     */   private StringFilter itemGroup;
/*     */   private StringFilter validatorRole;
/*     */   private StringFilter validator;
/*     */   private BooleanFilter isChecked;
/*     */   private StringFilter createdBy;
/*     */   private InstantFilter createdDate;
/*     */   private StringFilter lastModifiedBy;
/*     */   private InstantFilter lastModifiedDate;
/*     */   private LongFilter checklistId;
/*     */   private Boolean distinct;
/*     */   
/*     */   public ChecklistItemCriteria() {}
/*     */   
/*     */   public ChecklistItemCriteria(com.nanosoft.amtk.service.criteria.ChecklistItemCriteria other) {
/*  51 */     this.id = (other.id == null) ? null : other.id.copy();
/*  52 */     this.text = (other.text == null) ? null : other.text.copy();
/*  53 */     this.itemGroup = (other.itemGroup == null) ? null : other.itemGroup.copy();
/*  54 */     this.validatorRole = (other.validatorRole == null) ? null : other.validatorRole.copy();
/*  55 */     this.validator = (other.validator == null) ? null : other.validator.copy();
/*  56 */     this.isChecked = (other.isChecked == null) ? null : other.isChecked.copy();
/*  57 */     this.createdBy = (other.createdBy == null) ? null : other.createdBy.copy();
/*  58 */     this.createdDate = (other.createdDate == null) ? null : other.createdDate.copy();
/*  59 */     this.lastModifiedBy = (other.lastModifiedBy == null) ? null : other.lastModifiedBy.copy();
/*  60 */     this.lastModifiedDate = (other.lastModifiedDate == null) ? null : other.lastModifiedDate.copy();
/*  61 */     this.checklistId = (other.checklistId == null) ? null : other.checklistId.copy();
/*  62 */     this.distinct = other.distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public com.nanosoft.amtk.service.criteria.ChecklistItemCriteria copy() {
/*  67 */     return new com.nanosoft.amtk.service.criteria.ChecklistItemCriteria(this);
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
/*     */   public StringFilter getText() {
/*  86 */     return this.text;
/*     */   }
/*     */   
/*     */   public StringFilter text() {
/*  90 */     if (this.text == null) {
/*  91 */       this.text = new StringFilter();
/*     */     }
/*  93 */     return this.text;
/*     */   }
/*     */   
/*     */   public void setText(StringFilter text) {
/*  97 */     this.text = text;
/*     */   }
/*     */   
/*     */   public StringFilter getItemGroup() {
/* 101 */     return this.itemGroup;
/*     */   }
/*     */   
/*     */   public StringFilter itemGroup() {
/* 105 */     if (this.itemGroup == null) {
/* 106 */       this.itemGroup = new StringFilter();
/*     */     }
/* 108 */     return this.itemGroup;
/*     */   }
/*     */   
/*     */   public void setItemGroup(StringFilter itemGroup) {
/* 112 */     this.itemGroup = itemGroup;
/*     */   }
/*     */   
/*     */   public StringFilter getValidatorRole() {
/* 116 */     return this.validatorRole;
/*     */   }
/*     */   
/*     */   public StringFilter validatorRole() {
/* 120 */     if (this.validatorRole == null) {
/* 121 */       this.validatorRole = new StringFilter();
/*     */     }
/* 123 */     return this.validatorRole;
/*     */   }
/*     */   
/*     */   public void setValidatorRole(StringFilter validatorRole) {
/* 127 */     this.validatorRole = validatorRole;
/*     */   }
/*     */   
/*     */   public StringFilter getValidator() {
/* 131 */     return this.validator;
/*     */   }
/*     */   
/*     */   public StringFilter validator() {
/* 135 */     if (this.validator == null) {
/* 136 */       this.validator = new StringFilter();
/*     */     }
/* 138 */     return this.validator;
/*     */   }
/*     */   
/*     */   public void setValidator(StringFilter validator) {
/* 142 */     this.validator = validator;
/*     */   }
/*     */   
/*     */   public BooleanFilter getIsChecked() {
/* 146 */     return this.isChecked;
/*     */   }
/*     */   
/*     */   public BooleanFilter isChecked() {
/* 150 */     if (this.isChecked == null) {
/* 151 */       this.isChecked = new BooleanFilter();
/*     */     }
/* 153 */     return this.isChecked;
/*     */   }
/*     */   
/*     */   public void setIsChecked(BooleanFilter isChecked) {
/* 157 */     this.isChecked = isChecked;
/*     */   }
/*     */   
/*     */   public StringFilter getCreatedBy() {
/* 161 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public StringFilter createdBy() {
/* 165 */     if (this.createdBy == null) {
/* 166 */       this.createdBy = new StringFilter();
/*     */     }
/* 168 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(StringFilter createdBy) {
/* 172 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getCreatedDate() {
/* 176 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public InstantFilter createdDate() {
/* 180 */     if (this.createdDate == null) {
/* 181 */       this.createdDate = new InstantFilter();
/*     */     }
/* 183 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(InstantFilter createdDate) {
/* 187 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public StringFilter getLastModifiedBy() {
/* 191 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public StringFilter lastModifiedBy() {
/* 195 */     if (this.lastModifiedBy == null) {
/* 196 */       this.lastModifiedBy = new StringFilter();
/*     */     }
/* 198 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(StringFilter lastModifiedBy) {
/* 202 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getLastModifiedDate() {
/* 206 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public InstantFilter lastModifiedDate() {
/* 210 */     if (this.lastModifiedDate == null) {
/* 211 */       this.lastModifiedDate = new InstantFilter();
/*     */     }
/* 213 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(InstantFilter lastModifiedDate) {
/* 217 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public LongFilter getChecklistId() {
/* 221 */     return this.checklistId;
/*     */   }
/*     */   
/*     */   public LongFilter checklistId() {
/* 225 */     if (this.checklistId == null) {
/* 226 */       this.checklistId = new LongFilter();
/*     */     }
/* 228 */     return this.checklistId;
/*     */   }
/*     */   
/*     */   public void setChecklistId(LongFilter checklistId) {
/* 232 */     this.checklistId = checklistId;
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
/* 251 */     com.nanosoft.amtk.service.criteria.ChecklistItemCriteria that = (com.nanosoft.amtk.service.criteria.ChecklistItemCriteria)o;
/* 252 */     return (
/* 253 */       Objects.equals(this.id, that.id) && 
/* 254 */       Objects.equals(this.text, that.text) && 
/* 255 */       Objects.equals(this.itemGroup, that.itemGroup) && 
/* 256 */       Objects.equals(this.validatorRole, that.validatorRole) && 
/* 257 */       Objects.equals(this.validator, that.validator) && 
/* 258 */       Objects.equals(this.isChecked, that.isChecked) && 
/* 259 */       Objects.equals(this.createdBy, that.createdBy) && 
/* 260 */       Objects.equals(this.createdDate, that.createdDate) && 
/* 261 */       Objects.equals(this.lastModifiedBy, that.lastModifiedBy) && 
/* 262 */       Objects.equals(this.lastModifiedDate, that.lastModifiedDate) && 
/* 263 */       Objects.equals(this.checklistId, that.checklistId) && 
/* 264 */       Objects.equals(this.distinct, that.distinct));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 270 */     return Objects.hash(new Object[] { this.id, this.text, this.itemGroup, this.validatorRole, this.validator, this.isChecked, this.createdBy, this.createdDate, this.lastModifiedBy, this.lastModifiedDate, this.checklistId, this.distinct });
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
/* 290 */     return "ChecklistItemCriteria{" + ((this.id != null) ? ("id=" + this.id + ", ") : "") + (
/* 291 */       (this.text != null) ? ("text=" + this.text + ", ") : "") + (
/* 292 */       (this.itemGroup != null) ? ("itemGroup=" + this.itemGroup + ", ") : "") + (
/* 293 */       (this.validatorRole != null) ? ("validatorRole=" + this.validatorRole + ", ") : "") + (
/* 294 */       (this.validator != null) ? ("validator=" + this.validator + ", ") : "") + (
/* 295 */       (this.isChecked != null) ? ("isChecked=" + this.isChecked + ", ") : "") + (
/* 296 */       (this.createdBy != null) ? ("createdBy=" + this.createdBy + ", ") : "") + (
/* 297 */       (this.createdDate != null) ? ("createdDate=" + this.createdDate + ", ") : "") + (
/* 298 */       (this.lastModifiedBy != null) ? ("lastModifiedBy=" + this.lastModifiedBy + ", ") : "") + (
/* 299 */       (this.lastModifiedDate != null) ? ("lastModifiedDate=" + this.lastModifiedDate + ", ") : "") + (
/* 300 */       (this.checklistId != null) ? ("checklistId=" + this.checklistId + ", ") : "") + (
/* 301 */       (this.distinct != null) ? ("distinct=" + this.distinct + ", ") : "") + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\criteria\ChecklistItemCriteria.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */