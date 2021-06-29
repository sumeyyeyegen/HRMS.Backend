package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.dtos.EmployeeDto;

public interface EmployeeService extends BaseService<Employee, Integer> {
	public Result updateEmployee(EmployeeDto employeeUpdateDto);
	public Result addEmployee(EmployeeDto employeeDto);
}
