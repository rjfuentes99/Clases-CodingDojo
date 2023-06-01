package com.codingdojo.ricardo.enrutamiento.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String despliegaCoding(){
        return "¡Hola Coding Dojo!";
    }
    @RequestMapping(value = "/python", method = RequestMethod.GET)
    public String despliegaphyton(){
        return "¡Python/Django fue increíble!";
    }
    @RequestMapping(value = "/java", method = RequestMethod.GET)
    public String despliegajava(){
        return "¡Java/Spring es mejor!";
    }

}
