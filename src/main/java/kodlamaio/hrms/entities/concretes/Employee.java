package kodlamaio.hrms.entities.concretes;

import lombok.Data;

@Data

public class Employee extends User {
	private int id;
	private String firt_name;
	private String last_name;
}
