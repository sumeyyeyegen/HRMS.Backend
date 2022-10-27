package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name="candidate_cvs")
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class CandidateCv {
	
	@Id
	@NotNull
	@Column(name="candidate_cv_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Length(max=255)
	@Column(name="cover_letter")
	private String coverLetter;
	
	@NotNull
	@Column(name="created_at")
	private LocalDateTime createdAt = LocalDateTime.now();
	 
	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvEducation> educations;
	
	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvExperience> experiences;

	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvLanguage> languages;
	
	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvSkill> skills;
	
	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvImage> images;
	
	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvWebsite> websites;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;

}
