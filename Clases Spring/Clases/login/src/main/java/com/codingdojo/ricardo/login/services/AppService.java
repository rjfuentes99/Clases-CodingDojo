package com.codingdojo.ricardo.login.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.ricardo.login.models.User;
import com.codingdojo.ricardo.login.repository.RepositorioUsuario;

@Service
public class AppService {
    
    @Autowired
    private RepositorioUsuario repositorio_usuario;

    public User register(User nuevoUsuario, BindingResult result){

        String nuevoEmail = nuevoUsuario.getEmail();// Obtenemos el correo

        User existeUsuario = repositorio_usuario.findByEmail(nuevoEmail); // Null o objeto User

        //Verificando que el correo no exista
        if (existeUsuario != null) {
            result.rejectValue("email", "Unique", "El correo ya esta registrado");
        }
        // Comparando las contraseñas
        if (! nuevoUsuario.getPassword().equals(nuevoUsuario.getConfirm())) {
            result.rejectValue("confirm", "Matches", "Las contraseñas no coinciden");
        }

        if (!result.hasErrors()) {
            //Encriptamos contraseñá
            String contra_encri = BCrypt.hashpw(nuevoUsuario.getPassword(),BCrypt.gensalt());
            nuevoUsuario.setPassword(contra_encri);
            //Guardo Usuario
            return repositorio_usuario.save(nuevoUsuario);
        }else{
            return null;
        }
    }
    public User login(String email, String password){
        //Buscamos que el correo este en la base de datos
        User existeUsuario = repositorio_usuario.findByEmail(email); 
        if (existeUsuario == null) {
            return null;
        }

        // Comparamos contraseñas encriptadas

        if (BCrypt.checkpw(password, existeUsuario.getPassword())) {
            return existeUsuario;
        }else{
            return null;
        }
    }
}
