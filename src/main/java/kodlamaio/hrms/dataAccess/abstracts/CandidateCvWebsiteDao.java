package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateCvWebsite;
import kodlamaio.hrms.entities.dtos.CvWebSitesForAddDto;

public interface CandidateCvWebsiteDao extends JpaRepository<CandidateCvWebsite, Integer> {
	List<CandidateCvWebsite> getByCandidateCv_Id(int candidateCvId);
}
