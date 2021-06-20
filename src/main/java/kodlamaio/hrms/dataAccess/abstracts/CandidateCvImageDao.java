package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateCvImage;

public interface CandidateCvImageDao extends JpaRepository<CandidateCvImage, Integer> {
	CandidateCvImage getByCandidateCv_Id(int candidateCvId);
}
