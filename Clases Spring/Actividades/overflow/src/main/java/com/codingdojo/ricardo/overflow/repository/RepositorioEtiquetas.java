package com.codingdojo.ricardo.overflow.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ricardo.overflow.models.Tag;

@Repository
public interface RepositorioEtiquetas extends CrudRepository<Tag, Long>{
    
    List<Tag> findAll();
    
    Tag findByEtiqueta(String e); // Select * FROM tags where etiquera = "TEXTO"


}
