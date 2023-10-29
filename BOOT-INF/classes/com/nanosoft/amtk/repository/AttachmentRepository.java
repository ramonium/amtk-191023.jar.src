package BOOT-INF.classes.com.nanosoft.amtk.repository;

import com.nanosoft.amtk.domain.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long>, JpaSpecificationExecutor<Attachment> {}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\repository\AttachmentRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */