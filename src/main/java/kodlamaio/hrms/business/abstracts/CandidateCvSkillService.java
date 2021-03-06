package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvSkill;
import kodlamaio.hrms.entities.dtos.CvDto;
import kodlamaio.hrms.entities.dtos.CvSkillForAddAndUpdateDto;

public interface CandidateCvSkillService extends BaseService<CandidateCvSkill, Integer> {
	public Result addSkills(CvSkillForAddAndUpdateDto cvSkillForAddDto);
	public DataResult<List<CandidateCvSkill>> getByCandidateCvId(int candidateCvId);
	public Result updateSkill(CvSkillForAddAndUpdateDto svSkillDto);
}
