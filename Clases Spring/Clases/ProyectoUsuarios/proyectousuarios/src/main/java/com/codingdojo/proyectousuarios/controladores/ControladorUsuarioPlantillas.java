package com.codingdojo.proyectousuarios.controladores;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.proyectousuarios.modelos.Usuario;
import com.codingdojo.proyectousuarios.servicios.Servicios;

@Controller // Se dedican a desplegar JSP
public class ControladorUsuarioPlantillas {

    private final Servicios servicio;
    
    public ControladorUsuarioPlantillas(Servicios servicio){
        this.servicio = servicio;
    }
   /*  @RequestMapping(value="/")
    public String index(Model model){

        model.addAttribute("titulo", "!Bienvenidos a Spring!");

        String usuarios[] ={"Elena","Juana", "Pedro","Pablo"};

        model.addAttribute("usuarios", usuarios);
        
        return "index.jsp";
    }*/
    
    @GetMapping(value = "/registro")
    public String registro(){
        return "registro.jsp";
    }
    @RequestMapping(value = "/registrar" , method = RequestMethod.POST)
    public String registrar(@RequestParam(value = "nombre") String name,@RequestParam(value = "email") 
    String email,HttpSession session, /* Se agrega cuando qeuremos guardar informacion*/
    RedirectAttributes flash  /*Se agrega para generar un mensaje de validacion*/
    ){
         
        System.out.println(name);
        System.out.println(email);

        if (name.equals("")) {
            flash.addFlashAttribute("error", "Porfavor ingresa el nombre de tu usuario");
            return "redirect:/registro";
        }

        session.setAttribute("nombre", name);

        return "redirect:/dashboard";
    }
    @GetMapping("/dashboard")
    public String dashboard(Model model){

        List<Usuario> usuarios = servicio.find_usuarios();

        model.addAttribute("usuarios", usuarios); // Creo una variable usuarios que tiene elv alor de la lista con objetos de usuario   
        
        return "dashboard.jsp";
    }
    @GetMapping("/new")
    public String new_user(@ModelAttribute("usuario") Usuario usuario){
        // En base a lo que el usuario ingrese va a crea un objeto de usuario
        return "new.jsp";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("usuario") Usuario usuario,
                        BindingResult result/* Encargado de regresar los mensajes de validacion */){
        if (result.hasErrors()) {
            return "new.jsp";
        }else{
            servicio.save_usuario(usuario);
            return "redirect:/dashboard";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete_user(@PathVariable("id") Long id){
        servicio.delete_usuario(id);
        return "redirect:/dashboard";
    }

    @RequestMapping("/show/")
    public String show(@PathVariable("id") Long id, Model model){
        return "show.jsp";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model,@ModelAttribute("usuario") Usuario usuario){
        Usuario usuario_edit = servicio.find_usuario(id);
        model.addAttribute("usuario", usuario_edit);
        return "editar.jsp";
    }
    @PutMapping("/edit/{id}")
    public String updated(@PathVariable("id") Long id,@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result){

        if (result.hasErrors()) {
            return "editar.jsp";
        }else{
            servicio.updated_usuario(usuario);
            return "redirect:/dashboard";
        }

    }
}
