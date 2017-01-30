package com.nisum.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.nisum.car.Car;
import com.nisum.service.CarService;
import com.nisum.repository.CarMongoRepository;
import com.nisum.repository.CarSearchRepository;

@Service
@PreAuthorize("hasRole('ROLE_USER')")
public class CarServiceImpl implements CarService{
	@Autowired
	CarMongoRepository carMongoRepository; 
	
	@Autowired
	CarSearchRepository carSearchRepository; 
	
	@Override
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		return (List<Car>) carMongoRepository.findAll();
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void save(Car car) {
		// TODO Auto-generated method stub
		carMongoRepository.save(car);
	}

	@Override
	public Collection searchCars(String search) {
		// TODO Auto-generated method stub
		return carSearchRepository.searchCars(search);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	public void deleteCars(String delete) {
		// TODO Auto-generated method stub
		carSearchRepository.deleteCars(delete);
	}
	

}
