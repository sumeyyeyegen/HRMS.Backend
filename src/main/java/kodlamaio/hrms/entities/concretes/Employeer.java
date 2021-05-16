package kodlamaio.hrms.entities.concretes;

import lombok.Data;

@Data

public class Employeer extends User {
	private int id;
	private String company_name;
	private String web_site;
	private boolean admin_verify;
}
