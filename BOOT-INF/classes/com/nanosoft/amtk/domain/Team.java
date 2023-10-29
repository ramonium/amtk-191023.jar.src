/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.nanosoft.amtk.domain.AbstractAuditingEntity;
/*     */ import com.nanosoft.amtk.domain.Employee;
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
/*     */ @Table(name = "team")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class Team extends AbstractAuditingEntity implements Serializable {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
/*     */   @SequenceGenerator(name = "sequenceGenerator")
/*     */   @Column(name = "id")
/*     */   private Long id;
/*     */   @OneToMany(mappedBy = "team")
/*     */   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */   @JsonIgnoreProperties(value = {"attachments", "assignments", "title", "team", "managedTeams"}, allowSetters = true)
/*  36 */   private Set<Employee> employees = new HashSet<>();
/*     */   
/*     */   @NotNull
/*     */   @Column(name = "name", nullable = false, unique = true)
/*     */   private String name;
/*     */   @Column(name = "description")
/*     */   private String description;
/*     */   @ManyToOne
/*     */   @JsonIgnoreProperties(value = {"attachments", "assignments", "title", "team", "managedTeams"}, allowSetters = true)
/*     */   private Employee supervisor;
/*     */   
/*     */   public Long getId() {
/*  48 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Team id(Long id) {
/*  52 */     setId(id);
/*  53 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  57 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  61 */     return this.name;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Team name(String name) {
/*  65 */     setName(name);
/*  66 */     return this;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  70 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  74 */     return this.description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Team description(String description) {
/*  78 */     setDescription(description);
/*  79 */     return this;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  83 */     this.description = description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Team createdBy(String createdBy) {
/*  87 */     setCreatedBy(createdBy);
/*  88 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Team createdDate(Instant createdDate) {
/*  92 */     setCreatedDate(createdDate);
/*  93 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Team lastModifiedBy(String lastModifiedBy) {
/*  97 */     setLastModifiedBy(lastModifiedBy);
/*  98 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Team lastModifiedDate(Instant lastModifiedDate) {
/* 102 */     setLastModifiedDate(lastModifiedDate);
/* 103 */     return this;
/*     */   }
/*     */   
/*     */   public Set<Employee> getEmployees() {
/* 107 */     return this.employees;
/*     */   }
/*     */   
/*     */   public void setEmployees(Set<Employee> employees) {
/* 111 */     if (this.employees != null) {
/* 112 */       this.employees.forEach(i -> i.setTeam(null));
/*     */     }
/* 114 */     if (employees != null) {
/* 115 */       employees.forEach(i -> i.setTeam(this));
/*     */     }
/* 117 */     this.employees = employees;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Team employees(Set<Employee> employees) {
/* 121 */     setEmployees(employees);
/* 122 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Team addEmployee(Employee employee) {
/* 126 */     this.employees.add(employee);
/* 127 */     employee.setTeam(this);
/* 128 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Team removeEmployee(Employee employee) {
/* 132 */     this.employees.remove(employee);
/* 133 */     employee.setTeam(null);
/* 134 */     return this;
/*     */   }
/*     */   
/*     */   public Employee getSupervisor() {
/* 138 */     return this.supervisor;
/*     */   }
/*     */   
/*     */   public void setSupervisor(Employee employee) {
/* 142 */     this.supervisor = employee;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Team supervisor(Employee employee) {
/* 146 */     setSupervisor(employee);
/* 147 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 154 */     if (this == o) {
/* 155 */       return true;
/*     */     }
/* 157 */     if (!(o instanceof com.nanosoft.amtk.domain.Team)) {
/* 158 */       return false;
/*     */     }
/* 160 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.Team)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 166 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 173 */     return "Team{id=" + getId() + ", name='" + 
/* 174 */       getName() + "', description='" + 
/* 175 */       getDescription() + "', createdBy='" + 
/* 176 */       getCreatedBy() + "', createdDate='" + 
/* 177 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 178 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 179 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Team.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */