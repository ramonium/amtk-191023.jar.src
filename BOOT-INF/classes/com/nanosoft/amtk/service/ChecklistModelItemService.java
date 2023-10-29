package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.ChecklistModelItemDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChecklistModelItemService {
  ChecklistModelItemDTO save(ChecklistModelItemDTO paramChecklistModelItemDTO);
  
  ChecklistModelItemDTO update(ChecklistModelItemDTO paramChecklistModelItemDTO);
  
  Optional<ChecklistModelItemDTO> partialUpdate(ChecklistModelItemDTO paramChecklistModelItemDTO);
  
  Page<ChecklistModelItemDTO> findAll(Pageable paramPageable);
  
  Optional<ChecklistModelItemDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\ChecklistModelItemService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */