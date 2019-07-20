package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.entity.ParkingOrder;
import com.thoughtworks.parking_lot.respository.ParkingLotRepository;
import com.thoughtworks.parking_lot.respository.ParkingOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ParkingOrderService {
    @Autowired
    private ParkingOrderRepository parkingOrderRepository;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public void createOrdder(ParkingOrder parkingOrder) {
        parkingOrderRepository.saveAndFlush(parkingOrder);
    }

    public ParkingOrder findByCarNum(String CarNum) {
        ParkingOrder parkingOrder = parkingOrderRepository.findByCarNum(CarNum);
        parkingOrder.setEndTime(new Date(System.currentTimeMillis()));
        parkingOrder.setState(0);
        return parkingOrder;
    }
}
