/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Checklist;
/*     */ import com.nanosoft.amtk.domain.ChecklistItem;
/*     */ import com.nanosoft.amtk.domain.User;
/*     */ import com.nanosoft.amtk.domain.enumeration.ChecklistStatus;
/*     */ import com.nanosoft.amtk.repository.ChecklistItemRepository;
/*     */ import com.nanosoft.amtk.repository.ChecklistRepository;
/*     */ import com.nanosoft.amtk.repository.UserRepository;
/*     */ import com.nanosoft.amtk.service.ChecklistService;
/*     */ import com.nanosoft.amtk.service.dto.ChecklistDTO;
/*     */ import com.nanosoft.amtk.service.mapper.ChecklistMapper;
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
/*     */ import org.springframework.security.core.Authentication;
/*     */ import org.springframework.security.core.context.SecurityContextHolder;
/*     */ import org.springframework.security.core.userdetails.UserDetails;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ 
/*     */ 
/*     */ @Service
/*     */ @Transactional
/*     */ public class ChecklistServiceImpl
/*     */   implements ChecklistService
/*     */ {
/*  35 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.ChecklistServiceImpl.class);
/*     */ 
/*     */   
/*     */   private final ChecklistRepository checklistRepository;
/*     */ 
/*     */   
/*     */   private final ChecklistItemRepository checklistItemRepository;
/*     */   
/*     */   private final UserRepository userRepository;
/*     */   
/*     */   private final ChecklistMapper checklistMapper;
/*     */ 
/*     */   
/*     */   public ChecklistServiceImpl(ChecklistRepository checklistRepository, ChecklistItemRepository checklistItemRepository, UserRepository userRepository, ChecklistMapper checklistMapper) {
/*  49 */     this.checklistRepository = checklistRepository;
/*  50 */     this.checklistItemRepository = checklistItemRepository;
/*  51 */     this.userRepository = userRepository;
/*  52 */     this.checklistMapper = checklistMapper;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChecklistDTO save(ChecklistDTO checklistDTO) {
/*  57 */     this.log.debug("Request to save Checklist : {}", checklistDTO);
/*  58 */     Checklist checklist = (Checklist)this.checklistMapper.toEntity(checklistDTO);
/*  59 */     checklist = (Checklist)this.checklistRepository.save(checklist);
/*  60 */     return this.checklistMapper.toDto(checklist);
/*     */   }
/*     */ 
/*     */   
/*     */   public ChecklistDTO update(ChecklistDTO checklistDTO) {
/*  65 */     this.log.debug("Request to update Checklist : {}", checklistDTO);
/*  66 */     Checklist checklist = (Checklist)this.checklistMapper.toEntity(checklistDTO);
/*  67 */     Checklist oldChecklist = this.checklistRepository.findById(checklist.getId()).get();
/*  68 */     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
/*  69 */     UserDetails userDetails = (UserDetails)authentication.getPrincipal();
/*  70 */     User user = this.userRepository.findOneByLogin(userDetails.getUsername()).get();
/*  71 */     String userId = user.getFirstName() + " " + user.getFirstName() + " (#" + user.getLastName() + ")";
/*     */     
/*  73 */     if (checklist.getStatus() == ChecklistStatus.PendingItemsValidation) {
/*  74 */       int i; boolean finished = true;
/*  75 */       for (ChecklistItem item : checklist.getChecklistItems()) {
/*  76 */         ChecklistItem oldItem = this.checklistItemRepository.findById(item.getId()).get();
/*  77 */         if (oldItem.getIsChecked() != null) {
/*  78 */           if (item.getIsChecked() == null) {
/*  79 */             item.setValidator(null);
/*     */           }
/*     */         }
/*  82 */         else if (item.getIsChecked() != null) {
/*  83 */           item.setValidator(userId);
/*     */         } 
/*     */         
/*  86 */         i = finished & ((item.getIsChecked() != null) ? 1 : 0);
/*     */       } 
/*     */       
/*  89 */       if (i != 0) {
/*  90 */         checklist.setStatus(ChecklistStatus.PendingValidation);
/*     */       }
/*     */     } 
/*     */     
/*  94 */     if (checklist.getStatus() == ChecklistStatus.PendingValidation) {
/*  95 */       if (checklist.getValidatorCheck().booleanValue()) {
/*  96 */         if (!oldChecklist.getValidatorCheck().booleanValue()) {
/*  97 */           checklist.setValidator(userId);
/*     */         }
/*     */       }
/* 100 */       else if (oldChecklist.getValidatorCheck().booleanValue()) {
/* 101 */         checklist.setValidator(null);
/*     */       } 
/*     */ 
/*     */       
/* 105 */       if (checklist.getValidator2Check().booleanValue()) {
/* 106 */         if (!oldChecklist.getValidator2Check().booleanValue()) {
/* 107 */           checklist.setValidator2(userId);
/*     */         }
/*     */       }
/* 110 */       else if (oldChecklist.getValidator2Check().booleanValue()) {
/* 111 */         checklist.setValidator2(null);
/*     */       } 
/*     */ 
/*     */       
/* 115 */       if (checklist.getValidator3Check().booleanValue()) {
/* 116 */         if (!oldChecklist.getValidator3Check().booleanValue()) {
/* 117 */           checklist.setValidator3(userId);
/*     */         }
/*     */       }
/* 120 */       else if (oldChecklist.getValidator3Check().booleanValue()) {
/* 121 */         checklist.setValidator3(null);
/*     */       } 
/*     */ 
/*     */       
/* 125 */       if (checklist.getValidator4Check().booleanValue()) {
/* 126 */         if (!oldChecklist.getValidator4Check().booleanValue()) {
/* 127 */           checklist.setValidator4(userId);
/*     */         }
/*     */       }
/* 130 */       else if (oldChecklist.getValidator4Check().booleanValue()) {
/* 131 */         checklist.setValidator4(null);
/*     */       } 
/*     */ 
/*     */       
/* 135 */       boolean finished = checklist.getValidatorCheck().booleanValue();
/* 136 */       int i = finished & ((checklist.getValidatorRole2() == null || (checklist.getValidatorRole2() != null && checklist.getValidator2Check().booleanValue())) ? 1 : 0);
/* 137 */       i &= (checklist.getValidatorRole3() == null || (checklist.getValidatorRole3() != null && checklist.getValidator3Check().booleanValue())) ? 1 : 0;
/* 138 */       i &= (checklist.getValidatorRole4() == null || (checklist.getValidatorRole4() != null && checklist.getValidator4Check().booleanValue())) ? 1 : 0;
/*     */       
/* 140 */       if (i != 0) {
/* 141 */         checklist.setStatus(ChecklistStatus.Completed);
/*     */       }
/*     */     } 
/*     */     
/* 145 */     checklist = (Checklist)this.checklistRepository.save(checklist);
/* 146 */     return this.checklistMapper.toDto(checklist);
/*     */   }
/*     */ 
/*     */   
/*     */   public Optional<ChecklistDTO> partialUpdate(ChecklistDTO checklistDTO) {
/* 151 */     this.log.debug("Request to partially update Checklist : {}", checklistDTO);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     Objects.requireNonNull(this.checklistRepository);
/* 161 */     Objects.requireNonNull(this.checklistMapper); return this.checklistRepository.findById(checklistDTO.getId()).map(existingChecklist -> { this.checklistMapper.partialUpdate(existingChecklist, checklistDTO); return existingChecklist; }).map(this.checklistRepository::save).map(this.checklistMapper::toDto);
/*     */   }
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<ChecklistDTO> findAll(Pageable pageable) {
/* 167 */     this.log.debug("Request to get all Checklists");
/* 168 */     Objects.requireNonNull(this.checklistMapper); return this.checklistRepository.findAll(pageable).map(this.checklistMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<ChecklistDTO> findAllWhereCertificateIsNull() {
/* 177 */     this.log.debug("Request to get all checklists where Certificate is null");
/*     */ 
/*     */ 
/*     */     
/* 181 */     Objects.requireNonNull(this.checklistMapper); return (List<ChecklistDTO>)StreamSupport.stream(this.checklistRepository.findAll().spliterator(), false).filter(checklist -> (checklist.getCertificate() == null)).map(this.checklistMapper::toDto)
/* 182 */       .collect(Collectors.toCollection(java.util.LinkedList::new));
/*     */   }
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Optional<ChecklistDTO> findOne(Long id) {
/* 188 */     this.log.debug("Request to get Checklist : {}", id);
/* 189 */     Objects.requireNonNull(this.checklistMapper); return this.checklistRepository.findById(id).map(this.checklistMapper::toDto);
/*     */   }
/*     */ 
/*     */   
/*     */   public void delete(Long id) {
/* 194 */     this.log.debug("Request to delete Checklist : {}", id);
/* 195 */     this.checklistRepository.deleteById(id);
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\ChecklistServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */