package BOOT-INF.classes.com.nanosoft.amtk.repository;

import com.nanosoft.amtk.domain.CertificationLevel;
import com.nanosoft.amtk.domain.Process;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationLevelRepository extends JpaRepository<CertificationLevel, Long>, JpaSpecificationExecutor<CertificationLevel> {
  List<CertificationLevel> findAllByProcess(Process paramProcess);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\repository\CertificationLevelRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */