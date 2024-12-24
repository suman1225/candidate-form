package com.example.candidateForm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.candidateForm.entity.CandidateEntity;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity, Long> {

}
