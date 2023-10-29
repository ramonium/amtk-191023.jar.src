package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;

import com.nanosoft.amtk.domain.Employee;
import com.nanosoft.amtk.domain.User;
import com.nanosoft.amtk.domain.UserInfo;
import com.nanosoft.amtk.service.dto.EmployeeDTO;
import com.nanosoft.amtk.service.dto.UserDTO;
import com.nanosoft.amtk.service.dto.UserInfoDTO;
import com.nanosoft.amtk.service.mapper.EntityMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserInfoMapper extends EntityMapper<UserInfoDTO, UserInfo> {
  @Mappings({@Mapping(target = "user", source = "user"), @Mapping(target = "relatedEmployee", source = "relatedEmployee", qualifiedByName = {"employeeId"})})
  UserInfoDTO toDto(UserInfo paramUserInfo);
  
  @Named("userId")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  UserDTO toDtoUserId(User paramUser);
  
  @Named("employeeId")
  @BeanMapping(ignoreByDefault = true)
  @Mappings({@Mapping(target = "id", source = "id"), @Mapping(target = "firstName", source = "firstName"), @Mapping(target = "lastName", source = "lastName"), @Mapping(target = "employeeNumber", source = "employeeNumber"), @Mapping(target = "title", source = "title")})
  EmployeeDTO toDtoEmployeeId(Employee paramEmployee);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\UserInfoMapper.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */