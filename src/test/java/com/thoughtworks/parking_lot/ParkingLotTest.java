package com.thoughtworks.parking_lot;


import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.respository.ParkingLotRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingLotTest {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Test
    public void should_return_case_when_find_by_id() {
        //given
//        CriminalCase criminalCase_1 = new CriminalCase("aaa",new Date(1000));
//        CriminalCase criminalCase_2 = new CriminalCase("bbb",new Date(2000));
//
//        criminalCaseRepository.save(criminalCase_1);
//        criminalCaseRepository.save(criminalCase_2);
//
//        //when
//        CriminalCase resultCase  = criminalCaseRepository.findById(criminalCase_1.getId()).get();
//
//        //then
//        Assertions.assertEquals(criminalCase_1, resultCase);
        ParkingLot parkingLot1 = new ParkingLot("aaa",20,"aaa");
        ParkingLot parkingLot2 = new ParkingLot("bbb",30,"bbb");
        parkingLotRepository.save(parkingLot1);
        parkingLotRepository.save(parkingLot2);

        Assertions.assertEquals(2, parkingLotRepository.findAll().size());

    }
}
