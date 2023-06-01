package com.codingdojo.ricardo.login.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ricardo.login.models.User;

@Repository
public interface RepositorioUsuario extends CrudRepository<User, Long>{
    
    User findByEmail(String email);
}
