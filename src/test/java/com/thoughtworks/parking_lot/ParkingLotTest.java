package com.thoughtworks.parking_lot;


import com.alibaba.fastjson.JSON;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.respository.ParkingLotRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingLotTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_new_parkinglot_list_case_when_add_parkinglot()throws Exception{
        ParkingLot parkingLot = new ParkingLot("bbb",12,"qqq");
        String jsonString = JSON.toJSONString(parkingLot);

        this.mockMvc.perform(post("/parkinglots").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString)).andExpect(status().isOk());
    }

    @Test
    public void return_new_parkinglot_list_when_delete_a_parkinglot() throws Exception {
        String uuid = "8w5e9d5t6c0518ab016c05344de50000";
        this.mockMvc.perform(delete("/parkinglots/"+uuid)).andExpect(status().isOk());

    }

    @Test
    public void return_parkinglot_list_when_find_by_page() throws Exception {

        this.mockMvc.perform(get("/parkinglots").param("page","2").param("pageSize","3")).andExpect(status().isOk());

    }

    @Test
    public void r2eturn_parkinglot_list_when_find_by_page() throws Exception {

        String uuid = "8aee9r5b6c0518ab016c05344de50000";
        String content = mockMvc.perform(get("/parkinglots/"+uuid)).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(content);
        assertEquals("{\"name\":\"DDD\",\"location\":\"VVV\",\"id\":\"8aee9r5b6c0518ab016c05344de50000\",\"capacity\":18}", jsonObject.toString());


    }


}
