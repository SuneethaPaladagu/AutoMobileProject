package com.nisum.car.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nisum.car.Car;
import com.nisum.controller.CarController;
import com.nisum.service.CarService;
import com.nisum.util.MockTestUtil;

@RunWith(MockitoJUnitRunner.class)
public class CarControllerTest {
	
	private MockMvc mockMvc;

	@Resource
	private List<HandlerExceptionResolver> webApplicationContext;
	
	@Mock
	CarService carService;
	
	@InjectMocks
	CarController carController = new CarController();
	
	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(carController).setHandlerExceptionResolvers(webApplicationContext).build();
    }
	
/*	@Test
	public void addCarTest() throws Exception{
		
		
		Car car=new Car();
		car.setId("1");
		car.setMake("M1");
		car.setModel("New");
		car.setDescription("Desc");	 	
	
		mockMvc.perform(get("/home")).andExpect(status().isOk());
	}*/

	
	 @Test
	    public void addCarTest() throws Exception {
	 
		 Car car=new Car();
			car.setId("1");
			car.setMake("M1");
			car.setModel("New");
			car.setDescription("Desc");
	        mockMvc.perform(post("/home"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("/home"));
	 
	    }
	
/*
	@Test
	public void deleteCarTest() throws Exception{
		 String foodId = "M11";
		 doNothing().when(carService).deleteCars(foodId);
		 mockMvc.perform(get("/delete").param("delete", "M11")).andExpect(status().isOk());
	}*/

	@Test
	public void getAllCarsTest() throws Exception{
		
		Car car1 = new Car();		
		car1.setId("1");
		car1.setMake("M1");
		car1.setModel("New");
		car1.setDescription("Desc");	
		
		Car car2 = new Car();		
		car1.setId("2");
		car1.setMake("M2");
		car1.setModel("New2");
		car1.setDescription("Desc2");
		
		Mockito.when(carService.getAll()).thenReturn(Arrays.asList(car1, car2));
		
		//mockMvc.perform(get("/home").contentType(MediaType.TEXT_HTML)).andExpect(status().isOk());

		//Mockito.when((carService).getAll()).thenReturn(li_car);
		
		 // mockMvc.perform(get("/")).andExpect(status().isOk());
		//mockMvc.perform(get("/home")).andExpect(status().isOk());	 
		//	mockMvc.perform(get("/").contentType(MediaType.TEXT_HTML).content(MockTestUtil.convertToJsonFormat(new Car()))).andExpect(status().isOk());
	}
	

	@Test
	public void getCarByIdTest() throws Exception{
		String carId="M1";
		Car car1 = new Car();		
		car1.setId("1");
		car1.setMake("M1");
		car1.setModel("New");
		car1.setDescription("Desc");  
		Mockito.when((carService).searchCars(carId)).thenReturn(Arrays.asList(car1));
		mockMvc.perform(get("/search").param("search", "M1")).andExpect(status().isOk());
	}
	

}
