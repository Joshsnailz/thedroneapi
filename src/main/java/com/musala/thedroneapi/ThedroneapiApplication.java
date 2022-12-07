package com.musala.thedroneapi;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ThedroneapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThedroneapiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {return new ModelMapper();}

}
