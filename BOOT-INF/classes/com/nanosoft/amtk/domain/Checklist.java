/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.nanosoft.amtk.domain.AbstractAuditingEntity;
/*     */ import com.nanosoft.amtk.domain.Certificate;
/*     */ import com.nanosoft.amtk.domain.ChecklistItem;
/*     */ import com.nanosoft.amtk.domain.ChecklistModel;
/*     */ import com.nanosoft.amtk.domain.enumeration.ChecklistStatus;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import javax.persistence.CascadeType;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.EnumType;
/*     */ import javax.persistence.Enumerated;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.OneToOne;
/*     */ import javax.persistence.SequenceGenerator;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import org.hibernate.annotations.Cache;
/*     */ import org.hibernate.annotations.CacheConcurrencyStrategy;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "checklist")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class Checklist
/*     */   extends AbstractAuditingEntity
/*     */   implements Serializable {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
/*     */   @SequenceGenerator(name = "sequenceGenerator")
/*     */   @Column(name = "id")
/*     */   private Long id;
/*     */   @NotNull
/*     */   @Column(name = "title", nullable = false)
/*     */   private String title;
/*     */   @Column(name = "validator_check")
/*  46 */   private Boolean validatorCheck = Boolean.valueOf(false);
/*     */   
/*     */   @Column(name = "description")
/*     */   private String description;
/*     */   
/*     */   @NotNull
/*     */   @Column(name = "validator_role", nullable = false)
/*     */   private String validatorRole;
/*     */   @Column(name = "validator_2_check")
/*  55 */   private Boolean validator2Check = Boolean.valueOf(false);
/*     */   
/*     */   @Column(name = "validator")
/*     */   private String validator;
/*     */   
/*     */   @Column(name = "validator_role_2")
/*     */   private String validatorRole2;
/*     */   
/*     */   @Column(name = "validator_3_check")
/*  64 */   private Boolean validator3Check = Boolean.valueOf(false); @Column(name = "validator_2")
/*     */   private String validator2; @Column(name = "validator_role_3")
/*     */   private String validatorRole3; @Column(name = "validator_3")
/*     */   private String validator3;
/*     */   @Column(name = "validator_role_4")
/*     */   private String validatorRole4;
/*     */   @Column(name = "validator_4")
/*     */   private String validator4;
/*     */   @Column(name = "validator_4_check")
/*  73 */   private Boolean validator4Check = Boolean.valueOf(false);
/*     */   
/*     */   @Enumerated(EnumType.STRING)
/*     */   @Column(name = "status")
/*     */   private ChecklistStatus status;
/*     */   @JsonIgnoreProperties(value = {"assignment", "level", "checklist"}, allowSetters = true)
/*     */   @OneToOne(mappedBy = "checklist")
/*     */   private Certificate certificate;
/*     */   @ManyToOne
/*     */   @JsonIgnoreProperties(value = {"certificationLevels", "checklists", "checklistModelItems"}, allowSetters = true)
/*     */   private ChecklistModel checklistModel;
/*     */   @OneToMany(mappedBy = "checklist", cascade = {CascadeType.ALL})
/*     */   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */   @JsonIgnoreProperties(value = {"checklist"}, allowSetters = true)
/*  87 */   private Set<ChecklistItem> checklistItems = new HashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getId() {
/*  95 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist id(Long id) {
/*  99 */     setId(id);
/* 100 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/* 104 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getTitle() {
/* 108 */     return this.title;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist title(String title) {
/* 112 */     setTitle(title);
/* 113 */     return this;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/* 117 */     this.title = title;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 121 */     return this.description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist description(String description) {
/* 125 */     setDescription(description);
/* 126 */     return this;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 130 */     this.description = description;
/*     */   }
/*     */   
/*     */   public String getValidatorRole() {
/* 134 */     return this.validatorRole;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist validatorRole(String validatorRole) {
/* 138 */     setValidatorRole(validatorRole);
/* 139 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidatorRole(String validatorRole) {
/* 143 */     this.validatorRole = validatorRole;
/*     */   }
/*     */   
/*     */   public String getValidator() {
/* 147 */     return this.validator;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist validator(String validator) {
/* 151 */     setValidator(validator);
/* 152 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidator(String validator) {
/* 156 */     this.validator = validator;
/*     */   }
/*     */   
/*     */   public Boolean getValidatorCheck() {
/* 160 */     return this.validatorCheck;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist validatorCheck(Boolean validatorCheck) {
/* 164 */     setValidatorCheck(validatorCheck);
/* 165 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidatorCheck(Boolean validatorCheck) {
/* 169 */     this.validatorCheck = validatorCheck;
/*     */   }
/*     */   
/*     */   public String getValidatorRole2() {
/* 173 */     return this.validatorRole2;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist validatorRole2(String validatorRole2) {
/* 177 */     setValidatorRole2(validatorRole2);
/* 178 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidatorRole2(String validatorRole2) {
/* 182 */     this.validatorRole2 = validatorRole2;
/*     */   }
/*     */   
/*     */   public String getValidator2() {
/* 186 */     return this.validator2;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist validator2(String validator2) {
/* 190 */     setValidator2(validator2);
/* 191 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidator2(String validator2) {
/* 195 */     this.validator2 = validator2;
/*     */   }
/*     */   
/*     */   public Boolean getValidator2Check() {
/* 199 */     return this.validator2Check;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist validator2Check(Boolean validator2Check) {
/* 203 */     setValidator2Check(validator2Check);
/* 204 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidator2Check(Boolean validator2Check) {
/* 208 */     this.validator2Check = validator2Check;
/*     */   }
/*     */   
/*     */   public String getValidatorRole3() {
/* 212 */     return this.validatorRole3;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist validatorRole3(String validatorRole3) {
/* 216 */     setValidatorRole3(validatorRole3);
/* 217 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidatorRole3(String validatorRole3) {
/* 221 */     this.validatorRole3 = validatorRole3;
/*     */   }
/*     */   
/*     */   public String getValidator3() {
/* 225 */     return this.validator3;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist validator3(String validator3) {
/* 229 */     setValidator3(validator3);
/* 230 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidator3(String validator3) {
/* 234 */     this.validator3 = validator3;
/*     */   }
/*     */   
/*     */   public Boolean getValidator3Check() {
/* 238 */     return this.validator3Check;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist validator3Check(Boolean validator3Check) {
/* 242 */     setValidator3Check(validator3Check);
/* 243 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidator3Check(Boolean validator3Check) {
/* 247 */     this.validator3Check = validator3Check;
/*     */   }
/*     */   
/*     */   public String getValidatorRole4() {
/* 251 */     return this.validatorRole4;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist validatorRole4(String validatorRole4) {
/* 255 */     setValidatorRole4(validatorRole4);
/* 256 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidatorRole4(String validatorRole4) {
/* 260 */     this.validatorRole4 = validatorRole4;
/*     */   }
/*     */   
/*     */   public String getValidator4() {
/* 264 */     return this.validator4;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist validator4(String validator4) {
/* 268 */     setValidator4(validator4);
/* 269 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidator4(String validator4) {
/* 273 */     this.validator4 = validator4;
/*     */   }
/*     */   
/*     */   public Boolean getValidator4Check() {
/* 277 */     return this.validator4Check;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist validator4Check(Boolean validator4Check) {
/* 281 */     setValidator4Check(validator4Check);
/* 282 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidator4Check(Boolean validator4Check) {
/* 286 */     this.validator4Check = validator4Check;
/*     */   }
/*     */   
/*     */   public ChecklistStatus getStatus() {
/* 290 */     return this.status;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist status(ChecklistStatus status) {
/* 294 */     setStatus(status);
/* 295 */     return this;
/*     */   }
/*     */   
/*     */   public void setStatus(ChecklistStatus status) {
/* 299 */     this.status = status;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist createdBy(String createdBy) {
/* 303 */     setCreatedBy(createdBy);
/* 304 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist createdDate(Instant createdDate) {
/* 308 */     setCreatedDate(createdDate);
/* 309 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist lastModifiedBy(String lastModifiedBy) {
/* 313 */     setLastModifiedBy(lastModifiedBy);
/* 314 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist lastModifiedDate(Instant lastModifiedDate) {
/* 318 */     setLastModifiedDate(lastModifiedDate);
/* 319 */     return this;
/*     */   }
/*     */   
/*     */   public Certificate getCertificate() {
/* 323 */     return this.certificate;
/*     */   }
/*     */   
/*     */   public void setCertificate(Certificate certificate) {
/* 327 */     if (this.certificate != null) {
/* 328 */       this.certificate.setChecklist(null);
/*     */     }
/* 330 */     if (certificate != null) {
/* 331 */       certificate.setChecklist(this);
/*     */     }
/* 333 */     this.certificate = certificate;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist certificate(Certificate certificate) {
/* 337 */     setCertificate(certificate);
/* 338 */     return this;
/*     */   }
/*     */   
/*     */   public ChecklistModel getChecklistModel() {
/* 342 */     return this.checklistModel;
/*     */   }
/*     */   
/*     */   public void setChecklistModel(ChecklistModel checklistModel) {
/* 346 */     this.checklistModel = checklistModel;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist checklistModel(ChecklistModel checklistModel) {
/* 350 */     setChecklistModel(checklistModel);
/* 351 */     return this;
/*     */   }
/*     */   
/*     */   public Set<ChecklistItem> getChecklistItems() {
/* 355 */     return this.checklistItems;
/*     */   }
/*     */   
/*     */   public void setChecklistItems(Set<ChecklistItem> checklistItems) {
/* 359 */     if (this.checklistItems != null) {
/* 360 */       this.checklistItems.forEach(i -> i.setChecklist(null));
/*     */     }
/* 362 */     if (checklistItems != null) {
/* 363 */       checklistItems.forEach(i -> i.setChecklist(this));
/*     */     }
/* 365 */     this.checklistItems = checklistItems;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist checklistItems(Set<ChecklistItem> checklistItems) {
/* 369 */     setChecklistItems(checklistItems);
/* 370 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist addChecklistItem(ChecklistItem checklistItem) {
/* 374 */     this.checklistItems.add(checklistItem);
/* 375 */     checklistItem.setChecklist(this);
/* 376 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Checklist removeChecklistItem(ChecklistItem checklistItem) {
/* 380 */     this.checklistItems.remove(checklistItem);
/* 381 */     checklistItem.setChecklist(null);
/* 382 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 389 */     if (this == o) {
/* 390 */       return true;
/*     */     }
/* 392 */     if (!(o instanceof com.nanosoft.amtk.domain.Checklist)) {
/* 393 */       return false;
/*     */     }
/* 395 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.Checklist)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 401 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 408 */     return "Checklist{id=" + getId() + ", title='" + 
/* 409 */       getTitle() + "', description='" + 
/* 410 */       getDescription() + "', validatorRole='" + 
/* 411 */       getValidatorRole() + "', validator='" + 
/* 412 */       getValidator() + "', validatorCheck='" + 
/* 413 */       getValidatorCheck() + "', validatorRole2='" + 
/* 414 */       getValidatorRole2() + "', validator2='" + 
/* 415 */       getValidator2() + "', validator2Check='" + 
/* 416 */       getValidator2Check() + "', validatorRole3='" + 
/* 417 */       getValidatorRole3() + "', validator3='" + 
/* 418 */       getValidator3() + "', validator3Check='" + 
/* 419 */       getValidator3Check() + "', validatorRole4='" + 
/* 420 */       getValidatorRole4() + "', validator4='" + 
/* 421 */       getValidator4() + "', validator4Check='" + 
/* 422 */       getValidator4Check() + "', status='" + 
/* 423 */       getStatus() + "', createdBy='" + 
/* 424 */       getCreatedBy() + "', createdDate='" + 
/* 425 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 426 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 427 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Checklist.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */