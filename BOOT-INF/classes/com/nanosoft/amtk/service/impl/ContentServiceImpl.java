/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Content;
/*     */ import com.nanosoft.amtk.repository.ContentRepository;
/*     */ import com.nanosoft.amtk.service.ContentService;
/*     */ import com.nanosoft.amtk.service.dto.ContentDTO;
/*     */ import com.nanosoft.amtk.service.mapper.ContentMapper;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.StreamSupport;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.Pageable;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ 
/*     */ 
/*     */ @Service
/*     */ @Transactional
/*     */ public class ContentServiceImpl
/*     */   implements ContentService
/*     */ {
/*  27 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.ContentServiceImpl.class);
/*     */   
/*     */   private final ContentRepository contentRepository;
/*     */   
/*     */   private final ContentMapper contentMapper;
/*     */   
/*     */   public ContentServiceImpl(ContentRepository contentRepository, ContentMapper contentMapper) {
/*  34 */     this.contentRepository = contentRepository;
/*  35 */     this.contentMapper = contentMapper;
/*     */   }
/*     */ 
/*     */   
/*     */   public ContentDTO save(ContentDTO contentDTO) {
/*  40 */     this.log.debug("Request to save Content : {}", contentDTO);
/*  41 */     Content content = (Content)this.contentMapper.toEntity(contentDTO);
/*  42 */     content = (Content)this.contentRepository.save(content);
/*  43 */     return (ContentDTO)this.contentMapper.toDto(content);
/*     */   }
/*     */ 
/*     */   
/*     */   public ContentDTO update(ContentDTO contentDTO) {
/*  48 */     this.log.debug("Request to update Content : {}", contentDTO);
/*  49 */     Content content = (Content)this.contentMapper.toEntity(contentDTO);
/*  50 */     content = (Content)this.contentRepository.save(content);
/*  51 */     return (ContentDTO)this.contentMapper.toDto(content);
/*     */   }
/*     */ 
/*     */   
/*     */   public Optional<ContentDTO> partialUpdate(ContentDTO contentDTO) {
/*  56 */     this.log.debug("Request to partially update Content : {}", contentDTO);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     Objects.requireNonNull(this.contentRepository);
/*  66 */     Objects.requireNonNull(this.contentMapper); return this.contentRepository.findById(contentDTO.getId()).map(existingContent -> { this.contentMapper.partialUpdate(existingContent, contentDTO); return existingContent; }).map(this.contentRepository::save).map(this.contentMapper::toDto);
/*     */   }
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<ContentDTO> findAll(Pageable pageable) {
/*  72 */     this.log.debug("Request to get all Contents");
/*  73 */     Objects.requireNonNull(this.contentMapper); return this.contentRepository.findAll(pageable).map(this.contentMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<ContentDTO> findAllWhereAttachmentIsNull() {
/*  82 */     this.log.debug("Request to get all contents where Attachment is null");
/*     */ 
/*     */ 
/*     */     
/*  86 */     Objects.requireNonNull(this.contentMapper); return (List<ContentDTO>)StreamSupport.stream(this.contentRepository.findAll().spliterator(), false).filter(content -> (content.getAttachment() == null)).map(this.contentMapper::toDto)
/*  87 */       .collect(Collectors.toCollection(java.util.LinkedList::new));
/*     */   }
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Optional<ContentDTO> findOne(Long id) {
/*  93 */     this.log.debug("Request to get Content : {}", id);
/*  94 */     Objects.requireNonNull(this.contentMapper); return this.contentRepository.findById(id).map(this.contentMapper::toDto);
/*     */   }
/*     */ 
/*     */   
/*     */   public void delete(Long id) {
/*  99 */     this.log.debug("Request to delete Content : {}", id);
/* 100 */     this.contentRepository.deleteById(id);
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\ContentServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */