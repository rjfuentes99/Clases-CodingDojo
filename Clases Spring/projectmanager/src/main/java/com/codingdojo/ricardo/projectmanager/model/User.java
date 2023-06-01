package com.codingdojo.ricardo.projectmanager.model;

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
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El campo de nombre es obligatorio")
    @Size(min=2, max=30, message = "El nombre debe de tener entre 2 y 30 caracteres")
    private String first_name;

    @NotEmpty(message = "El campo de email es obligatorio")
    @Email(message = "Ingrese un correo electronico valido.")
    private String email;

    @NotEmpty(message = "El campo de password es obligatorio.")
    @Size(min = 6, max = 128, message = "La contraseña debe ser entre 6 y 128 caracteres")
    private String password;

    @Transient // No me guarda el dato en la base de datos
    @NotEmpty(message = "El campo de confirmacion es obligatorio.")
    @Size(min = 6, max = 128, message = "La confirmacion debe ser entre 6 y 128 caracteres")
    private String confirm;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created_at;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updated_at;

    @OneToMany(mappedBy = "lead", fetch = FetchType.LAZY)
    private List<Project> my_projects;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="projects_has_users",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn( name = "project_id")
    )
    private List<Project> projects_join;

    //Constructores

    public User() {
    }


    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
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

    public List<Project> getMy_projects() {
        return my_projects;
    }

    public void setMy_projects(List<Project> my_projects) {
        this.my_projects = my_projects;
    }

    public List<Project> getProjects_join() {
        return projects_join;
    }

    public void setProjects_join(List<Project> projects_join) {
        this.projects_join = projects_join;
    }


    @PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}


    
    
}

