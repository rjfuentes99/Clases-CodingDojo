package com.codingdojo.ricardo.lookify.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ricardo.lookify.models.Song;

@Repository
public interface RepositorioLookify extends CrudRepository<Song, Long>{

    List<Song> findAll();

	List<Song> findTop10ByOrderByRatingDesc();
    
    List<Song> findByArtista(String artista);
}
