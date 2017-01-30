package com.nisum.configuration;

import java.nio.charset.Charset;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com")
//@WebAppConfiguration("webapp")
public class AppConfig extends WebMvcConfigurerAdapter {

/*	     @Bean
	     public ViewResolver getViewResolver() {
	         InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	         resolver.setPrefix("/WEB-INF/views/html/");
	         resolver.setSuffix(".html");
	         resolver.setOrder(1);
	         return resolver;
	     }*/
	
	/*@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}*/
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	     
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
