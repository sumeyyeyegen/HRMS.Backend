package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateCvExperienceService;
import kodlamaio.hrms.business.abstracts.CandidateCvLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;
import kodlamaio.hrms.entities.dtos.CvLanguagesForAddAndUpdateDto;

@CrossOrigin()
@RestController
@RequestMapping("/api/candidate/cvs/languages")
public class CandidateCvLanguagesController {
	
	private CandidateCvLanguageService candidateCvLanguageService;

	@Autowired
	public CandidateCvLanguagesController(CandidateCvLanguageService candidateCvLanguageService) {
		super();
		this.candidateCvLanguageService = candidateCvLanguageService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<CandidateCvLanguage>>> getAll(){
		final DataResult<List<CandidateCvLanguage>> result = candidateCvLanguageService.getAll();
		
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody CvLanguagesForAddAndUpdateDto cvLanguagesForAddDto){
		final Result result = candidateCvLanguageService.addLanguages(cvLanguagesForAddDto);
		
		return ResponseEntity.ok(result);
	}
}
