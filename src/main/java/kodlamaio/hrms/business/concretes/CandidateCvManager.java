package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvDao;
import kodlamaio.hrms.entities.concretes.CandidateCv;

@Service
public class CandidateCvManager implements CandidateCvService{
	
	private CandidateCvDao candidateCvDao;
	
	@Autowired
	public CandidateCvManager(CandidateCvDao candidateCvDao) {
		this.candidateCvDao=candidateCvDao;
	}

	@Override
	public DataResult<List<CandidateCv>> getAllByCandidateId(int candidateId) {
		List<CandidateCv> cvs = candidateCvDao.getAllByCandidate_Id(candidateId);
		return new SuccessDataResult<List<CandidateCv>>(cvs, "Veriler başarılı bir şekilde getirildi.") ;
	}

	@Override
	public Result add(CandidateCv entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(CandidateCv entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<CandidateCv>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<CandidateCv> getById(Integer id) {
		final Optional<CandidateCv> candidateCv = candidateCvDao.findById(id);
		
		return new SuccessDataResult<CandidateCv>(candidateCv.get(), "Veri başarılı bir şekilde getirildi.");
	}

	@Override
	public Result update(CandidateCv entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
