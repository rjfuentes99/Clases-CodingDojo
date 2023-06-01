package com.codingdojo.ricardo.beltexamjava.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ricardo.beltexamjava.models.User;

@Repository
public interface RepositorioUsuarios extends CrudRepository<User, Long>{

    User findByEmail(String email);
    
}
