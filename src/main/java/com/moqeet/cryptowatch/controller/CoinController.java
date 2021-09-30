package com.moqeet.cryptowatch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoinController {

    @GetMapping("/coin")
    public String getCoin(Model model){
        model.addAttribute("something", "something");
        return "coin";
    }
}
