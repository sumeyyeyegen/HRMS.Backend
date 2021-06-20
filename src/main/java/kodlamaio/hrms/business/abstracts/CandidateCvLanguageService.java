package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;
import kodlamaio.hrms.entities.dtos.CvLanguagesForAddDto;

public interface CandidateCvLanguageService extends BaseService<CandidateCvLanguage, Integer> {
	public Result addLanguages(CvLanguagesForAddDto caCvLanguagesForAddDto);
	public DataResult<List<CandidateCvLanguage>> getByCandidateCvId(int candidateCvId);
}
