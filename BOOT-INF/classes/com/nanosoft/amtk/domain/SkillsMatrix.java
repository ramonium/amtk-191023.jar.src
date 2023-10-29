/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.nanosoft.amtk.domain.AbstractAuditingEntity;
/*     */ import com.nanosoft.amtk.domain.Project;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Lob;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToOne;
/*     */ import javax.persistence.SequenceGenerator;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import org.hibernate.annotations.Cache;
/*     */ import org.hibernate.annotations.CacheConcurrencyStrategy;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "skills_matrix")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class SkillsMatrix
/*     */   extends AbstractAuditingEntity implements Serializable {
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
/*     */   @ManyToOne(optional = false)
/*     */   @NotNull
/*     */   @JsonIgnoreProperties(value = {"areas", "skillsMatrixHistories", "skillsMatrix"}, allowSetters = true)
/*     */   private Project project;
/*     */   @JsonIgnoreProperties(value = {"areas", "skillsMatrixHistories", "skillsMatrix"}, allowSetters = true)
/*     */   @OneToOne(mappedBy = "skillsMatrix")
/*     */   private Project forProject;
/*     */   
/*     */   public Long getId() {
/*  48 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.SkillsMatrix id(Long id) {
/*  52 */     setId(id);
/*  53 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  57 */     this.id = id;
/*     */   }
/*     */   
/*     */   public byte[] getData() {
/*  61 */     return this.data;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.SkillsMatrix data(byte[] data) {
/*  65 */     setData(data);
/*  66 */     return this;
/*     */   }
/*     */   
/*     */   public void setData(byte[] data) {
/*  70 */     this.data = data;
/*     */   }
/*     */   
/*     */   public String getDataContentType() {
/*  74 */     return this.dataContentType;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.SkillsMatrix dataContentType(String dataContentType) {
/*  78 */     this.dataContentType = dataContentType;
/*  79 */     return this;
/*     */   }
/*     */   
/*     */   public void setDataContentType(String dataContentType) {
/*  83 */     this.dataContentType = dataContentType;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.SkillsMatrix createdBy(String createdBy) {
/*  87 */     setCreatedBy(createdBy);
/*  88 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.SkillsMatrix createdDate(Instant createdDate) {
/*  92 */     setCreatedDate(createdDate);
/*  93 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.SkillsMatrix lastModifiedBy(String lastModifiedBy) {
/*  97 */     setLastModifiedBy(lastModifiedBy);
/*  98 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.SkillsMatrix lastModifiedDate(Instant lastModifiedDate) {
/* 102 */     setLastModifiedDate(lastModifiedDate);
/* 103 */     return this;
/*     */   }
/*     */   
/*     */   public Project getProject() {
/* 107 */     return this.project;
/*     */   }
/*     */   
/*     */   public void setProject(Project project) {
/* 111 */     this.project = project;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.SkillsMatrix project(Project project) {
/* 115 */     setProject(project);
/* 116 */     return this;
/*     */   }
/*     */   
/*     */   public Project getForProject() {
/* 120 */     return this.forProject;
/*     */   }
/*     */   
/*     */   public void setForProject(Project project) {
/* 124 */     if (this.forProject != null) {
/* 125 */       this.forProject.setSkillsMatrix(null);
/*     */     }
/* 127 */     if (project != null) {
/* 128 */       project.setSkillsMatrix(this);
/*     */     }
/* 130 */     this.forProject = project;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.SkillsMatrix forProject(Project project) {
/* 134 */     setForProject(project);
/* 135 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 142 */     if (this == o) {
/* 143 */       return true;
/*     */     }
/* 145 */     if (!(o instanceof com.nanosoft.amtk.domain.SkillsMatrix)) {
/* 146 */       return false;
/*     */     }
/* 148 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.SkillsMatrix)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 154 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 161 */     return "SkillsMatrix{id=" + getId() + ", data='" + 
/* 162 */       getData() + "', dataContentType='" + 
/* 163 */       getDataContentType() + "', createdBy='" + 
/* 164 */       getCreatedBy() + "', createdDate='" + 
/* 165 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 166 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 167 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\SkillsMatrix.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */