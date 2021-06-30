package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkTimeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkTimeDao;
import kodlamaio.hrms.entities.concretes.WorkTime;

@Service
public class WorkTimeManager implements WorkTimeService {
	
	private WorkTimeDao workTimeDao;

	@Autowired
	public WorkTimeManager(WorkTimeDao workTimeDao) {
		super();
		this.workTimeDao = workTimeDao;
	}

	@Override
	public Result add(WorkTime workTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(WorkTime workTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<WorkTime>> getAll() {
		List<WorkTime> results = workTimeDao.findAll();
		return new SuccessDataResult<List<WorkTime>>(results, "Veriler başarılı bir şekilde getirildi.");
	}

	@Override
	public DataResult<WorkTime> getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(WorkTime workTime) {
		// TODO Auto-generated method stub
		return null;
	}

}
