package com.moqeet.cryptowatch.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moqeet.cryptowatch.model.Coin;
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

        System.out.println(coins.get(0).toString());

        //Parse Object to String
        List<String> coinsList = coins.stream()
                .map(object -> Objects.toString(object, null))
                .collect(Collectors.toList());

        return coinsList;

    }

    public List<String> translateJson2(String jsonResponse) throws JsonProcessingException {

        //Gets all of the report suites in the response as Objects
        ObjectMapper mapper = new ObjectMapper();
        Coin[] coins = mapper.readValue(jsonResponse, Coin[].class);
        coins[0].getName();
        return null;
    }


    public Coin getCoin() throws JsonProcessingException {

        Coin coin = new ObjectMapper()
                .readerFor(Coin.class)
                .readValue("{\n" +
                        "            \"id\": 1027,\n" +
                        "            \"name\": \"Ethereum\",\n" +
                        "            \"symbol\": \"ETH\",\n" +
                        "            \"slug\": \"ethereum\",\n" +
                        "            \"num_market_pairs\": 5043,\n" +
                        "            \"date_added\": \"2015-08-07T00:00:00.000Z\",\n" +
                        "            \"tags\": [\n" +
                        "                \"mineable\",\n" +
                        "                \"pow\",\n" +
                        "                \"smart-contracts\",\n" +
                        "                \"ethereum\",\n" +
                        "                \"binance-smart-chain\",\n" +
                        "                \"coinbase-ventures-portfolio\",\n" +
                        "                \"three-arrows-capital-portfolio\",\n" +
                        "                \"polychain-capital-portfolio\",\n" +
                        "                \"binance-labs-portfolio\",\n" +
                        "                \"arrington-xrp-capital\",\n" +
                        "                \"blockchain-capital-portfolio\",\n" +
                        "                \"boostvc-portfolio\",\n" +
                        "                \"cms-holdings-portfolio\",\n" +
                        "                \"dcg-portfolio\",\n" +
                        "                \"dragonfly-capital-portfolio\",\n" +
                        "                \"electric-capital-portfolio\",\n" +
                        "                \"fabric-ventures-portfolio\",\n" +
                        "                \"framework-ventures\",\n" +
                        "                \"hashkey-capital-portfolio\",\n" +
                        "                \"kinetic-capital\",\n" +
                        "                \"huobi-capital\",\n" +
                        "                \"alameda-research-portfolio\",\n" +
                        "                \"a16z-portfolio\",\n" +
                        "                \"1confirmation-portfolio\",\n" +
                        "                \"winklevoss-capital\",\n" +
                        "                \"usv-portfolio\",\n" +
                        "                \"placeholder-ventures-portfolio\",\n" +
                        "                \"pantera-capital-portfolio\",\n" +
                        "                \"multicoin-capital-portfolio\",\n" +
                        "                \"paradigm-xzy-screener\"\n" +
                        "            ],\n" +
                        "            \"max_supply\": null,\n" +
                        "            \"circulating_supply\": 117651590.124,\n" +
                        "            \"total_supply\": 117651590.124,\n" +
                        "            \"platform\": null,\n" +
                        "            \"cmc_rank\": 2,\n" +
                        "            \"last_updated\": \"2021-09-24T06:51:03.000Z\",\n" +
                        "            \"quote\": {\n" +
                        "                \"USD\": {\n" +
                        "                    \"price\": 3074.2380304626713,\n" +
                        "                    \"volume_24h\": 17737281672.070698,\n" +
                        "                    \"percent_change_1h\": 0.15462247,\n" +
                        "                    \"percent_change_24h\": -1.61049463,\n" +
                        "                    \"percent_change_7d\": -13.37876145,\n" +
                        "                    \"percent_change_30d\": -4.17641602,\n" +
                        "                    \"percent_change_60d\": 29.88297147,\n" +
                        "                    \"percent_change_90d\": 69.87481185,\n" +
                        "                    \"market_cap\": 361688992703.60724,\n" +
                        "                    \"market_cap_dominance\": 18.32,\n" +
                        "                    \"fully_diluted_market_cap\": 361688992703.61,\n" +
                        "                    \"last_updated\": \"2021-09-24T06:51:03.000Z\"\n" +
                        "                }\n" +
                        "            }\n" +
                        "        }");
        return coin;
    }

}
