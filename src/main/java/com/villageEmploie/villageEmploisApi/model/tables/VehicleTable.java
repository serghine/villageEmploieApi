package com.villageEmploie.villageEmploisApi.model.tables;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.util.Date;

/**
 * Represent vehicle table information
 */
@Data
@Entity
@Immutable
@Table(name = "VEHICLES")
public class VehicleTable {

    /**
     * primary key id off vehicle
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
     * start date
     */
    @Column(name = "START_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;

    /**
     * creation date
     */
    @Column(name = "CREATION_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date creationDate;

    /**
     * end date
     */
    @Column(name = "END_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;

    /**
     * update date
     */
    @Column(name = "UPDATE_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date updateDate;
}
