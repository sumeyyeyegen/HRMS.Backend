package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAll();
		
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisements);
		
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

	@Override
	public DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueAndEmployer_IdForList(int id) {
		return new SuccessDataResult<List<JobAdvertisementForListDto>>(jobAdvertisementDao.getByIsActiveTrueAndEmployer_IdForList(id),"Data listelendi.");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Başarılı bir şekilde eklendi.");
	}

	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		return null;
	}

	@Override
	public DataResult<JobAdvertisement> getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı güncellendi.");
	}

	@Override
	public Result disableById(int id) {
		final Optional<JobAdvertisement> jobAdvertisement = jobAdvertisementDao.findById(id);		
		jobAdvertisement.get().setActive(false);
		return update(jobAdvertisement.get());
	}
}
