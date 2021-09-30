package com.moqeet.cryptowatch.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

public class ListingUtility {

    private final String apiKey = "b0b815f9-35eb-4bf4-8285-ae1659e59fd9";


    public String getListings() {

        //Request to get coins
        String listingsURI = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";

        //Setting Headers
        String start = "1";
        String limit = "5000";
        String convert = "USD";

        //Sets the headers for the template
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("start", start);
        headers.set("limit", limit);
        headers.set("convert", convert);
        headers.set("X-CMC_PRO_API_KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(listingsURI, HttpMethod.GET, entity, String.class);

        return responseEntity.getBody();
    }

    public List<String> translateJson(String jsonResponse) {

        //Gets all of the report suites in the response as Objects
        ObjectMapper mapper = new ObjectMapper();
        Map obj;
        List<Object> coins = new ArrayList<>();
        try {
            obj = mapper.readValue(jsonResponse, Map.class);
            coins = (List<Object>) obj.get("data");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //Parse Object to String
        List<String> coinsList = coins.stream()
                .map(object -> Objects.toString(object, null))
                .collect(Collectors.toList());

        return coinsList;

    }

}
