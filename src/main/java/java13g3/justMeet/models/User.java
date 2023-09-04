package java13g3.justMeet.models;

import jakarta.persistence.*;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "NAME")
    String name;
    @Column(name = "SURNAME")
    String surname;
    @Column(name = "PROFILE_PICTURE")
    String photoProfile;
    @Column(name = "NICKNAME", nullable = false)
    String nickname;
    @Column(name = "AGE")
    Integer age;
    @Column(name = "EMAIL", nullable = false)
    String email;
    @Column(name = "PHONE_NUMBER", nullable = false)
    String phoneNumber;

    public User(Long id, String name, String surname, String photoProfile, String nickname, Integer age, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.photoProfile = photoProfile;
        this.nickname = nickname;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public User() {
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

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
