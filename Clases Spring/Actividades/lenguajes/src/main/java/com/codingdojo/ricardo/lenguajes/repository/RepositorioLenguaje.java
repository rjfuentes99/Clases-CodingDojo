package com.codingdojo.ricardo.lenguajes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ricardo.lenguajes.models.Lenguaje;

@Repository
public interface RepositorioLenguaje extends CrudRepository <Lenguaje, Long>{
    
    List <Lenguaje> findAll();

}
