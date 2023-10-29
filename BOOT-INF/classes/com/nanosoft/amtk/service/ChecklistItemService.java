package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.ChecklistItemDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChecklistItemService {
  ChecklistItemDTO save(ChecklistItemDTO paramChecklistItemDTO);
  
  ChecklistItemDTO update(ChecklistItemDTO paramChecklistItemDTO);
  
  Optional<ChecklistItemDTO> partialUpdate(ChecklistItemDTO paramChecklistItemDTO);
  
  Page<ChecklistItemDTO> findAll(Pageable paramPageable);
  
  Optional<ChecklistItemDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\ChecklistItemService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */