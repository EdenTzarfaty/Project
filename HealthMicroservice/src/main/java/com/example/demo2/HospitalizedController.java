package com.example.demo2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class HospitalizedController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HospitalizedRepository hospitalizedRepository;

    ObjectMapper mapper = new ObjectMapper();

    ////spring.devtools.livereload.port=38483

    @PostMapping("/addHospitalized") //add hospitalized from gov.il
    public void addHospitalized() throws JsonProcessingException {
        String url = "https://data.gov.il/api/3/action/datastore_search?resource_id=e4bf0ab8-ec88-4f9b-8669-f2cc78273edd";
        String json = restTemplate.getForObject(url, String.class);
        String recordsArray = mapper.readTree(json).get("result").get("records").toString();
        List<Hospitalized> list = mapper.readValue(recordsArray, new TypeReference<>(){});
        hospitalizedRepository.saveAll(list);
    }

    @PostMapping("/addHospitalizedList") //add hospitalized from list
    public List<Hospitalized> addHospitalizedList(@RequestBody final List<Hospitalized> list){
        hospitalizedRepository.saveAll(list);
        return list;
    }

    @GetMapping("/hospitalized") //return all hospitalized
    public List<Hospitalized> returnHospitalized(){
        return hospitalizedRepository.findAll();
    }

    @GetMapping("/hospitalized/{hospitalizedId}") //return hospitalized by id
    public Hospitalized findHospitalized(@PathVariable final int hospitalizedId) {
        return hospitalizedRepository.findById(hospitalizedId).orElseGet(Hospitalized::new);
    }

}

