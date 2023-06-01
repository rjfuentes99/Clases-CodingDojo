package com.codingdojo.ricardo.lenguajes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.ricardo.lenguajes.models.Lenguaje;
import com.codingdojo.ricardo.lenguajes.repository.RepositorioLenguaje;

@Service
public class AppService {
    
    @Autowired
    private RepositorioLenguaje repositorio_lenguaje;

    public List<Lenguaje> todos_lenguajes(){
        return repositorio_lenguaje.findAll();
    }

    public Lenguaje buscar_lenguaje(Long id){
        return repositorio_lenguaje.findById(id).orElse(null);
    }

    public Lenguaje nuevo_lenguaje(Lenguaje nuevoLenguaje){
        return repositorio_lenguaje.save(nuevoLenguaje);
    }

    public Lenguaje editar_lenguaje(Lenguaje lenguajeAct){
        return repositorio_lenguaje.save(lenguajeAct);
    }
    public void borrar_lenguaje(Long id){
        repositorio_lenguaje.deleteById(id);
    }

}
