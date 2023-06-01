package com.codingdojo.ricardo.licencia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ricardo.licencia.models.License;

@Repository
public interface RepositorioLicencias extends CrudRepository<License , Long>{
    
    List<License> findTopByOrderByNumberDesc();
}

