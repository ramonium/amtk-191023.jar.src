/*     */ package BOOT-INF.classes.com.nanosoft.amtk.license;
/*     */ 
/*     */ import com.nanosoft.amtk.license.LicenseTerms;
/*     */ import java.io.Serializable;
/*     */ import java.time.Instant;
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
/*     */ public class License
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String signature;
/*     */   private String licenseTermsData;
/*     */   private Instant creationDate;
/*     */   private String keyStore;
/*     */   private LicenseTerms licenseTerms;
/*     */   
/*     */   public Long getId() {
/*  34 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.License id(Long id) {
/*  38 */     setId(id);
/*  39 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  43 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getSignature() {
/*  47 */     return this.signature;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.License signature(String signature) {
/*  51 */     setSignature(signature);
/*  52 */     return this;
/*     */   }
/*     */   
/*     */   public void setSignature(String signature) {
/*  56 */     this.signature = signature;
/*     */   }
/*     */   
/*     */   public String getLicenseTermsData() {
/*  60 */     return this.licenseTermsData;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.License licenseTermsData(String licenseTermsData) {
/*  64 */     setLicenseTermsData(licenseTermsData);
/*  65 */     return this;
/*     */   }
/*     */   
/*     */   public void setLicenseTermsData(String licenseTermsData) {
/*  69 */     this.licenseTermsData = licenseTermsData;
/*     */   }
/*     */   
/*     */   public Instant getCreationDate() {
/*  73 */     return this.creationDate;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.License creationDate(Instant creationDate) {
/*  77 */     setCreationDate(creationDate);
/*  78 */     return this;
/*     */   }
/*     */   
/*     */   public void setCreationDate(Instant creationDate) {
/*  82 */     this.creationDate = creationDate;
/*     */   }
/*     */   
/*     */   public String getKeyStore() {
/*  86 */     return this.keyStore;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.License keyStore(String keyStore) {
/*  90 */     setKeyStore(keyStore);
/*  91 */     return this;
/*     */   }
/*     */   
/*     */   public void setKeyStore(String keyStore) {
/*  95 */     this.keyStore = keyStore;
/*     */   }
/*     */   
/*     */   public LicenseTerms getLicenseTerms() {
/*  99 */     return this.licenseTerms;
/*     */   }
/*     */   
/*     */   public void setLicenseTerms(LicenseTerms licenseTerms) {
/* 103 */     this.licenseTerms = licenseTerms;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.License licenseTerms(LicenseTerms licenseTerms) {
/* 107 */     setLicenseTerms(licenseTerms);
/* 108 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 115 */     if (this == o) {
/* 116 */       return true;
/*     */     }
/* 118 */     if (!(o instanceof com.nanosoft.amtk.license.License)) {
/* 119 */       return false;
/*     */     }
/* 121 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.license.License)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 127 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 134 */     return "License{id=" + getId() + ", signature='" + 
/* 135 */       getSignature() + "', licenseTermsData='" + 
/* 136 */       getLicenseTermsData() + "', creationDate='" + 
/* 137 */       getCreationDate() + "', keyStore='" + 
/* 138 */       getKeyStore() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\license\License.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */