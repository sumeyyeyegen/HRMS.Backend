package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.helpers.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.helpers.abstracts.EmailValidationService;
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
	private EmailValidationService emailValidationService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,MernisService mernisService,EmailService emailService,EmailValidationService emailValidationService) {
		super();
		this.candidateDao = candidateDao;
		this.mernisService=mernisService;
		this.emailService= emailService;
		this.emailValidationService = emailValidationService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data listelendi.");
	}

	@Override
	public Result register( Candidate candidate) {
		Result result = new ErrorResult("Kayıt işlemi başarısız");
		if(!mernisService.checkIfRealPerson(candidate))
			return new ErrorResult("Geçerli bir kullanıcı değil.");
		
		if(!emailValidationService.emailValidation(candidate))
			return new ErrorResult("Lütfen emailinizi doğrulayın");
		
		if(!candidateExists(candidate.getEmail(), candidate.getIdentityNumber()))
			return new ErrorResult("Kullanılmamış email ve kimlik numarasını giriniz");
		
//		candidate.getVerificationCodeCandidate().setVerified(true);
		candidateDao.save(candidate);
		
		return new SuccessResult("Kullanıcı başarılı bir şekilde kayıt edildi.");
	}
	
	private boolean candidateExists(String email, String indentityNumber) {
		if (this.candidateDao.getByEmail(email) == null && 
				this.candidateDao.getByIdentityNumber(indentityNumber) == null) {
			return true;
		}
		return false;
	}

	@Override
	public DataResult<Candidate> getByCandidateCvId(int candidateCvId) {
		Candidate candidate = candidateDao.getByCandidateCv_Id(candidateCvId);
		
		return new SuccessDataResult<Candidate>(candidate, "Veri başarılı bir şekilde getirildi");
	}

}
