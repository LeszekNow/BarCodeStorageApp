package com.leszeknowinski.BarCodeStorageApp.controllers;

import com.leszeknowinski.BarCodeStorageApp.models.BarCodeEntity;
import com.leszeknowinski.BarCodeStorageApp.models.forms.BarCodeForm;
import com.leszeknowinski.BarCodeStorageApp.models.services.BasketService;
import com.leszeknowinski.BarCodeStorageApp.repositories.BarCodeEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    BarCodeEntityRepository barCodeEntityRepository;

    @Autowired
    BasketService basketService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("barCodeForm", new BarCodeForm());
        model.addAttribute("allBarCodes", barCodeEntityRepository.findAll());
        model.addAttribute("basket", basketService);
        return "addBarCode";
    }

    @PostMapping("/search")
    public String search(@RequestParam("search") String search, Model model){
        List<BarCodeEntity>barCodeEntityList = new ArrayList<>();
        barCodeEntityList.addAll(barCodeEntityRepository.findAllByProductCompanyContains(search));
        barCodeEntityList.addAll(barCodeEntityRepository.findAllByProductNameContains(search));

        model.addAttribute("barCodeForm", new BarCodeForm());
        model.addAttribute("allBarCodes", barCodeEntityList);
        return "addBarCode";
    }

    @PostMapping("/")

    public String index(@ModelAttribute BarCodeForm barCodeForm){
        BarCodeEntity barCodeEntity = new BarCodeEntity(barCodeForm);
        barCodeEntityRepository.save(barCodeEntity);
        return "redirect:/";
    }


}
