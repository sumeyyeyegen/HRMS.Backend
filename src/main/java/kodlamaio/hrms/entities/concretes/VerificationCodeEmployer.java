package kodlamaio.hrms.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="verification_code_employers")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)

public class VerificationCodeEmployer extends VerificationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="verification_code_employer_id")
	private int id;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
}
