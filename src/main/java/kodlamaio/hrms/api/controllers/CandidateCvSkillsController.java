package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateCvSkillService;

@RestController
@RequestMapping("/api/candidate/cvs/skills")
public class CandidateCvSkillsController {
	
	private CandidateCvSkillService candidateCvSkillService;

	public CandidateCvSkillsController(CandidateCvSkillService candidateCvSkillService) {
		super();
		this.candidateCvSkillService = candidateCvSkillService;
	}
	
	
}
