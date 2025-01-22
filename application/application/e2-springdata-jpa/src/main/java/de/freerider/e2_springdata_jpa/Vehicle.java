package de.freerider;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String make;
    private String model;
    private Integer seats;
    private String category; // Enum-Werte als String speichern
    private String power;    // Enum-Werte als String speichern
    private String status;   // Enum-Werte als String speichern

    protected Vehicle() {}

    public Vehicle(String make, String model, Integer seats, String category, String power, String status) {
        this.make = make;
        this.model = model;
        this.seats = seats;
        this.category = category;
        this.power = power;
        this.status = status;
    }

    // Getter und Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Vehicle[id=%d, make='%s', model='%s', seats=%d, category='%s', power='%s', status='%s']",
                id, make, model, seats, category, power, status);
    }
}
