package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity_;
import com.nanosoft.amtk.domain.Certificate;
import com.nanosoft.amtk.domain.CertificationLevel;
import com.nanosoft.amtk.domain.ChecklistModel;
import com.nanosoft.amtk.domain.Process;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(CertificationLevel.class)
public abstract class CertificationLevel_ extends AbstractAuditingEntity_ {
  public static volatile SingularAttribute<CertificationLevel, ChecklistModel> checklistModel;
  
  public static volatile SingularAttribute<CertificationLevel, Process> process;
  
  public static volatile SingularAttribute<CertificationLevel, Integer> orderNumber;
  
  public static volatile SingularAttribute<CertificationLevel, String> trainingDuration;
  
  public static volatile SingularAttribute<CertificationLevel, String> recyclingPeriod;
  
  public static volatile SetAttribute<CertificationLevel, Certificate> certificates;
  
  public static volatile SingularAttribute<CertificationLevel, String> level;
  
  public static volatile SingularAttribute<CertificationLevel, String> description;
  
  public static volatile SingularAttribute<CertificationLevel, Long> id;
  
  public static final String CHECKLIST_MODEL = "checklistModel";
  
  public static final String PROCESS = "process";
  
  public static final String ORDER_NUMBER = "orderNumber";
  
  public static final String TRAINING_DURATION = "trainingDuration";
  
  public static final String RECYCLING_PERIOD = "recyclingPeriod";
  
  public static final String CERTIFICATES = "certificates";
  
  public static final String LEVEL = "level";
  
  public static final String DESCRIPTION = "description";
  
  public static final String ID = "id";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\CertificationLevel_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */