package com.dronecommunication;

import com.dronecommunication.controller.DroneController;
import com.dronecommunication.model.Medication;
import com.dronecommunication.service.DroneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ReviseApplicationTests {

	@Autowired
	private DroneService droneService;
	@Autowired
	private DroneController droneController;

	@Test
	void contextLoads() {
	}

}
