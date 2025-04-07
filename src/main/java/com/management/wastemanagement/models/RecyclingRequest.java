package com.management.wastemanagement.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "recycling_requests")
public class RecyclingRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String itemType; // e.g., "Paper", "Glass", "Metal"
    private int quantity;
    private String status; // e.g., "Pending", "Completed"
    private LocalDateTime requestDate;

    // Default constructor (required by JPA)
    public RecyclingRequest() {
    }

    // Parameterized constructor (optional, for convenience)
    public RecyclingRequest(User user, String itemType, int quantity, String status, LocalDateTime requestDate) {
        this.user = user;
        this.itemType = itemType;
        this.quantity = quantity;
        this.status = status;
        this.requestDate = requestDate;
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

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public String toString() {
        return "RecyclingRequest{" +
                "id=" + id +
                ", user=" + user +
                ", itemType='" + itemType + '\'' +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                ", requestDate=" + requestDate +
                '}';
    }
}