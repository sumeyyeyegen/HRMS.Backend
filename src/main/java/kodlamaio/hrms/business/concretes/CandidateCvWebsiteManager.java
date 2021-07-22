package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvWebsiteService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvWebsiteDao;
import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;
import kodlamaio.hrms.entities.concretes.CandidateCvWebsite;
import kodlamaio.hrms.entities.dtos.CvWebSitesForAddAndUpdateDto;

@Service
public class CandidateCvWebsiteManager implements CandidateCvWebsiteService {
	
	private CandidateCvWebsiteDao candidateCvWebsiteDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public CandidateCvWebsiteManager(CandidateCvWebsiteDao candidateCvWebsiteDao,DtoConverterService dtoConverterService) {
		super();
		this.candidateCvWebsiteDao = candidateCvWebsiteDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result addWebSites(CvWebSitesForAddAndUpdateDto cvWebSitesForAddDto) {
		candidateCvWebsiteDao.save((CandidateCvWebsite) dtoConverterService.dtoClassConverter(cvWebSitesForAddDto, CandidateCvWebsite.class));
		return new SuccessResult("Ekleme işlemi başarıyla gerçekleştirildi.");
	}

	@Override
	public Result delete(int webSiteId) {
		CandidateCvWebsite candidateCvWebsite = candidateCvWebsiteDao.getOne(webSiteId);
		candidateCvWebsiteDao.delete(candidateCvWebsite);
		return new SuccessResult("Silme işlemi gerçekleştirildi");
	}

	@Override
	public DataResult<List<CandidateCvWebsite>> getAll() {
		List<CandidateCvWebsite> webSites =  candidateCvWebsiteDao.findAll();
		return new SuccessDataResult<List<CandidateCvWebsite>>(webSites,"Veriler başarılı bir şekilde getirildi.");
	}

	@Override
	public DataResult<CandidateCvWebsite> getById(Integer id) {
		return null;
	}

	@Override
	public Result update(CandidateCvWebsite candidateCvWebsite) {
		return null;
	}

	@Override
	public Result add(CandidateCvWebsite entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<CandidateCvWebsite>> getByCandidateCvId(int candidateCvId) {
		List<CandidateCvWebsite> websites = candidateCvWebsiteDao.getByCandidateCv_Id(candidateCvId);
		return new SuccessDataResult<List<CandidateCvWebsite>>(websites, "Veriler başarılı bir şekilde getirildi.");
	}


	
	
}
