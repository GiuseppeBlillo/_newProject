package java13g3.justMeet.models;

import jakarta.persistence.*;
import java13g3.justMeet.enumerations.RatingEnum;

@Entity
@Table(name = "REVIEW")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "PHOTO")
    private String photo;
    @Column(name = "RATING")
    private RatingEnum rating;
    @OneToOne
    @JoinColumn(name = "REGISTRATION_ID")
    private Registration registrationId;

    public Review(String text, String photo, RatingEnum rating, Registration registrationId) {
        this.text = text;
        this.photo = photo;
        this.rating = rating;
        this.registrationId = registrationId;
    }
    public Review() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFieldText() {
        return text;
    }

    public void setFieldText(String fieldText) {
        this.text = fieldText;
    }

    public String getPhotos() {
        return photo;
    }

    public void setPhotos(String photo) {
        this.photo = photo;
    }

    public RatingEnum getRating() {
        return rating;
    }

    public void setRating(RatingEnum rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Registration getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Registration registrationId) {
        this.registrationId = registrationId;
    }
}
