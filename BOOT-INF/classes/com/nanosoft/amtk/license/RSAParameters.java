/*    */ package BOOT-INF.classes.com.nanosoft.amtk.license;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*    */ import java.math.BigInteger;
/*    */ import java.util.Base64;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RSAParameters
/*    */ {
/*    */   private String exponent;
/*    */   private String modulus;
/*    */   
/*    */   public RSAParameters() {}
/*    */   
/*    */   public RSAParameters(String ExponentString, String ModulusString) {
/* 18 */     this.exponent = ExponentString;
/* 19 */     this.modulus = ModulusString;
/*    */   }
/*    */   
/*    */   private BigInteger convertToBigInt(String str) {
/* 23 */     return new BigInteger(1, Base64.getDecoder().decode(str.trim()));
/*    */   }
/*    */   
/*    */   public String getExponent() {
/* 27 */     return this.exponent;
/*    */   }
/*    */   
/*    */   public void setExponent(String exponent) {
/* 31 */     this.exponent = exponent;
/*    */   }
/*    */   
/*    */   @JsonIgnore
/*    */   public BigInteger getExponentAsBigInt() {
/* 36 */     return convertToBigInt(this.exponent);
/*    */   }
/*    */   
/*    */   public String getModulus() {
/* 40 */     return this.modulus;
/*    */   }
/*    */   
/*    */   public void setModulus(String modulus) {
/* 44 */     this.modulus = modulus;
/*    */   }
/*    */   
/*    */   @JsonIgnore
/*    */   public BigInteger getModulusAsBigInt() {
/* 49 */     return convertToBigInt(this.modulus);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\license\RSAParameters.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */