package com.thoughtworks.parking_lot.respository;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ParkingLotRepository extends JpaRepository<ParkingLot, String> {


    ParkingLot findByName(String name);
}
