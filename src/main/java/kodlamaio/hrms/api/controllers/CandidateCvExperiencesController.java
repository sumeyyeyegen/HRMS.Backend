package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateCvExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvEducation;
import kodlamaio.hrms.entities.concretes.CandidateCvExperience;
import kodlamaio.hrms.entities.dtos.CvExperienceForAddAndUpdateDto;

@CrossOrigin()
@RestController
@RequestMapping("/api/candidate/cvs/experiences")

public class CandidateCvExperiencesController {
	
	private CandidateCvExperienceService candidateCvExperienceService;

	@Autowired
	public CandidateCvExperiencesController(CandidateCvExperienceService candidateCvExperienceService) {
		super();
		this.candidateCvExperienceService = candidateCvExperienceService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody CvExperienceForAddAndUpdateDto cvExperiencesForAddDto) {
		final Result result = candidateCvExperienceService.addExperiences(cvExperiencesForAddDto);

		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<CandidateCvExperience>>> getAll() {
		final DataResult<List<CandidateCvExperience>> result = candidateCvExperienceService.getAll();

		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getall/byeducationsiddesc")
	public ResponseEntity<DataResult<List<CandidateCvExperience>>> getByCandidateCvIdOrderByQuitDateDesc(@RequestParam int id) {
		final DataResult<List<CandidateCvExperience>> result = candidateCvExperienceService.getByCandidateCvIdOrderByQuitDateDesc(id);

		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getall/byeducationsidasc")
	public ResponseEntity<DataResult<List<CandidateCvExperience>>> getByCandidateCvIdOrderByQuitDateAsc(@RequestParam int id) {
		final DataResult<List<CandidateCvExperience>> result = candidateCvExperienceService.getByCandidateCvIdOrderByQuitDateAsc(id);

		return ResponseEntity.ok(result);
	}
	
}
