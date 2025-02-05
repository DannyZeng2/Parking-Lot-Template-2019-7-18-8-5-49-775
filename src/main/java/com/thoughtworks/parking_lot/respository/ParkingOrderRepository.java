package com.thoughtworks.parking_lot.respository;

import com.thoughtworks.parking_lot.entity.ParkingOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingOrderRepository extends JpaRepository<ParkingOrder, String> {
    ParkingOrder findByCarNum(String carNum);
}
