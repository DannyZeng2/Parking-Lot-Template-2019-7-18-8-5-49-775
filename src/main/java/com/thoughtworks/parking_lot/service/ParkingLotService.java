package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.respository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotService {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public List<ParkingLot> findAll() {
        return parkingLotRepository.findAll();
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLotRepository.save(parkingLot);
    }
}
