/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.nanosoft.amtk.domain.AbstractAuditingEntity;
/*     */ import com.nanosoft.amtk.domain.Area;
/*     */ import com.nanosoft.amtk.domain.SkillsMatrix;
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
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.OneToOne;
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
/*     */ @Table(name = "project")
/*     */ @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */ public class Project
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
/*     */   @Column(name = "name", nullable = false)
/*     */   private String name;
/*     */   @Column(name = "customer")
/*     */   private String customer;
/*     */   @OneToMany(mappedBy = "project")
/*     */   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */   @JsonIgnoreProperties(value = {"workstations", "project"}, allowSetters = true)
/*  53 */   private Set<Area> areas = new HashSet<>(); @NotNull @Column(name = "safety", nullable = false) private Boolean safety; @Pattern(regexp = "([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?") @Column(name = "qualification_after") private String qualificationAfter; @Pattern(regexp = "([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?") @Column(name = "decertify_after")
/*     */   private String decertifyAfter; @Column(name = "description")
/*     */   private String description; @OneToMany(mappedBy = "project")
/*     */   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/*     */   @JsonIgnoreProperties(value = {"project", "forProject"}, allowSetters = true)
/*  58 */   private Set<SkillsMatrix> skillsMatrixHistories = new HashSet<>();
/*     */ 
/*     */ 
/*     */   
/*     */   @JsonIgnoreProperties(value = {"project", "forProject"}, allowSetters = true)
/*     */   @OneToOne
/*     */   @JoinColumn(unique = true)
/*     */   private SkillsMatrix skillsMatrix;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getId() {
/*  71 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project id(Long id) {
/*  75 */     setId(id);
/*  76 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  80 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  84 */     return this.name;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project name(String name) {
/*  88 */     setName(name);
/*  89 */     return this;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  93 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getCustomer() {
/*  97 */     return this.customer;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project customer(String customer) {
/* 101 */     setCustomer(customer);
/* 102 */     return this;
/*     */   }
/*     */   
/*     */   public void setCustomer(String customer) {
/* 106 */     this.customer = customer;
/*     */   }
/*     */   
/*     */   public Boolean getSafety() {
/* 110 */     return this.safety;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project safety(Boolean safety) {
/* 114 */     setSafety(safety);
/* 115 */     return this;
/*     */   }
/*     */   
/*     */   public void setSafety(Boolean safety) {
/* 119 */     this.safety = safety;
/*     */   }
/*     */   
/*     */   public String getQualificationAfter() {
/* 123 */     return this.qualificationAfter;
/*     */   }
/*     */   
/*     */   @JsonIgnore
/*     */   public Period getQualificationAfterAsPeriod() {
/* 128 */     return Period.parse(this.qualificationAfter);
/*     */   }
/*     */   
/*     */   @JsonIgnore
/*     */   public void setQualificationAfterAsPeriod(Period qualificationAfter) {
/* 133 */     this.qualificationAfter = qualificationAfter.toString();
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project qualificationAfter(String qualificationAfter) {
/* 137 */     setQualificationAfter(qualificationAfter);
/* 138 */     return this;
/*     */   }
/*     */   
/*     */   public void setQualificationAfter(String qualificationAfter) {
/* 142 */     this.qualificationAfter = qualificationAfter;
/*     */   }
/*     */   
/*     */   public String getDecertifyAfter() {
/* 146 */     return this.decertifyAfter;
/*     */   }
/*     */   
/*     */   public Period getDecertifyAfterAsPeriod() {
/* 150 */     return Period.parse(this.decertifyAfter);
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project decertifyAfter(String decertifyAfter) {
/* 154 */     setDecertifyAfter(decertifyAfter);
/* 155 */     return this;
/*     */   }
/*     */   
/*     */   public void setDecertifyAfter(String decertifyAfter) {
/* 159 */     this.decertifyAfter = decertifyAfter;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 163 */     return this.description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project description(String description) {
/* 167 */     setDescription(description);
/* 168 */     return this;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 172 */     this.description = description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project createdBy(String createdBy) {
/* 176 */     setCreatedBy(createdBy);
/* 177 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project createdDate(Instant createdDate) {
/* 181 */     setCreatedDate(createdDate);
/* 182 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project lastModifiedBy(String lastModifiedBy) {
/* 186 */     setLastModifiedBy(lastModifiedBy);
/* 187 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project lastModifiedDate(Instant lastModifiedDate) {
/* 191 */     setLastModifiedDate(lastModifiedDate);
/* 192 */     return this;
/*     */   }
/*     */   
/*     */   public Set<Area> getAreas() {
/* 196 */     return this.areas;
/*     */   }
/*     */   
/*     */   public void setAreas(Set<Area> areas) {
/* 200 */     if (this.areas != null) {
/* 201 */       this.areas.forEach(i -> i.setProject(null));
/*     */     }
/* 203 */     if (areas != null) {
/* 204 */       areas.forEach(i -> i.setProject(this));
/*     */     }
/* 206 */     this.areas = areas;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project areas(Set<Area> areas) {
/* 210 */     setAreas(areas);
/* 211 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project addArea(Area area) {
/* 215 */     this.areas.add(area);
/* 216 */     area.setProject(this);
/* 217 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project removeArea(Area area) {
/* 221 */     this.areas.remove(area);
/* 222 */     area.setProject(null);
/* 223 */     return this;
/*     */   }
/*     */   
/*     */   public Set<SkillsMatrix> getSkillsMatrixHistories() {
/* 227 */     return this.skillsMatrixHistories;
/*     */   }
/*     */   
/*     */   public void setSkillsMatrixHistories(Set<SkillsMatrix> skillsMatrices) {
/* 231 */     if (this.skillsMatrixHistories != null) {
/* 232 */       this.skillsMatrixHistories.forEach(i -> i.setProject(null));
/*     */     }
/* 234 */     if (skillsMatrices != null) {
/* 235 */       skillsMatrices.forEach(i -> i.setProject(this));
/*     */     }
/* 237 */     this.skillsMatrixHistories = skillsMatrices;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project skillsMatrixHistories(Set<SkillsMatrix> skillsMatrices) {
/* 241 */     setSkillsMatrixHistories(skillsMatrices);
/* 242 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project addSkillsMatrixHistory(SkillsMatrix skillsMatrix) {
/* 246 */     this.skillsMatrixHistories.add(skillsMatrix);
/* 247 */     skillsMatrix.setProject(this);
/* 248 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project removeSkillsMatrixHistory(SkillsMatrix skillsMatrix) {
/* 252 */     this.skillsMatrixHistories.remove(skillsMatrix);
/* 253 */     skillsMatrix.setProject(null);
/* 254 */     return this;
/*     */   }
/*     */   
/*     */   public SkillsMatrix getSkillsMatrix() {
/* 258 */     return this.skillsMatrix;
/*     */   }
/*     */   
/*     */   public void setSkillsMatrix(SkillsMatrix skillsMatrix) {
/* 262 */     this.skillsMatrix = skillsMatrix;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.domain.Project skillsMatrix(SkillsMatrix skillsMatrix) {
/* 266 */     setSkillsMatrix(skillsMatrix);
/* 267 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 274 */     if (this == o) {
/* 275 */       return true;
/*     */     }
/* 277 */     if (!(o instanceof com.nanosoft.amtk.domain.Project)) {
/* 278 */       return false;
/*     */     }
/* 280 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.Project)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 286 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 293 */     return "Project{id=" + getId() + ", name='" + 
/* 294 */       getName() + "', customer='" + 
/* 295 */       getCustomer() + "', safety='" + 
/* 296 */       getSafety() + "', qualificationAfter='" + 
/* 297 */       getQualificationAfter() + "', decertifyAfter='" + 
/* 298 */       getDecertifyAfter() + "', description='" + 
/* 299 */       getDescription() + "', createdBy='" + 
/* 300 */       getCreatedBy() + "', createdDate='" + 
/* 301 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 302 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 303 */       getLastModifiedDate() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Project.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */