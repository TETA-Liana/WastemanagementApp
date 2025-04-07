package com.management.wastemanagement.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "collection_schedules")
public class CollectionSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "collector_id")
    private WasteCollector collector;

    private String location;
    private LocalDateTime collectionTime;

    // Default constructor (required by JPA)
    public CollectionSchedule() {
    }

    // Parameterized constructor (optional, for convenience)
    public CollectionSchedule(WasteCollector collector, String location, LocalDateTime collectionTime) {
        this.collector = collector;
        this.location = location;
        this.collectionTime = collectionTime;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WasteCollector getCollector() {
        return collector;
    }

    public void setCollector(WasteCollector collector) {
        this.collector = collector;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(LocalDateTime collectionTime) {
        this.collectionTime = collectionTime;
    }

    // Optional: toString method for debugging
    @Override
    public String toString() {
        return "CollectionSchedule{" +
                "id=" + id +
                ", collector=" + collector +
                ", location='" + location + '\'' +
                ", collectionTime=" + collectionTime +
                '}';
    }
}
