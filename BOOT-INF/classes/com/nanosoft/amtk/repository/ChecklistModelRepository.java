package BOOT-INF.classes.com.nanosoft.amtk.repository;

import com.nanosoft.amtk.domain.ChecklistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecklistModelRepository extends JpaRepository<ChecklistModel, Long>, JpaSpecificationExecutor<ChecklistModel> {}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\repository\ChecklistModelRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */