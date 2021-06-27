package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.CandidateCv;

public interface CandidateCvDao extends JpaRepository<CandidateCv, Integer> {
	List<CandidateCv> getAllByCandidate_Id(int candidateId);
}
