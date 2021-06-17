package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateCvImageService;
import kodlamaio.hrms.core.utilities.helpers.image.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvImageDao;
import kodlamaio.hrms.entities.concretes.CandidateCvImage;

@Service
public class CandidateCvImageManager implements CandidateCvImageService{
	
	private CandidateCvImageDao candidateCvImageDao;
	private ImageService imageService;

	@Autowired
	public CandidateCvImageManager(CandidateCvImageDao candidateCvImageDao, ImageService imageService) {
		super();
		this.candidateCvImageDao = candidateCvImageDao;
		this.imageService = imageService;
	}

	@Override
	public Result add(CandidateCvImage candidateCvImage) {
		candidateCvImageDao.save(candidateCvImage);
		return new SuccessResult("Fotoğraf başarılı bir şekilde eklendi.") ;
	}

	@Override
	public Result add(CandidateCvImage candidateCvImage, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
		String url =result.get("url");
		candidateCvImage.setImageUrl(url);
		return add(candidateCvImage);
	}

	@Override
	public Result delete(CandidateCvImage entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<CandidateCvImage>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<CandidateCvImage> getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(CandidateCvImage entity) {
		// TODO Auto-generated method stub
		return null;
	}


}
