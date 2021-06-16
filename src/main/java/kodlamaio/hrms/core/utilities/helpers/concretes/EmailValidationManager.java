package kodlamaio.hrms.core.utilities.helpers.concretes;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.helpers.abstracts.EmailValidationService;


@Component
public class EmailValidationManager implements EmailValidationService {

	private final String Email_Pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

	@Override
	public boolean emailValidation(User user) {
		Pattern pattern = Pattern.compile(Email_Pattern,Pattern.CASE_INSENSITIVE);
		return pattern.matcher(user.getEmail()).find();
	}
}
