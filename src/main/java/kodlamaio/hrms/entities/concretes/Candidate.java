package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="candidates")

public class Candidate extends User {	
	@Column(name="first_name",nullable = false,length = 20)
	private String first_name;
	
	@Column(name="last_name",nullable = false,length = 20)
	private String last_name;
	
	@Column(name="identity_number", nullable = false ,length = 11, unique = true)
	private String identity_number;
	
	@Column(name="birth_year",nullable = false)
	private int birth_year;
}
