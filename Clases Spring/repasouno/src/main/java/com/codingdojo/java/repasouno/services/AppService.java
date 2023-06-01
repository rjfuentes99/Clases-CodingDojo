package com.codingdojo.java.repasouno.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.java.repasouno.models.Event;
import com.codingdojo.java.repasouno.models.Message;
import com.codingdojo.java.repasouno.models.User;
import com.codingdojo.java.repasouno.repository.RepositorioEventos;
import com.codingdojo.java.repasouno.repository.RepositorioMensajes;
import com.codingdojo.java.repasouno.repository.RepositorioUsuarios;

@Service
public class AppService {
    
    @Autowired
    private RepositorioUsuarios repositorio_usuarios;

    @Autowired
    private RepositorioEventos repositorio_eventos;

    @Autowired
    private RepositorioMensajes repositorio_mensajes;

    public User register(User nuevoUsuario, BindingResult result) {
		
		String nuevoEmail = nuevoUsuario.getEmail(); //Obtenemos el correo
		User existeUsuario = repositorio_usuarios.findByEmail(nuevoEmail); //NULL o Objeto User
		
		//Verificando que el correo no exista
		if(existeUsuario != null) {
			result.rejectValue("email", "Unique", "El correo ya está registrado en nuestra BD");
		}
		
		//Comparando las contraseñas
		String contra = nuevoUsuario.getPassword();
		String confirmacion = nuevoUsuario.getConfirm();
		if(! contra.equals(confirmacion)) {
			result.rejectValue("confirm", "Matches", "Las contraseñas no coinciden");
		}
		
		if(!result.hasErrors()) {
			//Encriptamos contraseña
			String contra_encr = BCrypt.hashpw(nuevoUsuario.getPassword(), BCrypt.gensalt());
			nuevoUsuario.setPassword(contra_encr);
			//Guardo usuario
			return repositorio_usuarios.save(nuevoUsuario);
		}else {
			return null;
		}
		
		
	}
    
	public User login(String email, String password) {
		
		//Buscamos que el correo esté en la BD
		User existeUsuario = repositorio_usuarios.findByEmail(email); //NULL o Objeto Usuario
		if(existeUsuario == null) {
			return null;
		}
		
		//Comparamos contraseñas encriptadas
		if(BCrypt.checkpw(password, existeUsuario.getPassword())) {
			return existeUsuario;
		} else {
			return null;
		}
		
	}

	public User find_user(Long id){
		return repositorio_usuarios.findById(id).orElse(null);
	}

	public Event save_event(Event nuevoEvento){
		return repositorio_eventos.save(nuevoEvento);
	}

	// Eventos del estado

	public List<Event> eventos_Estado(String estado){
		return repositorio_eventos.findByEventState(estado);
	}
	// Eventos que no son del estado
	public List<Event> eventos_otros(String estado){
		return repositorio_eventos.findByEventStateIsNot(estado);
	}

	// Regresa un evento
	public Event find_event(Long id){
		return repositorio_eventos.findById(id).orElse(null);
	}
	// Unir persona a evento
	public void join_event(Long user_id, Long event_id){
		User miUsuario = find_user(user_id);
		Event evento = find_event(event_id);

		miUsuario.getEventsAttending().add(evento);
		repositorio_usuarios.save(miUsuario);
	}
	// Quitar evento de mi lista de eventos a asistir
	public void remove_event(Long user_id, Long event_id){
		User miUsuario = find_user(user_id);
		Event evento = find_event(event_id);

		miUsuario.getEventsAttending().remove(evento);
		repositorio_usuarios.save(miUsuario);
	}
	// Guardar un mensaje
	public Message save_message(Message nuevoMensaje){
		return repositorio_mensajes.save(nuevoMensaje);
	}
}

