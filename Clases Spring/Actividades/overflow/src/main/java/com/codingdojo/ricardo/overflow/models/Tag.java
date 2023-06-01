package com.codingdojo.ricardo.overflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tags")
public class Tag {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String etiqueta;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyy-MM-dd")
    private Date created_at;

    @DateTimeFormat(pattern="yyy-MM-dd")
    private Date updated_at;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="tags_questions",
                joinColumns = @JoinColumn(name="tag_id"),
                inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<Question> questions;
   
    /*Constructores */
    public Tag() {
    }

    public Tag(@NotNull String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @PrePersist
	protected void onCreate(){
		this.created_at= new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}

    /* Getters y setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    
}
