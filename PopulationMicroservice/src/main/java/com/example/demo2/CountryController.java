package com.example.demo2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
public class CountryController extends CountriesDatabaseLoad {

    private final RestTemplate restTemplate;
    private final CountryRepository countryRepository;
    ObjectMapper mapper;

    public CountryController(CountryRepository countryRepository, RestTemplate restTemplate) { //Constructor
        this.countryRepository = countryRepository;
        this.restTemplate = restTemplate;
        mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //ignore no relative field
    }

    /* Get countries from url and adding them to the database */

    @GetMapping("/countries")
    public void addCountries() throws JsonProcessingException {
        String url = "https://restcountries.com/v3.1/all";
        JsonNode json = restTemplate.getForObject(url, JsonNode.class);
        //initDatabaseCountries(json);
        List<Country> list = mapper.readValue(json.toString(), new TypeReference<>(){});
        countryRepository.saveAll(list);
    }

    /* Create new country and store him into the database */
    @PostMapping("/Country")
    public void createCountry(@RequestBody final Country country){
        countryRepository.save(country);
    }

    /* Create new countries and store them into the database */
    @PostMapping("/Country")
    public List<Country> addCountryList(@RequestBody final List<Country> list) {
        countryRepository.saveAll(list);
        return list;
    }

    /* Respond the number of all countries stored at server */
    @GetMapping("/Country/count")
    public long count(){
        return countryRepository.count();
    }

    /* Respond with a JSON representation of all the exists countries in the database */
    @GetMapping("/Country")
    public List<Country> getAll(){
        return countryRepository.findAll();
    }

    /* Respond with a JSON representation of the specific country with the requested ID from the database */
    @GetMapping("/Country/{id}")
    public Country getOne(@PathVariable final int id) {
        return countryRepository.findById(id).orElseGet(Country::new);
    }

    /* Delete country with requested ID from the database */
    @DeleteMapping("/Country/{id}")
    public void delete(@PathVariable final int id){
        countryRepository.deleteById(id);
    }
}
