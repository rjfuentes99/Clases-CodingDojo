package com.codingdojo.ricardo.projectmanager.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.ricardo.projectmanager.model.Project;
import com.codingdojo.ricardo.projectmanager.model.User;
import com.codingdojo.ricardo.projectmanager.service.AppService;

@Controller
public class ControladorUsuarios {
    
    @Autowired
    private AppService servicio;

    @GetMapping("/")
    public String index(@ModelAttribute("nuevoUsuario") User nuevoUsuario){
        return "index.jsp";
    }
    // Guardamos el usuario en la base de datos
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("nuevoUsuario") User nuevoUsuario,
                            BindingResult result, HttpSession session){
        servicio.register(nuevoUsuario, result);
        if (result.hasErrors()) {
            return "index.jsp";
        }else{
            session.setAttribute("user_session", nuevoUsuario);
            return "redirect:/dashboard";
        }                        
    }
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model){
        /*Revisamos la sesion */
        User usuario_en_sesion = (User)session.getAttribute("user_session");
        if (usuario_en_sesion == null) {
            return "redirect:/"; 
        }
        /*Revisamos la sesion */

        //Lista de projectos a los que pertenezco
        List<Project> mis_projectos = servicio.find_my_projects(usuario_en_sesion);
    
        //Lista de projectos a los que no pertenezco
        List<Project> resto_projectos = servicio.find_other_projects(usuario_en_sesion);
        
        model.addAttribute("mis_projectos", mis_projectos);
        model.addAttribute("resto_projectos", resto_projectos);
        
        return "dashboard.jsp";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user_session");
        return "redirect:/";
    }

    @PostMapping("/login") // RequestParam solo para formularios normales
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes,
                        HttpSession session){
        // Necesitamos enviar email y password y que el servicio verifique que son correctos
        User usuario_login = servicio.login(email, password);
        if (usuario_login == null) {
            // Hay un error
            redirectAttributes.addFlashAttribute("error_login","El correo/password son incorrectos");
            return "redirect:/";
        }else{
            // Guardamos en sesion
            session.setAttribute("user_session", usuario_login);
            return "redirect:/dashboard";
        }             
    }

}
