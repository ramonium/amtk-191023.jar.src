/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.nanosoft.amtk.domain.AbstractAuditingEntity;
/*     */ import com.nanosoft.amtk.domain.Assignment;
/*     */ import com.nanosoft.amtk.domain.Attachment;
/*     */ import com.nanosoft.amtk.domain.EmployeeTitle;
/*     */ import com.nanosoft.amtk.domain.Team;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import java.time.LocalDate;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "employee")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class Employee
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
/*     */   @Column(name = "first_name", nullable = false)
/*     */   private String firstName;
/*     */   @NotNull
/*     */   @Column(name = "last_name", nullable = false)
/*     */   private String lastName;
/*     */   @Column(name = "third_name")
/*     */   private String thirdName;
/*     */   @OneToMany(mappedBy = "employee")
/*     */   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */   @JsonIgnoreProperties(value = {"content", "employee"}, allowSetters = true)
/*  60 */   private Set<Attachment> attachments = new HashSet<>(); @Column(name = "gender") private String gender; @Column(name = "id_number") private String idNumber; @Column(name = "birthday") private LocalDate birthday; @Column(name = "joining_date") private LocalDate joiningDate; @Column(name = "relieving_date") private LocalDate relievingDate; @NotNull
/*     */   @Column(name = "employee_number", nullable = false)
/*     */   private String employeeNumber; @OneToMany(mappedBy = "employee")
/*     */   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */   @JsonIgnoreProperties(value = {"certificates", "workstation", "employee", "currentCertificate"}, allowSetters = true)
/*  65 */   private Set<Assignment> assignments = new HashSet<>();
/*     */   
/*     */   @ManyToOne(optional = false)
/*     */   @NotNull
/*     */   @JsonIgnoreProperties(value = {"employees"}, allowSetters = true)
/*     */   private EmployeeTitle title;
/*     */   
/*     */   @ManyToOne
/*     */   @JsonIgnoreProperties(value = {"employees", "supervisor"}, allowSetters = true)
/*     */   private Team team;
/*     */   
/*     */   @OneToMany(mappedBy = "supervisor")
/*     */   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */   @JsonIgnoreProperties(value = {"employees", "supervisor"}, allowSetters = true)
/*  79 */   private Set<Team> managedTeams = new HashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getId() {
/*  87 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee id(Long id) {
/*  91 */     setId(id);
/*  92 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  96 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getFirstName() {
/* 100 */     return this.firstName;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee firstName(String firstName) {
/* 104 */     setFirstName(firstName);
/* 105 */     return this;
/*     */   }
/*     */   
/*     */   public void setFirstName(String firstName) {
/* 109 */     this.firstName = firstName;
/*     */   }
/*     */   
/*     */   public String getLastName() {
/* 113 */     return this.lastName;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee lastName(String lastName) {
/* 117 */     setLastName(lastName);
/* 118 */     return this;
/*     */   }
/*     */   
/*     */   public void setLastName(String lastName) {
/* 122 */     this.lastName = lastName;
/*     */   }
/*     */   
/*     */   public String getThirdName() {
/* 126 */     return this.thirdName;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee thirdName(String thirdName) {
/* 130 */     setThirdName(thirdName);
/* 131 */     return this;
/*     */   }
/*     */   
/*     */   public void setThirdName(String thirdName) {
/* 135 */     this.thirdName = thirdName;
/*     */   }
/*     */   
/*     */   public String getGender() {
/* 139 */     return this.gender;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee gender(String gender) {
/* 143 */     setGender(gender);
/* 144 */     return this;
/*     */   }
/*     */   
/*     */   public void setGender(String gender) {
/* 148 */     this.gender = gender;
/*     */   }
/*     */   
/*     */   public String getIdNumber() {
/* 152 */     return this.idNumber;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee idNumber(String idNumber) {
/* 156 */     setIdNumber(idNumber);
/* 157 */     return this;
/*     */   }
/*     */   
/*     */   public void setIdNumber(String idNumber) {
/* 161 */     this.idNumber = idNumber;
/*     */   }
/*     */   
/*     */   public LocalDate getBirthday() {
/* 165 */     return this.birthday;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee birthday(LocalDate birthday) {
/* 169 */     setBirthday(birthday);
/* 170 */     return this;
/*     */   }
/*     */   
/*     */   public void setBirthday(LocalDate birthday) {
/* 174 */     this.birthday = birthday;
/*     */   }
/*     */   
/*     */   public LocalDate getJoiningDate() {
/* 178 */     return this.joiningDate;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee joiningDate(LocalDate joiningDate) {
/* 182 */     setJoiningDate(joiningDate);
/* 183 */     return this;
/*     */   }
/*     */   
/*     */   public void setJoiningDate(LocalDate joiningDate) {
/* 187 */     this.joiningDate = joiningDate;
/*     */   }
/*     */   
/*     */   public LocalDate getRelievingDate() {
/* 191 */     return this.relievingDate;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee relievingDate(LocalDate relievingDate) {
/* 195 */     setRelievingDate(relievingDate);
/* 196 */     return this;
/*     */   }
/*     */   
/*     */   public void setRelievingDate(LocalDate relievingDate) {
/* 200 */     this.relievingDate = relievingDate;
/*     */   }
/*     */   
/*     */   public String getEmployeeNumber() {
/* 204 */     return this.employeeNumber;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee employeeNumber(String employeeNumber) {
/* 208 */     setEmployeeNumber(employeeNumber);
/* 209 */     return this;
/*     */   }
/*     */   
/*     */   public void setEmployeeNumber(String employeeNumber) {
/* 213 */     this.employeeNumber = employeeNumber;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee createdBy(String createdBy) {
/* 217 */     setCreatedBy(createdBy);
/* 218 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee createdDate(Instant createdDate) {
/* 222 */     setCreatedDate(createdDate);
/* 223 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee lastModifiedBy(String lastModifiedBy) {
/* 227 */     setLastModifiedBy(lastModifiedBy);
/* 228 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee lastModifiedDate(Instant lastModifiedDate) {
/* 232 */     setLastModifiedDate(lastModifiedDate);
/* 233 */     return this;
/*     */   }
/*     */   
/*     */   public Set<Attachment> getAttachments() {
/* 237 */     return this.attachments;
/*     */   }
/*     */   
/*     */   public void setAttachments(Set<Attachment> attachments) {
/* 241 */     if (this.attachments != null) {
/* 242 */       this.attachments.forEach(i -> i.setEmployee(null));
/*     */     }
/* 244 */     if (attachments != null) {
/* 245 */       attachments.forEach(i -> i.setEmployee(this));
/*     */     }
/* 247 */     this.attachments = attachments;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee attachments(Set<Attachment> attachments) {
/* 251 */     setAttachments(attachments);
/* 252 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee addAttachment(Attachment attachment) {
/* 256 */     this.attachments.add(attachment);
/* 257 */     attachment.setEmployee(this);
/* 258 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee removeAttachment(Attachment attachment) {
/* 262 */     this.attachments.remove(attachment);
/* 263 */     attachment.setEmployee(null);
/* 264 */     return this;
/*     */   }
/*     */   
/*     */   public Set<Assignment> getAssignments() {
/* 268 */     return this.assignments;
/*     */   }
/*     */   
/*     */   public void setAssignments(Set<Assignment> assignments) {
/* 272 */     if (this.assignments != null) {
/* 273 */       this.assignments.forEach(i -> i.setEmployee(null));
/*     */     }
/* 275 */     if (assignments != null) {
/* 276 */       assignments.forEach(i -> i.setEmployee(this));
/*     */     }
/* 278 */     this.assignments = assignments;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee assignments(Set<Assignment> assignments) {
/* 282 */     setAssignments(assignments);
/* 283 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee addAssignment(Assignment assignment) {
/* 287 */     this.assignments.add(assignment);
/* 288 */     assignment.setEmployee(this);
/* 289 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee removeAssignment(Assignment assignment) {
/* 293 */     this.assignments.remove(assignment);
/* 294 */     assignment.setEmployee(null);
/* 295 */     return this;
/*     */   }
/*     */   
/*     */   public EmployeeTitle getTitle() {
/* 299 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(EmployeeTitle employeeTitle) {
/* 303 */     this.title = employeeTitle;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee title(EmployeeTitle employeeTitle) {
/* 307 */     setTitle(employeeTitle);
/* 308 */     return this;
/*     */   }
/*     */   
/*     */   public Team getTeam() {
/* 312 */     return this.team;
/*     */   }
/*     */   
/*     */   public void setTeam(Team team) {
/* 316 */     this.team = team;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee team(Team team) {
/* 320 */     setTeam(team);
/* 321 */     return this;
/*     */   }
/*     */   
/*     */   public Set<Team> getManagedTeams() {
/* 325 */     return this.managedTeams;
/*     */   }
/*     */   
/*     */   public void setManagedTeams(Set<Team> teams) {
/* 329 */     if (this.managedTeams != null) {
/* 330 */       this.managedTeams.forEach(i -> i.setSupervisor(null));
/*     */     }
/* 332 */     if (teams != null) {
/* 333 */       teams.forEach(i -> i.setSupervisor(this));
/*     */     }
/* 335 */     this.managedTeams = teams;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee managedTeams(Set<Team> teams) {
/* 339 */     setManagedTeams(teams);
/* 340 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee addManagedTeam(Team team) {
/* 344 */     this.managedTeams.add(team);
/* 345 */     team.setSupervisor(this);
/* 346 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Employee removeManagedTeam(Team team) {
/* 350 */     this.managedTeams.remove(team);
/* 351 */     team.setSupervisor(null);
/* 352 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 359 */     if (this == o) {
/* 360 */       return true;
/*     */     }
/* 362 */     if (!(o instanceof com.nanosoft.amtk.domain.Employee)) {
/* 363 */       return false;
/*     */     }
/* 365 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.Employee)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 371 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 378 */     return "Employee{id=" + getId() + ", firstName='" + 
/* 379 */       getFirstName() + "', lastName='" + 
/* 380 */       getLastName() + "', thirdName='" + 
/* 381 */       getThirdName() + "', gender='" + 
/* 382 */       getGender() + "', idNumber='" + 
/* 383 */       getIdNumber() + "', birthday='" + 
/* 384 */       getBirthday() + "', joiningDate='" + 
/* 385 */       getJoiningDate() + "', relievingDate='" + 
/* 386 */       getRelievingDate() + "', employeeNumber='" + 
/* 387 */       getEmployeeNumber() + "', createdBy='" + 
/* 388 */       getCreatedBy() + "', createdDate='" + 
/* 389 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 390 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 391 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Employee.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */