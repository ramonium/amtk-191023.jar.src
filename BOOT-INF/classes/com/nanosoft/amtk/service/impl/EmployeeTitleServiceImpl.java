/*    */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.EmployeeTitle;
/*    */ import com.nanosoft.amtk.repository.EmployeeTitleRepository;
/*    */ import com.nanosoft.amtk.service.EmployeeTitleService;
/*    */ import com.nanosoft.amtk.service.dto.EmployeeTitleDTO;
/*    */ import com.nanosoft.amtk.service.mapper.EmployeeTitleMapper;
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
/*    */ public class EmployeeTitleServiceImpl
/*    */   implements EmployeeTitleService
/*    */ {
/* 23 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.EmployeeTitleServiceImpl.class);
/*    */   
/*    */   private final EmployeeTitleRepository employeeTitleRepository;
/*    */   
/*    */   private final EmployeeTitleMapper employeeTitleMapper;
/*    */   
/*    */   public EmployeeTitleServiceImpl(EmployeeTitleRepository employeeTitleRepository, EmployeeTitleMapper employeeTitleMapper) {
/* 30 */     this.employeeTitleRepository = employeeTitleRepository;
/* 31 */     this.employeeTitleMapper = employeeTitleMapper;
/*    */   }
/*    */ 
/*    */   
/*    */   public EmployeeTitleDTO save(EmployeeTitleDTO employeeTitleDTO) {
/* 36 */     this.log.debug("Request to save EmployeeTitle : {}", employeeTitleDTO);
/* 37 */     EmployeeTitle employeeTitle = (EmployeeTitle)this.employeeTitleMapper.toEntity(employeeTitleDTO);
/* 38 */     employeeTitle = (EmployeeTitle)this.employeeTitleRepository.save(employeeTitle);
/* 39 */     return (EmployeeTitleDTO)this.employeeTitleMapper.toDto(employeeTitle);
/*    */   }
/*    */ 
/*    */   
/*    */   public EmployeeTitleDTO update(EmployeeTitleDTO employeeTitleDTO) {
/* 44 */     this.log.debug("Request to update EmployeeTitle : {}", employeeTitleDTO);
/* 45 */     EmployeeTitle employeeTitle = (EmployeeTitle)this.employeeTitleMapper.toEntity(employeeTitleDTO);
/* 46 */     employeeTitle = (EmployeeTitle)this.employeeTitleRepository.save(employeeTitle);
/* 47 */     return (EmployeeTitleDTO)this.employeeTitleMapper.toDto(employeeTitle);
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<EmployeeTitleDTO> partialUpdate(EmployeeTitleDTO employeeTitleDTO) {
/* 52 */     this.log.debug("Request to partially update EmployeeTitle : {}", employeeTitleDTO);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 61 */     Objects.requireNonNull(this.employeeTitleRepository);
/* 62 */     Objects.requireNonNull(this.employeeTitleMapper); return this.employeeTitleRepository.findById(employeeTitleDTO.getId()).map(existingEmployeeTitle -> { this.employeeTitleMapper.partialUpdate(existingEmployeeTitle, employeeTitleDTO); return existingEmployeeTitle; }).map(this.employeeTitleRepository::save).map(this.employeeTitleMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Page<EmployeeTitleDTO> findAll(Pageable pageable) {
/* 68 */     this.log.debug("Request to get all EmployeeTitles");
/* 69 */     Objects.requireNonNull(this.employeeTitleMapper); return this.employeeTitleRepository.findAll(pageable).map(this.employeeTitleMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Optional<EmployeeTitleDTO> findOne(Long id) {
/* 75 */     this.log.debug("Request to get EmployeeTitle : {}", id);
/* 76 */     Objects.requireNonNull(this.employeeTitleMapper); return this.employeeTitleRepository.findById(id).map(this.employeeTitleMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   public void delete(Long id) {
/* 81 */     this.log.debug("Request to delete EmployeeTitle : {}", id);
/* 82 */     this.employeeTitleRepository.deleteById(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\EmployeeTitleServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */