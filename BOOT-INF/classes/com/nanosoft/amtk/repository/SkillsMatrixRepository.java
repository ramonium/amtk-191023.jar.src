/*    */ package BOOT-INF.classes.com.nanosoft.amtk.repository;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.SkillsMatrix;
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
/*    */ public interface SkillsMatrixRepository
/*    */   extends JpaRepository<SkillsMatrix, Long>, JpaSpecificationExecutor<SkillsMatrix> {
/*    */   default Optional<SkillsMatrix> findOneWithEagerRelationships(Long id) {
/* 18 */     return findOneWithToOneRelationships(id);
/*    */   }
/*    */   
/*    */   default List<SkillsMatrix> findAllWithEagerRelationships() {
/* 22 */     return findAllWithToOneRelationships();
/*    */   }
/*    */   
/*    */   default Page<SkillsMatrix> findAllWithEagerRelationships(Pageable pageable) {
/* 26 */     return findAllWithToOneRelationships(pageable);
/*    */   }
/*    */   
/*    */   @Query(value = "select distinct skillsMatrix from SkillsMatrix skillsMatrix left join fetch skillsMatrix.project", countQuery = "select count(distinct skillsMatrix) from SkillsMatrix skillsMatrix")
/*    */   Page<SkillsMatrix> findAllWithToOneRelationships(Pageable paramPageable);
/*    */   
/*    */   @Query("select distinct skillsMatrix from SkillsMatrix skillsMatrix left join fetch skillsMatrix.project")
/*    */   List<SkillsMatrix> findAllWithToOneRelationships();
/*    */   
/*    */   @Query("select skillsMatrix from SkillsMatrix skillsMatrix left join fetch skillsMatrix.project where skillsMatrix.id =:id")
/*    */   Optional<SkillsMatrix> findOneWithToOneRelationships(@Param("id") Long paramLong);
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\repository\SkillsMatrixRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */