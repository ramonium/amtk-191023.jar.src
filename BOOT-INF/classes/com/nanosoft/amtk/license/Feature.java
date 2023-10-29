/*     */ package BOOT-INF.classes.com.nanosoft.amtk.license;
/*     */ 
/*     */ import com.nanosoft.amtk.license.Application;
/*     */ import java.io.Serializable;
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
/*     */ public class Feature
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String name;
/*     */   private String description;
/*     */   private Application application;
/*     */   
/*     */   public Long getId() {
/*  29 */     return this.id;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.Feature id(Long id) {
/*  33 */     setId(id);
/*  34 */     return this;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  38 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  42 */     return this.name;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.Feature name(String name) {
/*  46 */     setName(name);
/*  47 */     return this;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  51 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  55 */     return this.description;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.Feature description(String description) {
/*  59 */     setDescription(description);
/*  60 */     return this;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  64 */     this.description = description;
/*     */   }
/*     */   
/*     */   public Application getApplication() {
/*  68 */     return this.application;
/*     */   }
/*     */   
/*     */   public void setApplication(Application application) {
/*  72 */     this.application = application;
/*     */   }
/*     */   
/*     */   public com.nanosoft.amtk.license.Feature application(Application application) {
/*  76 */     setApplication(application);
/*  77 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  84 */     if (this == o) {
/*  85 */       return true;
/*     */     }
/*  87 */     if (!(o instanceof com.nanosoft.amtk.license.Feature)) {
/*  88 */       return false;
/*     */     }
/*  90 */     return (this.id != null && this.id.equals(((com.nanosoft.amtk.license.Feature)o).id));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     return getClass().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 103 */     return "Feature{id=" + getId() + ", name='" + 
/* 104 */       getName() + "', description='" + 
/* 105 */       getDescription() + "'}";
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\license\Feature.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */