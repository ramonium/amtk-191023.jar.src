/*    */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.Assignment;
/*    */ import com.nanosoft.amtk.repository.AssignmentRepository;
/*    */ import com.nanosoft.amtk.service.AssignmentService;
/*    */ import com.nanosoft.amtk.service.dto.AssignmentDTO;
/*    */ import com.nanosoft.amtk.service.mapper.AssignmentMapper;
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
/*    */ public class AssignmentServiceImpl
/*    */   implements AssignmentService
/*    */ {
/* 23 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.AssignmentServiceImpl.class);
/*    */   
/*    */   private final AssignmentRepository assignmentRepository;
/*    */   
/*    */   private final AssignmentMapper assignmentMapper;
/*    */   
/*    */   public AssignmentServiceImpl(AssignmentRepository assignmentRepository, AssignmentMapper assignmentMapper) {
/* 30 */     this.assignmentRepository = assignmentRepository;
/* 31 */     this.assignmentMapper = assignmentMapper;
/*    */   }
/*    */ 
/*    */   
/*    */   public AssignmentDTO save(AssignmentDTO assignmentDTO) {
/* 36 */     this.log.debug("Request to save Assignment : {}", assignmentDTO);
/* 37 */     Assignment assignment = (Assignment)this.assignmentMapper.toEntity(assignmentDTO);
/* 38 */     assignment = (Assignment)this.assignmentRepository.save(assignment);
/* 39 */     return this.assignmentMapper.toDto(assignment);
/*    */   }
/*    */ 
/*    */   
/*    */   public AssignmentDTO update(AssignmentDTO assignmentDTO) {
/* 44 */     this.log.debug("Request to update Assignment : {}", assignmentDTO);
/* 45 */     Assignment assignment = (Assignment)this.assignmentMapper.toEntity(assignmentDTO);
/* 46 */     assignment = (Assignment)this.assignmentRepository.save(assignment);
/* 47 */     return this.assignmentMapper.toDto(assignment);
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<AssignmentDTO> partialUpdate(AssignmentDTO assignmentDTO) {
/* 52 */     this.log.debug("Request to partially update Assignment : {}", assignmentDTO);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 61 */     Objects.requireNonNull(this.assignmentRepository);
/* 62 */     Objects.requireNonNull(this.assignmentMapper); return this.assignmentRepository.findById(assignmentDTO.getId()).map(existingAssignment -> { this.assignmentMapper.partialUpdate(existingAssignment, assignmentDTO); return existingAssignment; }).map(this.assignmentRepository::save).map(this.assignmentMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Page<AssignmentDTO> findAll(Pageable pageable) {
/* 68 */     this.log.debug("Request to get all Assignments");
/* 69 */     Objects.requireNonNull(this.assignmentMapper); return this.assignmentRepository.findAll(pageable).map(this.assignmentMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Optional<AssignmentDTO> findOne(Long id) {
/* 75 */     this.log.debug("Request to get Assignment : {}", id);
/* 76 */     Objects.requireNonNull(this.assignmentMapper); return this.assignmentRepository.findById(id).map(this.assignmentMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   public void delete(Long id) {
/* 81 */     this.log.debug("Request to delete Assignment : {}", id);
/* 82 */     this.assignmentRepository.deleteById(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\AssignmentServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */