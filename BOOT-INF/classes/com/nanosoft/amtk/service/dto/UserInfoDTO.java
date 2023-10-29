/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*     */ 
/*     */ import com.nanosoft.amtk.service.dto.EmployeeDTO;
/*     */ import com.nanosoft.amtk.service.dto.UserDTO;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import java.util.Objects;
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
/*     */ public class UserInfoDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   private String description;
/*     */   @Size(max = 50)
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   private UserDTO user;
/*     */   private EmployeeDTO relatedEmployee;
/*     */   
/*     */   public Long getId() {
/*  33 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  37 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  41 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  45 */     this.description = description;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/*  49 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/*  53 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/*  57 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/*  61 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/*  65 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/*  69 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/*  73 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/*  77 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public UserDTO getUser() {
/*  81 */     return this.user;
/*     */   }
/*     */   
/*     */   public void setUser(UserDTO user) {
/*  85 */     this.user = user;
/*     */   }
/*     */   
/*     */   public EmployeeDTO getRelatedEmployee() {
/*  89 */     return this.relatedEmployee;
/*     */   }
/*     */   
/*     */   public void setRelatedEmployee(EmployeeDTO relatedEmployee) {
/*  93 */     this.relatedEmployee = relatedEmployee;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  98 */     if (this == o) {
/*  99 */       return true;
/*     */     }
/* 101 */     if (!(o instanceof com.nanosoft.amtk.service.dto.UserInfoDTO)) {
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     com.nanosoft.amtk.service.dto.UserInfoDTO userInfoDTO = (com.nanosoft.amtk.service.dto.UserInfoDTO)o;
/* 106 */     if (this.id == null) {
/* 107 */       return false;
/*     */     }
/* 109 */     return Objects.equals(this.id, userInfoDTO.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 114 */     return Objects.hash(new Object[] { this.id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 121 */     return "UserInfoDTO{id=" + getId() + ", description='" + 
/* 122 */       getDescription() + "', createdBy='" + 
/* 123 */       getCreatedBy() + "', createdDate='" + 
/* 124 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 125 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 126 */       getLastModifiedDate() + "', user=" + 
/* 127 */       getUser() + ", relatedEmployee=" + 
/* 128 */       getRelatedEmployee() + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\UserInfoDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */