package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateCvImage;

public interface CandidateCvImageDao extends JpaRepository<CandidateCvImage, Integer> {

}
