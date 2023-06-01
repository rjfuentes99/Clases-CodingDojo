package com.codingdojo.ricardo.licencia.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ricardo.licencia.models.Person;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Person, Long>{

    List<Person> findAll();	
}

