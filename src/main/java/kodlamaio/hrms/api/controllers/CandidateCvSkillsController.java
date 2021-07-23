package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateCvSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;
import kodlamaio.hrms.entities.concretes.CandidateCvSkill;
import kodlamaio.hrms.entities.dtos.CvLanguagesForAddAndUpdateDto;
import kodlamaio.hrms.entities.dtos.CvSkillForAddAndUpdateDto;

@CrossOrigin()
@RestController
@RequestMapping("/api/candidate/cvs/skills")
public class CandidateCvSkillsController {
	
	private CandidateCvSkillService candidateCvSkillService;

	public CandidateCvSkillsController(CandidateCvSkillService candidateCvSkillService) {
		super();
		this.candidateCvSkillService = candidateCvSkillService;
	}
	
	@GetMapping("/getbycandidatecvid")
	public ResponseEntity<DataResult<List<CandidateCvSkill>>> getByCandidateCvId(@RequestParam int candidateCvId){
		final DataResult<List<CandidateCvSkill>> result = candidateCvSkillService.getByCandidateCvId(candidateCvId);
		 
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody CvSkillForAddAndUpdateDto cvSkillForAddDto){
		final Result result = candidateCvSkillService.addSkills(cvSkillForAddDto);
		
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Result> update(@RequestBody CvSkillForAddAndUpdateDto cvSkillForAddDto){
		final Result result = candidateCvSkillService.updateSkill(cvSkillForAddDto);
		
		return ResponseEntity.ok(result);
	}
}
