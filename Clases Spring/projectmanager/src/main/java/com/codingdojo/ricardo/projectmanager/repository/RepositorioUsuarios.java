package com.codingdojo.ricardo.projectmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ricardo.projectmanager.model.User;

@Repository
public interface RepositorioUsuarios extends CrudRepository<User, Long>{
    
    User findByEmail(String email);
}
