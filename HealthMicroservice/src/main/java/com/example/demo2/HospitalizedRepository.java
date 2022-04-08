package com.example.demo2;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HospitalizedRepository extends MongoRepository<Hospitalized, Integer> {
}
