package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="employers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","JobAdvertisement"})
public class Employer extends User {
	@Column(name="company_name",nullable = false,length = 255)
	private String company_name;
	
	@Column(name="web_site",nullable = false,length = 50)
	private String web_site;
	
	@Column(name="phone_number",nullable = false,length = 12)
	private String phone_number;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisement;
}
