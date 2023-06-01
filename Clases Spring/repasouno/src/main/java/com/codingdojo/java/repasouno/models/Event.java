package com.codingdojo.java.repasouno.models;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El campo de nombre de evento es obligatorio")
    private String eventName;

    @Future // Fecha en futuro
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date eventDate;

    @NotEmpty(message="El campo de locacion es obligatorio.")
    private String eventLocation;

    @NotEmpty(message="El campo de estado es obligatorio.")
    private String eventState;
    
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
        name ="users_has_events",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns =  @JoinColumn(name = "user_id")
    )
    private List<User> attendees; // Personas que asistiran
    
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private List<Message> messages; // Mensajes publicados al evento

    // Constructores

    public Event() {
    }


    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventState() {
        return eventState;
    }

    public void setEventState(String eventState) {
        this.eventState = eventState;
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

    public User getPlanner() {
        return planner;
    }

    public void setPlanner(User planner) {
        this.planner = planner;
    }

    public List<User> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
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
