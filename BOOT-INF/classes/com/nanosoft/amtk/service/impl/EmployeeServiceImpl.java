/*    */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.Employee;
/*    */ import com.nanosoft.amtk.repository.EmployeeRepository;
/*    */ import com.nanosoft.amtk.service.EmployeeService;
/*    */ import com.nanosoft.amtk.service.dto.EmployeeDTO;
/*    */ import com.nanosoft.amtk.service.mapper.EmployeeMapper;
/*    */ import java.util.Objects;
/*    */ import java.util.Optional;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.data.domain.Page;
/*    */ import org.springframework.data.domain.Pageable;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ 
/*    */ @Service
/*    */ @Transactional
/*    */ public class EmployeeServiceImpl
/*    */   implements EmployeeService
/*    */ {
/* 23 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.EmployeeServiceImpl.class);
/*    */   
/*    */   private final EmployeeRepository employeeRepository;
/*    */   
/*    */   private final EmployeeMapper employeeMapper;
/*    */   
/*    */   public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
/* 30 */     this.employeeRepository = employeeRepository;
/* 31 */     this.employeeMapper = employeeMapper;
/*    */   }
/*    */ 
/*    */   
/*    */   public EmployeeDTO save(EmployeeDTO employeeDTO) {
/* 36 */     this.log.debug("Request to save Employee : {}", employeeDTO);
/* 37 */     Employee employee = (Employee)this.employeeMapper.toEntity(employeeDTO);
/* 38 */     employee = (Employee)this.employeeRepository.save(employee);
/* 39 */     return this.employeeMapper.toDto(employee);
/*    */   }
/*    */ 
/*    */   
/*    */   public EmployeeDTO update(EmployeeDTO employeeDTO) {
/* 44 */     this.log.debug("Request to update Employee : {}", employeeDTO);
/* 45 */     Employee employee = (Employee)this.employeeMapper.toEntity(employeeDTO);
/* 46 */     employee = (Employee)this.employeeRepository.save(employee);
/* 47 */     return this.employeeMapper.toDto(employee);
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<EmployeeDTO> partialUpdate(EmployeeDTO employeeDTO) {
/* 52 */     this.log.debug("Request to partially update Employee : {}", employeeDTO);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 61 */     Objects.requireNonNull(this.employeeRepository);
/* 62 */     Objects.requireNonNull(this.employeeMapper); return this.employeeRepository.findById(employeeDTO.getId()).map(existingEmployee -> { this.employeeMapper.partialUpdate(existingEmployee, employeeDTO); return existingEmployee; }).map(this.employeeRepository::save).map(this.employeeMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Page<EmployeeDTO> findAll(Pageable pageable) {
/* 68 */     this.log.debug("Request to get all Employees");
/* 69 */     Objects.requireNonNull(this.employeeMapper); return this.employeeRepository.findAll(pageable).map(this.employeeMapper::toDto);
/*    */   }
/*    */   
/*    */   public Page<EmployeeDTO> findAllWithEagerRelationships(Pageable pageable) {
/* 73 */     Objects.requireNonNull(this.employeeMapper); return this.employeeRepository.findAllWithEagerRelationships(pageable).map(this.employeeMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Optional<EmployeeDTO> findOne(Long id) {
/* 79 */     this.log.debug("Request to get Employee : {}", id);
/* 80 */     Objects.requireNonNull(this.employeeMapper); return this.employeeRepository.findOneWithEagerRelationships(id).map(this.employeeMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   public void delete(Long id) {
/* 85 */     this.log.debug("Request to delete Employee : {}", id);
/* 86 */     this.employeeRepository.deleteById(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\EmployeeServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */