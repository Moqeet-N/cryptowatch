package com.moqeet.cryptowatch.model;

import java.util.Map;

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
    private Map<String, Object> quote;

    public Coin() {
    }

    public Coin(String id, String name, String symbol, String slug, String num_market_pairs, String date_added, String[] tags, String max_supply, String circulating_supply, String total_supply, String platform, String cmc_rank, String last_updated, Map<String, Object> quote) {
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
        this.quote = quote;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getNum_market_pairs() {
        return num_market_pairs;
    }

    public void setNum_market_pairs(String num_market_pairs) {
        this.num_market_pairs = num_market_pairs;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getMax_supply() {
        return max_supply;
    }

    public void setMax_supply(String max_supply) {
        this.max_supply = max_supply;
    }

    public String getCirculating_supply() {
        return circulating_supply;
    }

    public void setCirculating_supply(String circulating_supply) {
        this.circulating_supply = circulating_supply;
    }

    public String getTotal_supply() {
        return total_supply;
    }

    public void setTotal_supply(String total_supply) {
        this.total_supply = total_supply;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getCmc_rank() {
        return cmc_rank;
    }

    public void setCmc_rank(String cmc_rank) {
        this.cmc_rank = cmc_rank;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public Map<String, Object> getQuote() {
        return quote;
    }

    public void setQuote(Map<String, Object> quote) {
        this.quote = quote;
    }
}

