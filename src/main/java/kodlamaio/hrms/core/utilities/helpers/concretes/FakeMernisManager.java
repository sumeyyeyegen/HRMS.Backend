package kodlamaio.hrms.core.utilities.helpers.concretes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import kodlamaio.hrms.core.utilities.helpers.abstracts.MernisService;
import kodlamaio.hrms.entities.concretes.Candidate;

@Primary
@Component
public class FakeMernisManager implements MernisService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		return true;
	}
	
}
