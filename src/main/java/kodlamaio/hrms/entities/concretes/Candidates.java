package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="candidates")

public class Candidates {
	
	@Column(name="id",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	@Column(name="first_name",nullable = false,length = 20)
	private String first_name;
	
	@Column(name="last_name",nullable = false,length = 20)
	private String last_name;
	
	@Column(name="nationality_number", nullable = false ,length = 11, unique = true)
	private String nationality_number;
	
	@Column(name="birth_year",nullable = false)
	private int birth_year;
}
