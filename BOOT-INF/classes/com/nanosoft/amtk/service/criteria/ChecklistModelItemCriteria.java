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
/*     */ public class ChecklistModelItemCriteria
/*     */   implements Serializable, Criteria
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private LongFilter id;
/*     */   private StringFilter text;
/*     */   private StringFilter itemGroup;
/*     */   private StringFilter validator;
/*     */   private StringFilter createdBy;
/*     */   private InstantFilter createdDate;
/*     */   private StringFilter lastModifiedBy;
/*     */   private InstantFilter lastModifiedDate;
/*     */   private LongFilter checklistModelId;
/*     */   private Boolean distinct;
/*     */   
/*     */   public ChecklistModelItemCriteria() {}
/*     */   
/*     */   public ChecklistModelItemCriteria(com.nanosoft.amtk.service.criteria.ChecklistModelItemCriteria other) {
/*  47 */     this.id = (other.id == null) ? null : other.id.copy();
/*  48 */     this.text = (other.text == null) ? null : other.text.copy();
/*  49 */     this.itemGroup = (other.itemGroup == null) ? null : other.itemGroup.copy();
/*  50 */     this.validator = (other.validator == null) ? null : other.validator.copy();
/*  51 */     this.createdBy = (other.createdBy == null) ? null : other.createdBy.copy();
/*  52 */     this.createdDate = (other.createdDate == null) ? null : other.createdDate.copy();
/*  53 */     this.lastModifiedBy = (other.lastModifiedBy == null) ? null : other.lastModifiedBy.copy();
/*  54 */     this.lastModifiedDate = (other.lastModifiedDate == null) ? null : other.lastModifiedDate.copy();
/*  55 */     this.checklistModelId = (other.checklistModelId == null) ? null : other.checklistModelId.copy();
/*  56 */     this.distinct = other.distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public com.nanosoft.amtk.service.criteria.ChecklistModelItemCriteria copy() {
/*  61 */     return new com.nanosoft.amtk.service.criteria.ChecklistModelItemCriteria(this);
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
/*     */   public StringFilter getText() {
/*  80 */     return this.text;
/*     */   }
/*     */   
/*     */   public StringFilter text() {
/*  84 */     if (this.text == null) {
/*  85 */       this.text = new StringFilter();
/*     */     }
/*  87 */     return this.text;
/*     */   }
/*     */   
/*     */   public void setText(StringFilter text) {
/*  91 */     this.text = text;
/*     */   }
/*     */   
/*     */   public StringFilter getItemGroup() {
/*  95 */     return this.itemGroup;
/*     */   }
/*     */   
/*     */   public StringFilter itemGroup() {
/*  99 */     if (this.itemGroup == null) {
/* 100 */       this.itemGroup = new StringFilter();
/*     */     }
/* 102 */     return this.itemGroup;
/*     */   }
/*     */   
/*     */   public void setItemGroup(StringFilter itemGroup) {
/* 106 */     this.itemGroup = itemGroup;
/*     */   }
/*     */   
/*     */   public StringFilter getValidator() {
/* 110 */     return this.validator;
/*     */   }
/*     */   
/*     */   public StringFilter validator() {
/* 114 */     if (this.validator == null) {
/* 115 */       this.validator = new StringFilter();
/*     */     }
/* 117 */     return this.validator;
/*     */   }
/*     */   
/*     */   public void setValidator(StringFilter validator) {
/* 121 */     this.validator = validator;
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
/*     */   public LongFilter getChecklistModelId() {
/* 185 */     return this.checklistModelId;
/*     */   }
/*     */   
/*     */   public LongFilter checklistModelId() {
/* 189 */     if (this.checklistModelId == null) {
/* 190 */       this.checklistModelId = new LongFilter();
/*     */     }
/* 192 */     return this.checklistModelId;
/*     */   }
/*     */   
/*     */   public void setChecklistModelId(LongFilter checklistModelId) {
/* 196 */     this.checklistModelId = checklistModelId;
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
/* 215 */     com.nanosoft.amtk.service.criteria.ChecklistModelItemCriteria that = (com.nanosoft.amtk.service.criteria.ChecklistModelItemCriteria)o;
/* 216 */     return (
/* 217 */       Objects.equals(this.id, that.id) && 
/* 218 */       Objects.equals(this.text, that.text) && 
/* 219 */       Objects.equals(this.itemGroup, that.itemGroup) && 
/* 220 */       Objects.equals(this.validator, that.validator) && 
/* 221 */       Objects.equals(this.createdBy, that.createdBy) && 
/* 222 */       Objects.equals(this.createdDate, that.createdDate) && 
/* 223 */       Objects.equals(this.lastModifiedBy, that.lastModifiedBy) && 
/* 224 */       Objects.equals(this.lastModifiedDate, that.lastModifiedDate) && 
/* 225 */       Objects.equals(this.checklistModelId, that.checklistModelId) && 
/* 226 */       Objects.equals(this.distinct, that.distinct));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 232 */     return Objects.hash(new Object[] { this.id, this.text, this.itemGroup, this.validator, this.createdBy, this.createdDate, this.lastModifiedBy, this.lastModifiedDate, this.checklistModelId, this.distinct });
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
/* 250 */     return "ChecklistModelItemCriteria{" + ((this.id != null) ? ("id=" + this.id + ", ") : "") + (
/* 251 */       (this.text != null) ? ("text=" + this.text + ", ") : "") + (
/* 252 */       (this.itemGroup != null) ? ("itemGroup=" + this.itemGroup + ", ") : "") + (
/* 253 */       (this.validator != null) ? ("validator=" + this.validator + ", ") : "") + (
/* 254 */       (this.createdBy != null) ? ("createdBy=" + this.createdBy + ", ") : "") + (
/* 255 */       (this.createdDate != null) ? ("createdDate=" + this.createdDate + ", ") : "") + (
/* 256 */       (this.lastModifiedBy != null) ? ("lastModifiedBy=" + this.lastModifiedBy + ", ") : "") + (
/* 257 */       (this.lastModifiedDate != null) ? ("lastModifiedDate=" + this.lastModifiedDate + ", ") : "") + (
/* 258 */       (this.checklistModelId != null) ? ("checklistModelId=" + this.checklistModelId + ", ") : "") + (
/* 259 */       (this.distinct != null) ? ("distinct=" + this.distinct + ", ") : "") + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\criteria\ChecklistModelItemCriteria.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */