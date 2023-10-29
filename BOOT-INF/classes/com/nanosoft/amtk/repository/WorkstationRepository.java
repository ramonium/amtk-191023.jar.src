/*    */ package BOOT-INF.classes.com.nanosoft.amtk.repository;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.Workstation;
/*    */ import java.util.List;
/*    */ import java.util.Optional;
/*    */ import org.springframework.data.domain.Page;
/*    */ import org.springframework.data.domain.Pageable;
/*    */ import org.springframework.data.jpa.repository.JpaRepository;
/*    */ import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
/*    */ import org.springframework.data.jpa.repository.Query;
/*    */ import org.springframework.data.repository.query.Param;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public interface WorkstationRepository
/*    */   extends JpaRepository<Workstation, Long>, JpaSpecificationExecutor<Workstation> {
/*    */   default Optional<Workstation> findOneWithEagerRelationships(Long id) {
/* 18 */     return findOneWithToOneRelationships(id);
/*    */   }
/*    */   
/*    */   default List<Workstation> findAllWithEagerRelationships() {
/* 22 */     return findAllWithToOneRelationships();
/*    */   }
/*    */   
/*    */   default Page<Workstation> findAllWithEagerRelationships(Pageable pageable) {
/* 26 */     return findAllWithToOneRelationships(pageable);
/*    */   }
/*    */   
/*    */   @Query(value = "select distinct workstation from Workstation workstation left join fetch workstation.area left join fetch workstation.process", countQuery = "select count(distinct workstation) from Workstation workstation")
/*    */   Page<Workstation> findAllWithToOneRelationships(Pageable paramPageable);
/*    */   
/*    */   @Query("select distinct workstation from Workstation workstation left join fetch workstation.area left join fetch workstation.process")
/*    */   List<Workstation> findAllWithToOneRelationships();
/*    */   
/*    */   @Query("select workstation from Workstation workstation left join fetch workstation.area left join fetch workstation.process where workstation.id =:id")
/*    */   Optional<Workstation> findOneWithToOneRelationships(@Param("id") Long paramLong);
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\repository\WorkstationRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */