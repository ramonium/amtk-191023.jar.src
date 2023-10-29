/*    */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.CertificationLevel;
/*    */ import com.nanosoft.amtk.repository.CertificationLevelRepository;
/*    */ import com.nanosoft.amtk.service.CertificationLevelService;
/*    */ import com.nanosoft.amtk.service.dto.CertificationLevelDTO;
/*    */ import com.nanosoft.amtk.service.mapper.CertificationLevelMapper;
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
/*    */ public class CertificationLevelServiceImpl
/*    */   implements CertificationLevelService
/*    */ {
/* 23 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.CertificationLevelServiceImpl.class);
/*    */ 
/*    */   
/*    */   private final CertificationLevelRepository certificationLevelRepository;
/*    */ 
/*    */   
/*    */   private final CertificationLevelMapper certificationLevelMapper;
/*    */ 
/*    */   
/*    */   public CertificationLevelServiceImpl(CertificationLevelRepository certificationLevelRepository, CertificationLevelMapper certificationLevelMapper) {
/* 33 */     this.certificationLevelRepository = certificationLevelRepository;
/* 34 */     this.certificationLevelMapper = certificationLevelMapper;
/*    */   }
/*    */ 
/*    */   
/*    */   public CertificationLevelDTO save(CertificationLevelDTO certificationLevelDTO) {
/* 39 */     this.log.debug("Request to save CertificationLevel : {}", certificationLevelDTO);
/* 40 */     CertificationLevel certificationLevel = (CertificationLevel)this.certificationLevelMapper.toEntity(certificationLevelDTO);
/* 41 */     certificationLevel = (CertificationLevel)this.certificationLevelRepository.save(certificationLevel);
/* 42 */     return this.certificationLevelMapper.toDto(certificationLevel);
/*    */   }
/*    */ 
/*    */   
/*    */   public CertificationLevelDTO update(CertificationLevelDTO certificationLevelDTO) {
/* 47 */     this.log.debug("Request to update CertificationLevel : {}", certificationLevelDTO);
/* 48 */     CertificationLevel certificationLevel = (CertificationLevel)this.certificationLevelMapper.toEntity(certificationLevelDTO);
/* 49 */     certificationLevel = (CertificationLevel)this.certificationLevelRepository.save(certificationLevel);
/* 50 */     return this.certificationLevelMapper.toDto(certificationLevel);
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<CertificationLevelDTO> partialUpdate(CertificationLevelDTO certificationLevelDTO) {
/* 55 */     this.log.debug("Request to partially update CertificationLevel : {}", certificationLevelDTO);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 64 */     Objects.requireNonNull(this.certificationLevelRepository);
/* 65 */     Objects.requireNonNull(this.certificationLevelMapper); return this.certificationLevelRepository.findById(certificationLevelDTO.getId()).map(existingCertificationLevel -> { this.certificationLevelMapper.partialUpdate(existingCertificationLevel, certificationLevelDTO); return existingCertificationLevel; }).map(this.certificationLevelRepository::save).map(this.certificationLevelMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Page<CertificationLevelDTO> findAll(Pageable pageable) {
/* 71 */     this.log.debug("Request to get all CertificationLevels");
/* 72 */     Objects.requireNonNull(this.certificationLevelMapper); return this.certificationLevelRepository.findAll(pageable).map(this.certificationLevelMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Optional<CertificationLevelDTO> findOne(Long id) {
/* 78 */     this.log.debug("Request to get CertificationLevel : {}", id);
/* 79 */     Objects.requireNonNull(this.certificationLevelMapper); return this.certificationLevelRepository.findById(id).map(this.certificationLevelMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   public void delete(Long id) {
/* 84 */     this.log.debug("Request to delete CertificationLevel : {}", id);
/* 85 */     this.certificationLevelRepository.deleteById(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\CertificationLevelServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */