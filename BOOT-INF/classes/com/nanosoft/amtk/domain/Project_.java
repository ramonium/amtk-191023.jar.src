package BOOT-INF.classes.com.nanosoft.amtk.domain;

import com.nanosoft.amtk.domain.AbstractAuditingEntity_;
import com.nanosoft.amtk.domain.Area;
import com.nanosoft.amtk.domain.Project;
import com.nanosoft.amtk.domain.SkillsMatrix;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Project.class)
public abstract class Project_ extends AbstractAuditingEntity_ {
  public static volatile SingularAttribute<Project, SkillsMatrix> skillsMatrix;
  
  public static volatile SingularAttribute<Project, Boolean> safety;
  
  public static volatile SingularAttribute<Project, String> name;
  
  public static volatile SingularAttribute<Project, String> qualificationAfter;
  
  public static volatile SingularAttribute<Project, String> decertifyAfter;
  
  public static volatile SingularAttribute<Project, String> description;
  
  public static volatile SetAttribute<Project, Area> areas;
  
  public static volatile SingularAttribute<Project, Long> id;
  
  public static volatile SingularAttribute<Project, String> customer;
  
  public static volatile SetAttribute<Project, SkillsMatrix> skillsMatrixHistories;
  
  public static final String SKILLS_MATRIX = "skillsMatrix";
  
  public static final String SAFETY = "safety";
  
  public static final String NAME = "name";
  
  public static final String QUALIFICATION_AFTER = "qualificationAfter";
  
  public static final String DECERTIFY_AFTER = "decertifyAfter";
  
  public static final String DESCRIPTION = "description";
  
  public static final String AREAS = "areas";
  
  public static final String ID = "id";
  
  public static final String CUSTOMER = "customer";
  
  public static final String SKILLS_MATRIX_HISTORIES = "skillsMatrixHistories";
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\domain\Project_.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */