package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.helpers.email.EmailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailService emailService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmailService emailService) {
		this.employerDao = employerDao;
		this.emailService=emailService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "Veriler başarıyla listelendi.");
	}

	@Override
	public Result register(Employer employer) {
		employerDao.save(employer);
		emailService.sendEmail("Doğrulama işlemi başarılı bir şekilde gerçekleştirildi.");
		return new SuccessResult("Kullanıcı başarılı bir şekilde kayıt oldu. Doğrulama işlemi için email adresinizi kontrol ediniz");
	}
}
