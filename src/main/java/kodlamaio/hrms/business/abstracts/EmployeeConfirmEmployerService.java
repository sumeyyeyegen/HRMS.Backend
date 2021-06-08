package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.EmployeeConfirmEmployer;

public interface EmployeeConfirmEmployerService extends BaseService<EmployeeConfirmEmployer, Integer> {
	DataResult<EmployeeConfirmEmployer> getByUserId(final int userId);
}
