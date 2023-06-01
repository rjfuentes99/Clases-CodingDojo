package com.codingdojo.java.repasouno.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.java.repasouno.models.User;
import com.codingdojo.java.repasouno.models.Event;
import com.codingdojo.java.repasouno.models.Message;
import com.codingdojo.java.repasouno.models.State;
import com.codingdojo.java.repasouno.services.AppService;

@Controller
@RequestMapping("/events")
public class ControladorEventos {

    @Autowired
    private AppService servicio;

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("event") Event event,BindingResult result, HttpSession session,Model model){
        
        //Revisamos que haya inciiado sesion
        User usuario_en_sesion = (User)session.getAttribute("user_session");
        if (usuario_en_sesion == null) {
            return "redirect:/"; 
        }     
        //Revisamos que haya iniciado sesion 
        if (result.hasErrors()) {
            
            //Mandamos los estados
            model.addAttribute("states", State.States);

            // Obtenemos usuario en sesion
            User myUser = servicio.find_user(usuario_en_sesion.getId());

            model.addAttribute("user", myUser); // Enviamos a dashboard el user

            // Mandamos las dos listas de eventos

            String miEstado = usuario_en_sesion.getState();
            List<Event> eventos_miestado = servicio.eventos_Estado(miEstado);
            List<Event> eventos_otros = servicio.eventos_otros(miEstado);

            model.addAttribute("eventos_miestado", eventos_miestado);
            model.addAttribute("eventos_otros", eventos_otros);

            return "dashboard.jsp";
        }else{
            servicio.save_event(event);
            return "redirect:/dashboard";
        }              
    }
    @GetMapping("/join/{event_id}")
    public String join(@PathVariable("event_id") Long event_id, HttpSession session){
        // Revisamos que haya iniciado sesion
        User usuario_en_sesion = (User)session.getAttribute("user_session");
        if (usuario_en_sesion == null) {
            return "redirect:/"; 
        } 

        servicio.join_event(usuario_en_sesion.getId(), event_id);

        return "redirect:/dashboard";
    }
    @GetMapping("/remove/{event_id}")
    public String remove(@PathVariable("event_id") Long event_id, HttpSession session){
        // Revisamos que haya iniciado sesion
        User usuario_en_sesion = (User)session.getAttribute("user_session");
        if (usuario_en_sesion == null) {
            return "redirect:/"; 
        }
        servicio.remove_event(usuario_en_sesion.getId(), event_id);

        return "redirect:/dashboard";
    }

    @GetMapping("/{event_id}")
    public String show_event(@PathVariable("event_id") Long event_id, HttpSession session,
                            @ModelAttribute("message") Message message, Model model){
         // Revisamos que haya iniciado sesion
         User usuario_en_sesion = (User)session.getAttribute("user_session");
         if (usuario_en_sesion == null) {
             return "redirect:/"; 
         }
         
         Event evento = servicio.find_event(event_id);
         model.addAttribute("evento", evento);

         return "show.jsp";
    }
    @PostMapping("/message")
    public String message(@Valid @ModelAttribute("message") Message message,
                        HttpSession session , BindingResult result, Model model) {
      
      // Revisamos que haya iniciado sesion
      User usuario_en_sesion = (User)session.getAttribute("user_session");
      if (usuario_en_sesion == null) {
          return "redirect:/"; 
      }
      if (result.hasErrors()) {
        model.addAttribute(("evento"), message.getEvent()); 
        return "show.jsp";
    }else{
        servicio.save_message(message);
        return "redirect:/events/"+message.getEvent().getId();
    }

    }
}
