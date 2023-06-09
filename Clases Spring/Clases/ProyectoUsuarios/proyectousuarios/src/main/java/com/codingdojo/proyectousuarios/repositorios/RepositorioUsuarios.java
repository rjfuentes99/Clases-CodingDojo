package com.codingdojo.proyectousuarios.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.proyectousuarios.modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario,Long>{
    
    //SELECT * FROM users
    List<Usuario> findAll();

    //Select * FROM users WHERE eid = <IDL>
    List<Usuario> findById(long id);

    //Select * FROM users WHERE email = <EMAIL>
    List<Usuario> findByEmail(String email);

    //INSERT into users(first_name, last_name, password,email) VALUES (Datos del obj Usuario)
    //UPDATE -> siempre y cuando el objeto tenga id
    Usuario save(Usuario nuevoUsuario);

    void deleteById(Long id);

}
