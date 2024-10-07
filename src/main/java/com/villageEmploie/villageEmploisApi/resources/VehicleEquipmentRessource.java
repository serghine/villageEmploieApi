package com.villageEmploie.villageEmploisApi.resources;

import com.villageEmploie.villageEmploisApi.manager.VehicleEquipmentManager;
import com.villageEmploie.villageEmploisApi.model.Vehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Vehicle equipment resource information
 */
@RestController
public class VehicleEquipmentRessource {

    /**
     * vehicle equipment manager
     */
    @Autowired
    private VehicleEquipmentManager vehicleEquipmentManager;

    /**
     * Get all vehicles
     * @return all vehicles
     */
    @GetMapping(value = "/vehicles", name = "Vehicles resource")
    public ResponseEntity<List<Vehicles>> getAllVehicles() {
        List<Vehicles> vehicles = vehicleEquipmentManager.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }
}
