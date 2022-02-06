package com.jokam.code;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController

public class ApiRestController  {

    @Autowired
    private RestTemplate restTemplate;

    private String currency1API = "bitcoin";
    private String currency2API = "ethereum";

    private String url = "https://api.coingecko.com/api/v3/simple/price?ids="+currency1API+"&vs_currencies=usd&include_last_updated_at=true";

    @GetMapping("/coins")
    //public ResponseEntity<String> getCoins(){
        //Object[] countries = restTemplate.getForObject(url, Object[].class);
       //ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
     public String getCoins(){
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(url);
        System.out.println(result);
        return result;
    }
}
