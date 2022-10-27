package kodlamaio.hrms.entities.concretes;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.entities.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="candidates")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)

public class Candidate extends User {	

	@PrimaryKeyJoinColumn(name="candidate_id")
	@Setter(value = AccessLevel.NONE)
	private int id;
	
	@NotNull
	@Length(max = 20)
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@Length(max = 20)
	@Column(name="last_name")
	private String lastName;
	
	@UniqueElements
	@Length
	@NotNull
	@Column(name="identity_number")
	private String identityNumber;
	
	@NotNull
	@Column(name="birth_year")
	private String birthYear;	
	
	@NotNull
	@JsonIgnore()
	@OneToOne(mappedBy = "candidate",cascade = CascadeType.ALL)
	private VerificationCodeCandidate verificationCodeCandidate;
	
	@NotNull
	@JsonIgnore()
	@OneToOne(mappedBy = "candidate",cascade = CascadeType.ALL)
	private CandidateCv candidateCv;

	
}
