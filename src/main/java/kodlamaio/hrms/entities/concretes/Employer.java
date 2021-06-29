package kodlamaio.hrms.entities.concretes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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
@EqualsAndHashCode(callSuper=false)

public class Employer extends User {
	
	@Id
	@NotNull
	@Column(name="id")
	@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
	@JsonIgnore
	private int id;
	
	@NotNull
	@Length(max = 255)
	@Column(name="company_name")
	private String companyName;
	
	@NotNull
	@Length(max = 50)
	@Column(name="web_site")
	private String webSite;
	
	@NotNull
	@Length(max = 12)
	@Column(name="phone_number")
	private String phoneNumber;
	
	@NotNull
	@JsonIgnore()
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
	
	@NotNull
	@JsonIgnore()
	@OneToOne(mappedBy = "employer")
	private VerificationCodeEmployer verificationCodeEmployer;
		
}
