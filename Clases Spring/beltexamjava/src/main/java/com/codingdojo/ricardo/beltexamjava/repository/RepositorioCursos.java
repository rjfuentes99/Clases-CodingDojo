package com.codingdojo.ricardo.beltexamjava.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ricardo.beltexamjava.models.Course;
import com.codingdojo.ricardo.beltexamjava.models.User;

@Repository
public interface RepositorioCursos extends CrudRepository<Course, Long> {
    
    List<Course> findAll();

    List<Course> findByAttendeesNotContains(User user);

    //Projectos al que si pertenece el usuario
    List<Course> findAllByAttendees(User user);
}
