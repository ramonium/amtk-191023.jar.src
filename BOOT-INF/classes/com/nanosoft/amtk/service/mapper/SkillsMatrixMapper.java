package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;

import com.nanosoft.amtk.domain.SkillsMatrix;
import com.nanosoft.amtk.service.dto.SkillsMatrixDTO;
import com.nanosoft.amtk.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillsMatrixMapper extends EntityMapper<SkillsMatrixDTO, SkillsMatrix> {
  SkillsMatrixDTO toDto(SkillsMatrix paramSkillsMatrix);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\SkillsMatrixMapper.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */