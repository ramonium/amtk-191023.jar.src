/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.nanosoft.amtk.domain.AbstractAuditingEntity;
/*     */ import com.nanosoft.amtk.domain.Assignment;
/*     */ import com.nanosoft.amtk.domain.CertificationLevel;
/*     */ import com.nanosoft.amtk.domain.Checklist;
/*     */ import com.nanosoft.amtk.domain.enumeration.CertificationStatus;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.EnumType;
/*     */ import javax.persistence.Enumerated;
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
/*     */ @Table(name = "certificate")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class Certificate
/*     */   extends AbstractAuditingEntity
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
/*     */   @SequenceGenerator(name = "sequenceGenerator")
/*     */   @Column(name = "id")
/*     */   private Long id;
/*     */   @Enumerated(EnumType.STRING)
/*     */   @Column(name = "status")
/*     */   private CertificationStatus status;
/*     */   @NotNull
/*     */   @Column(name = "start_date", nullable = false)
/*     */   private Instant startDate;
/*     */   @NotNull
/*     */   @Column(name = "expected_end_date", nullable = false)
/*     */   private Instant expectedEndDate;
/*     */   @Column(name = "end_date")
/*     */   private Instant endDate;
/*     */   @Column(name = "validated")
/*     */   private Boolean validated;
/*     */   @Column(name = "is_recycling")
/*     */   private Boolean isRecycling;
/*     */   @ManyToOne
/*     */   @JsonIgnoreProperties(value = {"certificates", "workstation", "employee", "currentCertificate"}, allowSetters = true)
/*     */   private Assignment assignment;
/*     */   @JsonIgnoreProperties(value = {"certificates", "workstation", "employee", "currentCertificate"}, allowSetters = true)
/*     */   @OneToOne(mappedBy = "currentCertificate")
/*     */   private Assignment forAssigment;
/*     */   @ManyToOne(optional = false)
/*     */   @NotNull
/*     */   @JsonIgnoreProperties(value = {"certificates", "process", "checklistModel"}, allowSetters = true)
/*     */   private CertificationLevel level;
/*     */   @JsonIgnoreProperties(value = {"certificate", "checklistModel", "checklistItems"}, allowSetters = true)
/*     */   @OneToOne
/*     */   @JoinColumn(unique = true)
/*     */   private Checklist checklist;
/*     */   
/*     */   public Long getId() {
/*  71 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Certificate id(Long id) {
/*  75 */     setId(id);
/*  76 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  80 */     this.id = id;
/*     */   }
/*     */   
/*     */   public CertificationStatus getStatus() {
/*  84 */     return this.status;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Certificate status(CertificationStatus status) {
/*  88 */     setStatus(status);
/*  89 */     return this;
/*     */   }
/*     */   
/*     */   public void setStatus(CertificationStatus status) {
/*  93 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Instant getStartDate() {
/*  97 */     return this.startDate;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Certificate startDate(Instant startDate) {
/* 101 */     setStartDate(startDate);
/* 102 */     return this;
/*     */   }
/*     */   
/*     */   public void setStartDate(Instant startDate) {
/* 106 */     this.startDate = startDate;
/*     */   }
/*     */   
/*     */   public Instant getExpectedEndDate() {
/* 110 */     return this.expectedEndDate;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Certificate expectedEndDate(Instant expectedEndDate) {
/* 114 */     setExpectedEndDate(expectedEndDate);
/* 115 */     return this;
/*     */   }
/*     */   
/*     */   public void setExpectedEndDate(Instant expectedEndDate) {
/* 119 */     this.expectedEndDate = expectedEndDate;
/*     */   }
/*     */   
/*     */   public Instant getEndDate() {
/* 123 */     return this.endDate;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Certificate endDate(Instant endDate) {
/* 127 */     setEndDate(endDate);
/* 128 */     return this;
/*     */   }
/*     */   
/*     */   public void setEndDate(Instant endDate) {
/* 132 */     this.endDate = endDate;
/*     */   }
/*     */   
/*     */   public Boolean getValidated() {
/* 136 */     return this.validated;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Certificate validated(Boolean validated) {
/* 140 */     setValidated(validated);
/* 141 */     return this;
/*     */   }
/*     */   
/*     */   public void setValidated(Boolean validated) {
/* 145 */     this.validated = validated;
/*     */   }
/*     */   
/*     */   public Boolean getIsRecycling() {
/* 149 */     return this.isRecycling;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Certificate isRecycling(Boolean isRecycling) {
/* 153 */     setIsRecycling(isRecycling);
/* 154 */     return this;
/*     */   }
/*     */   
/*     */   public void setIsRecycling(Boolean isRecycling) {
/* 158 */     this.isRecycling = isRecycling;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Certificate createdBy(String createdBy) {
/* 162 */     setCreatedBy(createdBy);
/* 163 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Certificate createdDate(Instant createdDate) {
/* 167 */     setCreatedDate(createdDate);
/* 168 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Certificate lastModifiedBy(String lastModifiedBy) {
/* 172 */     setLastModifiedBy(lastModifiedBy);
/* 173 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Certificate lastModifiedDate(Instant lastModifiedDate) {
/* 177 */     setLastModifiedDate(lastModifiedDate);
/* 178 */     return this;
/*     */   }
/*     */   
/*     */   public Assignment getAssignment() {
/* 182 */     return this.assignment;
/*     */   }
/*     */   
/*     */   public void setAssignment(Assignment assignment) {
/* 186 */     this.assignment = assignment;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Certificate assignment(Assignment assignment) {
/* 190 */     setAssignment(assignment);
/* 191 */     return this;
/*     */   }
/*     */   
/*     */   public Assignment getForAssigment() {
/* 195 */     return this.forAssigment;
/*     */   }
/*     */   
/*     */   public void setForAssigment(Assignment assignment) {
/* 199 */     if (this.forAssigment != null) {
/* 200 */       this.forAssigment.setCurrentCertificate(null);
/*     */     }
/* 202 */     if (assignment != null) {
/* 203 */       assignment.setCurrentCertificate(this);
/*     */     }
/* 205 */     this.forAssigment = assignment;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Certificate forAssigment(Assignment assignment) {
/* 209 */     setForAssigment(assignment);
/* 210 */     return this;
/*     */   }
/*     */   
/*     */   public CertificationLevel getLevel() {
/* 214 */     return this.level;
/*     */   }
/*     */   
/*     */   public void setLevel(CertificationLevel certificationLevel) {
/* 218 */     this.level = certificationLevel;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Certificate level(CertificationLevel certificationLevel) {
/* 222 */     setLevel(certificationLevel);
/* 223 */     return this;
/*     */   }
/*     */   
/*     */   public Checklist getChecklist() {
/* 227 */     return this.checklist;
/*     */   }
/*     */   
/*     */   public void setChecklist(Checklist checklist) {
/* 231 */     this.checklist = checklist;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Certificate checklist(Checklist checklist) {
/* 235 */     setChecklist(checklist);
/* 236 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 243 */     if (this == o) {
/* 244 */       return true;
/*     */     }
/* 246 */     if (!(o instanceof com.nanosoft.amtk.domain.Certificate)) {
/* 247 */       return false;
/*     */     }
/* 249 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.Certificate)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 255 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 262 */     return "Certificate{id=" + getId() + ", status='" + 
/* 263 */       getStatus() + "', startDate='" + 
/* 264 */       getStartDate() + "', expectedEndDate='" + 
/* 265 */       getExpectedEndDate() + "', endDate='" + 
/* 266 */       getEndDate() + "', validated='" + 
/* 267 */       getValidated() + "', isRecycling='" + 
/* 268 */       getIsRecycling() + "', createdBy='" + 
/* 269 */       getCreatedBy() + "', createdDate='" + 
/* 270 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 271 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 272 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Certificate.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */