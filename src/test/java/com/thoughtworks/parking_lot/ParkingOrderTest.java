package com.thoughtworks.parking_lot;


import com.alibaba.fastjson.JSON;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.entity.ParkingOrder;
import com.thoughtworks.parking_lot.respository.ParkingLotRepository;
import com.thoughtworks.parking_lot.respository.ParkingOrderRepository;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingOrderTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ParkingOrderRepository parkingOrderRepository;

    @Test
    public void should_new_parking_order_list_case_when_add_parkingorder()throws Exception{
        ParkingLot parkingLot = new ParkingLot("PL4",12,"RRR");

        //String parkingLotName, String carNum, Date startTime, Date endTime, int state, ParkingLot parkingLot
        ParkingOrder parking0rder = new ParkingOrder("PL4","A2343",new Date(20190304),new Date(20190304),1,parkingLot);
        String jsonString = JSON.toJSONString(parking0rder);

        this.mockMvc.perform(post("/parkingorders").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString)).andExpect(status().isOk());
    }

    @Test
    public void return_update_state_and_endTime_when_park_car_by_carNum() throws Exception {
        String uuid = "8a5e9d5b6c0518ab016c054344rewqq0";

        String content = mockMvc.perform(get("/parkingorders").param("carNum","A1223")).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(content);
        assertEquals(0, jsonObject.get("state"));
        assertEquals(new Date(System.currentTimeMillis()).toString(), jsonObject.get("endTime"));
    }


}
