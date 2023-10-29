/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.nanosoft.amtk.domain.AbstractAuditingEntity;
/*     */ import com.nanosoft.amtk.domain.Certificate;
/*     */ import com.nanosoft.amtk.domain.ChecklistModel;
/*     */ import com.nanosoft.amtk.domain.Process;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import java.time.Period;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.SequenceGenerator;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import javax.validation.constraints.Pattern;
/*     */ import org.hibernate.annotations.Cache;
/*     */ import org.hibernate.annotations.CacheConcurrencyStrategy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "certification_level")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class CertificationLevel
/*     */   extends AbstractAuditingEntity
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
/*     */   @SequenceGenerator(name = "sequenceGenerator")
/*     */   @Column(name = "id")
/*     */   private Long id;
/*     */   @NotNull
/*     */   @Column(name = "level", nullable = false)
/*     */   private String level;
/*     */   @OneToMany(mappedBy = "level")
/*     */   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */   @JsonIgnoreProperties(value = {"assignment", "forAssigment", "level", "checklist"}, allowSetters = true)
/*  51 */   private Set<Certificate> certificates = new HashSet<>(); @Column(name = "order_number")
/*     */   private Integer orderNumber; @NotNull
/*     */   @Pattern(regexp = "([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?")
/*     */   @Column(name = "training_duration", nullable = false)
/*     */   private String trainingDuration; @NotNull
/*     */   @Pattern(regexp = "([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?")
/*     */   @Column(name = "recycling_period", nullable = false)
/*     */   private String recyclingPeriod; @Column(name = "description")
/*     */   private String description; @ManyToOne(optional = false)
/*     */   @NotNull
/*     */   @JsonIgnoreProperties(value = {"workstations", "certificationLevels"}, allowSetters = true)
/*     */   private Process process;
/*     */   @ManyToOne
/*     */   @JsonIgnoreProperties(value = {"certificationLevels", "checklists", "checklistModelItems"}, allowSetters = true)
/*     */   private ChecklistModel checklistModel;
/*     */   
/*     */   public Long getId() {
/*  68 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.CertificationLevel id(Long id) {
/*  72 */     setId(id);
/*  73 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  77 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getLevel() {
/*  81 */     return this.level;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.CertificationLevel level(String level) {
/*  85 */     setLevel(level);
/*  86 */     return this;
/*     */   }
/*     */   
/*     */   public void setLevel(String level) {
/*  90 */     this.level = level;
/*     */   }
/*     */   
/*     */   public Integer getOrderNumber() {
/*  94 */     return this.orderNumber;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.CertificationLevel orderNumber(Integer orderNumber) {
/*  98 */     setOrderNumber(orderNumber);
/*  99 */     return this;
/*     */   }
/*     */   
/*     */   public void setOrderNumber(Integer orderNumber) {
/* 103 */     this.orderNumber = orderNumber;
/*     */   }
/*     */   
/*     */   public String getTrainingDuration() {
/* 107 */     return this.trainingDuration;
/*     */   }
/*     */   
/*     */   @JsonIgnore
/*     */   public Period getTrainingDurationAsPeriod() {
/* 112 */     return Period.parse(this.trainingDuration);
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.CertificationLevel trainingDuration(String trainingDuration) {
/* 116 */     setTrainingDuration(trainingDuration);
/* 117 */     return this;
/*     */   }
/*     */   
/*     */   public void setTrainingDuration(String trainingDuration) {
/* 121 */     this.trainingDuration = trainingDuration;
/*     */   }
/*     */   
/*     */   public String getRecyclingPeriod() {
/* 125 */     return this.recyclingPeriod;
/*     */   }
/*     */   
/*     */   @JsonIgnore
/*     */   public Period getRecyclingAsPeriod() {
/* 130 */     return Period.parse(this.recyclingPeriod);
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.CertificationLevel recyclingPeriod(String recyclingPeriod) {
/* 134 */     setRecyclingPeriod(recyclingPeriod);
/* 135 */     return this;
/*     */   }
/*     */   
/*     */   public void setRecyclingPeriod(String recyclingPeriod) {
/* 139 */     this.recyclingPeriod = recyclingPeriod;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 143 */     return this.description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.CertificationLevel description(String description) {
/* 147 */     setDescription(description);
/* 148 */     return this;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 152 */     this.description = description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.CertificationLevel createdBy(String createdBy) {
/* 156 */     setCreatedBy(createdBy);
/* 157 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.CertificationLevel createdDate(Instant createdDate) {
/* 161 */     setCreatedDate(createdDate);
/* 162 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.CertificationLevel lastModifiedBy(String lastModifiedBy) {
/* 166 */     setLastModifiedBy(lastModifiedBy);
/* 167 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.CertificationLevel lastModifiedDate(Instant lastModifiedDate) {
/* 171 */     setLastModifiedDate(lastModifiedDate);
/* 172 */     return this;
/*     */   }
/*     */   
/*     */   public Set<Certificate> getCertificates() {
/* 176 */     return this.certificates;
/*     */   }
/*     */   
/*     */   public void setCertificates(Set<Certificate> certificates) {
/* 180 */     if (this.certificates != null) {
/* 181 */       this.certificates.forEach(i -> i.setLevel(null));
/*     */     }
/* 183 */     if (certificates != null) {
/* 184 */       certificates.forEach(i -> i.setLevel(this));
/*     */     }
/* 186 */     this.certificates = certificates;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.CertificationLevel certificates(Set<Certificate> certificates) {
/* 190 */     setCertificates(certificates);
/* 191 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.CertificationLevel addCertificate(Certificate certificate) {
/* 195 */     this.certificates.add(certificate);
/* 196 */     certificate.setLevel(this);
/* 197 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.CertificationLevel removeCertificate(Certificate certificate) {
/* 201 */     this.certificates.remove(certificate);
/* 202 */     certificate.setLevel(null);
/* 203 */     return this;
/*     */   }
/*     */   
/*     */   public Process getProcess() {
/* 207 */     return this.process;
/*     */   }
/*     */   
/*     */   public void setProcess(Process process) {
/* 211 */     this.process = process;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.CertificationLevel process(Process process) {
/* 215 */     setProcess(process);
/* 216 */     return this;
/*     */   }
/*     */   
/*     */   public ChecklistModel getChecklistModel() {
/* 220 */     return this.checklistModel;
/*     */   }
/*     */   
/*     */   public void setChecklistModel(ChecklistModel checklistModel) {
/* 224 */     this.checklistModel = checklistModel;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.CertificationLevel checklistModel(ChecklistModel checklistModel) {
/* 228 */     setChecklistModel(checklistModel);
/* 229 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 236 */     if (this == o) {
/* 237 */       return true;
/*     */     }
/* 239 */     if (!(o instanceof com.nanosoft.amtk.domain.CertificationLevel)) {
/* 240 */       return false;
/*     */     }
/* 242 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.CertificationLevel)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 248 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 255 */     return "CertificationLevel{id=" + getId() + ", level='" + 
/* 256 */       getLevel() + "', orderNumber=" + 
/* 257 */       getOrderNumber() + ", trainingDuration='" + 
/* 258 */       getTrainingDuration() + "', recyclingPeriod='" + 
/* 259 */       getRecyclingPeriod() + "', description='" + 
/* 260 */       getDescription() + "', createdBy='" + 
/* 261 */       getCreatedBy() + "', createdDate='" + 
/* 262 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 263 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 264 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\CertificationLevel.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */