/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.nanosoft.amtk.domain.AbstractAuditingEntity;
/*     */ import com.nanosoft.amtk.domain.Content;
/*     */ import com.nanosoft.amtk.domain.Employee;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import javax.persistence.CascadeType;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToOne;
/*     */ import javax.persistence.SequenceGenerator;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import org.hibernate.annotations.Cache;
/*     */ import org.hibernate.annotations.CacheConcurrencyStrategy;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "attachment")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class Attachment extends AbstractAuditingEntity implements Serializable {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
/*     */   @SequenceGenerator(name = "sequenceGenerator")
/*     */   @Column(name = "id")
/*     */   private Long id;
/*     */   @NotNull
/*     */   @Column(name = "title", nullable = false)
/*     */   private String title;
/*     */   @NotNull
/*     */   @Column(name = "file_name", nullable = false)
/*     */   private String fileName;
/*     */   @NotNull
/*     */   @Column(name = "file_size", nullable = false)
/*     */   private Long fileSize;
/*     */   @Column(name = "file_type")
/*     */   private String fileType;
/*     */   @Column(name = "description")
/*     */   private String description;
/*     */   @JsonIgnoreProperties(value = {"attachment"}, allowSetters = true)
/*     */   @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
/*     */   @NotNull
/*     */   @JoinColumn(unique = true)
/*     */   private Content content;
/*     */   @ManyToOne(optional = false)
/*     */   @NotNull
/*     */   @JsonIgnoreProperties(value = {"attachments", "assignments", "title", "team", "managedTeams"}, allowSetters = true)
/*     */   private Employee employee;
/*     */   
/*     */   public Long getId() {
/*  59 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Attachment id(Long id) {
/*  63 */     setId(id);
/*  64 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  68 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getTitle() {
/*  72 */     return this.title;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Attachment title(String title) {
/*  76 */     setTitle(title);
/*  77 */     return this;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/*  81 */     this.title = title;
/*     */   }
/*     */   
/*     */   public String getFileName() {
/*  85 */     return this.fileName;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Attachment fileName(String fileName) {
/*  89 */     setFileName(fileName);
/*  90 */     return this;
/*     */   }
/*     */   
/*     */   public void setFileName(String fileName) {
/*  94 */     this.fileName = fileName;
/*     */   }
/*     */   
/*     */   public Long getFileSize() {
/*  98 */     return this.fileSize;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Attachment fileSize(Long fileSize) {
/* 102 */     setFileSize(fileSize);
/* 103 */     return this;
/*     */   }
/*     */   
/*     */   public void setFileSize(Long fileSize) {
/* 107 */     this.fileSize = fileSize;
/*     */   }
/*     */   
/*     */   public String getFileType() {
/* 111 */     return this.fileType;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Attachment fileType(String fileType) {
/* 115 */     setFileType(fileType);
/* 116 */     return this;
/*     */   }
/*     */   
/*     */   public void setFileType(String fileType) {
/* 120 */     this.fileType = fileType;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 124 */     return this.description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Attachment description(String description) {
/* 128 */     setDescription(description);
/* 129 */     return this;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 133 */     this.description = description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Attachment createdBy(String createdBy) {
/* 137 */     setCreatedBy(createdBy);
/* 138 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Attachment createdDate(Instant createdDate) {
/* 142 */     setCreatedDate(createdDate);
/* 143 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Attachment lastModifiedBy(String lastModifiedBy) {
/* 147 */     setLastModifiedBy(lastModifiedBy);
/* 148 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Attachment lastModifiedDate(Instant lastModifiedDate) {
/* 152 */     setLastModifiedDate(lastModifiedDate);
/* 153 */     return this;
/*     */   }
/*     */   
/*     */   public Content getContent() {
/* 157 */     return this.content;
/*     */   }
/*     */   
/*     */   public void setContent(Content content) {
/* 161 */     this.content = content;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Attachment content(Content content) {
/* 165 */     setContent(content);
/* 166 */     return this;
/*     */   }
/*     */   
/*     */   public Employee getEmployee() {
/* 170 */     return this.employee;
/*     */   }
/*     */   
/*     */   public void setEmployee(Employee employee) {
/* 174 */     this.employee = employee;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Attachment employee(Employee employee) {
/* 178 */     setEmployee(employee);
/* 179 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 186 */     if (this == o) {
/* 187 */       return true;
/*     */     }
/* 189 */     if (!(o instanceof com.nanosoft.amtk.domain.Attachment)) {
/* 190 */       return false;
/*     */     }
/* 192 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.Attachment)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 198 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 205 */     return "Attachment{id=" + getId() + ", title='" + 
/* 206 */       getTitle() + "', fileName='" + 
/* 207 */       getFileName() + "', fileSize=" + 
/* 208 */       getFileSize() + ", fileType='" + 
/* 209 */       getFileType() + "', description='" + 
/* 210 */       getDescription() + "', createdBy='" + 
/* 211 */       getCreatedBy() + "', createdDate='" + 
/* 212 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 213 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 214 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Attachment.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */