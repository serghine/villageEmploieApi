package com.villageEmploie.villageEmploisApi.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
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
