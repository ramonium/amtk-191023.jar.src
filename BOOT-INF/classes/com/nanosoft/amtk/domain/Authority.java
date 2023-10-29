/*    */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ import javax.validation.constraints.NotNull;
/*    */ import javax.validation.constraints.Size;
/*    */ import org.hibernate.annotations.Cache;
/*    */ import org.hibernate.annotations.CacheConcurrencyStrategy;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "jhi_authority")
/*    */ @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
/*    */ public class Authority
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   @NotNull
/*    */   @Size(max = 50)
/*    */   @Id
/*    */   @Column(length = 50)
/*    */   private String name;
/*    */   
/*    */   public String getName() {
/* 31 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 35 */     this.name = name;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 40 */     if (this == o) {
/* 41 */       return true;
/*    */     }
/* 43 */     if (!(o instanceof com.nanosoft.amtk.domain.Authority)) {
/* 44 */       return false;
/*    */     }
/* 46 */     return Objects.equals(this.name, ((com.nanosoft.amtk.domain.Authority)o).name);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 51 */     return Objects.hashCode(this.name);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 57 */     return "Authority{name='" + this.name + "'}";
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Authority.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */