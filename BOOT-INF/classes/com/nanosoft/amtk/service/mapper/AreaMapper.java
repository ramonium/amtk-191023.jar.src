package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;

import com.nanosoft.amtk.domain.Area;
import com.nanosoft.amtk.domain.Project;
import com.nanosoft.amtk.service.dto.AreaDTO;
import com.nanosoft.amtk.service.dto.ProjectDTO;
import com.nanosoft.amtk.service.mapper.EntityMapper;
import com.nanosoft.amtk.service.mapper.ProjectMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {ProjectMapper.class})
public interface AreaMapper extends EntityMapper<AreaDTO, Area> {
  @Mapping(target = "project", source = "project")
  AreaDTO toDto(Area paramArea);
  
  @Named("projectName")
  @BeanMapping(ignoreByDefault = true)
  @Mappings({@Mapping(target = "id", source = "id"), @Mapping(target = "name", source = "name")})
  ProjectDTO toDtoProjectName(Project paramProject);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\AreaMapper.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */