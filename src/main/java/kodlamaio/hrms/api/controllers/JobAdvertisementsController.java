package kodlamaio.hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementsDto;

@CrossOrigin()
@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}	
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody JobAdvertisementsDto jobAdvertisementsDto) {
		final Result result = jobAdvertisementService.addJobAdvertisements(jobAdvertisementsDto);

		if (!result.isSuccess())
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody final JobAdvertisement jobAdvertisement) {
		final Result result = jobAdvertisementService.update(jobAdvertisement);

		if (!result.isSuccess())
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/update/disablebyid")
	public ResponseEntity<Result> disableById(final int id) {
		final Result result = jobAdvertisementService.disableById(id);

		if (!result.isSuccess())
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
 
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<JobAdvertisement>>> getAll() {
		final DataResult<List<JobAdvertisement>> result = jobAdvertisementService.getAll();

		if (!result.isSuccess())
			return new ResponseEntity<DataResult<List<JobAdvertisement>>>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getByIsActiveTrue")
	public ResponseEntity<DataResult<List<JobAdvertisement>>> getByIsActiveTrue(){
		final DataResult<List<JobAdvertisement>> result = jobAdvertisementService.getByIsActiveTrue();
		if (!result.isSuccess())
			return new ResponseEntity<DataResult<List<JobAdvertisement>>>(result, HttpStatus.BAD_REQUEST);
		
		return ResponseEntity.ok(result) ;
	}
	
	@GetMapping("/getByIsActiveTrueOrderByReleaseDateAsc")
	public ResponseEntity<DataResult<List<JobAdvertisement>>> getByIsActiveTrueOrderByReleaseDateAsc(){
		final DataResult<List<JobAdvertisement>> result = jobAdvertisementService.getByIsActiveTrueOrderByReleaseDateAsc();
		if(!result.isSuccess())
			return new ResponseEntity<DataResult<List<JobAdvertisement>>>(result,HttpStatus.BAD_REQUEST);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getByIsActiveTrueOrderByReleaseDateDesc")
	public ResponseEntity<DataResult<List<JobAdvertisementForListDto>>> getByIsActiveTrueOrderByReleaseDateDesc(){
		final DataResult<List<JobAdvertisementForListDto>> result = jobAdvertisementService.getByIsActiveTrueOrderByReleaseDateDesc();
		if(!result.isSuccess())
			return new ResponseEntity<DataResult<List<JobAdvertisementForListDto>>>(result, HttpStatus.BAD_REQUEST);
		return ResponseEntity.ok(result) ;
	}
	
	@GetMapping("/getByIsActiveTrueOrderByApplicationDeadlineAsc")
	public ResponseEntity<DataResult<List<JobAdvertisementForListDto>>> getByIsActiveTrueOrderByApplicationDeadlineAsc(){
		final DataResult<List<JobAdvertisementForListDto>> result = jobAdvertisementService.getByIsActiveTrueOrderByApplicationDeadlineAsc();
		
		if(!result.isSuccess())
			return new ResponseEntity<DataResult<List<JobAdvertisementForListDto>>>(result,HttpStatus.BAD_REQUEST);
	
		return ResponseEntity.ok(result) ;
	}
	
	@GetMapping("/getByIsActiveTrueOrderByApplicationDeadlineDesc")
	public ResponseEntity<DataResult<List<JobAdvertisementForListDto>>> getByIsActiveTrueOrderByApplicationDeadlineDesc(){
		final DataResult<List<JobAdvertisementForListDto>> result = jobAdvertisementService.getByIsActiveTrueOrderByApplicationDeadlineDesc();
		
		if(!result.isSuccess())
			return new ResponseEntity<DataResult<List<JobAdvertisementForListDto>>>(result,HttpStatus.BAD_REQUEST);
		
		return ResponseEntity.ok(result) ;
	}
	
	@GetMapping("/getByIsActiveTrueAndEmployerId")
	public ResponseEntity<DataResult<List<JobAdvertisementForListDto>>> getByIsActiveTrueAndEmployer_IdForList(@Valid @RequestParam final int id){
		
		final DataResult<List<JobAdvertisementForListDto>> result = jobAdvertisementService.getByIsActiveTrueAndEmployer_IdForList(id);
		
		if(!result.isSuccess())
			return new ResponseEntity<DataResult<List<JobAdvertisementForListDto>>>(result, HttpStatus.BAD_REQUEST);
		
		return ResponseEntity.ok(result);
		
	}	
	
	
	
	
	
	
	
	
	
}
