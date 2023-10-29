package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity_;
import com.nanosoft.amtk.domain.Checklist;
import com.nanosoft.amtk.domain.ChecklistItem;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ChecklistItem.class)
public abstract class ChecklistItem_ extends AbstractAuditingEntity_ {
  public static volatile SingularAttribute<ChecklistItem, String> itemGroup;
  
  public static volatile SingularAttribute<ChecklistItem, String> validator;
  
  public static volatile SingularAttribute<ChecklistItem, Checklist> checklist;
  
  public static volatile SingularAttribute<ChecklistItem, Long> id;
  
  public static volatile SingularAttribute<ChecklistItem, String> text;
  
  public static volatile SingularAttribute<ChecklistItem, Boolean> isChecked;
  
  public static volatile SingularAttribute<ChecklistItem, String> validatorRole;
  
  public static final String ITEM_GROUP = "itemGroup";
  
  public static final String VALIDATOR = "validator";
  
  public static final String CHECKLIST = "checklist";
  
  public static final String ID = "id";
  
  public static final String TEXT = "text";
  
  public static final String IS_CHECKED = "isChecked";
  
  public static final String VALIDATOR_ROLE = "validatorRole";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\ChecklistItem_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */