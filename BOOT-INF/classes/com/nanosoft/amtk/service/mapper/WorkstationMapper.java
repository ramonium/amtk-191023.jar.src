package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;

import com.nanosoft.amtk.domain.Area;
import com.nanosoft.amtk.domain.Process;
import com.nanosoft.amtk.domain.Workstation;
import com.nanosoft.amtk.service.dto.AreaDTO;
import com.nanosoft.amtk.service.dto.ProcessDTO;
import com.nanosoft.amtk.service.dto.WorkstationDTO;
import com.nanosoft.amtk.service.mapper.AreaMapper;
import com.nanosoft.amtk.service.mapper.EntityMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {AreaMapper.class})
public interface WorkstationMapper extends EntityMapper<WorkstationDTO, Workstation> {
  @Mappings({@Mapping(target = "area", source = "area"), @Mapping(target = "process", source = "process")})
  WorkstationDTO toDto(Workstation paramWorkstation);
  
  @Named("areaName")
  @BeanMapping(ignoreByDefault = true)
  @Mappings({@Mapping(target = "id", source = "id"), @Mapping(target = "name", source = "name")})
  AreaDTO toDtoAreaName(Area paramArea);
  
  @Named("processName")
  @BeanMapping(ignoreByDefault = true)
  @Mappings({@Mapping(target = "id", source = "id"), @Mapping(target = "name", source = "name")})
  ProcessDTO toDtoProcessName(Process paramProcess);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\WorkstationMapper.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */