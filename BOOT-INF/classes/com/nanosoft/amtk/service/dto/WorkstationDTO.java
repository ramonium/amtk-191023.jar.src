/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*     */ 
/*     */ import com.nanosoft.amtk.service.dto.AreaDTO;
/*     */ import com.nanosoft.amtk.service.dto.ProcessDTO;
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
/*     */ public class WorkstationDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   @NotNull
/*     */   private String name;
/*     */   private String description;
/*     */   private Integer orderNumber;
/*     */   @Size(max = 50)
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   private AreaDTO area;
/*     */   private ProcessDTO process;
/*     */   
/*     */   public Long getId() {
/*  38 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  42 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  46 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  50 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  54 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  58 */     this.description = description;
/*     */   }
/*     */   
/*     */   public Integer getOrderNumber() {
/*  62 */     return this.orderNumber;
/*     */   }
/*     */   
/*     */   public void setOrderNumber(Integer orderNumber) {
/*  66 */     this.orderNumber = orderNumber;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/*  70 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/*  74 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/*  78 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/*  82 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/*  86 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/*  90 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/*  94 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/*  98 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public AreaDTO getArea() {
/* 102 */     return this.area;
/*     */   }
/*     */   
/*     */   public void setArea(AreaDTO area) {
/* 106 */     this.area = area;
/*     */   }
/*     */   
/*     */   public ProcessDTO getProcess() {
/* 110 */     return this.process;
/*     */   }
/*     */   
/*     */   public void setProcess(ProcessDTO process) {
/* 114 */     this.process = process;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 119 */     if (this == o) {
/* 120 */       return true;
/*     */     }
/* 122 */     if (!(o instanceof com.nanosoft.amtk.service.dto.WorkstationDTO)) {
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     com.nanosoft.amtk.service.dto.WorkstationDTO workstationDTO = (com.nanosoft.amtk.service.dto.WorkstationDTO)o;
/* 127 */     if (this.id == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return Objects.equals(this.id, workstationDTO.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 135 */     return Objects.hash(new Object[] { this.id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 142 */     return "WorkstationDTO{id=" + getId() + ", name='" + 
/* 143 */       getName() + "', description='" + 
/* 144 */       getDescription() + "', orderNumber=" + 
/* 145 */       getOrderNumber() + ", createdBy='" + 
/* 146 */       getCreatedBy() + "', createdDate='" + 
/* 147 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 148 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 149 */       getLastModifiedDate() + "', area=" + 
/* 150 */       getArea() + ", process=" + 
/* 151 */       getProcess() + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\WorkstationDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */