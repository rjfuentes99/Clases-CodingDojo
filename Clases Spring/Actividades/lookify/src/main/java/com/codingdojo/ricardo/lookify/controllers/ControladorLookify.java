package com.codingdojo.ricardo.lookify.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.ricardo.lookify.models.Song;
import com.codingdojo.ricardo.lookify.services.AppService;

@Controller
public class ControladorLookify {
    
    @Autowired
    private AppService servicio;

    @GetMapping("/")
    public String index(){
        return "index.jsp";
    }

    @RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> canciones = servicio.lista_canciones();
		model.addAttribute("canciones", canciones);
		return "dashboard.jsp";
	}

    @RequestMapping("/songs/{id}")
	public String songs(@PathVariable("id") Long id, Model model) {
		Song cancion = servicio.buscar_cancion(id);
		model.addAttribute("cancion", cancion);
		return "song.jsp";
	}
    @RequestMapping("/new")
	public String nueva_cancion(@ModelAttribute("nuevaCancion") Song Cancion, Model model) {
		return "new.jsp";
	}

    @RequestMapping(value = "/new", method = RequestMethod.POST)
	public String guardar_cancion(@Valid @ModelAttribute("nuevaCancion") Song cancion, BindingResult result,Model model) {
		if (result.hasErrors()) {
			List<Song> canciones = servicio.lista_canciones();
			model.addAttribute("canciones", canciones);
            return "new.jsp";
        }else{
            servicio.nueva_cancion(cancion);
            return "redirect:/dashboard";
        }
	}
	@DeleteMapping("/delete/{id}")
    public String delete_lenguaje(@PathVariable("id") Long id){
        servicio.borrar_cancion(id);;
        return "redirect:/dashboard";
    }

	@RequestMapping("/topten")
	public String topten(Model model) {
		List<Song> canciones = servicio.getTopTen();
		model.addAttribute("canciones", canciones);
		return "topsongs.jsp";
	}

	@RequestMapping("/search/{artista}")
	public String search(@PathVariable("artista") String artista, Model model) {
		List<Song> songs = servicio.getSearchSongs(artista);
		model.addAttribute("artista", artista);
		model.addAttribute("songs", songs);
		return "/search.jsp";
	}
	
	@PostMapping("/search")
	public String search(@RequestParam("artista") String artista) {
		return "redirect:/search/"+artista;
	}
}
