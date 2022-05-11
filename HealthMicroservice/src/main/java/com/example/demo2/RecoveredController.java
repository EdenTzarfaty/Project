package com.example.demo2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
public class RecoveredController {

    private final RestTemplate restTemplate;
    private final RecoveredRepository recoveredRepository;
    ObjectMapper mapper = new ObjectMapper();

    public RecoveredController(RestTemplate restTemplate, RecoveredRepository recoveredRepository) {
        this.restTemplate = restTemplate;
        this.recoveredRepository = recoveredRepository;
    }

    /* Store recovered data from gov.il to the database */
    @PostMapping("/Recovered")
    public void addRecovered() throws JsonProcessingException {
        String url = "https://data.gov.il/api/3/action/datastore_search?resource_id=8455d49f-ce32-4f8f-b1d4-1d764660cca3";
        String json = restTemplate.getForObject(url, String.class);
        String recordsArray = mapper.readTree(json).get("result").get("records").toString();
        List<Recovered> list = mapper.readValue(recordsArray, new TypeReference<>(){});
        recoveredRepository.saveAll(list);
    }

    /* Store recovered from list to the database */
    @PostMapping("/addRecoveredList") //
    public List<Recovered> addRecoveredList(@RequestBody final List<Recovered> list){
        recoveredRepository.saveAll(list);
        return list;
    }

    /* Return all recovered that stored in the database */
    @GetMapping("/Recovered")
    public List<Recovered> returnRecovered(){
        return recoveredRepository.findAll();
    }

    /* Return specific recovered with requested ID */
    @GetMapping("/Recovered/{recoveredId}") //
    public Recovered findRecovered(@PathVariable final int recoveredId) {
        return recoveredRepository.findById(recoveredId).orElseGet(Recovered::new);
    }

    /* Delete recovered with requested ID from the database */
    @DeleteMapping("/Recovered/{id}")
    public void delete(@PathVariable final int id){
        recoveredRepository.deleteById(id);
    }
}
