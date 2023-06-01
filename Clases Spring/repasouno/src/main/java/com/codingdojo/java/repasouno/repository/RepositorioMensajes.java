package com.codingdojo.java.repasouno.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.java.repasouno.models.Message;

@Repository
public interface RepositorioMensajes extends CrudRepository<Message, Long>{
    
    List<Message> findAll();
}
