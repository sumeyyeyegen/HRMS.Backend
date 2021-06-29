package kodlamaio.hrms.business.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.entities.concretes.City;

public interface CityService extends BaseService<City, Integer> {

}
