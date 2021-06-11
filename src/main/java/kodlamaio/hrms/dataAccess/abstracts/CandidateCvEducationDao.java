package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateCvEducation;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto;

public interface CandidateCvEducationDao extends JpaRepository<CandidateCvEducation, Integer>{
	
	DataResult<List<CandidateCvEducation>> getByAllCandidateCv_Id(int jobSeekerId);
	
}
