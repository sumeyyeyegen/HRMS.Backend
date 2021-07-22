package kodlamaio.hrms.core.business;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface BaseService<T,Id> {
	Result add(T entity);
	Result delete(int id);
	DataResult<List<T>> getAll();
	DataResult<T> getById(Id id);
	Result update(T entity);
}
