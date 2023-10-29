package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity_;
import com.nanosoft.amtk.domain.CertificationLevel;
import com.nanosoft.amtk.domain.Checklist;
import com.nanosoft.amtk.domain.ChecklistModel;
import com.nanosoft.amtk.domain.ChecklistModelItem;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ChecklistModel.class)
public abstract class ChecklistModel_ extends AbstractAuditingEntity_ {
  public static volatile SetAttribute<ChecklistModel, Checklist> checklists;
  
  public static volatile SingularAttribute<ChecklistModel, String> validator4;
  
  public static volatile SingularAttribute<ChecklistModel, String> validator3;
  
  public static volatile SetAttribute<ChecklistModel, ChecklistModelItem> checklistModelItems;
  
  public static volatile SingularAttribute<ChecklistModel, String> validator2;
  
  public static volatile SingularAttribute<ChecklistModel, String> validator;
  
  public static volatile SingularAttribute<ChecklistModel, String> description;
  
  public static volatile SingularAttribute<ChecklistModel, Long> id;
  
  public static volatile SingularAttribute<ChecklistModel, String> title;
  
  public static volatile SetAttribute<ChecklistModel, CertificationLevel> certificationLevels;
  
  public static final String CHECKLISTS = "checklists";
  
  public static final String VALIDATOR4 = "validator4";
  
  public static final String VALIDATOR3 = "validator3";
  
  public static final String CHECKLIST_MODEL_ITEMS = "checklistModelItems";
  
  public static final String VALIDATOR2 = "validator2";
  
  public static final String VALIDATOR = "validator";
  
  public static final String DESCRIPTION = "description";
  
  public static final String ID = "id";
  
  public static final String TITLE = "title";
  
  public static final String CERTIFICATION_LEVELS = "certificationLevels";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\ChecklistModel_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */