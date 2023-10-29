package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;

import com.nanosoft.amtk.domain.ChecklistModel;
import com.nanosoft.amtk.domain.ChecklistModelItem;
import com.nanosoft.amtk.service.dto.ChecklistModelDTO;
import com.nanosoft.amtk.service.dto.ChecklistModelItemDTO;
import com.nanosoft.amtk.service.mapper.EntityMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ChecklistModelItemMapper extends EntityMapper<ChecklistModelItemDTO, ChecklistModelItem> {
  @Mapping(target = "checklistModel", source = "checklistModel")
  ChecklistModelItemDTO toDto(ChecklistModelItem paramChecklistModelItem);
  
  @Named("checklistModelId")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  ChecklistModelDTO toDtoChecklistModelId(ChecklistModel paramChecklistModel);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\ChecklistModelItemMapper.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */