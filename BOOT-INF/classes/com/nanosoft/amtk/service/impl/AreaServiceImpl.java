/*    */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.Area;
/*    */ import com.nanosoft.amtk.repository.AreaRepository;
/*    */ import com.nanosoft.amtk.service.AreaService;
/*    */ import com.nanosoft.amtk.service.dto.AreaDTO;
/*    */ import com.nanosoft.amtk.service.mapper.AreaMapper;
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
/*    */ public class AreaServiceImpl
/*    */   implements AreaService
/*    */ {
/* 23 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.AreaServiceImpl.class);
/*    */   
/*    */   private final AreaRepository areaRepository;
/*    */   
/*    */   private final AreaMapper areaMapper;
/*    */   
/*    */   public AreaServiceImpl(AreaRepository areaRepository, AreaMapper areaMapper) {
/* 30 */     this.areaRepository = areaRepository;
/* 31 */     this.areaMapper = areaMapper;
/*    */   }
/*    */ 
/*    */   
/*    */   public AreaDTO save(AreaDTO areaDTO) {
/* 36 */     this.log.debug("Request to save Area : {}", areaDTO);
/* 37 */     Area area = (Area)this.areaMapper.toEntity(areaDTO);
/* 38 */     area = (Area)this.areaRepository.save(area);
/* 39 */     return this.areaMapper.toDto(area);
/*    */   }
/*    */ 
/*    */   
/*    */   public AreaDTO update(AreaDTO areaDTO) {
/* 44 */     this.log.debug("Request to update Area : {}", areaDTO);
/* 45 */     Area area = (Area)this.areaMapper.toEntity(areaDTO);
/* 46 */     area = (Area)this.areaRepository.save(area);
/* 47 */     return this.areaMapper.toDto(area);
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<AreaDTO> partialUpdate(AreaDTO areaDTO) {
/* 52 */     this.log.debug("Request to partially update Area : {}", areaDTO);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 61 */     Objects.requireNonNull(this.areaRepository);
/* 62 */     Objects.requireNonNull(this.areaMapper); return this.areaRepository.findById(areaDTO.getId()).map(existingArea -> { this.areaMapper.partialUpdate(existingArea, areaDTO); return existingArea; }).map(this.areaRepository::save).map(this.areaMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Page<AreaDTO> findAll(Pageable pageable) {
/* 68 */     this.log.debug("Request to get all Areas");
/* 69 */     Objects.requireNonNull(this.areaMapper); return this.areaRepository.findAll(pageable).map(this.areaMapper::toDto);
/*    */   }
/*    */   
/*    */   public Page<AreaDTO> findAllWithEagerRelationships(Pageable pageable) {
/* 73 */     Objects.requireNonNull(this.areaMapper); return this.areaRepository.findAllWithEagerRelationships(pageable).map(this.areaMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Optional<AreaDTO> findOne(Long id) {
/* 79 */     this.log.debug("Request to get Area : {}", id);
/* 80 */     Objects.requireNonNull(this.areaMapper); return this.areaRepository.findOneWithEagerRelationships(id).map(this.areaMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   public void delete(Long id) {
/* 85 */     this.log.debug("Request to delete Area : {}", id);
/* 86 */     this.areaRepository.deleteById(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\AreaServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */