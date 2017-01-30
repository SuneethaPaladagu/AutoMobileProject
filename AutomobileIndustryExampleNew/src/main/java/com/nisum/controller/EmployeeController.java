package com.nisum.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import javassist.bytecode.Descriptor.Iterator;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nisum.employee.Employee;



/*import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nisum.employee.Employee;
import com.nisum.car.Car;
import com.nisum.repository.CarMongoRepository;
import com.nisum.repository.CarSearchRepository;*/

@Controller
@ComponentScan("com.nisum")
@Transactional
@RefreshScope
@EnableAutoConfiguration
@Component
public class EmployeeController {

	@Autowired
	@Qualifier("postgresJdbcTemplate")
	private JdbcTemplate postgresTemplate;
	
	
	//cloud config
	 @Value("${msgnew}")
	    private String name;
	    
	    @RequestMapping(value = "/cloud")
	    public ModelAndView cloudmsg() {
	    	
	    	
	    	ModelAndView mv=new ModelAndView();
	    	mv.setViewName("cloudex");
	    	mv.addObject("msg", name);
	    	return mv;

	    }
	
	
	//oauth2
	@RequestMapping(value = "/oauth/employee")
	public ModelAndView getoauthEmployee() {
		
	String SQL = "select * from employee";
	List <Employee> emps = postgresTemplate.query(SQL, 
	                                new EmployeeMapper());		

	ModelAndView mv=new ModelAndView();
	mv.setViewName("empnew");
	mv.addObject("empList", emps);
	return mv;
	   
	}
	
	@RequestMapping(value = "/employee")
	public ModelAndView getEmployee() {
		
	String SQL = "select * from employee";
	List <Employee> emps = postgresTemplate.query(SQL, 
	                                new EmployeeMapper());
		
	ModelAndView mv=new ModelAndView();
	mv.setViewName("empnew");
	mv.addObject("empList", emps);
	return mv;
	   
	}
	
	
}

