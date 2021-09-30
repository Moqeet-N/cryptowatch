package com.moqeet.cryptowatch.controller;

import com.moqeet.cryptowatch.utility.ListingUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListingController {

    @GetMapping("/listing")
    public String getCoin(Model model){
        ListingUtility listingUtility = new ListingUtility();

        String response = listingUtility.getListings();

        List<String> data = listingUtility.translateJson(response);

//        Coin c1 = listingUtility.mapToCoin(data);
        model.addAttribute("something", data.get(0));
        return "listing";
    }
}
