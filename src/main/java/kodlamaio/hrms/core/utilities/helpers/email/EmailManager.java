package kodlamaio.hrms.core.utilities.helpers.email;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class EmailManager implements EmailService{
	public Result sendEmail(String message) {
		return new SuccessResult(message);
	}

}
