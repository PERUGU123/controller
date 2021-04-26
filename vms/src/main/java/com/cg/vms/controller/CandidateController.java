package com.cg.vms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.exception.CandidateNotFoundException;
import com.cg.vms.model.Candidate;
import com.cg.vms.service.CandidateService;

@RestController
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	
	@PostMapping("/candidate/add")
	public Candidate insertData(@RequestBody Candidate candidate) {
		if(candidate.getAge()>=18 && candidate.getAge()<=60) {
		return candidateService.saveCandidate(candidate);
	}
		else {
			return null;
		}
		}
	
	
	@GetMapping("/candidate/all")
	public List<Candidate> viewAllCandidates() {
		return candidateService.viewAllCandidates();
	}
	
	
	@GetMapping("/candidate/{candidateId}") 
		public ResponseEntity<Candidate> viewCandidate(@PathVariable( value="candidateId") Long candidateId) throws CandidateNotFoundException{
		Candidate candidate=candidateService.getCandidateById(candidateId).orElseThrow(() -> new CandidateNotFoundException("No Candidate Data Available with Candidate Id: " +candidateId));
		return ResponseEntity.ok().body(candidate);
		}
	
	@PutMapping("/candidate/{candidateId}")
	public Candidate updateCandidate(@RequestBody Candidate candidate) {
		Optional <Candidate> canOptional = candidateService.getCandidateById(candidate.getCandidateId());
		if(canOptional.isPresent() .m nvc xzdfghjkop[]iuytfdgf&& candidate.getAge()>=18 && candidate.getAge()<=60) {
			return candidateService.saveCandidate(candidate);
		}
		else {
			return null;
		}
	}
	
	@DeleteMapping("/candidate/{candidateId}") 
	public String deleteCandidate(@PathVariable( value="candidateId") Long candidateId) throws CandidateNotFoundException{
		Candidate candidate=candidateService.getCandidateById(candidateId).orElseThrow(() -> new CandidateNotFoundException("No Candidate Data Available with Candidate Id: " +candidateId));
		candidateService.deleteCandidate(candidate);
		return "Candidate Details Deleted Successfully";
	}

}

