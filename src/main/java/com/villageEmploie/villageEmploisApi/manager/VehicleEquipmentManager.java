package com.villageEmploie.villageEmploisApi.manager;

import com.villageEmploie.villageEmploisApi.model.Equipments;
import com.villageEmploie.villageEmploisApi.model.Vehicles;
import com.villageEmploie.villageEmploisApi.model.views.VehicleEquipmentsView;
import com.villageEmploie.villageEmploisApi.repositories.VehicleEquipmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * vehicleEquipmentsManagement class information
 */
@Component
public class VehicleEquipmentManager {

    /**
     * vehicle equipment repository information
     */
    @Autowired
    private VehicleEquipmentsRepository vehicleEquipmentsRepository;

    /**
     * get all vehicles from vdeCrudMangement bdd
     *
     * @return list of vehicles with equipment
     */
    public List<Vehicles> getAllVehicles() {
        // Initialization des variables
        List<Vehicles> vehiclesList = new ArrayList<>();
        //
        Map<Integer, Vehicles> vehiclesMap = new HashMap<>();


        //
        Iterator<VehicleEquipmentsView> iterator = vehicleEquipmentsRepository.findAll().iterator();
        //
        while (iterator.hasNext()) {
            //
            List<Equipments> equipmentsList = new ArrayList<>();
            //
            var vehicleEquipmentsView = iterator.next();
            //
            var existingVehicle = vehiclesMap.get(vehicleEquipmentsView.getId());
            //
            Equipments equipments = new Equipments();
            equipments.setId(vehicleEquipmentsView.getEquipmentId());
            equipments.setCode(vehicleEquipmentsView.getCode());
            equipments.setLabel(vehicleEquipmentsView.getLabel());
            equipments.setDescription(vehicleEquipmentsView.getDescription());
            equipments.setPriceWithVat(vehicleEquipmentsView.getEquipmentPriceWithVat());
            equipments.setPriceWithoutVat(vehicleEquipmentsView.getEquipmentPriceWithoutVat());
            //
            if (existingVehicle != null) {
                for (Vehicles vehicles : vehiclesList) {
                    if (vehicles.getId().equals(existingVehicle.getId())) {
                        vehicles.getEquipmentList().add(equipments);
                    }
                }
            } else {
                var vehicles = new Vehicles();
                vehicles.setId(vehicleEquipmentsView.getId());
                vehicles.setBrand(vehicleEquipmentsView.getBrand());
                vehicles.setModel(vehicleEquipmentsView.getModel());
                vehicles.setVersion(vehicleEquipmentsView.getVersion());
                vehicles.setImageUrl(vehicleEquipmentsView.getImageUrl());
                vehicles.setPriceWithVat(vehicleEquipmentsView.getPriceWithVat());
                vehicles.setPriceWithoutVat(vehicleEquipmentsView.getPriceWithoutVat());
                //
                vehicles.getEquipmentList().add(equipments);
                //
                vehiclesList.add(vehicles);
                vehiclesMap.put(vehicles.getId(), vehicles);
            }

        }

        // sortie de methode
        return vehiclesList;
    }
}
