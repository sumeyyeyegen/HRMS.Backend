package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisementForListDto>>(
				jobAdvertisementDao.getByIsActiveTrue(), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByReleaseDateDesc() {
		return new SuccessDataResult<List<JobAdvertisementForListDto>>(jobAdvertisementDao.getByIsActiveTrueOrderByReleaseDateDesc(),"Data listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByReleaseDateAsc() {
		return new SuccessDataResult<List<JobAdvertisementForListDto>>(jobAdvertisementDao.getByIsActiveTrueOrderByReleaseDateAsc(),"Data listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByApplicationDeadlineDesc() {
		return new SuccessDataResult<List<JobAdvertisementForListDto>>(jobAdvertisementDao.getByIsActiveTrueOrderByApplicationDeadlineDesc() ,"Data listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByApplicationDeadlineAsc() {
		return new SuccessDataResult<List<JobAdvertisementForListDto>>(jobAdvertisementDao.getByIsActiveTrueOrderByReleaseDateAsc(),"Data listelendi.");
	}
	
	
}
