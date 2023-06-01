package com.codingdojo.ricardo.beltexamjava.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.ricardo.beltexamjava.models.Course;
import com.codingdojo.ricardo.beltexamjava.models.User;
import com.codingdojo.ricardo.beltexamjava.repository.RepositorioCursos;
import com.codingdojo.ricardo.beltexamjava.repository.RepositorioUsuarios;

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
    private RepositorioCursos repositorio_cursos;

    // Me guarda en la base de datos un objeto de projecto
    public Course save_course(Course nuevoCurso){
        return repositorio_cursos.save(nuevoCurso);
    }
    // Me regresa un objeto de usuario en base a un ID
    public User find_user(Long id){
        return repositorio_usuarios.findById(id).orElse(null);
    }
    // Me regresa un proyecto en base a su ID
    public Course find_course(Long id){
        return repositorio_cursos.findById(id).orElse(null);
    }
    public List<Course> listaCursos(){
        return repositorio_cursos.findAll();
    }
    
    // Guardar en BD los cambios del usuario
    public User save_user(User user){
        return repositorio_usuarios.save(user);
    }

	// Unir persona a evento
	public void join_course(Long user_id, Long course_id){
		User miUsuario = find_user(user_id);
		Course evento = find_course(course_id);

		miUsuario.getUsuario().add(evento);
		repositorio_usuarios.save(miUsuario);
	}
	// Quitar evento de mi lista de eventos a asistir
	public void remove_course(Long user_id, Long course_id){
		User miUsuario = find_user(user_id);
		Course course = find_course(course_id);

		miUsuario.getUsuario().remove(course);
		repositorio_usuarios.save(miUsuario);
	}

    public void delete(Long course_id){
        repositorio_cursos.deleteById(course_id);
    }



}
