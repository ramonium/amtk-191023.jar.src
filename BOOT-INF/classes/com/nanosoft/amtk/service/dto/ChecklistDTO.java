/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.enumeration.ChecklistStatus;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistItemDTO;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistModelDTO;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChecklistDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   @NotNull
/*     */   private String title;
/*     */   private String description;
/*     */   @NotNull
/*     */   private String validatorRole;
/*     */   private String validator;
/*     */   private Boolean validatorCheck;
/*     */   private String validatorRole2;
/*     */   private String validator2;
/*     */   private Boolean validator2Check;
/*     */   private String validatorRole3;
/*     */   private String validator3;
/*     */   private Boolean validator3Check;
/*     */   private String validatorRole4;
/*     */   private String validator4;
/*     */   private Boolean validator4Check;
/*     */   private ChecklistStatus status;
/*     */   @Size(max = 50)
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   private ChecklistModelDTO checklistModel;
/*     */   private List<ChecklistItemDTO> checklistItems;
/*     */   
/*     */   public Long getId() {
/*  65 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  69 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getTitle() {
/*  73 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/*  77 */     this.title = title;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  81 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  85 */     this.description = description;
/*     */   }
/*     */   
/*     */   public String getValidatorRole() {
/*  89 */     return this.validatorRole;
/*     */   }
/*     */   
/*     */   public void setValidatorRole(String validatorRole) {
/*  93 */     this.validatorRole = validatorRole;
/*     */   }
/*     */   
/*     */   public String getValidator() {
/*  97 */     return this.validator;
/*     */   }
/*     */   
/*     */   public void setValidator(String validator) {
/* 101 */     this.validator = validator;
/*     */   }
/*     */   
/*     */   public Boolean getValidatorCheck() {
/* 105 */     return this.validatorCheck;
/*     */   }
/*     */   
/*     */   public void setValidatorCheck(Boolean validatorCheck) {
/* 109 */     this.validatorCheck = validatorCheck;
/*     */   }
/*     */   
/*     */   public String getValidatorRole2() {
/* 113 */     return this.validatorRole2;
/*     */   }
/*     */   
/*     */   public void setValidatorRole2(String validatorRole2) {
/* 117 */     this.validatorRole2 = validatorRole2;
/*     */   }
/*     */   
/*     */   public String getValidator2() {
/* 121 */     return this.validator2;
/*     */   }
/*     */   
/*     */   public void setValidator2(String validator2) {
/* 125 */     this.validator2 = validator2;
/*     */   }
/*     */   
/*     */   public Boolean getValidator2Check() {
/* 129 */     return this.validator2Check;
/*     */   }
/*     */   
/*     */   public void setValidator2Check(Boolean validator2Check) {
/* 133 */     this.validator2Check = validator2Check;
/*     */   }
/*     */   
/*     */   public String getValidatorRole3() {
/* 137 */     return this.validatorRole3;
/*     */   }
/*     */   
/*     */   public void setValidatorRole3(String validatorRole3) {
/* 141 */     this.validatorRole3 = validatorRole3;
/*     */   }
/*     */   
/*     */   public String getValidator3() {
/* 145 */     return this.validator3;
/*     */   }
/*     */   
/*     */   public void setValidator3(String validator3) {
/* 149 */     this.validator3 = validator3;
/*     */   }
/*     */   
/*     */   public Boolean getValidator3Check() {
/* 153 */     return this.validator3Check;
/*     */   }
/*     */   
/*     */   public void setValidator3Check(Boolean validator3Check) {
/* 157 */     this.validator3Check = validator3Check;
/*     */   }
/*     */   
/*     */   public String getValidatorRole4() {
/* 161 */     return this.validatorRole4;
/*     */   }
/*     */   
/*     */   public void setValidatorRole4(String validatorRole4) {
/* 165 */     this.validatorRole4 = validatorRole4;
/*     */   }
/*     */   
/*     */   public String getValidator4() {
/* 169 */     return this.validator4;
/*     */   }
/*     */   
/*     */   public void setValidator4(String validator4) {
/* 173 */     this.validator4 = validator4;
/*     */   }
/*     */   
/*     */   public Boolean getValidator4Check() {
/* 177 */     return this.validator4Check;
/*     */   }
/*     */   
/*     */   public void setValidator4Check(Boolean validator4Check) {
/* 181 */     this.validator4Check = validator4Check;
/*     */   }
/*     */   
/*     */   public ChecklistStatus getStatus() {
/* 185 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(ChecklistStatus status) {
/* 189 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/* 193 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/* 197 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/* 201 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/* 205 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/* 209 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/* 213 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/* 217 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/* 221 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public ChecklistModelDTO getChecklistModel() {
/* 225 */     return this.checklistModel;
/*     */   }
/*     */   
/*     */   public void setChecklistModel(ChecklistModelDTO checklistModel) {
/* 229 */     this.checklistModel = checklistModel;
/*     */   }
/*     */   
/*     */   public List<ChecklistItemDTO> getChecklistItems() {
/* 233 */     return this.checklistItems;
/*     */   }
/*     */   
/*     */   public void setChecklistItems(List<ChecklistItemDTO> checklistItems) {
/* 237 */     this.checklistItems = checklistItems;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 242 */     if (this == o) {
/* 243 */       return true;
/*     */     }
/* 245 */     if (!(o instanceof com.nanosoft.amtk.service.dto.ChecklistDTO)) {
/* 246 */       return false;
/*     */     }
/*     */     
/* 249 */     com.nanosoft.amtk.service.dto.ChecklistDTO checklistDTO = (com.nanosoft.amtk.service.dto.ChecklistDTO)o;
/* 250 */     if (this.id == null) {
/* 251 */       return false;
/*     */     }
/* 253 */     return Objects.equals(this.id, checklistDTO.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 258 */     return Objects.hash(new Object[] { this.id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 265 */     return "ChecklistDTO{id=" + getId() + ", title='" + 
/* 266 */       getTitle() + "', description='" + 
/* 267 */       getDescription() + "', validatorRole='" + 
/* 268 */       getValidatorRole() + "', validator='" + 
/* 269 */       getValidator() + "', validatorCheck='" + 
/* 270 */       getValidatorCheck() + "', validatorRole2='" + 
/* 271 */       getValidatorRole2() + "', validator2='" + 
/* 272 */       getValidator2() + "', validator2Check='" + 
/* 273 */       getValidator2Check() + "', validatorRole3='" + 
/* 274 */       getValidatorRole3() + "', validator3='" + 
/* 275 */       getValidator3() + "', validator3Check='" + 
/* 276 */       getValidator3Check() + "', validatorRole4='" + 
/* 277 */       getValidatorRole4() + "', validator4='" + 
/* 278 */       getValidator4() + "', validator4Check='" + 
/* 279 */       getValidator4Check() + "', status='" + 
/* 280 */       getStatus() + "', createdBy='" + 
/* 281 */       getCreatedBy() + "', createdDate='" + 
/* 282 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 283 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 284 */       getLastModifiedDate() + "', checklistModel=" + 
/* 285 */       getChecklistModel() + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\ChecklistDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */