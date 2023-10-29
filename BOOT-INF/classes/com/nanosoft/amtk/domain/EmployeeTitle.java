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
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.SequenceGenerator;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import org.hibernate.annotations.Cache;
/*     */ import org.hibernate.annotations.CacheConcurrencyStrategy;
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "employee_title")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class EmployeeTitle
/*     */   extends AbstractAuditingEntity
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
/*     */   @SequenceGenerator(name = "sequenceGenerator")
/*     */   @Column(name = "id")
/*     */   private Long id;
/*     */   @OneToMany(mappedBy = "title")
/*     */   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */   @JsonIgnoreProperties(value = {"attachments", "assignments", "title", "team", "managedTeams"}, allowSetters = true)
/*  39 */   private Set<Employee> employees = new HashSet<>();
/*     */   
/*     */   @NotNull
/*     */   @Column(name = "name", nullable = false, unique = true)
/*     */   private String name;
/*     */ 
/*     */   
/*     */   public Long getId() {
/*  47 */     return this.id;
/*     */   } @Column(name = "description")
/*     */   private String description; @Column(name = "can_supervise")
/*     */   private Boolean canSupervise; public com.nanosoft.amtk.domain.EmployeeTitle id(Long id) {
/*  51 */     setId(id);
/*  52 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  56 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  60 */     return this.name;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.EmployeeTitle name(String name) {
/*  64 */     setName(name);
/*  65 */     return this;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  69 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  73 */     return this.description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.EmployeeTitle description(String description) {
/*  77 */     setDescription(description);
/*  78 */     return this;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  82 */     this.description = description;
/*     */   }
/*     */   
/*     */   public Boolean getCanSupervise() {
/*  86 */     return this.canSupervise;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.EmployeeTitle canSupervise(Boolean canSupervise) {
/*  90 */     setCanSupervise(canSupervise);
/*  91 */     return this;
/*     */   }
/*     */   
/*     */   public void setCanSupervise(Boolean canSupervise) {
/*  95 */     this.canSupervise = canSupervise;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.EmployeeTitle createdBy(String createdBy) {
/*  99 */     setCreatedBy(createdBy);
/* 100 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.EmployeeTitle createdDate(Instant createdDate) {
/* 104 */     setCreatedDate(createdDate);
/* 105 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.EmployeeTitle lastModifiedBy(String lastModifiedBy) {
/* 109 */     setLastModifiedBy(lastModifiedBy);
/* 110 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.EmployeeTitle lastModifiedDate(Instant lastModifiedDate) {
/* 114 */     setLastModifiedDate(lastModifiedDate);
/* 115 */     return this;
/*     */   }
/*     */   
/*     */   public Set<Employee> getEmployees() {
/* 119 */     return this.employees;
/*     */   }
/*     */   
/*     */   public void setEmployees(Set<Employee> employees) {
/* 123 */     if (this.employees != null) {
/* 124 */       this.employees.forEach(i -> i.setTitle(null));
/*     */     }
/* 126 */     if (employees != null) {
/* 127 */       employees.forEach(i -> i.setTitle(this));
/*     */     }
/* 129 */     this.employees = employees;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.EmployeeTitle employees(Set<Employee> employees) {
/* 133 */     setEmployees(employees);
/* 134 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.EmployeeTitle addEmployee(Employee employee) {
/* 138 */     this.employees.add(employee);
/* 139 */     employee.setTitle(this);
/* 140 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.EmployeeTitle removeEmployee(Employee employee) {
/* 144 */     this.employees.remove(employee);
/* 145 */     employee.setTitle(null);
/* 146 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 153 */     if (this == o) {
/* 154 */       return true;
/*     */     }
/* 156 */     if (!(o instanceof com.nanosoft.amtk.domain.EmployeeTitle)) {
/* 157 */       return false;
/*     */     }
/* 159 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.EmployeeTitle)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 165 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 172 */     return "EmployeeTitle{id=" + getId() + ", name='" + 
/* 173 */       getName() + "', description='" + 
/* 174 */       getDescription() + "', canSupervise='" + 
/* 175 */       getCanSupervise() + "', createdBy='" + 
/* 176 */       getCreatedBy() + "', createdDate='" + 
/* 177 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 178 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 179 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\EmployeeTitle.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */