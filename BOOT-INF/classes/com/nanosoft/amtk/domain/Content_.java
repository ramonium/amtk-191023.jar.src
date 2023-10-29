package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity_;
import com.nanosoft.amtk.domain.Attachment;
import com.nanosoft.amtk.domain.Content;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Content.class)
public abstract class Content_ extends AbstractAuditingEntity_ {
  public static volatile SingularAttribute<Content, byte[]> data;
  
  public static volatile SingularAttribute<Content, Attachment> attachment;
  
  public static volatile SingularAttribute<Content, Long> id;
  
  public static volatile SingularAttribute<Content, String> dataContentType;
  
  public static final String DATA = "data";
  
  public static final String ATTACHMENT = "attachment";
  
  public static final String ID = "id";
  
  public static final String DATA_CONTENT_TYPE = "dataContentType";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Content_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */