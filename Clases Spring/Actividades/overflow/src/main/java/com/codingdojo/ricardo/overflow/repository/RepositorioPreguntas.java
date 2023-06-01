package com.codingdojo.ricardo.overflow.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ricardo.overflow.models.Question;

@Repository
public interface RepositorioPreguntas extends CrudRepository<Question, Long> {
    
    List<Question> findAll();
}
