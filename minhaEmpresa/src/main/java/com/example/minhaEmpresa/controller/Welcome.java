package com.example.minhaEmpresa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev")
public class Welcome {

    @GetMapping
    public String welcome(){
        return "Natan William - SENAI";
    }
}
