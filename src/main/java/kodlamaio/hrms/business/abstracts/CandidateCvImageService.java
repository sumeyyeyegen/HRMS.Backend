package kodlamaio.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvImage;
import kodlamaio.hrms.entities.dtos.CvImageForAddAndUpdateDto;

public interface CandidateCvImageService extends BaseService<CandidateCvImage, Integer>{
	Result add(CvImageForAddAndUpdateDto imageDto, MultipartFile file);
	DataResult<CandidateCvImage> getByCandidateCvId(int candidateCvId);
	Result addImage(CvImageForAddAndUpdateDto imageDto);
}
