package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;

import com.nanosoft.amtk.domain.Checklist;
import com.nanosoft.amtk.domain.ChecklistItem;
import com.nanosoft.amtk.service.dto.ChecklistDTO;
import com.nanosoft.amtk.service.dto.ChecklistItemDTO;
import com.nanosoft.amtk.service.mapper.EntityMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ChecklistItemMapper extends EntityMapper<ChecklistItemDTO, ChecklistItem> {
  ChecklistItemDTO toDto(ChecklistItem paramChecklistItem);
  
  @Named("checklistId")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  ChecklistDTO toDtoChecklistId(Checklist paramChecklist);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\ChecklistItemMapper.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */