package com.moqeet.cryptowatch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
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
    private String platform;
    private String cmc_rank;
    private String last_updated;
    private String currency;
    private String price;
    private String percent_change_24h;
    private String percent_change_7d;
    private String percent_change_30d;
    private String percent_change_60d;
    private String percent_change_90d;
    private String market_cap;

    public Coin() {
    }

    public Coin(String id, String name, String symbol, String slug, String num_market_pairs, String date_added, String[] tags, String max_supply, String circulating_supply, String total_supply, String platform, String cmc_rank, String last_updated, String price, String percent_change_24h, String percent_change_7d, String percent_change_30d, String percent_change_60d, String percent_change_90d, String market_cap) {
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
        this.platform = platform;
        this.cmc_rank = cmc_rank;
        this.last_updated = last_updated;
        this.price = price;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_7d = percent_change_7d;
        this.percent_change_30d = percent_change_30d;
        this.percent_change_60d = percent_change_60d;
        this.percent_change_90d = percent_change_90d;
        this.market_cap = market_cap;
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("quote")
    private void unpackNested(Map<String,Object> quote) {
        Map<String,String> quoteData = (Map<String,String>)quote.get("USD");
        this.price = quoteData.get("price");
        this.percent_change_24h = quoteData.get("percent_change_24h");
        this.percent_change_7d = quoteData.get("percent_change_7d");
        this.percent_change_30d = quoteData.get("percent_change_30d");
        this.percent_change_60d = quoteData.get("percent_change_60d");
        this.percent_change_90d = quoteData.get("percent_change_90d");
        this.market_cap = quoteData.get("market_cap");
    }


}

