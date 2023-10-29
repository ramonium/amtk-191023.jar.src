/*    */ package BOOT-INF.classes.com.nanosoft.amtk.license;
/*    */ 
/*    */ import com.nanosoft.amtk.license.ServerInfos;
/*    */ import java.io.IOException;
/*    */ import java.util.Scanner;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WindowsServerInfos
/*    */   implements ServerInfos
/*    */ {
/*    */   public String getMainBoardSerial() {
/* 18 */     String serialNumber = "";
/*    */ 
/*    */     
/*    */     try {
/* 22 */       Process process = Runtime.getRuntime().exec("wmic path win32_computersystemproduct get uuid");
/* 23 */       process.getOutputStream().close();
/* 24 */       Scanner scanner = new Scanner(process.getInputStream());
/*    */       
/* 26 */       if (scanner != null && scanner.hasNext()) {
/* 27 */         scanner.next();
/*    */       }
/*    */       
/* 30 */       if (scanner.hasNext()) {
/* 31 */         serialNumber = scanner.next().trim();
/*    */       }
/*    */       
/* 34 */       scanner.close();
/* 35 */     } catch (IOException e) {
/* 36 */       e.printStackTrace();
/*    */     } 
/* 38 */     return serialNumber;
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\license\WindowsServerInfos.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */