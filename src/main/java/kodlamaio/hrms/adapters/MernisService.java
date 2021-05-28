package kodlamaio.hrms.adapters;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface MernisService {
	boolean checkIfRealPerson(Candidate candidate);
}
