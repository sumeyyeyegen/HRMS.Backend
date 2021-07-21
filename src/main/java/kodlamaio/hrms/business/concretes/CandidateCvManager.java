package kodlamaio.hrms.business.concretes;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvDao;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.dtos.CvDto;
@Service
public class CandidateCvManager implements CandidateCvService{
	
	private CandidateCvDao candidateCvDao;
	private DtoConverterService dtoConverter;
	
	@Autowired
	public CandidateCvManager(CandidateCvDao candidateCvDao,DtoConverterService dtoConverter) {
		this.candidateCvDao=candidateCvDao;
		this.dtoConverter=dtoConverter;
	}

	@Override
	public DataResult<List<CandidateCv>> getAllByCandidateId(int candidateId) {
		List<CandidateCv> cvs = candidateCvDao.getAllByCandidate_Id(candidateId);
		return new SuccessDataResult<List<CandidateCv>>(cvs, "Veriler başarılı bir şekilde getirildi.") ;
	}

	@Override
	public Result add(CandidateCv candidateCv) {
		candidateCvDao.save(candidateCv);
		return new Result(true, "Cv başarılı bir şekilde eklendi.");
	}

	@Override
	public Result delete(CandidateCv candidateCv) {
		candidateCvDao.delete(candidateCv);
		return new SuccessResult("Cv silindi");
	}

	@Override
	public DataResult<List<CandidateCv>> getAll() {
		List<CandidateCv> result = candidateCvDao.findAll();
		return new SuccessDataResult<List<CandidateCv>>(result, "Veriler başarılı bir şekilde getirildi");
	}

	@Override
	public DataResult<CandidateCv> getById(Integer id) {
		final Optional<CandidateCv> candidateCv = candidateCvDao.findById(id);
		
		return new SuccessDataResult<CandidateCv>(candidateCv.get(), "Veri başarılı bir şekilde getirildi.");
	}

	@Override
	public Result updateCv(CvDto cvDto) {
		CandidateCv lastCv = candidateCvDao.getOne(cvDto.getId());
		lastCv.setCoverLetter(cvDto.getCoverLetter());
		lastCv.setCreatedAt(cvDto.getCreatedAt());
		candidateCvDao.save(lastCv);
		return new SuccessResult("Veriler başarılı bir şekilde güncellendi.") ;
	}

	@Override
	public Result update(CandidateCv entity) {
		return null;
	}

	@Override
	public Result addCv(CvDto cvDto) {
		candidateCvDao.save((CandidateCv) dtoConverter.dtoClassConverter(cvDto, CandidateCv.class));
		return new SuccessResult("Cv başarılı bir şekilde eklendi.");
	}

}
