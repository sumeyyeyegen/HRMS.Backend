package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvSkill;
import kodlamaio.hrms.entities.dtos.CvSkillForAddDto;

public interface CandidateCvSkillService extends BaseService<CandidateCvSkill, Integer> {
	public Result addSkills(CvSkillForAddDto cvSkillForAddDto);
}
