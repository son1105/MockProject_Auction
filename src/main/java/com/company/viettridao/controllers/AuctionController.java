package com.company.viettridao.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auction")
public class AuctionController {

    @GetMapping("/buyer/{id}/getBidHistory")
    public String getBidHistoryOfUser(@PathVariable long id){
        return "";
    }
}
