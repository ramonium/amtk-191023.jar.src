package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.ProjectDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {
  ProjectDTO save(ProjectDTO paramProjectDTO);
  
  ProjectDTO update(ProjectDTO paramProjectDTO);
  
  Optional<ProjectDTO> partialUpdate(ProjectDTO paramProjectDTO);
  
  Page<ProjectDTO> findAll(Pageable paramPageable);
  
  Optional<ProjectDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\ProjectService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */