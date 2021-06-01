package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}	
	
	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrue(){
		return this.jobAdvertisementService.getByIsActiveTrue();
	}
	
	@GetMapping("/getByIsActiveTrueOrderByReleaseDateAsc")
	public DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByReleaseDateAsc(){
		return this.jobAdvertisementService.getByIsActiveTrueOrderByReleaseDateAsc();
	}
	
	@GetMapping("/getByIsActiveTrueOrderByReleaseDateDesc")
	public DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByReleaseDateDesc(){
		return this.jobAdvertisementService.getByIsActiveTrueOrderByReleaseDateDesc();
	}
	
	@GetMapping("/getByIsActiveTrueOrderByApplicationDeadlineAsc")
	public DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByApplicationDeadlineAsc(){
		return this.jobAdvertisementService.getByIsActiveTrueOrderByApplicationDeadlineAsc();
	}
	
	@GetMapping("/getByIsActiveTrueOrderByApplicationDeadlineDesc")
	public DataResult<List<JobAdvertisementForListDto>> getByIsActiveTrueOrderByApplicationDeadlineDesc(){
		return this.jobAdvertisementService.getByIsActiveTrueOrderByApplicationDeadlineDesc();
	}
}
