/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*     */ 
/*     */ import com.nanosoft.amtk.service.dto.ChecklistModelDTO;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import java.util.Objects;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import javax.validation.constraints.Size;
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
/*     */ public class ChecklistModelItemDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   @NotNull
/*     */   private String text;
/*     */   private String itemGroup;
/*     */   @NotNull
/*     */   private String validator;
/*     */   @Size(max = 50)
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   private ChecklistModelDTO checklistModel;
/*     */   
/*     */   public Long getId() {
/*  37 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  41 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getText() {
/*  45 */     return this.text;
/*     */   }
/*     */   
/*     */   public void setText(String text) {
/*  49 */     this.text = text;
/*     */   }
/*     */   
/*     */   public String getItemGroup() {
/*  53 */     return this.itemGroup;
/*     */   }
/*     */   
/*     */   public void setItemGroup(String itemGroup) {
/*  57 */     this.itemGroup = itemGroup;
/*     */   }
/*     */   
/*     */   public String getValidator() {
/*  61 */     return this.validator;
/*     */   }
/*     */   
/*     */   public void setValidator(String validator) {
/*  65 */     this.validator = validator;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/*  69 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/*  73 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/*  77 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/*  81 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/*  85 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/*  89 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/*  93 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/*  97 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public ChecklistModelDTO getChecklistModel() {
/* 101 */     return this.checklistModel;
/*     */   }
/*     */   
/*     */   public void setChecklistModel(ChecklistModelDTO checklistModel) {
/* 105 */     this.checklistModel = checklistModel;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 110 */     if (this == o) {
/* 111 */       return true;
/*     */     }
/* 113 */     if (!(o instanceof com.nanosoft.amtk.service.dto.ChecklistModelItemDTO)) {
/* 114 */       return false;
/*     */     }
/*     */     
/* 117 */     com.nanosoft.amtk.service.dto.ChecklistModelItemDTO checklistModelItemDTO = (com.nanosoft.amtk.service.dto.ChecklistModelItemDTO)o;
/* 118 */     if (this.id == null) {
/* 119 */       return false;
/*     */     }
/* 121 */     return Objects.equals(this.id, checklistModelItemDTO.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 126 */     return Objects.hash(new Object[] { this.id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 133 */     return "ChecklistModelItemDTO{id=" + getId() + ", text='" + 
/* 134 */       getText() + "', itemGroup='" + 
/* 135 */       getItemGroup() + "', validator='" + 
/* 136 */       getValidator() + "', createdBy='" + 
/* 137 */       getCreatedBy() + "', createdDate='" + 
/* 138 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 139 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 140 */       getLastModifiedDate() + "', checklistModel=" + 
/* 141 */       getChecklistModel() + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\ChecklistModelItemDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */