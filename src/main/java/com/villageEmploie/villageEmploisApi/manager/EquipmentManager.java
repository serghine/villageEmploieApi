package com.villageEmploie.villageEmploisApi.manager;

import com.villageEmploie.villageEmploisApi.model.dto.Equipments;
import com.villageEmploie.villageEmploisApi.model.tables.EquipmentTable;
import com.villageEmploie.villageEmploisApi.repositories.EquipmentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Represent equipment manager information
 */
@Component
public class EquipmentManager {

    /**
     * logger
     */
    private static Logger LOGGER = LogManager.getLogger(EquipmentManager.class);

    /**
     * equipment repository
     */
    @Autowired
    private EquipmentRepository equipmentRepository;

    /**
     * get all equipments by vehicleId
     * @param vehicleId id du vehicle
     * @return list off equipments
     */
    public List<Equipments> getAllEquipmentsByVehicleId(int vehicleId) {
        // initialization des variable
        List<Equipments> equipmentsList = new ArrayList<>();
        // garantir l'unicité
        Map<Integer, Equipments> equipmentsMap = new HashMap<>();
        //
        Iterator<EquipmentTable> equipmentTableIterator = equipmentRepository.findByVehicleId(vehicleId).iterator().hasNext()?
                equipmentRepository.findByVehicleId(vehicleId).iterator() : null;
        // iterate
        if (equipmentTableIterator != null) {
            while (equipmentTableIterator.hasNext()) {
                // parcourir ligne par ligne
                var equipmentTable = equipmentTableIterator.next();
                //
                var equipment = equipmentsMap.get(equipmentTable.getId());
                //
                if (equipment == null) {
                    // instantiation de lobjet equipment
                    Equipments equipments = new Equipments();
                    equipments.setId(equipmentTable.getId());
                    equipments.setCode(equipmentTable.getCode());
                    equipments.setDescription(equipmentTable.getDescription());
                    equipments.setLabel(equipmentTable.getLabel());
                    equipments.setPriceWithoutVat(equipmentTable.getPriceWithoutVat());
                    equipments.setPriceWithVat(equipmentTable.getPriceWithVat());
                    equipments.setCreationDate(equipmentTable.getCreationDate());
                    equipments.setEndDate(equipmentTable.getEndDate());
                    equipments.setUpdateDate(equipmentTable.getUpdateDate());
                    equipments.setStartDate(equipmentTable.getStartDate());
                    // ajouter a la list des equipment
                    equipmentsList.add(equipments);
                    //unicité
                    equipmentsMap.put(equipmentTable.getId(), equipments);
                }
            }
        } else {
            LOGGER.warn("No equipment table found for vehicle id " + vehicleId);
            return new ArrayList<>();
        }
        // sortie de la methode
        return equipmentsList;
    }
}
