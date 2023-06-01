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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="questions")
public class Question {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String pregunta;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyy-MM-dd")
    private Date created_at;

    @DateTimeFormat(pattern="yyy-MM-dd")
    private Date updated_at;

    @OneToMany(mappedBy="question" , fetch = FetchType.LAZY)
    private List<Answer> answers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="tags_questions",
                joinColumns = @JoinColumn(name="question_id"),
                inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;


    /*Constructores */
    public Question() {
    }

    public Question(String pregunta) {
        this.pregunta = pregunta;
    }


    /* Getters y setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @PrePersist
	protected void onCreate(){
		this.created_at= new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}
}
