/*    */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.Attachment;
/*    */ import com.nanosoft.amtk.domain.Content;
/*    */ import com.nanosoft.amtk.repository.AttachmentRepository;
/*    */ import com.nanosoft.amtk.service.AttachmentService;
/*    */ import com.nanosoft.amtk.service.dto.AttachmentDTO;
/*    */ import com.nanosoft.amtk.service.mapper.AttachmentMapper;
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
/*    */ public class AttachmentServiceImpl
/*    */   implements AttachmentService
/*    */ {
/* 24 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.AttachmentServiceImpl.class);
/*    */   
/*    */   private final AttachmentRepository attachmentRepository;
/*    */   
/*    */   private final AttachmentMapper attachmentMapper;
/*    */   
/*    */   public AttachmentServiceImpl(AttachmentRepository attachmentRepository, AttachmentMapper attachmentMapper) {
/* 31 */     this.attachmentRepository = attachmentRepository;
/* 32 */     this.attachmentMapper = attachmentMapper;
/*    */   }
/*    */ 
/*    */   
/*    */   public AttachmentDTO save(AttachmentDTO attachmentDTO) {
/* 37 */     this.log.debug("Request to save Attachment : {}", attachmentDTO);
/* 38 */     Attachment attachment = (Attachment)this.attachmentMapper.toEntity(attachmentDTO);
/* 39 */     attachment = (Attachment)this.attachmentRepository.save(attachment);
/* 40 */     return this.attachmentMapper.toDto(attachment);
/*    */   }
/*    */ 
/*    */   
/*    */   public AttachmentDTO update(AttachmentDTO attachmentDTO) {
/* 45 */     this.log.debug("Request to update Attachment : {}", attachmentDTO);
/* 46 */     Attachment attachment = (Attachment)this.attachmentMapper.toEntity(attachmentDTO);
/* 47 */     if (attachment.getContent() == null) attachment.setContent(new Content()); 
/* 48 */     attachment.getContent().setId(attachmentDTO.getContentId());
/* 49 */     attachment = (Attachment)this.attachmentRepository.save(attachment);
/* 50 */     return this.attachmentMapper.toDto(attachment);
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<AttachmentDTO> partialUpdate(AttachmentDTO attachmentDTO) {
/* 55 */     this.log.debug("Request to partially update Attachment : {}", attachmentDTO);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 64 */     Objects.requireNonNull(this.attachmentRepository);
/* 65 */     Objects.requireNonNull(this.attachmentMapper); return this.attachmentRepository.findById(attachmentDTO.getId()).map(existingAttachment -> { this.attachmentMapper.partialUpdate(existingAttachment, attachmentDTO); return existingAttachment; }).map(this.attachmentRepository::save).map(this.attachmentMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Page<AttachmentDTO> findAll(Pageable pageable) {
/* 71 */     this.log.debug("Request to get all Attachments");
/* 72 */     Objects.requireNonNull(this.attachmentMapper); return this.attachmentRepository.findAll(pageable).map(this.attachmentMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Optional<AttachmentDTO> findOne(Long id) {
/* 78 */     this.log.debug("Request to get Attachment : {}", id);
/* 79 */     Objects.requireNonNull(this.attachmentMapper); return this.attachmentRepository.findById(id).map(this.attachmentMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   public void delete(Long id) {
/* 84 */     this.log.debug("Request to delete Attachment : {}", id);
/* 85 */     this.attachmentRepository.deleteById(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\AttachmentServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */