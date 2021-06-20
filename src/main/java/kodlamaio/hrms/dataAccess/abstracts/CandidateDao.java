package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate getByEmail(String email);
	Candidate getByIdentityNumber(String identityNumber);
	Candidate getByCandidateCv_Id(int candidateCvId);
}
