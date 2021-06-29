package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public Result add(City city) {
		cityDao.save(city);
		
		return new SuccessResult("Şehir bilgisi eklendi");
	}

	@Override
	public Result delete(City city) {
		cityDao.delete(city);
		return new SuccessResult("Şehir bilgisi silindi");
	}

	@Override
	public DataResult<List<City>> getAll() {
		List<City> results = cityDao.findAll();
		return new SuccessDataResult<List<City>>(results,"Veriler başarılı bir şekilde getirildi.") ;
	}

	@Override
	public DataResult<City> getById(Integer id) {
		City city = cityDao.getOne(id);
		return new SuccessDataResult<City>(city, "Şehir getirildi.") ;
	}

	@Override
	public Result update(City city) {
		return null;
	}

}
