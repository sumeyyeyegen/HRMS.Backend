package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateCvEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvEducation;

@RestController
@RequestMapping("/api/candidate/cvs/educations")

public class CandidateCvEducationController {
	private CandidateCvEducationService candidateCvEducationService;

	@Autowired
	public CandidateCvEducationController(CandidateCvEducationService candidateCvEducationService) {
		super();
		this.candidateCvEducationService = candidateCvEducationService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid final CandidateCvEducation candidateCvEducation){
		final Result result = candidateCvEducationService.add(candidateCvEducation);

		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final CandidateCvEducation jobSeekerCVEducation) {
		final Result result = candidateCvEducationService.delete(jobSeekerCVEducation);

		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<CandidateCvEducation>>> getAll() {
		final DataResult<List<CandidateCvEducation>> result = candidateCvEducationService.getAll();

		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getall/bycandidatecvid")
	public ResponseEntity<DataResult<CandidateCvEducation>> getById(int id) {
		final DataResult<CandidateCvEducation> result = candidateCvEducationService.getById(id);

		return ResponseEntity.ok(result);
	}
}
