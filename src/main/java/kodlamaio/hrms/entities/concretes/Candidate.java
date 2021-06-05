package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidates")
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(callSuper=false)
public class Candidate extends User {	
	@Id
	@Column(name="id")
	@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
	private int id;
	
	@Column(name="first_name",nullable = false,length = 20)
	private String firstName;
	
	@Column(name="last_name",nullable = false,length = 20)
	private String lastName;
	
	@Column(name="identity_number", nullable = false ,length = 11, unique = true)
	private String identityNumber;
	
	@Column(name="birth_year",nullable = false)
	private int birthYear;	

	
}
