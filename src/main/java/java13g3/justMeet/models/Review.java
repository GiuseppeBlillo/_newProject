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
    private List<String> photos;
    @Column(name = "RATING")
    private RatingEnum rating;
    public Review(String text, RatingEnum rating) {
        this.text = text;
        this.rating = rating;
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

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
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


}
