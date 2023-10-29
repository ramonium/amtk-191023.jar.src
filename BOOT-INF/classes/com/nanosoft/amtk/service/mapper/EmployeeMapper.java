package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;

import com.nanosoft.amtk.domain.Employee;
import com.nanosoft.amtk.domain.EmployeeTitle;
import com.nanosoft.amtk.domain.Team;
import com.nanosoft.amtk.service.dto.EmployeeDTO;
import com.nanosoft.amtk.service.dto.EmployeeTitleDTO;
import com.nanosoft.amtk.service.dto.TeamDTO;
import com.nanosoft.amtk.service.mapper.EntityMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends EntityMapper<EmployeeDTO, Employee> {
  @Mappings({@Mapping(target = "title", source = "title", qualifiedByName = {"employeeTitleName"}), @Mapping(target = "team", source = "team", qualifiedByName = {"teamName"})})
  EmployeeDTO toDto(Employee paramEmployee);
  
  @Named("employeeTitleName")
  @BeanMapping(ignoreByDefault = true)
  @Mappings({@Mapping(target = "id", source = "id"), @Mapping(target = "name", source = "name")})
  EmployeeTitleDTO toDtoEmployeeTitleName(EmployeeTitle paramEmployeeTitle);
  
  @Named("teamName")
  @BeanMapping(ignoreByDefault = true)
  @Mappings({@Mapping(target = "id", source = "id"), @Mapping(target = "name", source = "name")})
  TeamDTO toDtoTeamName(Team paramTeam);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\EmployeeMapper.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */