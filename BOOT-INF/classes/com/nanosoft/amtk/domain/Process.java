/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.nanosoft.amtk.domain.AbstractAuditingEntity;
/*     */ import com.nanosoft.amtk.domain.CertificationLevel;
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
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.SequenceGenerator;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import org.hibernate.annotations.Cache;
/*     */ import org.hibernate.annotations.CacheConcurrencyStrategy;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "process")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class Process extends AbstractAuditingEntity implements Serializable {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
/*     */   @SequenceGenerator(name = "sequenceGenerator")
/*     */   @Column(name = "id")
/*     */   private Long id;
/*     */   @OneToMany(mappedBy = "process")
/*     */   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */   @JsonIgnoreProperties(value = {"assignments", "area", "process"}, allowSetters = true)
/*  36 */   private Set<Workstation> workstations = new HashSet<>();
/*     */   
/*     */   @OneToMany(mappedBy = "process")
/*     */   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */   @JsonIgnoreProperties(value = {"certificates", "process", "checklistModel"}, allowSetters = true)
/*  41 */   private Set<CertificationLevel> certificationLevels = new HashSet<>();
/*     */   @NotNull
/*     */   @Column(name = "name", nullable = false, unique = true)
/*     */   private String name;
/*     */   @Column(name = "description")
/*     */   private String description;
/*     */   
/*     */   public Long getId() {
/*  49 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Process id(Long id) {
/*  53 */     setId(id);
/*  54 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  58 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  62 */     return this.name;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Process name(String name) {
/*  66 */     setName(name);
/*  67 */     return this;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  71 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  75 */     return this.description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Process description(String description) {
/*  79 */     setDescription(description);
/*  80 */     return this;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  84 */     this.description = description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Process createdBy(String createdBy) {
/*  88 */     setCreatedBy(createdBy);
/*  89 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Process createdDate(Instant createdDate) {
/*  93 */     setCreatedDate(createdDate);
/*  94 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Process lastModifiedBy(String lastModifiedBy) {
/*  98 */     setLastModifiedBy(lastModifiedBy);
/*  99 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Process lastModifiedDate(Instant lastModifiedDate) {
/* 103 */     setLastModifiedDate(lastModifiedDate);
/* 104 */     return this;
/*     */   }
/*     */   
/*     */   public Set<Workstation> getWorkstations() {
/* 108 */     return this.workstations;
/*     */   }
/*     */   
/*     */   public void setWorkstations(Set<Workstation> workstations) {
/* 112 */     if (this.workstations != null) {
/* 113 */       this.workstations.forEach(i -> i.setProcess(null));
/*     */     }
/* 115 */     if (workstations != null) {
/* 116 */       workstations.forEach(i -> i.setProcess(this));
/*     */     }
/* 118 */     this.workstations = workstations;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Process workstations(Set<Workstation> workstations) {
/* 122 */     setWorkstations(workstations);
/* 123 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Process addWorkstation(Workstation workstation) {
/* 127 */     this.workstations.add(workstation);
/* 128 */     workstation.setProcess(this);
/* 129 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Process removeWorkstation(Workstation workstation) {
/* 133 */     this.workstations.remove(workstation);
/* 134 */     workstation.setProcess(null);
/* 135 */     return this;
/*     */   }
/*     */   
/*     */   public Set<CertificationLevel> getCertificationLevels() {
/* 139 */     return this.certificationLevels;
/*     */   }
/*     */   
/*     */   public void setCertificationLevels(Set<CertificationLevel> certificationLevels) {
/* 143 */     if (this.certificationLevels != null) {
/* 144 */       this.certificationLevels.forEach(i -> i.setProcess(null));
/*     */     }
/* 146 */     if (certificationLevels != null) {
/* 147 */       certificationLevels.forEach(i -> i.setProcess(this));
/*     */     }
/* 149 */     this.certificationLevels = certificationLevels;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Process certificationLevels(Set<CertificationLevel> certificationLevels) {
/* 153 */     setCertificationLevels(certificationLevels);
/* 154 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Process addCertificationLevel(CertificationLevel certificationLevel) {
/* 158 */     this.certificationLevels.add(certificationLevel);
/* 159 */     certificationLevel.setProcess(this);
/* 160 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Process removeCertificationLevel(CertificationLevel certificationLevel) {
/* 164 */     this.certificationLevels.remove(certificationLevel);
/* 165 */     certificationLevel.setProcess(null);
/* 166 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 173 */     if (this == o) {
/* 174 */       return true;
/*     */     }
/* 176 */     if (!(o instanceof com.nanosoft.amtk.domain.Process)) {
/* 177 */       return false;
/*     */     }
/* 179 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.Process)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 185 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 192 */     return "Process{id=" + getId() + ", name='" + 
/* 193 */       getName() + "', description='" + 
/* 194 */       getDescription() + "', createdBy='" + 
/* 195 */       getCreatedBy() + "', createdDate='" + 
/* 196 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 197 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 198 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Process.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */