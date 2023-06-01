package com.codingdojo.ricardo.cadenas.controladores;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Cadenas {
    @RequestMapping("/")
	public String despliegaHome(){

		return "Hola joven navegador bienvenido al Espacio Spring!";
	}
    @RequestMapping("/random")
	public String random(){

		return "Hola con Spring 2!";
	}
	
}
