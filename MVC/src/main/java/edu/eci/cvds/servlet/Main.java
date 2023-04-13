package edu.eci.cvds.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import java.util.Arrays;

@SpringBootApplication
public class Main{
	@Autowired
	ConfigurationService configurationService;

  public static void main (String[] args) {
      SpringApplication.run(Main.class, args);
  }

  @Bean
  ServletRegistrationBean jsfServletRegistration (ServletContext servletContext) {
      //spring boot only works if this is set
      servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());

      //registration
      ServletRegistrationBean srb = new ServletRegistrationBean();
      srb.setServlet(new FacesServlet());
      srb.setUrlMappings(Arrays.asList("*.xhtml"));
      srb.setLoadOnStartup(1);
      return srb;
  }
  
  @Bean
	public CommandLineRunner run() throws Exception {
		return (args) -> {
			
			System.out.println("Adding configurations....\n");
			configurationService.addConfiguration(new Configuration("Premio", "100"));
			
			
			System.out.println("\nGetting all configurations....");
			configurationService.getAllConfigurations().forEach(configuration -> System.out.println(configuration));
			
			System.out.println("\nGetting configuration with id = 1....");
			System.out.println(configurationService.getConfiguration("Premio"));
			
		
			
		
		};
	}
}