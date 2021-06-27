package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateCv;

@CrossOrigin()
@RestController
@RequestMapping("/api/candidate/cvs")
public class CandidateCvsController {
	private CandidateCvService candidateCvService;

	@Autowired
	public CandidateCvsController(CandidateCvService candidateCvService) {
		super();
		this.candidateCvService = candidateCvService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<CandidateCv>>> getAll(){
		DataResult<List<CandidateCv>> result = candidateCvService.getAll() ;

		if (!result.isSuccess())
			return new ResponseEntity<DataResult<List<CandidateCv>>>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
	
	
	@GetMapping("/getbycandidatecvid")
	public ResponseEntity<DataResult<CandidateCv>> getByCandidateCvId(int candidateCvId){
		DataResult<CandidateCv> result = candidateCvService.getById(candidateCvId) ;

		if (!result.isSuccess())
			return new ResponseEntity<DataResult<CandidateCv>>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getallbycandidateid")
	public ResponseEntity<DataResult<List<CandidateCv>>> getAllByCandidateId(int candidateCvId){
		DataResult<List<CandidateCv>> result = candidateCvService.getAllByCandidateId(candidateCvId);

		if (!result.isSuccess())
			return new ResponseEntity<DataResult<List<CandidateCv>>>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
}

