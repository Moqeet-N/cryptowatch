package com.moqeet.cryptowatch.controller;

import com.moqeet.cryptowatch.model.Coin;
import com.moqeet.cryptowatch.utility.ListingUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class ListingController {

    @GetMapping("/listing")
    public String getCoin(Model model) throws IOException {
        ListingUtility listingUtility = new ListingUtility();

        String response = listingUtility.getListings();
        System.out.println(response);
        List<Coin> coins = listingUtility.getCoins(response);

        model.addAttribute("something", coins.get(25).getName());
        return "listing";
    }
}
