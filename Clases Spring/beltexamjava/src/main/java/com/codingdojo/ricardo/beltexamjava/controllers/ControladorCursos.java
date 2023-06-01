package com.codingdojo.ricardo.beltexamjava.controllers;

import javax.servlet.http.HttpSession;
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

import com.codingdojo.ricardo.beltexamjava.models.Course;
import com.codingdojo.ricardo.beltexamjava.models.User;
import com.codingdojo.ricardo.beltexamjava.service.AppService;

@Controller
@RequestMapping("/course")
public class ControladorCursos {
    

    @Autowired
    private AppService servicio;

    @GetMapping("/new")
    public String new_course(@ModelAttribute("course") Course course,
                                HttpSession session){
        /*REVISAMOS LA SESION*/
		User usuario_en_sesion = (User)session.getAttribute("user_session");
		
		if(usuario_en_sesion == null) {
			return "redirect:/";
		}
		/*REVISAMOS LA SESION*/
        return "new.jsp";                           
    }

    @PostMapping("/create")//para mostrar la informacion
    public String create_course(@Valid @ModelAttribute("course") Course course,
                                BindingResult result,HttpSession session){

        User usuario_en_sesion = (User)session.getAttribute("user_session");
		
		if(usuario_en_sesion == null) {
			return "redirect:/";
		}
		/*REVISAMOS LA SESION*/ 
        if (result.hasErrors()) {
            return "new.jsp";
        }else{
            Course nuevoCurso = servicio.save_course(course);
            User myUser = servicio.find_user(usuario_en_sesion.getId());
            myUser.getUsuario().add(nuevoCurso);
            servicio.save_user(myUser);

            return "redirect:/dashboard";
        }
    }
    
    @GetMapping("/info/{course_id}")
    public String show_course_info(@PathVariable("course_id") Long course_id, HttpSession session,
                             Model model){
         // Revisamos que haya iniciado sesion
         User usuario_en_sesion = (User)session.getAttribute("user_session");
         if (usuario_en_sesion == null) {
             return "redirect:/"; 
         }
         // Revisamos que haya iniciado sesion
         
         Course curso = servicio.find_course(course_id);
         model.addAttribute("cursoid", curso);

         return "info.jsp";
    }


    @GetMapping("/join/{course_id}")
    public String join(@PathVariable("course_id") Long course_id, HttpSession session){
        // Revisamos que haya iniciado sesion
        User usuario_en_sesion = (User)session.getAttribute("user_session");
        if (usuario_en_sesion == null) {
            return "redirect:/"; 
        } 

        servicio.join_course(usuario_en_sesion.getId(), course_id);

        return "redirect:/dashboard";
    }
    
    @GetMapping("/remove/{course_id}")
    public String remove(@PathVariable("course_id") Long course_id, HttpSession session){
        // Revisamos que haya iniciado sesion
        User usuario_en_sesion = (User)session.getAttribute("user_session");
        if (usuario_en_sesion == null) {
            return "redirect:/"; 
        }
        servicio.remove_course(usuario_en_sesion.getId(), course_id);

        return "redirect:/dashboard";
    }

    @GetMapping("/edit/{course_id}")
    public String edit(@PathVariable("course_id") Long course_id,HttpSession session,
                        @ModelAttribute("course") Course course, Model model){
        /*REVISAMOS LA SESION*/                   
            User usuario_en_sesion = (User)session.getAttribute("user_session");
		
            if(usuario_en_sesion == null) {
                return "redirect:/";
            }
        /*REVISAMOS LA SESION*/    
        
        Course course_edit = servicio.find_course(course_id);

        // Revisamos que el id del lead sea igual al id del usuario en sesion
        if (course_edit.getPlanner().getId() != usuario_en_sesion.getId()) {
            return "redirect:/dashboard";
        }

        model.addAttribute("course", course_edit);

        return "edit.jsp";
    }
    
    @PutMapping("/update")
    public String update(@Valid @ModelAttribute("course") Course course, BindingResult result, HttpSession session, Model model){
        /*REVISAMOS LA SESION*/                   
        User usuario_en_sesion = (User)session.getAttribute("user_session");
		
        if(usuario_en_sesion == null) {
            return "redirect:/";
        }
    /*REVISAMOS LA SESION*/    

        if (result.hasErrors()) {
            // Obtengo el proyecto para enviarlo denuevo
            Course course_edit = servicio.find_course(course.getId());
            model.addAttribute("course", course_edit);
            return "edit.jsp";
        }else{
            // Los usuarios que forman parte del proyecto deben agregarse de nuevo
            Course thisCourse = servicio.find_course(course.getId());
            course.setAttendees(thisCourse.getAttendees());
            servicio.save_course(course);
            return "redirect:/dashboard";
        }
    }

    @DeleteMapping("delete/{cursoid}")
    public String eliminar_evento(@PathVariable("cursoid") Long id, HttpSession session){

        /*REVISAMOS LA SESION*/                   
        User usuario_en_sesion = (User)session.getAttribute("user_session");
		
        if(usuario_en_sesion == null) {
            return "redirect:/";
        }
        /*REVISAMOS LA SESION*/
        servicio.delete(id);    
        return "redirect:/dashboard";
    }
    
}
