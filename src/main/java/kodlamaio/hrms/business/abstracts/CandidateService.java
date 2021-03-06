package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService extends BaseService<Candidate, Integer> {
	Result register(Candidate candidate);
	DataResult<Candidate> getByCandidateCvId(int candidateCvId);
}
