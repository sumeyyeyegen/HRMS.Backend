package kodlamaio.hrms.core.utilities.helpers.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.helpers.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class EmailManager implements EmailService{
	public Result sendEmail(String message) {
		return new SuccessResult(message);
	}

}
