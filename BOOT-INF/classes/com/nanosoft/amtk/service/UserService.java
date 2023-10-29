/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ import com.nanosoft.amtk.domain.Authority;
/*     */ import com.nanosoft.amtk.domain.User;
/*     */ import com.nanosoft.amtk.repository.AuthorityRepository;
/*     */ import com.nanosoft.amtk.repository.UserRepository;
/*     */ import com.nanosoft.amtk.security.SecurityUtils;
/*     */ import com.nanosoft.amtk.service.EmailAlreadyUsedException;
/*     */ import com.nanosoft.amtk.service.InvalidPasswordException;
/*     */ import com.nanosoft.amtk.service.UsernameAlreadyUsedException;
/*     */ import com.nanosoft.amtk.service.dto.AdminUserDTO;
/*     */ import com.nanosoft.amtk.service.dto.UserDTO;
/*     */ import java.time.Instant;
/*     */ import java.time.temporal.ChronoUnit;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import java.util.function.Function;
/*     */ import java.util.stream.Collectors;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.cache.Cache;
/*     */ import org.springframework.cache.CacheManager;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.Pageable;
/*     */ import org.springframework.security.crypto.password.PasswordEncoder;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import tech.jhipster.security.RandomUtil;
/*     */ 
/*     */ @Service
/*     */ @Transactional
/*     */ public class UserService {
/*  34 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.UserService.class);
/*     */ 
/*     */   
/*     */   private final UserRepository userRepository;
/*     */ 
/*     */   
/*     */   private final PasswordEncoder passwordEncoder;
/*     */ 
/*     */   
/*     */   private final AuthorityRepository authorityRepository;
/*     */ 
/*     */   
/*     */   private final CacheManager cacheManager;
/*     */ 
/*     */   
/*     */   public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository, CacheManager cacheManager) {
/*  50 */     this.userRepository = userRepository;
/*  51 */     this.passwordEncoder = passwordEncoder;
/*  52 */     this.authorityRepository = authorityRepository;
/*  53 */     this.cacheManager = cacheManager;
/*     */   }
/*     */   
/*     */   public Optional<User> activateRegistration(String key) {
/*  57 */     this.log.debug("Activating user for activation key {}", key);
/*  58 */     return this.userRepository
/*  59 */       .findOneByActivationKey(key)
/*  60 */       .map(user -> {
/*     */           user.setActivated(true);
/*     */           user.setActivationKey(null);
/*     */           clearUserCaches(user);
/*     */           this.log.debug("Activated user: {}", user);
/*     */           return user;
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public Optional<User> completePasswordReset(String newPassword, String key) {
/*  71 */     this.log.debug("Reset user password for reset key {}", key);
/*  72 */     return this.userRepository
/*  73 */       .findOneByResetKey(key)
/*  74 */       .filter(user -> user.getResetDate().isAfter(Instant.now().minus(1L, ChronoUnit.DAYS)))
/*  75 */       .map(user -> {
/*     */           user.setPassword(this.passwordEncoder.encode(newPassword));
/*     */           user.setResetKey(null);
/*     */           user.setResetDate(null);
/*     */           clearUserCaches(user);
/*     */           return user;
/*     */         });
/*     */   }
/*     */   
/*     */   public Optional<User> requestPasswordReset(String mail) {
/*  85 */     return this.userRepository
/*  86 */       .findOneByEmailIgnoreCase(mail)
/*  87 */       .filter(User::isActivated)
/*  88 */       .map(user -> {
/*     */           user.setResetKey(RandomUtil.generateResetKey());
/*     */           user.setResetDate(Instant.now());
/*     */           clearUserCaches(user);
/*     */           return user;
/*     */         });
/*     */   }
/*     */   
/*     */   public User registerUser(AdminUserDTO userDTO, String password) {
/*  97 */     this.userRepository
/*  98 */       .findOneByLogin(userDTO.getLogin().toLowerCase())
/*  99 */       .ifPresent(existingUser -> {
/*     */           boolean removed = removeNonActivatedUser(existingUser);
/*     */           if (!removed) {
/*     */             throw new UsernameAlreadyUsedException();
/*     */           }
/*     */         });
/* 105 */     this.userRepository
/* 106 */       .findOneByEmailIgnoreCase(userDTO.getEmail())
/* 107 */       .ifPresent(existingUser -> {
/*     */           boolean removed = removeNonActivatedUser(existingUser);
/*     */           if (!removed) {
/*     */             throw new EmailAlreadyUsedException();
/*     */           }
/*     */         });
/* 113 */     User newUser = new User();
/* 114 */     String encryptedPassword = this.passwordEncoder.encode(password);
/* 115 */     newUser.setLogin(userDTO.getLogin().toLowerCase());
/*     */     
/* 117 */     newUser.setPassword(encryptedPassword);
/* 118 */     newUser.setFirstName(userDTO.getFirstName());
/* 119 */     newUser.setLastName(userDTO.getLastName());
/* 120 */     if (userDTO.getEmail() != null) {
/* 121 */       newUser.setEmail(userDTO.getEmail().toLowerCase());
/*     */     }
/* 123 */     newUser.setImageUrl(userDTO.getImageUrl());
/* 124 */     newUser.setLangKey(userDTO.getLangKey());
/*     */     
/* 126 */     newUser.setActivated(false);
/*     */     
/* 128 */     newUser.setActivationKey(RandomUtil.generateActivationKey());
/* 129 */     Set<Authority> authorities = new HashSet<>();
/* 130 */     Objects.requireNonNull(authorities); this.authorityRepository.findById("ROLE_USER").ifPresent(authorities::add);
/* 131 */     newUser.setAuthorities(authorities);
/* 132 */     this.userRepository.save(newUser);
/* 133 */     clearUserCaches(newUser);
/* 134 */     this.log.debug("Created Information for User: {}", newUser);
/* 135 */     return newUser;
/*     */   }
/*     */   
/*     */   private boolean removeNonActivatedUser(User existingUser) {
/* 139 */     if (existingUser.isActivated()) {
/* 140 */       return false;
/*     */     }
/* 142 */     this.userRepository.delete(existingUser);
/* 143 */     this.userRepository.flush();
/* 144 */     clearUserCaches(existingUser);
/* 145 */     return true;
/*     */   }
/*     */   
/*     */   public User createUser(AdminUserDTO userDTO) {
/* 149 */     User user = new User();
/* 150 */     user.setLogin(userDTO.getLogin().toLowerCase());
/* 151 */     user.setFirstName(userDTO.getFirstName());
/* 152 */     user.setLastName(userDTO.getLastName());
/* 153 */     if (userDTO.getEmail() != null) {
/* 154 */       user.setEmail(userDTO.getEmail().toLowerCase());
/*     */     }
/* 156 */     user.setImageUrl(userDTO.getImageUrl());
/* 157 */     if (userDTO.getLangKey() == null) {
/* 158 */       user.setLangKey("en");
/*     */     } else {
/* 160 */       user.setLangKey(userDTO.getLangKey());
/*     */     } 
/* 162 */     String encryptedPassword = this.passwordEncoder.encode(RandomUtil.generatePassword());
/* 163 */     user.setPassword(encryptedPassword);
/* 164 */     user.setResetKey(RandomUtil.generateResetKey());
/* 165 */     user.setResetDate(Instant.now());
/* 166 */     user.setActivated(true);
/* 167 */     if (userDTO.getAuthorities() != null) {
/*     */ 
/*     */ 
/*     */       
/* 171 */       Objects.requireNonNull(this.authorityRepository);
/*     */ 
/*     */       
/* 174 */       Set<Authority> authorities = (Set<Authority>)userDTO.getAuthorities().stream().map(this.authorityRepository::findById).filter(Optional::isPresent).map(Optional::get).collect(Collectors.toSet());
/* 175 */       user.setAuthorities(authorities);
/*     */     } 
/* 177 */     this.userRepository.save(user);
/* 178 */     clearUserCaches(user);
/* 179 */     this.log.debug("Created Information for User: {}", user);
/* 180 */     return user;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Optional<AdminUserDTO> updateUser(AdminUserDTO userDTO) {
/* 190 */     return 
/* 191 */       Optional.<Optional>of(this.userRepository.findById(userDTO.getId()))
/* 192 */       .filter(Optional::isPresent)
/* 193 */       .map(Optional::get)
/* 194 */       .map(user -> {
/*     */           clearUserCaches(user);
/*     */           
/*     */           user.setLogin(userDTO.getLogin().toLowerCase());
/*     */           
/*     */           user.setFirstName(userDTO.getFirstName());
/*     */           
/*     */           user.setLastName(userDTO.getLastName());
/*     */           
/*     */           if (userDTO.getEmail() != null) {
/*     */             user.setEmail(userDTO.getEmail().toLowerCase());
/*     */           }
/*     */           
/*     */           user.setImageUrl(userDTO.getImageUrl());
/*     */           user.setActivated(userDTO.isActivated());
/*     */           user.setLangKey(userDTO.getLangKey());
/*     */           Set<Authority> managedAuthorities = user.getAuthorities();
/*     */           managedAuthorities.clear();
/*     */           Objects.requireNonNull(this.authorityRepository);
/*     */           Objects.requireNonNull(managedAuthorities);
/*     */           userDTO.getAuthorities().stream().map(this.authorityRepository::findById).filter(Optional::isPresent).map(Optional::get).forEach(managedAuthorities::add);
/*     */           clearUserCaches(user);
/*     */           this.log.debug("Changed Information for User: {}", user);
/*     */           return user;
/* 218 */         }).map(AdminUserDTO::new);
/*     */   }
/*     */   
/*     */   public void deleteUser(String login) {
/* 222 */     this.userRepository
/* 223 */       .findOneByLogin(login)
/* 224 */       .ifPresent(user -> {
/*     */           this.userRepository.delete(user);
/*     */           clearUserCaches(user);
/*     */           this.log.debug("Deleted User: {}", user);
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateUser(String firstName, String lastName, String email, String langKey, String imageUrl) {
/* 243 */     Objects.requireNonNull(this.userRepository); SecurityUtils.getCurrentUserLogin().flatMap(this.userRepository::findOneByLogin)
/* 244 */       .ifPresent(user -> {
/*     */           user.setFirstName(firstName);
/*     */           user.setLastName(lastName);
/*     */           if (email != null) {
/*     */             user.setEmail(email.toLowerCase());
/*     */           }
/*     */           user.setLangKey(langKey);
/*     */           user.setImageUrl(imageUrl);
/*     */           clearUserCaches(user);
/*     */           this.log.debug("Changed Information for User: {}", user);
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional
/*     */   public void changePassword(String currentClearTextPassword, String newPassword) {
/* 261 */     Objects.requireNonNull(this.userRepository); SecurityUtils.getCurrentUserLogin().flatMap(this.userRepository::findOneByLogin)
/* 262 */       .ifPresent(user -> {
/*     */           String currentEncryptedPassword = user.getPassword();
/*     */           if (!this.passwordEncoder.matches(currentClearTextPassword, currentEncryptedPassword)) {
/*     */             throw new InvalidPasswordException();
/*     */           }
/*     */           String encryptedPassword = this.passwordEncoder.encode(newPassword);
/*     */           user.setPassword(encryptedPassword);
/*     */           clearUserCaches(user);
/*     */           this.log.debug("Changed password for User: {}", user);
/*     */         });
/*     */   }
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<AdminUserDTO> getAllManagedUsers(Pageable pageable) {
/* 276 */     return this.userRepository.findAll(pageable).map(AdminUserDTO::new);
/*     */   }
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Page<UserDTO> getAllPublicUsers(Pageable pageable) {
/* 281 */     return this.userRepository.findAllByIdNotNullAndActivatedIsTrue(pageable).map(UserDTO::new);
/*     */   }
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Optional<User> getUserWithAuthoritiesByLogin(String login) {
/* 286 */     return this.userRepository.findOneWithAuthoritiesByLogin(login);
/*     */   }
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public Optional<User> getUserWithAuthorities() {
/* 291 */     Objects.requireNonNull(this.userRepository); return SecurityUtils.getCurrentUserLogin().flatMap(this.userRepository::findOneWithAuthoritiesByLogin);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Scheduled(cron = "0 0 1 * * ?")
/*     */   public void removeNotActivatedUsers() {
/* 301 */     this.userRepository
/* 302 */       .findAllByActivatedIsFalseAndActivationKeyIsNotNullAndCreatedDateBefore(Instant.now().minus(3L, ChronoUnit.DAYS))
/* 303 */       .forEach(user -> {
/*     */           this.log.debug("Deleting not activated user {}", user.getLogin());
/*     */           this.userRepository.delete(user);
/*     */           clearUserCaches(user);
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<String> getAuthorities() {
/* 316 */     return (List<String>)this.authorityRepository.findAll().stream().map(Authority::getName).collect(Collectors.toList());
/*     */   }
/*     */   
/*     */   private void clearUserCaches(User user) {
/* 320 */     ((Cache)Objects.<Cache>requireNonNull(this.cacheManager.getCache("usersByLogin"))).evict(user.getLogin());
/* 321 */     if (user.getEmail() != null)
/* 322 */       ((Cache)Objects.<Cache>requireNonNull(this.cacheManager.getCache("usersByEmail"))).evict(user.getEmail()); 
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\UserService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */