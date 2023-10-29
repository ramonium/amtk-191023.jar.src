/*     */ package BOOT-INF.classes.com.nanosoft.amtk.security.jwt;
/*     */ import com.nanosoft.amtk.management.SecurityMetersService;
/*     */ import io.jsonwebtoken.Claims;
/*     */ import io.jsonwebtoken.ExpiredJwtException;
/*     */ import io.jsonwebtoken.Jwts;
/*     */ import io.jsonwebtoken.MalformedJwtException;
/*     */ import io.jsonwebtoken.UnsupportedJwtException;
/*     */ import io.jsonwebtoken.security.SignatureException;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.stream.Collectors;
/*     */ import org.springframework.security.core.Authentication;
/*     */ import org.springframework.security.core.GrantedAuthority;
/*     */ import org.springframework.security.core.userdetails.User;
/*     */ import tech.jhipster.config.JHipsterProperties;
/*     */ 
/*     */ @Component
/*     */ public class TokenProvider {
/*     */   private final Logger log;
/*     */   private static final String AUTHORITIES_KEY = "auth";
/*     */   private static final String INVALID_JWT_TOKEN = "Invalid JWT token.";
/*     */   private final Key key;
/*     */   
/*     */   public TokenProvider(JHipsterProperties jHipsterProperties, SecurityMetersService securityMetersService) {
/*     */     byte[] keyBytes;
/*  26 */     this.log = LoggerFactory.getLogger(com.nanosoft.amtk.security.jwt.TokenProvider.class);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  44 */     String secret = jHipsterProperties.getSecurity().getAuthentication().getJwt().getBase64Secret();
/*  45 */     if (!ObjectUtils.isEmpty(secret)) {
/*  46 */       this.log.debug("Using a Base64-encoded JWT secret key");
/*  47 */       keyBytes = (byte[])Decoders.BASE64.decode(secret);
/*     */     } else {
/*  49 */       this.log.warn("Warning: the JWT key used is not Base64-encoded. We recommend using the `jhipster.security.authentication.jwt.base64-secret` key for optimum security.");
/*     */ 
/*     */ 
/*     */       
/*  53 */       secret = jHipsterProperties.getSecurity().getAuthentication().getJwt().getSecret();
/*  54 */       keyBytes = secret.getBytes(StandardCharsets.UTF_8);
/*     */     } 
/*  56 */     this.key = Keys.hmacShaKeyFor(keyBytes);
/*  57 */     this.jwtParser = Jwts.parserBuilder().setSigningKey(this.key).build();
/*  58 */     this.tokenValidityInMilliseconds = 1000L * jHipsterProperties.getSecurity().getAuthentication().getJwt().getTokenValidityInSeconds();
/*  59 */     this
/*  60 */       .tokenValidityInMillisecondsForRememberMe = 1000L * jHipsterProperties.getSecurity().getAuthentication().getJwt().getTokenValidityInSecondsForRememberMe();
/*     */     
/*  62 */     this.securityMetersService = securityMetersService;
/*     */   } private final JwtParser jwtParser; private final long tokenValidityInMilliseconds; private final long tokenValidityInMillisecondsForRememberMe; private final SecurityMetersService securityMetersService;
/*     */   public String createToken(Authentication authentication, boolean rememberMe) {
/*     */     Date validity;
/*  66 */     String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
/*     */     
/*  68 */     long now = (new Date()).getTime();
/*     */     
/*  70 */     if (rememberMe) {
/*  71 */       validity = new Date(now + this.tokenValidityInMillisecondsForRememberMe);
/*     */     } else {
/*  73 */       validity = new Date(now + this.tokenValidityInMilliseconds);
/*     */     } 
/*     */     
/*  76 */     return 
/*  77 */       Jwts.builder()
/*  78 */       .setSubject(authentication.getName())
/*  79 */       .claim("auth", authorities)
/*  80 */       .signWith(this.key, SignatureAlgorithm.HS512)
/*  81 */       .setExpiration(validity)
/*  82 */       .compact();
/*     */   }
/*     */   
/*     */   public Authentication getAuthentication(String token) {
/*  86 */     Claims claims = (Claims)this.jwtParser.parseClaimsJws(token).getBody();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     Collection<? extends GrantedAuthority> authorities = (Collection<? extends GrantedAuthority>)Arrays.<String>stream(claims.get("auth").toString().split(",")).filter(auth -> !auth.trim().isEmpty()).map(org.springframework.security.core.authority.SimpleGrantedAuthority::new).collect(Collectors.toList());
/*     */     
/*  94 */     User principal = new User(claims.getSubject(), "", authorities);
/*     */     
/*  96 */     return (Authentication)new UsernamePasswordAuthenticationToken(principal, token, authorities);
/*     */   }
/*     */   
/*     */   public boolean validateToken(String authToken) {
/*     */     try {
/* 101 */       this.jwtParser.parseClaimsJws(authToken);
/*     */       
/* 103 */       return true;
/* 104 */     } catch (ExpiredJwtException e) {
/* 105 */       this.securityMetersService.trackTokenExpired();
/*     */       
/* 107 */       this.log.trace("Invalid JWT token.", (Throwable)e);
/* 108 */     } catch (UnsupportedJwtException e) {
/* 109 */       this.securityMetersService.trackTokenUnsupported();
/*     */       
/* 111 */       this.log.trace("Invalid JWT token.", (Throwable)e);
/* 112 */     } catch (MalformedJwtException e) {
/* 113 */       this.securityMetersService.trackTokenMalformed();
/*     */       
/* 115 */       this.log.trace("Invalid JWT token.", (Throwable)e);
/* 116 */     } catch (SignatureException e) {
/* 117 */       this.securityMetersService.trackTokenInvalidSignature();
/*     */       
/* 119 */       this.log.trace("Invalid JWT token.", (Throwable)e);
/* 120 */     } catch (IllegalArgumentException e) {
/* 121 */       this.log.error("Token validation error {}", e.getMessage());
/*     */     } 
/*     */     
/* 124 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\security\jwt\TokenProvider.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */