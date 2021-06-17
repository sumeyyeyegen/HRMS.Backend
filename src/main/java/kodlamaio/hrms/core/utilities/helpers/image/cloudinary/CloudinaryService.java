package kodlamaio.hrms.core.utilities.helpers.image.cloudinary;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.helpers.image.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import lombok.var;

@Service
public class CloudinaryService implements ImageService{	
	
	private Cloudinary cloudinary;
	
	private Map<String, String> valuesMap = new HashMap<>();
	
	@Autowired
	public CloudinaryService() {
		valuesMap.put("cloud_name", "cloudhrms");
		valuesMap.put("api_key", "237649574722439");
		valuesMap.put("api_secret", "Dn5kvbonhA4EFLUJK58NNiz0vYc");
		
		cloudinary = new Cloudinary(valuesMap);
	}
	@Override
	public DataResult<Map> upload(MultipartFile multipartFile) throws IOException {
		
		Map<String,Object> options = new HashMap<String, Object>();
		var allowedFormats = Arrays.asList("png","jpg","jpeg");
		
		options.put("allowed_formats", allowedFormats);
		File file = convert(multipartFile);
		Map result = null;
		try {
			result = cloudinary.uploader().upload(file, options);
		} catch (Exception e) {
			return new ErrorDataResult<Map>(e.getMessage());
		}
		file.delete();
		return new SuccessDataResult<Map>(result);
	}
	@Override
	public DataResult<Map> delete(String id) throws IOException {
		Map<String,Boolean> options = new HashMap<>();
		options.put("invalidate", true);
		Map result = cloudinary.uploader().destroy(id, options);
		return new SuccessDataResult<>(result);
	}
	
	@SuppressWarnings("unused")
	private File convert(final MultipartFile multipartFile) throws IOException {
		File file= new File(multipartFile.getOriginalFilename());
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(multipartFile.getBytes());
		fo.close();
		return file;
		
	}

	@Override
	public DataResult<?> save(MultipartFile file) {
		try{
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(uploadResult);
        } catch (IOException e){
            e.printStackTrace();
        }
        return new ErrorDataResult<Map>();
	}

}
