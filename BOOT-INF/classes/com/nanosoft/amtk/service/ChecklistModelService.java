package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.ChecklistModelDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChecklistModelService {
  ChecklistModelDTO save(ChecklistModelDTO paramChecklistModelDTO);
  
  ChecklistModelDTO update(ChecklistModelDTO paramChecklistModelDTO);
  
  Optional<ChecklistModelDTO> partialUpdate(ChecklistModelDTO paramChecklistModelDTO);
  
  Page<ChecklistModelDTO> findAll(Pageable paramPageable);
  
  Optional<ChecklistModelDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\ChecklistModelService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */