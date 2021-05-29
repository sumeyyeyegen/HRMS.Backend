package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.helpers.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.helpers.adapters.MernisServiceAdapter;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	private MernisServiceAdapter mernisAdapter;
	private EmailService emailService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,MernisServiceAdapter mernisAdapter,EmailService emailService) {
		super();
		this.candidateDao = candidateDao;
		//TODO: mernis
		this.mernisAdapter=mernisAdapter;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data listelendi.");
	}

	@Override
	public Result register(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("Kişi eklendi.");
	}

}
