package com.myProject.Nature_Circle.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

@Controller
public class Main {

    @GetMapping(path = "/")
    public String getMain(){
        return "Welcome green world!";
    }
}