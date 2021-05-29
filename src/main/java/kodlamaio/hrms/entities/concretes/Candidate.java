package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidates")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
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
