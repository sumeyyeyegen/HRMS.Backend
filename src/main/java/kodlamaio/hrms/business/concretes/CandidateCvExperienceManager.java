package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvExperienceService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvExperienceDao;
import kodlamaio.hrms.entities.concretes.CandidateCvExperience;
import kodlamaio.hrms.entities.dtos.CvExperienceForAddDto;

@Service
public class CandidateCvExperienceManager implements CandidateCvExperienceService{
	
	private CandidateCvExperienceDao candidateCvExperienceDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public CandidateCvExperienceManager(CandidateCvExperienceDao candidateCvExperienceDao,DtoConverterService dtoConverterService) {
		super();
		this.candidateCvExperienceDao = candidateCvExperienceDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(CandidateCvExperience candidateCvExperience) {
		candidateCvExperienceDao.save(candidateCvExperience);
		return new SuccessResult("Ekleme işlemi başarıyla gerçekleştirildi");
	}
	
	@Override
	public Result addExperiences(CvExperienceForAddDto cvExperiencesForAddDto) {
		candidateCvExperienceDao.save((CandidateCvExperience) dtoConverterService.dtoClassConverter(cvExperiencesForAddDto, CandidateCvExperience.class));
		return new SuccessResult("İş Deneyimi Eklendi");
	}
	@Override
	public Result delete(CandidateCvExperience candidateCvExperience) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<CandidateCvExperience>> getAll() {
		return new SuccessDataResult<List<CandidateCvExperience>>(candidateCvExperienceDao.findAll(), "Veriler başarılı bir şekilde getirildi"); 
	}

	@Override
	public DataResult<CandidateCvExperience> getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(CandidateCvExperience candidateCvExperience) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<CandidateCvExperience>> getByCandidateCvIdOrderByQuitDateDesc(int candidateCvId) {
		return new SuccessDataResult<List<CandidateCvExperience>>(candidateCvExperienceDao.getByCandidateCvIdOrderByQuitDateDesc(candidateCvId), "Veriler başarılı bir şekilde getirildi.");
	}

	@Override
	public DataResult<List<CandidateCvExperience>> getByCandidateCvIdOrderByQuitDateAsc(int candidateCvId) {
		return new SuccessDataResult<List<CandidateCvExperience>>(candidateCvExperienceDao.getByCandidateCvIdOrderByQuitDateAsc(candidateCvId), "Veriler başarılı bir şekilde getirildi.");
	}

}
