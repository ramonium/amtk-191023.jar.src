package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity;
import java.time.Instant;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(AbstractAuditingEntity.class)
public abstract class AbstractAuditingEntity_ {
  public static volatile SingularAttribute<AbstractAuditingEntity, Instant> createdDate;
  
  public static volatile SingularAttribute<AbstractAuditingEntity, String> createdBy;
  
  public static volatile SingularAttribute<AbstractAuditingEntity, Instant> lastModifiedDate;
  
  public static volatile SingularAttribute<AbstractAuditingEntity, String> lastModifiedBy;
  
  public static final String CREATED_DATE = "createdDate";
  
  public static final String CREATED_BY = "createdBy";
  
  public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
  
  public static final String LAST_MODIFIED_BY = "lastModifiedBy";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\AbstractAuditingEntity_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */