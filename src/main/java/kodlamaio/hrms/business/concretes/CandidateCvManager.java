package kodlamaio.hrms.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
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
	public DataResult<CandidateCv> getById(int id) {
		final Optional<CandidateCv> candidateCv = candidateCvDao.getById(id);
		
		return new SuccessDataResult<CandidateCv>(candidateCv.get(), "Veri başarılı bir şekilde getirildi.");
		
	}

}
