package com.moqeet.cryptowatch.utility;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class CoinUtility {

    private final String apiKey = "b0b815f9-35eb-4bf4-8285-ae1659e59fd9";

    public String getCoinData(String id) {

        //Request to get coins
        String listingsURI = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/info?id="+id;

        //Sets the headers for the template
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("X-CMC_PRO_API_KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(listingsURI, HttpMethod.GET, entity, String.class);

        return responseEntity.getBody();
    }

}
