package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.helpers.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.helpers.abstracts.MernisService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	private MernisService mernisService;
	private EmailService emailService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,MernisService mernisService,EmailService emailService) {
		super();
		this.candidateDao = candidateDao;
		this.mernisService=mernisService;
		this.emailService= emailService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data listelendi.");
	}

	@Override
	public Result register(Candidate candidate) {
		Result result = new ErrorResult("Kayıt işlemi başarısız");
		if(mernisService.checkIfRealPerson(candidate)) {
			emailService.sendEmail("Kayıt işleminin gerçekleşmesi için tarafınıza mail gönderilmiştir.");
			candidateDao.save(candidate);
			result =  new SuccessResult("Kayıt işlemi başarılı");
		}
		return result;
	}

}
