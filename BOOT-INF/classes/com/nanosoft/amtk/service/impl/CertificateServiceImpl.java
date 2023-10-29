/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Certificate;
/*     */ import com.nanosoft.amtk.repository.CertificateRepository;
/*     */ import com.nanosoft.amtk.service.CertificateService;
/*     */ import com.nanosoft.amtk.service.dto.CertificateDTO;
/*     */ import com.nanosoft.amtk.service.mapper.CertificateMapper;
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
/*     */ public class CertificateServiceImpl
/*     */   implements CertificateService
/*     */ {
/*  27 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.CertificateServiceImpl.class);
/*     */   
/*     */   private final CertificateRepository certificateRepository;
/*     */   
/*     */   private final CertificateMapper certificateMapper;
/*     */   
/*     */   public CertificateServiceImpl(CertificateRepository certificateRepository, CertificateMapper certificateMapper) {
/*  34 */     this.certificateRepository = certificateRepository;
/*  35 */     this.certificateMapper = certificateMapper;
/*     */   }
/*     */ 
/*     */   
/*     */   public CertificateDTO save(CertificateDTO certificateDTO) {
/*  40 */     this.log.debug("Request to save Certificate : {}", certificateDTO);
/*  41 */     Certificate certificate = (Certificate)this.certificateMapper.toEntity(certificateDTO);
/*  42 */     certificate = (Certificate)this.certificateRepository.save(certificate);
/*  43 */     return this.certificateMapper.toDto(certificate);
/*     */   }
/*     */ 
/*     */   
/*     */   public CertificateDTO update(CertificateDTO certificateDTO) {
/*  48 */     this.log.debug("Request to update Certificate : {}", certificateDTO);
/*  49 */     Certificate certificate = (Certificate)this.certificateMapper.toEntity(certificateDTO);
/*  50 */     certificate = (Certificate)this.certificateRepository.save(certificate);
/*  51 */     return this.certificateMapper.toDto(certificate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Optional<CertificateDTO> partialUpdate(CertificateDTO certificateDTO) {
/*  56 */     this.log.debug("Request to partially update Certificate : {}", certificateDTO);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     Objects.requireNonNull(this.certificateRepository);
/*  66 */     Objects.requireNonNull(this.certificateMapper); return this.certificateRepository.findById(certificateDTO.getId()).map(existingCertificate -> { this.certificateMapper.partialUpdate(existingCertificate, certificateDTO); return existingCertificate; }).map(this.certificateRepository::save).map(this.certificateMapper::toDto);
/*     */   }
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<CertificateDTO> findAll(Pageable pageable) {
/*  72 */     this.log.debug("Request to get all Certificates");
/*  73 */     Objects.requireNonNull(this.certificateMapper); return this.certificateRepository.findAll(pageable).map(this.certificateMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<CertificateDTO> findAllWhereForAssigmentIsNull() {
/*  82 */     this.log.debug("Request to get all certificates where ForAssigment is null");
/*     */ 
/*     */ 
/*     */     
/*  86 */     Objects.requireNonNull(this.certificateMapper); return (List<CertificateDTO>)StreamSupport.stream(this.certificateRepository.findAll().spliterator(), false).filter(certificate -> (certificate.getForAssigment() == null)).map(this.certificateMapper::toDto)
/*  87 */       .collect(Collectors.toCollection(java.util.LinkedList::new));
/*     */   }
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Optional<CertificateDTO> findOne(Long id) {
/*  93 */     this.log.debug("Request to get Certificate : {}", id);
/*  94 */     Objects.requireNonNull(this.certificateMapper); return this.certificateRepository.findById(id).map(this.certificateMapper::toDto);
/*     */   }
/*     */ 
/*     */   
/*     */   public void delete(Long id) {
/*  99 */     this.log.debug("Request to delete Certificate : {}", id);
/* 100 */     this.certificateRepository.deleteById(id);
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\CertificateServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */