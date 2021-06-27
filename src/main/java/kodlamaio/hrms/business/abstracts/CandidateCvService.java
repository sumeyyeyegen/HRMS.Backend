package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateCv;

public interface CandidateCvService extends BaseService<CandidateCv, Integer> {
	DataResult<List<CandidateCv>> getAllByCandidateId(int candidateId);
	
}
