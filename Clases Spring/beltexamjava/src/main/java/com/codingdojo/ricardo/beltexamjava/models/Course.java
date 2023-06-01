package com.codingdojo.ricardo.beltexamjava.models;

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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="courses")
public class Course {
    
    // Atributos
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El campo de titulo es obligatorio")
    @Size(min=2, max=30, message = "El titulo debe de tener entre 2 y 30 caracteres")
    private String titulo;

    @NotEmpty(message = "El campo de instructor es obligatorio")
    private String instructor;

    @NotNull
    @Min(0)
    @Max(20)
    private Integer capacidad;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created_at;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updated_at;


    // Relaciones

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User planner;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="course_has_users",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn( name = "user_id")
    )
    private List<User> attendees;

    //Constructores
    
    public Course() {
    }


    // Getters y setters

    @PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	
    @PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getInstructor() {
        return instructor;
    }


    public void setInstructor(String instructor) {
        this.instructor = instructor;
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


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public List<User> getAttendees() {
        return attendees;
    }


    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }


    public User getPlanner() {
        return planner;
    }


    public void setPlanner(User planner) {
        this.planner = planner;
    }

    






    
}
