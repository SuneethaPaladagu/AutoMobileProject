package com.nisum.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.nisum.car.Car;

@Repository
public class CarSearchRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public Collection searchCars(String text) {
        return mongoTemplate.find(Query.query(new Criteria()
                        .orOperator(Criteria.where("description").regex(text, "i"),
                                    Criteria.where("make").regex(text, "i"),
                                    Criteria.where("model").regex(text, "i"))
                        ), Car.class);
    }
    
    public void deleteCars(String text) { 
        
    	mongoTemplate.findAllAndRemove(Query.query(new Criteria()
                        .orOperator(Criteria.where("description").regex(text, "i"),
                                    Criteria.where("make").regex(text, "i"),
                                    Criteria.where("model").regex(text, "i"))
                        ), Car.class);
    }

}