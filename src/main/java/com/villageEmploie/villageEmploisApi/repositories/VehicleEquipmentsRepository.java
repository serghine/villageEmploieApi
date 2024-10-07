package com.villageEmploie.villageEmploisApi.repositories;

import com.villageEmploie.villageEmploisApi.model.views.VehicleEquipmentsView;
import org.springframework.data.repository.CrudRepository;

/**
 * vehicleEquipments views Information
 */
public interface VehicleEquipmentsRepository extends CrudRepository<VehicleEquipmentsView, Integer> {
}
