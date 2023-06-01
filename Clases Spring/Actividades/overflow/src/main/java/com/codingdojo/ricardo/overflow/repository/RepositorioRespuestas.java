package com.codingdojo.ricardo.overflow.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ricardo.overflow.models.Answer;

@Repository
public interface RepositorioRespuestas extends CrudRepository<Answer, Long>{
    List<Answer> findAll();
}
