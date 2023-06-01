package com.codingdojo.ricardo.holahumano.controladores;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HolaHumanoControlador {
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloNombre(){
        String respuesta = "<h1> Hello Human! </h1></br><h3>Welcome to SpringBoot!</h3>";
        return respuesta;
    }
    @RequestMapping("/hello/{nombre}")
    public String showDojo(@PathVariable(value = "nombre") String name){
        String respuesta = "<h1> Hello "+name+ "!</h1></br><h3>Welcome to SpringBoot!</h3>";
        return respuesta;
    }

    

}
