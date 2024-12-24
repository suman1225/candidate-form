package com.example.candidateForm.dto;

public class CandidateDto {

	private Long id;
	
	private String candidateName;
	
	private String candidateNumber;
	
	private String qualification;
	
	private String mailId;
	
	private String address;
	
	private String skills;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidateNumber() {
		return candidateNumber;
	}

	public void setCandidateNumber(String candidateNumber) {
		this.candidateNumber = candidateNumber;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	
}
