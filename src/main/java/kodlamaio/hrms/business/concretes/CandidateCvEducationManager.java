package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvEducationService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvEducationDao;
import kodlamaio.hrms.entities.concretes.CandidateCvEducation;
import kodlamaio.hrms.entities.dtos.CvEducationForAddAndUpdateDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto;

@Service
public class CandidateCvEducationManager implements CandidateCvEducationService {
	
	private CandidateCvEducationDao candidateCvEducationDao;
	private DtoConverterService dtoConverter;
	
	@Autowired
	public CandidateCvEducationManager(CandidateCvEducationDao candidateCvEducationDao,DtoConverterService dtoConverter) {
		this.candidateCvEducationDao=candidateCvEducationDao;
		this.dtoConverter = dtoConverter;
	}

	@Override
	public Result add(final CandidateCvEducation candidateCvEducation) {
		candidateCvEducationDao.save(candidateCvEducation);
		
		return new SuccessResult("Başarılı bir şekilde eklendi.");
	}

	@Override
	public Result delete(int cvEduId) {
		CandidateCvEducation cv = candidateCvEducationDao.getOne(cvEduId);
		candidateCvEducationDao.delete(cv);
		
		return new SuccessResult("Başarılı bir şekilde silindi.");
	}

	@Override
	public DataResult<List<CandidateCvEducation>> getAll() {
		return new SuccessDataResult<List<CandidateCvEducation>>(candidateCvEducationDao.findAll(), "Veriler başarılı bir şekilde getirildi.") ;
	}

	@Override
	public DataResult<List<CandidateCvEducation>> getByCandidateCvEducations_Id(int id) {
		final List<CandidateCvEducation> candidateCVEducations = candidateCvEducationDao.getByCandidateCvEducations_Id(id);

		return new SuccessDataResult<List<CandidateCvEducation>>(candidateCVEducations, "Veriler başarılı bir şekilde getirildi.");
	}

	@Override
	public Result updateEducation(CvEducationForAddAndUpdateDto cvEduDto) {
		CandidateCvEducation resCvEducation = candidateCvEducationDao.getOne(cvEduDto.getId());
		resCvEducation.setDepartmentName(cvEduDto.getDepartmentName());
		resCvEducation.setGraduationDate(cvEduDto.getGraduationDate());
		resCvEducation.setStartDate(cvEduDto.getStartDate());
		resCvEducation.setSchoolName(cvEduDto.getSchoolName());
		candidateCvEducationDao.save(resCvEducation);
		
		return new SuccessResult("Güncelleme işlemi başarılı bir şekilde gerçekleştirildi");
	}

	@Override
	public DataResult<CandidateCvEducation> getById(Integer id) {
		
		return null;
	}

	@Override
	public DataResult<List<CandidateCvEducation>> getAllByCandidateCvIdOrderByGraduationDateDesc(int candidateCvId) {
		return new SuccessDataResult<List<CandidateCvEducation>>(candidateCvEducationDao.getAllByCandidateCvIdOrderByGraduationDateDesc(candidateCvId),"Data listelendi.");
	}

	@Override
	public DataResult<List<CandidateCvEducation>> getAllByCandidateCvIdOrderByGraduationDateAsc(int candidateCvId) {
		return new SuccessDataResult<List<CandidateCvEducation>>(candidateCvEducationDao.getAllByCandidateCvIdOrderByGraduationDateAsc(candidateCvId),"Data listelendi.");
	}

	@Override
	public Result addEducation(CvEducationForAddAndUpdateDto eduDto) {
		candidateCvEducationDao.save((CandidateCvEducation) dtoConverter.dtoClassConverter(eduDto, CandidateCvEducation.class));
		
		return new SuccessResult("Başarılı bir şekilde eklendi.");
	}

	@Override
	public Result update(CandidateCvEducation entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
