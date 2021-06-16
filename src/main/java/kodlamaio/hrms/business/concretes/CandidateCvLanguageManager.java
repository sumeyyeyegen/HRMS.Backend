package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvLanguageDao;
import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;

@Service
public class CandidateCvLanguageManager implements CandidateCvLanguageService {
	
	private CandidateCvLanguageDao candidateCvLanguageDao;
	
	@Autowired
	public CandidateCvLanguageManager(CandidateCvLanguageDao candidateCvLanguageDao) {
		super();
		this.candidateCvLanguageDao = candidateCvLanguageDao;
	}

	@Override
	public Result add(CandidateCvLanguage candidateCvLanguage) {
		candidateCvLanguageDao.save(candidateCvLanguage);
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

}
