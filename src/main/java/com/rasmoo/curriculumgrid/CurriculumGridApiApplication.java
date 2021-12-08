package com.rasmoo.curriculumgrid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CurriculumGridApiApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CurriculumGridApiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CurriculumGridApiApplication.class, args);
	}
}