package com.nisum.repository;

import org.springframework.data.repository.CrudRepository;

import com.nisum.car.Car;

public interface CarMongoRepository extends CrudRepository<Car, String>{
	
}
