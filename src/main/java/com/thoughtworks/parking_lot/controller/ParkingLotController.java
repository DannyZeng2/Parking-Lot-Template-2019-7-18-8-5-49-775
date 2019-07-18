package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.respository.ParkingLotRepository;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/parkinglots")
public class ParkingLotController {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping(produces = {"application/json"})
    public ResponseEntity addParkingLot(@RequestBody ParkingLot parkingLot) {
        parkingLotService.addParkingLot(parkingLot);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteParkingLot(@PathVariable("id") String id) {

        parkingLotService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(params = {"page","pageSize"})
    public ResponseEntity findParkingLotByPage(@RequestParam("page") int page,@RequestParam("pageSize") int pageSize) {

        return ResponseEntity.ok().body(parkingLotService.findByPage(page,pageSize));
    }

    @GetMapping("/{id}")
    public ResponseEntity findParkingLotById(@PathVariable("id") String id) {

        return ResponseEntity.ok().body(parkingLotService.findById(id));
    }




}
