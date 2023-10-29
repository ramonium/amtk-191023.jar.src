package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity_;
import com.nanosoft.amtk.domain.Assignment;
import com.nanosoft.amtk.domain.Certificate;
import com.nanosoft.amtk.domain.Employee;
import com.nanosoft.amtk.domain.Workstation;
import java.time.Instant;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Assignment.class)
public abstract class Assignment_ extends AbstractAuditingEntity_ {
  public static volatile SingularAttribute<Assignment, Instant> assignmentEnd;
  
  public static volatile SingularAttribute<Assignment, Certificate> currentCertificate;
  
  public static volatile SingularAttribute<Assignment, Instant> assignmentStart;
  
  public static volatile SetAttribute<Assignment, Certificate> certificates;
  
  public static volatile SingularAttribute<Assignment, String> description;
  
  public static volatile SingularAttribute<Assignment, Workstation> workstation;
  
  public static volatile SingularAttribute<Assignment, Long> id;
  
  public static volatile SingularAttribute<Assignment, Employee> employee;
  
  public static final String ASSIGNMENT_END = "assignmentEnd";
  
  public static final String CURRENT_CERTIFICATE = "currentCertificate";
  
  public static final String ASSIGNMENT_START = "assignmentStart";
  
  public static final String CERTIFICATES = "certificates";
  
  public static final String DESCRIPTION = "description";
  
  public static final String WORKSTATION = "workstation";
  
  public static final String ID = "id";
  
  public static final String EMPLOYEE = "employee";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Assignment_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */