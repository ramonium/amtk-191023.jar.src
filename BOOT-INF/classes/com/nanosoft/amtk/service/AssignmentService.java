package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.AssignmentDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AssignmentService {
  AssignmentDTO save(AssignmentDTO paramAssignmentDTO);
  
  AssignmentDTO update(AssignmentDTO paramAssignmentDTO);
  
  Optional<AssignmentDTO> partialUpdate(AssignmentDTO paramAssignmentDTO);
  
  Page<AssignmentDTO> findAll(Pageable paramPageable);
  
  Optional<AssignmentDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\AssignmentService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */