package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.TeamDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeamService {
  TeamDTO save(TeamDTO paramTeamDTO);
  
  TeamDTO update(TeamDTO paramTeamDTO);
  
  Optional<TeamDTO> partialUpdate(TeamDTO paramTeamDTO);
  
  Page<TeamDTO> findAll(Pageable paramPageable);
  
  Optional<TeamDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\TeamService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */