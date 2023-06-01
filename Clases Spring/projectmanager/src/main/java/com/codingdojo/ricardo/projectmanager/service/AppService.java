package com.codingdojo.ricardo.projectmanager.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.ricardo.projectmanager.model.Project;
import com.codingdojo.ricardo.projectmanager.model.User;
import com.codingdojo.ricardo.projectmanager.repository.RepositorioProjectos;
import com.codingdojo.ricardo.projectmanager.repository.RepositorioUsuarios;

@Service
public class AppService {
    
    @Autowired
    private RepositorioUsuarios repositorio_usuarios;

    public User register(User nuevoUsuario, BindingResult result){

        String nuevoEmail = nuevoUsuario.getEmail();// Obtenemos el correo

        User existeUsuario = repositorio_usuarios.findByEmail(nuevoEmail); // Null o objeto User

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
            return repositorio_usuarios.save(nuevoUsuario);
        }else{
            return null;
        }
    }
    
    public User login(String email, String password){
        //Buscamos que el correo este en la base de datos
        User existeUsuario = repositorio_usuarios.findByEmail(email); 
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

    @Autowired
    private RepositorioProjectos repositorio_projectos;

    // Me guarda en la base de datos un objeto de projecto
    public Project save_project(Project nuevoProjecto){
        return repositorio_projectos.save(nuevoProjecto);
    }
    // Me regresa un objeto de usuario en base a un ID
    public User find_user(Long id){
        return repositorio_usuarios.findById(id).orElse(null);
    }
    // Me regresa un proyecto en base a su ID
    public Project find_project(Long id){
        return repositorio_projectos.findById(id).orElse(null);
    }
    // Guardar en BD los cambios del usuario
    public User save_user(User user){
        return repositorio_usuarios.save(user);
    }

    /* Me regresa la lista de objetosde proyecto a los que no pertenezco */
    public List<Project> find_other_projects(User usuario_en_sesion){
        return repositorio_projectos.findByUserJoinedNotContains(usuario_en_sesion);
    }
    /* Me regresa la lista de objetosde proyecto a los que si pertenezco */
    public List<Project> find_my_projects(User usuario_en_sesion){
        return repositorio_projectos.findAllByUserJoined(usuario_en_sesion);
    }

    public void save_project_user(Long user_id, Long project_id){
        User myUser = find_user(user_id); //Obteniendo el objeto de usuario
        Project myProject = find_project(project_id); //Obteniendo el objeto de proyecto

        myUser.getProjects_join().add(myProject);
        repositorio_usuarios.save(myUser);
    }

    public void remove_project_user(Long user_id, Long project_id){
        User myUser = find_user(user_id); //Obteniendo el objeto de usuario
        Project myProject = find_project(project_id); //Obteniendo el objeto de proyecto

        myUser.getProjects_join().remove(myProject);
        repositorio_usuarios.save(myUser);

    }


}
