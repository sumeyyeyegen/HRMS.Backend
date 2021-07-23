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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateCvImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.concretes.CandidateCvExperience;
import kodlamaio.hrms.entities.concretes.CandidateCvImage;
import kodlamaio.hrms.entities.dtos.CvExperienceForAddAndUpdateDto;
import kodlamaio.hrms.entities.dtos.CvImageForAddAndUpdateDto;

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
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<CandidateCvImage>>> getAll() {
		DataResult<List<CandidateCvImage>> result = candidateCvImageService.getAll();

		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CvImageForAddAndUpdateDto cvImageForAddDto) {
		final Result result = candidateCvImageService.addImage(cvImageForAddDto);

		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody CvImageForAddAndUpdateDto cvImageForAddDto) {
		final Result result = candidateCvImageService.updateImage(cvImageForAddDto);

		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/addwithmulti")
	public ResponseEntity<Result> add(@RequestBody MultipartFile file,@RequestParam int candidateCvId) {
		
//		CandidateCvImage candidateCvImage = new CandidateCvImage();
		CvImageForAddAndUpdateDto imageDto = new CvImageForAddAndUpdateDto();
		CandidateCv candidateCv = new CandidateCv();
		candidateCv.setId(candidateCvId);
		imageDto.setCandidateCvId(candidateCvId);
		final Result result = candidateCvImageService.add(imageDto,file);

		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/delete")
	public Result delete(int id) {
		candidateCvImageService.delete(id);
		return new SuccessResult("Fotoğraf başarılı bir şekilde silindi.");
	}
	
}
