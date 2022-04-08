package com.example.demo2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CountryRepository countryRepository;

    ObjectMapper mapper = new ObjectMapper();

    ////spring.devtools.livereload.port=38483

    @PostMapping("/Countries") //add countries from url
    public void AddCountries() throws JsonProcessingException {
        String url = "https://restcountries.com/v3.1/all";
        String json = restTemplate.getForObject(url, String.class);
        String recordsArray = mapper.readTree(json).get("result").get("records").toString();
        List<Country> list = mapper.readValue(recordsArray, new TypeReference<>(){});
        countryRepository.saveAll(list);
    }


    @PostMapping("/country") //create new country
    public void CreateCountry(@RequestBody final Country country){
        countryRepository.save(country);
    }

    @GetMapping("/country/count") //respond the number of all countries stored at server.
    public long Count(){
       return countryRepository.count();
    }

    @GetMapping("/country") //respond with a JSON representation of all the exists countries in the database
    public List<Country> GetAll(){
        return countryRepository.findAll();
    }

    @GetMapping("/country/{id}") //respond with a JSON representation of the specific country with the requested ID.
    public Country GetOne(@PathVariable final int id) {
        return countryRepository.findById(id).orElseGet(Country::new);
    }
    @DeleteMapping("/country/{id}")
    public void Delete(@PathVariable final int id){
        countryRepository.deleteById(id);
    }
}
