package com.villageEmploie.villageEmploisApi.repositories;

import com.villageEmploie.villageEmploisApi.model.tables.VehicleTable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Represent vehicle repository class information
 */
public interface VehicleRepository extends CrudRepository<VehicleTable, Integer> {
// implement methods off crud repository for vehicles
// find by id
    Optional<VehicleTable> findById(Integer id);

}
