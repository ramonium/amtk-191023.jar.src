/*     */ package BOOT-INF.classes.com.nanosoft.amtk.license;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import com.nanosoft.amtk.license.DSA;
/*     */ import com.nanosoft.amtk.license.Feature;
/*     */ import com.nanosoft.amtk.license.License;
/*     */ import com.nanosoft.amtk.license.LicenseTerms;
/*     */ import com.nanosoft.amtk.license.LinuxServerInfos;
/*     */ import com.nanosoft.amtk.license.WindowsServerInfos;
/*     */ import java.io.File;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.time.Instant;
/*     */ import java.time.LocalDate;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ public class LicenseCheckInterceptor implements HandlerInterceptor {
/*  19 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.license.LicenseCheckInterceptor.class);
/*     */   
/*     */   private final String appPort;
/*     */   
/*     */   private final ObjectMapper objectMapper;
/*     */   
/*     */   private boolean lastLicenseStatus = false;
/*     */   
/*     */   private Instant lastLicenseCheck;
/*     */   
/*     */   public LicenseCheckInterceptor(String appPort, ObjectMapper objectMapper) {
/*  30 */     this.appPort = appPort;
/*  31 */     this.objectMapper = objectMapper;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
/*  36 */     if (!this.lastLicenseStatus || this.lastLicenseCheck.isBefore(Instant.now().plus(-2L, ChronoUnit.HOURS))) {
/*  37 */       LinuxServerInfos linuxServerInfos; License license; String osName = System.getProperty("os.name").toLowerCase();
/*     */ 
/*     */       
/*  40 */       if (osName.startsWith("windows")) {
/*  41 */         WindowsServerInfos windowsServerInfos = new WindowsServerInfos();
/*  42 */       } else if (osName.startsWith("linux")) {
/*  43 */         linuxServerInfos = new LinuxServerInfos();
/*     */       } else {
/*  45 */         linuxServerInfos = new LinuxServerInfos();
/*     */       } 
/*     */       
/*  48 */       String fileName = "License.lic";
/*  49 */       File f = new File(fileName);
/*     */       
/*  51 */       if (f.exists()) {
/*  52 */         license = (License)this.objectMapper.readValue(f, License.class);
/*     */       } else {
/*  54 */         this.log.info("Device id {}", linuxServerInfos.getMainBoardSerial());
/*  55 */         this.log.info("Server port {}", this.appPort);
/*  56 */         this.log.info("License file not found");
/*  57 */         response.setStatus(503);
/*  58 */         response.getWriter().write("License file not found");
/*  59 */         response.getWriter().flush();
/*  60 */         return false;
/*     */       } 
/*     */       
/*  63 */       license.setLicenseTerms((LicenseTerms)this.objectMapper.readValue(license.getLicenseTermsData(), LicenseTerms.class));
/*  64 */       String licenseTermsStr = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(license.getLicenseTerms());
/*     */       
/*  66 */       DSA dsa = new DSA();
/*  67 */       byte[] licenseTermsBytes = licenseTermsStr.getBytes(StandardCharsets.UTF_8);
/*  68 */       byte[] signature = Base64.getDecoder().decode(license.getSignature().getBytes(StandardCharsets.UTF_8));
/*  69 */       boolean isCertified = dsa.verifyDigitalSignature(licenseTermsBytes, signature, license.getKeyStore());
/*     */       
/*  71 */       if (!isCertified) {
/*  72 */         response.setStatus(503);
/*  73 */         this.log.info("Device id {}", linuxServerInfos.getMainBoardSerial());
/*  74 */         this.log.info("Server port {}", this.appPort);
/*  75 */         response.getWriter().write("License check failed");
/*  76 */         response.getWriter().flush();
/*  77 */         return false;
/*     */       } 
/*     */       
/*  80 */       if (!license.getLicenseTerms().getDeviceId().equals(linuxServerInfos.getMainBoardSerial())) {
/*  81 */         this.log.info("Device id {}", linuxServerInfos.getMainBoardSerial());
/*  82 */         this.log.info("Server port {}", this.appPort);
/*  83 */         response.setStatus(503);
/*  84 */         response.getWriter().write("License file is generated for other machine");
/*  85 */         response.getWriter().flush();
/*  86 */         return false;
/*     */       } 
/*     */       
/*  89 */       if (license.getLicenseTerms().getFeatures().stream().noneMatch(feature -> feature.getName().equals("port"))) {
/*  90 */         this.log.info("Device id {}", linuxServerInfos.getMainBoardSerial());
/*  91 */         this.log.info("Server port {}", this.appPort);
/*  92 */         response.setStatus(503);
/*  93 */         response.getWriter().write("License file is generated for other machine");
/*  94 */         response.getWriter().flush();
/*  95 */         return false;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 103 */       Feature feature = license.getLicenseTerms().getFeatures().stream().filter(feature1 -> feature1.getName().equals("port")).findFirst().get();
/* 104 */       if (!feature.getDescription().equals(this.appPort)) {
/* 105 */         this.log.info("Device id {}", linuxServerInfos.getMainBoardSerial());
/* 106 */         this.log.info("Server port {}", this.appPort);
/* 107 */         response.setStatus(503);
/* 108 */         response.getWriter().write("License file is generated for other machine");
/* 109 */         response.getWriter().flush();
/* 110 */         return false;
/*     */       } 
/*     */ 
/*     */       
/* 114 */       if (!LocalDate.now().isAfter(license.getLicenseTerms().getStartDate())) {
/* 115 */         response.setStatus(503);
/* 116 */         response.getWriter().write("License start not yet reached");
/* 117 */         response.getWriter().flush();
/* 118 */         return false;
/*     */       } 
/*     */       
/* 121 */       if (!LocalDate.now().isBefore(license.getLicenseTerms().getEndDate())) {
/* 122 */         response.setStatus(503);
/* 123 */         response.getWriter().write("License expired");
/* 124 */         response.getWriter().flush();
/* 125 */         return false;
/*     */       } 
/*     */       
/* 128 */       this.lastLicenseStatus = true;
/* 129 */       this.lastLicenseCheck = Instant.now();
/*     */     } 
/*     */     
/* 132 */     return super.preHandle(request, response, handler);
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\license\LicenseCheckInterceptor.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */