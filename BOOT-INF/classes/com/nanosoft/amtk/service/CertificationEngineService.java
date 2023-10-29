package BOOT-INF.classes.com.nanosoft.amtk.service;

import com.nanosoft.amtk.domain.Certificate;

public interface CertificationEngineService {
  void runEngineSequence();
  
  void runCertificationEngine();
  
  void runSkillsMatrixEngine();
  
  void runSkillsMatrixEngine(Long paramLong);
  
  void runEnginForCertificate(Certificate paramCertificate);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\CertificationEngineService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */