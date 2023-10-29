package org.springframework.boot.loader.jarmode;

public interface JarMode {
  boolean accepts(String paramString);
  
  void run(String paramString, String[] paramArrayOfString);
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\org\springframework\boot\loader\jarmode\JarMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */