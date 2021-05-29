package kodlamaio.hrms.core.utilities.helpers.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface MernisService {
	boolean checkIfRealPerson(Candidate candidate);
}
