/*    */ package BOOT-INF.classes.com.nanosoft.amtk.license;
/*    */ 
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.security.KeyFactory;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ import java.security.PrivateKey;
/*    */ import java.security.PublicKey;
/*    */ import java.security.Signature;
/*    */ import java.security.spec.InvalidKeySpecException;
/*    */ import java.security.spec.PKCS8EncodedKeySpec;
/*    */ import java.security.spec.X509EncodedKeySpec;
/*    */ import java.util.Base64;
/*    */ 
/*    */ public class DSA
/*    */ {
/*    */   private static final String SIGNING_ALGORITHM = "SHA256withRSA";
/*    */   private static final String RSA = "RSA";
/*    */   private PublicKey publicKey;
/*    */   
/*    */   public PublicKey loadPublicKey(byte[] keyBytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
/* 21 */     KeyFactory keyFactory = KeyFactory.getInstance("RSA");
/* 22 */     X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(keyBytes);
/* 23 */     this.publicKey = keyFactory.generatePublic(publicKeySpec);
/* 24 */     return this.publicKey;
/*    */   }
/*    */   
/*    */   public PublicKey loadPublicKey(String key) throws NoSuchAlgorithmException, InvalidKeySpecException {
/* 28 */     return loadPublicKey(Base64.getDecoder().decode(key.getBytes(StandardCharsets.UTF_8)));
/*    */   }
/*    */   
/*    */   public PrivateKey loadPrivateKey(byte[] keyBytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
/* 32 */     KeyFactory keyFactory = KeyFactory.getInstance("RSA");
/* 33 */     PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(keyBytes);
/* 34 */     return keyFactory.generatePrivate(privateKeySpec);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean verifyDigitalSignature(byte[] input, byte[] signatureToVerify, String publicKey) throws Exception {
/* 40 */     loadPublicKey(publicKey);
/* 41 */     Signature signature = Signature.getInstance("SHA256withRSA");
/* 42 */     signature.initVerify(this.publicKey);
/* 43 */     signature.update(input);
/* 44 */     return signature.verify(signatureToVerify);
/*    */   }
/*    */   
/*    */   public PublicKey getPublicKey() {
/* 48 */     return this.publicKey;
/*    */   }
/*    */   
/*    */   public void setPublicKey(PublicKey publicKey) {
/* 52 */     this.publicKey = publicKey;
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\license\DSA.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */