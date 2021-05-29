package kodlamaio.hrms.core.utilities.helpers.concretes;

import java.util.regex.Pattern;
import kodlamaio.hrms.core.utilities.helpers.abstracts.EmailValidationService;

public class EmailValidationManager implements EmailValidationService {

	private final String Email_Pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
	
	@Override
	public boolean emailValidation(String email) {
		Pattern pattern = Pattern.compile(Email_Pattern,Pattern.CASE_INSENSITIVE);
		
		return pattern.matcher(email).find();
	}

}
