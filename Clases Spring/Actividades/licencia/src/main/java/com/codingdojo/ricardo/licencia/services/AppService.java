package com.codingdojo.ricardo.licencia.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.ricardo.licencia.models.License;
import com.codingdojo.ricardo.licencia.models.Person;
import com.codingdojo.ricardo.licencia.repository.RepositorioLicencias;
import com.codingdojo.ricardo.licencia.repository.RepositorioUsuarios;

@Service
public class AppService {
    
    @Autowired
    private RepositorioUsuarios repositorio_usuarios;
    
	public Person createPerson(Person person) {
		return repositorio_usuarios.save(person);
	}
	//find all 
	public List<Person> findAll(){
		return repositorio_usuarios.findAll();
	}
	//find user by id
	public Person findPerson(Long id) {
		Optional<Person> findPerson = repositorio_usuarios.findById(id);
		if(findPerson.isPresent()) {
			System.out.println(findPerson.get());
			return findPerson.get();
		}else {
			return null;
		}
	}

	@Autowired
	private RepositorioLicencias repositorio_licencias;

	private static String newNumber = "000000";

	public AppService(RepositorioLicencias licenseRepository) {
		this.repositorio_licencias = repositorio_licencias;
	}

	// create a license
	public License createLicense(License license) {

		newNumber = String.format("%06d", Integer.parseInt(newNumber) + 1);
		license.setNumber(newNumber);
		return repositorio_licencias.save(license);
	}

	// find License by id
	public License findLicense(Long id) {
		Optional<License> findLic = repositorio_licencias.findById(id);
		if (findLic.isPresent()) {
			return findLic.get();
		} else {
			return null;
		}
	}
}
