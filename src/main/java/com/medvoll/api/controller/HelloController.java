package com.medvoll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//serve para criar controladores de APIs RESTful
@RestController
//serve para mapear URLs de requisições web para classes ou métodos específicos de um controlador
@RequestMapping("/hello")
public class HelloController {

        @GetMapping
        public String helloWorld(){
            return "Hello world";
        }
}
