/*    */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.ChecklistModel;
/*    */ import com.nanosoft.amtk.repository.ChecklistModelRepository;
/*    */ import com.nanosoft.amtk.service.ChecklistModelService;
/*    */ import com.nanosoft.amtk.service.dto.ChecklistModelDTO;
/*    */ import com.nanosoft.amtk.service.mapper.ChecklistModelMapper;
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
/*    */ public class ChecklistModelServiceImpl
/*    */   implements ChecklistModelService
/*    */ {
/* 23 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.ChecklistModelServiceImpl.class);
/*    */   
/*    */   private final ChecklistModelRepository checklistModelRepository;
/*    */   
/*    */   private final ChecklistModelMapper checklistModelMapper;
/*    */   
/*    */   public ChecklistModelServiceImpl(ChecklistModelRepository checklistModelRepository, ChecklistModelMapper checklistModelMapper) {
/* 30 */     this.checklistModelRepository = checklistModelRepository;
/* 31 */     this.checklistModelMapper = checklistModelMapper;
/*    */   }
/*    */ 
/*    */   
/*    */   public ChecklistModelDTO save(ChecklistModelDTO checklistModelDTO) {
/* 36 */     this.log.debug("Request to save ChecklistModel : {}", checklistModelDTO);
/* 37 */     ChecklistModel checklistModel = (ChecklistModel)this.checklistModelMapper.toEntity(checklistModelDTO);
/* 38 */     checklistModel = (ChecklistModel)this.checklistModelRepository.save(checklistModel);
/* 39 */     return (ChecklistModelDTO)this.checklistModelMapper.toDto(checklistModel);
/*    */   }
/*    */ 
/*    */   
/*    */   public ChecklistModelDTO update(ChecklistModelDTO checklistModelDTO) {
/* 44 */     this.log.debug("Request to update ChecklistModel : {}", checklistModelDTO);
/* 45 */     ChecklistModel checklistModel = (ChecklistModel)this.checklistModelMapper.toEntity(checklistModelDTO);
/* 46 */     checklistModel = (ChecklistModel)this.checklistModelRepository.save(checklistModel);
/* 47 */     return (ChecklistModelDTO)this.checklistModelMapper.toDto(checklistModel);
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<ChecklistModelDTO> partialUpdate(ChecklistModelDTO checklistModelDTO) {
/* 52 */     this.log.debug("Request to partially update ChecklistModel : {}", checklistModelDTO);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 61 */     Objects.requireNonNull(this.checklistModelRepository);
/* 62 */     Objects.requireNonNull(this.checklistModelMapper); return this.checklistModelRepository.findById(checklistModelDTO.getId()).map(existingChecklistModel -> { this.checklistModelMapper.partialUpdate(existingChecklistModel, checklistModelDTO); return existingChecklistModel; }).map(this.checklistModelRepository::save).map(this.checklistModelMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Page<ChecklistModelDTO> findAll(Pageable pageable) {
/* 68 */     this.log.debug("Request to get all ChecklistModels");
/* 69 */     Objects.requireNonNull(this.checklistModelMapper); return this.checklistModelRepository.findAll(pageable).map(this.checklistModelMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Optional<ChecklistModelDTO> findOne(Long id) {
/* 75 */     this.log.debug("Request to get ChecklistModel : {}", id);
/* 76 */     Objects.requireNonNull(this.checklistModelMapper); return this.checklistModelRepository.findById(id).map(this.checklistModelMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   public void delete(Long id) {
/* 81 */     this.log.debug("Request to delete ChecklistModel : {}", id);
/* 82 */     this.checklistModelRepository.deleteById(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\ChecklistModelServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */