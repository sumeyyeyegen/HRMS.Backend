package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto"
			+ "(e.companyName , job.title , j.openPositions, j.releaseDate, j.applicationDeadline) "
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.job job WHERE j.isActive = true")
	List<JobAdvertisementForListDto> getByIsActiveTrue();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto"
			+ "(e.companyName , job.title , j.openPositions, j.releaseDate, j.applicationDeadline) "
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.job job WHERE j.isActive = true ORDER BY j.releaseDate DESC")
	List<JobAdvertisementForListDto> getByIsActiveTrueOrderByReleaseDateDesc();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto"
			+ "(e.companyName , job.title , j.openPositions, j.releaseDate, j.applicationDeadline) "
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.job job WHERE j.isActive = true ORDER BY j.releaseDate ASC")
	List<JobAdvertisementForListDto> getByIsActiveTrueOrderByReleaseDateAsc();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto"
			+ "(e.companyName , job.title , j.openPositions, j.releaseDate, j.applicationDeadline) "
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.job job WHERE j.isActive = true ORDER BY j.applicationDeadline ASC")
	List<JobAdvertisementForListDto> getByIsActiveTrueOrderByApplicationDeadlineAsc();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto"
			+ "(e.companyName , job.title , j.openPositions, j.releaseDate, j.applicationDeadline) "
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.job job WHERE j.isActive = true ORDER BY j.applicationDeadline DESC")
	List<JobAdvertisementForListDto> getByIsActiveTrueOrderByApplicationDeadlineDesc();
	
}