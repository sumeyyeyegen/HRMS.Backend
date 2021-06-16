package kodlamaio.hrms.business.abstracts;

import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateCv;

public interface CandidateCvService {
	DataResult<CandidateCv> getById(int id); 
}
