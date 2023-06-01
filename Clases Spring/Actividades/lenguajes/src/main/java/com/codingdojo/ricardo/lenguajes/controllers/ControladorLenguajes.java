package com.codingdojo.ricardo.lenguajes.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.ricardo.lenguajes.models.Lenguaje;
import com.codingdojo.ricardo.lenguajes.services.AppService;

@Controller
public class ControladorLenguajes {
    
    @Autowired
    private AppService servicio;

    @GetMapping("/lenguages")
    public String index(Model model,
                        @ModelAttribute("nuevoLenguaje") Lenguaje lenguaje){
        List <Lenguaje> lenguajes = servicio.todos_lenguajes();
        model.addAttribute("lenguajes", lenguajes);
        return "index.jsp";
    }

    @PostMapping("/lenguages")
    public String create(@Valid @ModelAttribute("nuevoLenguaje") Lenguaje lenguaje,
                        BindingResult result){
        if (result.hasErrors()) {
            return "index.jsp";
        }else{
            servicio.nuevo_lenguaje(lenguaje);
            return "redirect:/lenguages";
        }
    }
    @DeleteMapping("/delete/{id}")
    public String delete_lenguaje(@PathVariable("id") Long id){
        servicio.borrar_lenguaje(id);
        return "redirect:/lenguages";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model,@ModelAttribute("nuevoLenguaje") Lenguaje lenguaje){
        Lenguaje lenguaje_edit = servicio.buscar_lenguaje(id);
        model.addAttribute("lenguaje", lenguaje_edit);
        return "edit.jsp";
    }
    @PutMapping("/edit/{id}")
    public String updated(@PathVariable("id") Long id,@Valid @ModelAttribute("nuevoLenguaje") Lenguaje lenguaje, BindingResult result){

        if (result.hasErrors()) {
            return "edit.jsp";
        }else{
            servicio.nuevo_lenguaje(lenguaje);
            return "redirect:/lenguages";
        }
    }

    @GetMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Lenguaje languaje = servicio.buscar_lenguaje(id);
		model.addAttribute("languaje_show", languaje);
		return "show.jsp";
	}
}
