package com.moqeet.cryptowatch.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.moqeet.cryptowatch.model.Coin;
import com.moqeet.cryptowatch.utility.ListingUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListingController {

    @GetMapping("/listing")
    public String getCoin(Model model) throws JsonProcessingException {
        ListingUtility listingUtility = new ListingUtility();

        String response = listingUtility.getListings();

        //List<String> data = listingUtility.translateJson2(response);

        //Coin c1 = listingUtility.getCoin(data);
        model.addAttribute("something", listingUtility.getCoin().getName());
        return "listing";
    }
}
