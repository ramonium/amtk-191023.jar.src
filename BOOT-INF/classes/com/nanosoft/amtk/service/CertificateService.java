package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.CertificateDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CertificateService {
  CertificateDTO save(CertificateDTO paramCertificateDTO);
  
  CertificateDTO update(CertificateDTO paramCertificateDTO);
  
  Optional<CertificateDTO> partialUpdate(CertificateDTO paramCertificateDTO);
  
  Page<CertificateDTO> findAll(Pageable paramPageable);
  
  List<CertificateDTO> findAllWhereForAssigmentIsNull();
  
  Optional<CertificateDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\CertificateService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */