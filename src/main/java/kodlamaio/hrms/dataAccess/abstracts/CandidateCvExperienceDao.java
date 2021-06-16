package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateCvExperience;

public interface CandidateCvExperienceDao extends JpaRepository<CandidateCvExperience, Integer>{
	List<CandidateCvExperience> getByCandidateCvIdOrderByQuitDateAsc(int candidateCvId);
	List<CandidateCvExperience> getByCandidateCvIdOrderByQuitDateDesc(int candidateCvId);
}
