package com.example.candidateForm.serviceimpl;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.candidateForm.dto.CandidateDto;
import com.example.candidateForm.entity.CandidateEntity;
import com.example.candidateForm.entity.LogMessage;
import com.example.candidateForm.repository.CandidateRepository;
import com.example.candidateForm.repository.LogRepository;
import com.example.candidateForm.service.CandidateService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	CandidateRepository candidateRepository;

	@Autowired
	LogRepository logRepository;

	@Override
	@CircuitBreaker(name = "CandidateServiceImpl", fallbackMethod = "fallbackForProcessData")
	public Boolean saveCandidate(CandidateDto candidateDto) {
	    Boolean status = false;
	    try {
	        HttpEntity<CandidateDto> entity = new HttpEntity<>(candidateDto);
	        String url = "http://localhost:8081/candidate-list/save-candidate";
	        ResponseEntity<String> candidatId = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

	        CandidateEntity candidateEntity = new CandidateEntity();
	        candidateEntity.setCandidateId(Long.valueOf(candidatId.getBody()));
	        candidateRepository.save(candidateEntity);

	        candidateEntity = null;
	        status = true;
	        return status;

	    } catch (Exception e) {
 	        throw new RuntimeException("Error saving candidate", e); 
	    }
	}

	public Boolean fallbackForProcessData(CandidateDto candidateDto, Throwable throwable) {
	    Boolean status = false;
	    try {
	        LogMessage logMessage = new LogMessage();
	        logMessage.setLogMessages(throwable.getMessage());
	        logMessage.setLocalDate(LocalDate.now());

	        logRepository.save(logMessage);

	        logMessage = null;

	    } catch (Exception e2) {
	        System.out.println(e2.getMessage());
	    }

	    return status;
	}

}
