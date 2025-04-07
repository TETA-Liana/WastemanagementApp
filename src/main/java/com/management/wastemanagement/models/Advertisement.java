package com.management.wastemanagement.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "advertisements")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String advertiserName;
    private String adContent;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    // Default constructor (required by JPA)
    public Advertisement() {
    }

    // Parameterized constructor (optional, for convenience)
    public Advertisement(String advertiserName, String adContent, LocalDateTime startDate, LocalDateTime endDate) {
        this.advertiserName = advertiserName;
        this.adContent = adContent;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public String getAdContent() {
        return adContent;
    }

    public void setAdContent(String adContent) {
        this.adContent = adContent;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    // Optional: toString method for debugging
    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ", advertiserName='" + advertiserName + '\'' +
                ", adContent='" + adContent + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
