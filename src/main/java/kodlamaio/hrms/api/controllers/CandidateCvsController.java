package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.dtos.CvDto;
import kodlamaio.hrms.entities.dtos.CvForUpdateAndAddDto;

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
	
	@PostMapping("/add")
	public Result add(@RequestBody CvDto cvDto){
		Result result = candidateCvService.addCv(cvDto);
		if(!result.isSuccess())
			return new ErrorResult("İşlem başarılı değil.");
		return new SuccessResult("Cv başarılı bir şekilde eklendi");
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<CandidateCv>>> getAll(){
		DataResult<List<CandidateCv>> result = candidateCvService.getAll() ;

		if (!result.isSuccess())
			return new ResponseEntity<DataResult<List<CandidateCv>>>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/update") 
	public ResponseEntity<Result> updateCv(@RequestBody CvDto cvDto){
		Result result = candidateCvService.updateCv(cvDto);

		if (!result.isSuccess())
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
	 
	
	@GetMapping("/getbycandidatecvid")
	public ResponseEntity<DataResult<CandidateCv>> getByCandidateCvId(@RequestParam int candidateCvId){
		DataResult<CandidateCv> result = candidateCvService.getById(candidateCvId) ;

		if (!result.isSuccess())
			return new ResponseEntity<DataResult<CandidateCv>>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getallbycandidateid")
	public ResponseEntity<DataResult<List<CandidateCv>>> getAllByCandidateId(@RequestParam int candidateId){
		DataResult<List<CandidateCv>> result = candidateCvService.getAllByCandidateId(candidateId);
 
		if (!result.isSuccess())
			return new ResponseEntity<DataResult<List<CandidateCv>>>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
}

