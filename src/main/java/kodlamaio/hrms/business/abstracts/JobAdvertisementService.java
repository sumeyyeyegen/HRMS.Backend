package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementsDto;

public interface JobAdvertisementService extends BaseService<JobAdvertisement,Integer> {
	Result addJobAdvertisements(JobAdvertisementsDto jobAdvertisementsDto);
	Result disableById(int id);
	DataResult<List<JobAdvertisement>> getByIsActiveTrue();
	DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByReleaseDateDesc();
	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByReleaseDateAsc();
	DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByApplicationDeadlineDesc();
	DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByApplicationDeadlineAsc();
	DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueAndEmployer_IdForList(int id);
}
