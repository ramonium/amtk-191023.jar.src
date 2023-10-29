/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.nanosoft.amtk.domain.AbstractAuditingEntity;
/*     */ import com.nanosoft.amtk.domain.Attachment;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Lob;
/*     */ import javax.persistence.OneToOne;
/*     */ import javax.persistence.SequenceGenerator;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import org.hibernate.annotations.Cache;
/*     */ import org.hibernate.annotations.CacheConcurrencyStrategy;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "content")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class Content extends AbstractAuditingEntity implements Serializable {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
/*     */   @SequenceGenerator(name = "sequenceGenerator")
/*     */   @Column(name = "id")
/*     */   private Long id;
/*     */   @Lob
/*     */   @Column(name = "data", nullable = false)
/*     */   private byte[] data;
/*     */   @NotNull
/*     */   @Column(name = "data_content_type", nullable = false)
/*     */   private String dataContentType;
/*     */   @JsonIgnoreProperties(value = {"content", "employee"}, allowSetters = true)
/*     */   @OneToOne(mappedBy = "content")
/*     */   private Attachment attachment;
/*     */   
/*     */   public Long getId() {
/*  42 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Content id(Long id) {
/*  46 */     setId(id);
/*  47 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  51 */     this.id = id;
/*     */   }
/*     */   
/*     */   public byte[] getData() {
/*  55 */     return this.data;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Content data(byte[] data) {
/*  59 */     setData(data);
/*  60 */     return this;
/*     */   }
/*     */   
/*     */   public void setData(byte[] data) {
/*  64 */     this.data = data;
/*     */   }
/*     */   
/*     */   public String getDataContentType() {
/*  68 */     return this.dataContentType;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Content dataContentType(String dataContentType) {
/*  72 */     this.dataContentType = dataContentType;
/*  73 */     return this;
/*     */   }
/*     */   
/*     */   public void setDataContentType(String dataContentType) {
/*  77 */     this.dataContentType = dataContentType;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Content createdBy(String createdBy) {
/*  81 */     setCreatedBy(createdBy);
/*  82 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Content createdDate(Instant createdDate) {
/*  86 */     setCreatedDate(createdDate);
/*  87 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Content lastModifiedBy(String lastModifiedBy) {
/*  91 */     setLastModifiedBy(lastModifiedBy);
/*  92 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Content lastModifiedDate(Instant lastModifiedDate) {
/*  96 */     setLastModifiedDate(lastModifiedDate);
/*  97 */     return this;
/*     */   }
/*     */   
/*     */   public Attachment getAttachment() {
/* 101 */     return this.attachment;
/*     */   }
/*     */   
/*     */   public void setAttachment(Attachment attachment) {
/* 105 */     if (this.attachment != null) {
/* 106 */       this.attachment.setContent(null);
/*     */     }
/* 108 */     if (attachment != null) {
/* 109 */       attachment.setContent(this);
/*     */     }
/* 111 */     this.attachment = attachment;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Content attachment(Attachment attachment) {
/* 115 */     setAttachment(attachment);
/* 116 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 123 */     if (this == o) {
/* 124 */       return true;
/*     */     }
/* 126 */     if (!(o instanceof com.nanosoft.amtk.domain.Content)) {
/* 127 */       return false;
/*     */     }
/* 129 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.Content)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 135 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 142 */     return "Content{id=" + getId() + ", data='" + 
/* 143 */       getData() + "', dataContentType='" + 
/* 144 */       getDataContentType() + "', createdBy='" + 
/* 145 */       getCreatedBy() + "', createdDate='" + 
/* 146 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 147 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 148 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Content.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */