package com.mastery.javasb;

import com.mastery.javasb.controller.DroneController;
import com.mastery.javasb.repository.DroneRepository;
import com.mastery.javasb.task.BatteryCheckTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class ReviseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviseApplication.class, args);
	}
	@Autowired
	private BatteryCheckTask batteryCheckTask;

	@Bean
	public DroneRepository droneRepository() {
		return new DroneRepository();
	}

	@Bean
	public DroneController droneController(DroneRepository droneRepository) {
		return new DroneController(droneRepository);
	}

	@Scheduled(fixedRate = 60000)
	public void runBatteryCheckTask() {
		batteryCheckTask.run();
	}


}
