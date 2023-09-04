package java13g3.justMeet.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "REGISTRATION")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    @JoinColumn(name = "REGISTRATION_ID")
    private List<User> userList;
    @ManyToOne
    @JoinColumn(name = "EVENT_ID")
    private Event eventId;
    @Column(name = "PARTECIPATION_DATE")
    private LocalDateTime dateTime;

    public Registration(List<User> userList, Event eventId, LocalDateTime dateTime) {
        this.userList = userList;
        this.eventId = eventId;
        this.dateTime = dateTime;
    }

    public Registration() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Event getEventId() {
        return eventId;
    }

    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}


