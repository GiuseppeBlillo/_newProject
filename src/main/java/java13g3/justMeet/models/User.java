package java13g3.justMeet.models;

import java.sql.Blob;

public class User {
    Long id;
    String name;
    String surname;
    Blob photoProfile;
    String nickname;
    Integer age;
    String email;
    Integer phoneNumber;

    public User(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public User(Long id, String name, String surname, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    public User(Long id, String name, String surname, Blob photoProfile, String nickname, Integer age, String email, Integer phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.photoProfile = photoProfile;
        this.nickname = nickname;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Blob getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(Blob photoProfile) {
        this.photoProfile = photoProfile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
