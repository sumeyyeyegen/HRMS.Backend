package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvEducation;
import kodlamaio.hrms.entities.concretes.CandidateCvExperience;
import kodlamaio.hrms.entities.dtos.CvExperienceForAddDto;

public interface CandidateCvExperienceService extends BaseService<CandidateCvExperience, Integer> {
	Result addExperiences(CvExperienceForAddDto cvExperiencesForAddDto);
	DataResult<List<CandidateCvExperience>> getByCandidateCvIdOrderByQuitDateDesc(int candidateCvId);
	DataResult<List<CandidateCvExperience>> getByCandidateCvIdOrderByQuitDateAsc(int candidateCvId);
}
