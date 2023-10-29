package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity_;
import com.nanosoft.amtk.domain.Employee;
import com.nanosoft.amtk.domain.EmployeeTitle;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(EmployeeTitle.class)
public abstract class EmployeeTitle_ extends AbstractAuditingEntity_ {
  public static volatile SingularAttribute<EmployeeTitle, Boolean> canSupervise;
  
  public static volatile SingularAttribute<EmployeeTitle, String> name;
  
  public static volatile SingularAttribute<EmployeeTitle, String> description;
  
  public static volatile SingularAttribute<EmployeeTitle, Long> id;
  
  public static volatile SetAttribute<EmployeeTitle, Employee> employees;
  
  public static final String CAN_SUPERVISE = "canSupervise";
  
  public static final String NAME = "name";
  
  public static final String DESCRIPTION = "description";
  
  public static final String ID = "id";
  
  public static final String EMPLOYEES = "employees";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\EmployeeTitle_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */