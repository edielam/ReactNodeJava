package com.dronecommunication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.dronecommunication.controller.DroneController;
import com.dronecommunication.model.Drone;
import com.dronecommunication.model.Medication;
import com.dronecommunication.service.DroneService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class DroneControllerTest {
    @Mock
    private DroneService droneService;

    @InjectMocks
    private DroneController controller;

    @Test
    public void testLoadMedications_Success() {
        // Arrange
        String serialNumber = "12345";
        Medication medication1 = new Medication("Aspirin", 40.9, "5ty");
        Medication medication2 = new Medication("Ibuprofen", 27.2,"2yu");
        List<Medication> medications = Arrays.asList(medication1, medication2);
        Drone drone = new Drone("12345", serialNumber, 100, 75, Drone.DroneState.IDLE);
        when(droneService.getDroneBySerialNumber(serialNumber)).thenReturn(Optional.of(drone));
        doNothing().when(droneService).loadMedications(serialNumber, medications);

        // Act
        ResponseEntity<?> result = controller.loadMedications(serialNumber, medications);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void testLoadMedications_InvalidDrone() {
        // Arrange
        String serialNumber = "12345";
        Medication medication1 = new Medication("Aspirin", 40.9, "5ty");
        Medication medication2 = new Medication("Ibuprofen", 27.2,"2yu");
        List<Medication> medications = Arrays.asList(medication1, medication2);
        when(droneService.getDroneBySerialNumber(serialNumber)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<?> result = controller.loadMedications(serialNumber, medications);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }
}

