package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity_;
import com.nanosoft.amtk.domain.Area;
import com.nanosoft.amtk.domain.Project;
import com.nanosoft.amtk.domain.Workstation;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Area.class)
public abstract class Area_ extends AbstractAuditingEntity_ {
  public static volatile SetAttribute<Area, Workstation> workstations;
  
  public static volatile SingularAttribute<Area, Integer> orderNumber;
  
  public static volatile SingularAttribute<Area, String> name;
  
  public static volatile SingularAttribute<Area, String> description;
  
  public static volatile SingularAttribute<Area, Project> project;
  
  public static volatile SingularAttribute<Area, Long> id;
  
  public static final String WORKSTATIONS = "workstations";
  
  public static final String ORDER_NUMBER = "orderNumber";
  
  public static final String NAME = "name";
  
  public static final String DESCRIPTION = "description";
  
  public static final String PROJECT = "project";
  
  public static final String ID = "id";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Area_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */