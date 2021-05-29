package kodlamaio.hrms.core.utilities.helpers.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface EmailService {
	Result sendEmail(String message);
}
