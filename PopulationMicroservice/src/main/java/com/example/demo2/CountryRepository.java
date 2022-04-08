package com.example.demo2;

import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public abstract class CountryRepository implements MongoRepository<Country, String>  {

    MongoTemplate mongoTemplate;

    public void saveTo(Country country){

        BasicDBObject obj = new BasicDBObject();
        obj.append("id",country.getId());
        obj.append("population",country.getPopulation());
        obj.append("area",country.getArea());
        obj.append("name",country.getName());

       mongoTemplate.save(obj);
    }
}

