package com.codingdojo.java.repasouno.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.java.repasouno.models.Event;

@Repository
public interface RepositorioEventos extends CrudRepository<Event, Long>{
    
    List<Event> findByEventState(String state);
    
    List<Event> findByEventStateIsNot(String state);
}
