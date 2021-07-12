package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidate_cv_experiences")
@NoArgsConstructor
@AllArgsConstructor

public class CandidateCvExperience {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@Length(max=50)
	@Column(name="work_place_name")
	private String workPlaceName;
	
	@NotNull
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="quit_date")
	private LocalDate quitDate;
	
	@NotNull
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDateTime createAt = LocalDateTime.now();
	
	@NotNull
	@ManyToOne(targetEntity = CandidateCv.class, fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
	@JoinColumn(name="candidate_cv_id")
	private CandidateCv candidateCv;
	
	@NotNull
	@ManyToOne(targetEntity = Job.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="job_id")
	private Job job;
}
