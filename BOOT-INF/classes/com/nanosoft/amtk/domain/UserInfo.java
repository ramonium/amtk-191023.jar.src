/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.nanosoft.amtk.domain.Employee;
/*     */ import com.nanosoft.amtk.domain.User;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.OneToOne;
/*     */ import javax.persistence.SequenceGenerator;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.Size;
/*     */ import org.hibernate.annotations.Cache;
/*     */ import org.hibernate.annotations.CacheConcurrencyStrategy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "user_info")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class UserInfo
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
/*     */   @SequenceGenerator(name = "sequenceGenerator")
/*     */   @Column(name = "id")
/*     */   private Long id;
/*     */   @Column(name = "description")
/*     */   private String description;
/*     */   @Size(max = 50)
/*     */   @Column(name = "created_by", length = 50)
/*     */   private String createdBy;
/*     */   @Column(name = "created_date")
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   @Column(name = "last_modified_by", length = 50)
/*     */   private String lastModifiedBy;
/*     */   @Column(name = "last_modified_date")
/*     */   private Instant lastModifiedDate;
/*     */   @OneToOne
/*     */   @JoinColumn(unique = true)
/*     */   private User user;
/*     */   @JsonIgnoreProperties(value = {"attachments", "assignments", "title", "team", "managedTeams"}, allowSetters = true)
/*     */   @OneToOne
/*     */   @JoinColumn(unique = true)
/*     */   private Employee relatedEmployee;
/*     */   
/*     */   public Long getId() {
/*  57 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.UserInfo id(Long id) {
/*  61 */     setId(id);
/*  62 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  66 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  70 */     return this.description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.UserInfo description(String description) {
/*  74 */     setDescription(description);
/*  75 */     return this;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  79 */     this.description = description;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/*  83 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.UserInfo createdBy(String createdBy) {
/*  87 */     setCreatedBy(createdBy);
/*  88 */     return this;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/*  92 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/*  96 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.UserInfo createdDate(Instant createdDate) {
/* 100 */     setCreatedDate(createdDate);
/* 101 */     return this;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/* 105 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/* 109 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.UserInfo lastModifiedBy(String lastModifiedBy) {
/* 113 */     setLastModifiedBy(lastModifiedBy);
/* 114 */     return this;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/* 118 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/* 122 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.UserInfo lastModifiedDate(Instant lastModifiedDate) {
/* 126 */     setLastModifiedDate(lastModifiedDate);
/* 127 */     return this;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/* 131 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public User getUser() {
/* 135 */     return this.user;
/*     */   }
/*     */   
/*     */   public void setUser(User user) {
/* 139 */     this.user = user;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.UserInfo user(User user) {
/* 143 */     setUser(user);
/* 144 */     return this;
/*     */   }
/*     */   
/*     */   public Employee getRelatedEmployee() {
/* 148 */     return this.relatedEmployee;
/*     */   }
/*     */   
/*     */   public void setRelatedEmployee(Employee employee) {
/* 152 */     this.relatedEmployee = employee;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.UserInfo relatedEmployee(Employee employee) {
/* 156 */     setRelatedEmployee(employee);
/* 157 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 164 */     if (this == o) {
/* 165 */       return true;
/*     */     }
/* 167 */     if (!(o instanceof com.nanosoft.amtk.domain.UserInfo)) {
/* 168 */       return false;
/*     */     }
/* 170 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.UserInfo)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 176 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 183 */     return "UserInfo{id=" + getId() + ", description='" + 
/* 184 */       getDescription() + "', createdBy='" + 
/* 185 */       getCreatedBy() + "', createdDate='" + 
/* 186 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 187 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 188 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\UserInfo.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */