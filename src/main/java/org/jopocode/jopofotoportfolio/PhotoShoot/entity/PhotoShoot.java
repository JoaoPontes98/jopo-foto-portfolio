package org.jopocode.jopofotoportfolio.PhotoShoot.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "photo_shoots")
public class PhotoShoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String eventType;

    private LocalDateTime date;

    @Column(name = "main_photo_uuid")
    private String mainPhoto;

    @ElementCollection
    @CollectionTable(
            name = "photo_shoot_photos",
            joinColumns = @JoinColumn(name = "photo_shoot_id")
    )
    @Column(name = "photo_uuid")
    private List<String> photoList = new ArrayList<>();

    // Default constructor (required by JPA)
    public PhotoShoot() {}

    // Constructor with parameters
    public PhotoShoot(String name, String eventType, LocalDateTime date) {
        this.name = name;
        this.eventType = eventType;
        this.date = date;
        this.photoList = new ArrayList<>();
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public List<String> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<String> photoList) {
        this.photoList = photoList != null ? photoList : new ArrayList<>();
    }
}