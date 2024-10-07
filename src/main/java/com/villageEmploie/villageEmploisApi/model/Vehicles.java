package com.villageEmploie.villageEmploisApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent vehicles class information
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicles {

    /**
     * vehicle id
     */
    private Integer id;

    /**
     * vehicle brand
     */
    private String brand;

    /**
     * vehicle model
     */
    private String model;

    /**
     * version
     */
    private String version;

    /**
     * image url
     */
    private String imageUrl;

    /**
     * price with Vat
     */
    private Double priceWithVat;

    /**
     * price without Vat
     */
    private Double priceWithoutVat;

    /**
     * vehicle equipments
     */
    private List<Equipments> equipmentList = new ArrayList<>();
}
