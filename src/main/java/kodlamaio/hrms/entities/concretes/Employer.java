package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employers")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","JobAdvertisement"})
@EqualsAndHashCode(callSuper=false)
public class Employer extends User {
	@Id
	@Column(name="id")
	@JsonIgnore
	@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
	private int id;
	
	@Column(name="company_name",nullable = false,length = 255)
	private String companyName;
	
	@Column(name="web_site",nullable = false,length = 50)
	private String webSite;
	
	@Column(name="phone_number",nullable = false,length = 12)
	private String phoneNumber;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
	
}
