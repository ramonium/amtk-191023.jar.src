package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.UserInfoDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserInfoService {
  UserInfoDTO save(UserInfoDTO paramUserInfoDTO);
  
  UserInfoDTO update(UserInfoDTO paramUserInfoDTO);
  
  Optional<UserInfoDTO> partialUpdate(UserInfoDTO paramUserInfoDTO);
  
  Page<UserInfoDTO> findAll(Pageable paramPageable);
  
  Optional<UserInfoDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\UserInfoService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */