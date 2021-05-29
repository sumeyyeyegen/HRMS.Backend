package kodlamaio.hrms.core.utilities.helpers.adapters;

import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.helpers.abstracts.MernisService;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements MernisService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		
		boolean result=false;
		
		try {
			result = client.TCKimlikNoDogrula(
					Long.parseLong(candidate.getIdentity_number()), 
					candidate.getFirst_name().toUpperCase(new Locale("tr")),
					candidate.getLast_name().toUpperCase(new Locale("tr")),
					candidate.getBirth_year());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
