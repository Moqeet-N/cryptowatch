package com.moqeet.cryptowatch.utility;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moqeet.cryptowatch.model.Coin;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public List<Coin> getCoins(String jsonResponse) throws IOException {

        List<Coin> coins = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        //Retrieves data from response, JsonNode -> List that consists of data for each coin
        JsonNode arrNode = mapper.readTree(jsonResponse).get("data");

        //Maps each JsonNode to a Coin object
        for (int i = 0; i < arrNode.size()-1; i++) {
            Coin c = mapper.convertValue(arrNode.get(i), Coin.class);
            coins.add(c);
        }

        return coins;
    }

}
