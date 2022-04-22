package com.example.demo2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.*;
import org.springframework.boot.*;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class CountriesDatabaseLoad
{

    private static final Logger log = LoggerFactory.getLogger(CountriesDatabaseLoad.class);
    @Bean
    CommandLineRunner initDatabaseCountries(MongoTemplate mongoTemplate)
    {
        return args -> {

            //IMPLMENT YOUR CODE HERE
            //In order to work with countries data,
            //we need to fetch this data form somewhere,
            //convert it to Java object and store it at database

        };
    }
}

