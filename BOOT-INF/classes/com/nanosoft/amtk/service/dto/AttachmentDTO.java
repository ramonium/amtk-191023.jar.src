/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*     */ 
/*     */ import com.nanosoft.amtk.service.dto.ContentDTO;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AttachmentDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   @NotNull
/*     */   private String title;
/*     */   @NotNull
/*     */   private String fileName;
/*     */   @NotNull
/*     */   private Long fileSize;
/*     */   private String fileType;
/*     */   private String description;
/*     */   @Size(max = 50)
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   private ContentDTO content;
/*     */   private Long contentId;
/*     */   private EmployeeDTO employee;
/*     */   
/*     */   public Long getId() {
/*  46 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  50 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getTitle() {
/*  54 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/*  58 */     this.title = title;
/*     */   }
/*     */   
/*     */   public String getFileName() {
/*  62 */     return this.fileName;
/*     */   }
/*     */   
/*     */   public void setFileName(String fileName) {
/*  66 */     this.fileName = fileName;
/*     */   }
/*     */   
/*     */   public Long getFileSize() {
/*  70 */     return this.fileSize;
/*     */   }
/*     */   
/*     */   public void setFileSize(Long fileSize) {
/*  74 */     this.fileSize = fileSize;
/*     */   }
/*     */   
/*     */   public String getFileType() {
/*  78 */     return this.fileType;
/*     */   }
/*     */   
/*     */   public void setFileType(String fileType) {
/*  82 */     this.fileType = fileType;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  86 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  90 */     this.description = description;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/*  94 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/*  98 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/* 102 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/* 106 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/* 110 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/* 114 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/* 118 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/* 122 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public ContentDTO getContent() {
/* 126 */     return this.content;
/*     */   }
/*     */   
/*     */   public void setContent(ContentDTO content) {
/* 130 */     this.content = content;
/*     */   }
/*     */   
/*     */   public Long getContentId() {
/* 134 */     return this.contentId;
/*     */   }
/*     */   
/*     */   public void setContentId(Long contentId) {
/* 138 */     this.contentId = contentId;
/*     */   }
/*     */   
/*     */   public EmployeeDTO getEmployee() {
/* 142 */     return this.employee;
/*     */   }
/*     */   
/*     */   public void setEmployee(EmployeeDTO employee) {
/* 146 */     this.employee = employee;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 151 */     if (this == o) {
/* 152 */       return true;
/*     */     }
/* 154 */     if (!(o instanceof com.nanosoft.amtk.service.dto.AttachmentDTO)) {
/* 155 */       return false;
/*     */     }
/*     */     
/* 158 */     com.nanosoft.amtk.service.dto.AttachmentDTO attachmentDTO = (com.nanosoft.amtk.service.dto.AttachmentDTO)o;
/* 159 */     if (this.id == null) {
/* 160 */       return false;
/*     */     }
/* 162 */     return Objects.equals(this.id, attachmentDTO.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 167 */     return Objects.hash(new Object[] { this.id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 174 */     return "AttachmentDTO{id=" + getId() + ", title='" + 
/* 175 */       getTitle() + "', fileName='" + 
/* 176 */       getFileName() + "', fileSize=" + 
/* 177 */       getFileSize() + ", fileType='" + 
/* 178 */       getFileType() + "', description='" + 
/* 179 */       getDescription() + "', createdBy='" + 
/* 180 */       getCreatedBy() + "', createdDate='" + 
/* 181 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 182 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 183 */       getLastModifiedDate() + "', content=" + 
/* 184 */       getContent() + ", employee=" + 
/* 185 */       getEmployee() + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\AttachmentDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */