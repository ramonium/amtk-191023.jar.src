package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;

import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface EntityMapper<D, E> {
  E toEntity(D paramD);
  
  D toDto(E paramE);
  
  List<E> toEntity(List<D> paramList);
  
  List<D> toDto(List<E> paramList);
  
  @Named("partialUpdate")
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void partialUpdate(@MappingTarget E paramE, D paramD);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\EntityMapper.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */