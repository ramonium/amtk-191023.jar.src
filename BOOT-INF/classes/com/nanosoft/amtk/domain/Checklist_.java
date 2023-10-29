package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity_;
import com.nanosoft.amtk.domain.Certificate;
import com.nanosoft.amtk.domain.Checklist;
import com.nanosoft.amtk.domain.ChecklistItem;
import com.nanosoft.amtk.domain.ChecklistModel;
import com.nanosoft.amtk.domain.enumeration.ChecklistStatus;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Checklist.class)
public abstract class Checklist_ extends AbstractAuditingEntity_ {
  public static volatile SingularAttribute<Checklist, ChecklistModel> checklistModel;
  
  public static volatile SingularAttribute<Checklist, String> validator4;
  
  public static volatile SingularAttribute<Checklist, String> validator3;
  
  public static volatile SingularAttribute<Checklist, String> validator2;
  
  public static volatile SingularAttribute<Checklist, Boolean> validator4Check;
  
  public static volatile SingularAttribute<Checklist, String> validator;
  
  public static volatile SingularAttribute<Checklist, Certificate> certificate;
  
  public static volatile SingularAttribute<Checklist, String> description;
  
  public static volatile SingularAttribute<Checklist, Boolean> validator3Check;
  
  public static volatile SingularAttribute<Checklist, String> title;
  
  public static volatile SingularAttribute<Checklist, String> validatorRole;
  
  public static volatile SingularAttribute<Checklist, Boolean> validator2Check;
  
  public static volatile SingularAttribute<Checklist, String> validatorRole3;
  
  public static volatile SingularAttribute<Checklist, String> validatorRole2;
  
  public static volatile SingularAttribute<Checklist, Boolean> validatorCheck;
  
  public static volatile SingularAttribute<Checklist, String> validatorRole4;
  
  public static volatile SetAttribute<Checklist, ChecklistItem> checklistItems;
  
  public static volatile SingularAttribute<Checklist, Long> id;
  
  public static volatile SingularAttribute<Checklist, ChecklistStatus> status;
  
  public static final String CHECKLIST_MODEL = "checklistModel";
  
  public static final String VALIDATOR4 = "validator4";
  
  public static final String VALIDATOR3 = "validator3";
  
  public static final String VALIDATOR2 = "validator2";
  
  public static final String VALIDATOR4_CHECK = "validator4Check";
  
  public static final String VALIDATOR = "validator";
  
  public static final String CERTIFICATE = "certificate";
  
  public static final String DESCRIPTION = "description";
  
  public static final String VALIDATOR3_CHECK = "validator3Check";
  
  public static final String TITLE = "title";
  
  public static final String VALIDATOR_ROLE = "validatorRole";
  
  public static final String VALIDATOR2_CHECK = "validator2Check";
  
  public static final String VALIDATOR_ROLE3 = "validatorRole3";
  
  public static final String VALIDATOR_ROLE2 = "validatorRole2";
  
  public static final String VALIDATOR_CHECK = "validatorCheck";
  
  public static final String VALIDATOR_ROLE4 = "validatorRole4";
  
  public static final String CHECKLIST_ITEMS = "checklistItems";
  
  public static final String ID = "id";
  
  public static final String STATUS = "status";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Checklist_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */