package com.info.projectbatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectBatchApplication.class, args);
	}

}
