package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.EmployeeDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
  EmployeeDTO save(EmployeeDTO paramEmployeeDTO);
  
  EmployeeDTO update(EmployeeDTO paramEmployeeDTO);
  
  Optional<EmployeeDTO> partialUpdate(EmployeeDTO paramEmployeeDTO);
  
  Page<EmployeeDTO> findAll(Pageable paramPageable);
  
  Page<EmployeeDTO> findAllWithEagerRelationships(Pageable paramPageable);
  
  Optional<EmployeeDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\EmployeeService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */