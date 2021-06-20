package kodlamaio.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvImage;

public interface CandidateCvImageService extends BaseService<CandidateCvImage, Integer>{
	Result add(CandidateCvImage candidateCvImage, MultipartFile file);
	DataResult<CandidateCvImage> getByCandidateCvId(int candidateCvId);
}
