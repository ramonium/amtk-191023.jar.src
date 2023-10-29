/*    */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.ChecklistModelItem;
/*    */ import com.nanosoft.amtk.repository.ChecklistModelItemRepository;
/*    */ import com.nanosoft.amtk.service.ChecklistModelItemService;
/*    */ import com.nanosoft.amtk.service.dto.ChecklistModelItemDTO;
/*    */ import com.nanosoft.amtk.service.mapper.ChecklistModelItemMapper;
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
/*    */ public class ChecklistModelItemServiceImpl
/*    */   implements ChecklistModelItemService
/*    */ {
/* 23 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.ChecklistModelItemServiceImpl.class);
/*    */ 
/*    */   
/*    */   private final ChecklistModelItemRepository checklistModelItemRepository;
/*    */ 
/*    */   
/*    */   private final ChecklistModelItemMapper checklistModelItemMapper;
/*    */ 
/*    */   
/*    */   public ChecklistModelItemServiceImpl(ChecklistModelItemRepository checklistModelItemRepository, ChecklistModelItemMapper checklistModelItemMapper) {
/* 33 */     this.checklistModelItemRepository = checklistModelItemRepository;
/* 34 */     this.checklistModelItemMapper = checklistModelItemMapper;
/*    */   }
/*    */ 
/*    */   
/*    */   public ChecklistModelItemDTO save(ChecklistModelItemDTO checklistModelItemDTO) {
/* 39 */     this.log.debug("Request to save ChecklistModelItem : {}", checklistModelItemDTO);
/* 40 */     ChecklistModelItem checklistModelItem = (ChecklistModelItem)this.checklistModelItemMapper.toEntity(checklistModelItemDTO);
/* 41 */     checklistModelItem = (ChecklistModelItem)this.checklistModelItemRepository.save(checklistModelItem);
/* 42 */     return this.checklistModelItemMapper.toDto(checklistModelItem);
/*    */   }
/*    */ 
/*    */   
/*    */   public ChecklistModelItemDTO update(ChecklistModelItemDTO checklistModelItemDTO) {
/* 47 */     this.log.debug("Request to update ChecklistModelItem : {}", checklistModelItemDTO);
/* 48 */     ChecklistModelItem checklistModelItem = (ChecklistModelItem)this.checklistModelItemMapper.toEntity(checklistModelItemDTO);
/* 49 */     checklistModelItem = (ChecklistModelItem)this.checklistModelItemRepository.save(checklistModelItem);
/* 50 */     return this.checklistModelItemMapper.toDto(checklistModelItem);
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<ChecklistModelItemDTO> partialUpdate(ChecklistModelItemDTO checklistModelItemDTO) {
/* 55 */     this.log.debug("Request to partially update ChecklistModelItem : {}", checklistModelItemDTO);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 64 */     Objects.requireNonNull(this.checklistModelItemRepository);
/* 65 */     Objects.requireNonNull(this.checklistModelItemMapper); return this.checklistModelItemRepository.findById(checklistModelItemDTO.getId()).map(existingChecklistModelItem -> { this.checklistModelItemMapper.partialUpdate(existingChecklistModelItem, checklistModelItemDTO); return existingChecklistModelItem; }).map(this.checklistModelItemRepository::save).map(this.checklistModelItemMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Page<ChecklistModelItemDTO> findAll(Pageable pageable) {
/* 71 */     this.log.debug("Request to get all ChecklistModelItems");
/* 72 */     Objects.requireNonNull(this.checklistModelItemMapper); return this.checklistModelItemRepository.findAll(pageable).map(this.checklistModelItemMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Optional<ChecklistModelItemDTO> findOne(Long id) {
/* 78 */     this.log.debug("Request to get ChecklistModelItem : {}", id);
/* 79 */     Objects.requireNonNull(this.checklistModelItemMapper); return this.checklistModelItemRepository.findById(id).map(this.checklistModelItemMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   public void delete(Long id) {
/* 84 */     this.log.debug("Request to delete ChecklistModelItem : {}", id);
/* 85 */     this.checklistModelItemRepository.deleteById(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\ChecklistModelItemServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */