package java13g3.justMeet.models;

import jakarta.persistence.*;

@Entity
@Table(name = "REGISTRATION")
public class Registration {
    @OneToMany
    @JoinColumn(name = "USER_ID")
    private User userId;
    @ManyToOne
    @JoinColumn(name = "EVENT_ID")
    private Event eventId;

    public Registration(User userId, Event eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    public Registration() {
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Event getEventId() {
        return eventId;
    }

    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }
}
