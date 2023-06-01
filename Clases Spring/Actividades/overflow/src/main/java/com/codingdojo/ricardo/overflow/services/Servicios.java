package com.codingdojo.ricardo.overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.ricardo.overflow.models.Answer;
import com.codingdojo.ricardo.overflow.models.Question;
import com.codingdojo.ricardo.overflow.models.Tag;
import com.codingdojo.ricardo.overflow.repository.RepositorioEtiquetas;
import com.codingdojo.ricardo.overflow.repository.RepositorioPreguntas;
import com.codingdojo.ricardo.overflow.repository.RepositorioRespuestas;

@Service
public class Servicios {
    
    @Autowired
    private RepositorioPreguntas repositorio_preguntas;

    @Autowired
    private RepositorioRespuestas repositorio_respuestas;

    @Autowired
    private RepositorioEtiquetas repositorio_etiquetas;

    /* Funciones */

    public List<Question> find_questions(){
        return repositorio_preguntas.findAll();
    }
    public Question find_question(Long id){
        return repositorio_preguntas.findById(id).orElse(null);
    }
    public Question save_question(Question question){
        return repositorio_preguntas.save(question);
    }
    
    public Answer save_answer(Answer answer){
        return repositorio_respuestas.save(answer);
    }

    public Tag find_tag(String texto){
        return repositorio_etiquetas.findByEtiqueta(texto);
    }
    public Tag save_tag(Tag tag){
        return repositorio_etiquetas.save(tag);
    }

}
