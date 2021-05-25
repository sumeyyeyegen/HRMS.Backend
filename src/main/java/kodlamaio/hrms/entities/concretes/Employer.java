package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="employers")

public class Employer extends User {
	@Column(name="company_name",nullable = false,length = 255)
	private String company_name;
	
	@Column(name="web_site",nullable = false,length = 50)
	private String web_site;
	
	@Column(name="phone_number",nullable = false,length = 12)
	private String phone_number;
}
