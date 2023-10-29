/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Area;
/*     */ import com.nanosoft.amtk.domain.Process;
/*     */ import com.nanosoft.amtk.domain.Workstation;
/*     */ import com.nanosoft.amtk.service.dto.AreaDTO;
/*     */ import com.nanosoft.amtk.service.dto.ProcessDTO;
/*     */ import com.nanosoft.amtk.service.dto.WorkstationDTO;
/*     */ import com.nanosoft.amtk.service.mapper.AreaMapper;
/*     */ import com.nanosoft.amtk.service.mapper.WorkstationMapper;
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
/*     */ public class WorkstationMapperImpl
/*     */   implements WorkstationMapper
/*     */ {
/*     */   @Autowired
/*     */   private AreaMapper areaMapper;
/*     */   
/*     */   public Workstation toEntity(WorkstationDTO dto) {
/*  28 */     if (dto == null) {
/*  29 */       return null;
/*     */     }
/*     */     
/*  32 */     Workstation workstation = new Workstation();
/*     */     
/*  34 */     workstation.createdBy(dto.getCreatedBy());
/*  35 */     workstation.createdDate(dto.getCreatedDate());
/*  36 */     workstation.lastModifiedBy(dto.getLastModifiedBy());
/*  37 */     workstation.lastModifiedDate(dto.getLastModifiedDate());
/*  38 */     workstation.setId(dto.getId());
/*  39 */     workstation.setName(dto.getName());
/*  40 */     workstation.setDescription(dto.getDescription());
/*  41 */     workstation.setOrderNumber(dto.getOrderNumber());
/*  42 */     workstation.area((Area)this.areaMapper.toEntity(dto.getArea()));
/*  43 */     workstation.process(processDTOToProcess(dto.getProcess()));
/*     */     
/*  45 */     return workstation;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Workstation> toEntity(List<WorkstationDTO> dtoList) {
/*  50 */     if (dtoList == null) {
/*  51 */       return null;
/*     */     }
/*     */     
/*  54 */     List<Workstation> list = new ArrayList<>(dtoList.size());
/*  55 */     for (WorkstationDTO workstationDTO : dtoList) {
/*  56 */       list.add(toEntity(workstationDTO));
/*     */     }
/*     */     
/*  59 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<WorkstationDTO> toDto(List<Workstation> entityList) {
/*  64 */     if (entityList == null) {
/*  65 */       return null;
/*     */     }
/*     */     
/*  68 */     List<WorkstationDTO> list = new ArrayList<>(entityList.size());
/*  69 */     for (Workstation workstation : entityList) {
/*  70 */       list.add(toDto(workstation));
/*     */     }
/*     */     
/*  73 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void partialUpdate(Workstation entity, WorkstationDTO dto) {
/*  78 */     if (dto == null) {
/*     */       return;
/*     */     }
/*     */     
/*  82 */     if (dto.getCreatedBy() != null) {
/*  83 */       entity.createdBy(dto.getCreatedBy());
/*     */     }
/*  85 */     if (dto.getCreatedDate() != null) {
/*  86 */       entity.createdDate(dto.getCreatedDate());
/*     */     }
/*  88 */     if (dto.getLastModifiedBy() != null) {
/*  89 */       entity.lastModifiedBy(dto.getLastModifiedBy());
/*     */     }
/*  91 */     if (dto.getLastModifiedDate() != null) {
/*  92 */       entity.lastModifiedDate(dto.getLastModifiedDate());
/*     */     }
/*  94 */     if (dto.getId() != null) {
/*  95 */       entity.setId(dto.getId());
/*     */     }
/*  97 */     if (dto.getName() != null) {
/*  98 */       entity.setName(dto.getName());
/*     */     }
/* 100 */     if (dto.getDescription() != null) {
/* 101 */       entity.setDescription(dto.getDescription());
/*     */     }
/* 103 */     if (dto.getOrderNumber() != null) {
/* 104 */       entity.setOrderNumber(dto.getOrderNumber());
/*     */     }
/* 106 */     if (dto.getArea() != null) {
/* 107 */       entity.area((Area)this.areaMapper.toEntity(dto.getArea()));
/*     */     }
/* 109 */     if (dto.getProcess() != null) {
/* 110 */       if (entity.getProcess() == null) {
/* 111 */         entity.process(new Process());
/*     */       }
/* 113 */       processDTOToProcess1(dto.getProcess(), entity.getProcess());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public WorkstationDTO toDto(Workstation s) {
/* 119 */     if (s == null) {
/* 120 */       return null;
/*     */     }
/*     */     
/* 123 */     WorkstationDTO workstationDTO = new WorkstationDTO();
/*     */     
/* 125 */     workstationDTO.setArea(this.areaMapper.toDto(s.getArea()));
/* 126 */     workstationDTO.setProcess(processToProcessDTO(s.getProcess()));
/* 127 */     workstationDTO.setId(s.getId());
/* 128 */     workstationDTO.setName(s.getName());
/* 129 */     workstationDTO.setDescription(s.getDescription());
/* 130 */     workstationDTO.setOrderNumber(s.getOrderNumber());
/* 131 */     workstationDTO.setCreatedBy(s.getCreatedBy());
/* 132 */     workstationDTO.setCreatedDate(s.getCreatedDate());
/* 133 */     workstationDTO.setLastModifiedBy(s.getLastModifiedBy());
/* 134 */     workstationDTO.setLastModifiedDate(s.getLastModifiedDate());
/*     */     
/* 136 */     return workstationDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public AreaDTO toDtoAreaName(Area area) {
/* 141 */     if (area == null) {
/* 142 */       return null;
/*     */     }
/*     */     
/* 145 */     AreaDTO areaDTO = new AreaDTO();
/*     */     
/* 147 */     areaDTO.setId(area.getId());
/* 148 */     areaDTO.setName(area.getName());
/*     */     
/* 150 */     return areaDTO;
/*     */   }
/*     */ 
/*     */   
/*     */   public ProcessDTO toDtoProcessName(Process process) {
/* 155 */     if (process == null) {
/* 156 */       return null;
/*     */     }
/*     */     
/* 159 */     ProcessDTO processDTO = new ProcessDTO();
/*     */     
/* 161 */     processDTO.setId(process.getId());
/* 162 */     processDTO.setName(process.getName());
/*     */     
/* 164 */     return processDTO;
/*     */   }
/*     */   
/*     */   protected Process processDTOToProcess(ProcessDTO processDTO) {
/* 168 */     if (processDTO == null) {
/* 169 */       return null;
/*     */     }
/*     */     
/* 172 */     Process process = new Process();
/*     */     
/* 174 */     process.createdBy(processDTO.getCreatedBy());
/* 175 */     process.createdDate(processDTO.getCreatedDate());
/* 176 */     process.lastModifiedBy(processDTO.getLastModifiedBy());
/* 177 */     process.lastModifiedDate(processDTO.getLastModifiedDate());
/* 178 */     process.setId(processDTO.getId());
/* 179 */     process.setName(processDTO.getName());
/* 180 */     process.setDescription(processDTO.getDescription());
/*     */     
/* 182 */     return process;
/*     */   }
/*     */   
/*     */   protected void processDTOToProcess1(ProcessDTO processDTO, Process mappingTarget) {
/* 186 */     if (processDTO == null) {
/*     */       return;
/*     */     }
/*     */     
/* 190 */     if (processDTO.getCreatedBy() != null) {
/* 191 */       mappingTarget.createdBy(processDTO.getCreatedBy());
/*     */     }
/* 193 */     if (processDTO.getCreatedDate() != null) {
/* 194 */       mappingTarget.createdDate(processDTO.getCreatedDate());
/*     */     }
/* 196 */     if (processDTO.getLastModifiedBy() != null) {
/* 197 */       mappingTarget.lastModifiedBy(processDTO.getLastModifiedBy());
/*     */     }
/* 199 */     if (processDTO.getLastModifiedDate() != null) {
/* 200 */       mappingTarget.lastModifiedDate(processDTO.getLastModifiedDate());
/*     */     }
/* 202 */     if (processDTO.getId() != null) {
/* 203 */       mappingTarget.setId(processDTO.getId());
/*     */     }
/* 205 */     if (processDTO.getName() != null) {
/* 206 */       mappingTarget.setName(processDTO.getName());
/*     */     }
/* 208 */     if (processDTO.getDescription() != null) {
/* 209 */       mappingTarget.setDescription(processDTO.getDescription());
/*     */     }
/*     */   }
/*     */   
/*     */   protected ProcessDTO processToProcessDTO(Process process) {
/* 214 */     if (process == null) {
/* 215 */       return null;
/*     */     }
/*     */     
/* 218 */     ProcessDTO processDTO = new ProcessDTO();
/*     */     
/* 220 */     processDTO.setId(process.getId());
/* 221 */     processDTO.setName(process.getName());
/* 222 */     processDTO.setDescription(process.getDescription());
/* 223 */     processDTO.setCreatedBy(process.getCreatedBy());
/* 224 */     processDTO.setCreatedDate(process.getCreatedDate());
/* 225 */     processDTO.setLastModifiedBy(process.getLastModifiedBy());
/* 226 */     processDTO.setLastModifiedDate(process.getLastModifiedDate());
/*     */     
/* 228 */     return processDTO;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\WorkstationMapperImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */