package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateCvImageService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.concretes.CandidateCvImage;
import kodlamaio.hrms.entities.dtos.CvExperiencesForAddDto;

@CrossOrigin()
@RestController
@RequestMapping("/api/candidate/cvs/images")

public class CandidateCvImagesController {
	
	private CandidateCvImageService candidateCvImageService;

	@Autowired
	public CandidateCvImagesController(CandidateCvImageService candidateCvImageService) {
		super();
		this.candidateCvImageService = candidateCvImageService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CandidateCvImage candidateCvImage) {
		final Result result = candidateCvImageService.add(candidateCvImage);

		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/addwithmulti")
	public ResponseEntity<Result> add(@RequestBody MultipartFile file,@RequestParam int candidateCvId) {
		
		CandidateCvImage candidateCvImage = new CandidateCvImage();
		CandidateCv candidateCv = new CandidateCv();
		candidateCv.setId(candidateCvId);
		candidateCvImage.setCandidateCv(candidateCv);
		final Result result = candidateCvImageService.add(candidateCvImage,file);

		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam CandidateCvImage candidateCvImage) {
		candidateCvImageService.delete(candidateCvImage);
		return new SuccessResult("Fotoğraf başarılı bir şekilde silindi.");
	}
	
}
