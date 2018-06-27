package com.leszeknowinski.BarCodeStorageApp.controllers;

import com.leszeknowinski.BarCodeStorageApp.models.BarCodeEntity;
import com.leszeknowinski.BarCodeStorageApp.models.services.BasketService;
import com.leszeknowinski.BarCodeStorageApp.repositories.BarCodeEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;

@Controller
public class BasketController {

    @Autowired
    BasketService basketService;

    @Autowired
    BarCodeEntityRepository barCodeEntityRepository;

    @GetMapping("/basket")
    @ResponseBody
    public String basket(){
        return  basketService.getBasketList().stream().map(BarCodeEntity::toString).collect(Collectors.joining(", ", "Your list contains", ", "));
    }

    @GetMapping("/add/{id}")
    public String addToBasket(@PathVariable("id") int id){
        basketService.addProdToList(barCodeEntityRepository.findById(id).orElseThrow(IllegalStateException::new));
        return "redirect:/";

    }
    @GetMapping("/remove/{id}")
    public String removeFromBasket(@PathVariable("id") int id){
        basketService.removeProdFromList(id);
        return "redirect:/";

    }
}
