/*    */ package BOOT-INF.classes.com.nanosoft.amtk.domain;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*    */ import java.io.Serializable;
/*    */ import java.time.Instant;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.EntityListeners;
/*    */ import javax.persistence.MappedSuperclass;
/*    */ import org.springframework.data.annotation.CreatedBy;
/*    */ import org.springframework.data.annotation.CreatedDate;
/*    */ import org.springframework.data.annotation.LastModifiedBy;
/*    */ import org.springframework.data.annotation.LastModifiedDate;
/*    */ import org.springframework.data.jpa.domain.support.AuditingEntityListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @MappedSuperclass
/*    */ @EntityListeners({AuditingEntityListener.class})
/*    */ @JsonIgnoreProperties(value = {"createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"}, allowGetters = true)
/*    */ public abstract class AbstractAuditingEntity<T>
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   @CreatedBy
/*    */   @Column(name = "created_by", nullable = false, length = 50, updatable = false)
/*    */   private String createdBy;
/*    */   @CreatedDate
/*    */   @Column(name = "created_date", updatable = false)
/* 34 */   private Instant createdDate = Instant.now();
/*    */   
/*    */   @LastModifiedBy
/*    */   @Column(name = "last_modified_by", length = 50)
/*    */   private String lastModifiedBy;
/*    */   
/*    */   @LastModifiedDate
/*    */   @Column(name = "last_modified_date")
/* 42 */   private Instant lastModifiedDate = Instant.now();
/*    */   
/*    */   public String getCreatedBy() {
/* 45 */     return this.createdBy;
/*    */   }
/*    */   public abstract T getId();
/*    */   public void setCreatedBy(String createdBy) {
/* 49 */     this.createdBy = createdBy;
/*    */   }
/*    */   
/*    */   public Instant getCreatedDate() {
/* 53 */     return this.createdDate;
/*    */   }
/*    */   
/*    */   public void setCreatedDate(Instant createdDate) {
/* 57 */     this.createdDate = createdDate;
/*    */   }
/*    */   
/*    */   public String getLastModifiedBy() {
/* 61 */     return this.lastModifiedBy;
/*    */   }
/*    */   
/*    */   public void setLastModifiedBy(String lastModifiedBy) {
/* 65 */     this.lastModifiedBy = lastModifiedBy;
/*    */   }
/*    */   
/*    */   public Instant getLastModifiedDate() {
/* 69 */     return this.lastModifiedDate;
/*    */   }
/*    */   
/*    */   public void setLastModifiedDate(Instant lastModifiedDate) {
/* 73 */     this.lastModifiedDate = lastModifiedDate;
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\AbstractAuditingEntity.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */