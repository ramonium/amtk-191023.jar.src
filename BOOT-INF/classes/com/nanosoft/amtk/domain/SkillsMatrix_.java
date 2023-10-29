package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity_;
import com.nanosoft.amtk.domain.Project;
import com.nanosoft.amtk.domain.SkillsMatrix;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(SkillsMatrix.class)
public abstract class SkillsMatrix_ extends AbstractAuditingEntity_ {
  public static volatile SingularAttribute<SkillsMatrix, byte[]> data;
  
  public static volatile SingularAttribute<SkillsMatrix, Project> project;
  
  public static volatile SingularAttribute<SkillsMatrix, Long> id;
  
  public static volatile SingularAttribute<SkillsMatrix, String> dataContentType;
  
  public static volatile SingularAttribute<SkillsMatrix, Project> forProject;
  
  public static final String DATA = "data";
  
  public static final String PROJECT = "project";
  
  public static final String ID = "id";
  
  public static final String DATA_CONTENT_TYPE = "dataContentType";
  
  public static final String FOR_PROJECT = "forProject";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\SkillsMatrix_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */