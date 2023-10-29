/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChecklistItemDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   @NotNull
/*     */   private String text;
/*     */   @NotNull
/*     */   private String itemGroup;
/*     */   @NotNull
/*     */   private String validatorRole;
/*     */   private String validator;
/*     */   private Boolean isChecked;
/*     */   @Size(max = 50)
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   
/*     */   public Long getId() {
/*  41 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  45 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getText() {
/*  49 */     return this.text;
/*     */   }
/*     */   
/*     */   public void setText(String text) {
/*  53 */     this.text = text;
/*     */   }
/*     */   
/*     */   public String getItemGroup() {
/*  57 */     return this.itemGroup;
/*     */   }
/*     */   
/*     */   public void setItemGroup(String itemGroup) {
/*  61 */     this.itemGroup = itemGroup;
/*     */   }
/*     */   
/*     */   public String getValidatorRole() {
/*  65 */     return this.validatorRole;
/*     */   }
/*     */   
/*     */   public void setValidatorRole(String validatorRole) {
/*  69 */     this.validatorRole = validatorRole;
/*     */   }
/*     */   
/*     */   public String getValidator() {
/*  73 */     return this.validator;
/*     */   }
/*     */   
/*     */   public void setValidator(String validator) {
/*  77 */     this.validator = validator;
/*     */   }
/*     */   
/*     */   public Boolean getIsChecked() {
/*  81 */     return this.isChecked;
/*     */   }
/*     */   
/*     */   public void setIsChecked(Boolean isChecked) {
/*  85 */     this.isChecked = isChecked;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/*  89 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/*  93 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/*  97 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/* 101 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/* 105 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/* 109 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/* 113 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/* 117 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 122 */     if (this == o) {
/* 123 */       return true;
/*     */     }
/* 125 */     if (!(o instanceof com.nanosoft.amtk.service.dto.ChecklistItemDTO)) {
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     com.nanosoft.amtk.service.dto.ChecklistItemDTO checklistItemDTO = (com.nanosoft.amtk.service.dto.ChecklistItemDTO)o;
/* 130 */     if (this.id == null) {
/* 131 */       return false;
/*     */     }
/* 133 */     return Objects.equals(this.id, checklistItemDTO.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 138 */     return Objects.hash(new Object[] { this.id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 145 */     return "ChecklistItemDTO{id=" + getId() + ", text='" + 
/* 146 */       getText() + "', itemGroup='" + 
/* 147 */       getItemGroup() + "', validatorRole='" + 
/* 148 */       getValidatorRole() + "', validator='" + 
/* 149 */       getValidator() + "', isChecked='" + 
/* 150 */       getIsChecked() + "', createdBy='" + 
/* 151 */       getCreatedBy() + "', createdDate='" + 
/* 152 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 153 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 154 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\ChecklistItemDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */