package com.villageEmploie.villageEmploisApi.resources;

import com.villageEmploie.villageEmploisApi.manager.VehicleManager;
import com.villageEmploie.villageEmploisApi.model.dto.Equipments;
import com.villageEmploie.villageEmploisApi.model.dto.Vehicles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent resource off vehicle information
 */
@RestController
@RequestMapping("/vehicles")
public class VehicleResource {

    /**
     * logger
     */
    private static Logger LOGGER = LogManager.getLogger(VehicleResource.class);

    /**
     * vehicleManager
     */
    @Autowired
    private VehicleManager vehicleManager;

    /**
     * get all vehicle
     *
     * @return list off vehicle
     */
    @GetMapping(name = "Vehicles resource")
    public ResponseEntity<List<Vehicles>> getAllVehicles() {
        //
        LOGGER.info("Entree dans la methode getAllVehicles");
        //
        List<Vehicles> vehicles = vehicleManager.getAllVehicles();
        //
        return ResponseEntity.ok(vehicles);
    }

    /**
     * get vehicle by ID
     *
     * @param id id vehicle
     * @return vehicle
     */
    @GetMapping(value = "/{id}", name = "vehicle by id")
    public ResponseEntity<Vehicles> getVehicleById(@PathVariable Integer id) {
        // Entree dans la resource
        LOGGER.info("Entree dans la methode getVehicleById");
        //
        Vehicles vehicle = vehicleManager.getVehicleById(id);
        // sortie de la methode
        return ResponseEntity.ok(vehicle);
    }

    /**
     * get list equipments from vehicle by
     *
     * @param id vehicle id
     * @return list off equipments
     */
    @GetMapping(value = "/{id}/equipments", name = "resource equipment")
    public ResponseEntity<List<Equipments>> getVehicleEquipmentById(@PathVariable Integer id) {
        // Entree dans la resource
        LOGGER.info("Entree dans la methode getVehicleEquipmentById");
        //
        List<Equipments> equipmentsList = vehicleManager.getVehicleEquipmentsById(id);
        // sortie de la methode
        return ResponseEntity.ok(equipmentsList);
    }

    /**
     * get equipment by vehicle id and equipment id
     *
     * @param id          vehicle id
     * @param equipmentId equipment id
     * @return equipment
     */
    @GetMapping(value = "/{id}/equipments/{equipmentId}", name = "Equipment by id")
    public ResponseEntity<Equipments> getVehicleEquipmentByVehicleIdAndEquipmentId(@PathVariable Integer id, @PathVariable Integer equipmentId) {
        // Entree dans la resource
        LOGGER.info("Entree dans la methode getVehicleEquipmentByVehicleIdAndEquipmentId");
        //
        var equipment = vehicleManager.getVehicleEquipmentByVehicleIdAndEquipmentId(id, equipmentId);
        // sortie de la methode
        return ResponseEntity.ok(equipment);
    }
}
