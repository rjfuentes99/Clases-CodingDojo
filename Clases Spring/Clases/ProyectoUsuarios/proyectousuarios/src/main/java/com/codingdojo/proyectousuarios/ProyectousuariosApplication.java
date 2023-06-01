package com.codingdojo.proyectousuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class ProyectousuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectousuariosApplication.class, args);
	}

	/*@RequestMapping("/")
	public String despliegaHome(){
		return "Hola con Spring!";
	}*/

}
