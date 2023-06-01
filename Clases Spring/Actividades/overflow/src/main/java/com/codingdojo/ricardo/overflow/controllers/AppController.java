package com.codingdojo.ricardo.overflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.ricardo.overflow.models.Answer;
import com.codingdojo.ricardo.overflow.models.Question;
import com.codingdojo.ricardo.overflow.models.Tag;
import com.codingdojo.ricardo.overflow.services.Servicios;

@Controller
public class AppController {
    
    @Autowired
    private Servicios servicio;

    @GetMapping("/nueva_pregunta")
    public String nueva_pregunta(@ModelAttribute("question") Question question){
        return "nueva_pregunta.jsp";
    }

    @PostMapping("nueva_pregunta")
    public String guardar_pregunta(@Valid @ModelAttribute("question") Question question,
                                    BindingResult result,
                                    @RequestParam(value="etiquetas") String stringEtiquetas){
            if (result.hasErrors()) {
                return "nueva_pregunta.jsp";
            }else{
                //stringEtiquetas = "programacion, tecnologia,computadora"
                //listaEtiquetas = {"programacion","tecnologia","comptuadora"};
                String[] listaEtiquetas = stringEtiquetas.trim().split(",");
                ArrayList<Tag> etiquetas = new ArrayList<>();

                for(String t: listaEtiquetas){
                    //Buscar si existe el tag
                    Tag etiqueta = servicio.find_tag(t);
                    if (etiqueta == null) {
                        // Creamos una nueva etiqueta
                        Tag nueva_etiqueta = new Tag(t);
                        servicio.save_tag(nueva_etiqueta);
                        etiquetas.add(nueva_etiqueta);
                    }else{
                        etiquetas.add(etiqueta);
                    }
                }

                question.setTags(etiquetas);
                servicio.save_question(question);
                return "redirect:/";
            }
    }
    
    @GetMapping("/") // Lista de preguntas
    public String index(Model model){
        List<Question> questions = servicio.find_questions();
        model.addAttribute("questions", questions);
        return "index.jsp";
    }

    @GetMapping("/nueva_respuesta/{id}")
    public String nueva_respuesta(@PathVariable("id") Long id, Model model, @ModelAttribute("answer") Answer answer){
        Question question = servicio.find_question(id);
        model.addAttribute("question", question);
        return "nueva_respuesta.jsp";
    }
    @PostMapping("/nueva_respuesta/{id}")
    public String guardar_respuesta(@PathVariable("id") Long id, @Valid @ModelAttribute("answer") Answer answer, BindingResult result){
        Question question = servicio.find_question(id);
        if (result.hasErrors()) {
            return "nueva_respuesta.jsp";
        }else{
            Answer nuevaRespuesta = new Answer(answer.getRespuesta());
            nuevaRespuesta.setQuestion(question);
            servicio.save_answer(nuevaRespuesta);
            return "redirect:/nueva_respuesta/"+id;
        }
    }
}
