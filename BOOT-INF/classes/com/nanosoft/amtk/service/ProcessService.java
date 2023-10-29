package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.ProcessDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProcessService {
  ProcessDTO save(ProcessDTO paramProcessDTO);
  
  ProcessDTO update(ProcessDTO paramProcessDTO);
  
  Optional<ProcessDTO> partialUpdate(ProcessDTO paramProcessDTO);
  
  Page<ProcessDTO> findAll(Pageable paramPageable);
  
  Optional<ProcessDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\ProcessService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */