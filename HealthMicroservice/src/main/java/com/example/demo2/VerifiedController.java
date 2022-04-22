package com.example.demo2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class VerifiedController {

    private final RestTemplate restTemplate;
    private final VerifiedRepository verifiedRepository;
    ObjectMapper mapper = new ObjectMapper();

    public VerifiedController(RestTemplate restTemplate, VerifiedRepository hospitalizedRepository) {
        this.restTemplate = restTemplate;
        this.verifiedRepository = hospitalizedRepository;
    }
    ////spring.devtools.livereload.port=38483

    /* Store verified data from gov.il to the database */
    @PostMapping("/Verified")
    public void addVerified() throws JsonProcessingException {
        String url = "https://data.gov.il/api/3/action/datastore_search?resource_id=bd7b8fa9-7120-4e8d-933f-a1449dae8dad";
        String json = restTemplate.getForObject(url, String.class);
        String recordsArray = mapper.readTree(json).get("result").get("records").toString();
        List<Verified> list = mapper.readValue(recordsArray, new TypeReference<>(){});
        verifiedRepository.saveAll(list);
    }

    /* Store verified from list to the database */
    @PostMapping("/addVerifiedList")
    public List<Verified> addHospitalizedList(@RequestBody final List<Verified> list){
        verifiedRepository.saveAll(list);
        return list;
    }

    /* Return all verified that stored in the database */
    @GetMapping("/Verified")
    public List<Verified> returnHospitalized(){
        return verifiedRepository.findAll();
    }

    /* Return specific verified with requested ID */
    @GetMapping("/Verified/{VerifiedId}") //return verified by id
    public Verified findHospitalized(@PathVariable final int VerifiedId) {
        return verifiedRepository.findById(VerifiedId).orElseGet(Verified::new);
    }

    /* Delete Verified with requested ID from the database */
    @DeleteMapping("/Verified/{id}")
    public void Delete(@PathVariable final int id){
        verifiedRepository.deleteById(id);
    }
}

