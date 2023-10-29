/*    */ package BOOT-INF.classes.com.nanosoft.amtk.repository;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.Employee;
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
/*    */ public interface EmployeeRepository
/*    */   extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
/*    */   default Optional<Employee> findOneWithEagerRelationships(Long id) {
/* 18 */     return findOneWithToOneRelationships(id);
/*    */   }
/*    */   
/*    */   default List<Employee> findAllWithEagerRelationships() {
/* 22 */     return findAllWithToOneRelationships();
/*    */   }
/*    */   
/*    */   default Page<Employee> findAllWithEagerRelationships(Pageable pageable) {
/* 26 */     return findAllWithToOneRelationships(pageable);
/*    */   }
/*    */   
/*    */   @Query(value = "select distinct employee from Employee employee left join fetch employee.title left join fetch employee.team", countQuery = "select count(distinct employee) from Employee employee")
/*    */   Page<Employee> findAllWithToOneRelationships(Pageable paramPageable);
/*    */   
/*    */   @Query("select distinct employee from Employee employee left join fetch employee.title left join fetch employee.team")
/*    */   List<Employee> findAllWithToOneRelationships();
/*    */   
/*    */   @Query("select employee from Employee employee left join fetch employee.title left join fetch employee.team where employee.id =:id")
/*    */   Optional<Employee> findOneWithToOneRelationships(@Param("id") Long paramLong);
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\repository\EmployeeRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */