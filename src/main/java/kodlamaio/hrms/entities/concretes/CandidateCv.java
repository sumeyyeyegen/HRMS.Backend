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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidate_cvs")
@NoArgsConstructor
@AllArgsConstructor

public class CandidateCv {
	
	@NotNull
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@NotNull
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@NotNull
	@Column(name="cover_letter", length = 255 )
	private String coverLetter;
	
	@NotNull
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDateTime createdAt = LocalDateTime.now();
	
	@JsonIgnore()
	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvEducation> educations;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvExperience> experiences;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvLanguage> languages;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvSkill> skills;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvImage> images;

}
