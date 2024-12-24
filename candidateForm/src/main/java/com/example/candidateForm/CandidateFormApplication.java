package com.example.candidateForm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
 
@SpringBootApplication
@EnableAspectJAutoProxy
public class CandidateFormApplication {

	@Bean
	ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(CandidateFormApplication.class, args);
	}

}
