/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.nanosoft.amtk.domain.AbstractAuditingEntity;
/*     */ import com.nanosoft.amtk.domain.Certificate;
/*     */ import com.nanosoft.amtk.domain.Employee;
/*     */ import com.nanosoft.amtk.domain.Workstation;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.OneToOne;
/*     */ import javax.persistence.SequenceGenerator;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import org.hibernate.annotations.Cache;
/*     */ import org.hibernate.annotations.CacheConcurrencyStrategy;
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "assignment")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class Assignment
/*     */   extends AbstractAuditingEntity
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @OneToMany(mappedBy = "assignment")
/*     */   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */   @JsonIgnoreProperties(value = {"assignment", "forAssigment", "level", "checklist"}, allowSetters = true)
/*  39 */   private Set<Certificate> certificates = new HashSet<>(); @Id
/*     */   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
/*     */   @SequenceGenerator(name = "sequenceGenerator")
/*     */   @Column(name = "id")
/*     */   private Long id; @NotNull
/*     */   @Column(name = "assignment_start", nullable = false)
/*     */   private Instant assignmentStart; @Column(name = "assignment_end")
/*     */   private Instant assignmentEnd; @Column(name = "description")
/*     */   private String description;
/*     */   @ManyToOne(optional = false)
/*     */   @NotNull
/*     */   @JsonIgnoreProperties(value = {"assignments", "area", "process"}, allowSetters = true)
/*     */   private Workstation workstation;
/*     */   @ManyToOne(optional = false)
/*     */   @NotNull
/*     */   @JsonIgnoreProperties(value = {"attachments", "assignments", "title", "team", "managedTeams"}, allowSetters = true)
/*     */   private Employee employee;
/*     */   @JsonIgnoreProperties(value = {"assignment", "forAssigment", "level", "checklist"}, allowSetters = true)
/*     */   @OneToOne
/*     */   @JoinColumn(unique = true)
/*     */   private Certificate currentCertificate;
/*     */   
/*     */   public Long getId() {
/*  62 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Assignment id(Long id) {
/*  66 */     setId(id);
/*  67 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  71 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Instant getAssignmentStart() {
/*  75 */     return this.assignmentStart;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Assignment assignmentStart(Instant assignmentStart) {
/*  79 */     setAssignmentStart(assignmentStart);
/*  80 */     return this;
/*     */   }
/*     */   
/*     */   public void setAssignmentStart(Instant assignmentStart) {
/*  84 */     this.assignmentStart = assignmentStart;
/*     */   }
/*     */   
/*     */   public Instant getAssignmentEnd() {
/*  88 */     return this.assignmentEnd;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Assignment assignmentEnd(Instant assignmentEnd) {
/*  92 */     setAssignmentEnd(assignmentEnd);
/*  93 */     return this;
/*     */   }
/*     */   
/*     */   public void setAssignmentEnd(Instant assignmentEnd) {
/*  97 */     this.assignmentEnd = assignmentEnd;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 101 */     return this.description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Assignment description(String description) {
/* 105 */     setDescription(description);
/* 106 */     return this;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 110 */     this.description = description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Assignment createdBy(String createdBy) {
/* 114 */     setCreatedBy(createdBy);
/* 115 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Assignment createdDate(Instant createdDate) {
/* 119 */     setCreatedDate(createdDate);
/* 120 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Assignment lastModifiedBy(String lastModifiedBy) {
/* 124 */     setLastModifiedBy(lastModifiedBy);
/* 125 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Assignment lastModifiedDate(Instant lastModifiedDate) {
/* 129 */     setLastModifiedDate(lastModifiedDate);
/* 130 */     return this;
/*     */   }
/*     */   
/*     */   public Set<Certificate> getCertificates() {
/* 134 */     return this.certificates;
/*     */   }
/*     */   
/*     */   public void setCertificates(Set<Certificate> certificates) {
/* 138 */     if (this.certificates != null) {
/* 139 */       this.certificates.forEach(i -> i.setAssignment(null));
/*     */     }
/* 141 */     if (certificates != null) {
/* 142 */       certificates.forEach(i -> i.setAssignment(this));
/*     */     }
/* 144 */     this.certificates = certificates;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Assignment certificates(Set<Certificate> certificates) {
/* 148 */     setCertificates(certificates);
/* 149 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Assignment addCertificate(Certificate certificate) {
/* 153 */     this.certificates.add(certificate);
/* 154 */     certificate.setAssignment(this);
/* 155 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Assignment removeCertificate(Certificate certificate) {
/* 159 */     this.certificates.remove(certificate);
/* 160 */     certificate.setAssignment(null);
/* 161 */     return this;
/*     */   }
/*     */   
/*     */   public Workstation getWorkstation() {
/* 165 */     return this.workstation;
/*     */   }
/*     */   
/*     */   public void setWorkstation(Workstation workstation) {
/* 169 */     this.workstation = workstation;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Assignment workstation(Workstation workstation) {
/* 173 */     setWorkstation(workstation);
/* 174 */     return this;
/*     */   }
/*     */   
/*     */   public Employee getEmployee() {
/* 178 */     return this.employee;
/*     */   }
/*     */   
/*     */   public void setEmployee(Employee employee) {
/* 182 */     this.employee = employee;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Assignment employee(Employee employee) {
/* 186 */     setEmployee(employee);
/* 187 */     return this;
/*     */   }
/*     */   
/*     */   public Certificate getCurrentCertificate() {
/* 191 */     return this.currentCertificate;
/*     */   }
/*     */   
/*     */   public void setCurrentCertificate(Certificate certificate) {
/* 195 */     this.currentCertificate = certificate;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Assignment currentCertificate(Certificate certificate) {
/* 199 */     setCurrentCertificate(certificate);
/* 200 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 207 */     if (this == o) {
/* 208 */       return true;
/*     */     }
/* 210 */     if (!(o instanceof com.nanosoft.amtk.domain.Assignment)) {
/* 211 */       return false;
/*     */     }
/* 213 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.Assignment)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 219 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 226 */     return "Assignment{id=" + getId() + ", assignmentStart='" + 
/* 227 */       getAssignmentStart() + "', assignmentEnd='" + 
/* 228 */       getAssignmentEnd() + "', description='" + 
/* 229 */       getDescription() + "', createdBy='" + 
/* 230 */       getCreatedBy() + "', createdDate='" + 
/* 231 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 232 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 233 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Assignment.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */