package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;

import com.nanosoft.amtk.domain.Process;
import com.nanosoft.amtk.service.dto.ProcessDTO;
import com.nanosoft.amtk.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProcessMapper extends EntityMapper<ProcessDTO, Process> {}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\ProcessMapper.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */