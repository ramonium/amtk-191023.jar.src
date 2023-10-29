package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;

import com.nanosoft.amtk.domain.Content;
import com.nanosoft.amtk.service.dto.ContentDTO;
import com.nanosoft.amtk.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContentMapper extends EntityMapper<ContentDTO, Content> {}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\ContentMapper.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */