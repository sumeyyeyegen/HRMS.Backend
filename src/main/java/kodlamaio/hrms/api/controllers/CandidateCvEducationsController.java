package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateCvEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvEducation;
import kodlamaio.hrms.entities.dtos.CvEducationForAddAndUpdateDto;

@CrossOrigin()
@RestController
@RequestMapping("/api/candidate/cvs/educations")

public class CandidateCvEducationsController {
	private CandidateCvEducationService candidateCvEducationService;

	@Autowired
	public CandidateCvEducationsController(CandidateCvEducationService candidateCvEducationService) {
		super();
		this.candidateCvEducationService = candidateCvEducationService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid final CvEducationForAddAndUpdateDto eduDto){
		final Result result = candidateCvEducationService.addEducation(eduDto);
		if(!result.isSuccess())
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Result> update(@RequestBody CvEducationForAddAndUpdateDto cvEduDto){
		final Result result = candidateCvEducationService.updateEducation(cvEduDto);
		if(!result.isSuccess())
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(int cvEduId) {
		Result result = candidateCvEducationService.delete(cvEduId);

		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<CandidateCvEducation>>> getAll() {
		final DataResult<List<CandidateCvEducation>> result = candidateCvEducationService.getAll();

		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getall/bycandidatecvid")
	public ResponseEntity<DataResult<List<CandidateCvEducation>>> getByCandidateCvEducations_Id(@RequestParam int id) {
		final DataResult<List<CandidateCvEducation>> result = candidateCvEducationService.getByCandidateCvEducations_Id(id);

		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getall/bycandidatecvgraduationdatedesc")
	public ResponseEntity<DataResult<List<CandidateCvEducation>>> getByCandidateCvEducations_IdOrderByGraduationDateDesc(@RequestParam int id) {
		final DataResult<List<CandidateCvEducation>> result = candidateCvEducationService.getAllByCandidateCvIdOrderByGraduationDateDesc(id);

		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getall/bycandidatecvgraduationdateasc")
	public ResponseEntity<DataResult<List<CandidateCvEducation>>> getByCandidateCvEducations_IdOrderByGraduationDateAsc(@RequestParam int id) {
		final DataResult<List<CandidateCvEducation>> result = candidateCvEducationService.getAllByCandidateCvIdOrderByGraduationDateAsc(id);

		return ResponseEntity.ok(result);
	}
}
