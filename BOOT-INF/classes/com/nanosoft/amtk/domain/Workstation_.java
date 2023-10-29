package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity_;
import com.nanosoft.amtk.domain.Area;
import com.nanosoft.amtk.domain.Assignment;
import com.nanosoft.amtk.domain.Process;
import com.nanosoft.amtk.domain.Workstation;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Workstation.class)
public abstract class Workstation_ extends AbstractAuditingEntity_ {
  public static volatile SingularAttribute<Workstation, Area> area;
  
  public static volatile SingularAttribute<Workstation, Process> process;
  
  public static volatile SingularAttribute<Workstation, Integer> orderNumber;
  
  public static volatile SetAttribute<Workstation, Assignment> assignments;
  
  public static volatile SingularAttribute<Workstation, String> name;
  
  public static volatile SingularAttribute<Workstation, String> description;
  
  public static volatile SingularAttribute<Workstation, Long> id;
  
  public static final String AREA = "area";
  
  public static final String PROCESS = "process";
  
  public static final String ORDER_NUMBER = "orderNumber";
  
  public static final String ASSIGNMENTS = "assignments";
  
  public static final String NAME = "name";
  
  public static final String DESCRIPTION = "description";
  
  public static final String ID = "id";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Workstation_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */