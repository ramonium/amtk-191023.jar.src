/*    */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.Process;
/*    */ import com.nanosoft.amtk.repository.ProcessRepository;
/*    */ import com.nanosoft.amtk.service.ProcessService;
/*    */ import com.nanosoft.amtk.service.dto.ProcessDTO;
/*    */ import com.nanosoft.amtk.service.mapper.ProcessMapper;
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
/*    */ public class ProcessServiceImpl
/*    */   implements ProcessService
/*    */ {
/* 23 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.ProcessServiceImpl.class);
/*    */   
/*    */   private final ProcessRepository processRepository;
/*    */   
/*    */   private final ProcessMapper processMapper;
/*    */   
/*    */   public ProcessServiceImpl(ProcessRepository processRepository, ProcessMapper processMapper) {
/* 30 */     this.processRepository = processRepository;
/* 31 */     this.processMapper = processMapper;
/*    */   }
/*    */ 
/*    */   
/*    */   public ProcessDTO save(ProcessDTO processDTO) {
/* 36 */     this.log.debug("Request to save Process : {}", processDTO);
/* 37 */     Process process = (Process)this.processMapper.toEntity(processDTO);
/* 38 */     process = (Process)this.processRepository.save(process);
/* 39 */     return (ProcessDTO)this.processMapper.toDto(process);
/*    */   }
/*    */ 
/*    */   
/*    */   public ProcessDTO update(ProcessDTO processDTO) {
/* 44 */     this.log.debug("Request to update Process : {}", processDTO);
/* 45 */     Process process = (Process)this.processMapper.toEntity(processDTO);
/* 46 */     process = (Process)this.processRepository.save(process);
/* 47 */     return (ProcessDTO)this.processMapper.toDto(process);
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<ProcessDTO> partialUpdate(ProcessDTO processDTO) {
/* 52 */     this.log.debug("Request to partially update Process : {}", processDTO);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 61 */     Objects.requireNonNull(this.processRepository);
/* 62 */     Objects.requireNonNull(this.processMapper); return this.processRepository.findById(processDTO.getId()).map(existingProcess -> { this.processMapper.partialUpdate(existingProcess, processDTO); return existingProcess; }).map(this.processRepository::save).map(this.processMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Page<ProcessDTO> findAll(Pageable pageable) {
/* 68 */     this.log.debug("Request to get all Processes");
/* 69 */     Objects.requireNonNull(this.processMapper); return this.processRepository.findAll(pageable).map(this.processMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Optional<ProcessDTO> findOne(Long id) {
/* 75 */     this.log.debug("Request to get Process : {}", id);
/* 76 */     Objects.requireNonNull(this.processMapper); return this.processRepository.findById(id).map(this.processMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   public void delete(Long id) {
/* 81 */     this.log.debug("Request to delete Process : {}", id);
/* 82 */     this.processRepository.deleteById(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\ProcessServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */