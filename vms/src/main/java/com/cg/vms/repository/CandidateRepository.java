package com.cg.vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.vms.model.Candidate;

public interface CandidateRepository extends JpaRepository <Candidate, Long>{

}
