/*     */ package BOOT-INF.classes.com.nanosoft.amtk.config;
/*     */ 
/*     */ import com.nanosoft.amtk.security.jwt.JWTConfigurer;
/*     */ import com.nanosoft.amtk.security.jwt.TokenProvider;
/*     */ import javax.servlet.Filter;
/*     */ import org.springframework.context.annotation.Bean;
/*     */ import org.springframework.context.annotation.Import;
/*     */ import org.springframework.http.HttpMethod;
/*     */ import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
/*     */ import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
/*     */ import org.springframework.security.config.annotation.web.builders.HttpSecurity;
/*     */ import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
/*     */ import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
/*     */ import org.springframework.security.config.http.SessionCreationPolicy;
/*     */ import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/*     */ import org.springframework.security.crypto.password.PasswordEncoder;
/*     */ import org.springframework.security.web.AuthenticationEntryPoint;
/*     */ import org.springframework.security.web.SecurityFilterChain;
/*     */ import org.springframework.security.web.access.AccessDeniedHandler;
/*     */ import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
/*     */ import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;
/*     */ import org.springframework.web.filter.CorsFilter;
/*     */ import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport;
/*     */ import tech.jhipster.config.JHipsterProperties;
/*     */ 
/*     */ 
/*     */ 
/*     */ @EnableWebSecurity
/*     */ @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
/*     */ @Import({SecurityProblemSupport.class})
/*     */ public class SecurityConfiguration
/*     */ {
/*     */   private final JHipsterProperties jHipsterProperties;
/*     */   private final TokenProvider tokenProvider;
/*     */   private final CorsFilter corsFilter;
/*     */   private final SecurityProblemSupport problemSupport;
/*     */   
/*     */   public SecurityConfiguration(TokenProvider tokenProvider, CorsFilter corsFilter, JHipsterProperties jHipsterProperties, SecurityProblemSupport problemSupport) {
/*  39 */     this.tokenProvider = tokenProvider;
/*  40 */     this.corsFilter = corsFilter;
/*  41 */     this.problemSupport = problemSupport;
/*  42 */     this.jHipsterProperties = jHipsterProperties;
/*     */   }
/*     */   
/*     */   @Bean
/*     */   public PasswordEncoder passwordEncoder() {
/*  47 */     return (PasswordEncoder)new BCryptPasswordEncoder();
/*     */   }
/*     */ 
/*     */   
/*     */   @Bean
/*     */   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
/*  53 */     ((HttpSecurity)((HttpSecurity)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((HttpSecurity)((HttpSecurity)((HttpSecurity)((HttpSecurity)http
/*  54 */       .csrf()
/*  55 */       .disable())
/*  56 */       .addFilterBefore((Filter)this.corsFilter, UsernamePasswordAuthenticationFilter.class)
/*  57 */       .exceptionHandling()
/*  58 */       .authenticationEntryPoint((AuthenticationEntryPoint)this.problemSupport)
/*  59 */       .accessDeniedHandler((AccessDeniedHandler)this.problemSupport)
/*  60 */       .and())
/*  61 */       .headers()
/*  62 */       .contentSecurityPolicy(this.jHipsterProperties.getSecurity().getContentSecurityPolicy())
/*  63 */       .and()
/*  64 */       .referrerPolicy(ReferrerPolicyHeaderWriter.ReferrerPolicy.STRICT_ORIGIN_WHEN_CROSS_ORIGIN)
/*  65 */       .and()
/*  66 */       .permissionsPolicy().policy("camera=(), fullscreen=(self), geolocation=(), gyroscope=(), magnetometer=(), microphone=(), midi=(), payment=(), sync-xhr=()")
/*  67 */       .and()
/*  68 */       .frameOptions().sameOrigin()
/*  69 */       .and())
/*  70 */       .sessionManagement()
/*  71 */       .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
/*  72 */       .and())
/*  73 */       .authorizeRequests()
/*  74 */       .antMatchers(HttpMethod.OPTIONS, new String[] { "/**" })).permitAll()
/*  75 */       .antMatchers(new String[] { "/app/**/*.{js,html}" })).permitAll()
/*  76 */       .antMatchers(new String[] { "/i18n/**" })).permitAll()
/*  77 */       .antMatchers(new String[] { "/assets/**" })).permitAll()
/*  78 */       .antMatchers(new String[] { "/content/**" })).permitAll()
/*  79 */       .antMatchers(new String[] { "/swagger-ui/**" })).permitAll()
/*  80 */       .antMatchers(new String[] { "/test/**" })).permitAll()
/*  81 */       .antMatchers(new String[] { "/api/authenticate" })).permitAll()
/*  82 */       .antMatchers(new String[] { "/api/register" })).permitAll()
/*  83 */       .antMatchers(new String[] { "/api/activate" })).permitAll()
/*  84 */       .antMatchers(new String[] { "/api/account/reset-password/init" })).permitAll()
/*  85 */       .antMatchers(new String[] { "/api/account/reset-password/finish" })).permitAll()
/*  86 */       .antMatchers(new String[] { "/api/admin/**" })).hasAuthority("ROLE_ADMIN")
/*  87 */       .antMatchers(new String[] { "/api/**" })).authenticated()
/*  88 */       .antMatchers(new String[] { "/management/health" })).permitAll()
/*  89 */       .antMatchers(new String[] { "/management/health/**" })).permitAll()
/*  90 */       .antMatchers(new String[] { "/management/info" })).permitAll()
/*  91 */       .antMatchers(new String[] { "/management/prometheus" })).permitAll()
/*  92 */       .antMatchers(new String[] { "/management/**" })).hasAuthority("ROLE_ADMIN")
/*  93 */       .and())
/*  94 */       .httpBasic()
/*  95 */       .and())
/*  96 */       .apply((SecurityConfigurerAdapter)securityConfigurerAdapter());
/*  97 */     return (SecurityFilterChain)http.build();
/*     */   }
/*     */ 
/*     */   
/*     */   private JWTConfigurer securityConfigurerAdapter() {
/* 102 */     return new JWTConfigurer(this.tokenProvider);
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\config\SecurityConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */