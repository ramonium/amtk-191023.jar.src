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
/*     */ public class UserInfoCriteria
/*     */   implements Serializable, Criteria
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private LongFilter id;
/*     */   private StringFilter description;
/*     */   private StringFilter createdBy;
/*     */   private InstantFilter createdDate;
/*     */   private StringFilter lastModifiedBy;
/*     */   private InstantFilter lastModifiedDate;
/*     */   private LongFilter userId;
/*     */   private StringFilter userLogin;
/*     */   private LongFilter relatedEmployeeId;
/*     */   private Boolean distinct;
/*     */   
/*     */   public UserInfoCriteria() {}
/*     */   
/*     */   public UserInfoCriteria(com.nanosoft.amtk.service.criteria.UserInfoCriteria other) {
/*  47 */     this.id = (other.id == null) ? null : other.id.copy();
/*  48 */     this.description = (other.description == null) ? null : other.description.copy();
/*  49 */     this.createdBy = (other.createdBy == null) ? null : other.createdBy.copy();
/*  50 */     this.createdDate = (other.createdDate == null) ? null : other.createdDate.copy();
/*  51 */     this.lastModifiedBy = (other.lastModifiedBy == null) ? null : other.lastModifiedBy.copy();
/*  52 */     this.lastModifiedDate = (other.lastModifiedDate == null) ? null : other.lastModifiedDate.copy();
/*  53 */     this.userId = (other.userId == null) ? null : other.userId.copy();
/*  54 */     this.userLogin = (other.userLogin == null) ? null : other.userLogin.copy();
/*  55 */     this.relatedEmployeeId = (other.relatedEmployeeId == null) ? null : other.relatedEmployeeId.copy();
/*  56 */     this.distinct = other.distinct;
/*     */   }
/*     */ 
/*     */   
/*     */   public com.nanosoft.amtk.service.criteria.UserInfoCriteria copy() {
/*  61 */     return new com.nanosoft.amtk.service.criteria.UserInfoCriteria(this);
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
/*     */   public StringFilter getDescription() {
/*  80 */     return this.description;
/*     */   }
/*     */   
/*     */   public StringFilter description() {
/*  84 */     if (this.description == null) {
/*  85 */       this.description = new StringFilter();
/*     */     }
/*  87 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(StringFilter description) {
/*  91 */     this.description = description;
/*     */   }
/*     */   
/*     */   public StringFilter getCreatedBy() {
/*  95 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public StringFilter createdBy() {
/*  99 */     if (this.createdBy == null) {
/* 100 */       this.createdBy = new StringFilter();
/*     */     }
/* 102 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(StringFilter createdBy) {
/* 106 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getCreatedDate() {
/* 110 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public InstantFilter createdDate() {
/* 114 */     if (this.createdDate == null) {
/* 115 */       this.createdDate = new InstantFilter();
/*     */     }
/* 117 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(InstantFilter createdDate) {
/* 121 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public StringFilter getLastModifiedBy() {
/* 125 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public StringFilter lastModifiedBy() {
/* 129 */     if (this.lastModifiedBy == null) {
/* 130 */       this.lastModifiedBy = new StringFilter();
/*     */     }
/* 132 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(StringFilter lastModifiedBy) {
/* 136 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public InstantFilter getLastModifiedDate() {
/* 140 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public InstantFilter lastModifiedDate() {
/* 144 */     if (this.lastModifiedDate == null) {
/* 145 */       this.lastModifiedDate = new InstantFilter();
/*     */     }
/* 147 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(InstantFilter lastModifiedDate) {
/* 151 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public LongFilter getUserId() {
/* 155 */     return this.userId;
/*     */   }
/*     */   
/*     */   public LongFilter userId() {
/* 159 */     if (this.userId == null) {
/* 160 */       this.userId = new LongFilter();
/*     */     }
/* 162 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(LongFilter userId) {
/* 166 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public StringFilter getUserLogin() {
/* 170 */     return this.userLogin;
/*     */   }
/*     */   
/*     */   public StringFilter userLogin() {
/* 174 */     if (this.userLogin == null) {
/* 175 */       this.userLogin = new StringFilter();
/*     */     }
/* 177 */     return this.userLogin;
/*     */   }
/*     */   
/*     */   public void setUserLogin(StringFilter userLogin) {
/* 181 */     this.userLogin = userLogin;
/*     */   }
/*     */   
/*     */   public LongFilter getRelatedEmployeeId() {
/* 185 */     return this.relatedEmployeeId;
/*     */   }
/*     */   
/*     */   public LongFilter relatedEmployeeId() {
/* 189 */     if (this.relatedEmployeeId == null) {
/* 190 */       this.relatedEmployeeId = new LongFilter();
/*     */     }
/* 192 */     return this.relatedEmployeeId;
/*     */   }
/*     */   
/*     */   public void setRelatedEmployeeId(LongFilter relatedEmployeeId) {
/* 196 */     this.relatedEmployeeId = relatedEmployeeId;
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
/* 215 */     com.nanosoft.amtk.service.criteria.UserInfoCriteria that = (com.nanosoft.amtk.service.criteria.UserInfoCriteria)o;
/* 216 */     return (
/* 217 */       Objects.equals(this.id, that.id) && 
/* 218 */       Objects.equals(this.description, that.description) && 
/* 219 */       Objects.equals(this.createdBy, that.createdBy) && 
/* 220 */       Objects.equals(this.createdDate, that.createdDate) && 
/* 221 */       Objects.equals(this.lastModifiedBy, that.lastModifiedBy) && 
/* 222 */       Objects.equals(this.lastModifiedDate, that.lastModifiedDate) && 
/* 223 */       Objects.equals(this.userId, that.userId) && 
/* 224 */       Objects.equals(this.userLogin, that.userLogin) && 
/* 225 */       Objects.equals(this.relatedEmployeeId, that.relatedEmployeeId) && 
/* 226 */       Objects.equals(this.distinct, that.distinct));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 232 */     return Objects.hash(new Object[] { this.id, this.description, this.createdBy, this.createdDate, this.lastModifiedBy, this.lastModifiedDate, this.userId, this.userLogin, this.relatedEmployeeId, this.distinct });
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
/* 250 */     return "UserInfoCriteria{" + ((this.id != null) ? ("id=" + this.id + ", ") : "") + (
/* 251 */       (this.description != null) ? ("description=" + this.description + ", ") : "") + (
/* 252 */       (this.createdBy != null) ? ("createdBy=" + this.createdBy + ", ") : "") + (
/* 253 */       (this.createdDate != null) ? ("createdDate=" + this.createdDate + ", ") : "") + (
/* 254 */       (this.lastModifiedBy != null) ? ("lastModifiedBy=" + this.lastModifiedBy + ", ") : "") + (
/* 255 */       (this.lastModifiedDate != null) ? ("lastModifiedDate=" + this.lastModifiedDate + ", ") : "") + (
/* 256 */       (this.userId != null) ? ("userId=" + this.userId + ", ") : "") + (
/* 257 */       (this.userLogin != null) ? ("userLogin=" + this.userLogin + ", ") : "") + (
/* 258 */       (this.relatedEmployeeId != null) ? ("relatedEmployeeId=" + this.relatedEmployeeId + ", ") : "") + (
/* 259 */       (this.distinct != null) ? ("distinct=" + this.distinct + ", ") : "") + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\criteria\UserInfoCriteria.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */