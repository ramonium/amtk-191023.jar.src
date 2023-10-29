package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.CertificationLevelDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CertificationLevelService {
  CertificationLevelDTO save(CertificationLevelDTO paramCertificationLevelDTO);
  
  CertificationLevelDTO update(CertificationLevelDTO paramCertificationLevelDTO);
  
  Optional<CertificationLevelDTO> partialUpdate(CertificationLevelDTO paramCertificationLevelDTO);
  
  Page<CertificationLevelDTO> findAll(Pageable paramPageable);
  
  Optional<CertificationLevelDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\CertificationLevelService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */