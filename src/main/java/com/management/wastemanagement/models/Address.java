package com.management.wastemanagement.models;
import jakarta.persistence.*;
@Embeddable
public class Address {
    private String district;
    private String sector;
    private String village;
    private String cell;

    public Address(String district, String sector, String village, String cell) {
        this.district = district;
        this.sector = sector;
        this.village = village;
        this.cell = cell;
    }

    // Getters
    public String getDistrict() {
        return district;
    }

    public String getSector() {
        return sector;
    }

    public String getVillage() {
        return village;
    }

    public String getCell() {
        return cell;
    }

    // Setters
    public void setDistrict(String district) {
        this.district = district;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    @Override
    public String toString() {
        return "Address{" +
                "district='" + district + '\'' +
                ", sector='" + sector + '\'' +
                ", village='" + village + '\'' +
                ", cell='" + cell + '\'' +
                '}';
    }
}
