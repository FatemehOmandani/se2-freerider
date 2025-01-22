package de.freerider;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "VEHICLE_ID", nullable = false)
    private Vehicle vehicle;

    private LocalDateTime begin;
    private LocalDateTime end;
    private String pickup;
    private String dropoff;
    private String status; // Enum-Werte als String speichern

    protected Reservation() {}

    public Reservation(Customer customer, Vehicle vehicle, LocalDateTime begin, LocalDateTime end, String pickup, String dropoff, String status) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.begin = begin;
        this.end = end;
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.status = status;
    }

    // Getter und Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }
    
    public Long getCustomerId() {
        return customer != null ? customer.getId() : null;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getBegin() {
        return begin;
    }

    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDropoff() {
        return dropoff;
    }

    public void setDropoff(String dropoff) {
        this.dropoff = dropoff;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Reservation[id=%d, customer=%s, vehicle=%s, begin='%s', end='%s', pickup='%s', dropoff='%s', status='%s']",
                id, customer, vehicle, begin, end, pickup, dropoff, status);
    }
}
