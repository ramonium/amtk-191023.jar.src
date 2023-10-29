/*    */ package BOOT-INF.classes.com.nanosoft.amtk.repository;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.Area;
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
/*    */ public interface AreaRepository
/*    */   extends JpaRepository<Area, Long>, JpaSpecificationExecutor<Area> {
/*    */   default Optional<Area> findOneWithEagerRelationships(Long id) {
/* 18 */     return findOneWithToOneRelationships(id);
/*    */   }
/*    */   
/*    */   default List<Area> findAllWithEagerRelationships() {
/* 22 */     return findAllWithToOneRelationships();
/*    */   }
/*    */   
/*    */   default Page<Area> findAllWithEagerRelationships(Pageable pageable) {
/* 26 */     return findAllWithToOneRelationships(pageable);
/*    */   }
/*    */   
/*    */   @Query(value = "select distinct area from Area area left join fetch area.project", countQuery = "select count(distinct area) from Area area")
/*    */   Page<Area> findAllWithToOneRelationships(Pageable paramPageable);
/*    */   
/*    */   @Query("select distinct area from Area area left join fetch area.project")
/*    */   List<Area> findAllWithToOneRelationships();
/*    */   
/*    */   @Query("select area from Area area left join fetch area.project where area.id =:id")
/*    */   Optional<Area> findOneWithToOneRelationships(@Param("id") Long paramLong);
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\repository\AreaRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */