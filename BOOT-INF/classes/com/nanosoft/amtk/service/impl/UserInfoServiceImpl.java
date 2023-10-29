/*    */ package BOOT-INF.classes.com.nanosoft.amtk.service.impl;
/*    */ 
/*    */ import com.nanosoft.amtk.domain.UserInfo;
/*    */ import com.nanosoft.amtk.repository.UserInfoRepository;
/*    */ import com.nanosoft.amtk.service.UserInfoService;
/*    */ import com.nanosoft.amtk.service.dto.UserInfoDTO;
/*    */ import com.nanosoft.amtk.service.mapper.UserInfoMapper;
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
/*    */ public class UserInfoServiceImpl
/*    */   implements UserInfoService
/*    */ {
/* 23 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.impl.UserInfoServiceImpl.class);
/*    */   
/*    */   private final UserInfoRepository userInfoRepository;
/*    */   
/*    */   private final UserInfoMapper userInfoMapper;
/*    */   
/*    */   public UserInfoServiceImpl(UserInfoRepository userInfoRepository, UserInfoMapper userInfoMapper) {
/* 30 */     this.userInfoRepository = userInfoRepository;
/* 31 */     this.userInfoMapper = userInfoMapper;
/*    */   }
/*    */ 
/*    */   
/*    */   public UserInfoDTO save(UserInfoDTO userInfoDTO) {
/* 36 */     this.log.debug("Request to save UserInfo : {}", userInfoDTO);
/* 37 */     UserInfo userInfo = (UserInfo)this.userInfoMapper.toEntity(userInfoDTO);
/* 38 */     userInfo = (UserInfo)this.userInfoRepository.save(userInfo);
/* 39 */     return this.userInfoMapper.toDto(userInfo);
/*    */   }
/*    */ 
/*    */   
/*    */   public UserInfoDTO update(UserInfoDTO userInfoDTO) {
/* 44 */     this.log.debug("Request to update UserInfo : {}", userInfoDTO);
/* 45 */     UserInfo userInfo = (UserInfo)this.userInfoMapper.toEntity(userInfoDTO);
/* 46 */     userInfo = (UserInfo)this.userInfoRepository.save(userInfo);
/* 47 */     return this.userInfoMapper.toDto(userInfo);
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<UserInfoDTO> partialUpdate(UserInfoDTO userInfoDTO) {
/* 52 */     this.log.debug("Request to partially update UserInfo : {}", userInfoDTO);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 61 */     Objects.requireNonNull(this.userInfoRepository);
/* 62 */     Objects.requireNonNull(this.userInfoMapper); return this.userInfoRepository.findById(userInfoDTO.getId()).map(existingUserInfo -> { this.userInfoMapper.partialUpdate(existingUserInfo, userInfoDTO); return existingUserInfo; }).map(this.userInfoRepository::save).map(this.userInfoMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Page<UserInfoDTO> findAll(Pageable pageable) {
/* 68 */     this.log.debug("Request to get all UserInfos");
/* 69 */     Objects.requireNonNull(this.userInfoMapper); return this.userInfoRepository.findAll(pageable).map(this.userInfoMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(readOnly = true)
/*    */   public Optional<UserInfoDTO> findOne(Long id) {
/* 75 */     this.log.debug("Request to get UserInfo : {}", id);
/* 76 */     Objects.requireNonNull(this.userInfoMapper); return this.userInfoRepository.findById(id).map(this.userInfoMapper::toDto);
/*    */   }
/*    */ 
/*    */   
/*    */   public void delete(Long id) {
/* 81 */     this.log.debug("Request to delete UserInfo : {}", id);
/* 82 */     this.userInfoRepository.deleteById(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\impl\UserInfoServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */