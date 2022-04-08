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

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RecoveredRepository recoveredRepository;

    ObjectMapper mapper = new ObjectMapper();

    ////spring.devtools.livereload.port=38483

    @PostMapping("/recovered") //add recovered from gov.il
    public void addRecovered() throws JsonProcessingException {
        String url = "https://data.gov.il/api/3/action/datastore_search?resource_id=8455d49f-ce32-4f8f-b1d4-1d764660cca3";
        String json = restTemplate.getForObject(url, String.class);
        String recordsArray = mapper.readTree(json).get("result").get("records").toString();
        List<Recovered> list = mapper.readValue(recordsArray, new TypeReference<>(){});
        recoveredRepository.saveAll(list);
    }

    @PostMapping("/addRecoveredList") //add recovered from list
    public List<Recovered> addRecoveredList(@RequestBody final List<Recovered> list){
        recoveredRepository.saveAll(list);
        return list;
    }

    @GetMapping("/recovered") //return all recovered
    public List<Recovered> returnRecovered(){
        return recoveredRepository.findAll();
    }

    @GetMapping("/recovered/{recoveredId}") //return recovered by id
    public Recovered findRecovered(@PathVariable final int recoveredId) {
        return recoveredRepository.findById(recoveredId).orElseGet(Recovered::new);
    }

}
