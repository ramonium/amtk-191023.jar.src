/*     */ package BOOT-INF.classes.com.nanosoft.amtk.license;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*     */ import com.nanosoft.amtk.license.Application;
/*     */ import com.nanosoft.amtk.license.Feature;
/*     */ import com.nanosoft.amtk.license.License;
/*     */ import java.io.Serializable;
/*     */ import java.time.LocalDate;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
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
/*     */ public class LicenseTerms
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private LocalDate startDate;
/*     */   private LocalDate endDate;
/*     */   private String customer;
/*     */   private String deviceId;
/*  30 */   private Set<Feature> features = new HashSet<>();
/*     */   @JsonIgnore
/*  32 */   private Set<License> licenses = new HashSet<>();
/*     */ 
/*     */   
/*     */   private Application application;
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getId() {
/*  40 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.LicenseTerms id(Long id) {
/*  44 */     setId(id);
/*  45 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  49 */     this.id = id;
/*     */   }
/*     */   
/*     */   public LocalDate getStartDate() {
/*  53 */     return this.startDate;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.LicenseTerms startDate(LocalDate startDate) {
/*  57 */     setStartDate(startDate);
/*  58 */     return this;
/*     */   }
/*     */   
/*     */   public void setStartDate(LocalDate startDate) {
/*  62 */     this.startDate = startDate;
/*     */   }
/*     */   
/*     */   public LocalDate getEndDate() {
/*  66 */     return this.endDate;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.LicenseTerms endDate(LocalDate endDate) {
/*  70 */     setEndDate(endDate);
/*  71 */     return this;
/*     */   }
/*     */   
/*     */   public void setEndDate(LocalDate endDate) {
/*  75 */     this.endDate = endDate;
/*     */   }
/*     */   
/*     */   public String getCustomer() {
/*  79 */     return this.customer;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.LicenseTerms customer(String customer) {
/*  83 */     setCustomer(customer);
/*  84 */     return this;
/*     */   }
/*     */   
/*     */   public void setCustomer(String customer) {
/*  88 */     this.customer = customer;
/*     */   }
/*     */   
/*     */   public String getDeviceId() {
/*  92 */     return this.deviceId;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.LicenseTerms deviceId(String deviceId) {
/*  96 */     setDeviceId(deviceId);
/*  97 */     return this;
/*     */   }
/*     */   
/*     */   public void setDeviceId(String deviceId) {
/* 101 */     this.deviceId = deviceId;
/*     */   }
/*     */   
/*     */   public Set<Feature> getFeatures() {
/* 105 */     return this.features;
/*     */   }
/*     */   
/*     */   public void setFeatures(Set<Feature> features) {
/* 109 */     this.features = features;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.LicenseTerms features(Set<Feature> features) {
/* 113 */     setFeatures(features);
/* 114 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.LicenseTerms addFeature(Feature feature) {
/* 118 */     this.features.add(feature);
/* 119 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.LicenseTerms removeFeature(Feature feature) {
/* 123 */     this.features.remove(feature);
/* 124 */     return this;
/*     */   }
/*     */   
/*     */   public Set<License> getLicenses() {
/* 128 */     return this.licenses;
/*     */   }
/*     */   
/*     */   public void setLicenses(Set<License> licenses) {
/* 132 */     if (this.licenses != null) {
/* 133 */       this.licenses.forEach(i -> i.setLicenseTerms(null));
/*     */     }
/* 135 */     if (licenses != null) {
/* 136 */       licenses.forEach(i -> i.setLicenseTerms(this));
/*     */     }
/* 138 */     this.licenses = licenses;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.LicenseTerms licenses(Set<License> licenses) {
/* 142 */     setLicenses(licenses);
/* 143 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.LicenseTerms addLicense(License license) {
/* 147 */     this.licenses.add(license);
/* 148 */     license.setLicenseTerms(this);
/* 149 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.LicenseTerms removeLicense(License license) {
/* 153 */     this.licenses.remove(license);
/* 154 */     license.setLicenseTerms(null);
/* 155 */     return this;
/*     */   }
/*     */   
/*     */   public Application getApplication() {
/* 159 */     return this.application;
/*     */   }
/*     */   
/*     */   public void setApplication(Application application) {
/* 163 */     this.application = application;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.LicenseTerms application(Application application) {
/* 167 */     setApplication(application);
/* 168 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 175 */     if (this == o) {
/* 176 */       return true;
/*     */     }
/* 178 */     if (!(o instanceof com.nanosoft.amtk.license.LicenseTerms)) {
/* 179 */       return false;
/*     */     }
/* 181 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.license.LicenseTerms)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 187 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 194 */     return "LicenseTerms{id=" + getId() + ", startDate='" + 
/* 195 */       getStartDate() + "', endDate='" + 
/* 196 */       getEndDate() + "', customer='" + 
/* 197 */       getCustomer() + "', deviceId='" + 
/* 198 */       getDeviceId() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\license\LicenseTerms.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */