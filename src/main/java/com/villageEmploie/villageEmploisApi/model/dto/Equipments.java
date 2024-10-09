package com.villageEmploie.villageEmploisApi.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

    /**
     * start date
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;

    /**
     * creation date
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date creationDate;

    /**
     * end date
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;

    /**
     * update date
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date updateDate;
}