package com.example.candidateForm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.candidateForm.entity.CandidateEntity;
import com.example.candidateForm.entity.LogMessage;

@Repository
public interface LogRepository extends JpaRepository<LogMessage, Long> {

}
