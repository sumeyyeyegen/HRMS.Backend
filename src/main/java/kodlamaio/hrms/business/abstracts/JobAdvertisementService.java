package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrue();
	DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByReleaseDateDesc();
	DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByReleaseDateAsc();
	DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByApplicationDeadlineDesc();
	DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByApplicationDeadlineAsc();
}
