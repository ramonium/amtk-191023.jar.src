/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*     */ 
/*     */ import com.nanosoft.amtk.service.dto.EmployeeDTO;
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
/*     */ public class TeamDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   @NotNull
/*     */   private String name;
/*     */   private String description;
/*     */   @Size(max = 50)
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   private EmployeeDTO supervisor;
/*     */   
/*     */   public Long getId() {
/*  34 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  38 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  42 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  46 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  50 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  54 */     this.description = description;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/*  58 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/*  62 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/*  66 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/*  70 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/*  74 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/*  78 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/*  82 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/*  86 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public EmployeeDTO getSupervisor() {
/*  90 */     return this.supervisor;
/*     */   }
/*     */   
/*     */   public void setSupervisor(EmployeeDTO supervisor) {
/*  94 */     this.supervisor = supervisor;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  99 */     if (this == o) {
/* 100 */       return true;
/*     */     }
/* 102 */     if (!(o instanceof com.nanosoft.amtk.service.dto.TeamDTO)) {
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     com.nanosoft.amtk.service.dto.TeamDTO teamDTO = (com.nanosoft.amtk.service.dto.TeamDTO)o;
/* 107 */     if (this.id == null) {
/* 108 */       return false;
/*     */     }
/* 110 */     return Objects.equals(this.id, teamDTO.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 115 */     return Objects.hash(new Object[] { this.id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 122 */     return "TeamDTO{id=" + getId() + ", name='" + 
/* 123 */       getName() + "', description='" + 
/* 124 */       getDescription() + "', createdBy='" + 
/* 125 */       getCreatedBy() + "', createdDate='" + 
/* 126 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 127 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 128 */       getLastModifiedDate() + "', supervisor=" + 
/* 129 */       getSupervisor() + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\TeamDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */