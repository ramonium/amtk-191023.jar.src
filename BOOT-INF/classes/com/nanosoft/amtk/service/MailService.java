/*     */ package BOOT-INF.classes.com.nanosoft.amtk.service;
/*     */ 
/*     */ import com.nanosoft.amtk.domain.User;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.Locale;
/*     */ import javax.mail.internet.MimeMessage;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.context.MessageSource;
/*     */ import org.springframework.mail.MailException;
/*     */ import org.springframework.mail.javamail.JavaMailSender;
/*     */ import org.springframework.mail.javamail.MimeMessageHelper;
/*     */ import org.springframework.scheduling.annotation.Async;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.thymeleaf.context.Context;
/*     */ import org.thymeleaf.context.IContext;
/*     */ import org.thymeleaf.spring5.SpringTemplateEngine;
/*     */ import tech.jhipster.config.JHipsterProperties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class MailService
/*     */ {
/*  28 */   private final Logger log = LoggerFactory.getLogger(com.nanosoft.amtk.service.MailService.class);
/*     */ 
/*     */   
/*     */   private static final String USER = "user";
/*     */ 
/*     */   
/*     */   private static final String BASE_URL = "baseUrl";
/*     */ 
/*     */   
/*     */   private final JHipsterProperties jHipsterProperties;
/*     */ 
/*     */   
/*     */   private final JavaMailSender javaMailSender;
/*     */   
/*     */   private final MessageSource messageSource;
/*     */   
/*     */   private final SpringTemplateEngine templateEngine;
/*     */ 
/*     */   
/*     */   public MailService(JHipsterProperties jHipsterProperties, JavaMailSender javaMailSender, MessageSource messageSource, SpringTemplateEngine templateEngine) {
/*  48 */     this.jHipsterProperties = jHipsterProperties;
/*  49 */     this.javaMailSender = javaMailSender;
/*  50 */     this.messageSource = messageSource;
/*  51 */     this.templateEngine = templateEngine;
/*     */   }
/*     */   
/*     */   @Async
/*     */   public void sendEmail(String to, String subject, String content, boolean isMultipart, boolean isHtml) {
/*  56 */     this.log.debug("Send email[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}", new Object[] {
/*     */           
/*  58 */           Boolean.valueOf(isMultipart), 
/*  59 */           Boolean.valueOf(isHtml), to, subject, content
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  66 */     MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
/*     */     try {
/*  68 */       MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, StandardCharsets.UTF_8.name());
/*  69 */       message.setTo(to);
/*  70 */       message.setFrom(this.jHipsterProperties.getMail().getFrom());
/*  71 */       message.setSubject(subject);
/*  72 */       message.setText(content, isHtml);
/*  73 */       this.javaMailSender.send(mimeMessage);
/*  74 */       this.log.debug("Sent email to User '{}'", to);
/*  75 */     } catch (MailException|javax.mail.MessagingException e) {
/*  76 */       this.log.warn("Email could not be sent to user '{}'", to, e);
/*     */     } 
/*     */   }
/*     */   
/*     */   @Async
/*     */   public void sendEmailFromTemplate(User user, String templateName, String titleKey) {
/*  82 */     if (user.getEmail() == null) {
/*  83 */       this.log.debug("Email doesn't exist for user '{}'", user.getLogin());
/*     */       return;
/*     */     } 
/*  86 */     Locale locale = Locale.forLanguageTag(user.getLangKey());
/*  87 */     Context context = new Context(locale);
/*  88 */     context.setVariable("user", user);
/*  89 */     context.setVariable("baseUrl", this.jHipsterProperties.getMail().getBaseUrl());
/*  90 */     String content = this.templateEngine.process(templateName, (IContext)context);
/*  91 */     String subject = this.messageSource.getMessage(titleKey, null, locale);
/*  92 */     sendEmail(user.getEmail(), subject, content, false, true);
/*     */   }
/*     */   
/*     */   @Async
/*     */   public void sendActivationEmail(User user) {
/*  97 */     this.log.debug("Sending activation email to '{}'", user.getEmail());
/*  98 */     sendEmailFromTemplate(user, "mail/activationEmail", "email.activation.title");
/*     */   }
/*     */   
/*     */   @Async
/*     */   public void sendCreationEmail(User user) {
/* 103 */     this.log.debug("Sending creation email to '{}'", user.getEmail());
/* 104 */     sendEmailFromTemplate(user, "mail/creationEmail", "email.activation.title");
/*     */   }
/*     */   
/*     */   @Async
/*     */   public void sendPasswordResetMail(User user) {
/* 109 */     this.log.debug("Sending password reset email to '{}'", user.getEmail());
/* 110 */     sendEmailFromTemplate(user, "mail/passwordResetEmail", "email.reset.title");
/*     */   }
/*     */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\service\MailService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */