package com.villageEmploie.villageEmploisApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represent equipments class information
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipments {

    /**
     * Equipment id
     */
    private Integer id;

    /**
     * Equipment code
     */
    private String code;

    /**
     * Equipment label
     */
    private String label;

    /**
     * Equipment description
     */
    private String description;

    /**
     * price with vat
     */
    private Double priceWithVat;

    /**
     * price without vat
     */
    private Double priceWithoutVat;
}