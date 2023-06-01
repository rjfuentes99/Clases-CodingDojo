package com.codingdojo.ricardo.projectmanager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ricardo.projectmanager.model.Project;
import com.codingdojo.ricardo.projectmanager.model.User;

@Repository
public interface RepositorioProjectos extends CrudRepository<Project, Long>{

    //Projectos al que no pertenece el usuario
    List<Project> findByUserJoinedNotContains(User user);

    //Projectos al que si pertenece el usuario
    List<Project> findAllByUserJoined(User user);
    
}
