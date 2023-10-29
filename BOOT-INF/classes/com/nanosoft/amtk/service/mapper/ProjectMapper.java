package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;

import com.nanosoft.amtk.domain.Project;
import com.nanosoft.amtk.domain.SkillsMatrix;
import com.nanosoft.amtk.service.dto.ProjectDTO;
import com.nanosoft.amtk.service.dto.SkillsMatrixDTO;
import com.nanosoft.amtk.service.mapper.EntityMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProjectMapper extends EntityMapper<ProjectDTO, Project> {
  @Mapping(target = "skillsMatrix", source = "skillsMatrix", qualifiedByName = {"skillsMatrixId"})
  ProjectDTO toDto(Project paramProject);
  
  @Named("skillsMatrixId")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  SkillsMatrixDTO toDtoSkillsMatrixId(SkillsMatrix paramSkillsMatrix);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\ProjectMapper.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */