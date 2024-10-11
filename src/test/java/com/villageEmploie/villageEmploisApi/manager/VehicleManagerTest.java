package com.villageEmploie.villageEmploisApi.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.villageEmploie.villageEmploisApi.exception.ResourceNotFoundException;
import com.villageEmploie.villageEmploisApi.model.dto.Equipments;
import com.villageEmploie.villageEmploisApi.model.tables.VehicleTable;
import com.villageEmploie.villageEmploisApi.repositories.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * Vehicle manger test class information
 */
@SpringBootTest
class VehicleManagerTest {

    /**
     * vehicle manager class to test
     */
    @InjectMocks
    private VehicleManager vehicleManager;

    /**
     * equipmentManager
     */
    @Mock
    private EquipmentManager equipmentManager;

    /**
     * vehicle repository
     */
    @Mock
    private VehicleRepository vehicleRepository;

    /**
     * Initialization des variables
     */
    @BeforeEach
    void setUp() throws JsonProcessingException {
        // objectMapper to convert string to json
        ObjectMapper objectMapper = new ObjectMapper();
        //
        // Exemple 1
        VehicleTable vehicle1 = new VehicleTable();
        vehicle1.setId(1);
        vehicle1.setBrand("Tesla");
        vehicle1.setModel("Model S");
        vehicle1.setVersion("Long Range");
        vehicle1.setImageUrl("https://example.com/tesla_model_s.jpg");
        vehicle1.setPriceWithVat(79999.99);
        vehicle1.setPriceWithoutVat(66666.66);
        vehicle1.setStartDate(new Date(121, 5, 1)); // 2021-06-01
        vehicle1.setCreationDate(new Date(121, 4, 1)); // 2021-05-01
        vehicle1.setEndDate(new Date(126, 4, 1)); // 2026-05-01
        vehicle1.setUpdateDate(new Date(123, 1, 20)); // 2023-02-20

        // Exemple 2
        VehicleTable vehicle2 = new VehicleTable();
        vehicle2.setId(2);
        vehicle2.setBrand("BMW");
        vehicle2.setModel("X5");
        vehicle2.setVersion("xDrive40i");
        vehicle2.setImageUrl("https://example.com/bmw_x5.jpg");
        vehicle2.setPriceWithVat(69999.99);
        vehicle2.setPriceWithoutVat(58333.33);
        vehicle2.setStartDate(new Date(120, 9, 15)); // 2020-10-15
        vehicle2.setCreationDate(new Date(120, 8, 15)); // 2020-09-15
        vehicle2.setEndDate(new Date(125, 8, 15)); // 2025-09-15
        vehicle2.setUpdateDate(new Date(123, 3, 10)); // 2023-04-10

        // Liste de véhicules
        List<VehicleTable> vehicleList = Arrays.asList(vehicle1, vehicle2);
        //
        when(vehicleRepository.findAll()).thenReturn(vehicleList);
        //
        String equipmentsString = "[\n" +
                "        {\n" +
                "            \"id\": 9,\n" +
                "            \"code\": \"EQP-508-01\",\n" +
                "            \"label\": \"Détection dangle mort\",\n" +
                "            \"description\": \"Système de détection dangle mort\",\n" +
                "            \"priceWithVat\": 800.0,\n" +
                "            \"priceWithoutVat\": 700.0,\n" +
                "            \"startDate\": \"2022-02-28\",\n" +
                "            \"creationDate\": \"2022-02-28\",\n" +
                "            \"endDate\": \"2022-04-30\",\n" +
                "            \"updateDate\": \"2022-02-28\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 10,\n" +
                "            \"code\": \"EQP-508-02\",\n" +
                "            \"label\": \"Éclairage LED\",\n" +
                "            \"description\": \"Phares avant et arrière LED\",\n" +
                "            \"priceWithVat\": 1200.0,\n" +
                "            \"priceWithoutVat\": 1000.0,\n" +
                "            \"startDate\": \"2022-02-28\",\n" +
                "            \"creationDate\": \"2022-02-28\",\n" +
                "            \"endDate\": \"2022-04-30\",\n" +
                "            \"updateDate\": \"2022-02-28\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 11,\n" +
                "            \"code\": \"EQP-508-03\",\n" +
                "            \"label\": \"Sièges en cuir\",\n" +
                "            \"description\": \"Intérieur en cuir haut de gamme\",\n" +
                "            \"priceWithVat\": 3000.0,\n" +
                "            \"priceWithoutVat\": 2500.0,\n" +
                "            \"startDate\": \"2022-02-28\",\n" +
                "            \"creationDate\": \"2022-02-28\",\n" +
                "            \"endDate\": \"2022-04-30\",\n" +
                "            \"updateDate\": \"2022-02-28\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 12,\n" +
                "            \"code\": \"EQP-508-04\",\n" +
                "            \"label\": \"Suspension adaptative\",\n" +
                "            \"description\": \"Suspension réglable électroniquement\",\n" +
                "            \"priceWithVat\": 2500.0,\n" +
                "            \"priceWithoutVat\": 2200.0,\n" +
                "            \"startDate\": \"2022-02-28\",\n" +
                "            \"creationDate\": \"2022-02-28\",\n" +
                "            \"endDate\": \"2022-04-30\",\n" +
                "            \"updateDate\": \"2022-02-28\"\n" +
                "        }\n" +
                "    ]";
        //
        List<Equipments> equipmentsList = objectMapper.readValue(equipmentsString, new TypeReference<List<Equipments>>() {
        });
        //
        when(equipmentManager.getAllEquipmentsByVehicleId(anyInt())).thenReturn(equipmentsList);
    }

    /**
     * test getAllVehicles
     */
    @Test
    @DisplayName("testGetAllVehicles")
    void testGetAllVehicles() {
        // debut du test
        var vehicles = vehicleManager.getAllVehicles();
        assertNotNull(vehicles);
        // test ResourceNotFoundException
        when(vehicleRepository.findAll()).thenReturn(new ArrayList<>());
        //
        ResourceNotFoundException thrown = assertThrows(ResourceNotFoundException.class,
                () -> vehicleManager.getAllVehicles(), "No vehicles found");
    }

    /**
     * test getVehicleById
     */
    @Test
    @DisplayName("testGetVehicleById")
    void testGetVehicleById() {
       //todo: faire le test unitaire pour cette methode
    }

    /**
     * test getVehicleEquipmentsById
     */
    @Test
    @DisplayName("testGetVehicleEquipmentsById")
    void testGetVehicleEquipmentsById() {
        // debut du test
        var equipments = vehicleManager.getVehicleEquipmentsById(1);
        assertNotNull(equipments);
        // test check resource not found exception
        when(equipmentManager.getAllEquipmentsByVehicleId(anyInt())).thenReturn(new ArrayList<>());
        ResourceNotFoundException thrown = assertThrows(ResourceNotFoundException.class, () -> vehicleManager.getVehicleEquipmentsById(1));
    }

    /**
     * test getVehicleEquipmentByVehicleIdAndEquipmentId
     */
    @Test
    @DisplayName("testGetVehicleEquipmentByVehicleIdAndEquipmentId")
    void testGetVehicleEquipmentByVehicleIdAndEquipmentId() {
      //todo : faire le test unitaire pour cette methode
    }
}