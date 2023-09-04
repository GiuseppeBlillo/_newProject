package java13g3.justMeet.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java13g3.justMeet.enumerations.CategoryEnum;
import java13g3.justMeet.enumerations.LanguageEnum;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

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
    @JsonFormat(pattern = "HH:mm:ss dd-MM-yyyy")
    private LocalDateTime eventDate;
    @Column(name = "EVENT_API")
    private String eventApi;
    @Column(name = "ADDRESS_API")
    private String addressApi;
    @Column(name = "ISPRIVATE")
    private Boolean isPrivate;
    @OneToMany
    @JoinColumn(name = "EVENT_ID")
    private List<User> userId;

    public Event(String name, String description, CategoryEnum category, LanguageEnum language,
                 String coverPhoto, LocalDateTime eventDate, String eventApi, String addressApi, Boolean isPrivate, List<User> userId) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.language = language;
        this.coverPhoto = coverPhoto;
        this.eventDate = eventDate;
        this.eventApi = eventApi;
        this.addressApi = addressApi;
        this.isPrivate = isPrivate;
        this.userId = userId;
    }

    public Event(String name, Boolean isPrivate) {
        this.name = name;
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

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
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

    public List<User> getUserId() {
        return userId;
    }

    public void setUserId(List<User> userId) {
        this.userId = userId;
    }

}
