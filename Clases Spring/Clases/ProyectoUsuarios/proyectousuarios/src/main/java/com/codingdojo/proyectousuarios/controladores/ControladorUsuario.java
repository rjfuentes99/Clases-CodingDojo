package com.codingdojo.proyectousuarios.controladores;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String despliegaHome(){
        String respuesta = "";
        String usuarios[] = {"Elena", "Juan", "Pablo","Pedro"};
        for(int i = 0; i<usuarios.length; i++){
            respuesta += "<h2>"+usuarios[i]+"</h2>";
        }
        return respuesta;

    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloNombre(@RequestParam(value = "nombre") String name){
        String respuesta = "<h1> Hello "+name+ "</h1>";
        return respuesta;
    }

    @RequestMapping(value = "/hello/{nombre}", method = RequestMethod.GET)
    public String helloNombrePath(@PathVariable(value = "nombre") String name){
        String respuesta = "<h1> Hello "+name+ "</h1>";
        return respuesta;
    }

}
