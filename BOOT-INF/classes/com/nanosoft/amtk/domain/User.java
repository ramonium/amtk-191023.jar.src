/*     */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*     */ import com.nanosoft.amtk.domain.AbstractAuditingEntity;
/*     */ import com.nanosoft.amtk.domain.Authority;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
/*     */ import java.util.HashSet;
/*     */ import java.util.Locale;
/*     */ import java.util.Set;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.JoinTable;
/*     */ import javax.persistence.ManyToMany;
/*     */ import javax.persistence.SequenceGenerator;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.Email;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import javax.validation.constraints.Pattern;
/*     */ import javax.validation.constraints.Size;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.hibernate.annotations.BatchSize;
/*     */ import org.hibernate.annotations.Cache;
/*     */ import org.hibernate.annotations.CacheConcurrencyStrategy;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "jhi_user")
/*     */ @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
/*     */ public class User
/*     */   extends AbstractAuditingEntity<Long>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
/*     */   @SequenceGenerator(name = "sequenceGenerator")
/*     */   private Long id;
/*     */   @NotNull
/*     */   @Pattern(regexp = "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$")
/*     */   @Size(min = 1, max = 50)
/*     */   @Column(length = 50, unique = true, nullable = false)
/*     */   private String login;
/*     */   @JsonIgnore
/*     */   @NotNull
/*     */   @Size(min = 60, max = 60)
/*     */   @Column(name = "password_hash", length = 60, nullable = false)
/*     */   private String password;
/*     */   @Size(max = 50)
/*     */   @Column(name = "first_name", length = 50)
/*     */   private String firstName;
/*     */   @Size(max = 50)
/*     */   @Column(name = "last_name", length = 50)
/*     */   private String lastName;
/*     */   @Email
/*     */   @Size(min = 5, max = 254)
/*     */   @Column(length = 254, unique = true)
/*     */   private String email;
/*     */   @NotNull
/*     */   @Column(nullable = false)
/*     */   private boolean activated = false;
/*     */   @Size(min = 2, max = 10)
/*     */   @Column(name = "lang_key", length = 10)
/*     */   private String langKey;
/*     */   @Size(max = 256)
/*     */   @Column(name = "image_url", length = 256)
/*     */   private String imageUrl;
/*     */   @Size(max = 20)
/*     */   @Column(name = "activation_key", length = 20)
/*     */   @JsonIgnore
/*     */   private String activationKey;
/*     */   @Size(max = 20)
/*     */   @Column(name = "reset_key", length = 20)
/*     */   @JsonIgnore
/*     */   private String resetKey;
/*     */   @Column(name = "reset_date")
/*  82 */   private Instant resetDate = null; @JsonIgnore @ManyToMany @JoinTable(name = "jhi_user_authority", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
/*     */   @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
/*     */   @BatchSize(size = 20)
/*  85 */   private Set<Authority> authorities = new HashSet<>();
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
/*     */   public Long getId() {
/*  97 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/* 101 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getLogin() {
/* 105 */     return this.login;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLogin(String login) {
/* 110 */     this.login = StringUtils.lowerCase(login, Locale.ENGLISH);
/*     */   }
/*     */   
/*     */   public String getPassword() {
/* 114 */     return this.password;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/* 118 */     this.password = password;
/*     */   }
/*     */   
/*     */   public String getFirstName() {
/* 122 */     return this.firstName;
/*     */   }
/*     */   
/*     */   public void setFirstName(String firstName) {
/* 126 */     this.firstName = firstName;
/*     */   }
/*     */   
/*     */   public String getLastName() {
/* 130 */     return this.lastName;
/*     */   }
/*     */   
/*     */   public void setLastName(String lastName) {
/* 134 */     this.lastName = lastName;
/*     */   }
/*     */   
/*     */   public String getEmail() {
/* 138 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/* 142 */     this.email = email;
/*     */   }
/*     */   
/*     */   public String getImageUrl() {
/* 146 */     return this.imageUrl;
/*     */   }
/*     */   
/*     */   public void setImageUrl(String imageUrl) {
/* 150 */     this.imageUrl = imageUrl;
/*     */   }
/*     */   
/*     */   public boolean isActivated() {
/* 154 */     return this.activated;
/*     */   }
/*     */   
/*     */   public void setActivated(boolean activated) {
/* 158 */     this.activated = activated;
/*     */   }
/*     */   
/*     */   public String getActivationKey() {
/* 162 */     return this.activationKey;
/*     */   }
/*     */   
/*     */   public void setActivationKey(String activationKey) {
/* 166 */     this.activationKey = activationKey;
/*     */   }
/*     */   
/*     */   public String getResetKey() {
/* 170 */     return this.resetKey;
/*     */   }
/*     */   
/*     */   public void setResetKey(String resetKey) {
/* 174 */     this.resetKey = resetKey;
/*     */   }
/*     */   
/*     */   public Instant getResetDate() {
/* 178 */     return this.resetDate;
/*     */   }
/*     */   
/*     */   public void setResetDate(Instant resetDate) {
/* 182 */     this.resetDate = resetDate;
/*     */   }
/*     */   
/*     */   public String getLangKey() {
/* 186 */     return this.langKey;
/*     */   }
/*     */   
/*     */   public void setLangKey(String langKey) {
/* 190 */     this.langKey = langKey;
/*     */   }
/*     */   
/*     */   public Set<Authority> getAuthorities() {
/* 194 */     return this.authorities;
/*     */   }
/*     */   
/*     */   public void setAuthorities(Set<Authority> authorities) {
/* 198 */     this.authorities = authorities;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 203 */     if (this == o) {
/* 204 */       return true;
/*     */     }
/* 206 */     if (!(o instanceof com.nanosoft.amtk.domain.User)) {
/* 207 */       return false;
/*     */     }
/* 209 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.domain.User)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 215 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 221 */     return "User{login='" + this.login + "', firstName='" + this.firstName + "', lastName='" + this.lastName + "', email='" + this.email + "', imageUrl='" + this.imageUrl + "', activated='" + this.activated + "', langKey='" + this.langKey + "', activationKey='" + this.activationKey + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\User.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */