package java13g3.justMeet.models;

import java13g3.justMeet.enumerations.CategoryEnum;
import java13g3.justMeet.enumerations.LanguageEnum;

import java.sql.Blob;
import java.sql.Time;

public class Event {
    Long id;
    String name;
    String description;
    CategoryEnum category;
    LanguageEnum language;
    Blob coverPhoto;
    Time eventDate;
    String eventApi;
    String addressApi;
    Boolean isPrivate;

    public Event(Long id, String name, String description, CategoryEnum category, Time eventDate, Boolean isPrivate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.eventDate = eventDate;
        this.isPrivate = isPrivate;
    }

    public Event(Long id, String name, String description, CategoryEnum category, Time eventDate, String addressApi, Boolean isPrivate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.eventDate = eventDate;
        this.addressApi = addressApi;
        this.isPrivate = isPrivate;
    }

    public Event(Long id, String name, Boolean isPrivate) {
        this.id = id;
        this.name = name;
        this.isPrivate = isPrivate;
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

    public Enum getCategory() {
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

    public Blob getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(Blob coverPhoto) {
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
}
