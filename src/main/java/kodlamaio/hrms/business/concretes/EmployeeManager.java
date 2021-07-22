package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.EmployeeDto;

@Service
public class EmployeeManager implements EmployeeService {
	
	private EmployeeDao employeeDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,DtoConverterService dtoConverterService) {
		super();
		this.employeeDao = employeeDao;
		this.dtoConverterService=dtoConverterService;
	}

	@Override
	public Result delete(int id) {
		Employee emp = employeeDao.getOne(id);
		employeeDao.delete(emp);
		return new SuccessResult("Personel silindi");
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		List<Employee> result = employeeDao.findAll();
		return new SuccessDataResult<List<Employee>>(result, "Veriler başarıl bir şekilde getirildi.");
	}

	@Override
	public DataResult<Employee> getById(Integer id) {
		Employee emp = employeeDao.getOne(id);
		return new SuccessDataResult<Employee>(emp, "Personel bilgisi getirildi.");
	}

	@Override
	public Result updateEmployee(EmployeeDto employeeUpdateDto) {
		Employee employee = employeeDao.getOne(employeeUpdateDto.getId());
		employee.setFirstName(employeeUpdateDto.getFirstName());
		employee.setLastName(employeeUpdateDto.getLastName());
		employee.setEmail(employeeUpdateDto.getEmail());
		employee.setPassword(employeeUpdateDto.getPassword());
		employeeDao.save(employee);
		return new SuccessResult("Bilgiler kaydedildi.");
	}

	@Override
	public Result add(Employee employee) {
		employeeDao.save(employee);
		return new SuccessResult("Personel eklendi");
	}

	@Override
	public Result addEmployee(EmployeeDto employeeDto) {
		employeeDao.save((Employee) dtoConverterService.dtoClassConverter(employeeDto, Employee.class));
		return new SuccessResult("Personel eklendi");
	}
	
	@Override
	public Result update(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
