package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvSkillService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvSkillDao;
import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;
import kodlamaio.hrms.entities.concretes.CandidateCvSkill;
import kodlamaio.hrms.entities.dtos.CvSkillForAddAndUpdateDto;

@Service
public class CandidateCvSkillManager implements CandidateCvSkillService {
	
	private CandidateCvSkillDao candidateCvSkillDao;
	private DtoConverterService dtoConverterService;
	
	
	@Autowired
	public CandidateCvSkillManager(CandidateCvSkillDao candidateCvSkillDao, DtoConverterService dtoConverterService) {
		this.candidateCvSkillDao = candidateCvSkillDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(CandidateCvSkill entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int id) {
		CandidateCvSkill cvSkill = candidateCvSkillDao.getOne(id);
		candidateCvSkillDao.delete(cvSkill);
		return new SuccessResult("Silme işlemi gerçekleştirildi");
	}

	@Override
	public DataResult<List<CandidateCvSkill>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<CandidateCvSkill> getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(CandidateCvSkill entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result addSkills(CvSkillForAddAndUpdateDto cvSkillForAddDto) {
		candidateCvSkillDao.save((CandidateCvSkill) dtoConverterService.dtoClassConverter(cvSkillForAddDto, CandidateCvSkill.class));
		return new SuccessResult("Ekleme işlemi başarıyla gerçekleştirildi");
	}

	@Override
	public DataResult<List<CandidateCvSkill>> getByCandidateCvId(int candidateCvId) {
		List<CandidateCvSkill> skills = candidateCvSkillDao.getByCandidateCv_Id(candidateCvId);
		return new SuccessDataResult<List<CandidateCvSkill>>(skills, "Veriler başarılı bir şekilde getirildi");
	}

	@Override
	public Result updateSkill(CvSkillForAddAndUpdateDto cvSkillDto) {
		CandidateCvSkill cvSkill = candidateCvSkillDao.getOne(cvSkillDto.getId());
		cvSkill.getCandidateCv().setId(cvSkillDto.getCandidateCvId());
		cvSkill.setName(cvSkillDto.getName());
		return new SuccessResult("Güncelleme işlemi başarılı");
	}

}
