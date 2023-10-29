/*     */ package BOOT-INF.classes.com.nanosoft.amtk.web.rest.errors;
/*     */ 
/*     */ import com.nanosoft.amtk.service.EmailAlreadyUsedException;
/*     */ import com.nanosoft.amtk.service.InvalidPasswordException;
/*     */ import com.nanosoft.amtk.service.UsernameAlreadyUsedException;
/*     */ import com.nanosoft.amtk.web.rest.errors.BadRequestAlertException;
/*     */ import com.nanosoft.amtk.web.rest.errors.EmailAlreadyUsedException;
/*     */ import com.nanosoft.amtk.web.rest.errors.ErrorConstants;
/*     */ import com.nanosoft.amtk.web.rest.errors.FieldErrorVM;
/*     */ import com.nanosoft.amtk.web.rest.errors.InvalidPasswordException;
/*     */ import com.nanosoft.amtk.web.rest.errors.LoginAlreadyUsedException;
/*     */ import java.net.URI;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.annotation.Nonnull;
/*     */ import javax.annotation.Nullable;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.core.env.Environment;
/*     */ import org.springframework.dao.ConcurrencyFailureException;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.util.MultiValueMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.validation.FieldError;
/*     */ import org.springframework.web.bind.MethodArgumentNotValidException;
/*     */ import org.springframework.web.bind.annotation.ControllerAdvice;
/*     */ import org.springframework.web.bind.annotation.ExceptionHandler;
/*     */ import org.springframework.web.context.request.NativeWebRequest;
/*     */ import org.zalando.problem.DefaultProblem;
/*     */ import org.zalando.problem.Problem;
/*     */ import org.zalando.problem.ProblemBuilder;
/*     */ import org.zalando.problem.Status;
/*     */ import org.zalando.problem.StatusType;
/*     */ import org.zalando.problem.ThrowableProblem;
/*     */ import org.zalando.problem.spring.web.advice.ProblemHandling;
/*     */ import org.zalando.problem.spring.web.advice.security.SecurityAdviceTrait;
/*     */ import org.zalando.problem.violations.ConstraintViolationProblem;
/*     */ import tech.jhipster.web.util.HeaderUtil;
/*     */ 
/*     */ @ControllerAdvice
/*     */ public class ExceptionTranslator
/*     */   implements ProblemHandling, SecurityAdviceTrait {
/*     */   private static final String FIELD_ERRORS_KEY = "fieldErrors";
/*     */   private static final String MESSAGE_KEY = "message";
/*     */   private static final String PATH_KEY = "path";
/*     */   
/*     */   public ExceptionTranslator(Environment env) {
/*  53 */     this.env = env;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final String VIOLATIONS_KEY = "violations";
/*     */ 
/*     */   
/*     */   public ResponseEntity<Problem> process(@Nullable ResponseEntity<Problem> entity, NativeWebRequest request) {
/*  61 */     if (entity == null) {
/*  62 */       return null;
/*     */     }
/*  64 */     Problem problem = (Problem)entity.getBody();
/*  65 */     if (!(problem instanceof ConstraintViolationProblem) && !(problem instanceof DefaultProblem)) {
/*  66 */       return entity;
/*     */     }
/*     */     
/*  69 */     HttpServletRequest nativeRequest = (HttpServletRequest)request.getNativeRequest(HttpServletRequest.class);
/*  70 */     String requestUri = (nativeRequest != null) ? nativeRequest.getRequestURI() : "";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     ProblemBuilder builder = Problem.builder().withType(Problem.DEFAULT_TYPE.equals(problem.getType()) ? ErrorConstants.DEFAULT_TYPE : problem.getType()).withStatus(problem.getStatus()).withTitle(problem.getTitle()).with("path", requestUri);
/*     */     
/*  78 */     if (problem instanceof ConstraintViolationProblem) {
/*  79 */       builder
/*  80 */         .with("violations", ((ConstraintViolationProblem)problem).getViolations())
/*  81 */         .with("message", "error.validation");
/*     */     } else {
/*  83 */       builder.withCause(((DefaultProblem)problem).getCause()).withDetail(problem.getDetail()).withInstance(problem.getInstance());
/*  84 */       Objects.requireNonNull(builder); problem.getParameters().forEach(builder::with);
/*  85 */       if (!problem.getParameters().containsKey("message") && problem.getStatus() != null) {
/*  86 */         builder.with("message", "error.http." + problem.getStatus().getStatusCode());
/*     */       }
/*     */     } 
/*  89 */     return new ResponseEntity(builder.build(), (MultiValueMap)entity.getHeaders(), entity.getStatusCode());
/*     */   }
/*     */   @Value("${jhipster.clientApp.name}")
/*     */   private String applicationName; private final Environment env;
/*     */   public ResponseEntity<Problem> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, @Nonnull NativeWebRequest request) {
/*  94 */     BindingResult result = ex.getBindingResult();
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
/* 105 */     List<FieldErrorVM> fieldErrors = (List<FieldErrorVM>)result.getFieldErrors().stream().map(f -> new FieldErrorVM(f.getObjectName().replaceFirst("DTO$", ""), f.getField(), StringUtils.isNotBlank(f.getDefaultMessage()) ? f.getDefaultMessage() : f.getCode())).collect(Collectors.toList());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     ThrowableProblem throwableProblem = Problem.builder().withType(ErrorConstants.CONSTRAINT_VIOLATION_TYPE).withTitle("Method argument not valid").withStatus(defaultConstraintViolationStatus()).with("message", "error.validation").with("fieldErrors", fieldErrors).build();
/* 115 */     return create((Throwable)ex, (Problem)throwableProblem, request);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @ExceptionHandler
/*     */   public ResponseEntity<Problem> handleEmailAlreadyUsedException(EmailAlreadyUsedException ex, NativeWebRequest request) {
/* 123 */     EmailAlreadyUsedException problem = new EmailAlreadyUsedException();
/* 124 */     return create((ThrowableProblem)problem, request, 
/*     */ 
/*     */         
/* 127 */         HeaderUtil.createFailureAlert(this.applicationName, true, problem.getEntityName(), problem.getErrorKey(), problem.getMessage()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @ExceptionHandler
/*     */   public ResponseEntity<Problem> handleUsernameAlreadyUsedException(UsernameAlreadyUsedException ex, NativeWebRequest request) {
/* 136 */     LoginAlreadyUsedException problem = new LoginAlreadyUsedException();
/* 137 */     return create((ThrowableProblem)problem, request, 
/*     */ 
/*     */         
/* 140 */         HeaderUtil.createFailureAlert(this.applicationName, true, problem.getEntityName(), problem.getErrorKey(), problem.getMessage()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @ExceptionHandler
/*     */   public ResponseEntity<Problem> handleInvalidPasswordException(InvalidPasswordException ex, NativeWebRequest request) {
/* 149 */     return create((ThrowableProblem)new InvalidPasswordException(), request);
/*     */   }
/*     */   
/*     */   @ExceptionHandler
/*     */   public ResponseEntity<Problem> handleBadRequestAlertException(BadRequestAlertException ex, NativeWebRequest request) {
/* 154 */     return create((ThrowableProblem)ex, request, 
/*     */ 
/*     */         
/* 157 */         HeaderUtil.createFailureAlert(this.applicationName, true, ex.getEntityName(), ex.getErrorKey(), ex.getMessage()));
/*     */   }
/*     */ 
/*     */   
/*     */   @ExceptionHandler
/*     */   public ResponseEntity<Problem> handleConcurrencyFailure(ConcurrencyFailureException ex, NativeWebRequest request) {
/* 163 */     ThrowableProblem throwableProblem = Problem.builder().withStatus((StatusType)Status.CONFLICT).with("message", "error.concurrencyFailure").build();
/* 164 */     return create((Throwable)ex, (Problem)throwableProblem, request);
/*     */   }
/*     */ 
/*     */   
/*     */   public ProblemBuilder prepare(Throwable throwable, StatusType status, URI type) {
/* 169 */     Collection<String> activeProfiles = Arrays.asList(this.env.getActiveProfiles());
/*     */     
/* 171 */     if (activeProfiles.contains("prod")) {
/* 172 */       if (throwable instanceof org.springframework.http.converter.HttpMessageConversionException) {
/* 173 */         return 
/* 174 */           Problem.builder()
/* 175 */           .withType(type)
/* 176 */           .withTitle(status.getReasonPhrase())
/* 177 */           .withStatus(status)
/* 178 */           .withDetail("Unable to convert http message")
/* 179 */           .withCause(
/* 180 */             Optional.<Throwable>ofNullable(throwable.getCause()).filter(cause -> isCausalChainsEnabled()).map(this::toProblem).orElse(null));
/*     */       }
/*     */       
/* 183 */       if (throwable instanceof org.springframework.dao.DataAccessException) {
/* 184 */         return 
/* 185 */           Problem.builder()
/* 186 */           .withType(type)
/* 187 */           .withTitle(status.getReasonPhrase())
/* 188 */           .withStatus(status)
/* 189 */           .withDetail("Failure during data access")
/* 190 */           .withCause(
/* 191 */             Optional.<Throwable>ofNullable(throwable.getCause()).filter(cause -> isCausalChainsEnabled()).map(this::toProblem).orElse(null));
/*     */       }
/*     */       
/* 194 */       if (containsPackageName(throwable.getMessage())) {
/* 195 */         return 
/* 196 */           Problem.builder()
/* 197 */           .withType(type)
/* 198 */           .withTitle(status.getReasonPhrase())
/* 199 */           .withStatus(status)
/* 200 */           .withDetail("Unexpected runtime exception")
/* 201 */           .withCause(
/* 202 */             Optional.<Throwable>ofNullable(throwable.getCause()).filter(cause -> isCausalChainsEnabled()).map(this::toProblem).orElse(null));
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 207 */     return 
/* 208 */       Problem.builder()
/* 209 */       .withType(type)
/* 210 */       .withTitle(status.getReasonPhrase())
/* 211 */       .withStatus(status)
/* 212 */       .withDetail(throwable.getMessage())
/* 213 */       .withCause(
/* 214 */         Optional.<Throwable>ofNullable(throwable.getCause()).filter(cause -> isCausalChainsEnabled()).map(this::toProblem).orElse(null));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean containsPackageName(String message) {
/* 220 */     return StringUtils.containsAny(message, new CharSequence[] { "org.", "java.", "net.", "javax.", "com.", "io.", "de.", "com.nanosoft.amtk" });
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\web\rest\errors\ExceptionTranslator.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */