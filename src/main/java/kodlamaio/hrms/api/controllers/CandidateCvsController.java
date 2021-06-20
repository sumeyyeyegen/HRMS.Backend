package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateCvService;
import kodlamaio.hrms.business.concretes.CandidateCvManager;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.concretes.CandidateCvEducation;
import kodlamaio.hrms.entities.dtos.CandidateCvListDto;

@RestController
@RequestMapping("/api/candidate/cvs")
public class CandidateCvsController {
	private CandidateCvService candidateCvService;

	@Autowired
	public CandidateCvsController(CandidateCvService candidateCvService) {
		super();
		this.candidateCvService = candidateCvService;
	}
	
	@GetMapping("/getbycandidatecvid")
	public ResponseEntity<DataResult<CandidateCv>> getByCandidateCvId(int candidateCvId){
		DataResult<CandidateCv> result = candidateCvService.getById(candidateCvId) ;

		if (!result.isSuccess())
			return new ResponseEntity<DataResult<CandidateCv>>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
		}
	}

