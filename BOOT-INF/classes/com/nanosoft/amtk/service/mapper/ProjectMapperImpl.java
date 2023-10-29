/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Project;
/*     */ import com.nanosoft.amtk.domain.SkillsMatrix;
/*     */ import com.nanosoft.amtk.service.dto.ProjectDTO;
/*     */ import com.nanosoft.amtk.service.dto.SkillsMatrixDTO;
/*     */ import com.nanosoft.amtk.service.mapper.ProjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Component
/*     */ public class ProjectMapperImpl
/*     */   implements ProjectMapper
/*     */ {
/*     */   public Project toEntity(ProjectDTO dto) {
/*  23 */     if (dto == null) {
/*  24 */       return null;
/*     */     }
/*     */     
/*  27 */     Project project = new Project();
/*     */     
/*  29 */     project.createdBy(dto.getCreatedBy());
/*  30 */     project.createdDate(dto.getCreatedDate());
/*  31 */     project.lastModifiedBy(dto.getLastModifiedBy());
/*  32 */     project.lastModifiedDate(dto.getLastModifiedDate());
/*  33 */     project.setId(dto.getId());
/*  34 */     project.setName(dto.getName());
/*  35 */     project.setCustomer(dto.getCustomer());
/*  36 */     project.setSafety(dto.getSafety());
/*  37 */     project.setQualificationAfter(dto.getQualificationAfter());
/*  38 */     project.setDecertifyAfter(dto.getDecertifyAfter());
/*  39 */     project.setDescription(dto.getDescription());
/*  40 */     project.skillsMatrix(skillsMatrixDTOToSkillsMatrix(dto.getSkillsMatrix()));
/*     */     
/*  42 */     return project;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Project> toEntity(List<ProjectDTO> dtoList) {
/*  47 */     if (dtoList == null) {
/*  48 */       return null;
/*     */     }
/*     */     
/*  51 */     List<Project> list = new ArrayList<>(dtoList.size());
/*  52 */     for (ProjectDTO projectDTO : dtoList) {
/*  53 */       list.add(toEntity(projectDTO));
/*     */     }
/*     */     
/*  56 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ProjectDTO> toDto(List<Project> entityList) {
/*  61 */     if (entityList == null) {
/*  62 */       return null;
/*     */     }
/*     */     
/*  65 */     List<ProjectDTO> list = new ArrayList<>(entityList.size());
/*  66 */     for (Project project : entityList) {
/*  67 */       list.add(toDto(project));
/*     */     }
/*     */     
/*  70 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(Project entity, ProjectDTO dto) {
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
/*  97 */     if (dto.getCustomer() != null) {
/*  98 */       entity.setCustomer(dto.getCustomer());
/*     */     }
/* 100 */     if (dto.getSafety() != null) {
/* 101 */       entity.setSafety(dto.getSafety());
/*     */     }
/* 103 */     if (dto.getQualificationAfter() != null) {
/* 104 */       entity.setQualificationAfter(dto.getQualificationAfter());
/*     */     }
/* 106 */     if (dto.getDecertifyAfter() != null) {
/* 107 */       entity.setDecertifyAfter(dto.getDecertifyAfter());
/*     */     }
/* 109 */     if (dto.getDescription() != null) {
/* 110 */       entity.setDescription(dto.getDescription());
/*     */     }
/* 112 */     if (dto.getSkillsMatrix() != null) {
/* 113 */       if (entity.getSkillsMatrix() == null) {
/* 114 */         entity.skillsMatrix(new SkillsMatrix());
/*     */       }
/* 116 */       skillsMatrixDTOToSkillsMatrix1(dto.getSkillsMatrix(), entity.getSkillsMatrix());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ProjectDTO toDto(Project s) {
/* 122 */     if (s == null) {
/* 123 */       return null;
/*     */     }
/*     */     
/* 126 */     ProjectDTO projectDTO = new ProjectDTO();
/*     */     
/* 128 */     projectDTO.setSkillsMatrix(toDtoSkillsMatrixId(s.getSkillsMatrix()));
/* 129 */     projectDTO.setId(s.getId());
/* 130 */     projectDTO.setName(s.getName());
/* 131 */     projectDTO.setCustomer(s.getCustomer());
/* 132 */     projectDTO.setSafety(s.getSafety());
/* 133 */     projectDTO.setQualificationAfter(s.getQualificationAfter());
/* 134 */     projectDTO.setDecertifyAfter(s.getDecertifyAfter());
/* 135 */     projectDTO.setDescription(s.getDescription());
/* 136 */     projectDTO.setCreatedBy(s.getCreatedBy());
/* 137 */     projectDTO.setCreatedDate(s.getCreatedDate());
/* 138 */     projectDTO.setLastModifiedBy(s.getLastModifiedBy());
/* 139 */     projectDTO.setLastModifiedDate(s.getLastModifiedDate());
/*     */     
/* 141 */     return projectDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public SkillsMatrixDTO toDtoSkillsMatrixId(SkillsMatrix skillsMatrix) {
/* 146 */     if (skillsMatrix == null) {
/* 147 */       return null;
/*     */     }
/*     */     
/* 150 */     SkillsMatrixDTO skillsMatrixDTO = new SkillsMatrixDTO();
/*     */     
/* 152 */     skillsMatrixDTO.setId(skillsMatrix.getId());
/*     */     
/* 154 */     return skillsMatrixDTO;
/*     */   }
/*     */   
/*     */   protected SkillsMatrix skillsMatrixDTOToSkillsMatrix(SkillsMatrixDTO skillsMatrixDTO) {
/* 158 */     if (skillsMatrixDTO == null) {
/* 159 */       return null;
/*     */     }
/*     */     
/* 162 */     SkillsMatrix skillsMatrix = new SkillsMatrix();
/*     */     
/* 164 */     skillsMatrix.createdBy(skillsMatrixDTO.getCreatedBy());
/* 165 */     skillsMatrix.createdDate(skillsMatrixDTO.getCreatedDate());
/* 166 */     skillsMatrix.lastModifiedBy(skillsMatrixDTO.getLastModifiedBy());
/* 167 */     skillsMatrix.lastModifiedDate(skillsMatrixDTO.getLastModifiedDate());
/* 168 */     skillsMatrix.setId(skillsMatrixDTO.getId());
/* 169 */     byte[] data = skillsMatrixDTO.getData();
/* 170 */     if (data != null) {
/* 171 */       skillsMatrix.setData(Arrays.copyOf(data, data.length));
/*     */     }
/* 173 */     skillsMatrix.setDataContentType(skillsMatrixDTO.getDataContentType());
/*     */     
/* 175 */     return skillsMatrix;
/*     */   }
/*     */   
/*     */   protected void skillsMatrixDTOToSkillsMatrix1(SkillsMatrixDTO skillsMatrixDTO, SkillsMatrix mappingTarget) {
/* 179 */     if (skillsMatrixDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 183 */     if (skillsMatrixDTO.getCreatedBy() != null) {
/* 184 */       mappingTarget.createdBy(skillsMatrixDTO.getCreatedBy());
/*     */     }
/* 186 */     if (skillsMatrixDTO.getCreatedDate() != null) {
/* 187 */       mappingTarget.createdDate(skillsMatrixDTO.getCreatedDate());
/*     */     }
/* 189 */     if (skillsMatrixDTO.getLastModifiedBy() != null) {
/* 190 */       mappingTarget.lastModifiedBy(skillsMatrixDTO.getLastModifiedBy());
/*     */     }
/* 192 */     if (skillsMatrixDTO.getLastModifiedDate() != null) {
/* 193 */       mappingTarget.lastModifiedDate(skillsMatrixDTO.getLastModifiedDate());
/*     */     }
/* 195 */     if (skillsMatrixDTO.getId() != null) {
/* 196 */       mappingTarget.setId(skillsMatrixDTO.getId());
/*     */     }
/* 198 */     byte[] data = skillsMatrixDTO.getData();
/* 199 */     if (data != null) {
/* 200 */       mappingTarget.setData(Arrays.copyOf(data, data.length));
/*     */     }
/* 202 */     if (skillsMatrixDTO.getDataContentType() != null)
/* 203 */       mappingTarget.setDataContentType(skillsMatrixDTO.getDataContentType()); 
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\ProjectMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */