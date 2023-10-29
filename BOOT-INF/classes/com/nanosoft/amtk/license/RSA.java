/*    */ package BOOT-INF.classes.com.nanosoft.amtk.license;
/*    */ 
/*    */ import com.nanosoft.amtk.license.RSAParameters;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.security.KeyFactory;
/*    */ import java.security.MessageDigest;
/*    */ import java.security.PublicKey;
/*    */ import java.security.spec.RSAPublicKeySpec;
/*    */ import java.util.Base64;
/*    */ import javax.crypto.Cipher;
/*    */ 
/*    */ public class RSA {
/*    */   public static byte[] Encrypt(byte[] plainText, RSAParameters rSAParameters) throws Exception {
/* 14 */     KeyFactory factory = KeyFactory.getInstance("RSA");
/* 15 */     Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
/* 16 */     RSAPublicKeySpec RSAPublicKeySpec = new RSAPublicKeySpec(rSAParameters.getModulusAsBigInt(), rSAParameters.getExponentAsBigInt());
/* 17 */     PublicKey PublicKey = factory.generatePublic(RSAPublicKeySpec);
/* 18 */     cipher.init(1, PublicKey);
/* 19 */     return cipher.doFinal(plainText);
/*    */   }
/*    */   
/*    */   public static String SignString(String plainText, RSAParameters rSAParameters) throws Exception {
/* 23 */     MessageDigest digest = MessageDigest.getInstance("SHA-256");
/* 24 */     byte[] signatureBytes = digest.digest(plainText.getBytes(StandardCharsets.UTF_8));
/* 25 */     byte[] encryptedText = Encrypt(signatureBytes, rSAParameters);
/* 26 */     return Base64.getEncoder().encodeToString(encryptedText);
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\license\RSA.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */