package kodlamaio.hrms.business.abstracts;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;

public interface JobService {
	public Result addJob(Job job);
}
