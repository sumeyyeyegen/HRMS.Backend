package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.concretes.City;

@CrossOrigin()
@RestController
@RequestMapping("/api/cities")
public class CitiesController {
	
	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<City>>> getAll(){
		DataResult<List<City>> result = cityService.getAll() ;

		if (!result.isSuccess())
			return new ResponseEntity<DataResult<List<City>>>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<DataResult<City>> getById(Integer id){
		DataResult<City> result = cityService.getById(id) ;

		if (!result.isSuccess())
			return new ResponseEntity<DataResult<City>>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}


}
