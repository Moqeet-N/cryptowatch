package com.moqeet.cryptowatch.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoinData {

    private String id;
    private String name;
    private String symbol;
    private String description;
    private String slug;
    private String logo;
    private String urlWebsite;
    private String coinMarketCapUrl;

    public CoinData(String id, String name, String symbol, String description, String slug, String logo, String urlWebsite, String coinMarketCapUrl) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.description = description;
        this.slug = slug;
        this.logo = logo;
        this.urlWebsite = urlWebsite;
        this.coinMarketCapUrl = coinMarketCapUrl;
    }

    public CoinData() {
    }



}
