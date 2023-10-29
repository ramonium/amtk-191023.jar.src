package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.SkillsMatrixDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SkillsMatrixService {
  SkillsMatrixDTO save(SkillsMatrixDTO paramSkillsMatrixDTO);
  
  SkillsMatrixDTO update(SkillsMatrixDTO paramSkillsMatrixDTO);
  
  Optional<SkillsMatrixDTO> partialUpdate(SkillsMatrixDTO paramSkillsMatrixDTO);
  
  Page<SkillsMatrixDTO> findAll(Pageable paramPageable);
  
  List<SkillsMatrixDTO> findAllWhereForProjectIsNull();
  
  Page<SkillsMatrixDTO> findAllWithEagerRelationships(Pageable paramPageable);
  
  Optional<SkillsMatrixDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\SkillsMatrixService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */