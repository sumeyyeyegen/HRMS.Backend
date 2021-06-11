package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvEducationDao;
import kodlamaio.hrms.entities.concretes.CandidateCvEducation;

@Service
public class CandidateCvEducationManager implements CandidateCvEducationService {
	
	private CandidateCvEducationDao candidateCvEducationDao;
	
	@Autowired
	public CandidateCvEducationManager(CandidateCvEducationDao candidateCvEducationDao) {
		this.candidateCvEducationDao=candidateCvEducationDao;
	}

	@Override
	public Result add(final CandidateCvEducation candidateCvEducation) {
		candidateCvEducationDao.save(candidateCvEducation);
		
		return new SuccessResult("Başarılı bir şekilde eklendi.");
	}

	@Override
	public Result delete(CandidateCvEducation candidateCvEducation) {
		candidateCvEducationDao.delete(candidateCvEducation);
		
		return new SuccessResult("Başarılı bir şekilde silindi.");
	}

	@Override
	public DataResult<List<CandidateCvEducation>> getAll() {
		return new SuccessDataResult<List<CandidateCvEducation>>(candidateCvEducationDao.findAll(), "Veriler başarılı bir şekilde getirildi.") ;
	}

	@Override
	public DataResult<List<CandidateCvEducation>> getByAllCandidateCv_Id(int id) {
		final List<CandidateCvEducation> candidateCvEducations = candidateCvEducationDao.getByAllCandidateCv_Id(id);
		
		return 
	}

	@Override
	public Result update(CandidateCvEducation candidateCvEducation) {
		
		return null;
	}

	@Override
	public DataResult<CandidateCvEducation> getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
