package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.helpers.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.helpers.abstracts.EmailValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailService emailService;
	private EmailValidationService emailValidationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmailService emailService,EmailValidationService emailValidationService) {
		this.employerDao = employerDao;
		this.emailService=emailService;
		this.emailValidationService = emailValidationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "Veriler başarıyla listelendi.");
	}

	@Override
	public Result register(Employer employer) {
		Result result = new ErrorResult("Kayıt işlemi başarısız");
		if(!emailValidationService.emailValidation(employer))
			return new ErrorResult("Lütfen emailinizi doğrulayın");
		
		if(!employerExists(employer.getEmail()))
			return new ErrorResult("Kullanılmamış email ve kimlik numarasını giriniz");

		//employer.getVerificationCodeEmployer().setVerified(true);
		employerDao.save(employer);
		
		return new SuccessResult("Kullanıcı başarılı bir şekilde kayıt edildi.");
	}
	
	private boolean employerExists(String email) {
		if (this.employerDao.getByEmail(email) == null) {
			return true;
		}
		return false;
	}

}
