package com.nisum.service;
import java.util.Collection;
import java.util.List;

import com.nisum.car.Car;

public interface CarService {
	

		List<Car> getAll();

		void save(Car car);
		
		Collection searchCars(String search);
		
		void deleteCars(String delete);



}
