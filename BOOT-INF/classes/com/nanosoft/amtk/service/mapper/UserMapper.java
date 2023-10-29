/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service.mapper;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.Authority;
/*     */ import com.nanosoft.amtk.domain.User;
/*     */ import com.nanosoft.amtk.service.dto.AdminUserDTO;
/*     */ import com.nanosoft.amtk.service.dto.UserDTO;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collectors;
/*     */ import org.mapstruct.BeanMapping;
/*     */ import org.mapstruct.Mapping;
/*     */ import org.mapstruct.Mappings;
/*     */ import org.mapstruct.Named;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class UserMapper
/*     */ {
/*     */   public List<UserDTO> usersToUserDTOs(List<User> users) {
/*  24 */     return (List<UserDTO>)users.stream().filter(Objects::nonNull).map(this::userToUserDTO).collect(Collectors.toList());
/*     */   }
/*     */   
/*     */   public UserDTO userToUserDTO(User user) {
/*  28 */     return new UserDTO(user);
/*     */   }
/*     */   
/*     */   public List<AdminUserDTO> usersToAdminUserDTOs(List<User> users) {
/*  32 */     return (List<AdminUserDTO>)users.stream().filter(Objects::nonNull).map(this::userToAdminUserDTO).collect(Collectors.toList());
/*     */   }
/*     */   
/*     */   public AdminUserDTO userToAdminUserDTO(User user) {
/*  36 */     return new AdminUserDTO(user);
/*     */   }
/*     */   
/*     */   public List<User> userDTOsToUsers(List<AdminUserDTO> userDTOs) {
/*  40 */     return (List<User>)userDTOs.stream().filter(Objects::nonNull).map(this::userDTOToUser).collect(Collectors.toList());
/*     */   }
/*     */   
/*     */   public User userDTOToUser(AdminUserDTO userDTO) {
/*  44 */     if (userDTO == null) {
/*  45 */       return null;
/*     */     }
/*  47 */     User user = new User();
/*  48 */     user.setId(userDTO.getId());
/*  49 */     user.setLogin(userDTO.getLogin());
/*  50 */     user.setFirstName(userDTO.getFirstName());
/*  51 */     user.setLastName(userDTO.getLastName());
/*  52 */     user.setEmail(userDTO.getEmail());
/*  53 */     user.setImageUrl(userDTO.getImageUrl());
/*  54 */     user.setActivated(userDTO.isActivated());
/*  55 */     user.setLangKey(userDTO.getLangKey());
/*  56 */     Set<Authority> authorities = authoritiesFromStrings(userDTO.getAuthorities());
/*  57 */     user.setAuthorities(authorities);
/*  58 */     return user;
/*     */   }
/*     */ 
/*     */   
/*     */   private Set<Authority> authoritiesFromStrings(Set<String> authoritiesAsString) {
/*  63 */     Set<Authority> authorities = new HashSet<>();
/*     */     
/*  65 */     if (authoritiesAsString != null)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  74 */       authorities = (Set<Authority>)authoritiesAsString.stream().map(string -> { Authority auth = new Authority(); auth.setName(string); return auth; }).collect(Collectors.toSet());
/*     */     }
/*     */     
/*  77 */     return authorities;
/*     */   }
/*     */   
/*     */   public User userFromId(Long id) {
/*  81 */     if (id == null) {
/*  82 */       return null;
/*     */     }
/*  84 */     User user = new User();
/*  85 */     user.setId(id);
/*  86 */     return user;
/*     */   }
/*     */   
/*     */   @Named("id")
/*     */   @BeanMapping(ignoreByDefault = true)
/*     */   @Mapping(target = "id", source = "id")
/*     */   public UserDTO toDtoId(User user) {
/*  93 */     if (user == null) {
/*  94 */       return null;
/*     */     }
/*  96 */     UserDTO userDto = new UserDTO();
/*  97 */     userDto.setId(user.getId());
/*  98 */     return userDto;
/*     */   }
/*     */   
/*     */   @Named("idSet")
/*     */   @BeanMapping(ignoreByDefault = true)
/*     */   @Mapping(target = "id", source = "id")
/*     */   public Set<UserDTO> toDtoIdSet(Set<User> users) {
/* 105 */     if (users == null) {
/* 106 */       return Collections.emptySet();
/*     */     }
/*     */     
/* 109 */     Set<UserDTO> userSet = new HashSet<>();
/* 110 */     for (User userEntity : users) {
/* 111 */       userSet.add(toDtoId(userEntity));
/*     */     }
/*     */     
/* 114 */     return userSet;
/*     */   }
/*     */ 
/*     */   
/*     */   @Named("login")
/*     */   @BeanMapping(ignoreByDefault = true)
/*     */   @Mappings({@Mapping(target = "id", source = "id"), @Mapping(target = "login", source = "login")})
/*     */   public UserDTO toDtoLogin(User user) {
/* 122 */     if (user == null) {
/* 123 */       return null;
/*     */     }
/* 125 */     UserDTO userDto = new UserDTO();
/* 126 */     userDto.setId(user.getId());
/* 127 */     userDto.setLogin(user.getLogin());
/* 128 */     return userDto;
/*     */   }
/*     */ 
/*     */   
/*     */   @Named("loginSet")
/*     */   @BeanMapping(ignoreByDefault = true)
/*     */   @Mappings({@Mapping(target = "id", source = "id"), @Mapping(target = "login", source = "login")})
/*     */   public Set<UserDTO> toDtoLoginSet(Set<User> users) {
/* 136 */     if (users == null) {
/* 137 */       return Collections.emptySet();
/*     */     }
/*     */     
/* 140 */     Set<UserDTO> userSet = new HashSet<>();
/* 141 */     for (User userEntity : users) {
/* 142 */       userSet.add(toDtoLogin(userEntity));
/*     */     }
/*     */     
/* 145 */     return userSet;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\mapper\UserMapper.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */