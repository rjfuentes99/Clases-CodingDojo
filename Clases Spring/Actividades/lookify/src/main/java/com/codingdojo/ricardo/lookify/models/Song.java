package com.codingdojo.ricardo.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Canciones")
public class Song {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 30)
    private String titulo;

    @Size(min = 5, max = 30)
    private String artista;

    private Integer rating;

    @Column(updatable=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created_at;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updated_at;

    @PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}
   
    // Constructores

    public Song() {
    }
    public Song(Long id, @Size(min = 5, max = 30) String titulo, @Size(min = 5, max = 30) String artista,
            Integer rating) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.rating = rating;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public Date getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    public Date getUpdated_at() {
        return updated_at;
    }
    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    
    
    
}
