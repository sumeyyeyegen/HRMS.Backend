package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateCvEducation;

public interface CandidateCvEducationService extends BaseService<CandidateCvEducation, Integer> {
	DataResult<List<CandidateCvEducation>> getByCandidateCvEducations_Id(int id); 
	DataResult<List<CandidateCvEducation>> getAllByCandidateCvIdOrderByGraduationDateDesc(int candidateCvId);
	DataResult<List<CandidateCvEducation>> getAllByCandidateCvIdOrderByGraduationDateAsc(int candidateCvId);
}
