/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.nanosoft.amtk.domain.AbstractAuditingEntity;
/*     */ import com.nanosoft.amtk.domain.Checklist;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.SequenceGenerator;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import org.hibernate.annotations.Cache;
/*     */ import org.hibernate.annotations.CacheConcurrencyStrategy;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "checklist_item")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class ChecklistItem
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
/*     */   @Column(name = "text", nullable = false)
/*     */   private String text;
/*     */   @NotNull
/*     */   @Column(name = "item_group", nullable = false)
/*     */   private String itemGroup;
/*     */   @NotNull
/*     */   @Column(name = "validator_role", nullable = false)
/*     */   private String validatorRole;
/*     */   @Column(name = "validator")
/*     */   private String validator;
/*     */   @Column(name = "is_checked")
/*     */   private Boolean isChecked;
/*     */   @ManyToOne
/*     */   @JsonIgnoreProperties(value = {"certificate", "checklistModel", "checklistItems"}, allowSetters = true)
/*     */   private Checklist checklist;
/*     */   
/*     */   public Long getId() {
/*  53 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistItem id(Long id) {
/*  57 */     setId(id);
/*  58 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  62 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getText() {
/*  66 */     return this.text;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistItem text(String text) {
/*  70 */     setText(text);
/*  71 */     return this;
/*     */   }
/*     */   
/*     */   public void setText(String text) {
/*  75 */     this.text = text;
/*     */   }
/*     */   
/*     */   public String getItemGroup() {
/*  79 */     return this.itemGroup;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistItem itemGroup(String itemGroup) {
/*  83 */     setItemGroup(itemGroup);
/*  84 */     return this;
/*     */   }
/*     */   
/*     */   public void setItemGroup(String itemGroup) {
/*  88 */     this.itemGroup = itemGroup;
/*     */   }
/*     */   
/*     */   public String getValidatorRole() {
/*  92 */     return this.validatorRole;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistItem validatorRole(String validatorRole) {
/*  96 */     setValidatorRole(validatorRole);
/*  97 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidatorRole(String validatorRole) {
/* 101 */     this.validatorRole = validatorRole;
/*     */   }
/*     */   
/*     */   public String getValidator() {
/* 105 */     return this.validator;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistItem validator(String validator) {
/* 109 */     setValidator(validator);
/* 110 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidator(String validator) {
/* 114 */     this.validator = validator;
/*     */   }
/*     */   
/*     */   public Boolean getIsChecked() {
/* 118 */     return this.isChecked;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistItem isChecked(Boolean isChecked) {
/* 122 */     setIsChecked(isChecked);
/* 123 */     return this;
/*     */   }
/*     */   
/*     */   public void setIsChecked(Boolean isChecked) {
/* 127 */     this.isChecked = isChecked;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistItem createdBy(String createdBy) {
/* 131 */     setCreatedBy(createdBy);
/* 132 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistItem createdDate(Instant createdDate) {
/* 136 */     setCreatedDate(createdDate);
/* 137 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistItem lastModifiedBy(String lastModifiedBy) {
/* 141 */     setLastModifiedBy(lastModifiedBy);
/* 142 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistItem lastModifiedDate(Instant lastModifiedDate) {
/* 146 */     setLastModifiedDate(lastModifiedDate);
/* 147 */     return this;
/*     */   }
/*     */   
/*     */   public Checklist getChecklist() {
/* 151 */     return this.checklist;
/*     */   }
/*     */   
/*     */   public void setChecklist(Checklist checklist) {
/* 155 */     this.checklist = checklist;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistItem checklist(Checklist checklist) {
/* 159 */     setChecklist(checklist);
/* 160 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 167 */     if (this == o) {
/* 168 */       return true;
/*     */     }
/* 170 */     if (!(o instanceof com.nanosoft.amtk.domain.ChecklistItem)) {
/* 171 */       return false;
/*     */     }
/* 173 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.ChecklistItem)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 179 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 186 */     return "ChecklistItem{id=" + getId() + ", text='" + 
/* 187 */       getText() + "', itemGroup='" + 
/* 188 */       getItemGroup() + "', validatorRole='" + 
/* 189 */       getValidatorRole() + "', validator='" + 
/* 190 */       getValidator() + "', isChecked='" + 
/* 191 */       getIsChecked() + "', createdBy='" + 
/* 192 */       getCreatedBy() + "', createdDate='" + 
/* 193 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 194 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 195 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\ChecklistItem.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */