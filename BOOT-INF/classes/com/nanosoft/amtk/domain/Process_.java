package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity_;
import com.nanosoft.amtk.domain.CertificationLevel;
import com.nanosoft.amtk.domain.Process;
import com.nanosoft.amtk.domain.Workstation;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Process.class)
public abstract class Process_ extends AbstractAuditingEntity_ {
  public static volatile SetAttribute<Process, Workstation> workstations;
  
  public static volatile SingularAttribute<Process, String> name;
  
  public static volatile SingularAttribute<Process, String> description;
  
  public static volatile SingularAttribute<Process, Long> id;
  
  public static volatile SetAttribute<Process, CertificationLevel> certificationLevels;
  
  public static final String WORKSTATIONS = "workstations";
  
  public static final String NAME = "name";
  
  public static final String DESCRIPTION = "description";
  
  public static final String ID = "id";
  
  public static final String CERTIFICATION_LEVELS = "certificationLevels";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Process_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */