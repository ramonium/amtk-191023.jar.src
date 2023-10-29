/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.nanosoft.amtk.domain.AbstractAuditingEntity;
/*     */ import com.nanosoft.amtk.domain.Project;
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
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.SequenceGenerator;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import org.hibernate.annotations.Cache;
/*     */ import org.hibernate.annotations.CacheConcurrencyStrategy;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "area")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class Area
/*     */   extends AbstractAuditingEntity
/*     */   implements Serializable {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
/*     */   @SequenceGenerator(name = "sequenceGenerator")
/*     */   @Column(name = "id")
/*     */   private Long id;
/*     */   @OneToMany(mappedBy = "area")
/*     */   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */   @JsonIgnoreProperties(value = {"assignments", "area", "process"}, allowSetters = true)
/*  39 */   private Set<Workstation> workstations = new HashSet<>();
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   @Column(name = "name", nullable = false)
/*     */   private String name;
/*     */ 
/*     */   
/*     */   @Column(name = "description")
/*     */   private String description;
/*     */ 
/*     */   
/*     */   public Long getId() {
/*  52 */     return this.id; } @Column(name = "order_number")
/*     */   private Integer orderNumber; @ManyToOne(optional = false)
/*     */   @NotNull
/*     */   @JsonIgnoreProperties(value = {"areas", "skillsMatrixHistories", "skillsMatrix"}, allowSetters = true)
/*  56 */   private Project project; public com.nanosoft.amtk.domain.Area id(Long id) { setId(id);
/*  57 */     return this; }
/*     */ 
/*     */   
/*     */   public void setId(Long id) {
/*  61 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  65 */     return this.name;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Area name(String name) {
/*  69 */     setName(name);
/*  70 */     return this;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  74 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  78 */     return this.description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Area description(String description) {
/*  82 */     setDescription(description);
/*  83 */     return this;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  87 */     this.description = description;
/*     */   }
/*     */   
/*     */   public Integer getOrderNumber() {
/*  91 */     return this.orderNumber;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Area orderNumber(Integer orderNumber) {
/*  95 */     setOrderNumber(orderNumber);
/*  96 */     return this;
/*     */   }
/*     */   
/*     */   public void setOrderNumber(Integer orderNumber) {
/* 100 */     this.orderNumber = orderNumber;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Area createdBy(String createdBy) {
/* 104 */     setCreatedBy(createdBy);
/* 105 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Area createdDate(Instant createdDate) {
/* 109 */     setCreatedDate(createdDate);
/* 110 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Area lastModifiedBy(String lastModifiedBy) {
/* 114 */     setLastModifiedBy(lastModifiedBy);
/* 115 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Area lastModifiedDate(Instant lastModifiedDate) {
/* 119 */     setLastModifiedDate(lastModifiedDate);
/* 120 */     return this;
/*     */   }
/*     */   
/*     */   public Set<Workstation> getWorkstations() {
/* 124 */     return this.workstations;
/*     */   }
/*     */   
/*     */   public void setWorkstations(Set<Workstation> workstations) {
/* 128 */     if (this.workstations != null) {
/* 129 */       this.workstations.forEach(i -> i.setArea(null));
/*     */     }
/* 131 */     if (workstations != null) {
/* 132 */       workstations.forEach(i -> i.setArea(this));
/*     */     }
/* 134 */     this.workstations = workstations;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Area workstations(Set<Workstation> workstations) {
/* 138 */     setWorkstations(workstations);
/* 139 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Area addWorkstation(Workstation workstation) {
/* 143 */     this.workstations.add(workstation);
/* 144 */     workstation.setArea(this);
/* 145 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Area removeWorkstation(Workstation workstation) {
/* 149 */     this.workstations.remove(workstation);
/* 150 */     workstation.setArea(null);
/* 151 */     return this;
/*     */   }
/*     */   
/*     */   public Project getProject() {
/* 155 */     return this.project;
/*     */   }
/*     */   
/*     */   public void setProject(Project project) {
/* 159 */     this.project = project;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Area project(Project project) {
/* 163 */     setProject(project);
/* 164 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 171 */     if (this == o) {
/* 172 */       return true;
/*     */     }
/* 174 */     if (!(o instanceof com.nanosoft.amtk.domain.Area)) {
/* 175 */       return false;
/*     */     }
/* 177 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.Area)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 183 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 190 */     return "Area{id=" + getId() + ", name='" + 
/* 191 */       getName() + "', description='" + 
/* 192 */       getDescription() + "', orderNumber=" + 
/* 193 */       getOrderNumber() + ", createdBy='" + 
/* 194 */       getCreatedBy() + "', createdDate='" + 
/* 195 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 196 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 197 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Area.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */