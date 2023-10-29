/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Area;
/*     */ import com.nanosoft.amtk.domain.Project;
/*     */ import com.nanosoft.amtk.service.dto.AreaDTO;
/*     */ import com.nanosoft.amtk.service.dto.ProjectDTO;
/*     */ import com.nanosoft.amtk.service.mapper.AreaMapper;
/*     */ import com.nanosoft.amtk.service.mapper.ProjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Component
/*     */ public class AreaMapperImpl
/*     */   implements AreaMapper
/*     */ {
/*     */   @Autowired
/*     */   private ProjectMapper projectMapper;
/*     */   
/*     */   public Area toEntity(AreaDTO dto) {
/*  26 */     if (dto == null) {
/*  27 */       return null;
/*     */     }
/*     */     
/*  30 */     Area area = new Area();
/*     */     
/*  32 */     area.createdBy(dto.getCreatedBy());
/*  33 */     area.createdDate(dto.getCreatedDate());
/*  34 */     area.lastModifiedBy(dto.getLastModifiedBy());
/*  35 */     area.lastModifiedDate(dto.getLastModifiedDate());
/*  36 */     area.setId(dto.getId());
/*  37 */     area.setName(dto.getName());
/*  38 */     area.setDescription(dto.getDescription());
/*  39 */     area.setOrderNumber(dto.getOrderNumber());
/*  40 */     area.project((Project)this.projectMapper.toEntity(dto.getProject()));
/*     */     
/*  42 */     return area;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Area> toEntity(List<AreaDTO> dtoList) {
/*  47 */     if (dtoList == null) {
/*  48 */       return null;
/*     */     }
/*     */     
/*  51 */     List<Area> list = new ArrayList<>(dtoList.size());
/*  52 */     for (AreaDTO areaDTO : dtoList) {
/*  53 */       list.add(toEntity(areaDTO));
/*     */     }
/*     */     
/*  56 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<AreaDTO> toDto(List<Area> entityList) {
/*  61 */     if (entityList == null) {
/*  62 */       return null;
/*     */     }
/*     */     
/*  65 */     List<AreaDTO> list = new ArrayList<>(entityList.size());
/*  66 */     for (Area area : entityList) {
/*  67 */       list.add(toDto(area));
/*     */     }
/*     */     
/*  70 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(Area entity, AreaDTO dto) {
/*  75 */     if (dto == null) {
/*     */       return;
/*     */     }
/*     */     
/*  79 */     if (dto.getCreatedBy() != null) {
/*  80 */       entity.createdBy(dto.getCreatedBy());
/*     */     }
/*  82 */     if (dto.getCreatedDate() != null) {
/*  83 */       entity.createdDate(dto.getCreatedDate());
/*     */     }
/*  85 */     if (dto.getLastModifiedBy() != null) {
/*  86 */       entity.lastModifiedBy(dto.getLastModifiedBy());
/*     */     }
/*  88 */     if (dto.getLastModifiedDate() != null) {
/*  89 */       entity.lastModifiedDate(dto.getLastModifiedDate());
/*     */     }
/*  91 */     if (dto.getId() != null) {
/*  92 */       entity.setId(dto.getId());
/*     */     }
/*  94 */     if (dto.getName() != null) {
/*  95 */       entity.setName(dto.getName());
/*     */     }
/*  97 */     if (dto.getDescription() != null) {
/*  98 */       entity.setDescription(dto.getDescription());
/*     */     }
/* 100 */     if (dto.getOrderNumber() != null) {
/* 101 */       entity.setOrderNumber(dto.getOrderNumber());
/*     */     }
/* 103 */     if (dto.getProject() != null) {
/* 104 */       entity.project((Project)this.projectMapper.toEntity(dto.getProject()));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public AreaDTO toDto(Area s) {
/* 110 */     if (s == null) {
/* 111 */       return null;
/*     */     }
/*     */     
/* 114 */     AreaDTO areaDTO = new AreaDTO();
/*     */     
/* 116 */     areaDTO.setProject(this.projectMapper.toDto(s.getProject()));
/* 117 */     areaDTO.setId(s.getId());
/* 118 */     areaDTO.setName(s.getName());
/* 119 */     areaDTO.setDescription(s.getDescription());
/* 120 */     areaDTO.setOrderNumber(s.getOrderNumber());
/* 121 */     areaDTO.setCreatedBy(s.getCreatedBy());
/* 122 */     areaDTO.setCreatedDate(s.getCreatedDate());
/* 123 */     areaDTO.setLastModifiedBy(s.getLastModifiedBy());
/* 124 */     areaDTO.setLastModifiedDate(s.getLastModifiedDate());
/*     */     
/* 126 */     return areaDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public ProjectDTO toDtoProjectName(Project project) {
/* 131 */     if (project == null) {
/* 132 */       return null;
/*     */     }
/*     */     
/* 135 */     ProjectDTO projectDTO = new ProjectDTO();
/*     */     
/* 137 */     projectDTO.setId(project.getId());
/* 138 */     projectDTO.setName(project.getName());
/*     */     
/* 140 */     return projectDTO;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\AreaMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */