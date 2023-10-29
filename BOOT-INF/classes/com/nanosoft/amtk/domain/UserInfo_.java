package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.Employee;
import com.nanosoft.amtk.domain.User;
import com.nanosoft.amtk.domain.UserInfo;
import java.time.Instant;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UserInfo.class)
public abstract class UserInfo_ {
  public static volatile SingularAttribute<UserInfo, Instant> createdDate;
  
  public static volatile SingularAttribute<UserInfo, String> createdBy;
  
  public static volatile SingularAttribute<UserInfo, Instant> lastModifiedDate;
  
  public static volatile SingularAttribute<UserInfo, Employee> relatedEmployee;
  
  public static volatile SingularAttribute<UserInfo, String> lastModifiedBy;
  
  public static volatile SingularAttribute<UserInfo, String> description;
  
  public static volatile SingularAttribute<UserInfo, Long> id;
  
  public static volatile SingularAttribute<UserInfo, User> user;
  
  public static final String CREATED_DATE = "createdDate";
  
  public static final String CREATED_BY = "createdBy";
  
  public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
  
  public static final String RELATED_EMPLOYEE = "relatedEmployee";
  
  public static final String LAST_MODIFIED_BY = "lastModifiedBy";
  
  public static final String DESCRIPTION = "description";
  
  public static final String ID = "id";
  
  public static final String USER = "user";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\UserInfo_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */