package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;

import com.nanosoft.amtk.domain.Assignment;
import com.nanosoft.amtk.domain.Certificate;
import com.nanosoft.amtk.domain.CertificationLevel;
import com.nanosoft.amtk.domain.Checklist;
import com.nanosoft.amtk.domain.Employee;
import com.nanosoft.amtk.service.dto.AssignmentDTO;
import com.nanosoft.amtk.service.dto.CertificateDTO;
import com.nanosoft.amtk.service.dto.CertificationLevelDTO;
import com.nanosoft.amtk.service.dto.ChecklistDTO;
import com.nanosoft.amtk.service.dto.EmployeeDTO;
import com.nanosoft.amtk.service.mapper.EntityMapper;
import com.nanosoft.amtk.service.mapper.WorkstationMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {WorkstationMapper.class})
public interface CertificateMapper extends EntityMapper<CertificateDTO, Certificate> {
  @Mappings({@Mapping(target = "assignment", source = "assignment", qualifiedByName = {"assignmentId"}), @Mapping(target = "level", source = "level"), @Mapping(target = "checklist", source = "checklist")})
  CertificateDTO toDto(Certificate paramCertificate);
  
  @Named("assignmentId")
  @BeanMapping(ignoreByDefault = true)
  @Mappings({@Mapping(target = "id", source = "id"), @Mapping(target = "assignmentStart", source = "assignmentStart"), @Mapping(target = "workstation", source = "workstation"), @Mapping(target = "employee", source = "employee", qualifiedByName = {"employeeId"})})
  AssignmentDTO toDtoAssignmentId(Assignment paramAssignment);
  
  @Named("employeeId")
  @BeanMapping(ignoreByDefault = true)
  @Mappings({@Mapping(target = "id", source = "id"), @Mapping(target = "firstName", source = "firstName"), @Mapping(target = "lastName", source = "lastName"), @Mapping(target = "employeeNumber", source = "employeeNumber"), @Mapping(target = "title", source = "title")})
  EmployeeDTO toDtoEmployeeId(Employee paramEmployee);
  
  @Named("certificationLevelId")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  CertificationLevelDTO toDtoCertificationLevelId(CertificationLevel paramCertificationLevel);
  
  @Named("checklistId")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  ChecklistDTO toDtoChecklistId(Checklist paramChecklist);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\CertificateMapper.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */