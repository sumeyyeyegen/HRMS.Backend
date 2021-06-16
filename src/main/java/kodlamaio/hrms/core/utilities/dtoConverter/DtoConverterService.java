package kodlamaio.hrms.core.utilities.dtoConverter;
import java.util.List;

public interface DtoConverterService {

	public <S, T> List<T> dtoConverter(List<S> s, Class<T> targetClass);

	public <T> Object dtoClassConverter(Object source, Class<T> baseClass);

}
