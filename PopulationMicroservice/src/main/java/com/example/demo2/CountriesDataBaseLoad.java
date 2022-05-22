package com.example.demo2;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class CountriesDataBaseLoad {

    RestTemplate restTemplate;
    CountryRepository countryRepository;
    ObjectMapper mapper;

    private static final Logger log = LoggerFactory.getLogger(CountriesDataBaseLoad.class);

    @Autowired
    public CountriesDataBaseLoad(CountryRepository countryRepository, RestTemplate restTemplate) { //Constructor
        this.countryRepository = countryRepository;
        this.restTemplate = restTemplate;
        mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //ignore no relative field
    }

    @PostConstruct
    private void initDatabaseCountries() {
        try {
            log.info("starting");
            String url = "https://restcountries.com/v3.1/all";
            JsonNode json = restTemplate.getForObject(url, JsonNode.class);
            assert json != null;
            List<Country> list = mapper.readValue(json.toString(), new TypeReference<>(){});
            countryRepository.saveAll(list);
            log.info(list.size() + " countries added to the database");
        }
        catch (Exception e){
            log.error("error", e);
        }
    }
}