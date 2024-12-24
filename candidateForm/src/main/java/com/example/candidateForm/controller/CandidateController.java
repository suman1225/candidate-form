package com.example.candidateForm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.candidateForm.dto.CandidateDto;
import com.example.candidateForm.service.CandidateService;

@RestController
@CrossOrigin
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	CandidateService candidateService;

	@PostMapping("/save")
	public ResponseEntity<?> saveCandidate(@RequestBody CandidateDto candidateDto) {

		Boolean saveCandidate = candidateService.saveCandidate(candidateDto);
		if (saveCandidate) {
			return ResponseEntity.ok("Candidate saved successfully");
		} else {
			return ResponseEntity.ok("Error In Candidate Saving");
		}

	}

}
