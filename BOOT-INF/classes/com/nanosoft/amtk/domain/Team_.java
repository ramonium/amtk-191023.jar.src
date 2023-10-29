package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity_;
import com.nanosoft.amtk.domain.Employee;
import com.nanosoft.amtk.domain.Team;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Team.class)
public abstract class Team_ extends AbstractAuditingEntity_ {
  public static volatile SingularAttribute<Team, String> name;
  
  public static volatile SingularAttribute<Team, String> description;
  
  public static volatile SingularAttribute<Team, Long> id;
  
  public static volatile SetAttribute<Team, Employee> employees;
  
  public static volatile SingularAttribute<Team, Employee> supervisor;
  
  public static final String NAME = "name";
  
  public static final String DESCRIPTION = "description";
  
  public static final String ID = "id";
  
  public static final String EMPLOYEES = "employees";
  
  public static final String SUPERVISOR = "supervisor";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Team_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */