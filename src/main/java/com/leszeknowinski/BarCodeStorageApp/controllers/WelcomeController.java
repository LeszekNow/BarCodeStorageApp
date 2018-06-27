package com.leszeknowinski.BarCodeStorageApp.controllers;

import com.leszeknowinski.BarCodeStorageApp.models.services.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WelcomeController {

    @Autowired
    WelcomeService welcomeService;

    @GetMapping("/name/{name}")
    @ResponseBody
    public String name(@PathVariable("name") String name){
        welcomeService.setName(name);
        return "name changed!";
    }

    @GetMapping("/welcome")
    @ResponseBody
    public String welcome(){
        return welcomeService.generateWelcomeString();
    }

    @GetMapping("/exit")
    @ResponseBody
    public String exit(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().invalidate();
        return "logged out!";
    }
}
