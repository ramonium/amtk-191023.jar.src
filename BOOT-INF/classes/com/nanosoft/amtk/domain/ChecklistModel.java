/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.nanosoft.amtk.domain.AbstractAuditingEntity;
/*     */ import com.nanosoft.amtk.domain.CertificationLevel;
/*     */ import com.nanosoft.amtk.domain.Checklist;
/*     */ import com.nanosoft.amtk.domain.ChecklistModelItem;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.SequenceGenerator;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import org.hibernate.annotations.Cache;
/*     */ import org.hibernate.annotations.CacheConcurrencyStrategy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "checklist_model")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class ChecklistModel
/*     */   extends AbstractAuditingEntity
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
/*     */   @SequenceGenerator(name = "sequenceGenerator")
/*     */   @Column(name = "id")
/*     */   private Long id;
/*     */   @NotNull
/*     */   @Column(name = "title", nullable = false)
/*     */   private String title;
/*     */   @Column(name = "description")
/*     */   private String description;
/*     */   @OneToMany(mappedBy = "checklistModel")
/*     */   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */   @JsonIgnoreProperties(value = {"certificates", "process", "checklistModel"}, allowSetters = true)
/*  50 */   private Set<CertificationLevel> certificationLevels = new HashSet<>(); @NotNull @Column(name = "validator", nullable = false) private String validator; @Column(name = "validator_2") private String validator2; @Column(name = "validator_3")
/*     */   private String validator3; @Column(name = "validator_4")
/*     */   private String validator4; @OneToMany(mappedBy = "checklistModel")
/*     */   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */   @JsonIgnoreProperties(value = {"certificate", "checklistModel", "checklistItems"}, allowSetters = true)
/*  55 */   private Set<Checklist> checklists = new HashSet<>();
/*     */   
/*     */   @OneToMany(mappedBy = "checklistModel")
/*     */   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */   @JsonIgnoreProperties(value = {"checklistModel"}, allowSetters = true)
/*  60 */   private Set<ChecklistModelItem> checklistModelItems = new HashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getId() {
/*  68 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel id(Long id) {
/*  72 */     setId(id);
/*  73 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  77 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getTitle() {
/*  81 */     return this.title;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel title(String title) {
/*  85 */     setTitle(title);
/*  86 */     return this;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/*  90 */     this.title = title;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  94 */     return this.description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel description(String description) {
/*  98 */     setDescription(description);
/*  99 */     return this;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 103 */     this.description = description;
/*     */   }
/*     */   
/*     */   public String getValidator() {
/* 107 */     return this.validator;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel validator(String validator) {
/* 111 */     setValidator(validator);
/* 112 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidator(String validator) {
/* 116 */     this.validator = validator;
/*     */   }
/*     */   
/*     */   public String getValidator2() {
/* 120 */     return this.validator2;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel validator2(String validator2) {
/* 124 */     setValidator2(validator2);
/* 125 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidator2(String validator2) {
/* 129 */     this.validator2 = validator2;
/*     */   }
/*     */   
/*     */   public String getValidator3() {
/* 133 */     return this.validator3;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel validator3(String validator3) {
/* 137 */     setValidator3(validator3);
/* 138 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidator3(String validator3) {
/* 142 */     this.validator3 = validator3;
/*     */   }
/*     */   
/*     */   public String getValidator4() {
/* 146 */     return this.validator4;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel validator4(String validator4) {
/* 150 */     setValidator4(validator4);
/* 151 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidator4(String validator4) {
/* 155 */     this.validator4 = validator4;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel createdBy(String createdBy) {
/* 159 */     setCreatedBy(createdBy);
/* 160 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel createdDate(Instant createdDate) {
/* 164 */     setCreatedDate(createdDate);
/* 165 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel lastModifiedBy(String lastModifiedBy) {
/* 169 */     setLastModifiedBy(lastModifiedBy);
/* 170 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel lastModifiedDate(Instant lastModifiedDate) {
/* 174 */     setLastModifiedDate(lastModifiedDate);
/* 175 */     return this;
/*     */   }
/*     */   
/*     */   public Set<CertificationLevel> getCertificationLevels() {
/* 179 */     return this.certificationLevels;
/*     */   }
/*     */   
/*     */   public void setCertificationLevels(Set<CertificationLevel> certificationLevels) {
/* 183 */     if (this.certificationLevels != null) {
/* 184 */       this.certificationLevels.forEach(i -> i.setChecklistModel(null));
/*     */     }
/* 186 */     if (certificationLevels != null) {
/* 187 */       certificationLevels.forEach(i -> i.setChecklistModel(this));
/*     */     }
/* 189 */     this.certificationLevels = certificationLevels;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel certificationLevels(Set<CertificationLevel> certificationLevels) {
/* 193 */     setCertificationLevels(certificationLevels);
/* 194 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel addCertificationLevel(CertificationLevel certificationLevel) {
/* 198 */     this.certificationLevels.add(certificationLevel);
/* 199 */     certificationLevel.setChecklistModel(this);
/* 200 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel removeCertificationLevel(CertificationLevel certificationLevel) {
/* 204 */     this.certificationLevels.remove(certificationLevel);
/* 205 */     certificationLevel.setChecklistModel(null);
/* 206 */     return this;
/*     */   }
/*     */   
/*     */   public Set<Checklist> getChecklists() {
/* 210 */     return this.checklists;
/*     */   }
/*     */   
/*     */   public void setChecklists(Set<Checklist> checklists) {
/* 214 */     if (this.checklists != null) {
/* 215 */       this.checklists.forEach(i -> i.setChecklistModel(null));
/*     */     }
/* 217 */     if (checklists != null) {
/* 218 */       checklists.forEach(i -> i.setChecklistModel(this));
/*     */     }
/* 220 */     this.checklists = checklists;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel checklists(Set<Checklist> checklists) {
/* 224 */     setChecklists(checklists);
/* 225 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel addChecklist(Checklist checklist) {
/* 229 */     this.checklists.add(checklist);
/* 230 */     checklist.setChecklistModel(this);
/* 231 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel removeChecklist(Checklist checklist) {
/* 235 */     this.checklists.remove(checklist);
/* 236 */     checklist.setChecklistModel(null);
/* 237 */     return this;
/*     */   }
/*     */   
/*     */   public Set<ChecklistModelItem> getChecklistModelItems() {
/* 241 */     return this.checklistModelItems;
/*     */   }
/*     */   
/*     */   public void setChecklistModelItems(Set<ChecklistModelItem> checklistModelItems) {
/* 245 */     if (this.checklistModelItems != null) {
/* 246 */       this.checklistModelItems.forEach(i -> i.setChecklistModel(null));
/*     */     }
/* 248 */     if (checklistModelItems != null) {
/* 249 */       checklistModelItems.forEach(i -> i.setChecklistModel(this));
/*     */     }
/* 251 */     this.checklistModelItems = checklistModelItems;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel checklistModelItems(Set<ChecklistModelItem> checklistModelItems) {
/* 255 */     setChecklistModelItems(checklistModelItems);
/* 256 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel addChecklistModelItem(ChecklistModelItem checklistModelItem) {
/* 260 */     this.checklistModelItems.add(checklistModelItem);
/* 261 */     checklistModelItem.setChecklistModel(this);
/* 262 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModel removeChecklistModelItem(ChecklistModelItem checklistModelItem) {
/* 266 */     this.checklistModelItems.remove(checklistModelItem);
/* 267 */     checklistModelItem.setChecklistModel(null);
/* 268 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 275 */     if (this == o) {
/* 276 */       return true;
/*     */     }
/* 278 */     if (!(o instanceof com.nanosoft.amtk.domain.ChecklistModel)) {
/* 279 */       return false;
/*     */     }
/* 281 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.ChecklistModel)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 287 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 294 */     return "ChecklistModel{id=" + getId() + ", title='" + 
/* 295 */       getTitle() + "', description='" + 
/* 296 */       getDescription() + "', validator='" + 
/* 297 */       getValidator() + "', validator2='" + 
/* 298 */       getValidator2() + "', validator3='" + 
/* 299 */       getValidator3() + "', validator4='" + 
/* 300 */       getValidator4() + "', createdBy='" + 
/* 301 */       getCreatedBy() + "', createdDate='" + 
/* 302 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 303 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 304 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\ChecklistModel.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */