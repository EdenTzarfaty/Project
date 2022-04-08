package com.example.demo2;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecoveredRepository extends MongoRepository<Recovered, Integer> {
}
