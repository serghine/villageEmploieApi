package com.villageEmploie.villageEmploisApi.resources;

import com.villageEmploie.villageEmploisApi.manager.EquipmentManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipments")
public class EquipmentResource {

    /**
     * logger
     */
    private static Logger LOGGER = LogManager.getLogger(EquipmentResource.class);


}
