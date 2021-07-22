package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateCvImageService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.helpers.image.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvImageDao;
import kodlamaio.hrms.entities.concretes.CandidateCvImage;
import kodlamaio.hrms.entities.dtos.CvImageForAddDto;

@Service
public class CandidateCvImageManager implements CandidateCvImageService{
	
	private CandidateCvImageDao candidateCvImageDao;
	private ImageService imageService;
	private DtoConverterService dtoConverter;

	@Autowired
	public CandidateCvImageManager(CandidateCvImageDao candidateCvImageDao, ImageService imageService,DtoConverterService dtoConverter) {
		super();
		this.candidateCvImageDao = candidateCvImageDao;
		this.imageService = imageService;
		this.dtoConverter=dtoConverter;
	}

	@Override
	public Result addImage(CvImageForAddDto imageDto) {
		candidateCvImageDao.save((CandidateCvImage) dtoConverter.dtoClassConverter(imageDto, CandidateCvImage.class));
		return new SuccessResult("Fotoğraf başarılı bir şekilde eklendi.") ;
	}

	@Override
	public Result add(CvImageForAddDto imageDto, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
		String url =result.get("url");
		imageDto.setImageUrl(url);
		return addImage(imageDto);
	}

	@Override
	public Result delete(CandidateCvImage image) {
		candidateCvImageDao.delete(image);
		return new SuccessResult("Fotoğraf başarılı bir şekilde silindi.");
	}

	@Override
	public DataResult<List<CandidateCvImage>> getAll() {
		List<CandidateCvImage> images = candidateCvImageDao.findAll();
		return new SuccessDataResult<List<CandidateCvImage>>(images, "Bütün fotoğraflar getirildi.") ;
	}

	@Override
	public DataResult<CandidateCvImage> getById(Integer id) {
		CandidateCvImage result = candidateCvImageDao.getOne(id);
		return new SuccessDataResult<CandidateCvImage>(result, id+ "id'li image getirildi") ;
	}

	@Override
	public Result update(CandidateCvImage cvImage) {
		return null;
	}

	@Override
	public DataResult<CandidateCvImage> getByCandidateCvId(int candidateCvId) {
		CandidateCvImage image = candidateCvImageDao.getByCandidateCv_Id(candidateCvId);
		return new SuccessDataResult<CandidateCvImage>(image, "Fotoğraf başarılı bir şekilde getirildi.");
	}

	@Override
	public Result add(CandidateCvImage entity) {
		// TODO Auto-generated method stub
		return null;
	}


}
