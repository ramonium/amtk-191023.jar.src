/*     */ package BOOT-INF.classes.com.nanosoft.amtk.license;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*     */ import com.nanosoft.amtk.license.Feature;
/*     */ import java.io.Serializable;
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
/*     */ public class Application
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String name;
/*     */   private String description;
/*     */   @JsonIgnore
/*  25 */   private Set<Feature> features = new HashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getId() {
/*  31 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.Application id(Long id) {
/*  35 */     setId(id);
/*  36 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  40 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  44 */     return this.name;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.Application name(String name) {
/*  48 */     setName(name);
/*  49 */     return this;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  53 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  57 */     return this.description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.Application description(String description) {
/*  61 */     setDescription(description);
/*  62 */     return this;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  66 */     this.description = description;
/*     */   }
/*     */   
/*     */   public Set<Feature> getFeatures() {
/*  70 */     return this.features;
/*     */   }
/*     */   
/*     */   public void setFeatures(Set<Feature> features) {
/*  74 */     if (this.features != null) {
/*  75 */       this.features.forEach(i -> i.setApplication(null));
/*     */     }
/*  77 */     if (features != null) {
/*  78 */       features.forEach(i -> i.setApplication(this));
/*     */     }
/*  80 */     this.features = features;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.Application features(Set<Feature> features) {
/*  84 */     setFeatures(features);
/*  85 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.Application addFeature(Feature feature) {
/*  89 */     this.features.add(feature);
/*  90 */     feature.setApplication(this);
/*  91 */     return this;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.Application removeFeature(Feature feature) {
/*  95 */     this.features.remove(feature);
/*  96 */     feature.setApplication(null);
/*  97 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 104 */     if (this == o) {
/* 105 */       return true;
/*     */     }
/* 107 */     if (!(o instanceof com.nanosoft.amtk.license.Application)) {
/* 108 */       return false;
/*     */     }
/* 110 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.license.Application)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 123 */     return "Application{id=" + getId() + ", name='" + 
/* 124 */       getName() + "', description='" + 
/* 125 */       getDescription() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\license\Application.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */