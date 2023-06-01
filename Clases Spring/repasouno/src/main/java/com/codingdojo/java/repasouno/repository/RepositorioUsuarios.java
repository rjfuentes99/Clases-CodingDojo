package com.codingdojo.java.repasouno.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.java.repasouno.models.User;

@Repository
public interface RepositorioUsuarios extends CrudRepository<User, Long>{
    
    User findByEmail(String email);
}

