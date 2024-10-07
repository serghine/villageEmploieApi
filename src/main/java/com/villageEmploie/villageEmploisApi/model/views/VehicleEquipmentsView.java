package com.villageEmploie.villageEmploisApi.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;

/**
 * Represent VehicleEquipmentsView class information
 */
@Data
@Entity
@Immutable
@Table(name = "VEHICLE_EQUIPMENTS")
public class VehicleEquipmentsView {

    /**
     * vehicle id
     */
    @Id
    @Column(name = "ID")
    private Integer id;

    /**
     * vehicle brand
     */
    @Column(name = "BRAND")
    private String brand;

    /**
     * vehicle model
     */
    @Column(name = "MODEL")
    private String model;

    /**
     * version
     */
    @Column(name = "VEHICLE_VERSION")
    private String version;

    /**
     * image url
     */
    @Column(name = "IMAGE_URL")
    private String imageUrl;

    /**
     * price with Vat
     */
    @Column(name = "PRICE_WITH_VAT")
    private Double priceWithVat;

    /**
     * price without Vat
     */
    @Column(name = "PRICE_WITHOUT_VAT")
    private Double priceWithoutVat;

    /**
     * Equipment id
     */
    @Column(name = "EQUIPMENT_ID")
    private Integer equipmentId;

    /**
     * Equipment code
     */
    @Column(name = "CODE")
    private String code;

    /**
     * Equipment label
     */
    @Column(name = "EQUIPMENT_LABEL")
    private String label;

    /**
     * Equipment description
     */
    @Column(name = "EQUIPMENT_DESCRIPTION")
    private String description;

    /**
     * price with vat
     */
    @Column(name = "EQ_PRICE_WITH_VAT")
    private Double equipmentPriceWithVat;

    /**
     * price without vat
     */
    @Column(name = "EQ_PRICE_WITHOUT_VAT")
    private Double equipmentPriceWithoutVat;
}
