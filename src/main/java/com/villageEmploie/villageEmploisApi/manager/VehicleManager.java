package com.villageEmploie.villageEmploisApi.manager;


import com.villageEmploie.villageEmploisApi.exception.ResourceNotFoundException;
import com.villageEmploie.villageEmploisApi.model.dto.Equipments;
import com.villageEmploie.villageEmploisApi.model.dto.Vehicles;
import com.villageEmploie.villageEmploisApi.model.tables.VehicleTable;
import com.villageEmploie.villageEmploisApi.repositories.VehicleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Represent vehicleManager information
 */
@Component
public class VehicleManager {

    /**
     * logger
     */
    private static Logger LOGGER = LogManager.getLogger(VehicleManager.class);

    /**
     * equipment manager
     */
    @Autowired
    private EquipmentManager equipmentManager;

    /**
     * vehicle repository
     */
    @Autowired
    private VehicleRepository vehicleRepository;

    /**
     * get all vehicles from bdd with crud repository from table vehicles
     *
     * @return all vehicles
     */
    public List<Vehicles> getAllVehicles() {
        //
        LOGGER.info("Entree dans la methode getAllVehicles");
        //Initialisation des variables
        List<Vehicles> vehiclesList = new ArrayList<>();
        // unicité des vehicles
        Map<Integer, Vehicles> vehiclesMap = new HashMap<>();
        // iteration des lignes de vehicles
        Iterator<VehicleTable> vehicleTableIterator = vehicleRepository.findAll().iterator().hasNext() ?
                vehicleRepository.findAll().iterator(): null;
        // parcourir la list des lignes de la table vehicles
        if(vehicleTableIterator != null) {
            while (vehicleTableIterator.hasNext()) {
                //vehicle table ligne par ligne
                var vehicleTable = vehicleTableIterator.next();
                // vehicle
                var vehicle = vehiclesMap.get(vehicleTable.getId());
                //
                if (vehicle == null) {
                    // instanciation de lobjet vehicle
                    Vehicles vehicles = new Vehicles();
                    vehicles.setId(vehicleTable.getId());
                    vehicles.setBrand(vehicleTable.getBrand());
                    vehicles.setModel(vehicleTable.getModel());
                    vehicles.setImageUrl(vehicleTable.getImageUrl());
                    vehicles.setVersion(vehicleTable.getVersion());
                    vehicles.setPriceWithoutVat(vehicleTable.getPriceWithoutVat());
                    vehicles.setPriceWithVat(vehicleTable.getPriceWithVat());
                    vehicles.setStartDate(vehicleTable.getStartDate());
                    vehicles.setEndDate(vehicleTable.getEndDate());
                    vehicles.setCreationDate(vehicleTable.getCreationDate());
                    vehicles.setUpdateDate(vehicleTable.getUpdateDate());
                    // ajout dans la map vehicle pour faciliter lunicité et le trie
                    vehiclesMap.put(vehicleTable.getId(), vehicles);
                    // recuperation des equipment pour chaque vehicle
                    vehicles.setEquipmentList(equipmentManager.getAllEquipmentsByVehicleId(vehicleTable.getId()));
                    // ajouter le vehiclea la liste des vehicles
                    vehiclesList.add(vehicles);
                }
            }
        } else {
            LOGGER.error("No vehicles found");
            throw new ResourceNotFoundException("No vehicles found");
        }
        //
        LOGGER.info("vehicles -{}", vehiclesList);
        // sortie de la methode
        return vehiclesList;
    }

    /**
     * get vehicle by id
     *
     * @param id vehicle id
     * @return vehicle
     */
    public Vehicles getVehicleById(Integer id) {
        //
        LOGGER.info("Entree dans la methode getVehicleById");
        // initialisation des variable
        var vehicles = new Vehicles();
        // iterate
        Optional<VehicleTable> vehiclesIterator = Optional.ofNullable(vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found from vehicle id "+id)));
        // parcourir la list recu
        vehicles.setId(vehiclesIterator.get().getId());
        vehicles.setBrand(vehiclesIterator.get().getBrand());
        vehicles.setModel(vehiclesIterator.get().getModel());
        vehicles.setImageUrl(vehiclesIterator.get().getImageUrl());
        vehicles.setVersion(vehiclesIterator.get().getVersion());
        vehicles.setPriceWithoutVat(vehiclesIterator.get().getPriceWithoutVat());
        vehicles.setPriceWithVat(vehiclesIterator.get().getPriceWithVat());
        vehicles.setStartDate(vehiclesIterator.get().getStartDate());
        vehicles.setEndDate(vehiclesIterator.get().getEndDate());
        vehicles.setCreationDate(vehiclesIterator.get().getCreationDate());
        vehicles.setUpdateDate(vehiclesIterator.get().getUpdateDate());
        // ajouter la list des equipment
        vehicles.setEquipmentList(equipmentManager.getAllEquipmentsByVehicleId(vehiclesIterator.get().getId()));
        //
        LOGGER.debug("vehicles -{}", vehicles);
        // sortie de la methode
        return vehicles;
    }

    /**
     * get equipments from vehicle id
     *
     * @param id vehicle id
     * @return list equipments
     */
    public List<Equipments> getVehicleEquipmentsById(Integer id) {
        // sortie de la methode
        LOGGER.info("Entree dans la methode getVehicleEquipmentsById");
        //
        List<Equipments> equipmentsList = equipmentManager.getAllEquipmentsByVehicleId(id);
        // check if list off equipment is not empty
        if (equipmentsList.isEmpty()) {
            LOGGER.error("No equipments found from vehicle id -{}", id);
            throw new ResourceNotFoundException("No equipments found from vehicle id -"+id);
        }
        // Sortie de methode
        return equipmentsList;
    }

    /**
     * get equipment by vehicleId and equipmentId
     *
     * @param vehicleId   ID DU VEHICLE
     * @param equipmentId ID DE L EQUIPMENT
     * @return equipment
     */
    public Equipments getVehicleEquipmentByVehicleIdAndEquipmentId(Integer vehicleId, Integer equipmentId) {
       LOGGER.info("Entree dans la methode getVehicleEquipmentByVehicleIdAndEquipmentId");
        List<Equipments> equipmentsList = equipmentManager.getAllEquipmentsByVehicleId(vehicleId);
        if(equipmentsList.isEmpty()) {
            LOGGER.error("No equipment found for vehicle id -{} ", vehicleId);
            throw new ResourceNotFoundException("No equipment found for vehicle id " + vehicleId);
        }
        //
        Equipments equipments = null;
        //
        for (Equipments equipment : equipmentsList) {
            if (equipment.getId().equals(equipmentId)) {
                equipments = new Equipments();
                equipments = equipment;
            }
        }
        // check if equipment exist
        if (equipments == null) {
            LOGGER.error("No equipment found for equipment id -{} ", equipmentId);
            throw new ResourceNotFoundException("No equipment found for equipment id " + equipmentId);
        }
        // Sortie de methode
        LOGGER.info("equipments -{}", equipments);
        return equipments;
    }
}

