package com.leszeknowinski.BarCodeStorageApp.controllers;

import com.leszeknowinski.BarCodeStorageApp.models.BarCodeEntity;
import com.leszeknowinski.BarCodeStorageApp.models.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;

@Controller
public class BasketController {

    @Autowired
    BasketService basketService;

    @GetMapping("/basket")
    @ResponseBody
    public String basket(){
        return  basketService.getBasketList().stream().map(BarCodeEntity::toString).collect(Collectors.joining(", ", "Your list contains", ", "));
    }
}
