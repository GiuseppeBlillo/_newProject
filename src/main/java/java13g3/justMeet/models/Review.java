package java13g3.justMeet.models;

import java13g3.justMeet.enumerations.RatingEnum;

import java.sql.Blob;
import java.util.List;

public class Review {
    Long id;
    String fieldText;
    List<Blob> photos;
    RatingEnum rating;

    public Review(Long id, String fieldText, RatingEnum rating) {
        this.id = id;
        this.fieldText = fieldText;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFieldText() {
        return fieldText;
    }

    public void setFieldText(String fieldText) {
        this.fieldText = fieldText;
    }

    public List<Blob> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Blob> photos) {
        this.photos = photos;
    }

    public Enum getRating() {
        return rating;
    }

    public void setRating(RatingEnum rating) {
        this.rating = rating;
    }
}
