package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.EmployeeTitleDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeTitleService {
  EmployeeTitleDTO save(EmployeeTitleDTO paramEmployeeTitleDTO);
  
  EmployeeTitleDTO update(EmployeeTitleDTO paramEmployeeTitleDTO);
  
  Optional<EmployeeTitleDTO> partialUpdate(EmployeeTitleDTO paramEmployeeTitleDTO);
  
  Page<EmployeeTitleDTO> findAll(Pageable paramPageable);
  
  Optional<EmployeeTitleDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\EmployeeTitleService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */