package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;

import com.nanosoft.amtk.domain.Assignment;
import com.nanosoft.amtk.domain.Certificate;
import com.nanosoft.amtk.domain.Employee;
import com.nanosoft.amtk.domain.Workstation;
import com.nanosoft.amtk.service.dto.AssignmentDTO;
import com.nanosoft.amtk.service.dto.CertificateDTO;
import com.nanosoft.amtk.service.dto.EmployeeDTO;
import com.nanosoft.amtk.service.dto.WorkstationDTO;
import com.nanosoft.amtk.service.mapper.EntityMapper;
import com.nanosoft.amtk.service.mapper.WorkstationMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {WorkstationMapper.class})
public interface AssignmentMapper extends EntityMapper<AssignmentDTO, Assignment> {
  @Mappings({@Mapping(target = "workstation", source = "workstation"), @Mapping(target = "employee", source = "employee", qualifiedByName = {"employeeId"}), @Mapping(target = "currentCertificate", source = "currentCertificate", qualifiedByName = {"certificateId"})})
  AssignmentDTO toDto(Assignment paramAssignment);
  
  @Named("certificateId")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  CertificateDTO toDtoCertificateId(Certificate paramCertificate);
  
  @Named("workstationId")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  WorkstationDTO toDtoWorkstationId(Workstation paramWorkstation);
  
  @Named("employeeId")
  @BeanMapping(ignoreByDefault = true)
  @Mappings({@Mapping(target = "id", source = "id"), @Mapping(target = "firstName", source = "firstName"), @Mapping(target = "lastName", source = "lastName"), @Mapping(target = "employeeNumber", source = "employeeNumber"), @Mapping(target = "title", source = "title")})
  EmployeeDTO toDtoEmployeeId(Employee paramEmployee);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\AssignmentMapper.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */