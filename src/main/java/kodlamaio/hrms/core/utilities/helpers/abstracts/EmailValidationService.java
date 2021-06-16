package kodlamaio.hrms.core.utilities.helpers.abstracts;

import kodlamaio.hrms.core.entities.User;

public interface EmailValidationService {
	boolean emailValidation(User user);
}
