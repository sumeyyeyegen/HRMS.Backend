package kodlamaio.hrms.core.utilities.helpers.adapters;

import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.helpers.abstracts.MernisService;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements MernisService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		KPSPublicSoap client = new KPSPublicSoapProxy();
		
		boolean result=false;
		
		try {
			result = client.TCKimlikNoDogrula(
					Long.parseLong(candidate.getIdentityNumber() ), 
					candidate.getFirstName().toUpperCase(new Locale("tr")),
					candidate.getLastName().toUpperCase(new Locale("tr")),
					Integer.parseInt(candidate.getBirthYear()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
