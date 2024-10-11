package com.villageEmploie.villageEmploisApi;

import com.villageEmploie.villageEmploisApi.resources.VehicleResource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Represent main class
 */
@SpringBootApplication
public class VillageEmploisApiApplication {

	/**
	 * logger
	 */
	private static Logger LOGGER = LogManager.getLogger(VillageEmploisApiApplication.class);


	/**
	 * Entree de l'application
	 * @param args
	 */
	public static void main(String[] args) {
		// start application main
		// 🚀 : U+1F680
		// 💥 : U+1F4A5
		// 🔧 : U+1F527
		SpringApplication.run(VillageEmploisApiApplication.class, args);
		LOGGER.info("Main application started... \uD83D\uDE80");

	}
}
