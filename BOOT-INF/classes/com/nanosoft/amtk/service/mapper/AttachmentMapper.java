package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;

import com.nanosoft.amtk.domain.Attachment;
import com.nanosoft.amtk.domain.Content;
import com.nanosoft.amtk.domain.Employee;
import com.nanosoft.amtk.service.dto.AttachmentDTO;
import com.nanosoft.amtk.service.dto.ContentDTO;
import com.nanosoft.amtk.service.dto.EmployeeDTO;
import com.nanosoft.amtk.service.mapper.EntityMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AttachmentMapper extends EntityMapper<AttachmentDTO, Attachment> {
  @Mappings({@Mapping(target = "contentId", source = "content.id"), @Mapping(target = "content", ignore = true), @Mapping(target = "employee", source = "employee")})
  AttachmentDTO toDto(Attachment paramAttachment);
  
  @Named("contentId")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  ContentDTO toDtoContentId(Content paramContent);
  
  @Named("employeeId")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  EmployeeDTO toDtoEmployeeId(Employee paramEmployee);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\AttachmentMapper.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */