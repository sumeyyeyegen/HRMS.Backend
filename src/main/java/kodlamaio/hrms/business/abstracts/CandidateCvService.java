package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.dtos.CvDto;
import kodlamaio.hrms.entities.dtos.CvForUpdateAndAddDto;

public interface CandidateCvService extends BaseService<CandidateCv, Integer> {
	DataResult<List<CandidateCv>> getAllByCandidateId(int candidateId);
	Result updateCv(CvDto cvDto);
	Result addCv(CvDto cvDto);
}
