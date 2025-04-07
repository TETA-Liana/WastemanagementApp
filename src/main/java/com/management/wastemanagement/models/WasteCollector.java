package com.management.wastemanagement.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "waste_collectors")
public class WasteCollector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contactNumber;
    private String serviceArea;

    @OneToMany(mappedBy = "collector")
    private List<CollectionSchedule> collectionSchedules;

    // Default constructor (required by JPA)
    public WasteCollector() {
    }

    // Parameterized constructor (optional, for convenience)
    public WasteCollector(String name, String contactNumber, String serviceArea) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.serviceArea = serviceArea;
    }

    // Getters and Setters
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public List<CollectionSchedule> getCollectionSchedules() {
        return collectionSchedules;
    }

    public void setCollectionSchedules(List<CollectionSchedule> collectionSchedules) {
        this.collectionSchedules = collectionSchedules;
    }

    // Optional: toString method for debugging
    @Override
    public String toString() {
        return "WasteCollector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", serviceArea='" + serviceArea + '\'' +
                ", collectionSchedules=" + (collectionSchedules != null ? collectionSchedules.size() : 0) + " schedules" +
                '}';
    }
}
