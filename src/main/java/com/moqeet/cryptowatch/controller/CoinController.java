package com.moqeet.cryptowatch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CoinController {

    @PostMapping("/coin")
    public String getCoin(Model model, @RequestParam("coin")String coin){
        model.addAttribute("something", coin);
        return "coin";
    }
}
