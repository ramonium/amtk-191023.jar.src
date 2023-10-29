/*    */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.ChecklistItem;
/*    */ import com.nanosoft.amtk.repository.ChecklistItemRepository;
/*    */ import com.nanosoft.amtk.service.ChecklistItemService;
/*    */ import com.nanosoft.amtk.service.dto.ChecklistItemDTO;
/*    */ import com.nanosoft.amtk.service.mapper.ChecklistItemMapper;
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
/*    */ public class ChecklistItemServiceImpl
/*    */   implements ChecklistItemService
/*    */ {
/* 23 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.ChecklistItemServiceImpl.class);
/*    */   
/*    */   private final ChecklistItemRepository checklistItemRepository;
/*    */   
/*    */   private final ChecklistItemMapper checklistItemMapper;
/*    */   
/*    */   public ChecklistItemServiceImpl(ChecklistItemRepository checklistItemRepository, ChecklistItemMapper checklistItemMapper) {
/* 30 */     this.checklistItemRepository = checklistItemRepository;
/* 31 */     this.checklistItemMapper = checklistItemMapper;
/*    */   }
/*    */ 
/*    */   
/*    */   public ChecklistItemDTO save(ChecklistItemDTO checklistItemDTO) {
/* 36 */     this.log.debug("Request to save ChecklistItem : {}", checklistItemDTO);
/* 37 */     ChecklistItem checklistItem = (ChecklistItem)this.checklistItemMapper.toEntity(checklistItemDTO);
/* 38 */     checklistItem = (ChecklistItem)this.checklistItemRepository.save(checklistItem);
/* 39 */     return this.checklistItemMapper.toDto(checklistItem);
/*    */   }
/*    */ 
/*    */   
/*    */   public ChecklistItemDTO update(ChecklistItemDTO checklistItemDTO) {
/* 44 */     this.log.debug("Request to update ChecklistItem : {}", checklistItemDTO);
/* 45 */     ChecklistItem checklistItem = (ChecklistItem)this.checklistItemMapper.toEntity(checklistItemDTO);
/* 46 */     checklistItem = (ChecklistItem)this.checklistItemRepository.save(checklistItem);
/* 47 */     return this.checklistItemMapper.toDto(checklistItem);
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<ChecklistItemDTO> partialUpdate(ChecklistItemDTO checklistItemDTO) {
/* 52 */     this.log.debug("Request to partially update ChecklistItem : {}", checklistItemDTO);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 61 */     Objects.requireNonNull(this.checklistItemRepository);
/* 62 */     Objects.requireNonNull(this.checklistItemMapper); return this.checklistItemRepository.findById(checklistItemDTO.getId()).map(existingChecklistItem -> { this.checklistItemMapper.partialUpdate(existingChecklistItem, checklistItemDTO); return existingChecklistItem; }).map(this.checklistItemRepository::save).map(this.checklistItemMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Page<ChecklistItemDTO> findAll(Pageable pageable) {
/* 68 */     this.log.debug("Request to get all ChecklistItems");
/* 69 */     Objects.requireNonNull(this.checklistItemMapper); return this.checklistItemRepository.findAll(pageable).map(this.checklistItemMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Optional<ChecklistItemDTO> findOne(Long id) {
/* 75 */     this.log.debug("Request to get ChecklistItem : {}", id);
/* 76 */     Objects.requireNonNull(this.checklistItemMapper); return this.checklistItemRepository.findById(id).map(this.checklistItemMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   public void delete(Long id) {
/* 81 */     this.log.debug("Request to delete ChecklistItem : {}", id);
/* 82 */     this.checklistItemRepository.deleteById(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\ChecklistItemServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */