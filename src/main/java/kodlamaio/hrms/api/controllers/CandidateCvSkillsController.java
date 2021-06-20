package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateCvSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;
import kodlamaio.hrms.entities.concretes.CandidateCvSkill;
import kodlamaio.hrms.entities.dtos.CvLanguagesForAddDto;
import kodlamaio.hrms.entities.dtos.CvSkillForAddDto;

@RestController
@RequestMapping("/api/candidate/cvs/skills")
public class CandidateCvSkillsController {
	
	private CandidateCvSkillService candidateCvSkillService;

	public CandidateCvSkillsController(CandidateCvSkillService candidateCvSkillService) {
		super();
		this.candidateCvSkillService = candidateCvSkillService;
	}
	
	@GetMapping("/getbycandidatecvid")
	public ResponseEntity<DataResult<List<CandidateCvSkill>>> getByCandidateCvId(int candidateCvId){
		final DataResult<List<CandidateCvSkill>> result = candidateCvSkillService.getByCandidateCvId(candidateCvId);
		 
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/addskill")
	public ResponseEntity<Result> addSkills(@RequestBody CvSkillForAddDto cvSkillForAddDto){
		final Result result = candidateCvSkillService.addSkills(cvSkillForAddDto);
		
		return ResponseEntity.ok(result);
	}
}
