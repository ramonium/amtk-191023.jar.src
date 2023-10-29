/*    */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.Workstation;
/*    */ import com.nanosoft.amtk.repository.WorkstationRepository;
/*    */ import com.nanosoft.amtk.service.WorkstationService;
/*    */ import com.nanosoft.amtk.service.dto.WorkstationDTO;
/*    */ import com.nanosoft.amtk.service.mapper.WorkstationMapper;
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
/*    */ public class WorkstationServiceImpl
/*    */   implements WorkstationService
/*    */ {
/* 23 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.WorkstationServiceImpl.class);
/*    */   
/*    */   private final WorkstationRepository workstationRepository;
/*    */   
/*    */   private final WorkstationMapper workstationMapper;
/*    */   
/*    */   public WorkstationServiceImpl(WorkstationRepository workstationRepository, WorkstationMapper workstationMapper) {
/* 30 */     this.workstationRepository = workstationRepository;
/* 31 */     this.workstationMapper = workstationMapper;
/*    */   }
/*    */ 
/*    */   
/*    */   public WorkstationDTO save(WorkstationDTO workstationDTO) {
/* 36 */     this.log.debug("Request to save Workstation : {}", workstationDTO);
/* 37 */     Workstation workstation = (Workstation)this.workstationMapper.toEntity(workstationDTO);
/* 38 */     workstation = (Workstation)this.workstationRepository.save(workstation);
/* 39 */     return this.workstationMapper.toDto(workstation);
/*    */   }
/*    */ 
/*    */   
/*    */   public WorkstationDTO update(WorkstationDTO workstationDTO) {
/* 44 */     this.log.debug("Request to update Workstation : {}", workstationDTO);
/* 45 */     Workstation workstation = (Workstation)this.workstationMapper.toEntity(workstationDTO);
/* 46 */     workstation = (Workstation)this.workstationRepository.save(workstation);
/* 47 */     return this.workstationMapper.toDto(workstation);
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<WorkstationDTO> partialUpdate(WorkstationDTO workstationDTO) {
/* 52 */     this.log.debug("Request to partially update Workstation : {}", workstationDTO);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 61 */     Objects.requireNonNull(this.workstationRepository);
/* 62 */     Objects.requireNonNull(this.workstationMapper); return this.workstationRepository.findById(workstationDTO.getId()).map(existingWorkstation -> { this.workstationMapper.partialUpdate(existingWorkstation, workstationDTO); return existingWorkstation; }).map(this.workstationRepository::save).map(this.workstationMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Page<WorkstationDTO> findAll(Pageable pageable) {
/* 68 */     this.log.debug("Request to get all Workstations");
/* 69 */     Objects.requireNonNull(this.workstationMapper); return this.workstationRepository.findAll(pageable).map(this.workstationMapper::toDto);
/*    */   }
/*    */   
/*    */   public Page<WorkstationDTO> findAllWithEagerRelationships(Pageable pageable) {
/* 73 */     Objects.requireNonNull(this.workstationMapper); return this.workstationRepository.findAllWithEagerRelationships(pageable).map(this.workstationMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Optional<WorkstationDTO> findOne(Long id) {
/* 79 */     this.log.debug("Request to get Workstation : {}", id);
/* 80 */     Objects.requireNonNull(this.workstationMapper); return this.workstationRepository.findOneWithEagerRelationships(id).map(this.workstationMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   public void delete(Long id) {
/* 85 */     this.log.debug("Request to delete Workstation : {}", id);
/* 86 */     this.workstationRepository.deleteById(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\WorkstationServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */