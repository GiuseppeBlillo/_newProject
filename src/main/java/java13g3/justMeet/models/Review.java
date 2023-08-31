package java13g3.justMeet.models;

import jakarta.persistence.*;
import java13g3.justMeet.enumerations.RatingEnum;

import java.sql.Blob;
import java.util.List;

@Entity
@Table(name = "REVIEW")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "PHOTOS")
    private List<Blob> photos;
    @Column(name = "RATING", nullable = false)
    private RatingEnum rating;
    @OneToOne
    @JoinColumn(name = "REGISTRATION_ID", nullable = false)
    private Registration registrationId;

    public Review(Long id, String text, List<Blob> photos, RatingEnum rating) {
        this.id = id;
        this.text = text;
        this.photos = photos;
        this.rating = rating;
    }

    public Review(RatingEnum rating, Registration registrationId) {
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

    public List<Blob> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Blob> photos) {
        this.photos = photos;
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