package com.nisum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nisum.car.Car;
import com.nisum.repository.CarMongoRepository;
import com.nisum.repository.CarSearchRepository;
import com.nisum.service.CarService;

@Controller
@RefreshScope
@ComponentScan("com.nisum")
public class CarController {

	@Autowired
	CarService carService; 	
	
/*	
	//1st page display before login
	@RequestMapping("/entry")
	public ModelAndView loadMain(){		
		ModelAndView mv = new ModelAndView("redirect:/home.html");
		return mv;
	}
    */
	
	 /* @RequestMapping(value="/oauth/main")
	    public ModelAndView restmain() {
	    	ModelAndView model=new ModelAndView();
	    	model.setViewName("main");	    	
	        return model;
	    }*/
	
	
	
	
	  @RequestMapping(value="/login")
	    public ModelAndView login() {
	    	ModelAndView model=new ModelAndView();
	    	model.setViewName("login");	    	
	        return model;
	    }
	  @RequestMapping(value="/main")
	    public ModelAndView main() {
	    	ModelAndView model=new ModelAndView();
	    	model.setViewName("main");	    	
	        return model;
	    }
	      
	
    @RequestMapping(value="/home")
    public ModelAndView home() {
    	ModelAndView model=new ModelAndView();
    	model.setViewName("home");
    	model.addObject("carList", carService.getAll());
        return model;
    }
        

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public String addCar(@ModelAttribute Car car) {
    	carService.save(car);
        return "redirect:home";
    }    

    @RequestMapping(value = "/search")
    public String search(Model model, @RequestParam String search) {
        model.addAttribute("carList", carService.searchCars(search));
        model.addAttribute("search", search);
        return "home";
    }
    
  
    @RequestMapping(value = "/delete")
    public String delete(Model model, @RequestParam String delete) {       
       // model.addAttribute("delete", delete);        
        carService.deleteCars(delete);
        
        return "redirect:home";
    }
    
    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
		public ModelAndView errorPage() {
   		ModelAndView mv = new ModelAndView("redirect:/invalidUser.html");
   		mv.addObject("message", "sorry You don't have privileges to view this page!!!");
   		return mv;
		}
}
