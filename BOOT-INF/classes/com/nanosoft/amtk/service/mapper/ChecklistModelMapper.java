package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;

import com.nanosoft.amtk.domain.ChecklistModel;
import com.nanosoft.amtk.service.dto.ChecklistModelDTO;
import com.nanosoft.amtk.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChecklistModelMapper extends EntityMapper<ChecklistModelDTO, ChecklistModel> {}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\ChecklistModelMapper.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */