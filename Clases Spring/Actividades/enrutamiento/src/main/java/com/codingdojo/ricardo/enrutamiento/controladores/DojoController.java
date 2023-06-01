package com.codingdojo.ricardo.enrutamiento.controladores;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
    public class DojoController {
        @RequestMapping("/{dojo}")
        public String showDojo(@PathVariable(value = "dojo") String name){
            String respuesta = "¡El Dojo es increíble!";
            return respuesta;
        }
        @RequestMapping("dojo/{burbankdojo}")
        public String showBurbank(@PathVariable(value = "burbankdojo") String name2){
            String respuesta2 = "El Dojo Burbank está localizado al sur de California";
            return respuesta2;
        }    
        @RequestMapping("prueba/{sanjose}")
        public String showSanJose(@PathVariable(value = "sanjose") String name3){
            String respuesta3 = "El Dojo SJ es el cuartel general";
            return respuesta3;
        }    
        
    }
