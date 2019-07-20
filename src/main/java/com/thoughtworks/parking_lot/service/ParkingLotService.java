package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.entity.ParkingOrder;
import com.thoughtworks.parking_lot.respository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void deleteById(String id) {
        parkingLotRepository.deleteById(id);
    }

    public Page<ParkingLot> findByPage(int page, int pageSize) {
       return parkingLotRepository.findAll(PageRequest.of(page,pageSize));
    }


    public ParkingLot findById(String id) {
        return parkingLotRepository.findById(id).get();

    }

    public ParkingLot updateCapacityById(String id,int capacity) {


        ParkingLot parkingLot = parkingLotRepository.findById(id).get();
        parkingLot.setCapacity(capacity);
        return parkingLot;

    }

    public void createOrdder(ParkingOrder parkingOrder) {

    }

    public void addCar(String id, ParkingOrder parkingOrder) {
        ParkingLot parkingLot = parkingLotRepository.findById(id).get();
        if(parkingLot.getParkingOrders().size()>=parkingLot.getCapacity()){
            System.out.println("停车场已经满");
        }else {
            parkingLot.getParkingOrders().add(parkingOrder);
            parkingLotRepository.saveAndFlush(parkingLot);
        }


    }
}
