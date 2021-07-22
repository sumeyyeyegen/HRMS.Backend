package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvWebsite;
import kodlamaio.hrms.entities.dtos.CvWebSitesForAddAndUpdateDto;

public interface CandidateCvWebsiteService extends BaseService<CandidateCvWebsite, Integer>{
	Result addWebSites(CvWebSitesForAddAndUpdateDto cvWebSitesForAddDto);
	DataResult<List<CandidateCvWebsite>> getByCandidateCvId(int candidateCvId);
}
