package com.example.demo2;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class PeopleDataBaseLoad {

    RestTemplate restTemplateRecovered;
    RecoveredRepository recoveredRepository;
    ObjectMapper mapperRecovered;

    RestTemplate restTemplateVerified;
    VerifiedRepository verifiedRepository;
    ObjectMapper mapperVerified;

    private static final Logger log = LoggerFactory.getLogger(PeopleDataBaseLoad.class);

    @Autowired
    public PeopleDataBaseLoad(RecoveredRepository recoveredRepository, RestTemplate restTemplateRecovered,RestTemplate restTemplateVerified, VerifiedRepository verifiedRepository) { //Constructor
        this.recoveredRepository = recoveredRepository;
        this.restTemplateRecovered = restTemplateRecovered;
        mapperRecovered = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //ignore no relative field

        this.restTemplateVerified = restTemplateVerified;
        this.verifiedRepository = verifiedRepository;
        mapperVerified=new ObjectMapper();
    }

    @PostConstruct
    private void initDatabaseCountries() {
        try {
            log.info("starting");
            String url = "https://data.gov.il/api/3/action/datastore_search?resource_id=8455d49f-ce32-4f8f-b1d4-1d764660cca3";
            String json = restTemplateRecovered.getForObject(url, String.class);
            String recordsArray = mapperRecovered.readTree(json).get("result").get("records").toString();
            List<Recovered> list = mapperRecovered.readValue(recordsArray, new TypeReference<>(){});
            recoveredRepository.saveAll(list);
            log.info(list.size() + " recovered added to the database");

            String url2 = "https://data.gov.il/api/3/action/datastore_search?resource_id=bd7b8fa9-7120-4e8d-933f-a1449dae8dad";
            String json2 = restTemplateVerified.getForObject(url2, String.class);
            String recordsArray2 = mapperVerified.readTree(json2).get("result").get("records").toString();
            List<Verified> list2 = mapperVerified.readValue(recordsArray2, new TypeReference<>(){});
            verifiedRepository.saveAll(list2);
            log.info(list2.size() + " verified added to the database");
        }
        catch (Exception e){
            log.error("error", e);
        }
    }
}