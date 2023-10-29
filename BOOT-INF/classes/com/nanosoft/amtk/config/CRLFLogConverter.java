/*    */ package BOOT-INF.classes.com.nanosoft.amtk.config;
/*    */ 
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.core.pattern.CompositeConverter;
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.slf4j.Marker;
/*    */ import org.slf4j.MarkerFactory;
/*    */ import org.springframework.boot.ansi.AnsiColor;
/*    */ import org.springframework.boot.ansi.AnsiElement;
/*    */ import org.springframework.boot.ansi.AnsiOutput;
/*    */ import org.springframework.boot.ansi.AnsiStyle;
/*    */ 
/*    */ public class CRLFLogConverter
/*    */   extends CompositeConverter<ILoggingEvent> {
/* 17 */   public static final Marker CRLF_SAFE_MARKER = MarkerFactory.getMarker("CRLF_SAFE");
/*    */   
/* 19 */   private static final String[] SAFE_LOGGERS = new String[] { "org.hibernate" };
/*    */   private static final Map<String, AnsiElement> ELEMENTS;
/*    */   
/*    */   static {
/* 23 */     Map<String, AnsiElement> ansiElements = new HashMap<>();
/* 24 */     ansiElements.put("faint", AnsiStyle.FAINT);
/* 25 */     ansiElements.put("red", AnsiColor.RED);
/* 26 */     ansiElements.put("green", AnsiColor.GREEN);
/* 27 */     ansiElements.put("yellow", AnsiColor.YELLOW);
/* 28 */     ansiElements.put("blue", AnsiColor.BLUE);
/* 29 */     ansiElements.put("magenta", AnsiColor.MAGENTA);
/* 30 */     ansiElements.put("cyan", AnsiColor.CYAN);
/* 31 */     ELEMENTS = Collections.unmodifiableMap(ansiElements);
/*    */   }
/*    */ 
/*    */   
/*    */   protected String transform(ILoggingEvent event, String in) {
/* 36 */     AnsiElement element = ELEMENTS.get(getFirstOption());
/* 37 */     if ((event.getMarker() != null && event.getMarker().contains(CRLF_SAFE_MARKER)) || isLoggerSafe(event)) {
/* 38 */       return in;
/*    */     }
/* 40 */     String replacement = (element == null) ? "_" : toAnsiString("_", element);
/* 41 */     return in.replaceAll("[\n\r\t]", replacement);
/*    */   }
/*    */   
/*    */   protected boolean isLoggerSafe(ILoggingEvent event) {
/* 45 */     for (String safeLogger : SAFE_LOGGERS) {
/* 46 */       if (event.getLoggerName().startsWith(safeLogger)) {
/* 47 */         return true;
/*    */       }
/*    */     } 
/* 50 */     return false;
/*    */   }
/*    */   
/*    */   protected String toAnsiString(String in, AnsiElement element) {
/* 54 */     return AnsiOutput.toString(new Object[] { element, in });
/*    */   }
/*    */ }


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\config\CRLFLogConverter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */