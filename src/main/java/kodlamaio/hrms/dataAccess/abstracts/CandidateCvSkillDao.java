package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateCvSkill;

public interface CandidateCvSkillDao extends JpaRepository<CandidateCvSkill, Integer>{

}
