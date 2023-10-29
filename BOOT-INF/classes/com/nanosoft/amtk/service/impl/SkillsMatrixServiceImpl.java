/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.SkillsMatrix;
/*     */ import com.nanosoft.amtk.repository.SkillsMatrixRepository;
/*     */ import com.nanosoft.amtk.service.SkillsMatrixService;
/*     */ import com.nanosoft.amtk.service.dto.SkillsMatrixDTO;
/*     */ import com.nanosoft.amtk.service.mapper.SkillsMatrixMapper;
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
/*     */ public class SkillsMatrixServiceImpl
/*     */   implements SkillsMatrixService
/*     */ {
/*  27 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.SkillsMatrixServiceImpl.class);
/*     */   
/*     */   private final SkillsMatrixRepository skillsMatrixRepository;
/*     */   
/*     */   private final SkillsMatrixMapper skillsMatrixMapper;
/*     */   
/*     */   public SkillsMatrixServiceImpl(SkillsMatrixRepository skillsMatrixRepository, SkillsMatrixMapper skillsMatrixMapper) {
/*  34 */     this.skillsMatrixRepository = skillsMatrixRepository;
/*  35 */     this.skillsMatrixMapper = skillsMatrixMapper;
/*     */   }
/*     */ 
/*     */   
/*     */   public SkillsMatrixDTO save(SkillsMatrixDTO skillsMatrixDTO) {
/*  40 */     this.log.debug("Request to save SkillsMatrix : {}", skillsMatrixDTO);
/*  41 */     SkillsMatrix skillsMatrix = (SkillsMatrix)this.skillsMatrixMapper.toEntity(skillsMatrixDTO);
/*  42 */     skillsMatrix = (SkillsMatrix)this.skillsMatrixRepository.save(skillsMatrix);
/*  43 */     return this.skillsMatrixMapper.toDto(skillsMatrix);
/*     */   }
/*     */ 
/*     */   
/*     */   public SkillsMatrixDTO update(SkillsMatrixDTO skillsMatrixDTO) {
/*  48 */     this.log.debug("Request to update SkillsMatrix : {}", skillsMatrixDTO);
/*  49 */     SkillsMatrix skillsMatrix = (SkillsMatrix)this.skillsMatrixMapper.toEntity(skillsMatrixDTO);
/*  50 */     skillsMatrix = (SkillsMatrix)this.skillsMatrixRepository.save(skillsMatrix);
/*  51 */     return this.skillsMatrixMapper.toDto(skillsMatrix);
/*     */   }
/*     */ 
/*     */   
/*     */   public Optional<SkillsMatrixDTO> partialUpdate(SkillsMatrixDTO skillsMatrixDTO) {
/*  56 */     this.log.debug("Request to partially update SkillsMatrix : {}", skillsMatrixDTO);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     Objects.requireNonNull(this.skillsMatrixRepository);
/*  66 */     Objects.requireNonNull(this.skillsMatrixMapper); return this.skillsMatrixRepository.findById(skillsMatrixDTO.getId()).map(existingSkillsMatrix -> { this.skillsMatrixMapper.partialUpdate(existingSkillsMatrix, skillsMatrixDTO); return existingSkillsMatrix; }).map(this.skillsMatrixRepository::save).map(this.skillsMatrixMapper::toDto);
/*     */   }
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<SkillsMatrixDTO> findAll(Pageable pageable) {
/*  72 */     this.log.debug("Request to get all SkillsMatrices");
/*  73 */     Objects.requireNonNull(this.skillsMatrixMapper); return this.skillsMatrixRepository.findAll(pageable).map(this.skillsMatrixMapper::toDto);
/*     */   }
/*     */   
/*     */   public Page<SkillsMatrixDTO> findAllWithEagerRelationships(Pageable pageable) {
/*  77 */     Objects.requireNonNull(this.skillsMatrixMapper); return this.skillsMatrixRepository.findAllWithEagerRelationships(pageable).map(this.skillsMatrixMapper::toDto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<SkillsMatrixDTO> findAllWhereForProjectIsNull() {
/*  86 */     this.log.debug("Request to get all skillsMatrices where ForProject is null");
/*     */ 
/*     */ 
/*     */     
/*  90 */     Objects.requireNonNull(this.skillsMatrixMapper); return (List<SkillsMatrixDTO>)StreamSupport.stream(this.skillsMatrixRepository.findAll().spliterator(), false).filter(skillsMatrix -> (skillsMatrix.getForProject() == null)).map(this.skillsMatrixMapper::toDto)
/*  91 */       .collect(Collectors.toCollection(java.util.LinkedList::new));
/*     */   }
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Optional<SkillsMatrixDTO> findOne(Long id) {
/*  97 */     this.log.debug("Request to get SkillsMatrix : {}", id);
/*  98 */     Objects.requireNonNull(this.skillsMatrixMapper); return this.skillsMatrixRepository.findOneWithEagerRelationships(id).map(this.skillsMatrixMapper::toDto);
/*     */   }
/*     */ 
/*     */   
/*     */   public void delete(Long id) {
/* 103 */     this.log.debug("Request to delete SkillsMatrix : {}", id);
/* 104 */     this.skillsMatrixRepository.deleteById(id);
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\SkillsMatrixServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */