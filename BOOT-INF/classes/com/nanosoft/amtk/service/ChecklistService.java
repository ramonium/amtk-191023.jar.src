package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.ChecklistDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChecklistService {
  ChecklistDTO save(ChecklistDTO paramChecklistDTO);
  
  ChecklistDTO update(ChecklistDTO paramChecklistDTO);
  
  Optional<ChecklistDTO> partialUpdate(ChecklistDTO paramChecklistDTO);
  
  Page<ChecklistDTO> findAll(Pageable paramPageable);
  
  List<ChecklistDTO> findAllWhereCertificateIsNull();
  
  Optional<ChecklistDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\ChecklistService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */