package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
//	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto"
//			+ "(e.companyName , job.title , j.openPositions, j.releaseDate, j.applicationDeadline) "
//			+ "From JobAdvertisement j JOIN j.employer e JOIN j.job job WHERE j.isActive = true")
	List<JobAdvertisement> getByIsActiveTrue();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto"
			+ "(e.companyName , job.title , j.openPositions, j.releaseDate, j.applicationDeadline) "
			+ "From JobAdvertisement j JOIN j.employer e JOIN j.job job")
	List<JobAdvertisementForListDto> getAll();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto"
			+ "(e.companyName , job.title , j.openPositions, j.releaseDate, j.applicationDeadline) "
			+ "From JobAdvertisement j JOIN j.employer e JOIN j.job job WHERE j.isActive = true ORDER BY j.releaseDate DESC")
	List<JobAdvertisementForListDto> getByIsActiveTrueOrderByReleaseDateDesc();
	
//	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto"
//			+ "(e.companyName , job.title , j.openPositions, j.releaseDate, j.applicationDeadline) "
//			+ "From JobAdvertisement j JOIN j.employer e JOIN j.job job WHERE j.isActive = true ORDER BY j.releaseDate ASC")
	List<JobAdvertisement> getByIsActiveTrueOrderByReleaseDateAsc();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto"
			+ "(e.companyName , job.title , j.openPositions, j.releaseDate, j.applicationDeadline) "
			+ "From JobAdvertisement j JOIN j.employer e JOIN j.job job WHERE j.isActive = true ORDER BY j.applicationDeadline ASC")
	List<JobAdvertisementForListDto> getByIsActiveTrueOrderByApplicationDeadlineAsc();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto"
			+ "(e.companyName , job.title , j.openPositions, j.releaseDate, j.applicationDeadline) "
			+ "From JobAdvertisement j JOIN j.employer e JOIN j.job job WHERE j.isActive = true ORDER BY j.applicationDeadline DESC")
	List<JobAdvertisementForListDto> getByIsActiveTrueOrderByApplicationDeadlineDesc();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementForListDto"
			+ "(e.companyName , job.title , j.openPositions, j.releaseDate, j.applicationDeadline) "
			+ "From JobAdvertisement j JOIN j.employer e JOIN j.job job WHERE j.isActive = true AND e.id=:employerId")
	List<JobAdvertisementForListDto> getByIsActiveTrueAndEmployer_IdForList(@Param("employerId") int id);
	
	JobAdvertisement getById(int id);
	
}