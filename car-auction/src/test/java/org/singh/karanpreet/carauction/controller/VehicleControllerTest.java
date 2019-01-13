package org.singh.karanpreet.carauction.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.Matchers.hasSize;

import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.singh.karanpreet.carauction.model.AppUser;
import org.singh.karanpreet.carauction.model.Vehicle;
import org.singh.karanpreet.carauction.model.dto.BidClient;
import org.singh.karanpreet.carauction.service.AppUserService;
import org.singh.karanpreet.carauction.service.BidService;
import org.singh.karanpreet.carauction.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private VehicleService vehicleService;

  @MockBean
  private AppUserService appUserService;
  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private BidService bidService;

  Vehicle mockVehicle = new Vehicle(1, "Truck", "My truck");

  @Test
  public void testGetVehicles() throws Exception {
    List<Vehicle> mockVehicleList = new ArrayList<>();
    mockVehicleList.add(mockVehicle);
    Mockito.when(vehicleService.getVehicles()).thenReturn(mockVehicleList);
    mockMvc.perform(MockMvcRequestBuilders.get("/vehicles/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].type").value("Truck"))
        .andExpect(jsonPath("$[0].name").value("My truck"));
  }

  @Test
  @Transactional
  public void testAddVehicle() throws Exception {
    List<Vehicle> mockVehicleList = new ArrayList<>();
    Vehicle mockVehicle2 = new Vehicle(2, "car", "best car");
    mockVehicleList.add(mockVehicle);
    mockVehicleList.add(mockVehicle2);
    mockMvc.perform(MockMvcRequestBuilders.post("/vehicles/").contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(mockVehicle2))).andExpect(status().isOk());
    Mockito.when(vehicleService.getVehicles()).thenReturn(mockVehicleList);
    mockMvc.perform(MockMvcRequestBuilders.get("/vehicles/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)));
  }

  @Test
  public void testGetVehicleById() throws Exception {
    int vehicleId = mockVehicle.getId();
    Mockito.when(vehicleService.findById(vehicleId)).thenReturn(mockVehicle);
    mockMvc.perform(MockMvcRequestBuilders.get("/vehicles/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.type").value("Truck")).andExpect(jsonPath("$.name").value("My truck"));
  }

  @Test
  public void testPostBid() throws Exception {
    double bidAmount = 1000D;
    BidClient mockBidClient = new BidClient(bidAmount, 1);
    int vehicleId = 1;
    AppUser mockUser = new AppUser(1, "username1");
    Mockito.when(appUserService.findById(1)).thenReturn(mockUser);
    Mockito.when(vehicleService.findById(vehicleId)).thenReturn(mockVehicle);
    mockMvc.perform(MockMvcRequestBuilders.post("/vehicles/1/bid").contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(mockBidClient))).andExpect(status().isOk());
  }

  @Test
  public void testGetWinningBid() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/vehicles/1/winningbid").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
  }

}
