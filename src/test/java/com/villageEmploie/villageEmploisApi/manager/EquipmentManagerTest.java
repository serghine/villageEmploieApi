package com.villageEmploie.villageEmploisApi.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.villageEmploie.villageEmploisApi.model.dto.Equipments;
import com.villageEmploie.villageEmploisApi.model.tables.EquipmentTable;
import com.villageEmploie.villageEmploisApi.repositories.EquipmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * Represent equipment management test class information
 */
@SpringBootTest
class EquipmentManagerTest {

    /**
     * equipment manager class to test
     */
    @InjectMocks
    private EquipmentManager equipmentManager;

    /**
     * equipment repository mock
     */
    @Mock
    private EquipmentRepository equipmentRepository;

    /**
     * object mapper to change String to json
     */
    private ObjectMapper objectMapper;

    /**
     * equipmentTableIterator
     */
    private Iterable<EquipmentTable> equipmentTableIterator = null;

    /**
     * initialisation des variables
     */
    @BeforeEach
    void init() {
        // object mapper
        objectMapper = new ObjectMapper();
        // mock list off equipmentTable
        // Exemple 1
        EquipmentTable equipment1 = new EquipmentTable();
        equipment1.setId(1);
        equipment1.setVehicleId(101);
        equipment1.setCode("EQUIP_001");
        equipment1.setLabel("GPS");
        equipment1.setDescription("Système de navigation GPS intégré");
        equipment1.setPriceWithVat(350.50);
        equipment1.setPriceWithoutVat(292.08);
        equipment1.setStartDate(new Date(122, 4, 1)); // 2022-05-01
        equipment1.setCreationDate(new Date(122, 3, 1)); // 2022-04-01
        equipment1.setEndDate(new Date(125, 3, 1)); // 2025-04-01
        equipment1.setUpdateDate(new Date(123, 1, 15)); // 2023-02-15

        // Exemple 2
        EquipmentTable equipment2 = new EquipmentTable();
        equipment2.setId(2);
        equipment2.setVehicleId(102);
        equipment2.setCode("EQUIP_002");
        equipment2.setLabel("Climatisation");
        equipment2.setDescription("Climatisation automatique pour véhicule");
        equipment2.setPriceWithVat(500.00);
        equipment2.setPriceWithoutVat(416.67);
        equipment2.setStartDate(new Date(121, 10, 15)); // 2021-11-15
        equipment2.setCreationDate(new Date(121, 9, 1)); // 2021-10-01
        equipment2.setEndDate(new Date(124, 9, 1)); // 2024-10-01
        equipment2.setUpdateDate(new Date(123, 2, 10)); // 2023-03-10

        // Liste d'équipements
        List<EquipmentTable> equipmentList = Arrays.asList(equipment1, equipment2);
        // convert list to iterator
        equipmentTableIterator = equipmentList;
        //
        when(equipmentRepository.findByVehicleId(anyInt())).thenReturn(equipmentTableIterator);
    }

    /**
     * test GetAllEquipmentsByVehicleId
     */
    @Test
    @DisplayName("testGetAllEquipmentsByVehicleId")
    void testGetAllEquipmentsByVehicleId() {
        // debut du test
        List<Equipments> equipmentsList = equipmentManager.getAllEquipmentsByVehicleId(1);
        //
        assertNotNull(equipmentsList);
        assertEquals(2, equipmentsList.size());
    }

    /**
     * test getAllEquipmentsByVehicleIdException
     */
    @Test
    @DisplayName("testGetAllEquipmentsByVehicleIdException")
    void testGetAllEquipmentsByVehicleIdException() {
        // debut du test
        when(equipmentRepository.findByVehicleId(anyInt())).thenReturn(new ArrayList<>());
        // test
        List<Equipments> equipmentsList = equipmentManager.getAllEquipmentsByVehicleId(1);
        // valider le test
        assertEquals(0, equipmentsList.size());
    }
}