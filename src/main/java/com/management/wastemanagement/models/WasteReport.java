package com.management.wastemanagement.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "waste_reports")
public class WasteReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String wasteType; // e.g., "Plastic", "Organic", "E-Waste"
    private double quantity; // kg or liters
    private String location;
    private LocalDateTime reportedAt;

    // Default constructor (required by JPA)
    public WasteReport() {
    }

    // Parameterized constructor (optional, for convenience)
    public WasteReport(User user, String wasteType, double quantity, String location, LocalDateTime reportedAt) {
        this.user = user;
        this.wasteType = wasteType;
        this.quantity = quantity;
        this.location = location;
        this.reportedAt = reportedAt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getReportedAt() {
        return reportedAt;
    }

    public void setReportedAt(LocalDateTime reportedAt) {
        this.reportedAt = reportedAt;
    }

    // Optional: toString method for debugging
    @Override
    public String toString() {
        return "WasteReport{" +
                "id=" + id +
                ", user=" + user +
                ", wasteType='" + wasteType + '\'' +
                ", quantity=" + quantity +
                ", location='" + location + '\'' +
                ", reportedAt=" + reportedAt +
                '}';
    }
}
