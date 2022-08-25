package com.worker.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkerApplication {

	public static void main(String[] args) {
		System.out.println("start");
		SpringApplication.run(WorkerApplication.class);
	}

}
