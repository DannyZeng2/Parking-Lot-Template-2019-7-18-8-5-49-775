package com.thoughtworks.parking_lot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "PARKING_LOT_ORDER")
public class ParkingOrder {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    private String id;
    @Column(name = "PARKING_LOT_NAME")
    private String parkingLotName;
    @Column(name = "CAR_NUM")
    private String carNum;
    @Column(name = "START_NAME")
    private Date startTime;
    @Column(name = "END_NAME")
    private Date endTime;
    @Column(name = "STATE")
    private int state;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PARKING_LOT_ID")
    private ParkingLot parkingLot;

    public ParkingOrder(String parkingLotName, String carNum, Date startTime, Date endTime, int state, ParkingLot parkingLot) {
        this.parkingLotName = parkingLotName;
        this.carNum = carNum;
        this.startTime = startTime;
        this.endTime = endTime;
        this.state = state;
        this.parkingLot = parkingLot;
    }

    public ParkingOrder(String parkingLotName, String carNum, Date startTime, Date endTime, int state) {
        this.parkingLotName = parkingLotName;
        this.carNum = carNum;
        this.startTime = startTime;
        this.endTime = endTime;
        this.state = state;
    }

    public ParkingOrder() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @JsonIgnore
    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
