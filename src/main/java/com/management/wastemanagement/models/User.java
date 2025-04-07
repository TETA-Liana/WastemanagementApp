package com.management.wastemanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role;
    @Embedded
    private Address homeAddress;// e.g., "USER", "ADMIN", "WASTE_COLLECTOR"

    @OneToMany(mappedBy = "user")
    private List<WasteReport> wasteReports;

    @OneToMany(mappedBy = "user")
    private List<RecyclingRequest> recyclingRequests;
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subscription> subscriptions;
    // Default constructor (required by JPA)
    public User() {
    }

    // Parameterized constructor (optional, for convenience)
    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password; // In a real app, this should be hashed
        this.role = role;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<WasteReport> getWasteReports() {
        return wasteReports;
    }


    public void setWasteReports(List<WasteReport> wasteReports) {
        this.wasteReports = wasteReports;
    }

    public List<RecyclingRequest> getRecyclingRequests() {
        return recyclingRequests;
    }

    public void setRecyclingRequests(List<RecyclingRequest> recyclingRequests) {
        this.recyclingRequests = recyclingRequests;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", wasteReports=" + (wasteReports != null ? wasteReports.size() : 0) + " reports" +
                ", recyclingRequests=" + (recyclingRequests != null ? recyclingRequests.size() : 0) + " requests" +
                '}';
    }
}