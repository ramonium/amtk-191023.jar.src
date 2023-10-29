package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;

import com.nanosoft.amtk.domain.CertificationLevel;
import com.nanosoft.amtk.domain.ChecklistModel;
import com.nanosoft.amtk.domain.Process;
import com.nanosoft.amtk.service.dto.CertificationLevelDTO;
import com.nanosoft.amtk.service.dto.ChecklistModelDTO;
import com.nanosoft.amtk.service.dto.ProcessDTO;
import com.nanosoft.amtk.service.mapper.EntityMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CertificationLevelMapper extends EntityMapper<CertificationLevelDTO, CertificationLevel> {
  @Mappings({@Mapping(target = "process", source = "process"), @Mapping(target = "checklistModel", source = "checklistModel")})
  CertificationLevelDTO toDto(CertificationLevel paramCertificationLevel);
  
  @Named("processId")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  ProcessDTO toDtoProcessId(Process paramProcess);
  
  @Named("checklistModelId")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  ChecklistModelDTO toDtoChecklistModelId(ChecklistModel paramChecklistModel);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\CertificationLevelMapper.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */