package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvWebsite;
import kodlamaio.hrms.entities.dtos.CvWebSitesForAddDto;

public interface CandidateCvWebsiteService extends BaseService<CandidateCvWebsite, Integer>{
	Result addWebSites(CvWebSitesForAddDto cvWebSitesForAddDto);
}
