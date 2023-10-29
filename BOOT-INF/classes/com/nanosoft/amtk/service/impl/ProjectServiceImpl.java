/*    */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.Project;
/*    */ import com.nanosoft.amtk.repository.ProjectRepository;
/*    */ import com.nanosoft.amtk.service.ProjectService;
/*    */ import com.nanosoft.amtk.service.dto.ProjectDTO;
/*    */ import com.nanosoft.amtk.service.mapper.ProjectMapper;
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
/*    */ public class ProjectServiceImpl
/*    */   implements ProjectService
/*    */ {
/* 23 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.ProjectServiceImpl.class);
/*    */   
/*    */   private final ProjectRepository projectRepository;
/*    */   
/*    */   private final ProjectMapper projectMapper;
/*    */   
/*    */   public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
/* 30 */     this.projectRepository = projectRepository;
/* 31 */     this.projectMapper = projectMapper;
/*    */   }
/*    */ 
/*    */   
/*    */   public ProjectDTO save(ProjectDTO projectDTO) {
/* 36 */     this.log.debug("Request to save Project : {}", projectDTO);
/* 37 */     Project project = (Project)this.projectMapper.toEntity(projectDTO);
/* 38 */     project = (Project)this.projectRepository.save(project);
/* 39 */     return this.projectMapper.toDto(project);
/*    */   }
/*    */ 
/*    */   
/*    */   public ProjectDTO update(ProjectDTO projectDTO) {
/* 44 */     this.log.debug("Request to update Project : {}", projectDTO);
/* 45 */     Project project = (Project)this.projectMapper.toEntity(projectDTO);
/* 46 */     project = (Project)this.projectRepository.save(project);
/* 47 */     return this.projectMapper.toDto(project);
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<ProjectDTO> partialUpdate(ProjectDTO projectDTO) {
/* 52 */     this.log.debug("Request to partially update Project : {}", projectDTO);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 61 */     Objects.requireNonNull(this.projectRepository);
/* 62 */     Objects.requireNonNull(this.projectMapper); return this.projectRepository.findById(projectDTO.getId()).map(existingProject -> { this.projectMapper.partialUpdate(existingProject, projectDTO); return existingProject; }).map(this.projectRepository::save).map(this.projectMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Page<ProjectDTO> findAll(Pageable pageable) {
/* 68 */     this.log.debug("Request to get all Projects");
/* 69 */     Objects.requireNonNull(this.projectMapper); return this.projectRepository.findAll(pageable).map(this.projectMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Optional<ProjectDTO> findOne(Long id) {
/* 75 */     this.log.debug("Request to get Project : {}", id);
/* 76 */     Objects.requireNonNull(this.projectMapper); return this.projectRepository.findById(id).map(this.projectMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   public void delete(Long id) {
/* 81 */     this.log.debug("Request to delete Project : {}", id);
/* 82 */     this.projectRepository.deleteById(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\ProjectServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */