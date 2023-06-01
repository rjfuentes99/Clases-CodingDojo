package com.codingdojo.proyectousuarios.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.proyectousuarios.modelos.Usuario;
import com.codingdojo.proyectousuarios.repositorios.RepositorioUsuarios;

@Service
public class Servicios {
    
    private final RepositorioUsuarios repositorio_usuarios;
    
    public Servicios(RepositorioUsuarios repositorioUsuarios){
        this.repositorio_usuarios = repositorioUsuarios;
    }

    //Me regresa una lista de todos los usuarios
    public List<Usuario> find_usuarios(){
        return repositorio_usuarios.findAll();
    }

    //Guardamos o Actualizamos un usuario
    public Usuario save_usuario(Usuario nuevUsuario){
        // Nosotros vamos a recibir un objeto de usuario que no tiene ID
        return repositorio_usuarios.save(nuevUsuario);
    }

    //Encontrar un usuario en base a su ID
    public Usuario find_usuario(Long id){
        Optional<Usuario> optionalUser = repositorio_usuarios.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }else{
            return null;
        }
    }
    //Actualizamos usuario
    public Usuario updated_usuario(Usuario usuario){
        //Nosotros vamos a recibir un objeto de usuario que si tiene ID
        return repositorio_usuarios.save(usuario);
    }

    //Borrar Usuario
    public void delete_usuario(Long id){
        repositorio_usuarios.deleteById(id);
    }
}
