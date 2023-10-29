/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.nanosoft.amtk.domain.AbstractAuditingEntity;
/*     */ import com.nanosoft.amtk.domain.Area;
/*     */ import com.nanosoft.amtk.domain.Assignment;
/*     */ import com.nanosoft.amtk.domain.Process;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
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
/*     */ import org.hibernate.annotations.Cache;
/*     */ import org.hibernate.annotations.CacheConcurrencyStrategy;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "workstation")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class Workstation
/*     */   extends AbstractAuditingEntity implements Serializable {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
/*     */   @SequenceGenerator(name = "sequenceGenerator")
/*     */   @Column(name = "id")
/*     */   private Long id;
/*     */   @OneToMany(mappedBy = "workstation")
/*     */   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */   @JsonIgnoreProperties(value = {"certificates", "workstation", "employee", "currentCertificate"}, allowSetters = true)
/*  39 */   private Set<Assignment> assignments = new HashSet<>();
/*     */   @NotNull
/*     */   @Column(name = "name", nullable = false)
/*     */   private String name;
/*     */   @Column(name = "description")
/*     */   private String description;
/*     */   @Column(name = "order_number")
/*     */   private Integer orderNumber;
/*     */   @ManyToOne(optional = false)
/*     */   @NotNull
/*     */   @JsonIgnoreProperties(value = {"workstations", "project"}, allowSetters = true)
/*     */   private Area area;
/*     */   @ManyToOne(optional = false)
/*     */   @NotNull
/*     */   @JsonIgnoreProperties(value = {"workstations", "certificationLevels"}, allowSetters = true)
/*     */   private Process process;
/*     */   
/*     */   public Long getId() {
/*  57 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Workstation id(Long id) {
/*  61 */     setId(id);
/*  62 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  66 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  70 */     return this.name;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Workstation name(String name) {
/*  74 */     setName(name);
/*  75 */     return this;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  79 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  83 */     return this.description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Workstation description(String description) {
/*  87 */     setDescription(description);
/*  88 */     return this;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  92 */     this.description = description;
/*     */   }
/*     */   
/*     */   public Integer getOrderNumber() {
/*  96 */     return this.orderNumber;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Workstation orderNumber(Integer orderNumber) {
/* 100 */     setOrderNumber(orderNumber);
/* 101 */     return this;
/*     */   }
/*     */   
/*     */   public void setOrderNumber(Integer orderNumber) {
/* 105 */     this.orderNumber = orderNumber;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Workstation createdBy(String createdBy) {
/* 109 */     setCreatedBy(createdBy);
/* 110 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Workstation createdDate(Instant createdDate) {
/* 114 */     setCreatedDate(createdDate);
/* 115 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Workstation lastModifiedBy(String lastModifiedBy) {
/* 119 */     setLastModifiedBy(lastModifiedBy);
/* 120 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Workstation lastModifiedDate(Instant lastModifiedDate) {
/* 124 */     setLastModifiedDate(lastModifiedDate);
/* 125 */     return this;
/*     */   }
/*     */   
/*     */   public Set<Assignment> getAssignments() {
/* 129 */     return this.assignments;
/*     */   }
/*     */   
/*     */   public void setAssignments(Set<Assignment> assignments) {
/* 133 */     if (this.assignments != null) {
/* 134 */       this.assignments.forEach(i -> i.setWorkstation(null));
/*     */     }
/* 136 */     if (assignments != null) {
/* 137 */       assignments.forEach(i -> i.setWorkstation(this));
/*     */     }
/* 139 */     this.assignments = assignments;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Workstation assignments(Set<Assignment> assignments) {
/* 143 */     setAssignments(assignments);
/* 144 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Workstation addAssignment(Assignment assignment) {
/* 148 */     this.assignments.add(assignment);
/* 149 */     assignment.setWorkstation(this);
/* 150 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Workstation removeAssignment(Assignment assignment) {
/* 154 */     this.assignments.remove(assignment);
/* 155 */     assignment.setWorkstation(null);
/* 156 */     return this;
/*     */   }
/*     */   
/*     */   public Area getArea() {
/* 160 */     return this.area;
/*     */   }
/*     */   
/*     */   public void setArea(Area area) {
/* 164 */     this.area = area;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Workstation area(Area area) {
/* 168 */     setArea(area);
/* 169 */     return this;
/*     */   }
/*     */   
/*     */   public Process getProcess() {
/* 173 */     return this.process;
/*     */   }
/*     */   
/*     */   public void setProcess(Process process) {
/* 177 */     this.process = process;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Workstation process(Process process) {
/* 181 */     setProcess(process);
/* 182 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 189 */     if (this == o) {
/* 190 */       return true;
/*     */     }
/* 192 */     if (!(o instanceof com.nanosoft.amtk.domain.Workstation)) {
/* 193 */       return false;
/*     */     }
/* 195 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.Workstation)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 201 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 208 */     return "Workstation{id=" + getId() + ", name='" + 
/* 209 */       getName() + "', description='" + 
/* 210 */       getDescription() + "', orderNumber=" + 
/* 211 */       getOrderNumber() + ", createdBy='" + 
/* 212 */       getCreatedBy() + "', createdDate='" + 
/* 213 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 214 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 215 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Workstation.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */