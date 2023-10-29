/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.nanosoft.amtk.domain.AbstractAuditingEntity;
/*     */ import com.nanosoft.amtk.domain.ChecklistModel;
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
/*     */ @Entity
/*     */ @Table(name = "checklist_model_item")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class ChecklistModelItem
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
/*     */   @Column(name = "item_group")
/*     */   private String itemGroup;
/*     */   @NotNull
/*     */   @Column(name = "validator", nullable = false)
/*     */   private String validator;
/*     */   @ManyToOne
/*     */   @JsonIgnoreProperties(value = {"certificationLevels", "checklists", "checklistModelItems"}, allowSetters = true)
/*     */   private ChecklistModel checklistModel;
/*     */   
/*     */   public Long getId() {
/*  46 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModelItem id(Long id) {
/*  50 */     setId(id);
/*  51 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  55 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getText() {
/*  59 */     return this.text;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModelItem text(String text) {
/*  63 */     setText(text);
/*  64 */     return this;
/*     */   }
/*     */   
/*     */   public void setText(String text) {
/*  68 */     this.text = text;
/*     */   }
/*     */   
/*     */   public String getItemGroup() {
/*  72 */     return this.itemGroup;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModelItem itemGroup(String itemGroup) {
/*  76 */     setItemGroup(itemGroup);
/*  77 */     return this;
/*     */   }
/*     */   
/*     */   public void setItemGroup(String itemGroup) {
/*  81 */     this.itemGroup = itemGroup;
/*     */   }
/*     */   
/*     */   public String getValidator() {
/*  85 */     return this.validator;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModelItem validator(String validator) {
/*  89 */     setValidator(validator);
/*  90 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidator(String validator) {
/*  94 */     this.validator = validator;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModelItem createdBy(String createdBy) {
/*  98 */     setCreatedBy(createdBy);
/*  99 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModelItem createdDate(Instant createdDate) {
/* 103 */     setCreatedDate(createdDate);
/* 104 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModelItem lastModifiedBy(String lastModifiedBy) {
/* 108 */     setLastModifiedBy(lastModifiedBy);
/* 109 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModelItem lastModifiedDate(Instant lastModifiedDate) {
/* 113 */     setLastModifiedDate(lastModifiedDate);
/* 114 */     return this;
/*     */   }
/*     */   
/*     */   public ChecklistModel getChecklistModel() {
/* 118 */     return this.checklistModel;
/*     */   }
/*     */   
/*     */   public void setChecklistModel(ChecklistModel checklistModel) {
/* 122 */     this.checklistModel = checklistModel;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.ChecklistModelItem checklistModel(ChecklistModel checklistModel) {
/* 126 */     setChecklistModel(checklistModel);
/* 127 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 134 */     if (this == o) {
/* 135 */       return true;
/*     */     }
/* 137 */     if (!(o instanceof com.nanosoft.amtk.domain.ChecklistModelItem)) {
/* 138 */       return false;
/*     */     }
/* 140 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.ChecklistModelItem)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 146 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 153 */     return "ChecklistModelItem{id=" + getId() + ", text='" + 
/* 154 */       getText() + "', itemGroup='" + 
/* 155 */       getItemGroup() + "', validator='" + 
/* 156 */       getValidator() + "', createdBy='" + 
/* 157 */       getCreatedBy() + "', createdDate='" + 
/* 158 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 159 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 160 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\ChecklistModelItem.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */