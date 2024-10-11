package com.villageEmploie.villageEmploisApi.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.villageEmploie.villageEmploisApi.manager.VehicleManager;
import com.villageEmploie.villageEmploisApi.model.dto.Vehicles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class VehicleResourceTest {

    /**
     * resource to mock
     */
    @InjectMocks
    private VehicleResource vehicleResource;

    /**
     * vehicle manager
     */
    @Mock
    private VehicleManager vehicleManager;

    /**
     * Object mapper
     */
    private ObjectMapper objectMapper;

    private  List<Vehicles> vehiclesList = null;

    /**
     * Initialization des variable
     */
    @BeforeEach
    void init() throws JsonProcessingException {
        // object mapper
        objectMapper = new ObjectMapper();
        //
        String vehiclesString = "[\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"brand\": \"Peugeot\",\n" +
                "        \"model\": \"208\",\n" +
                "        \"version\": \"GT Line\",\n" +
                "        \"imageUrl\": \"https://cdn.pixabay.com/photo/2022/01/29/17/34/peugeot-308-6978160_1280.jpg\",\n" +
                "        \"priceWithVat\": 23000.0,\n" +
                "        \"priceWithoutVat\": 19000.0,\n" +
                "        \"equipmentList\": [\n" +
                "            {\n" +
                "                \"id\": 1,\n" +
                "                \"code\": \"EQP-208-01\",\n" +
                "                \"label\": \"Airbags\",\n" +
                "                \"description\": \"Airbags frontaux et latéraux\",\n" +
                "                \"priceWithVat\": 500.0,\n" +
                "                \"priceWithoutVat\": 400.0,\n" +
                "                \"startDate\": \"2021-12-31\",\n" +
                "                \"creationDate\": \"2021-12-31\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2021-12-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 2,\n" +
                "                \"code\": \"EQP-208-02\",\n" +
                "                \"label\": \"GPS\",\n" +
                "                \"description\": \"Système de navigation intégré\",\n" +
                "                \"priceWithVat\": 1000.0,\n" +
                "                \"priceWithoutVat\": 800.0,\n" +
                "                \"startDate\": \"2021-12-31\",\n" +
                "                \"creationDate\": \"2021-12-31\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2021-12-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 3,\n" +
                "                \"code\": \"EQP-208-03\",\n" +
                "                \"label\": \"Climatisation\",\n" +
                "                \"description\": \"Climatisation automatique\",\n" +
                "                \"priceWithVat\": 700.0,\n" +
                "                \"priceWithoutVat\": 600.0,\n" +
                "                \"startDate\": \"2021-12-31\",\n" +
                "                \"creationDate\": \"2021-12-31\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2021-12-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 4,\n" +
                "                \"code\": \"EQP-208-04\",\n" +
                "                \"label\": \"Système audio\",\n" +
                "                \"description\": \"Système audio haute fidélité\",\n" +
                "                \"priceWithVat\": 1200.0,\n" +
                "                \"priceWithoutVat\": 1000.0,\n" +
                "                \"startDate\": \"2021-12-31\",\n" +
                "                \"creationDate\": \"2021-12-31\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2021-12-31\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"startDate\": \"2021-12-31\",\n" +
                "        \"creationDate\": \"2021-12-31\",\n" +
                "        \"endDate\": \"2022-04-30\",\n" +
                "        \"updateDate\": \"2021-12-31\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"brand\": \"Peugeot\",\n" +
                "        \"model\": \"3008\",\n" +
                "        \"version\": \"Hybrid4\",\n" +
                "        \"imageUrl\": \"https://cdn.pixabay.com/photo/2015/07/22/13/42/peugeot-855554_1280.jpg\",\n" +
                "        \"priceWithVat\": 40000.0,\n" +
                "        \"priceWithoutVat\": 33000.0,\n" +
                "        \"equipmentList\": [\n" +
                "            {\n" +
                "                \"id\": 5,\n" +
                "                \"code\": \"EQP-3008-01\",\n" +
                "                \"label\": \"Caméra de recul\",\n" +
                "                \"description\": \"Caméra arrière pour faciliter le stationnement\",\n" +
                "                \"priceWithVat\": 800.0,\n" +
                "                \"priceWithoutVat\": 700.0,\n" +
                "                \"startDate\": \"2022-01-31\",\n" +
                "                \"creationDate\": \"2022-01-31\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2022-01-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 6,\n" +
                "                \"code\": \"EQP-3008-02\",\n" +
                "                \"label\": \"Sièges chauffants\",\n" +
                "                \"description\": \"Sièges avant chauffants\",\n" +
                "                \"priceWithVat\": 600.0,\n" +
                "                \"priceWithoutVat\": 500.0,\n" +
                "                \"startDate\": \"2022-01-31\",\n" +
                "                \"creationDate\": \"2022-01-31\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2022-01-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 7,\n" +
                "                \"code\": \"EQP-3008-03\",\n" +
                "                \"label\": \"Toit panoramique\",\n" +
                "                \"description\": \"Toit ouvrant panoramique\",\n" +
                "                \"priceWithVat\": 2000.0,\n" +
                "                \"priceWithoutVat\": 1800.0,\n" +
                "                \"startDate\": \"2022-01-31\",\n" +
                "                \"creationDate\": \"2022-01-31\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2022-01-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 8,\n" +
                "                \"code\": \"EQP-3008-04\",\n" +
                "                \"label\": \"Régulateur de vitesse\",\n" +
                "                \"description\": \"Régulateur de vitesse adaptatif\",\n" +
                "                \"priceWithVat\": 1000.0,\n" +
                "                \"priceWithoutVat\": 850.0,\n" +
                "                \"startDate\": \"2022-01-31\",\n" +
                "                \"creationDate\": \"2022-01-31\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2022-01-31\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"startDate\": \"2022-01-31\",\n" +
                "        \"creationDate\": \"2022-01-31\",\n" +
                "        \"endDate\": \"2022-04-30\",\n" +
                "        \"updateDate\": \"2022-01-31\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 4,\n" +
                "        \"brand\": \"Peugeot\",\n" +
                "        \"model\": \"508\",\n" +
                "        \"version\": \"GT\",\n" +
                "        \"imageUrl\": \"https://cdn.pixabay.com/photo/2014/10/23/12/46/peugeot-499684_1280.jpg\",\n" +
                "        \"priceWithVat\": 45000.0,\n" +
                "        \"priceWithoutVat\": 37500.0,\n" +
                "        \"equipmentList\": [\n" +
                "            {\n" +
                "                \"id\": 9,\n" +
                "                \"code\": \"EQP-508-01\",\n" +
                "                \"label\": \"Détection dangle mort\",\n" +
                "                \"description\": \"Système de détection dangle mort\",\n" +
                "                \"priceWithVat\": 800.0,\n" +
                "                \"priceWithoutVat\": 700.0,\n" +
                "                \"startDate\": \"2022-02-28\",\n" +
                "                \"creationDate\": \"2022-02-28\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2022-02-28\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 10,\n" +
                "                \"code\": \"EQP-508-02\",\n" +
                "                \"label\": \"Éclairage LED\",\n" +
                "                \"description\": \"Phares avant et arrière LED\",\n" +
                "                \"priceWithVat\": 1200.0,\n" +
                "                \"priceWithoutVat\": 1000.0,\n" +
                "                \"startDate\": \"2022-02-28\",\n" +
                "                \"creationDate\": \"2022-02-28\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2022-02-28\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 11,\n" +
                "                \"code\": \"EQP-508-03\",\n" +
                "                \"label\": \"Sièges en cuir\",\n" +
                "                \"description\": \"Intérieur en cuir haut de gamme\",\n" +
                "                \"priceWithVat\": 3000.0,\n" +
                "                \"priceWithoutVat\": 2500.0,\n" +
                "                \"startDate\": \"2022-02-28\",\n" +
                "                \"creationDate\": \"2022-02-28\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2022-02-28\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 12,\n" +
                "                \"code\": \"EQP-508-04\",\n" +
                "                \"label\": \"Suspension adaptative\",\n" +
                "                \"description\": \"Suspension réglable électroniquement\",\n" +
                "                \"priceWithVat\": 2500.0,\n" +
                "                \"priceWithoutVat\": 2200.0,\n" +
                "                \"startDate\": \"2022-02-28\",\n" +
                "                \"creationDate\": \"2022-02-28\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2022-02-28\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"startDate\": \"2022-02-28\",\n" +
                "        \"creationDate\": \"2022-02-28\",\n" +
                "        \"endDate\": \"2022-04-30\",\n" +
                "        \"updateDate\": \"2022-02-28\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 5,\n" +
                "        \"brand\": \"Peugeot\",\n" +
                "        \"model\": \"2008\",\n" +
                "        \"version\": \"Allure\",\n" +
                "        \"imageUrl\": \"https://cdn.pixabay.com/photo/2021/11/03/16/56/peugeot-403-6766338_1280.jpg\",\n" +
                "        \"priceWithVat\": 27000.0,\n" +
                "        \"priceWithoutVat\": 22000.0,\n" +
                "        \"equipmentList\": [\n" +
                "            {\n" +
                "                \"id\": 13,\n" +
                "                \"code\": \"EQP-2008-01\",\n" +
                "                \"label\": \"Jantes alliage\",\n" +
                "                \"description\": \"Jantes en alliage léger\",\n" +
                "                \"priceWithVat\": 1000.0,\n" +
                "                \"priceWithoutVat\": 850.0,\n" +
                "                \"startDate\": \"2022-03-31\",\n" +
                "                \"creationDate\": \"2022-03-31\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2022-03-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 14,\n" +
                "                \"code\": \"EQP-2008-02\",\n" +
                "                \"label\": \"Vitres teintées\",\n" +
                "                \"description\": \"Vitres arrière teintées\",\n" +
                "                \"priceWithVat\": 500.0,\n" +
                "                \"priceWithoutVat\": 400.0,\n" +
                "                \"startDate\": \"2022-03-31\",\n" +
                "                \"creationDate\": \"2022-03-31\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2022-03-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 15,\n" +
                "                \"code\": \"EQP-2008-03\",\n" +
                "                \"label\": \"Connectivité Bluetooth\",\n" +
                "                \"description\": \"Connectivité Bluetooth pour téléphone\",\n" +
                "                \"priceWithVat\": 300.0,\n" +
                "                \"priceWithoutVat\": 250.0,\n" +
                "                \"startDate\": \"2022-03-31\",\n" +
                "                \"creationDate\": \"2022-03-31\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2022-03-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 16,\n" +
                "                \"code\": \"EQP-2008-04\",\n" +
                "                \"label\": \"Rétroviseurs électriques\",\n" +
                "                \"description\": \"Rétroviseurs à réglage électrique\",\n" +
                "                \"priceWithVat\": 400.0,\n" +
                "                \"priceWithoutVat\": 350.0,\n" +
                "                \"startDate\": \"2022-03-31\",\n" +
                "                \"creationDate\": \"2022-03-31\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2022-03-31\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"startDate\": \"2022-03-31\",\n" +
                "        \"creationDate\": \"2022-03-31\",\n" +
                "        \"endDate\": \"2022-04-30\",\n" +
                "        \"updateDate\": \"2022-03-31\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 6,\n" +
                "        \"brand\": \"Citroën\",\n" +
                "        \"model\": \"C3\",\n" +
                "        \"version\": \"Shine\",\n" +
                "        \"imageUrl\": \"https://cdn.pixabay.com/photo/2022/01/26/14/25/car-6968952_1280.jpg\",\n" +
                "        \"priceWithVat\": 20000.0,\n" +
                "        \"priceWithoutVat\": 17000.0,\n" +
                "        \"equipmentList\": [\n" +
                "            {\n" +
                "                \"id\": 17,\n" +
                "                \"code\": \"EQP-C3-01\",\n" +
                "                \"label\": \"Volant en cuir\",\n" +
                "                \"description\": \"Volant en cuir multifonctions\",\n" +
                "                \"priceWithVat\": 500.0,\n" +
                "                \"priceWithoutVat\": 400.0,\n" +
                "                \"startDate\": \"2022-04-30\",\n" +
                "                \"creationDate\": \"2022-04-30\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2022-04-30\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 18,\n" +
                "                \"code\": \"EQP-C3-02\",\n" +
                "                \"label\": \"Capteurs de stationnement\",\n" +
                "                \"description\": \"Capteurs de stationnement avant et arrière\",\n" +
                "                \"priceWithVat\": 800.0,\n" +
                "                \"priceWithoutVat\": 700.0,\n" +
                "                \"startDate\": \"2022-04-30\",\n" +
                "                \"creationDate\": \"2022-04-30\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2022-04-30\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 19,\n" +
                "                \"code\": \"EQP-C3-03\",\n" +
                "                \"label\": \"Chargeur sans fil\",\n" +
                "                \"description\": \"Chargeur sans fil pour smartphone\",\n" +
                "                \"priceWithVat\": 300.0,\n" +
                "                \"priceWithoutVat\": 250.0,\n" +
                "                \"startDate\": \"2022-04-30\",\n" +
                "                \"creationDate\": \"2022-04-30\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2022-04-30\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 20,\n" +
                "                \"code\": \"EQP-C3-04\",\n" +
                "                \"label\": \"Rétroviseur intérieur électrochrome\",\n" +
                "                \"description\": \"Rétroviseur intérieur anti-éblouissement automatique\",\n" +
                "                \"priceWithVat\": 250.0,\n" +
                "                \"priceWithoutVat\": 200.0,\n" +
                "                \"startDate\": \"2022-04-30\",\n" +
                "                \"creationDate\": \"2022-04-30\",\n" +
                "                \"endDate\": \"2022-04-30\",\n" +
                "                \"updateDate\": \"2022-04-30\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"startDate\": \"2022-04-30\",\n" +
                "        \"creationDate\": \"2022-04-30\",\n" +
                "        \"endDate\": \"2022-04-30\",\n" +
                "        \"updateDate\": \"2022-04-30\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 7,\n" +
                "        \"brand\": \"Citroën\",\n" +
                "        \"model\": \"C4\",\n" +
                "        \"version\": \"Feel\",\n" +
                "        \"imageUrl\": \"https://cdn.pixabay.com/photo/2022/01/26/14/31/car-6968974_1280.jpg\",\n" +
                "        \"priceWithVat\": 22000.0,\n" +
                "        \"priceWithoutVat\": 18500.0,\n" +
                "        \"equipmentList\": [\n" +
                "            {\n" +
                "                \"id\": 21,\n" +
                "                \"code\": \"EQP-C4-01\",\n" +
                "                \"label\": \"Affichage tête haute\",\n" +
                "                \"description\": \"Affichage numérique sur le pare-brise\",\n" +
                "                \"priceWithVat\": 1000.0,\n" +
                "                \"priceWithoutVat\": 850.0,\n" +
                "                \"startDate\": \"2022-05-31\",\n" +
                "                \"creationDate\": \"2022-05-31\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-05-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 22,\n" +
                "                \"code\": \"EQP-C4-02\",\n" +
                "                \"label\": \"Système de freinage durgence\",\n" +
                "                \"description\": \"Freinage durgence automatique\",\n" +
                "                \"priceWithVat\": 1500.0,\n" +
                "                \"priceWithoutVat\": 1300.0,\n" +
                "                \"startDate\": \"2022-05-31\",\n" +
                "                \"creationDate\": \"2022-05-31\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-05-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 23,\n" +
                "                \"code\": \"EQP-C4-03\",\n" +
                "                \"label\": \"Phares automatiques\",\n" +
                "                \"description\": \"Activation automatique des phares\",\n" +
                "                \"priceWithVat\": 700.0,\n" +
                "                \"priceWithoutVat\": 600.0,\n" +
                "                \"startDate\": \"2022-05-31\",\n" +
                "                \"creationDate\": \"2022-05-31\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-05-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 24,\n" +
                "                \"code\": \"EQP-C4-04\",\n" +
                "                \"label\": \"Système dinfodivertissement\",\n" +
                "                \"description\": \"Écran tactile et connectivité smartphone\",\n" +
                "                \"priceWithVat\": 1200.0,\n" +
                "                \"priceWithoutVat\": 1000.0,\n" +
                "                \"startDate\": \"2022-05-31\",\n" +
                "                \"creationDate\": \"2022-05-31\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-05-31\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"startDate\": \"2022-05-31\",\n" +
                "        \"creationDate\": \"2022-05-31\",\n" +
                "        \"endDate\": \"2022-04-30\",\n" +
                "        \"updateDate\": \"2022-05-31\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 8,\n" +
                "        \"brand\": \"Citroën\",\n" +
                "        \"model\": \"C5 Aircross\",\n" +
                "        \"version\": \"Feel\",\n" +
                "        \"imageUrl\": \"https://cdn.pixabay.com/photo/2018/05/20/08/42/car-3415288_1280.jpg\",\n" +
                "        \"priceWithVat\": 35000.0,\n" +
                "        \"priceWithoutVat\": 29000.0,\n" +
                "        \"equipmentList\": [\n" +
                "            {\n" +
                "                \"id\": 25,\n" +
                "                \"code\": \"EQP-C5-01\",\n" +
                "                \"label\": \"Suspension Progressive\",\n" +
                "                \"description\": \"Suspension avec butées hydrauliques\",\n" +
                "                \"priceWithVat\": 2500.0,\n" +
                "                \"priceWithoutVat\": 2200.0,\n" +
                "                \"startDate\": \"2022-06-30\",\n" +
                "                \"creationDate\": \"2022-06-30\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-06-30\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 26,\n" +
                "                \"code\": \"EQP-C5-02\",\n" +
                "                \"label\": \"Caméra 360°\",\n" +
                "                \"description\": \"Vue caméra à 360 degrés\",\n" +
                "                \"priceWithVat\": 1800.0,\n" +
                "                \"priceWithoutVat\": 1500.0,\n" +
                "                \"startDate\": \"2022-06-30\",\n" +
                "                \"creationDate\": \"2022-06-30\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-06-30\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 27,\n" +
                "                \"code\": \"EQP-C5-03\",\n" +
                "                \"label\": \"Recharge sans fil\",\n" +
                "                \"description\": \"Station de recharge sans fil pour smartphones\",\n" +
                "                \"priceWithVat\": 400.0,\n" +
                "                \"priceWithoutVat\": 350.0,\n" +
                "                \"startDate\": \"2022-06-30\",\n" +
                "                \"creationDate\": \"2022-06-30\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-06-30\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 28,\n" +
                "                \"code\": \"EQP-C5-04\",\n" +
                "                \"label\": \"Sièges massants\",\n" +
                "                \"description\": \"Sièges avant massants\",\n" +
                "                \"priceWithVat\": 2000.0,\n" +
                "                \"priceWithoutVat\": 1700.0,\n" +
                "                \"startDate\": \"2022-06-30\",\n" +
                "                \"creationDate\": \"2022-06-30\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-06-30\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"startDate\": \"2022-06-30\",\n" +
                "        \"creationDate\": \"2022-06-30\",\n" +
                "        \"endDate\": \"2022-04-30\",\n" +
                "        \"updateDate\": \"2022-06-30\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 9,\n" +
                "        \"brand\": \"Citroën\",\n" +
                "        \"model\": \"Ami\",\n" +
                "        \"version\": \"Electric\",\n" +
                "        \"imageUrl\": \"https://cdn.pixabay.com/photo/2019/10/26/18/39/auto-4580073_1280.jpg\",\n" +
                "        \"priceWithVat\": 7000.0,\n" +
                "        \"priceWithoutVat\": 6000.0,\n" +
                "        \"equipmentList\": [\n" +
                "            {\n" +
                "                \"id\": 29,\n" +
                "                \"code\": \"EQP-Ami-01\",\n" +
                "                \"label\": \"Station de recharge mobile\",\n" +
                "                \"description\": \"Station de recharge pour véhicule électrique\",\n" +
                "                \"priceWithVat\": 500.0,\n" +
                "                \"priceWithoutVat\": 450.0,\n" +
                "                \"startDate\": \"2022-07-31\",\n" +
                "                \"creationDate\": \"2022-07-31\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-07-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 30,\n" +
                "                \"code\": \"EQP-Ami-02\",\n" +
                "                \"label\": \"Système audio Bluetooth\",\n" +
                "                \"description\": \"Haut-parleurs Bluetooth intégrés\",\n" +
                "                \"priceWithVat\": 250.0,\n" +
                "                \"priceWithoutVat\": 200.0,\n" +
                "                \"startDate\": \"2022-07-31\",\n" +
                "                \"creationDate\": \"2022-07-31\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-07-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 31,\n" +
                "                \"code\": \"EQP-Ami-03\",\n" +
                "                \"label\": \"Panneaux solaires\",\n" +
                "                \"description\": \"Panneaux solaires pour recharge dappoint\",\n" +
                "                \"priceWithVat\": 1500.0,\n" +
                "                \"priceWithoutVat\": 1300.0,\n" +
                "                \"startDate\": \"2022-07-31\",\n" +
                "                \"creationDate\": \"2022-07-31\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-07-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 32,\n" +
                "                \"code\": \"EQP-Ami-04\",\n" +
                "                \"label\": \"Connectivité smartphone\",\n" +
                "                \"description\": \"Application mobile de gestion du véhicule\",\n" +
                "                \"priceWithVat\": 300.0,\n" +
                "                \"priceWithoutVat\": 250.0,\n" +
                "                \"startDate\": \"2022-07-31\",\n" +
                "                \"creationDate\": \"2022-07-31\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-07-31\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"startDate\": \"2022-07-31\",\n" +
                "        \"creationDate\": \"2022-07-31\",\n" +
                "        \"endDate\": \"2022-04-30\",\n" +
                "        \"updateDate\": \"2022-07-31\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 10,\n" +
                "        \"brand\": \"Renault\",\n" +
                "        \"model\": \"Clio\",\n" +
                "        \"version\": \"RS Line\",\n" +
                "        \"imageUrl\": \"https://cdn.pixabay.com/photo/2017/08/25/20/08/renault-2681248_1280.jpg\",\n" +
                "        \"priceWithVat\": 22000.0,\n" +
                "        \"priceWithoutVat\": 18000.0,\n" +
                "        \"equipmentList\": [\n" +
                "            {\n" +
                "                \"id\": 33,\n" +
                "                \"code\": \"EQP-Clio-01\",\n" +
                "                \"label\": \"Système daide au stationnement\",\n" +
                "                \"description\": \"Aide au stationnement automatique\",\n" +
                "                \"priceWithVat\": 1200.0,\n" +
                "                \"priceWithoutVat\": 1000.0,\n" +
                "                \"startDate\": \"2022-08-31\",\n" +
                "                \"creationDate\": \"2022-08-31\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-08-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 34,\n" +
                "                \"code\": \"EQP-Clio-02\",\n" +
                "                \"label\": \"Régulateur de vitesse adaptatif\",\n" +
                "                \"description\": \"Régulateur de vitesse avec détection de véhicule\",\n" +
                "                \"priceWithVat\": 1000.0,\n" +
                "                \"priceWithoutVat\": 850.0,\n" +
                "                \"startDate\": \"2022-08-31\",\n" +
                "                \"creationDate\": \"2022-08-31\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-08-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 35,\n" +
                "                \"code\": \"EQP-Clio-03\",\n" +
                "                \"label\": \"Frein à main électronique\",\n" +
                "                \"description\": \"Frein de parking électronique\",\n" +
                "                \"priceWithVat\": 800.0,\n" +
                "                \"priceWithoutVat\": 700.0,\n" +
                "                \"startDate\": \"2022-08-31\",\n" +
                "                \"creationDate\": \"2022-08-31\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-08-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 36,\n" +
                "                \"code\": \"EQP-Clio-04\",\n" +
                "                \"label\": \"Reconnaissance des panneaux\",\n" +
                "                \"description\": \"Système de reconnaissance des panneaux de signalisation\",\n" +
                "                \"priceWithVat\": 700.0,\n" +
                "                \"priceWithoutVat\": 600.0,\n" +
                "                \"startDate\": \"2022-08-31\",\n" +
                "                \"creationDate\": \"2022-08-31\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-08-31\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"startDate\": \"2022-08-31\",\n" +
                "        \"creationDate\": \"2022-08-31\",\n" +
                "        \"endDate\": \"2022-04-30\",\n" +
                "        \"updateDate\": \"2022-08-31\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 11,\n" +
                "        \"brand\": \"Renault\",\n" +
                "        \"model\": \"Megane\",\n" +
                "        \"version\": \"GT\",\n" +
                "        \"imageUrl\": \"https://cdn.pixabay.com/photo/2017/11/12/09/58/renault-2942017_1280.jpg\",\n" +
                "        \"priceWithVat\": 28000.0,\n" +
                "        \"priceWithoutVat\": 23000.0,\n" +
                "        \"equipmentList\": [\n" +
                "            {\n" +
                "                \"id\": 37,\n" +
                "                \"code\": \"EQP-Megane-01\",\n" +
                "                \"label\": \"Système multimédia\",\n" +
                "                \"description\": \"Écran tactile avec navigation\",\n" +
                "                \"priceWithVat\": 1500.0,\n" +
                "                \"priceWithoutVat\": 1300.0,\n" +
                "                \"startDate\": \"2022-09-30\",\n" +
                "                \"creationDate\": \"2022-09-30\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-09-30\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 38,\n" +
                "                \"code\": \"EQP-Megane-02\",\n" +
                "                \"label\": \"Avertisseur de collision\",\n" +
                "                \"description\": \"Avertissement de collision avant\",\n" +
                "                \"priceWithVat\": 900.0,\n" +
                "                \"priceWithoutVat\": 750.0,\n" +
                "                \"startDate\": \"2022-09-30\",\n" +
                "                \"creationDate\": \"2022-09-30\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-09-30\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 39,\n" +
                "                \"code\": \"EQP-Megane-03\",\n" +
                "                \"label\": \"Climatisation automatique bi-zone\",\n" +
                "                \"description\": \"Climatisation séparée pour conducteur et passager\",\n" +
                "                \"priceWithVat\": 1000.0,\n" +
                "                \"priceWithoutVat\": 850.0,\n" +
                "                \"startDate\": \"2022-09-30\",\n" +
                "                \"creationDate\": \"2022-09-30\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-09-30\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 40,\n" +
                "                \"code\": \"EQP-Megane-04\",\n" +
                "                \"label\": \"Éclairage dambiance LED\",\n" +
                "                \"description\": \"Éclairage intérieur LED personnalisable\",\n" +
                "                \"priceWithVat\": 500.0,\n" +
                "                \"priceWithoutVat\": 400.0,\n" +
                "                \"startDate\": \"2022-09-30\",\n" +
                "                \"creationDate\": \"2022-09-30\",\n" +
                "                \"endDate\": \"2022-09-30\",\n" +
                "                \"updateDate\": \"2022-09-30\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"startDate\": \"2022-09-30\",\n" +
                "        \"creationDate\": \"2022-09-30\",\n" +
                "        \"endDate\": \"2022-04-30\",\n" +
                "        \"updateDate\": \"2022-09-30\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 12,\n" +
                "        \"brand\": \"Renault\",\n" +
                "        \"model\": \"Kadjar\",\n" +
                "        \"version\": \"Intens\",\n" +
                "        \"imageUrl\": \"https://cdn.pixabay.com/photo/2022/01/26/17/08/car-6969349_1280.jpg\",\n" +
                "        \"priceWithVat\": 32000.0,\n" +
                "        \"priceWithoutVat\": 27000.0,\n" +
                "        \"equipmentList\": [\n" +
                "            {\n" +
                "                \"id\": 41,\n" +
                "                \"code\": \"EQP-Kadjar-01\",\n" +
                "                \"label\": \"Toit ouvrant panoramique\",\n" +
                "                \"description\": \"Toit ouvrant en verre panoramique\",\n" +
                "                \"priceWithVat\": 2000.0,\n" +
                "                \"priceWithoutVat\": 1700.0,\n" +
                "                \"startDate\": \"2022-10-31\",\n" +
                "                \"creationDate\": \"2022-10-31\",\n" +
                "                \"endDate\": \"2022-11-30\",\n" +
                "                \"updateDate\": \"2022-10-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 42,\n" +
                "                \"code\": \"EQP-Kadjar-02\",\n" +
                "                \"label\": \"Aide à la conduite ProPILOT\",\n" +
                "                \"description\": \"Système de conduite semi-autonome\",\n" +
                "                \"priceWithVat\": 3000.0,\n" +
                "                \"priceWithoutVat\": 2500.0,\n" +
                "                \"startDate\": \"2022-10-31\",\n" +
                "                \"creationDate\": \"2022-10-31\",\n" +
                "                \"endDate\": \"2022-11-30\",\n" +
                "                \"updateDate\": \"2022-10-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 43,\n" +
                "                \"code\": \"EQP-Kadjar-03\",\n" +
                "                \"label\": \"Sièges chauffants\",\n" +
                "                \"description\": \"Sièges avant chauffants et ventilés\",\n" +
                "                \"priceWithVat\": 1200.0,\n" +
                "                \"priceWithoutVat\": 1000.0,\n" +
                "                \"startDate\": \"2022-10-31\",\n" +
                "                \"creationDate\": \"2022-10-31\",\n" +
                "                \"endDate\": \"2022-11-30\",\n" +
                "                \"updateDate\": \"2022-10-31\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 44,\n" +
                "                \"code\": \"EQP-Kadjar-04\",\n" +
                "                \"label\": \"Système de son Bose\",\n" +
                "                \"description\": \"Système de son Bose premium\",\n" +
                "                \"priceWithVat\": 2500.0,\n" +
                "                \"priceWithoutVat\": 2200.0,\n" +
                "                \"startDate\": \"2022-10-31\",\n" +
                "                \"creationDate\": \"2022-10-31\",\n" +
                "                \"endDate\": \"2022-11-30\",\n" +
                "                \"updateDate\": \"2022-10-31\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"startDate\": \"2022-10-31\",\n" +
                "        \"creationDate\": \"2022-10-31\",\n" +
                "        \"endDate\": \"2022-04-30\",\n" +
                "        \"updateDate\": \"2022-10-31\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 13,\n" +
                "        \"brand\": \"Renault\",\n" +
                "        \"model\": \"Twingo\",\n" +
                "        \"version\": \"Zen\",\n" +
                "        \"imageUrl\": \"https://cdn.pixabay.com/photo/2013/09/27/17/10/auto-187144_1280.jpg\",\n" +
                "        \"priceWithVat\": 15000.0,\n" +
                "        \"priceWithoutVat\": 12500.0,\n" +
                "        \"equipmentList\": [\n" +
                "            {\n" +
                "                \"id\": 45,\n" +
                "                \"code\": \"EQP-Twingo-01\",\n" +
                "                \"label\": \"Capteur de pluie\",\n" +
                "                \"description\": \"Détecteur de pluie avec activation automatique des essuie-glaces\",\n" +
                "                \"priceWithVat\": 500.0,\n" +
                "                \"priceWithoutVat\": 400.0,\n" +
                "                \"startDate\": \"2022-11-30\",\n" +
                "                \"creationDate\": \"2022-11-30\",\n" +
                "                \"endDate\": \"2022-11-30\",\n" +
                "                \"updateDate\": \"2022-11-30\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 46,\n" +
                "                \"code\": \"EQP-Twingo-02\",\n" +
                "                \"label\": \"Système Start/Stop\",\n" +
                "                \"description\": \"Système automatique arrêt/redémarrage du moteur\",\n" +
                "                \"priceWithVat\": 600.0,\n" +
                "                \"priceWithoutVat\": 500.0,\n" +
                "                \"startDate\": \"2022-11-30\",\n" +
                "                \"creationDate\": \"2022-11-30\",\n" +
                "                \"endDate\": \"2022-11-30\",\n" +
                "                \"updateDate\": \"2022-11-30\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 47,\n" +
                "                \"code\": \"EQP-Twingo-03\",\n" +
                "                \"label\": \"Rétroviseurs dégivrants\",\n" +
                "                \"description\": \"Rétroviseurs extérieurs chauffants\",\n" +
                "                \"priceWithVat\": 300.0,\n" +
                "                \"priceWithoutVat\": 250.0,\n" +
                "                \"startDate\": \"2022-11-30\",\n" +
                "                \"creationDate\": \"2022-11-30\",\n" +
                "                \"endDate\": \"2022-11-30\",\n" +
                "                \"updateDate\": \"2022-11-30\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 48,\n" +
                "                \"code\": \"EQP-Twingo-04\",\n" +
                "                \"label\": \"Système de freinage anti-blocage\",\n" +
                "                \"description\": \"Système ABS avec assistance au freinage durgence\",\n" +
                "                \"priceWithVat\": 800.0,\n" +
                "                \"priceWithoutVat\": 700.0,\n" +
                "                \"startDate\": \"2022-11-30\",\n" +
                "                \"creationDate\": \"2022-11-30\",\n" +
                "                \"endDate\": \"2022-11-30\",\n" +
                "                \"updateDate\": \"2022-11-30\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"startDate\": \"2022-11-30\",\n" +
                "        \"creationDate\": \"2022-11-30\",\n" +
                "        \"endDate\": \"2022-04-30\",\n" +
                "        \"updateDate\": \"2022-11-30\"\n" +
                "    }\n" +
                "]";
        //
        vehiclesList = new ArrayList<>();
        //
        vehiclesList = objectMapper.readValue(vehiclesString, new TypeReference<List<Vehicles>>(){});
        //
        when(vehicleManager.getAllVehicles()).thenReturn(vehiclesList);
        //
        when(vehicleManager.getVehicleById(anyInt())).thenReturn(vehiclesList.get(0));
        //
        when(vehicleManager.getVehicleEquipmentsById(anyInt())).thenReturn(vehiclesList.get(0).getEquipmentList());
        //
        when(vehicleManager.getVehicleEquipmentByVehicleIdAndEquipmentId(anyInt(), anyInt())).thenReturn(vehiclesList.get(0).getEquipmentList().get(0));
    }

    /**
     * test GetAllVehicles resources
     */
    @Test
    @DisplayName("testGetAllVehiclesResource")
    void testGetAllVehicles() {
        // debut du test
        var response = vehicleResource.getAllVehicles();
        // assertion validation du test
        assertNotNull(response);
        assertEquals(response.getStatusCode().value(), 200);
    }

    /**
     * test getVehicleById resources
     */
    @Test
    @DisplayName("testGetVehicleByIdResource")
    void testGetVehicleById() {
        // debut dub test
        var response = vehicleResource.getVehicleById(1);
        assertNotNull(response);
        assertEquals(response.getStatusCode().value(), 200);
    }

    /**
     * test getVehicleEquipmentById
     */
    @Test
    @DisplayName("testGetVehicleEquipmentByIdResource")
   void testGetVehicleEquipmentById() {
    // debut du test
    var response = vehicleResource.getVehicleEquipmentById(1);
    // validation du test
    assertNotNull(response);
    assertEquals(response.getStatusCode().value(), 200);
   }

    /**
     * test GetVehicleEquipmentByVehicleIdAndEquipmentId
     */
   @Test
   @DisplayName("testGetVehicleEquipmentByVehicleIdAndEquipmentIdResource")
   void testGetVehicleEquipmentByVehicleIdAndEquipmentId() {
       // debut du test
       var response = vehicleResource.getVehicleEquipmentByVehicleIdAndEquipmentId(1, 1);
       // valider le test
       assertNotNull(response);
       assertEquals(response.getStatusCode().value(), 200);
   }
}