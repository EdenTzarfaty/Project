package com.example.demo2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class VerifiedController {

    RestTemplate restTemplate2;
    VerifiedRepository verifiedRepository;
    ObjectMapper mapperVerified;

    @Autowired
    public VerifiedController(RestTemplate restTemplate2, VerifiedRepository verifiedRepository) {
        this.restTemplate2 = restTemplate2;
        this.verifiedRepository = verifiedRepository;
        mapperVerified = new ObjectMapper();
    }

    /* Store verified from list to the database */
    @PostMapping("/Health/Verified/addVerifiedList")
    public List<Verified> addHospitalizedList(@RequestBody final List<Verified> list){
        verifiedRepository.saveAll(list);
        return list;
    }

    /* Return all verified that stored in the database */
    @GetMapping("/Health/Verified")
    public List<Verified> returnHospitalized(){
        return verifiedRepository.findAll();
    }

    /* Return specific verified with requested ID */
    @GetMapping("/Health/Verified/{VerifiedId}") //return verified by id
    public Verified findHospitalized(@PathVariable final int VerifiedId) {
        return verifiedRepository.findById(VerifiedId).orElseGet(Verified::new);
    }

    /* Delete Verified with requested ID from the database */
    @DeleteMapping("/Health/Verified/{id}")
    public void delete(@PathVariable final int id){
        verifiedRepository.deleteById(id);
    }
}

