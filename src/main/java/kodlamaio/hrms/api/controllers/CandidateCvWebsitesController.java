package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateCvWebsiteService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvWebsite;
import kodlamaio.hrms.entities.dtos.CvWebSitesForAddAndUpdateDto;

@CrossOrigin()
@RestController
@RequestMapping("/api/candidate/cvs/websites")
public class CandidateCvWebsitesController {
	private CandidateCvWebsiteService candidateCvWebsiteService;

	@Autowired
	public CandidateCvWebsitesController(CandidateCvWebsiteService candidateCvWebsiteService) {
		super();
		this.candidateCvWebsiteService = candidateCvWebsiteService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody CvWebSitesForAddAndUpdateDto cvWebSitesForAddDto) {
		final Result result = candidateCvWebsiteService.addWebSites(cvWebSitesForAddDto);

		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Result> update(@RequestBody CvWebSitesForAddAndUpdateDto cvWebSitesForAddDto) {
		final Result result = candidateCvWebsiteService.updateWebSite(cvWebSitesForAddDto);

		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(int webSiteId) {
		final Result result = candidateCvWebsiteService.delete(webSiteId);

		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<CandidateCvWebsite>>> getAll(@RequestBody CandidateCvWebsite candidateCvWebsite){
		final DataResult<List<CandidateCvWebsite>> webSites = candidateCvWebsiteService.getAll();
		
		return ResponseEntity.ok(webSites);
	}
}
