package kodlamaio.hrms.entities.concretes;

import lombok.Data;

@Data

public class JobSeeker extends User {
	private int id;
	private String first_name;
	private String last_name;
	private String nationality_number;
	private int birth_year;
}
