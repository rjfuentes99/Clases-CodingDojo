package com.codingdojo.ricardo.lookify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.ricardo.lookify.models.Song;
import com.codingdojo.ricardo.lookify.repository.RepositorioLookify;

@Service
public class AppService {
    
    @Autowired
    private RepositorioLookify repositorio_lookify;

    public List<Song> lista_canciones(){
        return repositorio_lookify.findAll();
    }
    public Song buscar_cancion(Long id){
        return repositorio_lookify.findById(id).orElse(null);
    }
    public Song nueva_cancion(Song nuevaCancion){
        return repositorio_lookify.save(nuevaCancion);
    }
    public void borrar_cancion(Long id){
        repositorio_lookify.deleteById(id);
    }

    public List<Song> getTopTen(){
		return repositorio_lookify.findTop10ByOrderByRatingDesc();
	}
	
	public List<Song> getSearchSongs(String artista){
		return repositorio_lookify.findByArtista(artista);
	}
}
