package com.moqeet.cryptowatch.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Coin {

    private String id;
    private String name;
    private String symbol;
    private String slug;
    private String num_market_pairs;
    private String date_added;
    private String[] tags;
    private String max_supply;
    private String circulating_supply;
    private String total_supply;

    private String coinMarketCapURL;

    //Platform vars
    private String platformId;
    private String platformName;
    private String platformSymbol;
    private String platformSlug;
    private String platformToken_address;

    private String cmc_rank;
    private String last_updated;
    private String currency;

    //Quote vars
    private Double price;
    private Double percent_change_1h;
    private Double percent_change_24h;
    private Double percent_change_7d;
    private Double percent_change_30d;
    private Double percent_change_60d;
    private Double percent_change_90d;
    private Double market_cap;

    public Coin() {
    }

    public Coin(String id, String name, String symbol, String slug, String num_market_pairs, String date_added, String[] tags, String max_supply, String circulating_supply, String total_supply, String platformId, String platformName, String platformSymbol, String platformSlug, String platformToken_address, String cmc_rank, String last_updated, String currency, Double price, Double percent_change_1h, Double percent_change_24h, Double percent_change_7d, Double percent_change_30d, Double percent_change_60d, Double percent_change_90d, Double market_cap) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.slug = slug;
        this.num_market_pairs = num_market_pairs;
        this.date_added = date_added;
        this.tags = tags;
        this.max_supply = max_supply;
        this.circulating_supply = circulating_supply;
        this.total_supply = total_supply;
        this.coinMarketCapURL = "https://coinmarketcap.com/currencies/"+slug;
        this.platformId = platformId;
        this.platformName = platformName;
        this.platformSymbol = platformSymbol;
        this.platformSlug = platformSlug;
        this.platformToken_address = platformToken_address;
        this.cmc_rank = cmc_rank;
        this.last_updated = last_updated;
        this.currency = currency;
        this.price = price;
        this.percent_change_1h = percent_change_1h;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_7d = percent_change_7d;
        this.percent_change_30d = percent_change_30d;
        this.percent_change_60d = percent_change_60d;
        this.percent_change_90d = percent_change_90d;
        this.market_cap = market_cap;
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("quote")
    private void unpackNestedQuote(Map<String,Object> quote) {
        Map<String,Double> quoteData = (Map<String,Double>)quote.get("USD");
        this.price = quoteData.get("price");

        //Fixes issue where 0 as value is considered an Integer and cannot be parsed to a Double
        if(quoteData.get("percent_change_1h") instanceof Double){
            this.percent_change_1h = quoteData.get("percent_change_1h");
        }else{
            this.percent_change_1h = 0.0;
        }
        if(quoteData.get("percent_change_24h") instanceof Double){
            this.percent_change_24h = quoteData.get("percent_change_24h");
        }else{
            this.percent_change_24h = 0.0;
        }
        if(quoteData.get("percent_change_7d") instanceof Double){
            this.percent_change_7d = quoteData.get("percent_change_7d");
        }else{
            this.percent_change_7d = 0.0;
        }
        if(quoteData.get("percent_change_30d") instanceof Double){
            this.percent_change_30d = quoteData.get("percent_change_30d");
        }else{
            this.percent_change_30d = 0.0;
        }
        if(quoteData.get("percent_change_60d") instanceof Double){
            this.percent_change_60d = quoteData.get("percent_change_60d");
        }else{
            this.percent_change_60d = 0.0;
        }
        if(quoteData.get("percent_change_90d") instanceof Double){
            this.percent_change_90d = quoteData.get("percent_change_90d");
        }else{
            this.percent_change_90d = 0.0;
        }
        this.market_cap = quoteData.get("market_cap");
    }

    @JsonProperty("platform")
    private void unpackNestedPlatform(Map<String,String> platform) {
        if(platform == null){
            return;
        }
        this.platformId = platform.get("id");
        this.platformName = platform.get("name");
        this.platformSymbol = platform.get("symbol");
        this.platformSlug = platform.get("slug");
        this.platformToken_address = platform.get("token_address");
    }

}

