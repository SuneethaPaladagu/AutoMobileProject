package com.nisum.car.service;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.nisum.repository.CarMongoRepository;
import com.nisum.repository.CarSearchRepository;
import com.nisum.car.Car;
import com.nisum.service.impl.*;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceImplTest {
	@Mock
	private CarMongoRepository repository;
	private CarSearchRepository carSearchrepository;

	private Car car;

	
	@InjectMocks
	private CarServiceImpl carServiceImpl;
	
	private List<Car> cars;
	
	private Collection<Car> carc ;
		
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	   @Test
		public void getAllCarsTest() throws Exception {
			
	    	when(carServiceImpl.getAll()).thenReturn(cars);

		}
	  
	   @Test
	    public void insertCar() throws Exception {
	   		
		   carServiceImpl.save(any(Car.class));
		}

}
