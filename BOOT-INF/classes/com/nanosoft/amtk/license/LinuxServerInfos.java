/*    */ package BOOT-INF.classes.com.nanosoft.amtk.license;
/*    */ 
/*    */ import com.nanosoft.amtk.license.ServerInfos;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LinuxServerInfos
/*    */   implements ServerInfos
/*    */ {
/*    */   public String getMainBoardSerial() {
/* 20 */     String serialNumber = "";
/*    */ 
/*    */     
/*    */     try {
/* 24 */       String[] shell = { "/bin/bash", "-c", "dmidecode | grep 'Serial Number' | awk -F ':' '{print $2}' | head -n 1" };
/* 25 */       Process process = null;
/* 26 */       process = Runtime.getRuntime().exec(shell);
/* 27 */       process.getOutputStream().close();
/*    */       
/* 29 */       BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
/*    */       
/* 31 */       String line = reader.readLine().trim();
/* 32 */       if (StringUtils.isNotBlank(line)) {
/* 33 */         serialNumber = line;
/*    */       }
/*    */       
/* 36 */       reader.close();
/* 37 */     } catch (IOException e) {
/* 38 */       e.printStackTrace();
/*    */     } 
/*    */     
/* 41 */     return serialNumber;
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\license\LinuxServerInfos.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */