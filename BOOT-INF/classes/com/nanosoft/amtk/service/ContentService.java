package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.service.dto.ContentDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContentService {
  ContentDTO save(ContentDTO paramContentDTO);
  
  ContentDTO update(ContentDTO paramContentDTO);
  
  Optional<ContentDTO> partialUpdate(ContentDTO paramContentDTO);
  
  Page<ContentDTO> findAll(Pageable paramPageable);
  
  List<ContentDTO> findAllWhereAttachmentIsNull();
  
  Optional<ContentDTO> findOne(Long paramLong);
  
  void delete(Long paramLong);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\ContentService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */