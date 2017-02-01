package com.nisum.configuration;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;


import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@EnableWebMvc
@ComponentScan("com")
//@WebAppConfiguration("webapp")
public class AppConfig extends WebMvcConfigurerAdapter {

	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	// start Thymeleaf specific configuration
	@Bean(name = "templateResolver")
	public TemplateResolver getTemplateResolver() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
 		templateResolver.setPrefix("/");
 		templateResolver.setSuffix(".html");
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setOrder(4);
		return templateResolver;
	}

	@Bean(name = "templateEngine")
	public SpringTemplateEngine getTemplateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(getTemplateResolver());
		return templateEngine;
	}

	@Bean(name = "viewResolver")
	public ThymeleafViewResolver getViewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(getTemplateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
		viewResolver.setViewNames(new String[]{"thymeleaf/*"});
		viewResolver.setOrder(5);
		return viewResolver;
	}
	   /*  
	     @Bean(name = "templateResolver")
	 	public TemplateResolver templateResolver() {
	 		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
	 		templateResolver.setPrefix("/");
	 		templateResolver.setSuffix(".html");
	 		templateResolver.setCharacterEncoding("UTF-8");
	 		templateResolver.setTemplateMode("HTML5");
	 		templateResolver.setOrder(4);
	 		return templateResolver;
	 	}
	     	   
	     
	     
	     @Bean("templateEngine")
	 	public SpringTemplateEngine templateEngine(){
	 		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	 		templateEngine.setTemplateResolver(templateResolver());
	 		Set<IDialect> dialects = new HashSet<>();
	 		dialects.add(new LayoutDialect());
	 		dialects.add(new SpringSecurityDialect());
	 		templateEngine.setAdditionalDialects(dialects);
	 		
	 		
	 		//templateEngine.setDialect(new SpringStandardDialect()); //one sec.standard dialect must be there.
	 		//templateEngine.setDialect(securityDialect()); //added security dialect to spring template engine
	 		//templateEngine.addDialect(new SpringSecurityDialect());
	 		return templateEngine;
	 	}
	 	
	 	@Bean //Standard dialect is enough
	 	public SpringSecurityDialect securityDialect(){
	 		return new SpringSecurityDialect();
	 	}
	 	
	 	@Bean
	 	public ViewResolver thymeleafViewResolver(){
	 		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	 		viewResolver.setTemplateEngine(templateEngine());
	 		return viewResolver;
	 	}*/
	     
/*	 	@Bean
		public InternalResourceViewResolver jspViewResolver() {
			InternalResourceViewResolver resolver = new InternalResourceViewResolver();
			resolver.setPrefix("/");
			resolver.setSuffix(".jsp");
			//resolver.setViewNames("jsps/*");
			resolver.setOrder(3);
			return resolver;
		}*/
	 	
	    @Override
	     public void configureDefaultServletHandling(
	             DefaultServletHandlerConfigurer configurer) {
	         configurer.enable();
	     } 
	    @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	      registry.addViewController("/").setViewName("forward:/index.html");
	    }
	   

}
