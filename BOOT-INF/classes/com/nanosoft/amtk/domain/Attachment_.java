package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity_;
import com.nanosoft.amtk.domain.Attachment;
import com.nanosoft.amtk.domain.Content;
import com.nanosoft.amtk.domain.Employee;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Attachment.class)
public abstract class Attachment_ extends AbstractAuditingEntity_ {
  public static volatile SingularAttribute<Attachment, String> fileName;
  
  public static volatile SingularAttribute<Attachment, Long> fileSize;
  
  public static volatile SingularAttribute<Attachment, String> description;
  
  public static volatile SingularAttribute<Attachment, Long> id;
  
  public static volatile SingularAttribute<Attachment, String> title;
  
  public static volatile SingularAttribute<Attachment, Employee> employee;
  
  public static volatile SingularAttribute<Attachment, String> fileType;
  
  public static volatile SingularAttribute<Attachment, Content> content;
  
  public static final String FILE_NAME = "fileName";
  
  public static final String FILE_SIZE = "fileSize";
  
  public static final String DESCRIPTION = "description";
  
  public static final String ID = "id";
  
  public static final String TITLE = "title";
  
  public static final String EMPLOYEE = "employee";
  
  public static final String FILE_TYPE = "fileType";
  
  public static final String CONTENT = "content";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Attachment_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */