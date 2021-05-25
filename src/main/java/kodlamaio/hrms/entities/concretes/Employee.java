package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employees")

public class Employee extends User {	
	@Column(name="first_name",nullable = false,length = 35)
	private String first_name;
	
	@Column(name="last_name",nullable = false,length = 35)
	private String last_name;
	
	@OneToOne
	@JoinColumn(name="id")
	private User fk_employees_users;
}
