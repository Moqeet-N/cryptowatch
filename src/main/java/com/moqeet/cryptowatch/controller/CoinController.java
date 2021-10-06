package com.moqeet.cryptowatch.controller;

import com.moqeet.cryptowatch.model.Coin;
import com.moqeet.cryptowatch.utility.CoinUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CoinController {

    @PostMapping("/coin")
    public String getCoin(Model model, @RequestParam("id") String id){
        id = id.substring(0, id.length()-1);

        CoinUtility coinUtility = new CoinUtility();
        String response = coinUtility.getCoinData(id);

        model.addAttribute("coin", response);
        return "coin";
    }

}
