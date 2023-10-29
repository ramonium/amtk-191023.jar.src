/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*     */ 
/*     */ import com.nanosoft.amtk.service.dto.EmployeeTitleDTO;
/*     */ import com.nanosoft.amtk.service.dto.TeamDTO;
/*     */ import io.swagger.v3.oas.annotations.media.Schema;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import java.time.LocalDate;
/*     */ import java.util.Objects;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import javax.validation.constraints.Size;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Schema(description = "The Employee entity.")
/*     */ public class EmployeeDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   @NotNull
/*     */   private String firstName;
/*     */   @NotNull
/*     */   private String lastName;
/*     */   private String thirdName;
/*     */   private String gender;
/*     */   private String idNumber;
/*     */   private LocalDate birthday;
/*     */   private LocalDate joiningDate;
/*     */   private LocalDate relievingDate;
/*     */   @NotNull
/*     */   private String employeeNumber;
/*     */   @Size(max = 50)
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   @Size(max = 50)
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   private EmployeeTitleDTO title;
/*     */   private TeamDTO team;
/*     */   
/*     */   public Long getId() {
/*  55 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  59 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getFirstName() {
/*  63 */     return this.firstName;
/*     */   }
/*     */   
/*     */   public void setFirstName(String firstName) {
/*  67 */     this.firstName = firstName;
/*     */   }
/*     */   
/*     */   public String getLastName() {
/*  71 */     return this.lastName;
/*     */   }
/*     */   
/*     */   public void setLastName(String lastName) {
/*  75 */     this.lastName = lastName;
/*     */   }
/*     */   
/*     */   public String getThirdName() {
/*  79 */     return this.thirdName;
/*     */   }
/*     */   
/*     */   public void setThirdName(String thirdName) {
/*  83 */     this.thirdName = thirdName;
/*     */   }
/*     */   
/*     */   public String getGender() {
/*  87 */     return this.gender;
/*     */   }
/*     */   
/*     */   public void setGender(String gender) {
/*  91 */     this.gender = gender;
/*     */   }
/*     */   
/*     */   public String getIdNumber() {
/*  95 */     return this.idNumber;
/*     */   }
/*     */   
/*     */   public void setIdNumber(String idNumber) {
/*  99 */     this.idNumber = idNumber;
/*     */   }
/*     */   
/*     */   public LocalDate getBirthday() {
/* 103 */     return this.birthday;
/*     */   }
/*     */   
/*     */   public void setBirthday(LocalDate birthday) {
/* 107 */     this.birthday = birthday;
/*     */   }
/*     */   
/*     */   public LocalDate getJoiningDate() {
/* 111 */     return this.joiningDate;
/*     */   }
/*     */   
/*     */   public void setJoiningDate(LocalDate joiningDate) {
/* 115 */     this.joiningDate = joiningDate;
/*     */   }
/*     */   
/*     */   public LocalDate getRelievingDate() {
/* 119 */     return this.relievingDate;
/*     */   }
/*     */   
/*     */   public void setRelievingDate(LocalDate relievingDate) {
/* 123 */     this.relievingDate = relievingDate;
/*     */   }
/*     */   
/*     */   public String getEmployeeNumber() {
/* 127 */     return this.employeeNumber;
/*     */   }
/*     */   
/*     */   public void setEmployeeNumber(String employeeNumber) {
/* 131 */     this.employeeNumber = employeeNumber;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/* 135 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/* 139 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/* 143 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/* 147 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/* 151 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/* 155 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/* 159 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/* 163 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public EmployeeTitleDTO getTitle() {
/* 167 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(EmployeeTitleDTO title) {
/* 171 */     this.title = title;
/*     */   }
/*     */   
/*     */   public TeamDTO getTeam() {
/* 175 */     return this.team;
/*     */   }
/*     */   
/*     */   public void setTeam(TeamDTO team) {
/* 179 */     this.team = team;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 184 */     if (this == o) {
/* 185 */       return true;
/*     */     }
/* 187 */     if (!(o instanceof com.nanosoft.amtk.service.dto.EmployeeDTO)) {
/* 188 */       return false;
/*     */     }
/*     */     
/* 191 */     com.nanosoft.amtk.service.dto.EmployeeDTO employeeDTO = (com.nanosoft.amtk.service.dto.EmployeeDTO)o;
/* 192 */     if (this.id == null) {
/* 193 */       return false;
/*     */     }
/* 195 */     return Objects.equals(this.id, employeeDTO.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 200 */     return Objects.hash(new Object[] { this.id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 207 */     return "EmployeeDTO{id=" + getId() + ", firstName='" + 
/* 208 */       getFirstName() + "', lastName='" + 
/* 209 */       getLastName() + "', thirdName='" + 
/* 210 */       getThirdName() + "', gender='" + 
/* 211 */       getGender() + "', idNumber='" + 
/* 212 */       getIdNumber() + "', birthday='" + 
/* 213 */       getBirthday() + "', joiningDate='" + 
/* 214 */       getJoiningDate() + "', relievingDate='" + 
/* 215 */       getRelievingDate() + "', employeeNumber='" + 
/* 216 */       getEmployeeNumber() + "', createdBy='" + 
/* 217 */       getCreatedBy() + "', createdDate='" + 
/* 218 */       getCreatedDate() + "', lastModifiedBy='" + 
/* 219 */       getLastModifiedBy() + "', lastModifiedDate='" + 
/* 220 */       getLastModifiedDate() + "', title=" + 
/* 221 */       getTitle() + ", team=" + 
/* 222 */       getTeam() + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\EmployeeDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */