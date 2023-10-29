package BOOT-INF.classes.com.nanosoft.amtk.repository;

import com.nanosoft.amtk.domain.User;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  public static final String USERS_BY_LOGIN_CACHE = "usersByLogin";
  
  public static final String USERS_BY_EMAIL_CACHE = "usersByEmail";
  
  Optional<User> findOneByActivationKey(String paramString);
  
  List<User> findAllByActivatedIsFalseAndActivationKeyIsNotNullAndCreatedDateBefore(Instant paramInstant);
  
  Optional<User> findOneByResetKey(String paramString);
  
  Optional<User> findOneByEmailIgnoreCase(String paramString);
  
  Optional<User> findOneByLogin(String paramString);
  
  @EntityGraph(attributePaths = {"authorities"})
  @Cacheable(cacheNames = {"usersByLogin"})
  Optional<User> findOneWithAuthoritiesByLogin(String paramString);
  
  @EntityGraph(attributePaths = {"authorities"})
  @Cacheable(cacheNames = {"usersByEmail"})
  Optional<User> findOneWithAuthoritiesByEmailIgnoreCase(String paramString);
  
  Page<User> findAllByIdNotNullAndActivatedIsTrue(Pageable paramPageable);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\repository\UserRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */