/*    */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.Team;
/*    */ import com.nanosoft.amtk.repository.TeamRepository;
/*    */ import com.nanosoft.amtk.service.TeamService;
/*    */ import com.nanosoft.amtk.service.dto.TeamDTO;
/*    */ import com.nanosoft.amtk.service.mapper.TeamMapper;
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
/*    */ public class TeamServiceImpl
/*    */   implements TeamService
/*    */ {
/* 23 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.TeamServiceImpl.class);
/*    */   
/*    */   private final TeamRepository teamRepository;
/*    */   
/*    */   private final TeamMapper teamMapper;
/*    */   
/*    */   public TeamServiceImpl(TeamRepository teamRepository, TeamMapper teamMapper) {
/* 30 */     this.teamRepository = teamRepository;
/* 31 */     this.teamMapper = teamMapper;
/*    */   }
/*    */ 
/*    */   
/*    */   public TeamDTO save(TeamDTO teamDTO) {
/* 36 */     this.log.debug("Request to save Team : {}", teamDTO);
/* 37 */     Team team = (Team)this.teamMapper.toEntity(teamDTO);
/* 38 */     team = (Team)this.teamRepository.save(team);
/* 39 */     return this.teamMapper.toDto(team);
/*    */   }
/*    */ 
/*    */   
/*    */   public TeamDTO update(TeamDTO teamDTO) {
/* 44 */     this.log.debug("Request to update Team : {}", teamDTO);
/* 45 */     Team team = (Team)this.teamMapper.toEntity(teamDTO);
/* 46 */     team = (Team)this.teamRepository.save(team);
/* 47 */     return this.teamMapper.toDto(team);
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<TeamDTO> partialUpdate(TeamDTO teamDTO) {
/* 52 */     this.log.debug("Request to partially update Team : {}", teamDTO);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 61 */     Objects.requireNonNull(this.teamRepository);
/* 62 */     Objects.requireNonNull(this.teamMapper); return this.teamRepository.findById(teamDTO.getId()).map(existingTeam -> { this.teamMapper.partialUpdate(existingTeam, teamDTO); return existingTeam; }).map(this.teamRepository::save).map(this.teamMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Page<TeamDTO> findAll(Pageable pageable) {
/* 68 */     this.log.debug("Request to get all Teams");
/* 69 */     Objects.requireNonNull(this.teamMapper); return this.teamRepository.findAll(pageable).map(this.teamMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Optional<TeamDTO> findOne(Long id) {
/* 75 */     this.log.debug("Request to get Team : {}", id);
/* 76 */     Objects.requireNonNull(this.teamMapper); return this.teamRepository.findById(id).map(this.teamMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   public void delete(Long id) {
/* 81 */     this.log.debug("Request to delete Team : {}", id);
/* 82 */     this.teamRepository.deleteById(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\TeamServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */