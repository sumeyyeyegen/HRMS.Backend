package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkPlaceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.WorkPlaceDao;
import kodlamaio.hrms.entities.concretes.WorkPlace;

@Service
public class WorkPlaceManager implements WorkPlaceService {
	private WorkPlaceDao workPlaceDao;
	
	@Autowired
	public WorkPlaceManager(WorkPlaceDao workPlaceDao) {
		super();
		this.workPlaceDao = workPlaceDao;
	}

	@Override
	public Result add(WorkPlace workPlace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(WorkPlace workPlace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<WorkPlace>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<WorkPlace> getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(WorkPlace workPlace) {
		// TODO Auto-generated method stub
		return null;
	}

}