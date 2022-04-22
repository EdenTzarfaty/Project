package com.example.demo2;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerifiedRepository extends MongoRepository<Verified, Integer> {
}
