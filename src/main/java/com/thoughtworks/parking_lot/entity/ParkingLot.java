package com.thoughtworks.parking_lot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Entity
@Table(name = "PARKING_LOT")
public class ParkingLot {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    private String id;

    @Column(name = "NAME",unique = true)
    private String name;

    @Column(name = "CAPACITY")
    private int capacity;

    @Column(name = "LOCATION")
    private String location;

    @OneToMany(mappedBy="parkingLot",cascade = CascadeType.ALL)
    private List<ParkingOrder> parkingOrders;

    public ParkingLot() {

    }

    public ParkingLot(String name, int capacity, String location) {
        this.name = name;
        this.capacity = capacity;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public java.lang.String getLocation() {
        return location;
    }

    public void setLocation(java.lang.String location) {
        this.location = location;
    }

    //@JsonIgnore
    public List<ParkingOrder> getParkingOrders() {
        return parkingOrders;
    }

    public void setParkingOrders(List<ParkingOrder> parkingOrders) {
        this.parkingOrders = parkingOrders;
    }
}
