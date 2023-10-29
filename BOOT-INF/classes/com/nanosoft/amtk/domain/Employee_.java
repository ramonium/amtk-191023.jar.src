package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity_;
import com.nanosoft.amtk.domain.Assignment;
import com.nanosoft.amtk.domain.Attachment;
import com.nanosoft.amtk.domain.Employee;
import com.nanosoft.amtk.domain.EmployeeTitle;
import com.nanosoft.amtk.domain.Team;
import java.time.LocalDate;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Employee.class)
public abstract class Employee_ extends AbstractAuditingEntity_ {
  public static volatile SingularAttribute<Employee, LocalDate> birthday;
  
  public static volatile SingularAttribute<Employee, String> lastName;
  
  public static volatile SetAttribute<Employee, Attachment> attachments;
  
  public static volatile SetAttribute<Employee, Assignment> assignments;
  
  public static volatile SingularAttribute<Employee, String> gender;
  
  public static volatile SingularAttribute<Employee, LocalDate> joiningDate;
  
  public static volatile SingularAttribute<Employee, String> thirdName;
  
  public static volatile SingularAttribute<Employee, Team> team;
  
  public static volatile SingularAttribute<Employee, String> idNumber;
  
  public static volatile SingularAttribute<Employee, LocalDate> relievingDate;
  
  public static volatile SingularAttribute<Employee, EmployeeTitle> title;
  
  public static volatile SingularAttribute<Employee, String> employeeNumber;
  
  public static volatile SingularAttribute<Employee, String> firstName;
  
  public static volatile SingularAttribute<Employee, Long> id;
  
  public static volatile SetAttribute<Employee, Team> managedTeams;
  
  public static final String BIRTHDAY = "birthday";
  
  public static final String LAST_NAME = "lastName";
  
  public static final String ATTACHMENTS = "attachments";
  
  public static final String ASSIGNMENTS = "assignments";
  
  public static final String GENDER = "gender";
  
  public static final String JOINING_DATE = "joiningDate";
  
  public static final String THIRD_NAME = "thirdName";
  
  public static final String TEAM = "team";
  
  public static final String ID_NUMBER = "idNumber";
  
  public static final String RELIEVING_DATE = "relievingDate";
  
  public static final String TITLE = "title";
  
  public static final String EMPLOYEE_NUMBER = "employeeNumber";
  
  public static final String FIRST_NAME = "firstName";
  
  public static final String ID = "id";
  
  public static final String MANAGED_TEAMS = "managedTeams";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Employee_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */