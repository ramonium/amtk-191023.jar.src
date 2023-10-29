/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.dto;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Authority;
/*     */ import com.nanosoft.amtk.domain.User;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.validation.constraints.Email;
/*     */ import javax.validation.constraints.NotBlank;
/*     */ import javax.validation.constraints.Pattern;
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
/*     */ public class AdminUserDTO
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   @NotBlank
/*     */   @Pattern(regexp = "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$")
/*     */   @Size(min = 1, max = 50)
/*     */   private String login;
/*     */   @Size(max = 50)
/*     */   private String firstName;
/*     */   @Size(max = 50)
/*     */   private String lastName;
/*     */   @Email
/*     */   @Size(min = 5, max = 254)
/*     */   private String email;
/*     */   @Size(max = 256)
/*     */   private String imageUrl;
/*     */   private boolean activated = false;
/*     */   @Size(min = 2, max = 10)
/*     */   private String langKey;
/*     */   private String createdBy;
/*     */   private Instant createdDate;
/*     */   private String lastModifiedBy;
/*     */   private Instant lastModifiedDate;
/*     */   private Set<String> authorities;
/*     */   
/*     */   public AdminUserDTO() {}
/*     */   
/*     */   public AdminUserDTO(User user) {
/*  59 */     this.id = user.getId();
/*  60 */     this.login = user.getLogin();
/*  61 */     this.firstName = user.getFirstName();
/*  62 */     this.lastName = user.getLastName();
/*  63 */     this.email = user.getEmail();
/*  64 */     this.activated = user.isActivated();
/*  65 */     this.imageUrl = user.getImageUrl();
/*  66 */     this.langKey = user.getLangKey();
/*  67 */     this.createdBy = user.getCreatedBy();
/*  68 */     this.createdDate = user.getCreatedDate();
/*  69 */     this.lastModifiedBy = user.getLastModifiedBy();
/*  70 */     this.lastModifiedDate = user.getLastModifiedDate();
/*  71 */     this.authorities = (Set<String>)user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet());
/*     */   }
/*     */   
/*     */   public Long getId() {
/*  75 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  79 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getLogin() {
/*  83 */     return this.login;
/*     */   }
/*     */   
/*     */   public void setLogin(String login) {
/*  87 */     this.login = login;
/*     */   }
/*     */   
/*     */   public String getFirstName() {
/*  91 */     return this.firstName;
/*     */   }
/*     */   
/*     */   public void setFirstName(String firstName) {
/*  95 */     this.firstName = firstName;
/*     */   }
/*     */   
/*     */   public String getLastName() {
/*  99 */     return this.lastName;
/*     */   }
/*     */   
/*     */   public void setLastName(String lastName) {
/* 103 */     this.lastName = lastName;
/*     */   }
/*     */   
/*     */   public String getEmail() {
/* 107 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/* 111 */     this.email = email;
/*     */   }
/*     */   
/*     */   public String getImageUrl() {
/* 115 */     return this.imageUrl;
/*     */   }
/*     */   
/*     */   public void setImageUrl(String imageUrl) {
/* 119 */     this.imageUrl = imageUrl;
/*     */   }
/*     */   
/*     */   public boolean isActivated() {
/* 123 */     return this.activated;
/*     */   }
/*     */   
/*     */   public void setActivated(boolean activated) {
/* 127 */     this.activated = activated;
/*     */   }
/*     */   
/*     */   public String getLangKey() {
/* 131 */     return this.langKey;
/*     */   }
/*     */   
/*     */   public void setLangKey(String langKey) {
/* 135 */     this.langKey = langKey;
/*     */   }
/*     */   
/*     */   public String getCreatedBy() {
/* 139 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/* 143 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   public Instant getCreatedDate() {
/* 147 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Instant createdDate) {
/* 151 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/* 155 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String lastModifiedBy) {
/* 159 */     this.lastModifiedBy = lastModifiedBy;
/*     */   }
/*     */   
/*     */   public Instant getLastModifiedDate() {
/* 163 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(Instant lastModifiedDate) {
/* 167 */     this.lastModifiedDate = lastModifiedDate;
/*     */   }
/*     */   
/*     */   public Set<String> getAuthorities() {
/* 171 */     return this.authorities;
/*     */   }
/*     */   
/*     */   public void setAuthorities(Set<String> authorities) {
/* 175 */     this.authorities = authorities;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 181 */     return "AdminUserDTO{login='" + this.login + "', firstName='" + this.firstName + "', lastName='" + this.lastName + "', email='" + this.email + "', imageUrl='" + this.imageUrl + "', activated=" + this.activated + ", langKey='" + this.langKey + "', createdBy=" + this.createdBy + ", createdDate=" + this.createdDate + ", lastModifiedBy='" + this.lastModifiedBy + "', lastModifiedDate=" + this.lastModifiedDate + ", authorities=" + this.authorities + "}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\dto\AdminUserDTO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */