package BOOT-INF.classes.com.nanosoft.amtk.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LicenseConfiguration implements WebMvcConfigurer {
  @Autowired
  private ObjectMapper objectMapper;
  
  @Value("${spring.datasource.url}")
  private String dbUrl;
  
  @Value("${server.port}")
  private String appPort;
  
  public void addInterceptors(InterceptorRegistry registry) {}
}


/* Location:              C:\Users\mouad\Documents\AMTK\amtk-191023.jar!\BOOT-INF\classes\com\nanosoft\amtk\config\LicenseConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */