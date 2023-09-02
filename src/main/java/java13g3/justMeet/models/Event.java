package java13g3.justMeet.models;

import jakarta.persistence.*;
import java13g3.justMeet.enumerations.CategoryEnum;
import java13g3.justMeet.enumerations.LanguageEnum;

import java.sql.Blob;
import java.sql.Time;
@Entity
@Table(name = "EVENT")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name= "NAME", nullable = false)
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CATEGORY")
    private CategoryEnum category;
    @Column(name = "LANGUAGE")
    private LanguageEnum language;
    @Column(name = "PHOTO")
    private String coverPhoto;
    @Column(name = "DATE")
    private Time eventDate;
    @Column(name = "EVENT_API")
    private String eventApi;
    @Column(name = "ADDRESS_API")
    private String addressApi;
    @Column(name = "ISPRIVATE")
    private Boolean isPrivate;
    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USER")
    private User userId;

     */


    public Event(String name, String description, CategoryEnum category, LanguageEnum language,
                 String coverPhoto, Time eventDate, String eventApi, String addressApi, Boolean isPrivate, User userId) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.language = language;
        this.coverPhoto = coverPhoto;
        this.eventDate = eventDate;
        this.eventApi = eventApi;
        this.addressApi = addressApi;
        this.isPrivate = isPrivate;
    }

    public Event() {
    }

    public Event(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public LanguageEnum getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEnum language) {
        this.language = language;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public Time getEventDate() {
        return eventDate;
    }

    public void setEventDate(Time eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventApi() {
        return eventApi;
    }

    public void setEventApi(String eventApi) {
        this.eventApi = eventApi;
    }

    public String getAddressApi() {
        return addressApi;
    }

    public void setAddressApi(String addressApi) {
        this.addressApi = addressApi;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    /*public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

     */
}
