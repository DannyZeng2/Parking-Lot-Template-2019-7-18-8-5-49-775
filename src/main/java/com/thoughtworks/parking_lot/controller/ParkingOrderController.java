package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.ParkingOrder;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import com.thoughtworks.parking_lot.service.ParkingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/parkingorders")
public class ParkingOrderController {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    private ParkingOrderService parkingOrderService;

    @PostMapping(produces = {"application/json"})
    public ResponseEntity parkCar(@RequestBody ParkingOrder parkingOrder) {
        parkingOrderService.createOrdder(parkingOrder);

        return ResponseEntity.ok().build();
    }

    @GetMapping(params = {"carNum"})
    public ResponseEntity getCarById(@RequestParam("carNum") String carNum) {

        return ResponseEntity.ok().body(parkingOrderService.findByCarNum(carNum));
    }
}
