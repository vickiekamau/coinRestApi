package com.jokam.code;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jokam.code.Model.Coin;
import com.jokam.code.Repository.CoinRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Log
public class UtilityRunner implements CommandLineRunner
{

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CoinRepository coinRepository;
    private String currency1API = "bitcoin";
    private String currency2API = "ethereum";

    private String url = "https://api.coingecko.com/api/v3/simple/price?ids="+currency1API+"&vs_currencies=usd&include_last_updated_at=true";
    private String result = restTemplate.getForObject(url, String.class);

    @Override
    public void run(String... args) throws Exception {
        System.out.println(result);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        Coin value = mapper.readValue(result, Coin.class);
        Coin save = coinRepository.save(value);
        log.info("Coin info" +save.toString());



    }
}
