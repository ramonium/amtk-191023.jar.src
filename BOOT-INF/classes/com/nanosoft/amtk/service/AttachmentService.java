package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.AttachmentDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AttachmentService {
  AttachmentDTO save(AttachmentDTO paramAttachmentDTO);
  
  AttachmentDTO update(AttachmentDTO paramAttachmentDTO);
  
  Optional<AttachmentDTO> partialUpdate(AttachmentDTO paramAttachmentDTO);
  
  Page<AttachmentDTO> findAll(Pageable paramPageable);
  
  Optional<AttachmentDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\AttachmentService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */