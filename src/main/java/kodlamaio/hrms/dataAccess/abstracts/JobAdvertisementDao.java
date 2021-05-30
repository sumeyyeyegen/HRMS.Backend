package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	@Query("SELECT new hrms.entities.concretes.JobAdvertisement(emp.companyName,j.title,ja.openPositions,ja.releaseDate,ja.applicationDeadline) FROM JobAdvertisement ja JOIN ja.employer e JOIN ja.job j WHERE ja.isActive=:isActive AND e.companyName=:companyName")                             
	List<JobAdvertisement> getByIsActiveForList(@Param("isActive") boolean isActive);
}
