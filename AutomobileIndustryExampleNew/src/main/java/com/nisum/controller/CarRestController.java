package com.nisum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.car.Car;
import com.nisum.service.CarService;

@RestController
@ComponentScan("com.nisum")
public class CarRestController {

	@Autowired
	CarService carService; 
	
	@RequestMapping(value="/homejs")
    public List<Car> listcars() {
    	
        return carService.getAll();
    }

}
