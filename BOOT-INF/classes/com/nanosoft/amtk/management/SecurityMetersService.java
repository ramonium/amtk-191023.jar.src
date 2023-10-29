/*    */ package BOOT-INF.classes.com.nanosoft.amtk.management;
/*    */ 
/*    */ import io.micrometer.core.instrument.Counter;
/*    */ import io.micrometer.core.instrument.MeterRegistry;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class SecurityMetersService
/*    */ {
/*    */   public static final String INVALID_TOKENS_METER_NAME = "security.authentication.invalid-tokens";
/*    */   public static final String INVALID_TOKENS_METER_DESCRIPTION = "Indicates validation error count of the tokens presented by the clients.";
/*    */   public static final String INVALID_TOKENS_METER_BASE_UNIT = "errors";
/*    */   public static final String INVALID_TOKENS_METER_CAUSE_DIMENSION = "cause";
/*    */   private final Counter tokenInvalidSignatureCounter;
/*    */   private final Counter tokenExpiredCounter;
/*    */   private final Counter tokenUnsupportedCounter;
/*    */   private final Counter tokenMalformedCounter;
/*    */   
/*    */   public SecurityMetersService(MeterRegistry registry) {
/* 22 */     this.tokenInvalidSignatureCounter = invalidTokensCounterForCauseBuilder("invalid-signature").register(registry);
/* 23 */     this.tokenExpiredCounter = invalidTokensCounterForCauseBuilder("expired").register(registry);
/* 24 */     this.tokenUnsupportedCounter = invalidTokensCounterForCauseBuilder("unsupported").register(registry);
/* 25 */     this.tokenMalformedCounter = invalidTokensCounterForCauseBuilder("malformed").register(registry);
/*    */   }
/*    */   
/*    */   private Counter.Builder invalidTokensCounterForCauseBuilder(String cause) {
/* 29 */     return 
/* 30 */       Counter.builder("security.authentication.invalid-tokens")
/* 31 */       .baseUnit("errors")
/* 32 */       .description("Indicates validation error count of the tokens presented by the clients.")
/* 33 */       .tag("cause", cause);
/*    */   }
/*    */   
/*    */   public void trackTokenInvalidSignature() {
/* 37 */     this.tokenInvalidSignatureCounter.increment();
/*    */   }
/*    */   
/*    */   public void trackTokenExpired() {
/* 41 */     this.tokenExpiredCounter.increment();
/*    */   }
/*    */   
/*    */   public void trackTokenUnsupported() {
/* 45 */     this.tokenUnsupportedCounter.increment();
/*    */   }
/*    */   
/*    */   public void trackTokenMalformed() {
/* 49 */     this.tokenMalformedCounter.increment();
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\management\SecurityMetersService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */