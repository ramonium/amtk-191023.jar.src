package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.AreaDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AreaService {
  AreaDTO save(AreaDTO paramAreaDTO);
  
  AreaDTO update(AreaDTO paramAreaDTO);
  
  Optional<AreaDTO> partialUpdate(AreaDTO paramAreaDTO);
  
  Page<AreaDTO> findAll(Pageable paramPageable);
  
  Page<AreaDTO> findAllWithEagerRelationships(Pageable paramPageable);
  
  Optional<AreaDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\AreaService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */