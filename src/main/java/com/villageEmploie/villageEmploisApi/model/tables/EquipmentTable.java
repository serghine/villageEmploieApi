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
 * Represent equipment table information
 */
@Data
@Entity
@Immutable
@Table(name = "EQUIPMENTS")
public class EquipmentTable {

    /**
     * primary key of equipment
     */
    @Id
    @Column(name = "ID")
    private Integer id;

    /**
     * vehicle id
     */
    @Column(name = "VEHICLE_ID")
    private Integer vehicleId;

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
    @Column(name = "PRICE_WITH_VAT")
    private Double priceWithVat;

    /**
     * price without vat
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
