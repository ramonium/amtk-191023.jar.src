package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.WorkstationDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WorkstationService {
  WorkstationDTO save(WorkstationDTO paramWorkstationDTO);
  
  WorkstationDTO update(WorkstationDTO paramWorkstationDTO);
  
  Optional<WorkstationDTO> partialUpdate(WorkstationDTO paramWorkstationDTO);
  
  Page<WorkstationDTO> findAll(Pageable paramPageable);
  
  Page<WorkstationDTO> findAllWithEagerRelationships(Pageable paramPageable);
  
  Optional<WorkstationDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\WorkstationService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */