package com.codingdojo.ricardo.licencia.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.ricardo.licencia.models.License;
import com.codingdojo.ricardo.licencia.models.Person;
import com.codingdojo.ricardo.licencia.services.AppService;

@Controller
public class Controlador {
    @Autowired
    private AppService servicio;

    @RequestMapping("/")
	public String index() {
		return "redirect:/person/new";
	}

	@RequestMapping("/person/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "index.jsp";
	}
	

	@RequestMapping(value = "/create/person", method = RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {

			servicio.createPerson(person);
			return "redirect:/person/new";
		}
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license")License license, Model model) {
		List<Person> listPerson = servicio.findAll();
		model.addAttribute("persons", listPerson);
		return "license.jsp";
	}
	
	@RequestMapping(value="/licenses/create", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license")License license, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/licenses/new";
		}else {
			servicio.createLicense(license);
			return "redirect:/";
		}
		
	}
	@RequestMapping("/person/{id}")
	public String showProfile(@PathVariable("id")Long id, Model model) {
		Person findPerson = servicio.findPerson(id);
		if (findPerson == null) {
			return "redirect:/";
		}else {
			model.addAttribute("person", findPerson);
//			System.out.println(findPerson.getLicense().getExpiration_date());
			return "result.jsp";
		}
		
	}
	
}
