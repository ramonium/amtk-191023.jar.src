package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity_;
import com.nanosoft.amtk.domain.ChecklistModel;
import com.nanosoft.amtk.domain.ChecklistModelItem;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ChecklistModelItem.class)
public abstract class ChecklistModelItem_ extends AbstractAuditingEntity_ {
  public static volatile SingularAttribute<ChecklistModelItem, ChecklistModel> checklistModel;
  
  public static volatile SingularAttribute<ChecklistModelItem, String> itemGroup;
  
  public static volatile SingularAttribute<ChecklistModelItem, String> validator;
  
  public static volatile SingularAttribute<ChecklistModelItem, Long> id;
  
  public static volatile SingularAttribute<ChecklistModelItem, String> text;
  
  public static final String CHECKLIST_MODEL = "checklistModel";
  
  public static final String ITEM_GROUP = "itemGroup";
  
  public static final String VALIDATOR = "validator";
  
  public static final String ID = "id";
  
  public static final String TEXT = "text";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\ChecklistModelItem_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */