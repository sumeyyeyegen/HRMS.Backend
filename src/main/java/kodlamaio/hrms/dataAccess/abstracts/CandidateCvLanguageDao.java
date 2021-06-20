package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;

public interface CandidateCvLanguageDao extends JpaRepository<CandidateCvLanguage, Integer>{
	
	List<CandidateCvLanguage> getByCandidateCv_Id(int candidateCvId);
}
