package com.villageEmploie.villageEmploisApi.repositories;


import com.villageEmploie.villageEmploisApi.model.tables.EquipmentTable;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;

/**
 * Represent Equipment Repository class information
 */
public interface EquipmentRepository extends CrudRepository<EquipmentTable, Integer> {
// implement methods crud repository for equipments
    Iterable<EquipmentTable> findByVehicleId(Integer vehicleId);
}
