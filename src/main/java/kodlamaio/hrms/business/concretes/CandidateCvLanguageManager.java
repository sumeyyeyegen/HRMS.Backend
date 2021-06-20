package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvLanguageService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvLanguageDao;
import kodlamaio.hrms.entities.concretes.CandidateCvExperience;
import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;
import kodlamaio.hrms.entities.dtos.CvLanguagesForAddDto;

@Service
public class CandidateCvLanguageManager implements CandidateCvLanguageService {
	
	private CandidateCvLanguageDao candidateCvLanguageDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CandidateCvLanguageManager(CandidateCvLanguageDao candidateCvLanguageDao,DtoConverterService dtoConverterService) {
		super();
		this.candidateCvLanguageDao = candidateCvLanguageDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result addLanguages(CvLanguagesForAddDto cvLanguagesForAddDto) {
		candidateCvLanguageDao.save((CandidateCvLanguage) dtoConverterService.dtoClassConverter(cvLanguagesForAddDto, CandidateCvLanguage.class));
		return new SuccessResult("Ekleme işlemi başarıyla gerçekleştirildi");
	}

	@Override
	public Result delete(CandidateCvLanguage candidateCvLanguage) {
		candidateCvLanguageDao.delete(candidateCvLanguage);
		candidateCvLanguageDao.save(candidateCvLanguage);
		return new SuccessResult("Silme işlemi gerçekleştirildi");
	}

	@Override
	public DataResult<List<CandidateCvLanguage>> getAll() {
		return new SuccessDataResult<List<CandidateCvLanguage>>(candidateCvLanguageDao.findAll(),"Veriler başarılı bir şekilde listelendi.");
	}

	@Override
	public DataResult<CandidateCvLanguage> getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(CandidateCvLanguage candidateCvLanguage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(CandidateCvLanguage entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<CandidateCvLanguage>> getByCandidateCvId(int candidateCvId) {
		List<CandidateCvLanguage> languages = candidateCvLanguageDao.getByCandidateCv_Id(candidateCvId);
		return new SuccessDataResult<List<CandidateCvLanguage>>(languages, "Veriler başarılı bir şekilde getirildi.") ;
	}

}
