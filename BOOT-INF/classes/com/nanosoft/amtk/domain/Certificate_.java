package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity_;
import com.nanosoft.amtk.domain.Assignment;
import com.nanosoft.amtk.domain.Certificate;
import com.nanosoft.amtk.domain.CertificationLevel;
import com.nanosoft.amtk.domain.Checklist;
import com.nanosoft.amtk.domain.enumeration.CertificationStatus;
import java.time.Instant;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Certificate.class)
public abstract class Certificate_ extends AbstractAuditingEntity_ {
  public static volatile SingularAttribute<Certificate, Boolean> isRecycling;
  
  public static volatile SingularAttribute<Certificate, Assignment> forAssigment;
  
  public static volatile SingularAttribute<Certificate, Instant> expectedEndDate;
  
  public static volatile SingularAttribute<Certificate, Boolean> validated;
  
  public static volatile SingularAttribute<Certificate, Instant> endDate;
  
  public static volatile SingularAttribute<Certificate, CertificationLevel> level;
  
  public static volatile SingularAttribute<Certificate, Assignment> assignment;
  
  public static volatile SingularAttribute<Certificate, Checklist> checklist;
  
  public static volatile SingularAttribute<Certificate, Long> id;
  
  public static volatile SingularAttribute<Certificate, Instant> startDate;
  
  public static volatile SingularAttribute<Certificate, CertificationStatus> status;
  
  public static final String IS_RECYCLING = "isRecycling";
  
  public static final String FOR_ASSIGMENT = "forAssigment";
  
  public static final String EXPECTED_END_DATE = "expectedEndDate";
  
  public static final String VALIDATED = "validated";
  
  public static final String END_DATE = "endDate";
  
  public static final String LEVEL = "level";
  
  public static final String ASSIGNMENT = "assignment";
  
  public static final String CHECKLIST = "checklist";
  
  public static final String ID = "id";
  
  public static final String START_DATE = "startDate";
  
  public static final String STATUS = "status";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Certificate_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */