package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.Job;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementsDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,DtoConverterService dtoConverterService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAll();
		
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisements, "Veriler başarılı bir şekilde getirildi");
		
	}
	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(
				jobAdvertisementDao.getByIsActiveTrue(), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByReleaseDateDesc() {
		return new SuccessDataResult<List<JobAdvertisementForListDto>>(jobAdvertisementDao.getByIsActiveTrueOrderByReleaseDateDesc(),"Data listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByReleaseDateAsc() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByIsActiveTrueOrderByReleaseDateAsc(),"Data listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByApplicationDeadlineDesc() {
		return new SuccessDataResult<List<JobAdvertisementForListDto>>(jobAdvertisementDao.getByIsActiveTrueOrderByApplicationDeadlineDesc() ,"Data listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByApplicationDeadlineAsc() {
		return new SuccessDataResult<List<JobAdvertisementForListDto>>(jobAdvertisementDao.getByIsActiveTrueOrderByApplicationDeadlineAsc(),"Data listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueAndEmployer_IdForList(int id) {
		return new SuccessDataResult<List<JobAdvertisementForListDto>>(jobAdvertisementDao.getByIsActiveTrueAndEmployer_IdForList(id),"Data listelendi.");
	}

	@Override
	public Result disableById(int id) {
		final Optional<JobAdvertisement> jobAdvertisement = jobAdvertisementDao.findById(id);		
		jobAdvertisement.get().setActive(false);
		return update(jobAdvertisement.get());
	}

	@Override
	public Result add(JobAdvertisement entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobAdvertisement entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<JobAdvertisement> getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result addJobAdvertisements(JobAdvertisementsDto jobAdvertisementsDto) {
		jobAdvertisementDao.save((JobAdvertisement) dtoConverterService.dtoClassConverter(jobAdvertisementsDto, JobAdvertisement.class));
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		JobAdvertisement jobAdvertisementToUpdate = jobAdvertisementDao.getOne(jobAdvertisement.getId());
		jobAdvertisementToUpdate=jobAdvertisement;
		jobAdvertisementDao.save(jobAdvertisementToUpdate);
		return new SuccessResult("İş ilanı güncellendi.");
	}
}
